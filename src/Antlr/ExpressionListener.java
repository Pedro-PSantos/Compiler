// Generated from Expression.g4 by ANTLR 4.13.1

    package Antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExpressionParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExpressionParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExpressionParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExpressionParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExplicitDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExplicitDeclaration(ExpressionParser.ExplicitDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExplicitDeclaration(ExpressionParser.ExplicitDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImplicitDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImplicitDeclaration(ExpressionParser.ImplicitDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImplicitDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImplicitDeclaration(ExpressionParser.ImplicitDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(ExpressionParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(ExpressionParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfClause}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfClause(ExpressionParser.IfClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfClause}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfClause(ExpressionParser.IfClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(ExpressionParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(ExpressionParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code For}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFor(ExpressionParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code For}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFor(ExpressionParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn(ExpressionParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn(ExpressionParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OperationPM}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperationPM(ExpressionParser.OperationPMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OperationPM}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperationPM(ExpressionParser.OperationPMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionInvocation}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(ExpressionParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionInvocation}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(ExpressionParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExpressionParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExpressionParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatNumber}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloatNumber(ExpressionParser.FloatNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatNumber}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloatNumber(ExpressionParser.FloatNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OperationConditional}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperationConditional(ExpressionParser.OperationConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OperationConditional}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperationConditional(ExpressionParser.OperationConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNumber(ExpressionParser.IntegerNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNumber(ExpressionParser.IntegerNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code List}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterList(ExpressionParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code List}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitList(ExpressionParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionWithParentheses}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionWithParentheses(ExpressionParser.ExpressionWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionWithParentheses}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionWithParentheses(ExpressionParser.ExpressionWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(ExpressionParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(ExpressionParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OperationMultDiv}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperationMultDiv(ExpressionParser.OperationMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OperationMultDiv}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperationMultDiv(ExpressionParser.OperationMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SignedExpression}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSignedExpression(ExpressionParser.SignedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SignedExpression}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSignedExpression(ExpressionParser.SignedExpressionContext ctx);
}