package TAC;

import java.util.ArrayList;
import java.util.List;

public class P3Generator {
    private int labelCount = 0; // Contador para gerar rótulos únicos

    // Método principal que traduz uma lista de instruções TAC para P3
    public List<String> translate(List<TACInstruction> tacInstructions) {
        List<String> p3Instructions = new ArrayList<>();

        // Itera sobre cada instrução TAC na lista fornecida
        for (TACInstruction instr : tacInstructions) {
            switch (instr.getOp()) {
                // Caso de atribuição (ex: t1 = a)
                case "=":
                    p3Instructions.add(translateAssignment(instr));
                    break;
                // Caso de adição (ex: t1 = t2 + t3)
                case "+":
                    p3Instructions.add(translateAddition(instr));
                    break;
                // Caso de subtração (ex: t1 = t2 - t3)
                case "-":
                    p3Instructions.add(translateSubtraction(instr));
                    break;
                // Caso de multiplicação (ex: t1 = t2 * t3)
                case "*":
                    p3Instructions.add(translateMultiplication(instr));
                    break;
                // Caso de divisão (ex: t1 = t2 / t3)
                case "/":
                    p3Instructions.add(translateDivision(instr));
                    break;
                // Caso de estrutura condicional 'if'
                case "if":
                    p3Instructions.addAll(translateIf(instr));
                    break;
                // Caso de estrutura condicional 'ifFalse'
                case "ifFalse":
                    p3Instructions.addAll(translateIfFalse(instr));
                    break;
                // Caso de salto incondicional (ex: goto L1)
                case "goto":
                    p3Instructions.add(translateGoto(instr));
                    break;
                // Caso de rótulo (ex: L1:)
                case "LABEL":
                    p3Instructions.add(translateLabel(instr));
                    break;
                // Caso de loop 'while'
                case "while":
                    p3Instructions.addAll(translateWhile(instr));
                    break;
                // Caso de loop 'doWhile'
                case "doWhile":
                    p3Instructions.addAll(translateDoWhile(instr));
                    break;
                // Caso de loop 'for'
                case "for":
                    p3Instructions.addAll(translateFor(instr));
                    break;
                // Caso de definição de função 'func'
                case "func":
                    p3Instructions.addAll(translateFunction(instr));
                    break;
                // Caso de retorno (ex: return t1)
                case "return":
                    p3Instructions.add(translateReturn(instr));
                    break;
                // Caso padrão para operações não suportadas
                default:
                    throw new UnsupportedOperationException("Operação não suportada: " + instr.getOp());
            }
        }

        return p3Instructions;
    }

    // Método para traduzir uma atribuição (t1 = a) para P3 (MOV t1, a)
    private String translateAssignment(TACInstruction instr) {
        return "MOV " + instr.getResult() + ", " + instr.getArg1();
    }

    // Método para traduzir uma adição (t1 = t2 + t3) para P3 (ADD t1, t2, t3)
    private String translateAddition(TACInstruction instr) {
        return "ADD " + instr.getResult() + ", " + instr.getArg1() + ", " + instr.getArg2();
    }

    // Método para traduzir uma subtração (t1 = t2 - t3) para P3 (SUB t1, t2, t3)
    private String translateSubtraction(TACInstruction instr) {
        return "SUB " + instr.getResult() + ", " + instr.getArg1() + ", " + instr.getArg2();
    }

    // Método para traduzir uma multiplicação (t1 = t2 * t3) para P3 (MUL t1, t2, t3)
    private String translateMultiplication(TACInstruction instr) {
        return "MUL " + instr.getResult() + ", " + instr.getArg1() + ", " + instr.getArg2();
    }

    // Método para traduzir uma divisão (t1 = t2 / t3) para P3 (DIV t1, t2, t3)
    private String translateDivision(TACInstruction instr) {
        return "DIV " + instr.getResult() + ", " + instr.getArg1() + ", " + instr.getArg2();
    }

    // Método para traduzir uma estrutura 'if' para P3
    private List<String> translateIf(TACInstruction instr) {
        List<String> result = new ArrayList<>();
        String label = generateLabel();
        // Comparação (ex: CMP t1, t2)
        result.add("CMP " + instr.getArg1() + ", " + instr.getArg2());
        // Salto condicional (ex: JMP.EQ L1)
        result.add("JMP.EQ " + label);
        // Rótulo da instrução 'if' (ex: L2:)
        result.add(instr.getResult() + ":");
        // Rótulo de destino do salto condicional (ex: L1:)
        result.add(label + ":");
        return result;
    }

