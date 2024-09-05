package TAC;

// Classe para representar uma instrução em código intermediário de três endereços (TAC)
public class TACInstruction {
    // Variáveis para armazenar o operador, os argumentos e o resultado da instrução TAC
    public String op;     // Operador da instrução (ex: +, -, *, etc.)
    public String arg1;   // Primeiro argumento da instrução
    public String arg2;   // Segundo argumento da instrução
    public String result; // Resultado da instrução

    // Construtor da classe TACInstruction
    public TACInstruction(String op, String arg1, String arg2, String result) {
        // Inicializa as variáveis de instância com os valores passados como parâmetro
        this.op = op; // Operador da instrução
        this.arg1 = arg1; // Primeiro argumento
        this.arg2 = arg2; // Segundo argumento
        this.result = result; // Resultado
    }

    // Método para converter a instrução em uma representação de string
    @Override
    public String toString() {
        // Retorna a instrução no formato "resultado = arg1 operador arg2"
        return result + " = " + arg1 + " " + op + " " + arg2;
    }//

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public String getOp() {
        return op;
    }

    public String getResult() {
        return result;
    }
}

