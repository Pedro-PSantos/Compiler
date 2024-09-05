package TAC;

import Expressions.*;
import Expressions.Literals.*;
import Expressions.Operations.*;
import Expressions.Loops.*;
import Expressions.Conditionals.*;
import Expressions.Declarations.*;

import java.util.ArrayList;
import java.util.List;

public class TACGenerator {
    private int tempVarCount = 0; // Contador para variáveis temporárias

    // Método público para gerar as instruções TAC a partir de um nó da AST
    public List<TACInstruction> generate(Expression node) {
        List<TACInstruction> instructions = new ArrayList<>(); // Lista para armazenar as instruções TAC
        generate(node, instructions); // Chama o método privado de geração de instruções recursivamente
        return instructions; // Retorna a lista de instruções TAC geradas
    }

    // Método privado para gerar as instruções TAC de forma recursiva
    private String generate(Expression node, List<TACInstruction> instructions) {
        if (node instanceof IntegerNumber) {
            return ((IntegerNumber) node).toString();
        } else if (node instanceof FloatNumber) {
            return ((FloatNumber) node).toString();
        } else if (node instanceof StringLiteral) {
            return ((StringLiteral) node).toString();
        } else if (node instanceof Variable) {
            return ((Variable) node).toString();
        } else if (node instanceof BinaryExpression) {
            // Para expressões binárias (ex: a + b)
            BinaryExpression binOpNode = (BinaryExpression) node;
            //TODO Arranjar primeiro BinaryExpression
            String left = generate(binOpNode.getLeft(), instructions);
            String right = generate(binOpNode.getRight(), instructions);
            String tempVar = "t" + tempVarCount++;
            instructions.add(new TACInstruction(binOpNode.getOperator(), left, right, tempVar));
            return tempVar;
        } else if (node instanceof UnaryExpression) {
            // Para expressões unárias (ex: -a)
            UnaryExpression unOpNode = (UnaryExpression) node;
            String operand = generate(unOpNode.getOperand(), instructions);
            String tempVar = "t" + tempVarCount++;
            instructions.add(new TACInstruction(unOpNode.getOperator(), operand, "", tempVar));
            return tempVar;
        } else if (node instanceof ListExpression) {
            // Para expressões de lista (ex: [1, 2, 3])
            ListExpression listExpr = (ListExpression) node;
            String tempVar = "t" + tempVarCount++;
            List<String> elements = new ArrayList<>();
            for (Expression expr : listExpr.getElements()) {
                elements.add(generate(expr, instructions));
            }
            instructions.add(new TACInstruction("LIST", String.join(", ", elements), "", tempVar));
            return tempVar;
        } else if (node instanceof FunctionCallExpression) {
            // Para chamadas de função (ex: func(a, b))
            FunctionCallExpression funcCall = (FunctionCallExpression) node;
            List<String> args = new ArrayList<>();
            for (Expression arg : funcCall.getArguments()) {
                args.add(generate(arg, instructions));
            }
            String tempVar = "t" + tempVarCount++;
            instructions.add(new TACInstruction("CALL", funcCall.getFunctionName(), String.join(", ", args), tempVar));
            return tempVar;
        } else if (node instanceof VariableDeclaration) {
            // Para declarações de variável (ex: int a = 10)
            VariableDeclaration varDecl = (VariableDeclaration) node;
            for (Variable var : varDecl.getVariables()) {
                String value = generate(var.getValueExpression(), instructions);
                instructions.add(new TACInstruction("DECLARE", var.getType(), value, var.getName()));
            }

            //TODO Arranjar primeiro ifExpr
        } else if (node instanceof IfExpression) {
                // Para expressões condicionais (if-elif-else)
                IfExpression ifExpr = (IfExpression) node;
                String condition = generate(ifExpr.getCondition(), instructions);
                String labelTrue = "L" + tempVarCount++;
                String labelEnd = "L" + tempVarCount++;
                instructions.add(new TACInstruction("IF", condition, "", labelTrue));
                for (Expression stmt : ifExpr.getStatements()) {
                    generate(stmt, instructions);
                }
                instructions.add(new TACInstruction("GOTO", "", "", labelEnd));
                instructions.add(new TACInstruction("LABEL", "", "", labelTrue));
                for (ElifExpression elifExpr : ifExpr.getElifExpressions()) {
                    condition = generate(elifExpr.getCondition(), instructions);
                    String labelElifTrue = "L" + tempVarCount++;
                    instructions.add(new TACInstruction("IF", condition, "", labelElifTrue));
                    for (Expression stmt : elifExpr.getStatements()) {
                        generate(stmt, instructions);
                    }
                    instructions.add(new TACInstruction("GOTO", "", "", labelEnd));
                    instructions.add(new TACInstruction("LABEL", "", "", labelElifTrue));
                }
                if (ifExpr.getElseExpression() != null) {
                    for (Expression stmt : ifExpr.getElseExpression().getStatements()) {
                        generate(stmt, instructions);
                    }
                }
                instructions.add(new TACInstruction("LABEL", "", "", labelEnd));
        }else if (node instanceof WhileLoop) {
            // Para loops 'while'
            WhileLoop whileLoop = (WhileLoop) node;
            String labelStart = "L" + tempVarCount++;
            String labelEnd = "L" + tempVarCount++;
            instructions.add(new TACInstruction("LABEL", "", "", labelStart));
            String condition = generate(whileLoop.getCondition(), instructions);
            instructions.add(new TACInstruction("IF", condition, "", labelEnd));
            for (Expression stmt : whileLoop.getStatements()) {
                generate(stmt, instructions);
            }
            instructions.add(new TACInstruction("GOTO", "", "", labelStart));
            instructions.add(new TACInstruction("LABEL", "", "", labelEnd));

            //TODO Arranjar primeiro ForLoop
        } else if (node instanceof ForLoop) {
            // Para loops 'for'
            ForLoop forLoop = (ForLoop) node;
            String labelStart = "L" + tempVarCount++;
            String labelEnd = "L" + tempVarCount++;
            String iterator = forLoop.getIterator().getName();
            String start = generate(forLoop.getRange().getStart(), instructions);
            String stop = generate(forLoop.getRange().getStop(), instructions);
            String step = forLoop.getRange().getStep() != null ? generate(forLoop.getRange().getStep(), instructions) : "1";
            instructions.add(new TACInstruction("DECLARE", "int", start, iterator));
            instructions.add(new TACInstruction("LABEL", "", "", labelStart));
            instructions.add(new TACInstruction("IF", iterator + " >= " + stop, "", labelEnd));
            for (Expression stmt : forLoop.getStatements()) {
                generate(stmt, instructions);
            }
            instructions.add(new TACInstruction("ADD", iterator, step, iterator));
            instructions.add(new TACInstruction("GOTO", "", "", labelStart));
            instructions.add(new TACInstruction("LABEL", "", "", labelEnd));

            //TODO Arranjar primeiro ReturnExpression
        } else if (node instanceof ReturnExpression) {
            // Para expressões de retorno
            ReturnExpression returnExpr = (ReturnExpression) node;
            String value = generate(returnExpr.getExpression(), instructions);
            instructions.add(new TACInstruction("RETURN", value, "", ""));
        }

        return null; // Retorna null por padrão
    }
}
