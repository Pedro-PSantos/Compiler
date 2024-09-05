package TAC;

import java.util.*;

// Classe responsável por otimizar as instruções TAC (Three-Address Code)
public class Optimizer {

    // Método principal para otimizar uma lista de instruções TAC
    public List<TACInstruction> optimize(List<TACInstruction> instructions) {
        eliminateDeadCode(instructions);          // Elimina código morto
        eliminateCopyInstructions(instructions);  // Elimina instruções de cópia redundantes
        simplifyExpressions(instructions);        // Simplifica expressões constantes
        instructions = unrollLoops(instructions); // Desenrolamento de ciclos
        instructions = inlineFunctions(instructions); // Inlining de funções
        propagateConstants(instructions);         // Propagação de constantes
        removeRedundantAssignments(instructions); // Remoção de atribuições redundantes
        peepholeOptimization(instructions);       // Peephole optimization
        return instructions;                      // Retorna a lista otimizada de instruções
    }

    // Elimina código morto (instruções cujas variáveis de resultado nunca são usadas)
    private void eliminateDeadCode(List<TACInstruction> instructions) {
        Set<String> usedVars = new HashSet<>(); // Conjunto para rastrear variáveis usadas

        // Percorre as instruções para identificar variáveis usadas
        for (TACInstruction instr : instructions) {
            if (instr.arg1 != null && !isConstant(instr.arg1)) {
                usedVars.add(instr.arg1);
            }
            if (instr.arg2 != null && !isConstant(instr.arg2)) {
                usedVars.add(instr.arg2);
            }
        }

        // Remove instruções cujas variáveis de resultado nunca são usadas
        instructions.removeIf(instr -> !usedVars.contains(instr.result));
    }

    // Elimina instruções de cópia redundantes
    private void eliminateCopyInstructions(List<TACInstruction> instructions) {
        Map<String, String> copyMap = new HashMap<>(); // Mapa para rastrear instruções de cópia

        // Percorre as instruções para identificar e mapear cópias
        for (TACInstruction instr : instructions) {
            if (instr.op.equals("=") && !isConstant(instr.arg1)) {
                copyMap.put(instr.result, instr.arg1);
            }
        }

        // Substitui argumentos por suas cópias mapeadas
        for (TACInstruction instr : instructions) {
            if (copyMap.containsKey(instr.arg1)) {
                instr.arg1 = copyMap.get(instr.arg1);
            }
            if (instr.arg2 != null && copyMap.containsKey(instr.arg2)) {
                instr.arg2 = copyMap.get(instr.arg2);
            }
        }

        // Remove instruções de cópia redundantes
        instructions.removeIf(instr -> instr.op.equals("=") && copyMap.containsKey(instr.result));
    }

    // Simplifica expressões constantes
    private void simplifyExpressions(List<TACInstruction> instructions) {
        // Percorre as instruções para simplificar expressões
        for (TACInstruction instr : instructions) {
            if (isConstant(instr.arg1) && instr.arg2 != null && isConstant(instr.arg2)) {
                // Avalia a expressão e simplifica
                instr.result = evaluate(instr.op, instr.arg1, instr.arg2);
                instr.op = "=";
                instr.arg1 = instr.result;
                instr.arg2 = null;
            }
        }
    }

