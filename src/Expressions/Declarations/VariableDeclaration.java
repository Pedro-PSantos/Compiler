
package Expressions.Declarations;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
import Expressions.Literals.Variable;

import java.util.ArrayList;
import java.util.List;
// Classe para representar uma declaração de variável
public class VariableDeclaration extends Expression {
    public List<Variable> variables;
    // Construtor que recebe uma lista de variáveis
    public VariableDeclaration(List<Variable> variableList) {
        variables = new ArrayList<>();
        variables.addAll(variableList);

        for (int i = 0; i < Expression.variables.size(); i++) {
            for (Variable variable : variables) {
                if (Expression.variables.get(i).name.equals(variable.name)) {
                    Expression.variables.get(i).value = variable.value;
                    break;
                }
            }
        }
    }

    // Método para obter o resultado da expressão
    private String getVariables(String expression) {
        for (int i = 0; i < variables.size(); i++) {
            expression += variables.get(i).name + " = " + variables.get(i).value;

            // Se não for a última, separa por vírgulas
            if(i != variables.size() - 1)
                expression += ", ";
        }
        // Retorna a expressão
        return expression;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        //System.out.println("num de vars: " + variables.size());
        if (!variables.isEmpty()) {
            String expression = "";

            // Se tiver um tipo, busca-o
            if (!(variables.get(0).type == null || variables.get(0).type.isEmpty() || variables.get(0).type.isBlank())){
                expression = variables.get(0).type + " ";
            }

            // Inicializa as variáveis
            expression = getVariables(expression);
            // Retorna a expressão
            return expression;
        }
        // Retorna que não há variáveis
        return "Não há variáveis para mostrar";
    }

    public List<Variable> getVariables() {
        return variables;
    }
}
