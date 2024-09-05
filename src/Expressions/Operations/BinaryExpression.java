package Expressions.Operations;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Expression;
import Expressions.Literals.Variable;
// Classe para representar uma operação de subtração
public class BinaryExpression extends Expression {
    public Expression left;
    public Expression right;
    public String operator;
    // Construtor que recebe as expressões à esquerda e à direita
    public BinaryExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    // Método para obter o resultado da expressão
    @Override
    public String toString() {
        //System.out.println("Im in BinaryExpression.ToString");
        return getBinaryComparison(left, operator, right);
    }
    private String AvaliarTipo(String value){
        // Verificar se é uma variável

        /*if (value.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
            return "variable";
        }*/
        // Verificar se é um número inteiro
        if (value.matches("[-+]?[0-9]+")) {
            return "int";
        }
        // Verificar se é um número real
        if (value.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            return "float";
        }
        // Retorna o tipo da variável
        return "variable";
    }
    // Método para obter o resultado da expressão
    private String getBinaryComparison(Expression left, String operator, Expression right){
        // Buscar os tipos de variável
        //ex x + y ou 2 + 3

       // System.out.println("Im in getBinaryComparison");
        //System.out.println("Is empty -> " + left.toString().isEmpty() + " and is blank -> " + left.toString().isBlank());
      //  System.out.println("I have left = " + left + " operator = " + operator + " and right = " + right + " with the values " + left.toString() + " and " + right.toString());

        //System.out.println("Im in getBinaryComparison");
        //System.out.println("Is empty -> " + left.toString().isEmpty() + " and is blank -> " + left.toString().isBlank());
        //System.out.println("I have left = " + left + " operator = " + operator + " and right = " + right + " with the values " + left.toString() + " and " + right.toString());

        String esq = AvaliarTipo(left.toString());
        Variable esquerda = null;
        /*if(esq.equals("string"))
            esquerda = (Variable) left;*/
        Variable direita = null;
        String dir = AvaliarTipo(right.toString());
        //System.out.println("Left is type " + esq + " and right is type " + dir);
        // Se forem os 2 variáveis
        if(esq.equals("variable")){

            //System.out.println("Left is variable");
            esquerda = (Variable) left;
           // System.out.println("Left is variable with name " + esquerda.name + " and value " + esquerda.value + " of type " + esquerda.type);

            //System.out.println("Left is variable");
            esquerda = (Variable) left;
            //System.out.println("Left is variable with name " + esquerda.name + " and value " + esquerda.value + " of type " + esquerda.type);



            // Se forem os 2 variáveis 
            if(dir.equals("variable")){

               // System.out.println("Right is variable");

                //System.out.println("Right is variable");

                // Se forem os 2 variáveis
                direita = (Variable) right;
                switch (esquerda.type){
                    case "int":
                        // Se ambos forem Inteiros
                        if(direita.type.equals("int")){
                            switch (operator){
                                case "+":
                                    return Integer.toString(Integer.parseInt(esquerda.value) + Integer.parseInt(direita.value));
                                case "-":
                                    return Integer.toString(Integer.parseInt(esquerda.value) - Integer.parseInt(direita.value));
                                case "*":
                                    return Integer.toString(Integer.parseInt(esquerda.value) * Integer.parseInt(direita.value));
                                case "/":
                                    return Integer.toString(Integer.parseInt(esquerda.value) / Integer.parseInt(direita.value));
                            }
                        }// Se um for inteiro e o outro float
                        else if(direita.type.equals("float")){
                            switch (operator) {
                                case "+":
                                    return Float.toString(Float.parseFloat(esquerda.value) + Float.parseFloat(direita.value));
                                case "-":
                                    return Float.toString(Float.parseFloat(esquerda.value) - Float.parseFloat(direita.value));
                                case "*":
                                    return Float.toString(Float.parseFloat(esquerda.value) * Float.parseFloat(direita.value));
                                case "/":
                                    return Float.toString(Float.parseFloat(esquerda.value) / Float.parseFloat(direita.value));
                            }
                        }
                        // Direita é string
                        return esquerda.value + " " + operator + " " + direita.value;
                    // Se a esquerda for float
                    case "float":
                        if(direita.type.equals("int") || direita.type.equals("float")){
                            switch (operator) {
                                case "+":
                                    return Float.toString(Float.parseFloat(esquerda.value) + Float.parseFloat(direita.value));
                                case "-":
                                    return Float.toString(Float.parseFloat(esquerda.value) - Float.parseFloat(direita.value));
                                case "*":
                                    return Float.toString(Float.parseFloat(esquerda.value) * Float.parseFloat(direita.value));
                                case "/":
                                    return Float.toString(Float.parseFloat(esquerda.value) / Float.parseFloat(direita.value));
                            }
                        }
                        // Direita é string
                        return esquerda.value + " " + operator + " " + direita.value;
                }
            } // Direita não é variável
            else{
                switch (esquerda.type){
                    case "int":
                        // Se ambos forem Inteiros
                        if(dir.equals("int")){
                            switch (operator){
                                case "+":
                                    return Integer.toString(Integer.parseInt(esquerda.value) + Integer.parseInt(right.toString()));
                                case "-":
                                    return Integer.toString(Integer.parseInt(esquerda.value) - Integer.parseInt(right.toString()));
                                case "*":
                                    return Integer.toString(Integer.parseInt(esquerda.value) * Integer.parseInt(right.toString()));
                                case "/":
                                    return Integer.toString(Integer.parseInt(esquerda.value) / Integer.parseInt(right.toString()));
                            }
                        }// Se um for inteiro e o outro float
                        else if(dir.equals("float")){
                            switch (operator) {
                                case "+":
                                    return Float.toString(Float.parseFloat(esquerda.value) + Float.parseFloat(right.toString()));
                                case "-":
                                    return Float.toString(Float.parseFloat(esquerda.value) - Float.parseFloat(right.toString()));
                                case "*":
                                    return Float.toString(Float.parseFloat(esquerda.value) * Float.parseFloat(right.toString()));
                                case "/":
                                    return Float.toString(Float.parseFloat(esquerda.value) / Float.parseFloat(right.toString()));
                            }
                        }
                        return esquerda.value + " " + operator + " " + right.toString();
                    // Se a esquerda for float
                    case "float":
                        if(dir.equals("int") || dir.equals("float")){
                            switch (operator) {
                                case "+":
                                    return Float.toString(Float.parseFloat(esquerda.value) + Float.parseFloat(right.toString()));
                                case "-":
                                    return Float.toString(Float.parseFloat(esquerda.value) - Float.parseFloat(right.toString()));
                                case "*":
                                    return Float.toString(Float.parseFloat(esquerda.value) * Float.parseFloat(right.toString()));
                                case "/":
                                    return Float.toString(Float.parseFloat(esquerda.value) / Float.parseFloat(right.toString()));
                            }
                        }
                        // Direita é string
                        return esquerda.value + " " + operator + " " + right.toString();
                }
            }
        } // Esquerda não é variável
        else if(dir.equals("variable")){
            direita = (Variable) right;
            switch (direita.type){
                case "int":
                    // Se ambos forem Inteiros
                    if(esq.equals("int")){
                        switch (operator){
                            case "+":
                                return Integer.toString(Integer.parseInt(left.toString()) + Integer.parseInt(direita.value));
                            case "-":
                                return Integer.toString(Integer.parseInt(left.toString()) - Integer.parseInt(direita.value));
                            case "*":
                                return Integer.toString(Integer.parseInt(left.toString()) * Integer.parseInt(direita.value));
                            case "/":
                                return Integer.toString(Integer.parseInt(left.toString()) / Integer.parseInt(direita.value));
                        }
                    }// Se um for inteiro e o outro float
                    else if(esq.equals("float")){
                        switch (operator){
                            case "+":
                                return Float.toString(Float.parseFloat(left.toString()) + Float.parseFloat(direita.value));
                            case "-":
                                return Float.toString(Float.parseFloat(left.toString()) - Float.parseFloat(direita.value));
                            case "*":
                                return Float.toString(Float.parseFloat(left.toString()) * Float.parseFloat(direita.value));
                            case "/":
                                return Float.toString(Float.parseFloat(left.toString()) / Float.parseFloat(direita.value));
                        }
                    }
                    // Direita é string
                    return left.toString() + " " + operator + " " + direita.value;
                // Direita é float
                case "float":
                    if(esq.equals("int") || esq.equals("float")){
                        switch (operator){
                            case "+":
                                return Float.toString(Float.parseFloat(left.toString()) + Float.parseFloat(direita.value));
                            case "-":
                                return Float.toString(Float.parseFloat(left.toString()) - Float.parseFloat(direita.value));
                            case "*":
                                return Float.toString(Float.parseFloat(left.toString()) * Float.parseFloat(direita.value));
                            case "/":
                                return Float.toString(Float.parseFloat(left.toString()) / Float.parseFloat(direita.value));
                        }
                    }
                    // Direita é string
                    return left.toString() + " " + operator +"  " + direita.value;
            }
        }else{
            // Nenhum é variável
            switch (esq){
                case "int":
                    // Se ambos forem Inteiros
                    if(esq.equals(dir)){
                        switch (operator){
                            case "+":
                                return Integer.toString(Integer.parseInt(left.toString()) + Integer.parseInt(right.toString()));
                            case "-":
                                return Integer.toString(Integer.parseInt(left.toString()) - Integer.parseInt(right.toString()));
                            case "*":
                                return Integer.toString(Integer.parseInt(left.toString()) * Integer.parseInt(right.toString()));
                            case "/":
                                return Integer.toString(Integer.parseInt(left.toString()) / Integer.parseInt(right.toString()));
                        }
                    }// Se um for inteiro e o outro float
                    else if(dir.equals("float")){
                        switch (operator){
                            case "+":
                                return Float.toString(Float.parseFloat(left.toString()) + Float.parseFloat(right.toString()));
                            case "-":
                                return Float.toString(Float.parseFloat(left.toString()) - Float.parseFloat(right.toString()));
                            case "*":
                                return Float.toString(Float.parseFloat(left.toString()) * Float.parseFloat(right.toString()));
                            case "/":
                                return Float.toString(Float.parseFloat(left.toString()) / Float.parseFloat(right.toString()));
                        }
                    }
                    // Direita é string
                    return left + " " + operator + " " + right;
                // Direita é string
                case "float":
                    if(esq.equals(dir) || dir.equals("int")){
                        switch (operator){
                            case "+":
                                return Float.toString(Float.parseFloat(left.toString()) + Float.parseFloat(right.toString()));
                            case "-":
                                return Float.toString(Float.parseFloat(left.toString()) - Float.parseFloat(right.toString()));
                            case "*":
                                return Float.toString(Float.parseFloat(left.toString()) * Float.parseFloat(right.toString()));
                            case "/":
                                return Float.toString(Float.parseFloat(left.toString()) / Float.parseFloat(right.toString()));
                        }
                    }
                    // Direita é string
                    return left.toString() + " " + operator + " " + right.toString();
            }
        }
        // Não é nenhum dos casos acima
        return left.toString() + " " + operator + " " + right.toString();
    }

    public Expression getLeft() {
        return left;
    }
    public Expression getRight() {
        return right;
    }
    public String getOperator() {
        return operator;
    }
}
