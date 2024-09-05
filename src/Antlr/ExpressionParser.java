// Generated from Expression.g4 by ANTLR 4.13.1

    package Antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		TYPE=10, STRING=11, VARIABLE=12, INT=13, FLOAT=14, MINUS=15, PLUS=16, 
		DIVISION=17, MULTIPLICATION=18, INTDIVISION=19, EXPONENTIAL=20, MODULE=21, 
		CONDITIONALS=22, SMALLER=23, SMALLEREQ=24, BIGGER=25, BIGGEREQ=26, DIFFERENT=27, 
		EQUALS=28, IF=29, ELIF=30, ELSE=31, DEF=32, WHILE=33, FOR=34, RETURN=35, 
		COMMENT=36, WS=37, INDENT=38, DEDENT=39, NEWLINE=40;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "statement", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'('", "')'", "':'", "'in'", "'range('", "'['", "']'", 
			null, null, null, null, null, "'-'", "'+'", "'/'", "'*'", "'//'", "'**'", 
			"'%'", null, "'<'", "'<='", "'>'", "'>='", "'!='", "'=='", "'if'", "'elif'", 
			"'else'", "'def'", "'while'", "'for'", "'return'", null, null, "' '", 
			"'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "TYPE", "STRING", 
			"VARIABLE", "INT", "FLOAT", "MINUS", "PLUS", "DIVISION", "MULTIPLICATION", 
			"INTDIVISION", "EXPONENTIAL", "MODULE", "CONDITIONALS", "SMALLER", "SMALLEREQ", 
			"BIGGER", "BIGGEREQ", "DIFFERENT", "EQUALS", "IF", "ELIF", "ELSE", "DEF", 
			"WHILE", "FOR", "RETURN", "COMMENT", "WS", "INDENT", "DEDENT", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ProgContext {
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0)) {
				{
				{
				setState(6);
				statement();
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends StatementContext {
		public TerminalNode DEF() { return getToken(ExpressionParser.DEF, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(ExpressionParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(ExpressionParser.VARIABLE, i);
		}
		public TerminalNode NEWLINE() { return getToken(ExpressionParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ExpressionParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ExpressionParser.DEDENT, 0); }
		public List<TerminalNode> TYPE() { return getTokens(ExpressionParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(ExpressionParser.TYPE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(ExpressionParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends StatementContext {
		public TerminalNode FOR() { return getToken(ExpressionParser.FOR, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(ExpressionParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(ExpressionParser.VARIABLE, i);
		}
		public TerminalNode NEWLINE() { return getToken(ExpressionParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ExpressionParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ExpressionParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfClauseContext extends StatementContext {
		public TerminalNode IF() { return getToken(ExpressionParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> INDENT() { return getTokens(ExpressionParser.INDENT); }
		public TerminalNode INDENT(int i) {
			return getToken(ExpressionParser.INDENT, i);
		}
		public List<TerminalNode> DEDENT() { return getTokens(ExpressionParser.DEDENT); }
		public TerminalNode DEDENT(int i) {
			return getToken(ExpressionParser.DEDENT, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(ExpressionParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(ExpressionParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(ExpressionParser.ELSE, 0); }
		public IfClauseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIfClause(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImplicitDeclarationContext extends StatementContext {
		public List<TerminalNode> VARIABLE() { return getTokens(ExpressionParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(ExpressionParser.VARIABLE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ImplicitDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterImplicitDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitImplicitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitImplicitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(ExpressionParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExpressionParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ExpressionParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ExpressionParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitDeclarationContext extends StatementContext {
		public TerminalNode TYPE() { return getToken(ExpressionParser.TYPE, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(ExpressionParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(ExpressionParser.VARIABLE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExplicitDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExplicitDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExplicitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExplicitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				_localctx = new ExplicitDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(TYPE);
				setState(15);
				match(VARIABLE);
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(16);
					match(T__0);
					setState(17);
					match(VARIABLE);
					}
					}
					setState(22);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(23);
					match(T__1);
					setState(24);
					expr(0);
					setState(29);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(25);
						match(T__0);
						setState(26);
						expr(0);
						}
						}
						setState(31);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case VARIABLE:
				_localctx = new ImplicitDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(VARIABLE);
				setState(35);
				match(T__1);
				setState(36);
				expr(0);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(37);
					match(T__0);
					setState(38);
					match(VARIABLE);
					setState(39);
					match(T__1);
					setState(40);
					expr(0);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEF:
				_localctx = new FunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				match(DEF);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE) {
					{
					setState(47);
					match(TYPE);
					}
				}

				setState(50);
				match(VARIABLE);
				setState(51);
				match(T__2);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE || _la==VARIABLE) {
					{
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==TYPE) {
						{
						setState(52);
						match(TYPE);
						}
					}

					setState(55);
					match(VARIABLE);
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(56);
						match(T__0);
						setState(58);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==TYPE) {
							{
							setState(57);
							match(TYPE);
							}
						}

						setState(60);
						match(VARIABLE);
						}
						}
						setState(65);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(68);
				match(T__3);
				setState(69);
				match(T__4);
				setState(70);
				match(NEWLINE);
				setState(71);
				match(INDENT);
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					statement();
					}
					}
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0) );
				setState(77);
				match(DEDENT);
				}
				break;
			case IF:
				_localctx = new IfClauseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(IF);
				setState(80);
				expr(0);
				setState(81);
				match(T__4);
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INDENT:
					{
					setState(82);
					match(INDENT);
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(83);
						statement();
						}
						}
						setState(86); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0) );
					setState(88);
					match(DEDENT);
					}
					break;
				case TYPE:
				case VARIABLE:
				case IF:
				case DEF:
				case WHILE:
				case FOR:
				case RETURN:
					{
					setState(90);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(93);
						match(ELIF);
						setState(94);
						expr(0);
						setState(95);
						match(T__4);
						setState(105);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case INDENT:
							{
							setState(96);
							match(INDENT);
							setState(98); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(97);
								statement();
								}
								}
								setState(100); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0) );
							setState(102);
							match(DEDENT);
							}
							break;
						case TYPE:
						case VARIABLE:
						case IF:
						case DEF:
						case WHILE:
						case FOR:
						case RETURN:
							{
							setState(104);
							statement();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(111);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(112);
					match(ELSE);
					setState(113);
					match(T__4);
					setState(123);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INDENT:
						{
						setState(114);
						match(INDENT);
						setState(116); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(115);
							statement();
							}
							}
							setState(118); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0) );
						setState(120);
						match(DEDENT);
						}
						break;
					case TYPE:
					case VARIABLE:
					case IF:
					case DEF:
					case WHILE:
					case FOR:
					case RETURN:
						{
						setState(122);
						statement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				}
				break;
			case WHILE:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(WHILE);
				setState(128);
				expr(0);
				setState(129);
				match(T__4);
				setState(130);
				match(NEWLINE);
				setState(131);
				match(INDENT);
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					statement();
					}
					}
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0) );
				setState(137);
				match(DEDENT);
				}
				break;
			case FOR:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				match(FOR);
				setState(140);
				match(VARIABLE);
				setState(141);
				match(T__5);
				setState(155);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARIABLE:
					{
					setState(142);
					match(VARIABLE);
					}
					break;
				case T__6:
					{
					{
					setState(143);
					match(T__6);
					setState(144);
					expr(0);
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(145);
						match(T__0);
						setState(146);
						expr(0);
						setState(149);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__0) {
							{
							setState(147);
							match(T__0);
							setState(148);
							expr(0);
							}
						}

						}
					}

					setState(153);
					match(T__3);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(157);
				match(T__4);
				setState(158);
				match(NEWLINE);
				setState(159);
				match(INDENT);
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160);
					statement();
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 64961385472L) != 0) );
				setState(165);
				match(DEDENT);
				}
				break;
			case RETURN:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(RETURN);
				setState(168);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperationPMContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public OperationPMContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOperationPM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOperationPM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitOperationPM(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionInvocationContext extends ExprContext {
		public TerminalNode VARIABLE() { return getToken(ExpressionParser.VARIABLE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionInvocationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExprContext {
		public TerminalNode VARIABLE() { return getToken(ExpressionParser.VARIABLE, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatNumberContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(ExpressionParser.FLOAT, 0); }
		public FloatNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFloatNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFloatNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFloatNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperationConditionalContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONDITIONALS() { return getToken(ExpressionParser.CONDITIONALS, 0); }
		public OperationConditionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOperationConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOperationConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitOperationConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerNumberContext extends ExprContext {
		public TerminalNode INT() { return getToken(ExpressionParser.INT, 0); }
		public IntegerNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIntegerNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIntegerNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIntegerNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionWithParenthesesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionWithParenthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpressionWithParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpressionWithParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExpressionWithParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ExpressionParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperationMultDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(ExpressionParser.DIVISION, 0); }
		public TerminalNode MULTIPLICATION() { return getToken(ExpressionParser.MULTIPLICATION, 0); }
		public TerminalNode INTDIVISION() { return getToken(ExpressionParser.INTDIVISION, 0); }
		public TerminalNode MODULE() { return getToken(ExpressionParser.MODULE, 0); }
		public TerminalNode EXPONENTIAL() { return getToken(ExpressionParser.EXPONENTIAL, 0); }
		public OperationMultDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOperationMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOperationMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitOperationMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SignedExpressionContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public SignedExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSignedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSignedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSignedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new SignedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(172);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==PLUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(173);
				expr(11);
				}
				break;
			case 2:
				{
				_localctx = new ExpressionWithParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(T__2);
				setState(175);
				expr(0);
				setState(176);
				match(T__3);
				}
				break;
			case 3:
				{
				_localctx = new FunctionInvocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(VARIABLE);
				setState(179);
				match(T__2);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 129288L) != 0)) {
					{
					setState(180);
					expr(0);
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(181);
						match(T__0);
						setState(182);
						expr(0);
						}
						}
						setState(187);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(190);
				match(T__3);
				}
				break;
			case 4:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(T__7);
				setState(192);
				expr(0);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(193);
					match(T__0);
					setState(194);
					expr(0);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__8);
				}
				break;
			case 5:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(VARIABLE);
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new FloatNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(FLOAT);
				}
				break;
			case 8:
				{
				_localctx = new IntegerNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new OperationMultDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(209);
						((OperationMultDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
							((OperationMultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(210);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new OperationPMContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(212);
						((OperationPMContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((OperationPMContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(213);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new OperationConditionalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(215);
						match(CONDITIONALS);
						setState(216);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00df\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0005\u0000\b\b\u0000\n\u0000\f\u0000\u000b"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0013\b\u0001\n\u0001\f\u0001\u0016\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001c\b\u0001\n\u0001"+
		"\f\u0001\u001f\t\u0001\u0003\u0001!\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001*\b"+
		"\u0001\n\u0001\f\u0001-\t\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0001\u0005"+
		"\u0001>\b\u0001\n\u0001\f\u0001A\t\u0001\u0003\u0001C\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001J\b\u0001"+
		"\u000b\u0001\f\u0001K\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001U\b\u0001\u000b\u0001"+
		"\f\u0001V\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\\\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001c\b"+
		"\u0001\u000b\u0001\f\u0001d\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001j\b\u0001\u0005\u0001l\b\u0001\n\u0001\f\u0001o\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001u\b\u0001\u000b\u0001"+
		"\f\u0001v\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001|\b\u0001\u0003"+
		"\u0001~\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001\u0086\b\u0001\u000b\u0001\f\u0001\u0087"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0096\b\u0001\u0003\u0001\u0098\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u009c\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0004\u0001\u00a2\b\u0001\u000b\u0001\f\u0001\u00a3\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00aa\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00b8\b\u0002\n\u0002\f\u0002\u00bb\t\u0002\u0003\u0002\u00bd\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00c4\b\u0002\n\u0002\f\u0002\u00c7\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00cf\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00da\b\u0002\n\u0002\f\u0002"+
		"\u00dd\t\u0002\u0001\u0002\u0000\u0001\u0004\u0003\u0000\u0002\u0004\u0000"+
		"\u0002\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0015\u0106\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0002\u00a9\u0001\u0000\u0000\u0000\u0004\u00ce\u0001"+
		"\u0000\u0000\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006\u0001\u0000"+
		"\u0000\u0000\b\u000b\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000\u0000"+
		"\u0000\t\n\u0001\u0000\u0000\u0000\n\f\u0001\u0000\u0000\u0000\u000b\t"+
		"\u0001\u0000\u0000\u0000\f\r\u0005\u0000\u0000\u0001\r\u0001\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0005\n\u0000\u0000\u000f\u0014\u0005\f\u0000"+
		"\u0000\u0010\u0011\u0005\u0001\u0000\u0000\u0011\u0013\u0005\f\u0000\u0000"+
		"\u0012\u0010\u0001\u0000\u0000\u0000\u0013\u0016\u0001\u0000\u0000\u0000"+
		"\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000"+
		"\u0015 \u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0005\u0002\u0000\u0000\u0018\u001d\u0003\u0004\u0002\u0000\u0019"+
		"\u001a\u0005\u0001\u0000\u0000\u001a\u001c\u0003\u0004\u0002\u0000\u001b"+
		"\u0019\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e"+
		"!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 \u0017\u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u00aa\u0001\u0000\u0000"+
		"\u0000\"#\u0005\f\u0000\u0000#$\u0005\u0002\u0000\u0000$+\u0003\u0004"+
		"\u0002\u0000%&\u0005\u0001\u0000\u0000&\'\u0005\f\u0000\u0000\'(\u0005"+
		"\u0002\u0000\u0000(*\u0003\u0004\u0002\u0000)%\u0001\u0000\u0000\u0000"+
		"*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,\u00aa\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.0\u0005"+
		" \u0000\u0000/1\u0005\n\u0000\u00000/\u0001\u0000\u0000\u000001\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0005\f\u0000\u00003B\u0005"+
		"\u0003\u0000\u000046\u0005\n\u0000\u000054\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u00007?\u0005\f\u0000\u00008:\u0005"+
		"\u0001\u0000\u00009;\u0005\n\u0000\u0000:9\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0005\f\u0000\u0000=8\u0001"+
		"\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000B5\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DE\u0005\u0004\u0000\u0000EF\u0005\u0005\u0000\u0000FG\u0005"+
		"(\u0000\u0000GI\u0005&\u0000\u0000HJ\u0003\u0002\u0001\u0000IH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0005\'\u0000\u0000N\u00aa"+
		"\u0001\u0000\u0000\u0000OP\u0005\u001d\u0000\u0000PQ\u0003\u0004\u0002"+
		"\u0000Q[\u0005\u0005\u0000\u0000RT\u0005&\u0000\u0000SU\u0003\u0002\u0001"+
		"\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005"+
		"\'\u0000\u0000Y\\\u0001\u0000\u0000\u0000Z\\\u0003\u0002\u0001\u0000["+
		"R\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\m\u0001\u0000\u0000"+
		"\u0000]^\u0005\u001e\u0000\u0000^_\u0003\u0004\u0002\u0000_i\u0005\u0005"+
		"\u0000\u0000`b\u0005&\u0000\u0000ac\u0003\u0002\u0001\u0000ba\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0005\'\u0000\u0000gj\u0001"+
		"\u0000\u0000\u0000hj\u0003\u0002\u0001\u0000i`\u0001\u0000\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000k]\u0001\u0000\u0000"+
		"\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000n}\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005"+
		"\u001f\u0000\u0000q{\u0005\u0005\u0000\u0000rt\u0005&\u0000\u0000su\u0003"+
		"\u0002\u0001\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000xy\u0005\'\u0000\u0000y|\u0001\u0000\u0000\u0000z|\u0003\u0002\u0001"+
		"\u0000{r\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|~\u0001\u0000"+
		"\u0000\u0000}p\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u00aa"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0005!\u0000\u0000\u0080\u0081\u0003"+
		"\u0004\u0002\u0000\u0081\u0082\u0005\u0005\u0000\u0000\u0082\u0083\u0005"+
		"(\u0000\u0000\u0083\u0085\u0005&\u0000\u0000\u0084\u0086\u0003\u0002\u0001"+
		"\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0005\'\u0000\u0000"+
		"\u008a\u00aa\u0001\u0000\u0000\u0000\u008b\u008c\u0005\"\u0000\u0000\u008c"+
		"\u008d\u0005\f\u0000\u0000\u008d\u009b\u0005\u0006\u0000\u0000\u008e\u009c"+
		"\u0005\f\u0000\u0000\u008f\u0090\u0005\u0007\u0000\u0000\u0090\u0097\u0003"+
		"\u0004\u0002\u0000\u0091\u0092\u0005\u0001\u0000\u0000\u0092\u0095\u0003"+
		"\u0004\u0002\u0000\u0093\u0094\u0005\u0001\u0000\u0000\u0094\u0096\u0003"+
		"\u0004\u0002\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001"+
		"\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0091\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0005\u0004\u0000\u0000\u009a\u009c\u0001"+
		"\u0000\u0000\u0000\u009b\u008e\u0001\u0000\u0000\u0000\u009b\u008f\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\u0005\u0000\u0000\u009e\u009f\u0005(\u0000\u0000\u009f\u00a1\u0005&\u0000"+
		"\u0000\u00a0\u00a2\u0003\u0002\u0001\u0000\u00a1\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0005\'\u0000\u0000\u00a6\u00aa\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0005#\u0000\u0000\u00a8\u00aa\u0003\u0004\u0002\u0000\u00a9"+
		"\u000e\u0001\u0000\u0000\u0000\u00a9\"\u0001\u0000\u0000\u0000\u00a9."+
		"\u0001\u0000\u0000\u0000\u00a9O\u0001\u0000\u0000\u0000\u00a9\u007f\u0001"+
		"\u0000\u0000\u0000\u00a9\u008b\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00aa\u0003\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006"+
		"\u0002\uffff\uffff\u0000\u00ac\u00ad\u0007\u0000\u0000\u0000\u00ad\u00cf"+
		"\u0003\u0004\u0002\u000b\u00ae\u00af\u0005\u0003\u0000\u0000\u00af\u00b0"+
		"\u0003\u0004\u0002\u0000\u00b0\u00b1\u0005\u0004\u0000\u0000\u00b1\u00cf"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\f\u0000\u0000\u00b3\u00bc\u0005"+
		"\u0003\u0000\u0000\u00b4\u00b9\u0003\u0004\u0002\u0000\u00b5\u00b6\u0005"+
		"\u0001\u0000\u0000\u00b6\u00b8\u0003\u0004\u0002\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00b4\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u00cf\u0005\u0004\u0000\u0000\u00bf\u00c0\u0005"+
		"\b\u0000\u0000\u00c0\u00c5\u0003\u0004\u0002\u0000\u00c1\u00c2\u0005\u0001"+
		"\u0000\u0000\u00c2\u00c4\u0003\u0004\u0002\u0000\u00c3\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\t\u0000"+
		"\u0000\u00c9\u00cf\u0001\u0000\u0000\u0000\u00ca\u00cf\u0005\f\u0000\u0000"+
		"\u00cb\u00cf\u0005\u000b\u0000\u0000\u00cc\u00cf\u0005\u000e\u0000\u0000"+
		"\u00cd\u00cf\u0005\r\u0000\u0000\u00ce\u00ab\u0001\u0000\u0000\u0000\u00ce"+
		"\u00ae\u0001\u0000\u0000\u0000\u00ce\u00b2\u0001\u0000\u0000\u0000\u00ce"+
		"\u00bf\u0001\u0000\u0000\u0000\u00ce\u00ca\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cf\u00db\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\n\t\u0000\u0000\u00d1\u00d2\u0007\u0001\u0000\u0000\u00d2\u00da"+
		"\u0003\u0004\u0002\n\u00d3\u00d4\n\b\u0000\u0000\u00d4\u00d5\u0007\u0000"+
		"\u0000\u0000\u00d5\u00da\u0003\u0004\u0002\t\u00d6\u00d7\n\u0007\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0016\u0000\u0000\u00d8\u00da\u0003\u0004\u0002"+
		"\b\u00d9\u00d0\u0001\u0000\u0000\u0000\u00d9\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d9\u00d6\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000"+
		"\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000"+
		"\u00dc\u0005\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u001f\t\u0014\u001d +05:?BKV[dimv{}\u0087\u0095\u0097\u009b\u00a3\u00a9"+
		"\u00b9\u00bc\u00c5\u00ce\u00d9\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}