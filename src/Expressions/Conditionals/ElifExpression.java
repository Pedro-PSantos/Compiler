package Expressions.Conditionals;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
import Expressions.Statement;

import java.util.List;
// Classe para representar uma condição elif
public class ElifExpression extends Expression {
    private Expression condition;
    private List<Statement> statements;
    public ElifExpression(Expression condition, List<Statement> statements){
        this.condition = condition;
        this.statements = statements;
    }
    // Método para obter o resultado da expressão
    public Expression getCondition() {
        return condition;
    }
    // Método para obter o resultado da expressão
    public List<Statement> getStatements() {
        return statements;
    }



}


