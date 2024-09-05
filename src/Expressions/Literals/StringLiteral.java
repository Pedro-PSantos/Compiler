package Expressions.Literals;
// Classe para representar um número inteiro
import Expressions.Expression;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
public class StringLiteral extends Expression
{
    private final String value;
    // Construtor que recebe uma String
    public StringLiteral(String value)
    {
        this.value = value;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString()
    {
        return value; // Retorna a String
    }
}