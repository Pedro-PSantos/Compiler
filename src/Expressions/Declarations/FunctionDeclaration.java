package Expressions.Declarations;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
import Expressions.Parameter;

import java.util.List;
// Classe para representar uma declaração de função
public class FunctionDeclaration extends Expression {
    private String returnType;
    private String functionName;
    private List<Parameter> parameters;
    private List<Expression> body;
    // Construtor que recebe o tipo de retorno, o nome da função, os parâmetros e o corpo da função
    public FunctionDeclaration(String returnType, String functionName, List<Parameter> parameters, List<Expression> body) {
        this.returnType = returnType;
        this.functionName = functionName;
        this.parameters = parameters;
        this.body = body;
    }
    // Método para obter o resultado da expressão
    public String getReturnType() {
        return returnType;
    }
    // Método para obter o resultado da expressão 
    public String getFunctionName() {
        return functionName;
    }
    // Método para obter o resultado da expressão
    public List<Parameter> getParameters() {
        return parameters;
    }
    // Método para obter o resultado da expressão
    public List<Expression> getBody() {
        return body;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        return "FunctionDeclaration{" +
                "returnType='" + returnType + '\'' +
                ", functionName='" + functionName + '\'' +
                ", parameters=" + parameters +
                ", body=" + body +
                '}';
    }
}
