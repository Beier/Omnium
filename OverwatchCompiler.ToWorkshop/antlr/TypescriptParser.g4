// Eclipse Public License - v 1.0, http://www.eclipse.org/legal/epl-v10.html
// Copyright (c) 2013, Christian Wulf (chwchw@gmx.de)
// Copyright (c) 2016-2017, Ivan Kochurkin (kvanttt@gmail.com), Positive Technologies.

parser grammar TypescriptParser;

options { tokenVocab=TypescriptLexer; }

sourceFiles : sourceFile*;

// entry point
sourceFile
	: BYTE_ORDER_MARK? importDeclaration* namespaceMemberDeclarations? EOF
	;

importDeclaration: IMPORT stringLiteral ';';

//B.2 Syntactic grammar

//B.2.1 Basic concepts

namespaceOrTypeName 
	: (identifier typeArgumentList?) ('.' identifier typeArgumentList?)*
	;

//B.2.2 Types
type 
	: baseType (OPEN_BRACKET CLOSE_BRACKET)*
	;

baseType
	: simpleType
	| classType  // represents types: enum, class, delegate, typeParameter
	;

simpleType 
	: numericType
	| BOOL
	;

numericType 
	: NUMBER
	;


/** namespaceOrTypeName, OBJECT, STRING */
classType 
	: namespaceOrTypeName
	| STRING
	;

typeArgumentList 
	: '<' type ( ',' type)* '>'
	;

//B.2.4 Expressions
argumentList 
	: argument ( ',' argument)*
	;

argument
	: (identifier ':')? expression
	;

expression
	: assignment
	| nonAssignmentExpression
	;

nonAssignmentExpression
	: lambdaExpression
	| conditionalExpression
	;

assignment
	: unaryExpression assignmentOperator expression
	;

assignmentOperator
	: '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' | '<<=' | rightShiftAssignment
	;

conditionalExpression
	: conditionalOrExpression ('?' expression ':' expression)?
	;

conditionalOrExpression
	: conditionalAndExpression (OP_OR conditionalAndExpression)*
	;

conditionalAndExpression
	: inclusiveOrExpression (OP_AND inclusiveOrExpression)*
	;

inclusiveOrExpression
	: exclusiveOrExpression ('|' exclusiveOrExpression)*
	;

exclusiveOrExpression
	: andExpression ('^' andExpression)*
	;

andExpression
	: equalityExpression ('&' equalityExpression)*
	;

equalityExpression
	: relationalExpression ((OP_EQ | OP_NE)  relationalExpression)*
	;

relationalExpression
	: shiftExpression (('<' | '>' | '<=' | '>=') shiftExpression)*
	;

shiftExpression
	: additiveExpression (('<<' | rightShift)  additiveExpression)*
	;

additiveExpression
	: multiplicativeExpression (('+' | '-')  multiplicativeExpression)*
	;

multiplicativeExpression
	: unaryExpression (('*' | '/' | '%')  unaryExpression)*
	;

// https://msdn.microsoft.com/library/6a71f45d(v=vs.110).aspx
unaryExpression
	: primaryExpression
	| '+' unaryExpression
	| '-' unaryExpression
	| BANG unaryExpression
	| '~' unaryExpression
	| OPEN_PARENS type CLOSE_PARENS unaryExpression
	;

primaryExpression  // Null-conditional operators C# 6: https://msdn.microsoft.com/en-us/library/dn986595.aspx
	: pe=primaryExpressionStart bracketExpression*
	  ((memberAccess | methodInvocation | '++' | '--') bracketExpression*)*
	;

primaryExpressionStart
	: literal                                   #literalExpression
	| identifier typeArgumentList?            #simpleNameExpression
	| OPEN_PARENS expression CLOSE_PARENS       #parenthesisExpressions
	| LITERAL_ACCESS                            #literalAccessExpression
	| THIS                                      #thisReferenceExpression
	| NEW type (objectCreationExpression | '[' expression ']')                       #objectCreation
	;

