package Expressions.Conditionals;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Conditionals.ElifExpression;
import Expressions.Expression;
import Expressions.Statement;

import java.util.List;
// Classe para representar uma condição if
public class IfExpression extends Expression {
    private Expression condition;
    private List<Statement> statements;
    private List<ElifExpression> elifExpressions;
    private ElseExpression elseExpression;
    // Método para obter o resultado da expressão
    public IfExpression(Expression condition, List<Statement> statements, List<ElifExpression> elifExpressions, ElseExpression elseExpression){
        this.condition = condition;
        this.statements = statements;
        this.elifExpressions = elifExpressions;
        this.elseExpression = elseExpression;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        // TODO overwrite
    

        String str = "if (" + condition.toString() + "):\n";
        for (Statement statement : statements) {
            str += statement.toString() + "\n";
        }
        for (ElifExpression elifExpression : elifExpressions) {
            str += elifExpression.toString() + "\n";
        }
        if (elseExpression!= null) {
            str += elseExpression.toString() + "\n";
        }
        return str;
        // return "";
    }

    public Expression getCondition() {
        return condition;
    }
    public List<Statement> getStatements() {
        return statements;
    }

    public List<ElifExpression> getElifExpressions() {
        return elifExpressions;
    }

    public ElseExpression getElseExpression() {
        return elseExpression;
    }
}
