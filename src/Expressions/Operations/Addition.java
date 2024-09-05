package Expressions.Operations;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
// Classe para representar uma operação de soma
public class Addition extends Expression {
    public Expression left;
    public Expression right;
    // Construtor que recebe as expressões à esquerda e à direita
    public Addition(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }
}
