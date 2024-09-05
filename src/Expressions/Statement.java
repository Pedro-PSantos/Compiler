package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import java.util.ArrayList;
import java.util.List;
// Classe para representar uma instrução
public class Statement extends Expression{
    public List<Expression> expressions;
    public Statement(){
        this.expressions = new ArrayList<>();
    }
    // Método para adicionar uma expressão ao programa
    public void addExpression(Expression expr){
        expressions.add(expr);
    }
}