    // Verifica se um argumento é uma constante (número inteiro)
    private boolean isConstant(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Avalia uma operação entre dois argumentos constantes
    private String evaluate(String op, String arg1, String arg2) {
        int val1 = Integer.parseInt(arg1); // Converte argumentos para inteiros
        int val2 = Integer.parseInt(arg2); // Converte argumentos para inteiros
        // Avalia a expressão e retorna o resultado como uma string
        switch (op) {
            case "+": return Integer.toString(val1 + val2);  // Soma
            case "-": return Integer.toString(val1 - val2);  // Subtração
            case "*": return Integer.toString(val1 * val2);  // Multiplicação
            case "/": return Integer.toString(val1 / val2);  // Divisão
            default: throw new RuntimeException("Unknown operator: " + op); // Operador desconhecido
        }
    }

    // Desenrolamento de ciclos (Loop Unrolling)
    private List<TACInstruction> unrollLoops(List<TACInstruction> instructions) {
        List<TACInstruction> result = new ArrayList<>();

        for (int i = 0; i < instructions.size(); i++) {
            TACInstruction instr = instructions.get(i);

            if (instr.getOp().equals("for")) {
                // Desenrolamento de ciclos simples
                String indexVar = instr.getArg1();
                int start = Integer.parseInt(instr.getArg2());
                int end = Integer.parseInt(instr.getResult());

                for (int j = start; j < end; j++) {
                    for (int k = i + 1; k < instructions.size(); k++) {
                        TACInstruction innerInstr = instructions.get(k);
                        if (innerInstr.getOp().equals("endfor")) {
                            i = k;
                            break;
                        }
                        // Substituição da variável de índice pelo valor atual
                        result.add(new TACInstruction(innerInstr.getOp(),
                                innerInstr.getArg1().replace(indexVar, Integer.toString(j)),
                                innerInstr.getArg2() != null ? innerInstr.getArg2().replace(indexVar, Integer.toString(j)) : null,
                                innerInstr.getResult().replace(indexVar, Integer.toString(j))));
                    }
                }
            } else {
                result.add(instr);
            }
        }

        return result;
    }

    // Inlining de funções
    private List<TACInstruction> inlineFunctions(List<TACInstruction> instructions) {
        List<TACInstruction> result = new ArrayList<>();
        Map<String, List<TACInstruction>> functionMap = new HashMap<>();
        String functionName = null;
        List<TACInstruction> functionBody = null;

        for (TACInstruction instr : instructions) {
            if (instr.getOp().equals("def")) {
                functionName = instr.getResult();
                functionBody = new ArrayList<>();
            } else if (instr.getOp().equals("enddef")) {
                functionMap.put(functionName, functionBody);
                functionName = null;
                functionBody = null;
            } else if (functionName != null) {
                functionBody.add(instr);
            } else if (instr.getOp().equals("call")) {
                String calledFunctionName = instr.getResult();
                List<TACInstruction> calledFunctionBody = functionMap.get(calledFunctionName);
                if (calledFunctionBody != null) {
                    result.addAll(calledFunctionBody);
                }
            } else {
                result.add(instr);
            }
        }

        return result;
    }

    // Propagação de constantes
    private void propagateConstants(List<TACInstruction> instructions) {
        Map<String, String> constMap = new HashMap<>(); // Mapa para rastrear constantes

        // Percorre as instruções para identificar e mapear constantes
        for (TACInstruction instr : instructions) {
            if (instr.op.equals("=") && isConstant(instr.arg1)) {
                constMap.put(instr.result, instr.arg1);
            }
        }

        // Substitui argumentos por suas constantes mapeadas
        for (TACInstruction instr : instructions) {
            if (constMap.containsKey(instr.arg1)) {
                instr.arg1 = constMap.get(instr.arg1);
            }
            if (instr.arg2 != null && constMap.containsKey(instr.arg2)) {
                instr.arg2 = constMap.get(instr.arg2);
            }
        }
    }

    // Remoção de atribuições redundantes
    private void removeRedundantAssignments(List<TACInstruction> instructions) {
        instructions.removeIf(instr -> instr.op.equals("=") && instr.result.equals(instr.arg1));
    }

    // Peephole optimization
    private void peepholeOptimization(List<TACInstruction> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            TACInstruction instr = instructions.get(i);
            // Exemplo de peephole optimization: x = x + 0 => NOP
            if (instr.op.equals("+") && isConstant(instr.arg2) && Integer.parseInt(instr.arg2) == 0) {
                instructions.set(i, new TACInstruction("NOP", null, null, null));
            }
            // Adicionar mais otimizações peephole conforme necessário
        }

        // Remover instruções NOP
        instructions.removeIf(instr -> instr.op.equals("NOP"));
    }
}
