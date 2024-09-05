package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos

// Classe para representar um parâmetro de uma função
public class Parameter extends Expression {
    private String type;
    private String name;
    // Construtor que recebe o tipo e o nome do parâmetro
    public Parameter(String type, String name) {
        this.type = type;
        this.name = name;
    }
    // Método para obter o resultado da expressão
    public String getType() {
        return type;
    }
    // Método para obter o resultado da expressão
    public String getName() {
        return name;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}