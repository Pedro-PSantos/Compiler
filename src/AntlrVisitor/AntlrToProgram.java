package AntlrVisitor;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Antlr.ExpressionBaseVisitor;
import Antlr.ExpressionParser;
import Expressions.Program;

import java.util.ArrayList;
import java.util.List;
// Classe para converter uma árvore sintática em uma Programa
public class AntlrToProgram extends ExpressionBaseVisitor<Program> {

    // Erros semânticos (Dupla declaração, referência a variável não declarada, etc.)
    public List<String> semanticErrors;
    // Erros sintáticos (int x = 1.5, string = 1, etc)
    @Override
    public Program visitProgram(ExpressionParser.ProgramContext ctx) {
        Program prog = new Program();
        // Lista de erros semânticos
        semanticErrors = new ArrayList<>();
        // Helper visitor para transformar cada subtree numa Expression
        AntlrToExpression expressionVisitor = new AntlrToExpression(semanticErrors);
        // Percorrer cada subtree
        for (int i = 0; i < ctx.getChildCount(); i++){
            // Não verificar o EOF
            if(i != ctx.getChildCount() - 1){
                prog.addExpression(expressionVisitor.visit(ctx.getChild(i)));
            }
        }
        // Retornar o programa
        return prog;
    }
}
