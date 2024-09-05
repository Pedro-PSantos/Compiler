package Expressions.Loops;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Conditionals.ElifExpression;
import Expressions.Conditionals.ElseExpression;
import Expressions.Expression;
import Expressions.Statement;

import java.util.List;
// Classe para representar um laço while
public class WhileLoop extends Expression{
    private Expression condition;
    private List<Statement> statements;
    // Construtor que recebe a condição e os comandos do laço
    public WhileLoop(Expression condition, List<Statement> statements){
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
