package Expressions.Literals;
// Classe para representar um número inteiro
import Expressions.Expression;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos

// Classe para representar uma variável
public class Variable extends Expression {
    public String type;
    public String name;
    public String value;

    // Construtor que recebe o valor do número inteiro
    public Variable(String type, String name, String value){
        this.name = name; 
        this.type = type; 
        this.value = value;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        if(type == null || type.isBlank() || type.isEmpty()){
            //System.out.println("value =" + value);
            if(value.matches("[-+]?[0-9]*\\.?[0-9]+"))
                type = "float";
            else
                type = "String";
            return  name + " = " + value;
        }

        return type + " " + name + " = " + value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Expression getValueExpression() {
        if(value.matches("[-+]?[0-9]*\\.?[0-9]+"))
            return new FloatNumber(Float.parseFloat(value));
        else
            return new StringLiteral(value);
    }
}