    // Método para traduzir uma estrutura 'ifFalse' para P3
    private List<String> translateIfFalse(TACInstruction instr) {
        List<String> result = new ArrayList<>();
        String label = generateLabel();
        // Comparação (ex: CMP t1, t2)
        result.add("CMP " + instr.getArg1() + ", " + instr.getArg2());
        // Salto condicional (ex: JMP.NE L1)
        result.add("JMP.NE " + label);
        // Rótulo da instrução 'ifFalse' (ex: L2:)
        result.add(instr.getResult() + ":");
        // Rótulo de destino do salto condicional (ex: L1:)
        result.add(label + ":");
        return result;
    }

    // Método para traduzir uma instrução de salto incondicional (goto) para P3
    private String translateGoto(TACInstruction instr) {
        return "JMP " + instr.getResult();
    }

    // Método para traduzir uma instrução de definição de rótulo (LABEL) para P3
    private String translateLabel(TACInstruction instr) {
        return instr.getResult() + ":";
    }

    // Método para traduzir uma estrutura 'while' para P3
    private List<String> translateWhile(TACInstruction instr) {
        List<String> result = new ArrayList<>();
        String startLabel = generateLabel();
        String endLabel = generateLabel();
        // Rótulo de início do loop (ex: L1:)
        result.add(startLabel + ":");
        // Comparação (ex: CMP t1, t2)
        result.add("CMP " + instr.getArg1() + ", " + instr.getArg2());
        // Salto condicional para fim do loop (ex: JMP.EQ L2)
        result.add("JMP.EQ " + endLabel);
        // Corpo do loop (instruções dentro do 'while')
        result.add(instr.getResult() + ":");
        // Salto incondicional para o início do loop (ex: JMP L1)
        result.add("JMP " + startLabel);
        // Rótulo de fim do loop (ex: L2:)
        result.add(endLabel + ":");
        return result;
    }

    // Método para traduzir uma estrutura 'doWhile' para P3
    private List<String> translateDoWhile(TACInstruction instr) {
        List<String> result = new ArrayList<>();
        String startLabel = generateLabel();
        String endLabel = generateLabel();
        // Rótulo de início do loop (ex: L1:)
        result.add(startLabel + ":");
        // Corpo do loop (instruções dentro do 'doWhile')
        result.add(instr.getResult() + ":");
        // Comparação (ex: CMP t1, t2)
        result.add("CMP " + instr.getArg1() + ", " + instr.getArg2());
        // Salto condicional para início do loop (ex: JMP.NE L1)
        result.add("JMP.NE " + startLabel);
        // Rótulo de fim do loop (ex: L2:)
        result.add(endLabel + ":");
        return result;
    }

    // Método para traduzir uma estrutura 'for' para P3
    private List<String> translateFor(TACInstruction instr) {
        List<String> result = new ArrayList<>();
        String startLabel = generateLabel();
        String endLabel = generateLabel();
        // Inicialização do loop (ex: MOV t1, a)
        result.add("MOV " + instr.getResult() + ", " + instr.getArg1());
        // Rótulo de início do loop (ex: L1:)
        result.add(startLabel + ":");
        // Comparação (ex: CMP t1, t2)
        result.add("CMP " + instr.getResult() + ", " + instr.getArg2());
        // Salto condicional para fim do loop (ex: JMP.EQ L2)
        result.add("JMP.EQ " + endLabel);
        // Corpo do loop (instruções dentro do 'for')
        result.add(instr.getArg1() + ":");
        // Incremento (ex: ADD t1, t1, 1)
        result.add("ADD " + instr.getResult() + ", " + instr.getResult() + ", 1");
        // Salto incondicional para início do loop (ex: JMP L1)
        result.add("JMP " + startLabel);
        // Rótulo de fim do loop (ex: L2:)
        result.add(endLabel + ":");
        return result;
    }

    // Método para traduzir uma definição de função 'func' para P3
    private List<String> translateFunction(TACInstruction instr) {
        List<String> result = new ArrayList<>();
        // Rótulo da função (ex: func1:)
        result.add(instr.getResult() + ":");
        // Corpo da função (instruções dentro da função)
        result.add(instr.getArg1() + ":");
        return result;
    }

    // Método para traduzir uma instrução de retorno 'return' para P3
    private String translateReturn(TACInstruction instr) {
        return "RET " + instr.getArg1();
    }

    // Método para gerar rótulos únicos
    private String generateLabel() {
        return "L" + (labelCount++);
    }
}