memberAccess
	: '.' identifier typeArgumentList?
	;

bracketExpression
	: '[' expression ( ',' expression)* ']'
	;

lambdaExpression
	: anonymousFunctionSignature rightArrow anonymousFunctionBody
	;

anonymousFunctionSignature
	: OPEN_PARENS CLOSE_PARENS
	| OPEN_PARENS explicitAnonymousFunctionParameterList CLOSE_PARENS
	| OPEN_PARENS implicitAnonymousFunctionParameterList CLOSE_PARENS
	| identifier
	;

explicitAnonymousFunctionParameterList
	: explicitAnonymousFunctionParameter ( ',' explicitAnonymousFunctionParameter)*
	;

explicitAnonymousFunctionParameter
	: identifier ':' type
	;

implicitAnonymousFunctionParameterList
	: identifier (',' identifier)*
	;

anonymousFunctionBody
	: expression
	| block
	;

//B.2.5 Statements
statement
	: localVariableDeclaration ';'  #declarationStatement
	| embeddedStatement             #embedded                               
	;

embeddedStatement
	: block
	| simpleEmbeddedStatement
	;

simpleEmbeddedStatement
	: ';'                                                         #emptyStatement
	| expression ';'                                              #expressionStatement

	// selection statements
	| IF OPEN_PARENS expression CLOSE_PARENS ifBody (ELSE ifBody)?               #ifStatement
    | SWITCH OPEN_PARENS expression CLOSE_PARENS OPEN_BRACE switchSection* CLOSE_BRACE           #switchStatement

    // iteration statements
	| WHILE OPEN_PARENS expression CLOSE_PARENS embeddedStatement                                        #whileStatement
	| DO embeddedStatement WHILE OPEN_PARENS expression CLOSE_PARENS ';'                                 #doStatement
	| FOR OPEN_PARENS forInitializer? ';' expression? ';' forIterator? CLOSE_PARENS embeddedStatement  #forStatement
	| FOREACH OPEN_PARENS localVariableType identifier OF expression CLOSE_PARENS embeddedStatement    #foreachStatement

    // jump statements
	| BREAK ';'                                                   #breakStatement
	| CONTINUE ';'                                                #continueStatement
	| RETURN expression? ';'                                      #returnStatement
	| THROW expression? ';'                                       #throwStatement

	| TRY block (catchClauses finallyClause? | finallyClause)  #tryStatement
	;

block
	: OPEN_BRACE statementList? CLOSE_BRACE
	;
localVariableDeclaration
	: localVariableType localVariableDeclarator ( ','  localVariableDeclarator)*
	;

localVariableType 
	: VAR | CONST | LET ;

localVariableDeclarator
	: identifier (':' type)? ('=' expression)?
	;

ifBody
	: block
	| simpleEmbeddedStatement
	;

switchSection
	: switchLabel+ statementList
	;

switchLabel
	: CASE expression ':'
	| DEFAULT ':'
	;

statementList
	: statement+
	;

forInitializer
	: localVariableDeclaration
	| expression (','  expression)*
	;

forIterator
	: expression (','  expression)*
	;

catchClauses
	: specificCatchClause (specificCatchClause)* generalCatchClause?
	| generalCatchClause
	;

specificCatchClause
	: CATCH OPEN_PARENS classType identifier? CLOSE_PARENS block
	;

generalCatchClause
	: CATCH block
	;

finallyClause
	: FINALLY block
	;

resourceAcquisition
	: localVariableDeclaration
	| expression
	;

//B.2.6 Namespaces;
namespaceDeclaration
	: MODULE identifier namespaceBody ';'?
	;

namespaceBody
	: OPEN_BRACE namespaceMemberDeclarations? CLOSE_BRACE
	;

namespaceMemberDeclarations
	: namespaceMemberDeclaration+
	;

namespaceMemberDeclaration
	: namespaceDeclaration
	| typeDeclaration
	| classMemberDeclaration
	| statement
	;

typeDeclaration
	: allMemberModifiers?
      (classDefinition | enumDefinition)
  	;

