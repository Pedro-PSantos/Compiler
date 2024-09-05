// Generated from Expression.g4 by ANTLR 4.13.1

    package Antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExpressionParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExpressionParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExplicitDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitDeclaration(ExpressionParser.ExplicitDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImplicitDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitDeclaration(ExpressionParser.ImplicitDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(ExpressionParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfClause}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfClause(ExpressionParser.IfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ExpressionParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(ExpressionParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link ExpressionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(ExpressionParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OperationPM}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationPM(ExpressionParser.OperationPMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionInvocation}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(ExpressionParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ExpressionParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatNumber}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatNumber(ExpressionParser.FloatNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OperationConditional}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationConditional(ExpressionParser.OperationConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNumber(ExpressionParser.IntegerNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code List}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(ExpressionParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionWithParentheses}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithParentheses(ExpressionParser.ExpressionWithParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ExpressionParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OperationMultDiv}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationMultDiv(ExpressionParser.OperationMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedExpression}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedExpression(ExpressionParser.SignedExpressionContext ctx);
}