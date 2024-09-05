package AntlrVisitor;
// Importar as classes do projeto antlr para acessar os tokens e outros elementos
import Antlr.ExpressionBaseVisitor;
import Antlr.ExpressionParser;
import Expressions.*;
import Expressions.Conditionals.ElifExpression;
import Expressions.Conditionals.ElseExpression;
import Expressions.Conditionals.IfExpression;
import Expressions.Declarations.FunctionDeclaration;
import Expressions.Declarations.VariableDeclaration;
import Expressions.Literals.*;
import Expressions.Loops.ForLoop;
import Expressions.Loops.WhileLoop;
import Expressions.Loops.RangeExpression;
import Expressions.Operations.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// AST Visitor
public class AntlrToExpression extends ExpressionBaseVisitor<Expression> {

    // Erros semânticos (Dupla declaração, referência a variável não declarada, etc.)
    private List<String> semanticErrors;

    // Erros sintáticos (int x = 1.5, string = 1, etc)
    private List<String> syntaxErrors;
    // Construtor
    public AntlrToExpression(List<String> semanticErrors){
        this.semanticErrors = semanticErrors;
        this.syntaxErrors = new ArrayList<>();
    }
    // Método para obter a lista de erros semânticos
    private String AvaliarExpressao(Expression expression){

        if(expression instanceof IntegerNumber){
            IntegerNumber num = (IntegerNumber) expression;
            // Se for um inteiro, devolver valor
            return num.toString();
        }
        // Se for um float, devolver valor
        else if(expression instanceof FloatNumber){
            FloatNumber num = (FloatNumber) expression;
            // Se for um float, devolver valor
            return  num.toString();
        }
        // Se for uma variável, devolver valor
        else if(expression instanceof Variable){
            Variable variable = (Variable) expression;
            // Se for uma variável, devolver valor
            return variable.value;
        }
        // Se for uma variável, devolver valor
        else if(expression instanceof Addition){
            Addition exp = (Addition) expression;
            return exp.toString();
        }
        // Se for uma variável, devolver valor
        else if(expression instanceof Subtraction){
            Subtraction exp = (Subtraction) expression;
            return exp.toString();
        }
        // Se for uma variável, devolver valor
        else if(expression instanceof Multiplication){
            Multiplication exp = (Multiplication) expression;
            return exp.toString();
        }
        // Se for uma variável, devolver valor
        else if(expression instanceof Division){
            Division exp = (Division) expression;
            return exp.toString();
        }
        // Se for uma variável, devolver valor
        else if(expression instanceof BinaryExpression exp){



            return exp.toString();
        }
        // Se for uma variável, devolver valor
        else{
            semanticErrors.add("A expressão não foi bem construída, o compilador não conseguiu identificar.");
            return null;
        }
    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitProgram(ExpressionParser.ProgramContext ctx){
        Program prog = new Program();

        // Buscar cada Statement
        for (int i = 0; i < ctx.statement().size(); i++) {
            prog.addExpression(visit(ctx.statement(i)));
        }
        // Retorna programa
        return prog;
    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitExplicitDeclaration(ExpressionParser.ExplicitDeclarationContext ctx) {
        //  TYPE VARIABLE ('=' expr)? (',' VARIABLE ('=' expr)?)* ';';
        //  0    1          2  3        4  5          6  7         8

        // Tipo da variável
        String type = ctx.TYPE().getText();

        // Lista para devolver as variáveis
        List<Variable> variableList = new ArrayList<>();

        //Mostar as variáveis que temos até ao momento
        for (int i = 0; i < Expression.variables.size(); i++) {
        }
        //Temos este input para analisar


        // Busca cada variável
        for (int i = 0; i < ctx.VARIABLE().size(); i++) {
            // Nome da variável + verificar se já existe
            String variableName = ctx.VARIABLE(i).getText();

            // Valor da variável
            //String value = ctx.expr(i).getText();
            String value = AvaliarExpressao(visit(ctx.expr(i)));

            // Verifica se a variável já existe, caso contrário, adiciona-a à lista (cria-a)
            if(Expression.variables.stream().anyMatch(x -> x.equals(variableName))){
                Token idToken = ((TerminalNode)ctx.getChild(0)).getSymbol();
                int line = idToken.getLine();
                int column = idToken.getCharPositionInLine() + 1;
                semanticErrors.add("Erro: Variável " + variableName + " já foi declarada em (linha: " + line + ", coluna: " + column + ")");
            }
            else {
                Variable variable = new Variable(type, variableName, value);
                Expression.variables.add(variable);
                variableList.add(variable);
                //System.out.println("Adicionada nova variavel à lista: " + Expression.variables.get(Expression.variables.size()-1));
            }
        }
        // Devolve lista de variáveis
        if(ctx.VARIABLE().size() > 1) {
            //System.out.println("Returns a list of variables");

            return new VariableDeclaration(variableList);
        }
        // Devolve só 1 variável
        //System.out.println("Returns a single variable");
        return variableList.get(0);
    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitImplicitDeclaration(ExpressionParser.ImplicitDeclarationContext ctx) {

        //System.out.println("visitImplicitDeclaration176");
        //  VARIABLE '=' expr (',' VARIABLE '=' expr)* ;
        //  0         1  2      3         4  5

        //System.out.println("Argumento recebido é " + ctx.getText());

        //System.out.println("visitImplicitDeclaration176");
        //  VARIABLE '=' expr (',' VARIABLE '=' expr)* ;
        //  0         1  2      3         4  5

        //System.out.println("Argumento recebido é " + ctx.getText());

        // Lista para devolver as variáveis
        List<Variable> variableList = new ArrayList<>();

        // Busca cada variável
        for (int i = 0; i < ctx.VARIABLE().size(); i++) {
            // Nome da variável + verificar se já existe
            String variableName = ctx.VARIABLE(i).getText();

            // Valor da variável
            //System.out.println("Vamos visitar a expressão: " + ctx.expr(i).getText());
            String value = AvaliarExpressao(visit(ctx.expr(i)));


            //System.out.println("Acabamos a visita!");

            //System.out.println("Acabamos a visita!");
            Variable variable = new Variable(null, variableName, value);
            //System.out.println("Variável: " + variable.toString());
            variableList.add(variable);
            // Se já existe, atribui-lhe novo valor, caso contrário, inicializa-a
            if(!Expression.variables.stream().anyMatch(x -> x.equals(variableName))){

                //System.out.println("Esta variavel ainda não existe.");

                //System.out.println("Esta variavel ainda não existe.");

                Expression.variables.add(variable);
            }
        }

        // Devolve lista de variáveis
        if(ctx.VARIABLE().size() > 1) {
            return new VariableDeclaration(variableList);
        }
        // Devolve só 1 variável
        return variableList.get(0);
    }

    @Override
    public Expression visitFunctionDeclaration(ExpressionParser.FunctionDeclarationContext ctx) {
        //System.out.println("visitFunctionDeclaration187");
        // 'def' TYPE? VARIABLE '(' (TYPE? VARIABLE (',' TYPE? VARIABLE)*)? ')' ':' NEWLINE INDENT statement+ DEDENT;
        // 0     1     2         3   4     5          6  7     8             9  10  11      12     13         14

        // Tipo de retorno da função (se tiver)
        String returnType = ctx.TYPE(0) != null ? ctx.TYPE(0).getText() : null;

        // Nome da função
        String functionName = ctx.VARIABLE(0).getText();

        // List to store the function parameters
        List<Parameter> parameters = new ArrayList<>();

        // Buscar os parâmetros todos da função
        for (int i = 0; i < ctx.VARIABLE().size(); i++) {

            String paramType = ctx.TYPE(i) != null ? ctx.TYPE(i).getText() : null;
            String paramName = ctx.VARIABLE(i).getText();
            parameters.add(new Parameter(paramType, paramName));

        }


        // Buscar o corpo da função
        List<Expression> body = new ArrayList<>();

        // Buscar cada Statement para o corpo da função
        for (int i = 0; i < ctx.statement().size(); i++) {
            body.add(visit(ctx.statement(i)));
        }
        // Retorna a função
        return new FunctionDeclaration(returnType, functionName, parameters, body);

    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitOperationPM(ExpressionParser.OperationPMContext ctx) {

       // System.out.println("visitOperationPM248");

        //System.out.println("visitOperationPM248");

        // expr op= (PLUS | MINUS) expr
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String operator = ctx.op.getText();
        return new BinaryExpression(left, operator, right);
    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitOperationConditional(ExpressionParser.OperationConditionalContext ctx) {
        //System.out.println("visitOperationConditional233");
        // expr CONDITIONALS expr
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String operator = ctx.CONDITIONALS().getText();
        return new BinaryExpression(left, operator, right);
    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitOperationMultDiv(ExpressionParser.OperationMultDivContext ctx) {
        //System.out.println("visitOperationMultDiv243");
        // expr op=(DIVISION|MULTIPLICATION|INTDIVISION|MODULE|EXPONENTIAL) expr
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String operator = ctx.op.getText();
        return new BinaryExpression(left, operator, right);
    }
    @Override
    public Expression visitIfClause(ExpressionParser.IfClauseContext ctx) {
        //System.out.println("visitIfClause");
        // IF expr ':'  (INDENT statement+ DEDENT | statement)
        // (ELIF expr ':'  (INDENT statement+ DEDENT | statement))*
        // (ELSE ':'  (INDENT statement+ DEDENT | statement))?

        // Condição do if
        Expression condition = visit(ctx.expr(0));
        List<Statement> statements = getStatements(ctx.statement(0), ctx.INDENT(0), ctx.DEDENT(0));
        // 
        List<ElifExpression> elifs = new ArrayList<>();
        // Se tiver elifs
        if(!ctx.ELIF().isEmpty()){
            // Começa em 1, porque o 0 é do IF
            for (int i = 1; i < ctx.ELIF().size(); i++) {
                Expression elifCondition = visit(ctx.ELIF(i));
                List<Statement> elifStatements = getStatements(ctx.statement(i), ctx.INDENT(i), ctx.DEDENT(i));
                elifs.add(new ElifExpression(elifCondition, elifStatements));
            }
        }
        // Se tiver else
        ElseExpression elseExpression = null;
        // Se tiver else
        if(ctx.ELSE() != null) {
            List<Statement> elseStatements = getStatements(ctx.statement(elifs.size() + 1), ctx.INDENT(elifs.size() + 1), ctx.DEDENT(elifs.size() + 1));
            elseExpression = new ElseExpression(elseStatements);
        }

        //Expression condition, List<Statement> statements, List<ElifExpression> elifExpressions, Statement elseExpression
        return new IfExpression(condition, statements, elifs, elseExpression);
    }
    // Usado para ir buscar os statements dentro do IF, ELIF e ELSE
    private List<Statement> getStatements(ExpressionParser.StatementContext ctx, TerminalNode indent, TerminalNode dedent) {
        //System.out.println("getStatements299");
        List<Statement> statements = new ArrayList<>();
        if (indent != null && dedent != null) {
            // Buscar os statements
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (ctx.getChild(i) instanceof ExpressionParser.StatementContext) {
                    statements.add((Statement) visit(ctx.getChild(i)));
                }
            }
        } else {
            // Statement sem INDENT-DEDENT
            statements.add((Statement) visit(ctx));
        }
        // Return the list of statements
        return statements;
    }
    // Método para obter a lista de erros sintáticos
    @Override
    public Expression visitWhile(ExpressionParser.WhileContext ctx) {
        //System.out.println("visitWhile303");
        // 'while' expr ':' NEWLINE INDENT statement+ DEDENT

        // Visitar a condição do while
        Expression condition = visit(ctx.expr());

        // Visit the statements inside the 'while' loop
        List<Statement> statements = new ArrayList<>();
        for (int i = 0; i < ctx.statement().size(); i++) {
            statements.add((Statement) visit(ctx.statement(i)));
        }

        // Create and return a WhileExpression object
        return new WhileLoop(condition, statements);
    }
//TODO FAZER O FOR
    @Override
    public Expression visitFor(ExpressionParser.ForContext ctx) {
        //System.out.println("visitFor321");
        // 'for' VARIABLE 'in' (VARIABLE | ('range(' expr (',' expr (',' expr)?)? ')')) ':' NEWLINE INDENT statement+ DEDENT

        // Ver se a variável já existe
        if(!Expression.variables.stream().anyMatch(x -> x.equals(ctx.VARIABLE(0)))){
            semanticErrors.add("Variável não inicializada " + ctx.VARIABLE(0));
            return null;
        }

        // Corpo do for
        List<Statement> body = getStatements(ctx.statement(0), ctx.INDENT(), ctx.DEDENT());

        // Verificar se está a iterar sob uma variável ou sob o Range function
        if(ctx.VARIABLE(1) != null){
        
            Expression iterador = null;

            // Verificar se a variável existe
            if(Expression.variables.stream().anyMatch(x -> x.equals(ctx.VARIABLE(1).getText()))){

            }else{
                // TODO ver se a variavel precisa de estar inicializada fora do for ou não
                semanticErrors.add("Variável não inicializada " + ctx.VARIABLE(1));
                return null;
                //iterador = new VariableExpression(ctx.VARIABLE(1).getText());
                //return new ForLoop(null, iterador, null, body);
                //return null;
                
            }
            return new ForLoop(null, iterador, null, body);
        }else{
            // The loop iterates over a range
            Expression start, stop, step = null;
            start = visit(ctx.expr(0));
            stop = visit(ctx.expr(1));

            if(ctx.expr(2) != null)
                step = visit(ctx.expr(2));
            // Retorna um range
            return new ForLoop(null, null, new RangeExpression(start, stop, step), body);
        }
    }
    // Método para visitar o return
    @Override
    public Expression visitReturn(ExpressionParser.ReturnContext ctx) {
        //System.out.println("visitReturn366");
        // RETURN expr
        // TODO verificar se o return está dentro de uma função
        if(ctx.expr() == null){
            semanticErrors.add("Return sem expressão");
            return null;
        }   

        return new ReturnExpression(visit(ctx.expr()));
    }
    // Método para visitar o print
    @Override
    public Expression visitFunctionInvocation(ExpressionParser.FunctionInvocationContext ctx) {
        //System.out.println("visitFunctionInvocation379");
        // VARIABLE '(' (expr (',' expr)*)? ')'

        // Get the function name
        String functionName = ctx.VARIABLE().getText();

        // List to store the function call arguments
        List<Expression> args = new ArrayList<>();

        // Visit each expression inside the parentheses
        for (ExpressionParser.ExprContext exprCtx : ctx.expr()) {
            args.add(visit(exprCtx));
        }

        // Create a FunctionCallExpression object with the function name and arguments
        return new FunctionCallExpression(functionName, args);
    }
    // Método para visitar o print
    @Override
    public Expression visitFloatNumber(ExpressionParser.FloatNumberContext ctx) {

       // System.out.println("visitFloatNumber425");

        //System.out.println("visitFloatNumber425");

        // Buscar texto do float
        String floatText = ctx.getText();

        // Converter
        float floatValue;
        try {
            floatValue = Float.parseFloat(floatText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tentativa de transformar valor " + floatText + " em float.", e);
        }

        // Devolver float
        return new FloatNumber(floatValue);
    }

    // 
    @Override
    public Expression visitIntegerNumber(ExpressionParser.IntegerNumberContext ctx) {

        //System.out.println("visitIntegerNumber446");

        //System.out.println("visitIntegerNumber446");

        // Buscar texto do inteiro
        String intText = ctx.getText();
        //System.out.println("Texto = " + intText);

        // Converter
        int intValue;
        try {
            intValue = Integer.parseInt(intText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tentativa de transformar valor " + intText + " em int.", e);
        }

        // Devolver inteiro
        return new IntegerNumber(intValue);
    }
    // Método para visitar o print
    @Override
    public Expression visitVariable(ExpressionParser.VariableContext ctx) {

        //System.out.println("visitVariableName462: " + ctx.getText());
       // System.out.println("Verificar se a variável " + ctx.getText() +" existe... A mostrar variáveis:\n " + Expression.variables);

        //System.out.println("visitVariableName462: " + ctx.getText());
        //System.out.println("Verificar se a variável " + ctx.getText() +" existe... A mostrar variáveis:\n " + Expression.variables);


        // Verificar se a variável já foi declarada
        if(!Expression.variables.stream().anyMatch(x -> x.name.equals(ctx.getText()))){
            //System.out.println("Im here mofo");
            Token token = ctx.VARIABLE().getSymbol();
            int line = token.getLine();
            int col = token.getCharPositionInLine();
            semanticErrors.add("Variável não inicializada: " + ctx.getText() + " em (linha: " + line + ", col: " + col + ")");
        }
        else
        {
            Optional<Variable> Test = Expression.variables.stream().filter(x -> x.name.equals(ctx.getText())).findFirst();
            // Test.ifPresent(variable -> System.out.println("Variável encontrada: " + variable));
            //System.out.println("A retornar variável: " + ctx.getText());
            return Test.get();
        }


        // Variável com o nome dado
        //System.out.println("A retornar variável: " + ctx.getText());
        return new Variable("", ctx.getText(),"");
    }
    // Método para visitar o print
    @Override
    public Expression visitList(ExpressionParser.ListContext ctx) {
        //System.out.println("visitList449");
        // '[' expr (',' expr)* ']'
        // Inicializar a lista
        List<Expression> elements = new ArrayList<>();

        // Visitar cada expressão e adicionar à lista
        for (ExpressionParser.ExprContext exprCtx : ctx.expr()) {
            elements.add(visit(exprCtx));
        }

        // Create and return a new ListExpression object
        return new ListExpression(elements);
    }
    // Método para visitar o print
    @Override
    public Expression visitExpressionWithParentheses(ExpressionParser.ExpressionWithParenthesesContext ctx) {
        //System.out.println("visitExpressionWithParentheses465");
        // '(' expr ')'
        return visit(ctx.expr());
    }
    // Método para visitar o print
    @Override
    public Expression visitString(ExpressionParser.StringContext ctx) {
        //System.out.println("visitString473");
        // Extrair o literal da string do contexto
        String stringLiteral = ctx.getText();

        // Retornar a expressão de string
        return new StringLiteral(stringLiteral);
    }

    // 
    @Override
    public Expression visitSignedExpression(ExpressionParser.SignedExpressionContext ctx) {
        //System.out.println("visitString483");
        // (PLUS|MINUS) expr
        String operator = ctx.MINUS() != null? "-" : "+";
        

        return new UnaryExpression(operator, visit(ctx.expr()));
    }
}
