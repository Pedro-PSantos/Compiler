package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Declarations.VariableDeclaration;
import Expressions.Literals.FloatNumber;
import Expressions.Literals.IntegerNumber;
import Expressions.Literals.Variable;
import Expressions.Operations.*;

import java.util.ArrayList;
import java.util.List;

// Classe responsável por processar as expressões
public class ExpressionProcessor {
    public List<Expression> expressionList;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN_BACKGROUND  = "\033[46m";
    public List<Variable> values;

    public ExpressionProcessor(List<Expression> expressions){
        this.expressionList = expressions;
        values = new ArrayList<>();
    }
    // Método para obter os resultados da avaliação das expressões
    public List<String> getEvaluationResults(){
        List<String> evaluations = new ArrayList<>();
        // Percorre a lista de expressões
        for (Expression expression: expressionList) {

                values.add((Variable) expression);

                String input = expression.toString();
                String result = getASTResult(expression);
                evaluations.add(input + " " + ANSI_CYAN_BACKGROUND  + " Avalia para: " + ANSI_RESET + " " + result);
            //}
        }
        // Retorna a lista de resultados
        return evaluations;
    }
    // 
    private String getASTResult(Expression expression){
        if(expression instanceof IntegerNumber){
            IntegerNumber num = (IntegerNumber) expression;
            // Se for um inteiro, devolver valor
            return num.toString();
        }
        else if(expression instanceof FloatNumber){
            FloatNumber num = (FloatNumber) expression;
            // Se for um float, devolver valor
            return  num.toString();
        }
        else if(expression instanceof Variable){
            Variable variableName = (Variable) expression;
            return values.stream().filter(v -> v.name.equals(variableName.name)).findFirst().get().toString();
        }

        else if(expression instanceof Addition){
            Addition exp = (Addition) expression;
            String left = getASTResult(exp.left);
            String right = getASTResult(exp.left);

            // Se a esquerda for int
            if(left.matches("[-+]?[0-9]")){
                int esq = Integer.parseInt(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);

                    return Integer.toString(esq + dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);

                    return Float.toString(esq + dir);
                } // Direita é string
                return left + right;
            }
            // Se a esquerda for float
            else if(left.matches("[-+]?[0-9]*\\.[0-9]+")){
                float esq = Float.parseFloat(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);

                    return Float.toString(esq + dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);

                    return Float.toString(esq + dir);
                } // Direita é string
                return left + right;
            }
            // São as duas strings
            return left + right;
        }
        else if(expression instanceof Subtraction){
            Subtraction exp = (Subtraction) expression;
            String left = getASTResult(exp.left);
            String right = getASTResult(exp.left);

            // Se a esquerda for int
            if(left.matches("[-+]?[0-9]")){
                int esq = Integer.parseInt(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);

                    return Integer.toString(esq - dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);

                    return Float.toString(esq - dir);
                } // Direita é string
                return left + right;
            }
            // Se a esquerda for float
            else if(left.matches("[-+]?[0-9]*\\.[0-9]+")){
                float esq = Float.parseFloat(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);

                    return Float.toString(esq - dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);
                    // retorna a subtração dos dois valores
                    return Float.toString(esq - dir);
                } // Direita é string
                return left + right;
            }
            // São as duas strings
            return left + right;
        }
        else if(expression instanceof Multiplication){
            Multiplication exp = (Multiplication) expression;
            String left = getASTResult(exp.left);
            String right = getASTResult(exp.left);

            // Se a esquerda for int
            if(left.matches("[-+]?[0-9]")){
                int esq = Integer.parseInt(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);
                    // retorna a multiplicação dos dois valores
                    return Integer.toString(esq * dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);

                    return Float.toString(esq * dir);
                } // Direita é string
                return left + right;
            }
            // Se a esquerda for float
            else if(left.matches("[-+]?[0-9]*\\.[0-9]+")){
                float esq = Float.parseFloat(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);
                    // retorna a multiplicação dos dois valores
                    return Float.toString(esq * dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);

                    return Float.toString(esq * dir);
                } // Direita é string
                return left + right;
            }
            // São as duas strings
            return left + right;
        }
        else if(expression instanceof Division){
            Division exp = (Division) expression;
            String left = getASTResult(exp.left);
            String right = getASTResult(exp.left);

            // Se a esquerda for int
            if(left.matches("[-+]?[0-9]")){
                int esq = Integer.parseInt(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);
                    // retorna a divisão dos dois valores
                    return Integer.toString(esq / dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);
                    // retorna a divisão dos dois valores
                    return Float.toString(esq / dir);
                } // Direita é string
                return left + right;
            }
            // Se a esquerda for float
            else if(left.matches("[-+]?[0-9]*\\.[0-9]+")){
                float esq = Float.parseFloat(left);
                // Se a direita for int
                if(right.matches("[-+]?[0-9]")){
                    int dir = Integer.parseInt(right);
                    // retorna a divisão dos dois valores
                    return Float.toString(esq / dir);
                } // Se a direita for float
                else if(right.matches("[-+]?[0-9]*\\.[0-9]+")){
                    float dir = Float.parseFloat(right);
                    // retorna a divisão dos dois valores
                    return Float.toString(esq / dir);
                } // Direita é string
                return left + right;
            }
            // São as duas strings
            return left + right;
        }
        else if(expression instanceof BinaryExpression){
            BinaryExpression exp = (BinaryExpression) expression;
            switch (exp.operator){
                case "+":
                    return new Addition(exp.left, exp.right).toString();
                case "-":
                    return new Subtraction(exp.left, exp.right).toString();
                case "*":
                    return new Multiplication(exp.left, exp.right).toString();
                case "/":
                    return new Division(exp.left, exp.right).toString();
            }
            return new BinaryExpression(exp.left, exp.operator, exp.right).toString();
        }
        else{
            return null;
        }
    }
}
