package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import java.util.ArrayList;
import java.util.List;
// Classe para representar um programa
public class Program extends Expression {

    private final List<Expression> expressions;


    public Program(){
        this.expressions = new ArrayList<>();
    }
    // Método para adicionar uma expressão ao programa
    public void addExpression(Expression  expression){
        expressions.add(expression);
    }
    // Método para obter o resultado da expressão
    public List<Expression> getExpressions() {
        return expressions;
    }
}
