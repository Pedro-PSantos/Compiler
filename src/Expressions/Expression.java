package Expressions;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Expressions.Literals.Variable;

import java.util.ArrayList;
import java.util.List;
// Classe abstrata para representar expressões
public abstract class Expression
{
    // Guarda as variaveis declaradas no programa para todos terem acesso
    public static List<Variable> variables = new ArrayList<>();

    public String getName() {
        return "";
    }
}
