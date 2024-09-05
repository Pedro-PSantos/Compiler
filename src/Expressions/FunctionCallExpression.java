package Expressions;

// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import java.util.List;

// Classe para representar uma chamada de função
public class FunctionCallExpression extends Expression {
    private String functionName;
    private List<Expression> arguments;
    // Construtor que recebe o nome da função e uma lista de argumentos
    public FunctionCallExpression(String functionName, List<Expression> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        StringBuilder args = new StringBuilder();
        for (Expression arg : arguments) {
            args.append(arg.toString()).append(", ");
        }
        // Retorna a chamada de função no formato "função(arg1, arg2, ...)"
        return functionName + "(" + args.substring(0, args.length() - 2) + ")";
    }

    public Expression getArgument(int index) {
        return arguments.get(index);
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public String getFunctionName() {
        return functionName;
    }
}
