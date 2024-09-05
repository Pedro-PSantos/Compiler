package Expressions.Loops;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
import Expressions.Literals.Variable;
import Expressions.Statement;

import java.util.List;
// Classe para representar um laço for
public class ForLoop extends Expression {
    private final Variable variable;
    private final RangeExpression range;
    private final List<Statement> body;
    private final Expression iterator;

    // Construtor que recebe o nome da variável, o iterador, o intervalo e o corpo do laço
    public ForLoop(Variable variable, Expression iterator, RangeExpression range, List<Statement> body) {
        this.variable = variable; // Armazena o nome da variável
        this.iterator = iterator; // Armazena o iterador
        this.range = range; // Armazena o intervalo
        this.body = body; // Armazena o corpo do laço
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        StringBuilder bodyStr = new StringBuilder();
        for (Statement statement : body) {
            bodyStr.append(statement.toString()).append("\n");
        }
        // Retorna o laço for
        return "for " + variable.toString() + " in " + range.toString() + ":\n" + bodyStr.toString();
    }

    public Variable getVariable() {
        return variable;
    }

    public RangeExpression getRange() {
        return range;
    }

    public List<Statement> getBody() {
        return body;
    }

    // Método para obter o resultado da expressão

    public Expression getIterator() {
        return iterator;
    }


    // Método para obter o resultado da expressão

    public Expression[] getStatements() {
        return null;
    }
}
