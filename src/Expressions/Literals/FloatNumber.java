package Expressions.Literals;

// Classe para representar um número real
import Expressions.Expression;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
public class FloatNumber extends Expression
{
    private final float value;
    // Construtor que recebe o valor do número real
    public FloatNumber(float value)
    {
        this.value = value; // Armazena o valor do número real
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString()
    {
        return Float.toString(value);
    }
}