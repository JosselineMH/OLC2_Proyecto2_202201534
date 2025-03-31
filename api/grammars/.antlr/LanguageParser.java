// Generated from /home/josseline/Escritorio/GoLight/api/grammars/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, INT=58, BOOL=59, FLOAT=60, 
		STRING=61, RUNE=62, ID=63, WS=64, COMENTARIOLINEA=65, COMENTARIOMULTIL=66;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_declaracionVariable = 2, RULE_declaracionFuncForanea = 3, 
		RULE_parametros = 4, RULE_tipoFunc = 5, RULE_slice = 6, RULE_elementosSlice = 7, 
		RULE_elementoSlice = 8, RULE_structDecl = 9, RULE_atributoStruct = 10, 
		RULE_sentencia = 11, RULE_stmtCase = 12, RULE_stmtDefault = 13, RULE_forInit = 14, 
		RULE_expresion = 15, RULE_atributoInstancia = 16, RULE_call = 17, RULE_args = 18, 
		RULE_tipoDeclaracion = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "declaracionVariable", "declaracionFuncForanea", "parametros", 
			"tipoFunc", "slice", "elementosSlice", "elementoSlice", "structDecl", 
			"atributoStruct", "sentencia", "stmtCase", "stmtDefault", "forInit", 
			"expresion", "atributoInstancia", "call", "args", "tipoDeclaracion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'var'", "'='", "':='", "'func'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "','", "'type'", "'struct'", "'fmt.Println('", "'if'", 
			"'else'", "'switch'", "'for'", "'range'", "'break'", "'continue'", "'return'", 
			"'case'", "':'", "'default'", "'strconv.Atoi('", "'strconv.ParseFloat('", 
			"'reflect.TypeOf('", "'slices.Index('", "'strings.Join('", "'len('", 
			"'append('", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+='", 
			"'-='", "'.'", "'int'", "'float64'", "'string'", "'bool'", "'rune'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "INT", "BOOL", 
			"FLOAT", "STRING", "RUNE", "ID", "WS", "COMENTARIOLINEA", "COMENTARIOMULTIL"
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307550878364L) != 0)) {
				{
				{
				setState(40);
				dcl();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DclContext extends ParserRuleContext {
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public DeclaracionFuncForaneaContext declaracionFuncForanea() {
			return getRuleContext(DeclaracionFuncForaneaContext.class,0);
		}
		public StructDeclContext structDecl() {
			return getRuleContext(StructDeclContext.class,0);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				declaracionVariable();
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(47);
					match(T__0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				declaracionFuncForanea();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				structDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				sentencia();
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(53);
					match(T__0);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionVariableContext extends ParserRuleContext {
		public DeclaracionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionVariable; }
	 
		public DeclaracionVariableContext() { }
		public void copyFrom(DeclaracionVariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSliceContext extends DeclaracionVariableContext {
		public SliceContext slice() {
			return getRuleContext(SliceContext.class,0);
		}
		public DeclaracionSliceContext(DeclaracionVariableContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionPorDefectoContext extends DeclaracionVariableContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public DeclaracionPorDefectoContext(DeclaracionVariableContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionExplicitaContext extends DeclaracionVariableContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionExplicitaContext(DeclaracionVariableContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionImplicitaContext extends DeclaracionVariableContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionImplicitaContext(DeclaracionVariableContext ctx) { copyFrom(ctx); }
	}

	public final DeclaracionVariableContext declaracionVariable() throws RecognitionException {
		DeclaracionVariableContext _localctx = new DeclaracionVariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracionVariable);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__1);
				setState(59);
				match(ID);
				setState(60);
				tipoDeclaracion();
				setState(61);
				match(T__2);
				setState(62);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__1);
				setState(65);
				match(ID);
				setState(66);
				tipoDeclaracion();
				}
				break;
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(ID);
				setState(68);
				match(T__3);
				setState(69);
				expresion(0);
				}
				break;
			case 4:
				_localctx = new DeclaracionSliceContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				slice();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionFuncForaneaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public DeclaracionFuncForaneaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionFuncForanea; }
	}

	public final DeclaracionFuncForaneaContext declaracionFuncForanea() throws RecognitionException {
		DeclaracionFuncForaneaContext _localctx = new DeclaracionFuncForaneaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracionFuncForanea);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__4);
			setState(74);
			match(ID);
			setState(75);
			match(T__5);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(76);
				parametros();
				}
			}

			setState(79);
			match(T__6);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279223176896970752L) != 0)) {
				{
				setState(80);
				tipoDeclaracion();
				}
			}

			setState(83);
			match(T__7);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307550878364L) != 0)) {
				{
				{
				setState(84);
				dcl();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(T__8);
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public List<TipoFuncContext> tipoFunc() {
			return getRuleContexts(TipoFuncContext.class);
		}
		public TipoFuncContext tipoFunc(int i) {
			return getRuleContext(TipoFuncContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(93);
				match(T__9);
				setState(94);
				match(T__10);
				}
			}

			setState(97);
			tipoFunc();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(98);
				match(T__11);
				setState(99);
				match(ID);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(100);
					match(T__9);
					setState(101);
					match(T__10);
					}
				}

				setState(104);
				tipoFunc();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoFuncContext extends ParserRuleContext {
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TipoFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoFunc; }
	}

	public final TipoFuncContext tipoFunc() throws RecognitionException {
		TipoFuncContext _localctx = new TipoFuncContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipoFunc);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				tipoDeclaracion();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(ID);
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
	public static class SliceContext extends ParserRuleContext {
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
	 
		public SliceContext() { }
		public void copyFrom(SliceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSliceVacioContext extends SliceContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public DeclaracionSliceVacioContext(SliceContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSliceMultidimensionalContext extends SliceContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public ElementosSliceContext elementosSlice() {
			return getRuleContext(ElementosSliceContext.class,0);
		}
		public DeclaracionSliceMultidimensionalContext(SliceContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSliceValoresContext extends SliceContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionSliceValoresContext(SliceContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSliceCopiaContext extends SliceContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public DeclaracionSliceCopiaContext(SliceContext ctx) { copyFrom(ctx); }
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_slice);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new DeclaracionSliceValoresContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(ID);
				setState(115);
				match(T__3);
				setState(116);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new DeclaracionSliceVacioContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(T__1);
				setState(118);
				match(ID);
				setState(119);
				match(T__9);
				setState(120);
				match(T__10);
				setState(121);
				tipoDeclaracion();
				}
				break;
			case 3:
				_localctx = new DeclaracionSliceCopiaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(ID);
				setState(123);
				match(T__2);
				setState(124);
				match(ID);
				}
				break;
			case 4:
				_localctx = new DeclaracionSliceMultidimensionalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				match(ID);
				setState(126);
				match(T__3);
				setState(127);
				match(T__9);
				setState(128);
				match(T__10);
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					match(T__9);
					setState(130);
					match(T__10);
					}
					}
					setState(133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(135);
				tipoDeclaracion();
				setState(136);
				match(T__7);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(137);
					elementosSlice();
					}
				}

				setState(140);
				match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementosSliceContext extends ParserRuleContext {
		public List<ElementoSliceContext> elementoSlice() {
			return getRuleContexts(ElementoSliceContext.class);
		}
		public ElementoSliceContext elementoSlice(int i) {
			return getRuleContext(ElementoSliceContext.class,i);
		}
		public ElementosSliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementosSlice; }
	}

	public final ElementosSliceContext elementosSlice() throws RecognitionException {
		ElementosSliceContext _localctx = new ElementosSliceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elementosSlice);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			elementoSlice();
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					match(T__11);
					setState(146);
					elementoSlice();
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(152);
				match(T__11);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementoSliceContext extends ParserRuleContext {
		public ElementosSliceContext elementosSlice() {
			return getRuleContext(ElementosSliceContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ElementoSliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementoSlice; }
	}

	public final ElementoSliceContext elementoSlice() throws RecognitionException {
		ElementoSliceContext _localctx = new ElementoSliceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elementoSlice);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(T__7);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(156);
					elementosSlice();
					}
				}

				setState(159);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(T__7);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307566451648L) != 0)) {
					{
					setState(161);
					expresion(0);
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__11) {
						{
						{
						setState(162);
						match(T__11);
						setState(163);
						expresion(0);
						}
						}
						setState(168);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(171);
				match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<AtributoStructContext> atributoStruct() {
			return getRuleContexts(AtributoStructContext.class);
		}
		public AtributoStructContext atributoStruct(int i) {
			return getRuleContext(AtributoStructContext.class,i);
		}
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__12);
			setState(175);
			match(ID);
			setState(176);
			match(T__13);
			setState(177);
			match(T__7);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(178);
				atributoStruct();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
			match(T__8);
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
	public static class AtributoStructContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TipoFuncContext tipoFunc() {
			return getRuleContext(TipoFuncContext.class,0);
		}
		public AtributoStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributoStruct; }
	}

	public final AtributoStructContext atributoStruct() throws RecognitionException {
		AtributoStructContext _localctx = new AtributoStructContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atributoStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(ID);
			setState(187);
			tipoFunc();
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
	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends SentenciaContext {
		public ContinueStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<StmtCaseContext> stmtCase() {
			return getRuleContexts(StmtCaseContext.class);
		}
		public StmtCaseContext stmtCase(int i) {
			return getRuleContext(StmtCaseContext.class,i);
		}
		public StmtDefaultContext stmtDefault() {
			return getRuleContext(StmtDefaultContext.class,0);
		}
		public SwitchStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends SentenciaContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public PrintStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public IfStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends SentenciaContext {
		public BreakStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends SentenciaContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BlockStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForRangeStmtContext extends SentenciaContext {
		public Token indice;
		public Token valor;
		public Token ident;
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public ForRangeStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForWhileStmtContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public ForWhileStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends SentenciaContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public ForStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ReturnStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencia);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__14);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307566451648L) != 0)) {
					{
					setState(191);
					expresion(0);
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__11) {
						{
						{
						setState(192);
						match(T__11);
						setState(193);
						expresion(0);
						}
						}
						setState(198);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(201);
				match(T__6);
				}
				break;
			case 3:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(T__7);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307550878364L) != 0)) {
					{
					{
					setState(203);
					dcl();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(210);
				match(T__15);
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(211);
					match(T__5);
					}
					break;
				}
				setState(214);
				expresion(0);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(215);
					match(T__6);
					}
				}

				setState(218);
				sentencia();
				setState(221);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(219);
					match(T__16);
					setState(220);
					sentencia();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(223);
				match(T__17);
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(224);
					match(T__5);
					}
					break;
				}
				setState(227);
				expresion(0);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(228);
					match(T__6);
					}
				}

				setState(231);
				match(T__7);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(232);
					stmtCase();
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(238);
					stmtDefault();
					}
				}

				setState(241);
				match(T__8);
				}
				break;
			case 6:
				_localctx = new ForWhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				match(T__18);
				setState(245);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(244);
					match(T__5);
					}
					break;
				}
				setState(247);
				expresion(0);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(248);
					match(T__6);
					}
				}

				setState(251);
				sentencia();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				match(T__18);
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(254);
					match(T__5);
					}
					break;
				}
				setState(257);
				forInit();
				setState(258);
				expresion(0);
				setState(259);
				match(T__0);
				setState(260);
				expresion(0);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(261);
					match(T__6);
					}
				}

				setState(264);
				sentencia();
				}
				break;
			case 8:
				_localctx = new ForRangeStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(266);
				match(T__18);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(267);
					match(T__5);
					}
				}

				setState(270);
				((ForRangeStmtContext)_localctx).indice = match(ID);
				setState(271);
				match(T__11);
				setState(272);
				((ForRangeStmtContext)_localctx).valor = match(ID);
				setState(273);
				match(T__3);
				setState(274);
				match(T__19);
				setState(275);
				((ForRangeStmtContext)_localctx).ident = match(ID);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(276);
					match(T__6);
					}
				}

				setState(279);
				sentencia();
				}
				break;
			case 9:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(280);
				match(T__20);
				}
				break;
			case 10:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(281);
				match(T__21);
				}
				break;
			case 11:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(282);
				match(T__22);
				setState(284);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(283);
					expresion(0);
					}
					break;
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtCaseContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public StmtCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtCase; }
	}

	public final StmtCaseContext stmtCase() throws RecognitionException {
		StmtCaseContext _localctx = new StmtCaseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmtCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__23);
			setState(289);
			expresion(0);
			setState(290);
			match(T__24);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307550878364L) != 0)) {
				{
				{
				setState(291);
				dcl();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtDefaultContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public StmtDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtDefault; }
	}

	public final StmtDefaultContext stmtDefault() throws RecognitionException {
		StmtDefaultContext _localctx = new StmtDefaultContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmtDefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__25);
			setState(298);
			match(T__24);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307550878364L) != 0)) {
				{
				{
				setState(299);
				dcl();
				}
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forInit);
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				declaracionVariable();
				setState(306);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				expresion(0);
				setState(309);
				match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignSliceContext extends ExpresionContext {
		public ExpresionContext indice;
		public ExpresionContext valor;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AssignSliceContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CalleeContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public CalleeContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceLenFuncContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SliceLenFuncContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceLiteralContext extends ExpresionContext {
		public TipoDeclaracionContext tipoDeclaracion() {
			return getRuleContext(TipoDeclaracionContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SliceLiteralContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ParensContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExpresionContext {
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public StringContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public LogicalOrContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalNotContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public LogicalNotContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructAccessContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public StructAccessContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public MulDivModContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmebbedFuncAtoiContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public EmebbedFuncAtoiContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ExpresionContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public NumberContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructAssignContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public StructAssignContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public LogicalAndContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public EqualityContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceStringFuncJoinContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SliceStringFuncJoinContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExpresionContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public BooleanContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceAccessContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SliceAccessContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructInstanciaContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<AtributoInstanciaContext> atributoInstancia() {
			return getRuleContexts(AtributoInstanciaContext.class);
		}
		public AtributoInstanciaContext atributoInstancia(int i) {
			return getRuleContext(AtributoInstanciaContext.class,i);
		}
		public StructInstanciaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AddSubContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignVarContext extends ExpresionContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AssignVarContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public RelationalContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceMatrixAccessContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SliceMatrixAccessContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmebbedFuncParseFloatContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public EmebbedFuncParseFloatContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceFuncIndexContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SliceFuncIndexContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExpresionContext {
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public FloatContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignSliceMultidimensionalContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AssignSliceMultidimensionalContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceAppendFuncContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SliceAppendFuncContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmebbedFuncTypeOfContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public EmebbedFuncTypeOfContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public NegateContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncrementDecrementContext extends ExpresionContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IncrementDecrementContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuneContext extends ExpresionContext {
		public TerminalNode RUNE() { return getToken(LanguageParser.RUNE, 0); }
		public RuneContext(ExpresionContext ctx) { copyFrom(ctx); }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				_localctx = new EmebbedFuncAtoiContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(314);
				match(T__26);
				setState(315);
				expresion(0);
				setState(316);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new EmebbedFuncParseFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				match(T__27);
				setState(319);
				expresion(0);
				setState(320);
				match(T__6);
				}
				break;
			case 3:
				{
				_localctx = new EmebbedFuncTypeOfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(322);
				match(T__28);
				setState(323);
				expresion(0);
				setState(324);
				match(T__6);
				}
				break;
			case 4:
				{
				_localctx = new SliceFuncIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326);
				match(T__29);
				setState(327);
				match(ID);
				setState(328);
				match(T__11);
				setState(329);
				expresion(0);
				setState(330);
				match(T__6);
				}
				break;
			case 5:
				{
				_localctx = new SliceStringFuncJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				match(T__30);
				setState(333);
				match(ID);
				setState(334);
				match(T__11);
				setState(335);
				expresion(0);
				setState(336);
				match(T__6);
				}
				break;
			case 6:
				{
				_localctx = new SliceLenFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(338);
				match(T__31);
				setState(339);
				expresion(0);
				setState(340);
				match(T__6);
				}
				break;
			case 7:
				{
				_localctx = new SliceAppendFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342);
				match(T__32);
				setState(343);
				match(ID);
				setState(344);
				match(T__11);
				setState(345);
				expresion(0);
				setState(346);
				match(T__6);
				}
				break;
			case 8:
				{
				_localctx = new SliceAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(348);
				match(ID);
				setState(349);
				match(T__9);
				setState(350);
				expresion(0);
				setState(351);
				match(T__10);
				}
				break;
			case 9:
				{
				_localctx = new SliceMatrixAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353);
				match(ID);
				setState(358); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(354);
						match(T__9);
						setState(355);
						expresion(0);
						setState(356);
						match(T__10);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(360); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362);
				match(T__33);
				setState(363);
				expresion(24);
				}
				break;
			case 11:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				match(T__34);
				setState(365);
				expresion(22);
				}
				break;
			case 12:
				{
				_localctx = new IncrementDecrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(366);
				match(ID);
				setState(367);
				((IncrementDecrementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__47 || _la==T__48) ) {
					((IncrementDecrementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 13:
				{
				_localctx = new AssignVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(368);
				match(ID);
				setState(369);
				((AssignVarContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3377699720527880L) != 0)) ) {
					((AssignVarContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(370);
				expresion(14);
				}
				break;
			case 14:
				{
				_localctx = new AssignSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				match(ID);
				setState(372);
				match(T__9);
				setState(373);
				((AssignSliceContext)_localctx).indice = expresion(0);
				setState(374);
				match(T__10);
				setState(375);
				match(T__2);
				setState(376);
				((AssignSliceContext)_localctx).valor = expresion(13);
				}
				break;
			case 15:
				{
				_localctx = new AssignSliceMultidimensionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(378);
				match(ID);
				setState(383); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(379);
					match(T__9);
					setState(380);
					expresion(0);
					setState(381);
					match(T__10);
					}
					}
					setState(385); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(387);
				match(T__2);
				setState(388);
				expresion(12);
				}
				break;
			case 16:
				{
				_localctx = new SliceLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(390);
				match(T__9);
				setState(391);
				match(T__10);
				setState(392);
				tipoDeclaracion();
				setState(393);
				match(T__7);
				setState(394);
				expresion(0);
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(395);
					match(T__11);
					setState(396);
					expresion(0);
					}
					}
					setState(401);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(402);
				match(T__8);
				}
				break;
			case 17:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(404);
				match(BOOL);
				}
				break;
			case 18:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				match(FLOAT);
				}
				break;
			case 19:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(406);
				match(RUNE);
				}
				break;
			case 20:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(407);
				match(STRING);
				}
				break;
			case 21:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408);
				match(INT);
				}
				break;
			case 22:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				match(ID);
				}
				break;
			case 23:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410);
				match(T__5);
				setState(411);
				expresion(0);
				setState(412);
				match(T__6);
				}
				break;
			case 24:
				{
				_localctx = new StructInstanciaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				match(ID);
				setState(415);
				match(T__7);
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(416);
					atributoInstancia();
					}
					}
					setState(421);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(422);
				match(T__8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(461);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(425);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(426);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(427);
						expresion(22);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(428);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(429);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__38) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(430);
						expresion(21);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(431);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(432);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(433);
						expresion(20);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(434);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(435);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__43 || _la==T__44) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(436);
						expresion(19);
						}
						break;
					case 5:
						{
						_localctx = new LogicalAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(437);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(438);
						((LogicalAndContext)_localctx).op = match(T__45);
						setState(439);
						expresion(18);
						}
						break;
					case 6:
						{
						_localctx = new LogicalOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(440);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(441);
						((LogicalOrContext)_localctx).op = match(T__46);
						setState(442);
						expresion(17);
						}
						break;
					case 7:
						{
						_localctx = new StructAssignContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(443);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(446); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(444);
							match(T__51);
							setState(445);
							match(ID);
							}
							}
							setState(448); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==T__51 );
						setState(450);
						match(T__2);
						setState(451);
						expresion(4);
						}
						break;
					case 8:
						{
						_localctx = new CalleeContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(452);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(454); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(453);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(456); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 9:
						{
						_localctx = new StructAccessContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(458);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(459);
						match(T__51);
						setState(460);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtributoInstanciaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AtributoInstanciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributoInstancia; }
	}

	public final AtributoInstanciaContext atributoInstancia() throws RecognitionException {
		AtributoInstanciaContext _localctx = new AtributoInstanciaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atributoInstancia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(ID);
			setState(467);
			match(T__24);
			setState(468);
			expresion(0);
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(469);
				match(T__11);
				setState(470);
				match(ID);
				setState(471);
				match(T__24);
				setState(472);
				expresion(0);
				}
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(T__5);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230307566451648L) != 0)) {
				{
				setState(479);
				args();
				}
			}

			setState(482);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			expresion(0);
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(485);
				match(T__11);
				setState(486);
				expresion(0);
				}
				}
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoDeclaracionContext extends ParserRuleContext {
		public TipoDeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDeclaracion; }
	}

	public final TipoDeclaracionContext tipoDeclaracion() throws RecognitionException {
		TipoDeclaracionContext _localctx = new TipoDeclaracionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tipoDeclaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 279223176896970752L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 21);
		case 1:
			return precpred(_ctx, 20);
		case 2:
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 23);
		case 8:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001B\u01ef\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u00017\b\u0001\u0003\u00019\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003N\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"R\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003V\b\u0003\n\u0003\f\u0003"+
		"Y\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004`\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004g\b\u0004\u0001\u0004\u0005\u0004j\b\u0004\n\u0004"+
		"\f\u0004m\t\u0004\u0001\u0005\u0001\u0005\u0003\u0005q\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u0084\b\u0006"+
		"\u000b\u0006\f\u0006\u0085\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u008b\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u008f\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0094\b\u0007\n\u0007\f\u0007"+
		"\u0097\t\u0007\u0001\u0007\u0003\u0007\u009a\b\u0007\u0001\b\u0001\b\u0003"+
		"\b\u009e\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a5\b\b"+
		"\n\b\f\b\u00a8\t\b\u0003\b\u00aa\b\b\u0001\b\u0003\b\u00ad\b\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00b4\b\t\n\t\f\t\u00b7\t\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00c3\b\u000b\n\u000b\f\u000b\u00c6"+
		"\t\u000b\u0003\u000b\u00c8\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00cd\b\u000b\n\u000b\f\u000b\u00d0\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00d5\b\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00d9\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00de"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e2\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00e6\b\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00ea\b\u000b\n\u000b\f\u000b\u00ed\t\u000b\u0001\u000b\u0003\u000b\u00f0"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f6"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00fa\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0100\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0107\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u010d\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0116\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u011d\b\u000b\u0003\u000b\u011f\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0125\b\f\n\f\f\f\u0128"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u012d\b\r\n\r\f\r\u0130\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0138\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u0167"+
		"\b\u000f\u000b\u000f\f\u000f\u0168\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0004\u000f\u0180\b\u000f\u000b\u000f\f\u000f\u0181\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u018e\b\u000f\n\u000f\f\u000f"+
		"\u0191\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01a2\b\u000f"+
		"\n\u000f\f\u000f\u01a5\t\u000f\u0001\u000f\u0003\u000f\u01a8\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u01bf\b\u000f\u000b\u000f\f"+
		"\u000f\u01c0\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f"+
		"\u01c7\b\u000f\u000b\u000f\f\u000f\u01c8\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u01ce\b\u000f\n\u000f\f\u000f\u01d1\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u01da\b\u0010\n\u0010\f\u0010\u01dd\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u01e1\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u01e8\b\u0012\n\u0012\f\u0012\u01eb\t\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0000\u0001\u001e\u0014\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&\u0000\u0007\u0001\u000001\u0002\u0000\u0003\u000323\u0001\u0000"+
		"$&\u0002\u0000\"\"\'\'\u0001\u0000(+\u0001\u0000,-\u0001\u000059\u023d"+
		"\u0000+\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004G"+
		"\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\b\\\u0001\u0000"+
		"\u0000\u0000\np\u0001\u0000\u0000\u0000\f\u008e\u0001\u0000\u0000\u0000"+
		"\u000e\u0090\u0001\u0000\u0000\u0000\u0010\u00ac\u0001\u0000\u0000\u0000"+
		"\u0012\u00ae\u0001\u0000\u0000\u0000\u0014\u00ba\u0001\u0000\u0000\u0000"+
		"\u0016\u011e\u0001\u0000\u0000\u0000\u0018\u0120\u0001\u0000\u0000\u0000"+
		"\u001a\u0129\u0001\u0000\u0000\u0000\u001c\u0137\u0001\u0000\u0000\u0000"+
		"\u001e\u01a7\u0001\u0000\u0000\u0000 \u01d2\u0001\u0000\u0000\u0000\""+
		"\u01de\u0001\u0000\u0000\u0000$\u01e4\u0001\u0000\u0000\u0000&\u01ec\u0001"+
		"\u0000\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000"+
		"*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,\u0001\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.0\u0003"+
		"\u0004\u0002\u0000/1\u0005\u0001\u0000\u00000/\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000019\u0001\u0000\u0000\u000029\u0003\u0006\u0003"+
		"\u000039\u0003\u0012\t\u000046\u0003\u0016\u000b\u000057\u0005\u0001\u0000"+
		"\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000"+
		"\u0000\u00008.\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u000083\u0001"+
		"\u0000\u0000\u000084\u0001\u0000\u0000\u00009\u0003\u0001\u0000\u0000"+
		"\u0000:;\u0005\u0002\u0000\u0000;<\u0005?\u0000\u0000<=\u0003&\u0013\u0000"+
		"=>\u0005\u0003\u0000\u0000>?\u0003\u001e\u000f\u0000?H\u0001\u0000\u0000"+
		"\u0000@A\u0005\u0002\u0000\u0000AB\u0005?\u0000\u0000BH\u0003&\u0013\u0000"+
		"CD\u0005?\u0000\u0000DE\u0005\u0004\u0000\u0000EH\u0003\u001e\u000f\u0000"+
		"FH\u0003\f\u0006\u0000G:\u0001\u0000\u0000\u0000G@\u0001\u0000\u0000\u0000"+
		"GC\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\u0005\u0001\u0000"+
		"\u0000\u0000IJ\u0005\u0005\u0000\u0000JK\u0005?\u0000\u0000KM\u0005\u0006"+
		"\u0000\u0000LN\u0003\b\u0004\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OQ\u0005\u0007\u0000\u0000PR\u0003"+
		"&\u0013\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000SW\u0005\b\u0000\u0000TV\u0003\u0002\u0001\u0000UT\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000Z[\u0005\t\u0000\u0000[\u0007\u0001\u0000\u0000\u0000\\_\u0005?"+
		"\u0000\u0000]^\u0005\n\u0000\u0000^`\u0005\u000b\u0000\u0000_]\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ak\u0003"+
		"\n\u0005\u0000bc\u0005\f\u0000\u0000cf\u0005?\u0000\u0000de\u0005\n\u0000"+
		"\u0000eg\u0005\u000b\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0003\n\u0005\u0000ib\u0001\u0000"+
		"\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000l\t\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"nq\u0003&\u0013\u0000oq\u0005?\u0000\u0000pn\u0001\u0000\u0000\u0000p"+
		"o\u0001\u0000\u0000\u0000q\u000b\u0001\u0000\u0000\u0000rs\u0005?\u0000"+
		"\u0000st\u0005\u0004\u0000\u0000t\u008f\u0003\u001e\u000f\u0000uv\u0005"+
		"\u0002\u0000\u0000vw\u0005?\u0000\u0000wx\u0005\n\u0000\u0000xy\u0005"+
		"\u000b\u0000\u0000y\u008f\u0003&\u0013\u0000z{\u0005?\u0000\u0000{|\u0005"+
		"\u0003\u0000\u0000|\u008f\u0005?\u0000\u0000}~\u0005?\u0000\u0000~\u007f"+
		"\u0005\u0004\u0000\u0000\u007f\u0080\u0005\n\u0000\u0000\u0080\u0083\u0005"+
		"\u000b\u0000\u0000\u0081\u0082\u0005\n\u0000\u0000\u0082\u0084\u0005\u000b"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0003&\u0013"+
		"\u0000\u0088\u008a\u0005\b\u0000\u0000\u0089\u008b\u0003\u000e\u0007\u0000"+
		"\u008a\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005\t\u0000\u0000\u008d"+
		"\u008f\u0001\u0000\u0000\u0000\u008er\u0001\u0000\u0000\u0000\u008eu\u0001"+
		"\u0000\u0000\u0000\u008ez\u0001\u0000\u0000\u0000\u008e}\u0001\u0000\u0000"+
		"\u0000\u008f\r\u0001\u0000\u0000\u0000\u0090\u0095\u0003\u0010\b\u0000"+
		"\u0091\u0092\u0005\f\u0000\u0000\u0092\u0094\u0003\u0010\b\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u009a\u0005\f\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u000f\u0001\u0000\u0000\u0000\u009b\u009d"+
		"\u0005\b\u0000\u0000\u009c\u009e\u0003\u000e\u0007\u0000\u009d\u009c\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00ad\u0005\t\u0000\u0000\u00a0\u00a9\u0005\b"+
		"\u0000\u0000\u00a1\u00a6\u0003\u001e\u000f\u0000\u00a2\u00a3\u0005\f\u0000"+
		"\u0000\u00a3\u00a5\u0003\u001e\u000f\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ad\u0005\t\u0000\u0000\u00ac\u009b\u0001\u0000\u0000\u0000"+
		"\u00ac\u00a0\u0001\u0000\u0000\u0000\u00ad\u0011\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0\u0005?\u0000\u0000\u00b0"+
		"\u00b1\u0005\u000e\u0000\u0000\u00b1\u00b5\u0005\b\u0000\u0000\u00b2\u00b4"+
		"\u0003\u0014\n\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005\t\u0000\u0000\u00b9\u0013\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005?\u0000\u0000\u00bb\u00bc\u0003\n\u0005"+
		"\u0000\u00bc\u0015\u0001\u0000\u0000\u0000\u00bd\u011f\u0003\u001e\u000f"+
		"\u0000\u00be\u00c7\u0005\u000f\u0000\u0000\u00bf\u00c4\u0003\u001e\u000f"+
		"\u0000\u00c0\u00c1\u0005\f\u0000\u0000\u00c1\u00c3\u0003\u001e\u000f\u0000"+
		"\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c7\u00bf\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u011f\u0005\u0007\u0000\u0000"+
		"\u00ca\u00ce\u0005\b\u0000\u0000\u00cb\u00cd\u0003\u0002\u0001\u0000\u00cc"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1"+
		"\u011f\u0005\t\u0000\u0000\u00d2\u00d4\u0005\u0010\u0000\u0000\u00d3\u00d5"+
		"\u0005\u0006\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d8"+
		"\u0003\u001e\u000f\u0000\u00d7\u00d9\u0005\u0007\u0000\u0000\u00d8\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0001\u0000\u0000\u0000\u00da\u00dd\u0003\u0016\u000b\u0000\u00db\u00dc"+
		"\u0005\u0011\u0000\u0000\u00dc\u00de\u0003\u0016\u000b\u0000\u00dd\u00db"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u011f"+
		"\u0001\u0000\u0000\u0000\u00df\u00e1\u0005\u0012\u0000\u0000\u00e0\u00e2"+
		"\u0005\u0006\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5"+
		"\u0003\u001e\u000f\u0000\u00e4\u00e6\u0005\u0007\u0000\u0000\u00e5\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e7\u00eb\u0005\b\u0000\u0000\u00e8\u00ea\u0003"+
		"\u0018\f\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000"+
		"\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ee\u00f0\u0003\u001a\r\u0000\u00ef\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0005\t\u0000\u0000\u00f2\u011f\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f5\u0005\u0013\u0000\u0000\u00f4\u00f6\u0005\u0006\u0000\u0000"+
		"\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f9\u0003\u001e\u000f\u0000"+
		"\u00f8\u00fa\u0005\u0007\u0000\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0003\u0016\u000b\u0000\u00fc\u011f\u0001\u0000\u0000\u0000"+
		"\u00fd\u00ff\u0005\u0013\u0000\u0000\u00fe\u0100\u0005\u0006\u0000\u0000"+
		"\u00ff\u00fe\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000"+
		"\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0003\u001c\u000e\u0000"+
		"\u0102\u0103\u0003\u001e\u000f\u0000\u0103\u0104\u0005\u0001\u0000\u0000"+
		"\u0104\u0106\u0003\u001e\u000f\u0000\u0105\u0107\u0005\u0007\u0000\u0000"+
		"\u0106\u0105\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0003\u0016\u000b\u0000"+
		"\u0109\u011f\u0001\u0000\u0000\u0000\u010a\u010c\u0005\u0013\u0000\u0000"+
		"\u010b\u010d\u0005\u0006\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0005?\u0000\u0000\u010f\u0110\u0005\f\u0000\u0000\u0110"+
		"\u0111\u0005?\u0000\u0000\u0111\u0112\u0005\u0004\u0000\u0000\u0112\u0113"+
		"\u0005\u0014\u0000\u0000\u0113\u0115\u0005?\u0000\u0000\u0114\u0116\u0005"+
		"\u0007\u0000\u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0115\u0116\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u011f\u0003"+
		"\u0016\u000b\u0000\u0118\u011f\u0005\u0015\u0000\u0000\u0119\u011f\u0005"+
		"\u0016\u0000\u0000\u011a\u011c\u0005\u0017\u0000\u0000\u011b\u011d\u0003"+
		"\u001e\u000f\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011c\u011d\u0001"+
		"\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u00bd\u0001"+
		"\u0000\u0000\u0000\u011e\u00be\u0001\u0000\u0000\u0000\u011e\u00ca\u0001"+
		"\u0000\u0000\u0000\u011e\u00d2\u0001\u0000\u0000\u0000\u011e\u00df\u0001"+
		"\u0000\u0000\u0000\u011e\u00f3\u0001\u0000\u0000\u0000\u011e\u00fd\u0001"+
		"\u0000\u0000\u0000\u011e\u010a\u0001\u0000\u0000\u0000\u011e\u0118\u0001"+
		"\u0000\u0000\u0000\u011e\u0119\u0001\u0000\u0000\u0000\u011e\u011a\u0001"+
		"\u0000\u0000\u0000\u011f\u0017\u0001\u0000\u0000\u0000\u0120\u0121\u0005"+
		"\u0018\u0000\u0000\u0121\u0122\u0003\u001e\u000f\u0000\u0122\u0126\u0005"+
		"\u0019\u0000\u0000\u0123\u0125\u0003\u0002\u0001\u0000\u0124\u0123\u0001"+
		"\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0019\u0001"+
		"\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012a\u0005"+
		"\u001a\u0000\u0000\u012a\u012e\u0005\u0019\u0000\u0000\u012b\u012d\u0003"+
		"\u0002\u0001\u0000\u012c\u012b\u0001\u0000\u0000\u0000\u012d\u0130\u0001"+
		"\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f\u001b\u0001\u0000\u0000\u0000\u0130\u012e\u0001"+
		"\u0000\u0000\u0000\u0131\u0132\u0003\u0004\u0002\u0000\u0132\u0133\u0005"+
		"\u0001\u0000\u0000\u0133\u0138\u0001\u0000\u0000\u0000\u0134\u0135\u0003"+
		"\u001e\u000f\u0000\u0135\u0136\u0005\u0001\u0000\u0000\u0136\u0138\u0001"+
		"\u0000\u0000\u0000\u0137\u0131\u0001\u0000\u0000\u0000\u0137\u0134\u0001"+
		"\u0000\u0000\u0000\u0138\u001d\u0001\u0000\u0000\u0000\u0139\u013a\u0006"+
		"\u000f\uffff\uffff\u0000\u013a\u013b\u0005\u001b\u0000\u0000\u013b\u013c"+
		"\u0003\u001e\u000f\u0000\u013c\u013d\u0005\u0007\u0000\u0000\u013d\u01a8"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0005\u001c\u0000\u0000\u013f\u0140"+
		"\u0003\u001e\u000f\u0000\u0140\u0141\u0005\u0007\u0000\u0000\u0141\u01a8"+
		"\u0001\u0000\u0000\u0000\u0142\u0143\u0005\u001d\u0000\u0000\u0143\u0144"+
		"\u0003\u001e\u000f\u0000\u0144\u0145\u0005\u0007\u0000\u0000\u0145\u01a8"+
		"\u0001\u0000\u0000\u0000\u0146\u0147\u0005\u001e\u0000\u0000\u0147\u0148"+
		"\u0005?\u0000\u0000\u0148\u0149\u0005\f\u0000\u0000\u0149\u014a\u0003"+
		"\u001e\u000f\u0000\u014a\u014b\u0005\u0007\u0000\u0000\u014b\u01a8\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u0005\u001f\u0000\u0000\u014d\u014e\u0005"+
		"?\u0000\u0000\u014e\u014f\u0005\f\u0000\u0000\u014f\u0150\u0003\u001e"+
		"\u000f\u0000\u0150\u0151\u0005\u0007\u0000\u0000\u0151\u01a8\u0001\u0000"+
		"\u0000\u0000\u0152\u0153\u0005 \u0000\u0000\u0153\u0154\u0003\u001e\u000f"+
		"\u0000\u0154\u0155\u0005\u0007\u0000\u0000\u0155\u01a8\u0001\u0000\u0000"+
		"\u0000\u0156\u0157\u0005!\u0000\u0000\u0157\u0158\u0005?\u0000\u0000\u0158"+
		"\u0159\u0005\f\u0000\u0000\u0159\u015a\u0003\u001e\u000f\u0000\u015a\u015b"+
		"\u0005\u0007\u0000\u0000\u015b\u01a8\u0001\u0000\u0000\u0000\u015c\u015d"+
		"\u0005?\u0000\u0000\u015d\u015e\u0005\n\u0000\u0000\u015e\u015f\u0003"+
		"\u001e\u000f\u0000\u015f\u0160\u0005\u000b\u0000\u0000\u0160\u01a8\u0001"+
		"\u0000\u0000\u0000\u0161\u0166\u0005?\u0000\u0000\u0162\u0163\u0005\n"+
		"\u0000\u0000\u0163\u0164\u0003\u001e\u000f\u0000\u0164\u0165\u0005\u000b"+
		"\u0000\u0000\u0165\u0167\u0001\u0000\u0000\u0000\u0166\u0162\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000"+
		"\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u01a8\u0001\u0000"+
		"\u0000\u0000\u016a\u016b\u0005\"\u0000\u0000\u016b\u01a8\u0003\u001e\u000f"+
		"\u0018\u016c\u016d\u0005#\u0000\u0000\u016d\u01a8\u0003\u001e\u000f\u0016"+
		"\u016e\u016f\u0005?\u0000\u0000\u016f\u01a8\u0007\u0000\u0000\u0000\u0170"+
		"\u0171\u0005?\u0000\u0000\u0171\u0172\u0007\u0001\u0000\u0000\u0172\u01a8"+
		"\u0003\u001e\u000f\u000e\u0173\u0174\u0005?\u0000\u0000\u0174\u0175\u0005"+
		"\n\u0000\u0000\u0175\u0176\u0003\u001e\u000f\u0000\u0176\u0177\u0005\u000b"+
		"\u0000\u0000\u0177\u0178\u0005\u0003\u0000\u0000\u0178\u0179\u0003\u001e"+
		"\u000f\r\u0179\u01a8\u0001\u0000\u0000\u0000\u017a\u017f\u0005?\u0000"+
		"\u0000\u017b\u017c\u0005\n\u0000\u0000\u017c\u017d\u0003\u001e\u000f\u0000"+
		"\u017d\u017e\u0005\u000b\u0000\u0000\u017e\u0180\u0001\u0000\u0000\u0000"+
		"\u017f\u017b\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000"+
		"\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000"+
		"\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u0003\u0000\u0000"+
		"\u0184\u0185\u0003\u001e\u000f\f\u0185\u01a8\u0001\u0000\u0000\u0000\u0186"+
		"\u0187\u0005\n\u0000\u0000\u0187\u0188\u0005\u000b\u0000\u0000\u0188\u0189"+
		"\u0003&\u0013\u0000\u0189\u018a\u0005\b\u0000\u0000\u018a\u018f\u0003"+
		"\u001e\u000f\u0000\u018b\u018c\u0005\f\u0000\u0000\u018c\u018e\u0003\u001e"+
		"\u000f\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u0191\u0001\u0000"+
		"\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000"+
		"\u0000\u0000\u0190\u0192\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000"+
		"\u0000\u0000\u0192\u0193\u0005\t\u0000\u0000\u0193\u01a8\u0001\u0000\u0000"+
		"\u0000\u0194\u01a8\u0005;\u0000\u0000\u0195\u01a8\u0005<\u0000\u0000\u0196"+
		"\u01a8\u0005>\u0000\u0000\u0197\u01a8\u0005=\u0000\u0000\u0198\u01a8\u0005"+
		":\u0000\u0000\u0199\u01a8\u0005?\u0000\u0000\u019a\u019b\u0005\u0006\u0000"+
		"\u0000\u019b\u019c\u0003\u001e\u000f\u0000\u019c\u019d\u0005\u0007\u0000"+
		"\u0000\u019d\u01a8\u0001\u0000\u0000\u0000\u019e\u019f\u0005?\u0000\u0000"+
		"\u019f\u01a3\u0005\b\u0000\u0000\u01a0\u01a2\u0003 \u0010\u0000\u01a1"+
		"\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a5\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a8\u0005\t\u0000\u0000\u01a7\u0139\u0001\u0000\u0000\u0000\u01a7\u013e"+
		"\u0001\u0000\u0000\u0000\u01a7\u0142\u0001\u0000\u0000\u0000\u01a7\u0146"+
		"\u0001\u0000\u0000\u0000\u01a7\u014c\u0001\u0000\u0000\u0000\u01a7\u0152"+
		"\u0001\u0000\u0000\u0000\u01a7\u0156\u0001\u0000\u0000\u0000\u01a7\u015c"+
		"\u0001\u0000\u0000\u0000\u01a7\u0161\u0001\u0000\u0000\u0000\u01a7\u016a"+
		"\u0001\u0000\u0000\u0000\u01a7\u016c\u0001\u0000\u0000\u0000\u01a7\u016e"+
		"\u0001\u0000\u0000\u0000\u01a7\u0170\u0001\u0000\u0000\u0000\u01a7\u0173"+
		"\u0001\u0000\u0000\u0000\u01a7\u017a\u0001\u0000\u0000\u0000\u01a7\u0186"+
		"\u0001\u0000\u0000\u0000\u01a7\u0194\u0001\u0000\u0000\u0000\u01a7\u0195"+
		"\u0001\u0000\u0000\u0000\u01a7\u0196\u0001\u0000\u0000\u0000\u01a7\u0197"+
		"\u0001\u0000\u0000\u0000\u01a7\u0198\u0001\u0000\u0000\u0000\u01a7\u0199"+
		"\u0001\u0000\u0000\u0000\u01a7\u019a\u0001\u0000\u0000\u0000\u01a7\u019e"+
		"\u0001\u0000\u0000\u0000\u01a8\u01cf\u0001\u0000\u0000\u0000\u01a9\u01aa"+
		"\n\u0015\u0000\u0000\u01aa\u01ab\u0007\u0002\u0000\u0000\u01ab\u01ce\u0003"+
		"\u001e\u000f\u0016\u01ac\u01ad\n\u0014\u0000\u0000\u01ad\u01ae\u0007\u0003"+
		"\u0000\u0000\u01ae\u01ce\u0003\u001e\u000f\u0015\u01af\u01b0\n\u0013\u0000"+
		"\u0000\u01b0\u01b1\u0007\u0004\u0000\u0000\u01b1\u01ce\u0003\u001e\u000f"+
		"\u0014\u01b2\u01b3\n\u0012\u0000\u0000\u01b3\u01b4\u0007\u0005\u0000\u0000"+
		"\u01b4\u01ce\u0003\u001e\u000f\u0013\u01b5\u01b6\n\u0011\u0000\u0000\u01b6"+
		"\u01b7\u0005.\u0000\u0000\u01b7\u01ce\u0003\u001e\u000f\u0012\u01b8\u01b9"+
		"\n\u0010\u0000\u0000\u01b9\u01ba\u0005/\u0000\u0000\u01ba\u01ce\u0003"+
		"\u001e\u000f\u0011\u01bb\u01be\n\u0003\u0000\u0000\u01bc\u01bd\u00054"+
		"\u0000\u0000\u01bd\u01bf\u0005?\u0000\u0000\u01be\u01bc\u0001\u0000\u0000"+
		"\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000"+
		"\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0005\u0003\u0000\u0000\u01c3\u01ce\u0003\u001e\u000f"+
		"\u0004\u01c4\u01c6\n\u0017\u0000\u0000\u01c5\u01c7\u0003\"\u0011\u0000"+
		"\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000"+
		"\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000"+
		"\u01c9\u01ce\u0001\u0000\u0000\u0000\u01ca\u01cb\n\u0004\u0000\u0000\u01cb"+
		"\u01cc\u00054\u0000\u0000\u01cc\u01ce\u0005?\u0000\u0000\u01cd\u01a9\u0001"+
		"\u0000\u0000\u0000\u01cd\u01ac\u0001\u0000\u0000\u0000\u01cd\u01af\u0001"+
		"\u0000\u0000\u0000\u01cd\u01b2\u0001\u0000\u0000\u0000\u01cd\u01b5\u0001"+
		"\u0000\u0000\u0000\u01cd\u01b8\u0001\u0000\u0000\u0000\u01cd\u01bb\u0001"+
		"\u0000\u0000\u0000\u01cd\u01c4\u0001\u0000\u0000\u0000\u01cd\u01ca\u0001"+
		"\u0000\u0000\u0000\u01ce\u01d1\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001"+
		"\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u001f\u0001"+
		"\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01d3\u0005"+
		"?\u0000\u0000\u01d3\u01d4\u0005\u0019\u0000\u0000\u01d4\u01db\u0003\u001e"+
		"\u000f\u0000\u01d5\u01d6\u0005\f\u0000\u0000\u01d6\u01d7\u0005?\u0000"+
		"\u0000\u01d7\u01d8\u0005\u0019\u0000\u0000\u01d8\u01da\u0003\u001e\u000f"+
		"\u0000\u01d9\u01d5\u0001\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000"+
		"\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000"+
		"\u0000\u01dc!\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000"+
		"\u01de\u01e0\u0005\u0006\u0000\u0000\u01df\u01e1\u0003$\u0012\u0000\u01e0"+
		"\u01df\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1"+
		"\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e3\u0005\u0007\u0000\u0000\u01e3"+
		"#\u0001\u0000\u0000\u0000\u01e4\u01e9\u0003\u001e\u000f\u0000\u01e5\u01e6"+
		"\u0005\f\u0000\u0000\u01e6\u01e8\u0003\u001e\u000f\u0000\u01e7\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e8\u01eb\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001"+
		"\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea%\u0001\u0000"+
		"\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000\u01ec\u01ed\u0007\u0006"+
		"\u0000\u0000\u01ed\'\u0001\u0000\u0000\u00007+068GMQW_fkp\u0085\u008a"+
		"\u008e\u0095\u0099\u009d\u00a6\u00a9\u00ac\u00b5\u00c4\u00c7\u00ce\u00d4"+
		"\u00d8\u00dd\u00e1\u00e5\u00eb\u00ef\u00f5\u00f9\u00ff\u0106\u010c\u0115"+
		"\u011c\u011e\u0126\u012e\u0137\u0168\u0181\u018f\u01a3\u01a7\u01c0\u01c8"+
		"\u01cd\u01cf\u01db\u01e0\u01e9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}