// Generated from /home/josseline/Escritorio/OLC2_PROYECTO2/api/grammars/Language.g4 by ANTLR 4.13.1
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
		RULE_program = 0, RULE_dcl = 1, RULE_dclFuera = 2, RULE_declaracionVariable = 3, 
		RULE_declaracionFuncForanea = 4, RULE_parametros = 5, RULE_tipoFunc = 6, 
		RULE_slice = 7, RULE_elementosSlice = 8, RULE_elementoSlice = 9, RULE_sentencia = 10, 
		RULE_stmtCase = 11, RULE_stmtDefault = 12, RULE_forInit = 13, RULE_expresion = 14, 
		RULE_atributoInstancia = 15, RULE_call = 16, RULE_args = 17, RULE_tipoDeclaracion = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "dclFuera", "declaracionVariable", "declaracionFuncForanea", 
			"parametros", "tipoFunc", "slice", "elementosSlice", "elementoSlice", 
			"sentencia", "stmtCase", "stmtDefault", "forInit", "expresion", "atributoInstancia", 
			"call", "args", "tipoDeclaracion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func main()'", "'{'", "'}'", "';'", "'var'", "'='", "':='", "'func'", 
			"'('", "')'", "'['", "']'", "','", "'fmt.Println('", "'if'", "'else'", 
			"'switch'", "'for'", "'range'", "'break'", "'continue'", "'return'", 
			"'case'", "':'", "'default'", "'strconv.Atoi('", "'strconv.ParseFloat('", 
			"'reflect.TypeOf('", "'slices.Index('", "'strings.Join('", "'len('", 
			"'append('", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+='", 
			"'-='", "'nil'", "'.'", "'int'", "'float64'", "'string'", "'bool'", "'rune'"
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
		public List<DclFueraContext> dclFuera() {
			return getRuleContexts(DclFueraContext.class);
		}
		public DclFueraContext dclFuera(int i) {
			return getRuleContext(DclFueraContext.class,i);
		}
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223372036854775520L) != 0)) {
				{
				{
				setState(38);
				dclFuera();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(T__0);
			setState(45);
			match(T__1);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542037611740L) != 0)) {
				{
				{
				setState(46);
				dcl();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(T__2);
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
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				declaracionVariable();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(55);
					match(T__3);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				declaracionFuncForanea();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				sentencia();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(60);
					match(T__3);
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
	public static class DclFueraContext extends ParserRuleContext {
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public DeclaracionFuncForaneaContext declaracionFuncForanea() {
			return getRuleContext(DeclaracionFuncForaneaContext.class,0);
		}
		public DclFueraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclFuera; }
	}

	public final DclFueraContext dclFuera() throws RecognitionException {
		DclFueraContext _localctx = new DclFueraContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dclFuera);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				declaracionVariable();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(66);
					match(T__3);
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				declaracionFuncForanea();
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
		enterRule(_localctx, 6, RULE_declaracionVariable);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(T__4);
				setState(73);
				match(ID);
				setState(74);
				tipoDeclaracion();
				setState(75);
				match(T__5);
				setState(76);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(T__4);
				setState(79);
				match(ID);
				setState(80);
				tipoDeclaracion();
				}
				break;
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(ID);
				setState(82);
				match(T__6);
				setState(83);
				expresion(0);
				}
				break;
			case 4:
				_localctx = new DeclaracionSliceContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
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
		enterRule(_localctx, 8, RULE_declaracionFuncForanea);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__7);
			setState(88);
			match(ID);
			setState(89);
			match(T__8);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(90);
				parametros();
				}
			}

			setState(93);
			match(T__9);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279223176896970752L) != 0)) {
				{
				setState(94);
				tipoDeclaracion();
				}
			}

			setState(97);
			match(T__1);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542037611740L) != 0)) {
				{
				{
				setState(98);
				dcl();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(T__2);
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
		enterRule(_localctx, 10, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(ID);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(107);
				match(T__10);
				setState(108);
				match(T__11);
				}
			}

			setState(111);
			tipoFunc();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(112);
				match(T__12);
				setState(113);
				match(ID);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(114);
					match(T__10);
					setState(115);
					match(T__11);
					}
				}

				setState(118);
				tipoFunc();
				}
				}
				setState(123);
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
		enterRule(_localctx, 12, RULE_tipoFunc);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				tipoDeclaracion();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
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
		enterRule(_localctx, 14, RULE_slice);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new DeclaracionSliceValoresContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(ID);
				setState(129);
				match(T__6);
				setState(130);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new DeclaracionSliceVacioContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__4);
				setState(132);
				match(ID);
				setState(133);
				match(T__10);
				setState(134);
				match(T__11);
				setState(135);
				tipoDeclaracion();
				}
				break;
			case 3:
				_localctx = new DeclaracionSliceCopiaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(ID);
				setState(137);
				match(T__5);
				setState(138);
				match(ID);
				}
				break;
			case 4:
				_localctx = new DeclaracionSliceMultidimensionalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(ID);
				setState(140);
				match(T__6);
				setState(141);
				match(T__10);
				setState(142);
				match(T__11);
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(143);
					match(T__10);
					setState(144);
					match(T__11);
					}
					}
					setState(147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				setState(149);
				tipoDeclaracion();
				setState(150);
				match(T__1);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(151);
					elementosSlice();
					}
				}

				setState(154);
				match(T__2);
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
		enterRule(_localctx, 16, RULE_elementosSlice);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			elementoSlice();
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					match(T__12);
					setState(160);
					elementoSlice();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(166);
				match(T__12);
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
		enterRule(_localctx, 18, RULE_elementoSlice);
		int _la;
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(T__1);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(170);
					elementosSlice();
					}
				}

				setState(173);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(T__1);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542045394432L) != 0)) {
					{
					setState(175);
					expresion(0);
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(176);
						match(T__12);
						setState(177);
						expresion(0);
						}
						}
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(185);
				match(T__2);
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
		enterRule(_localctx, 20, RULE_sentencia);
		int _la;
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__13);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542045394432L) != 0)) {
					{
					setState(190);
					expresion(0);
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(191);
						match(T__12);
						setState(192);
						expresion(0);
						}
						}
						setState(197);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(200);
				match(T__9);
				}
				break;
			case 3:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(T__1);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542037611740L) != 0)) {
					{
					{
					setState(202);
					dcl();
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(208);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				match(T__14);
				setState(211);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(210);
					match(T__8);
					}
					break;
				}
				setState(213);
				expresion(0);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(214);
					match(T__9);
					}
				}

				setState(217);
				sentencia();
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(218);
					match(T__15);
					setState(219);
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
				setState(222);
				match(T__16);
				setState(224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(223);
					match(T__8);
					}
					break;
				}
				setState(226);
				expresion(0);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(227);
					match(T__9);
					}
				}

				setState(230);
				match(T__1);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22) {
					{
					{
					setState(231);
					stmtCase();
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(237);
					stmtDefault();
					}
				}

				setState(240);
				match(T__2);
				}
				break;
			case 6:
				_localctx = new ForWhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(242);
				match(T__17);
				setState(244);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(243);
					match(T__8);
					}
					break;
				}
				setState(246);
				expresion(0);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(247);
					match(T__9);
					}
				}

				setState(250);
				sentencia();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(252);
				match(T__17);
				setState(254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(253);
					match(T__8);
					}
					break;
				}
				setState(256);
				forInit();
				setState(257);
				expresion(0);
				setState(258);
				match(T__3);
				setState(259);
				expresion(0);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(260);
					match(T__9);
					}
				}

				setState(263);
				sentencia();
				}
				break;
			case 8:
				_localctx = new ForRangeStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(265);
				match(T__17);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(266);
					match(T__8);
					}
				}

				setState(269);
				((ForRangeStmtContext)_localctx).indice = match(ID);
				setState(270);
				match(T__12);
				setState(271);
				((ForRangeStmtContext)_localctx).valor = match(ID);
				setState(272);
				match(T__6);
				setState(273);
				match(T__18);
				setState(274);
				((ForRangeStmtContext)_localctx).ident = match(ID);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(275);
					match(T__9);
					}
				}

				setState(278);
				sentencia();
				}
				break;
			case 9:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(279);
				match(T__19);
				}
				break;
			case 10:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(280);
				match(T__20);
				}
				break;
			case 11:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(281);
				match(T__21);
				setState(283);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(282);
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
		enterRule(_localctx, 22, RULE_stmtCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__22);
			setState(288);
			expresion(0);
			setState(289);
			match(T__23);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542037611740L) != 0)) {
				{
				{
				setState(290);
				dcl();
				}
				}
				setState(295);
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
		enterRule(_localctx, 24, RULE_stmtDefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__24);
			setState(297);
			match(T__23);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542037611740L) != 0)) {
				{
				{
				setState(298);
				dcl();
				}
				}
				setState(303);
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
		enterRule(_localctx, 26, RULE_forInit);
		try {
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				declaracionVariable();
				setState(305);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				expresion(0);
				setState(308);
				match(T__3);
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
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
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
	public static class NilContext extends ExpresionContext {
		public NilContext(ExpresionContext ctx) { copyFrom(ctx); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				_localctx = new EmebbedFuncAtoiContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(313);
				match(T__25);
				setState(314);
				expresion(0);
				setState(315);
				match(T__9);
				}
				break;
			case 2:
				{
				_localctx = new EmebbedFuncParseFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				match(T__26);
				setState(318);
				expresion(0);
				setState(319);
				match(T__9);
				}
				break;
			case 3:
				{
				_localctx = new EmebbedFuncTypeOfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321);
				match(T__27);
				setState(322);
				expresion(0);
				setState(323);
				match(T__9);
				}
				break;
			case 4:
				{
				_localctx = new SliceFuncIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				match(T__28);
				setState(326);
				match(ID);
				setState(327);
				match(T__12);
				setState(328);
				expresion(0);
				setState(329);
				match(T__9);
				}
				break;
			case 5:
				{
				_localctx = new SliceStringFuncJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(331);
				match(T__29);
				setState(332);
				match(ID);
				setState(333);
				match(T__12);
				setState(334);
				expresion(0);
				setState(335);
				match(T__9);
				}
				break;
			case 6:
				{
				_localctx = new SliceLenFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337);
				match(T__30);
				setState(338);
				expresion(0);
				setState(339);
				match(T__9);
				}
				break;
			case 7:
				{
				_localctx = new SliceAppendFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				match(T__31);
				setState(342);
				match(ID);
				setState(343);
				match(T__12);
				setState(344);
				expresion(0);
				setState(345);
				match(T__9);
				}
				break;
			case 8:
				{
				_localctx = new SliceAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(347);
				match(ID);
				setState(348);
				match(T__10);
				setState(349);
				expresion(0);
				setState(350);
				match(T__11);
				}
				break;
			case 9:
				{
				_localctx = new SliceMatrixAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(352);
				match(ID);
				setState(357); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(353);
						match(T__10);
						setState(354);
						expresion(0);
						setState(355);
						match(T__11);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(359); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(361);
				match(T__32);
				setState(362);
				expresion(23);
				}
				break;
			case 11:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(363);
				match(T__33);
				setState(364);
				expresion(21);
				}
				break;
			case 12:
				{
				_localctx = new IncrementDecrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(365);
				match(ID);
				setState(366);
				((IncrementDecrementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__46 || _la==T__47) ) {
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
				setState(367);
				match(ID);
				setState(368);
				((AssignVarContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1688849860264000L) != 0)) ) {
					((AssignVarContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(369);
				expresion(13);
				}
				break;
			case 14:
				{
				_localctx = new AssignSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				match(ID);
				setState(371);
				match(T__10);
				setState(372);
				((AssignSliceContext)_localctx).indice = expresion(0);
				setState(373);
				match(T__11);
				setState(374);
				match(T__5);
				setState(375);
				((AssignSliceContext)_localctx).valor = expresion(12);
				}
				break;
			case 15:
				{
				_localctx = new AssignSliceMultidimensionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(377);
				match(ID);
				setState(382); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(378);
					match(T__10);
					setState(379);
					expresion(0);
					setState(380);
					match(T__11);
					}
					}
					setState(384); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				setState(386);
				match(T__5);
				setState(387);
				expresion(11);
				}
				break;
			case 16:
				{
				_localctx = new SliceLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(389);
				match(T__10);
				setState(390);
				match(T__11);
				setState(391);
				tipoDeclaracion();
				setState(392);
				match(T__1);
				setState(393);
				expresion(0);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(394);
					match(T__12);
					setState(395);
					expresion(0);
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(401);
				match(T__2);
				}
				break;
			case 17:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(403);
				match(BOOL);
				}
				break;
			case 18:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(404);
				match(FLOAT);
				}
				break;
			case 19:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				match(RUNE);
				}
				break;
			case 20:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(406);
				match(STRING);
				}
				break;
			case 21:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(407);
				match(INT);
				}
				break;
			case 22:
				{
				_localctx = new NilContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408);
				match(T__50);
				}
				break;
			case 23:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				match(ID);
				}
				break;
			case 24:
				{
				_localctx = new StructAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410);
				match(ID);
				setState(413); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(411);
						match(T__51);
						setState(412);
						match(ID);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(415); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 25:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(417);
				match(T__8);
				setState(418);
				expresion(0);
				setState(419);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(449);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(447);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(423);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(424);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240518168576L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(425);
						expresion(21);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(426);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(427);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__37) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(428);
						expresion(20);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(429);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(430);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337208320L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(431);
						expresion(19);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(432);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(433);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__42 || _la==T__43) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(434);
						expresion(18);
						}
						break;
					case 5:
						{
						_localctx = new LogicalAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(435);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(436);
						((LogicalAndContext)_localctx).op = match(T__44);
						setState(437);
						expresion(17);
						}
						break;
					case 6:
						{
						_localctx = new LogicalOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(438);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(439);
						((LogicalOrContext)_localctx).op = match(T__45);
						setState(440);
						expresion(16);
						}
						break;
					case 7:
						{
						_localctx = new CalleeContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(441);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(443); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(442);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(445); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(451);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
		enterRule(_localctx, 30, RULE_atributoInstancia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(ID);
			setState(453);
			match(T__23);
			setState(454);
			expresion(0);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(455);
				match(T__12);
				setState(456);
				match(ID);
				setState(457);
				match(T__23);
				setState(458);
				expresion(0);
				}
				}
				setState(463);
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
		enterRule(_localctx, 32, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(T__8);
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -285978542045394432L) != 0)) {
				{
				setState(465);
				args();
				}
			}

			setState(468);
			match(T__9);
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
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			expresion(0);
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(471);
				match(T__12);
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
	public static class TipoDeclaracionContext extends ParserRuleContext {
		public TipoDeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDeclaracion; }
	}

	public final TipoDeclaracionContext tipoDeclaracion() throws RecognitionException {
		TipoDeclaracionContext _localctx = new TipoDeclaracionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tipoDeclaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
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
		case 14:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 22);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001B\u01e1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u00003\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u00019\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001\u0003\u0001"+
		"@\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002D\b\u0002\u0001\u0002\u0003"+
		"\u0002G\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003V\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004`\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004d\b\u0004"+
		"\n\u0004\f\u0004g\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005n\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005u\b\u0005\u0001\u0005\u0005\u0005"+
		"x\b\u0005\n\u0005\f\u0005{\t\u0005\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u007f\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0004\u0007\u0092\b\u0007\u000b\u0007\f\u0007\u0093\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0099\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u009d\b\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00a2\b\b\n\b\f\b"+
		"\u00a5\t\b\u0001\b\u0003\b\u00a8\b\b\u0001\t\u0001\t\u0003\t\u00ac\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00b3\b\t\n\t\f\t\u00b6"+
		"\t\t\u0003\t\u00b8\b\t\u0001\t\u0003\t\u00bb\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00c2\b\n\n\n\f\n\u00c5\t\n\u0003\n\u00c7\b"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00cc\b\n\n\n\f\n\u00cf\t\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u00d4\b\n\u0001\n\u0001\n\u0003\n\u00d8\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00dd\b\n\u0001\n\u0001\n\u0003\n\u00e1\b\n"+
		"\u0001\n\u0001\n\u0003\n\u00e5\b\n\u0001\n\u0001\n\u0005\n\u00e9\b\n\n"+
		"\n\f\n\u00ec\t\n\u0001\n\u0003\n\u00ef\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00f5\b\n\u0001\n\u0001\n\u0003\n\u00f9\b\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u00ff\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u0106\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u010c\b\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0115"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u011c\b\n\u0003\n"+
		"\u011e\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u0124\b\u000b\n\u000b\f\u000b\u0127\t\u000b\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u012c\b\f\n\f\f\f\u012f\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u0137\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e"+
		"\u0166\b\u000e\u000b\u000e\f\u000e\u0167\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0004\u000e\u017f\b\u000e\u000b\u000e\f\u000e\u0180\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u018d\b\u000e\n\u000e"+
		"\f\u000e\u0190\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0004\u000e\u019e\b\u000e\u000b\u000e\f\u000e"+
		"\u019f\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01a6"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u01bc\b\u000e\u000b\u000e\f"+
		"\u000e\u01bd\u0005\u000e\u01c0\b\u000e\n\u000e\f\u000e\u01c3\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u01cc\b\u000f\n\u000f\f\u000f\u01cf\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u01d3\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u01da\b\u0011\n\u0011\f\u0011\u01dd"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0001\u001c\u0013\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$\u0000\u0007\u0001\u0000/0\u0002\u0000\u0006\u000612\u0001\u0000"+
		"#%\u0002\u0000!!&&\u0001\u0000\'*\u0001\u0000+,\u0001\u000059\u022f\u0000"+
		")\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0004F\u0001"+
		"\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000\bW\u0001\u0000\u0000"+
		"\u0000\nj\u0001\u0000\u0000\u0000\f~\u0001\u0000\u0000\u0000\u000e\u009c"+
		"\u0001\u0000\u0000\u0000\u0010\u009e\u0001\u0000\u0000\u0000\u0012\u00ba"+
		"\u0001\u0000\u0000\u0000\u0014\u011d\u0001\u0000\u0000\u0000\u0016\u011f"+
		"\u0001\u0000\u0000\u0000\u0018\u0128\u0001\u0000\u0000\u0000\u001a\u0136"+
		"\u0001\u0000\u0000\u0000\u001c\u01a5\u0001\u0000\u0000\u0000\u001e\u01c4"+
		"\u0001\u0000\u0000\u0000 \u01d0\u0001\u0000\u0000\u0000\"\u01d6\u0001"+
		"\u0000\u0000\u0000$\u01de\u0001\u0000\u0000\u0000&(\u0003\u0004\u0002"+
		"\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000,-\u0005\u0001\u0000\u0000-1\u0005\u0002\u0000\u0000"+
		".0\u0003\u0002\u0001\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u00005\u0001"+
		"\u0001\u0000\u0000\u000068\u0003\u0006\u0003\u000079\u0005\u0004\u0000"+
		"\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009@\u0001\u0000"+
		"\u0000\u0000:@\u0003\b\u0004\u0000;=\u0003\u0014\n\u0000<>\u0005\u0004"+
		"\u0000\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001"+
		"\u0000\u0000\u0000?6\u0001\u0000\u0000\u0000?:\u0001\u0000\u0000\u0000"+
		"?;\u0001\u0000\u0000\u0000@\u0003\u0001\u0000\u0000\u0000AC\u0003\u0006"+
		"\u0003\u0000BD\u0005\u0004\u0000\u0000CB\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EG\u0003\b\u0004\u0000FA\u0001"+
		"\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000"+
		"\u0000HI\u0005\u0005\u0000\u0000IJ\u0005?\u0000\u0000JK\u0003$\u0012\u0000"+
		"KL\u0005\u0006\u0000\u0000LM\u0003\u001c\u000e\u0000MV\u0001\u0000\u0000"+
		"\u0000NO\u0005\u0005\u0000\u0000OP\u0005?\u0000\u0000PV\u0003$\u0012\u0000"+
		"QR\u0005?\u0000\u0000RS\u0005\u0007\u0000\u0000SV\u0003\u001c\u000e\u0000"+
		"TV\u0003\u000e\u0007\u0000UH\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000"+
		"\u0000UQ\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0007\u0001"+
		"\u0000\u0000\u0000WX\u0005\b\u0000\u0000XY\u0005?\u0000\u0000Y[\u0005"+
		"\t\u0000\u0000Z\\\u0003\n\u0005\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0005\n\u0000\u0000^`"+
		"\u0003$\u0012\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ae\u0005\u0002\u0000\u0000bd\u0003\u0002\u0001"+
		"\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000hi\u0005\u0003\u0000\u0000i\t\u0001\u0000\u0000\u0000"+
		"jm\u0005?\u0000\u0000kl\u0005\u000b\u0000\u0000ln\u0005\f\u0000\u0000"+
		"mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000oy\u0003\f\u0006\u0000pq\u0005\r\u0000\u0000qt\u0005?\u0000\u0000"+
		"rs\u0005\u000b\u0000\u0000su\u0005\f\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0003\f\u0006\u0000"+
		"wp\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z\u000b\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|\u007f\u0003$\u0012\u0000}\u007f\u0005?\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\r\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0005?\u0000\u0000\u0081\u0082\u0005\u0007\u0000"+
		"\u0000\u0082\u009d\u0003\u001c\u000e\u0000\u0083\u0084\u0005\u0005\u0000"+
		"\u0000\u0084\u0085\u0005?\u0000\u0000\u0085\u0086\u0005\u000b\u0000\u0000"+
		"\u0086\u0087\u0005\f\u0000\u0000\u0087\u009d\u0003$\u0012\u0000\u0088"+
		"\u0089\u0005?\u0000\u0000\u0089\u008a\u0005\u0006\u0000\u0000\u008a\u009d"+
		"\u0005?\u0000\u0000\u008b\u008c\u0005?\u0000\u0000\u008c\u008d\u0005\u0007"+
		"\u0000\u0000\u008d\u008e\u0005\u000b\u0000\u0000\u008e\u0091\u0005\f\u0000"+
		"\u0000\u008f\u0090\u0005\u000b\u0000\u0000\u0090\u0092\u0005\f\u0000\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0003$\u0012\u0000\u0096"+
		"\u0098\u0005\u0002\u0000\u0000\u0097\u0099\u0003\u0010\b\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0003\u0000\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u0080\u0001\u0000\u0000\u0000\u009c\u0083"+
		"\u0001\u0000\u0000\u0000\u009c\u0088\u0001\u0000\u0000\u0000\u009c\u008b"+
		"\u0001\u0000\u0000\u0000\u009d\u000f\u0001\u0000\u0000\u0000\u009e\u00a3"+
		"\u0003\u0012\t\u0000\u009f\u00a0\u0005\r\u0000\u0000\u00a0\u00a2\u0003"+
		"\u0012\t\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a8\u0005\r\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u0011\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ab\u0005\u0002\u0000\u0000\u00aa\u00ac\u0003\u0010\b\u0000"+
		"\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00bb\u0005\u0003\u0000\u0000"+
		"\u00ae\u00b7\u0005\u0002\u0000\u0000\u00af\u00b4\u0003\u001c\u000e\u0000"+
		"\u00b0\u00b1\u0005\r\u0000\u0000\u00b1\u00b3\u0003\u001c\u000e\u0000\u00b2"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7"+
		"\u00af\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bb\u0005\u0003\u0000\u0000\u00ba"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ba\u00ae\u0001\u0000\u0000\u0000\u00bb"+
		"\u0013\u0001\u0000\u0000\u0000\u00bc\u011e\u0003\u001c\u000e\u0000\u00bd"+
		"\u00c6\u0005\u000e\u0000\u0000\u00be\u00c3\u0003\u001c\u000e\u0000\u00bf"+
		"\u00c0\u0005\r\u0000\u0000\u00c0\u00c2\u0003\u001c\u000e\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00be"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\u011e\u0005\n\u0000\u0000\u00c9\u00cd\u0005"+
		"\u0002\u0000\u0000\u00ca\u00cc\u0003\u0002\u0001\u0000\u00cb\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0001"+
		"\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u011e\u0005"+
		"\u0003\u0000\u0000\u00d1\u00d3\u0005\u000f\u0000\u0000\u00d2\u00d4\u0005"+
		"\t\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0003\u001c"+
		"\u000e\u0000\u00d6\u00d8\u0005\n\u0000\u0000\u00d7\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dc\u0003\u0014\n\u0000\u00da\u00db\u0005\u0010\u0000\u0000"+
		"\u00db\u00dd\u0003\u0014\n\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd\u011e\u0001\u0000\u0000\u0000\u00de"+
		"\u00e0\u0005\u0011\u0000\u0000\u00df\u00e1\u0005\t\u0000\u0000\u00e0\u00df"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e4\u0003\u001c\u000e\u0000\u00e3\u00e5"+
		"\u0005\n\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00ea\u0005"+
		"\u0002\u0000\u0000\u00e7\u00e9\u0003\u0016\u000b\u0000\u00e8\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ef\u0003"+
		"\u0018\f\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u0003"+
		"\u0000\u0000\u00f1\u011e\u0001\u0000\u0000\u0000\u00f2\u00f4\u0005\u0012"+
		"\u0000\u0000\u00f3\u00f5\u0005\t\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f8\u0003\u001c\u000e\u0000\u00f7\u00f9\u0005\n\u0000\u0000"+
		"\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0003\u0014\n\u0000\u00fb"+
		"\u011e\u0001\u0000\u0000\u0000\u00fc\u00fe\u0005\u0012\u0000\u0000\u00fd"+
		"\u00ff\u0005\t\u0000\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0101"+
		"\u0003\u001a\r\u0000\u0101\u0102\u0003\u001c\u000e\u0000\u0102\u0103\u0005"+
		"\u0004\u0000\u0000\u0103\u0105\u0003\u001c\u000e\u0000\u0104\u0106\u0005"+
		"\n\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0003\u0014"+
		"\n\u0000\u0108\u011e\u0001\u0000\u0000\u0000\u0109\u010b\u0005\u0012\u0000"+
		"\u0000\u010a\u010c\u0005\t\u0000\u0000\u010b\u010a\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0005?\u0000\u0000\u010e\u010f\u0005\r\u0000\u0000\u010f"+
		"\u0110\u0005?\u0000\u0000\u0110\u0111\u0005\u0007\u0000\u0000\u0111\u0112"+
		"\u0005\u0013\u0000\u0000\u0112\u0114\u0005?\u0000\u0000\u0113\u0115\u0005"+
		"\n\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u011e\u0003\u0014"+
		"\n\u0000\u0117\u011e\u0005\u0014\u0000\u0000\u0118\u011e\u0005\u0015\u0000"+
		"\u0000\u0119\u011b\u0005\u0016\u0000\u0000\u011a\u011c\u0003\u001c\u000e"+
		"\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u00bc\u0001\u0000\u0000"+
		"\u0000\u011d\u00bd\u0001\u0000\u0000\u0000\u011d\u00c9\u0001\u0000\u0000"+
		"\u0000\u011d\u00d1\u0001\u0000\u0000\u0000\u011d\u00de\u0001\u0000\u0000"+
		"\u0000\u011d\u00f2\u0001\u0000\u0000\u0000\u011d\u00fc\u0001\u0000\u0000"+
		"\u0000\u011d\u0109\u0001\u0000\u0000\u0000\u011d\u0117\u0001\u0000\u0000"+
		"\u0000\u011d\u0118\u0001\u0000\u0000\u0000\u011d\u0119\u0001\u0000\u0000"+
		"\u0000\u011e\u0015\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u0017\u0000"+
		"\u0000\u0120\u0121\u0003\u001c\u000e\u0000\u0121\u0125\u0005\u0018\u0000"+
		"\u0000\u0122\u0124\u0003\u0002\u0001\u0000\u0123\u0122\u0001\u0000\u0000"+
		"\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000"+
		"\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0017\u0001\u0000\u0000"+
		"\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0129\u0005\u0019\u0000"+
		"\u0000\u0129\u012d\u0005\u0018\u0000\u0000\u012a\u012c\u0003\u0002\u0001"+
		"\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000"+
		"\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000"+
		"\u0000\u012e\u0019\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0003\u0006\u0003\u0000\u0131\u0132\u0005\u0004\u0000"+
		"\u0000\u0132\u0137\u0001\u0000\u0000\u0000\u0133\u0134\u0003\u001c\u000e"+
		"\u0000\u0134\u0135\u0005\u0004\u0000\u0000\u0135\u0137\u0001\u0000\u0000"+
		"\u0000\u0136\u0130\u0001\u0000\u0000\u0000\u0136\u0133\u0001\u0000\u0000"+
		"\u0000\u0137\u001b\u0001\u0000\u0000\u0000\u0138\u0139\u0006\u000e\uffff"+
		"\uffff\u0000\u0139\u013a\u0005\u001a\u0000\u0000\u013a\u013b\u0003\u001c"+
		"\u000e\u0000\u013b\u013c\u0005\n\u0000\u0000\u013c\u01a6\u0001\u0000\u0000"+
		"\u0000\u013d\u013e\u0005\u001b\u0000\u0000\u013e\u013f\u0003\u001c\u000e"+
		"\u0000\u013f\u0140\u0005\n\u0000\u0000\u0140\u01a6\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0005\u001c\u0000\u0000\u0142\u0143\u0003\u001c\u000e\u0000"+
		"\u0143\u0144\u0005\n\u0000\u0000\u0144\u01a6\u0001\u0000\u0000\u0000\u0145"+
		"\u0146\u0005\u001d\u0000\u0000\u0146\u0147\u0005?\u0000\u0000\u0147\u0148"+
		"\u0005\r\u0000\u0000\u0148\u0149\u0003\u001c\u000e\u0000\u0149\u014a\u0005"+
		"\n\u0000\u0000\u014a\u01a6\u0001\u0000\u0000\u0000\u014b\u014c\u0005\u001e"+
		"\u0000\u0000\u014c\u014d\u0005?\u0000\u0000\u014d\u014e\u0005\r\u0000"+
		"\u0000\u014e\u014f\u0003\u001c\u000e\u0000\u014f\u0150\u0005\n\u0000\u0000"+
		"\u0150\u01a6\u0001\u0000\u0000\u0000\u0151\u0152\u0005\u001f\u0000\u0000"+
		"\u0152\u0153\u0003\u001c\u000e\u0000\u0153\u0154\u0005\n\u0000\u0000\u0154"+
		"\u01a6\u0001\u0000\u0000\u0000\u0155\u0156\u0005 \u0000\u0000\u0156\u0157"+
		"\u0005?\u0000\u0000\u0157\u0158\u0005\r\u0000\u0000\u0158\u0159\u0003"+
		"\u001c\u000e\u0000\u0159\u015a\u0005\n\u0000\u0000\u015a\u01a6\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0005?\u0000\u0000\u015c\u015d\u0005\u000b\u0000"+
		"\u0000\u015d\u015e\u0003\u001c\u000e\u0000\u015e\u015f\u0005\f\u0000\u0000"+
		"\u015f\u01a6\u0001\u0000\u0000\u0000\u0160\u0165\u0005?\u0000\u0000\u0161"+
		"\u0162\u0005\u000b\u0000\u0000\u0162\u0163\u0003\u001c\u000e\u0000\u0163"+
		"\u0164\u0005\f\u0000\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165\u0161"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0165"+
		"\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u01a6"+
		"\u0001\u0000\u0000\u0000\u0169\u016a\u0005!\u0000\u0000\u016a\u01a6\u0003"+
		"\u001c\u000e\u0017\u016b\u016c\u0005\"\u0000\u0000\u016c\u01a6\u0003\u001c"+
		"\u000e\u0015\u016d\u016e\u0005?\u0000\u0000\u016e\u01a6\u0007\u0000\u0000"+
		"\u0000\u016f\u0170\u0005?\u0000\u0000\u0170\u0171\u0007\u0001\u0000\u0000"+
		"\u0171\u01a6\u0003\u001c\u000e\r\u0172\u0173\u0005?\u0000\u0000\u0173"+
		"\u0174\u0005\u000b\u0000\u0000\u0174\u0175\u0003\u001c\u000e\u0000\u0175"+
		"\u0176\u0005\f\u0000\u0000\u0176\u0177\u0005\u0006\u0000\u0000\u0177\u0178"+
		"\u0003\u001c\u000e\f\u0178\u01a6\u0001\u0000\u0000\u0000\u0179\u017e\u0005"+
		"?\u0000\u0000\u017a\u017b\u0005\u000b\u0000\u0000\u017b\u017c\u0003\u001c"+
		"\u000e\u0000\u017c\u017d\u0005\f\u0000\u0000\u017d\u017f\u0001\u0000\u0000"+
		"\u0000\u017e\u017a\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000"+
		"\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000"+
		"\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0183\u0005\u0006\u0000"+
		"\u0000\u0183\u0184\u0003\u001c\u000e\u000b\u0184\u01a6\u0001\u0000\u0000"+
		"\u0000\u0185\u0186\u0005\u000b\u0000\u0000\u0186\u0187\u0005\f\u0000\u0000"+
		"\u0187\u0188\u0003$\u0012\u0000\u0188\u0189\u0005\u0002\u0000\u0000\u0189"+
		"\u018e\u0003\u001c\u000e\u0000\u018a\u018b\u0005\r\u0000\u0000\u018b\u018d"+
		"\u0003\u001c\u000e\u0000\u018c\u018a\u0001\u0000\u0000\u0000\u018d\u0190"+
		"\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018f"+
		"\u0001\u0000\u0000\u0000\u018f\u0191\u0001\u0000\u0000\u0000\u0190\u018e"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0005\u0003\u0000\u0000\u0192\u01a6"+
		"\u0001\u0000\u0000\u0000\u0193\u01a6\u0005;\u0000\u0000\u0194\u01a6\u0005"+
		"<\u0000\u0000\u0195\u01a6\u0005>\u0000\u0000\u0196\u01a6\u0005=\u0000"+
		"\u0000\u0197\u01a6\u0005:\u0000\u0000\u0198\u01a6\u00053\u0000\u0000\u0199"+
		"\u01a6\u0005?\u0000\u0000\u019a\u019d\u0005?\u0000\u0000\u019b\u019c\u0005"+
		"4\u0000\u0000\u019c\u019e\u0005?\u0000\u0000\u019d\u019b\u0001\u0000\u0000"+
		"\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000"+
		"\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a6\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0005\t\u0000\u0000\u01a2\u01a3\u0003\u001c\u000e\u0000"+
		"\u01a3\u01a4\u0005\n\u0000\u0000\u01a4\u01a6\u0001\u0000\u0000\u0000\u01a5"+
		"\u0138\u0001\u0000\u0000\u0000\u01a5\u013d\u0001\u0000\u0000\u0000\u01a5"+
		"\u0141\u0001\u0000\u0000\u0000\u01a5\u0145\u0001\u0000\u0000\u0000\u01a5"+
		"\u014b\u0001\u0000\u0000\u0000\u01a5\u0151\u0001\u0000\u0000\u0000\u01a5"+
		"\u0155\u0001\u0000\u0000\u0000\u01a5\u015b\u0001\u0000\u0000\u0000\u01a5"+
		"\u0160\u0001\u0000\u0000\u0000\u01a5\u0169\u0001\u0000\u0000\u0000\u01a5"+
		"\u016b\u0001\u0000\u0000\u0000\u01a5\u016d\u0001\u0000\u0000\u0000\u01a5"+
		"\u016f\u0001\u0000\u0000\u0000\u01a5\u0172\u0001\u0000\u0000\u0000\u01a5"+
		"\u0179\u0001\u0000\u0000\u0000\u01a5\u0185\u0001\u0000\u0000\u0000\u01a5"+
		"\u0193\u0001\u0000\u0000\u0000\u01a5\u0194\u0001\u0000\u0000\u0000\u01a5"+
		"\u0195\u0001\u0000\u0000\u0000\u01a5\u0196\u0001\u0000\u0000\u0000\u01a5"+
		"\u0197\u0001\u0000\u0000\u0000\u01a5\u0198\u0001\u0000\u0000\u0000\u01a5"+
		"\u0199\u0001\u0000\u0000\u0000\u01a5\u019a\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a6\u01c1\u0001\u0000\u0000\u0000\u01a7"+
		"\u01a8\n\u0014\u0000\u0000\u01a8\u01a9\u0007\u0002\u0000\u0000\u01a9\u01c0"+
		"\u0003\u001c\u000e\u0015\u01aa\u01ab\n\u0013\u0000\u0000\u01ab\u01ac\u0007"+
		"\u0003\u0000\u0000\u01ac\u01c0\u0003\u001c\u000e\u0014\u01ad\u01ae\n\u0012"+
		"\u0000\u0000\u01ae\u01af\u0007\u0004\u0000\u0000\u01af\u01c0\u0003\u001c"+
		"\u000e\u0013\u01b0\u01b1\n\u0011\u0000\u0000\u01b1\u01b2\u0007\u0005\u0000"+
		"\u0000\u01b2\u01c0\u0003\u001c\u000e\u0012\u01b3\u01b4\n\u0010\u0000\u0000"+
		"\u01b4\u01b5\u0005-\u0000\u0000\u01b5\u01c0\u0003\u001c\u000e\u0011\u01b6"+
		"\u01b7\n\u000f\u0000\u0000\u01b7\u01b8\u0005.\u0000\u0000\u01b8\u01c0"+
		"\u0003\u001c\u000e\u0010\u01b9\u01bb\n\u0016\u0000\u0000\u01ba\u01bc\u0003"+
		" \u0010\u0000\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000"+
		"\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000"+
		"\u0000\u0000\u01be\u01c0\u0001\u0000\u0000\u0000\u01bf\u01a7\u0001\u0000"+
		"\u0000\u0000\u01bf\u01aa\u0001\u0000\u0000\u0000\u01bf\u01ad\u0001\u0000"+
		"\u0000\u0000\u01bf\u01b0\u0001\u0000\u0000\u0000\u01bf\u01b3\u0001\u0000"+
		"\u0000\u0000\u01bf\u01b6\u0001\u0000\u0000\u0000\u01bf\u01b9\u0001\u0000"+
		"\u0000\u0000\u01c0\u01c3\u0001\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000"+
		"\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2\u001d\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c4\u01c5\u0005?\u0000"+
		"\u0000\u01c5\u01c6\u0005\u0018\u0000\u0000\u01c6\u01cd\u0003\u001c\u000e"+
		"\u0000\u01c7\u01c8\u0005\r\u0000\u0000\u01c8\u01c9\u0005?\u0000\u0000"+
		"\u01c9\u01ca\u0005\u0018\u0000\u0000\u01ca\u01cc\u0003\u001c\u000e\u0000"+
		"\u01cb\u01c7\u0001\u0000\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000"+
		"\u01cd\u01cb\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000"+
		"\u01ce\u001f\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000"+
		"\u01d0\u01d2\u0005\t\u0000\u0000\u01d1\u01d3\u0003\"\u0011\u0000\u01d2"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005\n\u0000\u0000\u01d5!"+
		"\u0001\u0000\u0000\u0000\u01d6\u01db\u0003\u001c\u000e\u0000\u01d7\u01d8"+
		"\u0005\r\u0000\u0000\u01d8\u01da\u0003\u001c\u000e\u0000\u01d9\u01d7\u0001"+
		"\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000\u0000\u01db\u01d9\u0001"+
		"\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc#\u0001\u0000"+
		"\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01de\u01df\u0007\u0006"+
		"\u0000\u0000\u01df%\u0001\u0000\u0000\u00008)18=?CFU[_emty~\u0093\u0098"+
		"\u009c\u00a3\u00a7\u00ab\u00b4\u00b7\u00ba\u00c3\u00c6\u00cd\u00d3\u00d7"+
		"\u00dc\u00e0\u00e4\u00ea\u00ee\u00f4\u00f8\u00fe\u0105\u010b\u0114\u011b"+
		"\u011d\u0125\u012d\u0136\u0167\u0180\u018e\u019f\u01a5\u01bd\u01bf\u01c1"+
		"\u01cd\u01d2\u01db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}