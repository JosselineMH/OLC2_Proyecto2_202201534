	grammar Language;


	program: (dclFuera*)? 'func main()' '{' dcl* '}';

	dcl: declaracionVariable  (';')? 
		| declaracionFuncForanea 
		| structDecl
		| sentencia (';')? ;

	dclFuera: declaracionVariable  (';')? 
		| declaracionFuncForanea 
		| structDecl;

	declaracionVariable: 'var' ID tipoDeclaracion '=' expresion  	# DeclaracionExplicita
						| 'var' ID tipoDeclaracion 	 				# DeclaracionPorDefecto
						| ID ':=' expresion   						# DeclaracionImplicita
						| slice  									# DeclaracionSlice;

	declaracionFuncForanea: 'func' ID '(' parametros? ')' tipoDeclaracion?  '{' dcl* '}';

	parametros: ID ('[' ']')? tipoFunc (',' ID ('[' ']')? tipoFunc)*;

	tipoFunc: tipoDeclaracion
			| ID ;

	slice: ID ':=' expresion	# DeclaracionSliceValores
		| 'var' ID '[' ']' tipoDeclaracion     								# DeclaracionSliceVacio
		| ID '=' ID                                							# DeclaracionSliceCopia
		| ID ':=' '[' ']' ('[' ']')+ tipoDeclaracion '{' elementosSlice? '}' # DeclaracionSliceMultidimensional;

	elementosSlice: elementoSlice (',' elementoSlice)* ','?;

	elementoSlice: '{' elementosSlice? '}'  
				| '{' (expresion (',' expresion)*)? '}';


	structDecl: 'type' ID 'struct' '{' atributoStruct* '}' ;          

	atributoStruct: ID tipoFunc (ID tipoFunc)*;

	sentencia: expresion  													# ExprStmt 
			| 'fmt.Println(' (expresion (',' expresion)*)? ')'				# PrintStmt
			| '{' dcl* '}' 													# BlockStmt
			| 'if' ('(')? expresion (')')? sentencia ('else' sentencia)? 	# IfStmt
			| 'switch' ('(')? expresion (')')? '{' stmtCase* stmtDefault? '}' 	# SwitchStmt
			| 'for' ('(')? expresion (')')? sentencia 							# ForWhileStmt
			| 'for' ('(')? forInit  expresion ';' expresion (')')? sentencia	# ForStmt
			| 'for' ('(')?  indice=ID ',' valor=ID ':=' 'range' ident=ID (')')? sentencia 	# ForRangeStmt
			| 'break'															# BreakStmt
			| 'continue'														# ContinueStmt
			| 'return' expresion? 												# ReturnStmt;

	stmtCase: 'case' expresion ':' dcl*;
	stmtDefault: 'default' ':' dcl*  ;

	forInit: declaracionVariable ';'
			| expresion ';';

	expresion:	
			'strconv.Atoi(' expresion ')'					# EmebbedFuncAtoi
			| 'strconv.ParseFloat(' expresion ')'			# EmebbedFuncParseFloat
			| 'reflect.TypeOf(' expresion ')'				# EmebbedFuncTypeOf
			| 'slices.Index(' ID ',' expresion ')'			# SliceFuncIndex
			| 'strings.Join(' ID ',' expresion ')'			# SliceStringFuncJoin
			| 'len(' expresion ')'							# SliceLenFunc
			| 'append(' ID ',' expresion ')'				# SliceAppendFunc
			| ID '[' expresion ']'							# SliceAccess
			| ID ('[' expresion ']')+ 						# SliceMatrixAccess
			|'-' expresion									# Negate
			| expresion call+								# Callee
			| '!' expresion									# LogicalNot
			| expresion op = ('*' | '/' | '%') expresion	# MulDivMod
			| expresion op = ('+' | '-') expresion			# AddSub
			| expresion op = ('<' | '<=' | '>' | '>=' ) expresion 			# Relational
			| expresion op = ('==' | '!=') expresion		# Equality
			| expresion op = '&&' expresion					# LogicalAnd
			| expresion op = '||' expresion					# LogicalOr
			| ID op = ('++' | '--')							# IncrementDecrement
			| ID ('.' ID)+ '=' expresion  						# StructAssign
			| ID op = ( '=' | '+=' | '-=' ) expresion		# AssignVar
			| ID '[' indice = expresion ']' '=' valor = expresion		# AssignSlice
			| ID ('[' expresion ']')+ '=' expresion						# AssignSliceMultidimensional
			| '[' ']' tipoDeclaracion '{' expresion (',' expresion)* '}' # SliceLiteral
			| BOOL														# Boolean
			| FLOAT														# Float
			| RUNE														# Rune
			| STRING													# String
			| INT												# Number
			| 'nil'												# Nil
			| ID												# Identifier
			| ID ('.' ID)+                                      # StructAccess
			| '(' expresion ')'									# Parens
			| ID '{' atributoInstancia '}'						# StructInstancia;

	atributoInstancia: ID ':' expresion (',' ID ':' expresion)*;

	call: '(' args? ')';

	args: expresion (',' expresion)*;

	tipoDeclaracion: 
					'int'
				| 'float64'
				| 'string'
				| 'bool'
				| 'rune';	

	INT: [0-9]+;
	BOOL: 'true' | 'false';
	FLOAT: [0-9]+ '.' [0-9]+;
	STRING: '"' (ESC_SEQ | ~["\\])* '"';

	fragment ESC_SEQ: '\\' ( '"' | '\\' | 'n' | 'r' | 't' );


	RUNE: '\'' . '\'';

	ID: [_a-zA-Z][_a-zA-Z0-9]*;

	WS: [ \t\r\n]+ -> skip;

	COMENTARIOLINEA: '//' ~[\r\n]* -> skip;
	COMENTARIOMULTIL: '/*' .*? '*/' -> skip;