//B.2.7 Classes;
typeParameterList
	: '<' typeParameter (','  typeParameter)* '>'
	;

typeParameter
	: identifier
	;

classBody
	: OPEN_BRACE classMemberDeclarations? CLOSE_BRACE
	;

classMemberDeclarations
	: classMemberDeclaration+
	;

classMemberDeclaration
	: allMemberModifiers? commonMemberDeclaration
	;

allMemberModifiers
	: allMemberModifier+
	;

allMemberModifier
	: NEW
	| PUBLIC
	| PROTECTED
	| PRIVATE
	| READONLY
	| OVERRIDE
	| ABSTRACT
	| STATIC
	;

// represents the intersection of structMemberDeclaration and classMemberDeclaration
commonMemberDeclaration
	: typedMemberDeclaration
	| constructorDeclaration
	| classDefinition
	| enumDefinition
	;

typedMemberDeclaration
	: 
	  ( methodDeclaration
	  | fieldDeclaration
	  )
	;

variableDeclarators
	: variableDeclarator (','  variableDeclarator)*
	;

variableDeclarator
	: identifier (':' type)? ('=' variableInitializer)?
	;

variableInitializer
	: expression
	;

returnType
	: type
	| VOID
	;

memberName
	: namespaceOrTypeName
	;

methodBody
	: block
	| ';'
	;

formalParameterList
	: fixedParameters
	;

fixedParameters
	: fixedParameter ( ',' fixedParameter )*
	;

fixedParameter
	: argDeclaration
	;

constructorInitializer
	: ':' SUPER OPEN_PARENS argumentList? CLOSE_PARENS
	;

body
	: block
	| ';'
	;

//B.2.10 Interfaces
variantTypeParameterList
	: '<' variantTypeParameter (',' variantTypeParameter)* '>'
	;

variantTypeParameter
	: identifier
	;

//B.2.11 Enums

enumBody
	: OPEN_BRACE (enumMemberDeclaration (','  enumMemberDeclaration)* ','?)? CLOSE_BRACE
	;

enumMemberDeclaration
	: identifier ('=' expression)?
	;

//B.3 Grammar extensions for unsafe code

rightArrow
	: first='=' second='>' {$first.index + 1 == $second.index}? // Nothing between the tokens?
	;

rightShift
	: first='>' second='>' {$first.index + 1 == $second.index}? // Nothing between the tokens?
	;

rightShiftAssignment
	: first='>' second='>=' {$first.index + 1 == $second.index}? // Nothing between the tokens?
	;

literal
	: booleanLiteral
	| stringLiteral
	| INTEGER_LITERAL
	| HEX_INTEGER_LITERAL
	| REAL_LITERAL
	| CHARACTER_LITERAL
	| NULL
	;

booleanLiteral
	: TRUE
	| FALSE
	;

stringLiteral
	: REGULAR_STRING
	;

// -------------------- extra rules for modularization --------------------------------

classDefinition
	: CLASS identifier typeParameterList? 
	    classBody ';'?
	;

enumDefinition
	: ENUM identifier enumBody ';'?
	;

fieldDeclaration
	: variableDeclarators ';'
	;

constructorDeclaration
	: identifier OPEN_PARENS formalParameterList? CLOSE_PARENS body
	;

methodDeclaration // lamdas from C# 6
	: (GET | SET)? methodMemberName typeParameterList? OPEN_PARENS formalParameterList? CLOSE_PARENS
	    (':' returnType)? (methodBody | rightArrow expression ';')
	;

methodMemberName
	: (identifier | identifier '::' identifier) (typeArgumentList? '.' identifier)*
	;

argDeclaration
	: identifier (':' type)? ('=' expression)?
	;

methodInvocation
	: OPEN_PARENS argumentList? CLOSE_PARENS
	;

objectCreationExpression
	: OPEN_PARENS argumentList? CLOSE_PARENS
	;

identifier
	: IDENTIFIER
	| GET
	| LET
	| SET
	| VAR
	| NUMBER
	;