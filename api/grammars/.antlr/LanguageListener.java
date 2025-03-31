// Generated from /home/josseline/Escritorio/GoLight/api/grammars/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(LanguageParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(LanguageParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionExplicita}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionExplicita}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionPorDefecto}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionPorDefecto}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionImplicita}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionImplicita}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionSlice}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSlice(LanguageParser.DeclaracionSliceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionSlice}
	 * labeled alternative in {@link LanguageParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSlice(LanguageParser.DeclaracionSliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declaracionFuncForanea}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionFuncForanea(LanguageParser.DeclaracionFuncForaneaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declaracionFuncForanea}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionFuncForanea(LanguageParser.DeclaracionFuncForaneaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(LanguageParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(LanguageParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#tipoFunc}.
	 * @param ctx the parse tree
	 */
	void enterTipoFunc(LanguageParser.TipoFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#tipoFunc}.
	 * @param ctx the parse tree
	 */
	void exitTipoFunc(LanguageParser.TipoFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionSliceValores}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSliceValores(LanguageParser.DeclaracionSliceValoresContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionSliceValores}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSliceValores(LanguageParser.DeclaracionSliceValoresContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionSliceVacio}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSliceVacio(LanguageParser.DeclaracionSliceVacioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionSliceVacio}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSliceVacio(LanguageParser.DeclaracionSliceVacioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionSliceCopia}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSliceCopia(LanguageParser.DeclaracionSliceCopiaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionSliceCopia}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSliceCopia(LanguageParser.DeclaracionSliceCopiaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaracionSliceMultidimensional}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSliceMultidimensional(LanguageParser.DeclaracionSliceMultidimensionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaracionSliceMultidimensional}
	 * labeled alternative in {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSliceMultidimensional(LanguageParser.DeclaracionSliceMultidimensionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elementosSlice}.
	 * @param ctx the parse tree
	 */
	void enterElementosSlice(LanguageParser.ElementosSliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elementosSlice}.
	 * @param ctx the parse tree
	 */
	void exitElementosSlice(LanguageParser.ElementosSliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elementoSlice}.
	 * @param ctx the parse tree
	 */
	void enterElementoSlice(LanguageParser.ElementoSliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elementoSlice}.
	 * @param ctx the parse tree
	 */
	void exitElementoSlice(LanguageParser.ElementoSliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void enterStructDecl(LanguageParser.StructDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void exitStructDecl(LanguageParser.StructDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#atributoStruct}.
	 * @param ctx the parse tree
	 */
	void enterAtributoStruct(LanguageParser.AtributoStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#atributoStruct}.
	 * @param ctx the parse tree
	 */
	void exitAtributoStruct(LanguageParser.AtributoStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SwitchStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(LanguageParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SwitchStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(LanguageParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForWhileStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterForWhileStmt(LanguageParser.ForWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForWhileStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitForWhileStmt(LanguageParser.ForWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForRangeStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterForRangeStmt(LanguageParser.ForRangeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForRangeStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitForRangeStmt(LanguageParser.ForRangeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(LanguageParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link LanguageParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(LanguageParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#stmtCase}.
	 * @param ctx the parse tree
	 */
	void enterStmtCase(LanguageParser.StmtCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#stmtCase}.
	 * @param ctx the parse tree
	 */
	void exitStmtCase(LanguageParser.StmtCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#stmtDefault}.
	 * @param ctx the parse tree
	 */
	void enterStmtDefault(LanguageParser.StmtDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#stmtDefault}.
	 * @param ctx the parse tree
	 */
	void exitStmtDefault(LanguageParser.StmtDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignSlice}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAssignSlice(LanguageParser.AssignSliceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignSlice}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAssignSlice(LanguageParser.AssignSliceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Callee}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterCallee(LanguageParser.CalleeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Callee}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitCallee(LanguageParser.CalleeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SliceLenFunc}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSliceLenFunc(LanguageParser.SliceLenFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SliceLenFunc}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSliceLenFunc(LanguageParser.SliceLenFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterParens(LanguageParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitParens(LanguageParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterString(LanguageParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitString(LanguageParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(LanguageParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(LanguageParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(LanguageParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(LanguageParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(LanguageParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(LanguageParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmebbedFuncAtoi}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEmebbedFuncAtoi(LanguageParser.EmebbedFuncAtoiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmebbedFuncAtoi}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEmebbedFuncAtoi(LanguageParser.EmebbedFuncAtoiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNumber(LanguageParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNumber(LanguageParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(LanguageParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(LanguageParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEquality(LanguageParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEquality(LanguageParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SliceStringFuncJoin}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSliceStringFuncJoin(LanguageParser.SliceStringFuncJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SliceStringFuncJoin}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSliceStringFuncJoin(LanguageParser.SliceStringFuncJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(LanguageParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(LanguageParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SliceAccess}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSliceAccess(LanguageParser.SliceAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SliceAccess}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSliceAccess(LanguageParser.SliceAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructInstancia}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterStructInstancia(LanguageParser.StructInstanciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructInstancia}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitStructInstancia(LanguageParser.StructInstanciaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAssignVar(LanguageParser.AssignVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAssignVar(LanguageParser.AssignVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterRelational(LanguageParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitRelational(LanguageParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SliceMatrixAccess}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSliceMatrixAccess(LanguageParser.SliceMatrixAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SliceMatrixAccess}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSliceMatrixAccess(LanguageParser.SliceMatrixAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmebbedFuncParseFloat}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEmebbedFuncParseFloat(LanguageParser.EmebbedFuncParseFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmebbedFuncParseFloat}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEmebbedFuncParseFloat(LanguageParser.EmebbedFuncParseFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SliceFuncIndex}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSliceFuncIndex(LanguageParser.SliceFuncIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SliceFuncIndex}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSliceFuncIndex(LanguageParser.SliceFuncIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterFloat(LanguageParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitFloat(LanguageParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignSliceMultidimensional}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAssignSliceMultidimensional(LanguageParser.AssignSliceMultidimensionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignSliceMultidimensional}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAssignSliceMultidimensional(LanguageParser.AssignSliceMultidimensionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SliceAppendFunc}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSliceAppendFunc(LanguageParser.SliceAppendFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SliceAppendFunc}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSliceAppendFunc(LanguageParser.SliceAppendFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmebbedFuncTypeOf}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEmebbedFuncTypeOf(LanguageParser.EmebbedFuncTypeOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmebbedFuncTypeOf}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEmebbedFuncTypeOf(LanguageParser.EmebbedFuncTypeOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNegate(LanguageParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNegate(LanguageParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncrementDecrement}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIncrementDecrement(LanguageParser.IncrementDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncrementDecrement}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIncrementDecrement(LanguageParser.IncrementDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rune}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterRune(LanguageParser.RuneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rune}
	 * labeled alternative in {@link LanguageParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitRune(LanguageParser.RuneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#atributoInstancia}.
	 * @param ctx the parse tree
	 */
	void enterAtributoInstancia(LanguageParser.AtributoInstanciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#atributoInstancia}.
	 * @param ctx the parse tree
	 */
	void exitAtributoInstancia(LanguageParser.AtributoInstanciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(LanguageParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(LanguageParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#tipoDeclaracion}.
	 * @param ctx the parse tree
	 */
	void enterTipoDeclaracion(LanguageParser.TipoDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#tipoDeclaracion}.
	 * @param ctx the parse tree
	 */
	void exitTipoDeclaracion(LanguageParser.TipoDeclaracionContext ctx);
}