// Define a grammar called Hello
grammar TypescriptCode;


root: declartion* EOF;

declartion
	: importDeclaration
	| statement
	| classDeclaration
	| methodDeclaration
	| functionDeclaration
	| constructorDeclaration
	| getterDeclaration
	| moduleDeclaration
	;

importDeclaration: 'import' STRING;
classDeclaration: EXPORT? 'class' IDENTIFIER '{' declartion* '}';
methodDeclaration: accessModifier? STATIC? IDENTIFIER genericTypeParameters? parameters (':' typeReferenceList)? statementBlock;
functionDeclaration: 'function' IDENTIFIER parameters (':' typeReferenceList)? statementBlock;
constructorDeclaration: accessModifier? 'constructor' parameters statementBlock;
getterDeclaration: accessModifier? 'get' IDENTIFIER '(' ')' (':' typeReferenceList)? statementBlock;
moduleDeclaration: 'module' IDENTIFIER '{' declartion* '}';

accessModifier: PUBLIC | PRIVATE;
genericTypeParameters: '<' (IDENTIFIER (',' IDENTIFIER)*)? '>';

statementBlock: '{' statement* '}';
statement
	: statementBlock
	| methodCallStatement
	| assignmentStatement
	| throwStatement
	;

methodCallStatement: IDENTIFIER arguments ';';
assignmentStatement: propertyExpression '=' expression ';';
returnStatement: RETURN expression? ';';
throwStatement: 'throw' expression ';';

arguments: '(' (expression (',' expression)*)? ')';


expression : conditional_or_expression;


conditional_or_expression
	: left=conditional_and_expression ('||' right=conditional_or_expression)?
	;

conditional_and_expression
	: left=inclusive_or_expression ('&&' right=conditional_and_expression)?
	;

equality_expression
	: left=relational_expression ((eq='==' | neq='!=')  right=equality_expression)?
	;

relational_expression
	: left=additive_expression ((lt='<' | gt='>' | le='<=' | ge='>=') right=relational_expression)?
	;

additive_expression
	: left=multiplicative_expression ((plus='+' | minus='-') right=additive_expression)?
	;

multiplicative_expression
	: left=unary_expression ((mul='*' | div='/' | mod='%') right=unary_expression)?
	;

unary_expression
	: primary_expression
	| (negate='-' | not='!') unary_expression
	;

primary_expression 
	: pe=primary_expression_start bracket_expression*
	  ((member_access | method_invocation | '++' | '--') bracket_expression*)*
	| parameters '=>' statementBlock;
	;

	//Todo: primitive.method()
primary_expression_start
	: literal                                   #literalExpression
	| identifier type_argument_list?            #simpleNameExpression
	| '(' expression ')'						#parenthesisExpressions
	| 'this'                                    #thisReferenceExpression
	| NEW (type (object_creation_expression
	             | object_or_collection_initializer
	             | '[' expression_list ']' rank_specifier* array_initializer?
	             | rank_specifier+ array_initializer)
	      | anonymous_object_initializer
	      | rank_specifier array_initializer)                       #objectCreationExpression
	;

member_access
	: '.' identifier type_argument_list?
	;

bracket_expression
	: '[' expression ']'
	;

type_argument_list 
	: '<' type ( ',' type)* '>'
	;

method_invocation
	: '(' argument_list? ')'
	;

argument_list 
	: argument ( ',' argument)*
	;

argument
	: (identifier ':')? expression
	;

parameters: '(' (parameter (',' parameter)*)? ')';
parameter: IDENTIFIER (':' typeReferenceList)? ('=' expression)?;
typeReferenceList: typeReference ('|' typeReference)*;
typeReference
	: simpleTypeReference
	| arrayTypeReference
	| methodTypeReference
	;
simpleTypeReference: (IDENTIFIER '.')* IDENTIFIER;
arrayTypeReference: nameReference '[' ']';
methodTypeReference: parameters '=>' typeReferenceList;


STAR: '*';
SLASH: '/';
PLUS: '+';
MINUS: '-';
EQ: '==';
NEQ: '==';
PUBLIC: 'public';
PRIVATE: 'private';
STATIC: 'static';
RETURN: 'return';
EXPORT: 'export';
IDENTIFIER: [a-zA-Z] [a-zA-Z0-9]*;
STRING : '"' ( '\\"' | . )*? '"';
SINGLE_LINE_COMMENT : '//[^\n]*\n' -> channel(HIDDEN);
WS : ( ' ' | '\t' | '\r' | '\n' ) -> channel(HIDDEN);
ERROR_CHAR : .;
