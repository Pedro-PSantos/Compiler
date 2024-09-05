package Expressions.Loops;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
public class RangeExpression extends Expression {
    private Expression start;
    private Expression stop;
    private Expression step;
    // Construtor que recebe as expressões à esquerda e à direita
    public RangeExpression(Expression start, Expression stop, Expression step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }
    // Método para obter o resultado da expressão
    public Expression getStart() {
        return start;
    }
    // Método para obter o resultado da expressão
    public Expression getStop() {
        return stop;
    }
    // Método para obter o resultado da expressão
    public Expression getStep() {
        return step;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        return "Range{" +
                "start=" + start +
                ", stop=" + stop +
                ", step=" + step +
                '}';
    }
}
