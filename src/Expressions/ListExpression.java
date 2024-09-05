package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import java.util.List;
// Classe para representar uma lista de expressões
public class ListExpression extends Expression {
    private List<Expression> expressions;
    // Construtor que recebe uma lista de expressões
    public ListExpression(List<Expression> elements) {
        this.expressions = elements;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        StringBuilder elems = new StringBuilder();
        for (Expression elem : expressions) {
            elems.append(elem.toString()).append(", ");
        }
        // Retorna a lista de expressões no formato "[expr1, expr2,...]"
        return "[" + elems.substring(0, elems.length() - 2) + "]";
    }

    public List<Expression> getElements() {
        return expressions;
    }


}
