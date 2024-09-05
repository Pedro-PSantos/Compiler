package Expressions;

public class UnaryExpression extends Expression {
    private final String operator;
    private final Expression expr;
    // Construtor que recebe o operador e a expressão
    public UnaryExpression(String operator, Expression expr) {
        this.operator = operator;
        this.expr = expr;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        return operator + expr.toString();
    }

    public Expression getOperand() {
        return expr;
    }

    public String getOperator() {
        return operator;
    }
}
