package Expressions.Literals;
// Classe para representar um número inteiro
import Expressions.Expression;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
public class IntegerNumber extends Expression {
    private final int value;
    // Construtor que recebe o valor do número inteiro
    public IntegerNumber(int value)
    {
        this.value = value;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        // Retorna o valor do número inteiro no formato String
        return Integer.toString(value);
    }
}
