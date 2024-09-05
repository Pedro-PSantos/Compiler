package Expressions.Conditionals;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
import Expressions.Statement;

import java.util.List;
// Classe para representar uma condição elif
public class ElseExpression extends Expression {
    private List<Statement> statements;
    public ElseExpression(List<Statement> statements){
        this.statements = statements;
    }
    
    public List<Statement> getStatements() {
        return statements;
    }
}
