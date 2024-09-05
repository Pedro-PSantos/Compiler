package Application;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Antlr.ExpressionLexer;
import Antlr.ExpressionParser;
import AntlrVisitor.AntlrToProgram;
import Expressions.Expression;
import Expressions.ExpressionErrorListener;
import Expressions.ExpressionProcessor;
import Expressions.Program;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
// Classe para representar a aplicação do programa
public class ExpressionApplication {
    // Método principal
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Inserir caminho do ficheiro que se pretende utilizar");
            System.exit(1);
        }
        // Obter o ficheiro a ser analisado
        try {
            // Input stream
            CharStream in = CharStreams.fromFileName(args[0]);

            // Lexer
            ExpressionLexer lexer = new ExpressionLexer(in);

            // Scan stream for tokens
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Parser
            ExpressionParser parser = new ExpressionParser(tokens);
            // Syntax + error handling
            parser.removeErrorListeners();
            parser.addErrorListener(new ExpressionErrorListener());

            // Obter a Parse Tree desde o último "prog"
            ParseTree AST = parser.prog();

            if (ExpressionErrorListener.hasError){
                // TODO report the error
            }
            else {

                // Visitor para converter a parse tree em numa Expression
                AntlrToProgram progVisitor = new AntlrToProgram();
                Program prog = progVisitor.visit(AST);

                // verificar se há erros semânticos
                if (progVisitor.semanticErrors.isEmpty()) {
                    ExpressionProcessor exp = new ExpressionProcessor(prog.getExpressions());


                // verificar se há erros semânticos
                } else {
                    for (String err: progVisitor.semanticErrors) {
                        System.out.println(err);
                    }
                }
            }
        }
        // Tratar erros de IO
        catch (IOException ex){
            System.err.println("Erro a ler o ficheiro: " + ex.getMessage());
            System.exit(1);
        }
    }
}
