package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;
// Classe para tratar erros sintáticos
public class ExpressionErrorListener extends BaseErrorListener {
    public static boolean hasError = false;
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        hasError = true;
        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.err.println("Syntax Error!");
        System.err.println("Token " + "\"" + ((Token)offendingSymbol).getText() + "\"" + " (linha: " + line + ", " + "coluna: " + (charPositionInLine + 1) + "): " + msg);
        System.err.println("Stack de Regras: " + stack);

        // Para debug
        // verificar o tipo de erro e o contexto
        if (e instanceof InputMismatchException) {
            System.err.println("Contexto: " + e.getCtx().getText());
            System.err.println("Classe: " + e.getCtx().getClass().getSimpleName());
        }
    }
}
