// Generated from c:\Users\Guillermo\Desktop\SegundoSemestre\Compiladores\Proyecto3\GeneradorAssembly\Decaf.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, ID=38, NUM=39, 
		CHAR=40, WS=41, QUOTES=42, APOSTROPHE=43, CHAR_LITERAL=44;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_varDeclaration = 2, RULE_structDeclaration = 3, 
		RULE_varType = 4, RULE_methodDeclaration = 5, RULE_methodType = 6, RULE_parameter = 7, 
		RULE_parameterType = 8, RULE_block = 9, RULE_statement = 10, RULE_location = 11, 
		RULE_var_id = 12, RULE_array_id = 13, RULE_expression = 14, RULE_methodCall = 15, 
		RULE_arith_op_cmp = 16, RULE_arith_op_and = 17, RULE_arith_op_or = 18, 
		RULE_literal = 19, RULE_int_literal = 20, RULE_bool_literal = 21, RULE_char_literal = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "varDeclaration", "structDeclaration", "varType", 
			"methodDeclaration", "methodType", "parameter", "parameterType", "block", 
			"statement", "location", "var_id", "array_id", "expression", "methodCall", 
			"arith_op_cmp", "arith_op_and", "arith_op_or", "literal", "int_literal", 
			"bool_literal", "char_literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'Program'", "'{'", "'}'", "';'", "'['", "']'", "'struct'", 
			"'int'", "'boolean'", "'char'", "'void'", "'('", "','", "')'", "'if'", 
			"'else'", "'while'", "'return'", "'='", "'.'", "'-'", "'!'", "'*'", "'/'", 
			"'%'", "'+'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", 
			"'true'", "'false'", null, null, null, null, "'\"'", "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "NUM", "CHAR", "WS", "QUOTES", "APOSTROPHE", "CHAR_LITERAL"
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
	public String getGrammarFileName() { return "Decaf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			match(T__1);
			setState(48);
			match(T__2);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(49);
				declaration();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(T__3);
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

	public static class DeclarationContext extends ParserRuleContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				structDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				varDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				methodDeclaration();
				}
				break;
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDeclaration_ArrayContext extends VarDeclarationContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public TerminalNode NUM() { return getToken(DecafParser.NUM, 0); }
		public VarDeclaration_ArrayContext(VarDeclarationContext ctx) { copyFrom(ctx); }
	}
	public static class VarDeclaration_IDContext extends VarDeclarationContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public VarDeclaration_IDContext(VarDeclarationContext ctx) { copyFrom(ctx); }
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDeclaration);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDeclaration_IDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				varType();
				setState(63);
				match(ID);
				setState(64);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new VarDeclaration_ArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				varType();
				setState(67);
				match(ID);
				setState(68);
				match(T__5);
				setState(69);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUM) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(70);
				match(T__6);
				setState(71);
				match(T__4);
				}
				break;
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

	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__7);
			setState(76);
			match(ID);
			setState(77);
			match(T__2);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(78);
				varDeclaration();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__3);
			setState(85);
			match(T__4);
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

	public static class VarTypeContext extends ParserRuleContext {
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	 
		public VarTypeContext() { }
		public void copyFrom(VarTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarType_voidContext extends VarTypeContext {
		public VarType_voidContext(VarTypeContext ctx) { copyFrom(ctx); }
	}
	public static class VarType_intContext extends VarTypeContext {
		public VarType_intContext(VarTypeContext ctx) { copyFrom(ctx); }
	}
	public static class VarType_charContext extends VarTypeContext {
		public VarType_charContext(VarTypeContext ctx) { copyFrom(ctx); }
	}
	public static class VarType_structContext extends VarTypeContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public VarType_structContext(VarTypeContext ctx) { copyFrom(ctx); }
	}
	public static class VarType_structDeclarationContext extends VarTypeContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public VarType_structDeclarationContext(VarTypeContext ctx) { copyFrom(ctx); }
	}
	public static class VarType_booleanContext extends VarTypeContext {
		public VarType_booleanContext(VarTypeContext ctx) { copyFrom(ctx); }
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varType);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VarType_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(T__8);
				}
				break;
			case 2:
				_localctx = new VarType_booleanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__9);
				}
				break;
			case 3:
				_localctx = new VarType_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(T__10);
				}
				break;
			case 4:
				_localctx = new VarType_structContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				match(T__7);
				setState(91);
				match(ID);
				}
				break;
			case 5:
				_localctx = new VarType_structDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				structDeclaration();
				}
				break;
			case 6:
				_localctx = new VarType_voidContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				match(T__11);
				}
				break;
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			methodType();
			setState(97);
			match(ID);
			setState(98);
			match(T__12);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(99);
				parameter();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(100);
					match(T__13);
					setState(101);
					parameter();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(T__14);
			setState(113);
			block();
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

	public static class MethodTypeContext extends ParserRuleContext {
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
	 
		public MethodTypeContext() { }
		public void copyFrom(MethodTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodType_voidContext extends MethodTypeContext {
		public MethodType_voidContext(MethodTypeContext ctx) { copyFrom(ctx); }
	}
	public static class MethodType_intContext extends MethodTypeContext {
		public MethodType_intContext(MethodTypeContext ctx) { copyFrom(ctx); }
	}
	public static class MethodType_booleanContext extends MethodTypeContext {
		public MethodType_booleanContext(MethodTypeContext ctx) { copyFrom(ctx); }
	}
	public static class MethodType_charContext extends MethodTypeContext {
		public MethodType_charContext(MethodTypeContext ctx) { copyFrom(ctx); }
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodType);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new MethodType_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(T__8);
				}
				break;
			case T__10:
				_localctx = new MethodType_charContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__10);
				}
				break;
			case T__9:
				_localctx = new MethodType_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(T__9);
				}
				break;
			case T__11:
				_localctx = new MethodType_voidContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(T__11);
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

	public static class ParameterContext extends ParserRuleContext {
		public ParameterTypeContext parameterType() {
			return getRuleContext(ParameterTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				parameterType();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(122);
					match(ID);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				parameterType();
				setState(126);
				match(ID);
				setState(127);
				match(T__5);
				setState(128);
				match(T__6);
				}
				break;
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

	public static class ParameterTypeContext extends ParserRuleContext {
		public ParameterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterType; }
	 
		public ParameterTypeContext() { }
		public void copyFrom(ParameterTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParameterType_booleanContext extends ParameterTypeContext {
		public ParameterType_booleanContext(ParameterTypeContext ctx) { copyFrom(ctx); }
	}
	public static class ParameterType_charContext extends ParameterTypeContext {
		public ParameterType_charContext(ParameterTypeContext ctx) { copyFrom(ctx); }
	}
	public static class ParameterType_intContext extends ParameterTypeContext {
		public ParameterType_intContext(ParameterTypeContext ctx) { copyFrom(ctx); }
	}
	public static class ParameterType_voidContext extends ParameterTypeContext {
		public ParameterType_voidContext(ParameterTypeContext ctx) { copyFrom(ctx); }
	}

	public final ParameterTypeContext parameterType() throws RecognitionException {
		ParameterTypeContext _localctx = new ParameterTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterType);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new ParameterType_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T__8);
				}
				break;
			case T__10:
				_localctx = new ParameterType_charContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(T__10);
				}
				break;
			case T__9:
				_localctx = new ParameterType_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(T__9);
				}
				break;
			case T__11:
				_localctx = new ParameterType_voidContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(T__11);
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

	public static class BlockContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__2);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				{
				setState(139);
				varDeclaration();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__12) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				{
				setState(145);
				statement();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(T__3);
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
	public static class Statement_blockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Statement_blockContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class Statement_whileContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Statement_whileContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class Statement_methodCallContext extends StatementContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public Statement_methodCallContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class Statement_returnContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Statement_returnContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class Statement_ifContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Statement_ifContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class Statement_expressionContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Statement_expressionContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class Statement_assignValueContext extends StatementContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Statement_assignValueContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Statement_ifContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(T__15);
				setState(154);
				match(T__12);
				setState(155);
				expression(0);
				setState(156);
				match(T__14);
				setState(157);
				block();
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(158);
					match(T__16);
					setState(159);
					block();
					}
				}

				}
				break;
			case 2:
				_localctx = new Statement_whileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(T__17);
				setState(163);
				match(T__12);
				setState(164);
				expression(0);
				setState(165);
				match(T__14);
				setState(166);
				block();
				}
				break;
			case 3:
				_localctx = new Statement_returnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(T__18);
				setState(169);
				expression(0);
				setState(170);
				match(T__4);
				}
				break;
			case 4:
				_localctx = new Statement_methodCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				methodCall();
				setState(173);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new Statement_blockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				block();
				}
				break;
			case 6:
				_localctx = new Statement_assignValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				location();
				setState(177);
				match(T__19);
				setState(178);
				expression(0);
				setState(179);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new Statement_expressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
					{
					setState(181);
					expression(0);
					}
				}

				setState(184);
				match(T__4);
				}
				break;
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

	public static class LocationContext extends ParserRuleContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Array_idContext array_id() {
			return getRuleContext(Array_idContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(187);
				var_id();
				}
				break;
			case 2:
				{
				setState(188);
				array_id();
				}
				break;
			}
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(191);
				match(T__20);
				setState(192);
				location();
				}
				break;
			}
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

	public static class Var_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Var_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_id; }
	}

	public final Var_idContext var_id() throws RecognitionException {
		Var_idContext _localctx = new Var_idContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_var_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(ID);
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(196);
				match(T__20);
				setState(197);
				location();
				}
				break;
			}
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

	public static class Array_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Array_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_id; }
	}

	public final Array_idContext array_id() throws RecognitionException {
		Array_idContext _localctx = new Array_idContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ID);
			setState(201);
			match(T__5);
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(202);
				int_literal();
				}
				break;
			case ID:
				{
				setState(203);
				var_id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(206);
			match(T__6);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expression_SecondPrecedenceContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_SecondPrecedenceContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_literalContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Expression_literalContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_orContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Arith_op_orContext arith_op_or() {
			return getRuleContext(Arith_op_orContext.class,0);
		}
		public Expression_orContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_locationContext extends ExpressionContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Expression_locationContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_negative_intContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_negative_intContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_firstPrecedenceContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_firstPrecedenceContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_negate_boolContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_negate_boolContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_methodCallContext extends ExpressionContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public Expression_methodCallContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_parenthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_parenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_compareContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Arith_op_cmpContext arith_op_cmp() {
			return getRuleContext(Arith_op_cmpContext.class,0);
		}
		public Expression_compareContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class Expression_andContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Arith_op_andContext arith_op_and() {
			return getRuleContext(Arith_op_andContext.class,0);
		}
		public Expression_andContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new Expression_locationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(209);
				location();
				}
				break;
			case 2:
				{
				_localctx = new Expression_methodCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				methodCall();
				}
				break;
			case 3:
				{
				_localctx = new Expression_literalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				literal();
				}
				break;
			case 4:
				{
				_localctx = new Expression_negative_intContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(T__21);
				setState(213);
				expression(8);
				}
				break;
			case 5:
				{
				_localctx = new Expression_negate_boolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(T__22);
				setState(215);
				expression(7);
				}
				break;
			case 6:
				{
				_localctx = new Expression_parenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(T__12);
				setState(217);
				expression(0);
				setState(218);
				match(T__14);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new Expression_firstPrecedenceContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(223);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new Expression_SecondPrecedenceContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(226);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__26) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(227);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new Expression_compareContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						arith_op_cmp();
						setState(230);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new Expression_andContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(233);
						arith_op_and();
						setState(234);
						expression(3);
						}
						break;
					case 5:
						{
						_localctx = new Expression_orContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(237);
						arith_op_or();
						setState(238);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(ID);
			setState(246);
			match(T__12);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__21) | (1L << T__22) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				{
				setState(247);
				expression(0);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(248);
					match(T__13);
					}
				}

				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(T__14);
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

	public static class Arith_op_cmpContext extends ParserRuleContext {
		public Arith_op_cmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op_cmp; }
	}

	public final Arith_op_cmpContext arith_op_cmp() throws RecognitionException {
		Arith_op_cmpContext _localctx = new Arith_op_cmpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arith_op_cmp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Arith_op_andContext extends ParserRuleContext {
		public Arith_op_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op_and; }
	}

	public final Arith_op_andContext arith_op_and() throws RecognitionException {
		Arith_op_andContext _localctx = new Arith_op_andContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arith_op_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__33);
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

	public static class Arith_op_orContext extends ParserRuleContext {
		public Arith_op_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op_or; }
	}

	public final Arith_op_orContext arith_op_or() throws RecognitionException {
		Arith_op_orContext _localctx = new Arith_op_orContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arith_op_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__34);
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

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				int_literal();
				}
				break;
			case T__35:
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				bool_literal();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				char_literal();
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

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(DecafParser.NUM, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(NUM);
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

	public static class Bool_literalContext extends ParserRuleContext {
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(DecafParser.CHAR, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(CHAR);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0116\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\3\3\3\3\3\5\3?\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\7\5R\n\5"+
		"\f\5\16\5U\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\7\7n\n\7\f\7\16\7q\13\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\5\bz\n\b\3\t\3\t\5\t~\n\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u0085\n\t\3\n\3\n\3\n\3\n\5\n\u008b\n\n\3\13\3\13\7\13\u008f\n\13"+
		"\f\13\16\13\u0092\13\13\3\13\7\13\u0095\n\13\f\13\16\13\u0098\13\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a3\n\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b9"+
		"\n\f\3\f\5\f\u00bc\n\f\3\r\3\r\5\r\u00c0\n\r\3\r\3\r\5\r\u00c4\n\r\3\16"+
		"\3\16\3\16\5\16\u00c9\n\16\3\17\3\17\3\17\3\17\5\17\u00cf\n\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00df"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00f3\n\20\f\20\16\20\u00f6\13\20\3\21"+
		"\3\21\3\21\3\21\5\21\u00fc\n\21\7\21\u00fe\n\21\f\21\16\21\u0101\13\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\5\25\u010e\n\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\2\3\36\31\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\2\7\3\2()\3\2\32\34\4\2\30\30\35\35\3\2\36#\3"+
		"\2&\'\2\u012e\2\60\3\2\2\2\4>\3\2\2\2\6K\3\2\2\2\bM\3\2\2\2\n`\3\2\2\2"+
		"\fb\3\2\2\2\16y\3\2\2\2\20\u0084\3\2\2\2\22\u008a\3\2\2\2\24\u008c\3\2"+
		"\2\2\26\u00bb\3\2\2\2\30\u00bf\3\2\2\2\32\u00c5\3\2\2\2\34\u00ca\3\2\2"+
		"\2\36\u00de\3\2\2\2 \u00f7\3\2\2\2\"\u0104\3\2\2\2$\u0106\3\2\2\2&\u0108"+
		"\3\2\2\2(\u010d\3\2\2\2*\u010f\3\2\2\2,\u0111\3\2\2\2.\u0113\3\2\2\2\60"+
		"\61\7\3\2\2\61\62\7\4\2\2\62\66\7\5\2\2\63\65\5\4\3\2\64\63\3\2\2\2\65"+
		"8\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\6\2"+
		"\2:\3\3\2\2\2;?\5\b\5\2<?\5\6\4\2=?\5\f\7\2>;\3\2\2\2><\3\2\2\2>=\3\2"+
		"\2\2?\5\3\2\2\2@A\5\n\6\2AB\7(\2\2BC\7\7\2\2CL\3\2\2\2DE\5\n\6\2EF\7("+
		"\2\2FG\7\b\2\2GH\t\2\2\2HI\7\t\2\2IJ\7\7\2\2JL\3\2\2\2K@\3\2\2\2KD\3\2"+
		"\2\2L\7\3\2\2\2MN\7\n\2\2NO\7(\2\2OS\7\5\2\2PR\5\6\4\2QP\3\2\2\2RU\3\2"+
		"\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\6\2\2WX\7\7\2\2X\t\3"+
		"\2\2\2Ya\7\13\2\2Za\7\f\2\2[a\7\r\2\2\\]\7\n\2\2]a\7(\2\2^a\5\b\5\2_a"+
		"\7\16\2\2`Y\3\2\2\2`Z\3\2\2\2`[\3\2\2\2`\\\3\2\2\2`^\3\2\2\2`_\3\2\2\2"+
		"a\13\3\2\2\2bc\5\16\b\2cd\7(\2\2do\7\17\2\2ej\5\20\t\2fg\7\20\2\2gi\5"+
		"\20\t\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2kn\3\2\2\2lj\3\2\2\2me"+
		"\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\21\2\2"+
		"st\5\24\13\2t\r\3\2\2\2uz\7\13\2\2vz\7\r\2\2wz\7\f\2\2xz\7\16\2\2yu\3"+
		"\2\2\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z\17\3\2\2\2{}\5\22\n\2|~\7(\2\2}"+
		"|\3\2\2\2}~\3\2\2\2~\u0085\3\2\2\2\177\u0080\5\22\n\2\u0080\u0081\7(\2"+
		"\2\u0081\u0082\7\b\2\2\u0082\u0083\7\t\2\2\u0083\u0085\3\2\2\2\u0084{"+
		"\3\2\2\2\u0084\177\3\2\2\2\u0085\21\3\2\2\2\u0086\u008b\7\13\2\2\u0087"+
		"\u008b\7\r\2\2\u0088\u008b\7\f\2\2\u0089\u008b\7\16\2\2\u008a\u0086\3"+
		"\2\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\23\3\2\2\2\u008c\u0090\7\5\2\2\u008d\u008f\5\6\4\2\u008e\u008d\3\2\2"+
		"\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0096"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\5\26\f\2\u0094\u0093\3\2\2\2"+
		"\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\6\2\2\u009a\25\3\2\2\2\u009b"+
		"\u009c\7\22\2\2\u009c\u009d\7\17\2\2\u009d\u009e\5\36\20\2\u009e\u009f"+
		"\7\21\2\2\u009f\u00a2\5\24\13\2\u00a0\u00a1\7\23\2\2\u00a1\u00a3\5\24"+
		"\13\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00bc\3\2\2\2\u00a4"+
		"\u00a5\7\24\2\2\u00a5\u00a6\7\17\2\2\u00a6\u00a7\5\36\20\2\u00a7\u00a8"+
		"\7\21\2\2\u00a8\u00a9\5\24\13\2\u00a9\u00bc\3\2\2\2\u00aa\u00ab\7\25\2"+
		"\2\u00ab\u00ac\5\36\20\2\u00ac\u00ad\7\7\2\2\u00ad\u00bc\3\2\2\2\u00ae"+
		"\u00af\5 \21\2\u00af\u00b0\7\7\2\2\u00b0\u00bc\3\2\2\2\u00b1\u00bc\5\24"+
		"\13\2\u00b2\u00b3\5\30\r\2\u00b3\u00b4\7\26\2\2\u00b4\u00b5\5\36\20\2"+
		"\u00b5\u00b6\7\7\2\2\u00b6\u00bc\3\2\2\2\u00b7\u00b9\5\36\20\2\u00b8\u00b7"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\7\7\2\2\u00bb"+
		"\u009b\3\2\2\2\u00bb\u00a4\3\2\2\2\u00bb\u00aa\3\2\2\2\u00bb\u00ae\3\2"+
		"\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00b2\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bc"+
		"\27\3\2\2\2\u00bd\u00c0\5\32\16\2\u00be\u00c0\5\34\17\2\u00bf\u00bd\3"+
		"\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00c2\7\27\2\2\u00c2"+
		"\u00c4\5\30\r\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\31\3\2\2"+
		"\2\u00c5\u00c8\7(\2\2\u00c6\u00c7\7\27\2\2\u00c7\u00c9\5\30\r\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\33\3\2\2\2\u00ca\u00cb\7(\2\2"+
		"\u00cb\u00ce\7\b\2\2\u00cc\u00cf\5*\26\2\u00cd\u00cf\5\32\16\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\t\2\2\u00d1"+
		"\35\3\2\2\2\u00d2\u00d3\b\20\1\2\u00d3\u00df\5\30\r\2\u00d4\u00df\5 \21"+
		"\2\u00d5\u00df\5(\25\2\u00d6\u00d7\7\30\2\2\u00d7\u00df\5\36\20\n\u00d8"+
		"\u00d9\7\31\2\2\u00d9\u00df\5\36\20\t\u00da\u00db\7\17\2\2\u00db\u00dc"+
		"\5\36\20\2\u00dc\u00dd\7\21\2\2\u00dd\u00df\3\2\2\2\u00de\u00d2\3\2\2"+
		"\2\u00de\u00d4\3\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d6\3\2\2\2\u00de\u00d8"+
		"\3\2\2\2\u00de\u00da\3\2\2\2\u00df\u00f4\3\2\2\2\u00e0\u00e1\f\7\2\2\u00e1"+
		"\u00e2\t\3\2\2\u00e2\u00f3\5\36\20\b\u00e3\u00e4\f\6\2\2\u00e4\u00e5\t"+
		"\4\2\2\u00e5\u00f3\5\36\20\7\u00e6\u00e7\f\5\2\2\u00e7\u00e8\5\"\22\2"+
		"\u00e8\u00e9\5\36\20\6\u00e9\u00f3\3\2\2\2\u00ea\u00eb\f\4\2\2\u00eb\u00ec"+
		"\5$\23\2\u00ec\u00ed\5\36\20\5\u00ed\u00f3\3\2\2\2\u00ee\u00ef\f\3\2\2"+
		"\u00ef\u00f0\5&\24\2\u00f0\u00f1\5\36\20\4\u00f1\u00f3\3\2\2\2\u00f2\u00e0"+
		"\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00e6\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f2"+
		"\u00ee\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\37\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7(\2\2\u00f8\u00ff"+
		"\7\17\2\2\u00f9\u00fb\5\36\20\2\u00fa\u00fc\7\20\2\2\u00fb\u00fa\3\2\2"+
		"\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe\u0101"+
		"\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\7\21\2\2\u0103!\3\2\2\2\u0104\u0105\t\5\2\2"+
		"\u0105#\3\2\2\2\u0106\u0107\7$\2\2\u0107%\3\2\2\2\u0108\u0109\7%\2\2\u0109"+
		"\'\3\2\2\2\u010a\u010e\5*\26\2\u010b\u010e\5,\27\2\u010c\u010e\5.\30\2"+
		"\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e)\3"+
		"\2\2\2\u010f\u0110\7)\2\2\u0110+\3\2\2\2\u0111\u0112\t\6\2\2\u0112-\3"+
		"\2\2\2\u0113\u0114\7*\2\2\u0114/\3\2\2\2\34\66>KS`joy}\u0084\u008a\u0090"+
		"\u0096\u00a2\u00b8\u00bb\u00bf\u00c3\u00c8\u00ce\u00de\u00f2\u00f4\u00fb"+
		"\u00ff\u010d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}