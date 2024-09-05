package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
public class ReturnExpression extends Expression {
    private final Expression expression;
    // Construtor que recebe uma expressão
    public ReturnExpression(Expression expression) {
        this.expression = expression;
    }
    // Método para obter o resultado da expressão
    public Expression getExpression() {
        return expression;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        return "return " + expression.toString();
    }
}
