// Eclipse Public License - v 1.0, http://www.eclipse.org/legal/epl-v10.html
// Copyright (c) 2013, Christian Wulf (chwchw@gmx.de)
// Copyright (c) 2016-2017, Ivan Kochurkin (kvanttt@gmail.com), Positive Technologies.

parser grammar TypescriptParser;

options { tokenVocab=TypescriptLexer; }

sourceFiles : sourceFile*;

// entry point
sourceFile
locals[string FilePath]
	: BYTE_ORDER_MARK? importDeclaration* moduleMemberDeclarations? EOF
	;

importDeclaration
locals[
	SourceFileContext TargetFile { get; set; }
	public string TargetPath
        {
            get
            {
                var parent = (SourceFileContext) Parent;
                var currentFolder = new FileInfo(parent.FilePath).Directory.FullName;
                var importPath = Path.Combine(currentFolder, RemoveQuotes(stringLiteral().GetText()));
                return Path.GetFullPath(importPath);
            }
        }

        private string RemoveQuotes(string s)
        {
            return s.Substring(1, s.Length - 2);
        }
		private string ignoreMe
]
	: IMPORT stringLiteral ';'
	;

//B.2 Syntactic grammar

//B.2.1 Basic concepts

moduleOrTypeName 
	: (identifier) ('.' identifier)*
	;

//B.2.2 Types
typeList
	: typeInOptionalParenthesis ('|' typeInOptionalParenthesis)*
	;

typeInOptionalParenthesis
	: '(' type ')'
	| type
	;

type 
	: baseType (OPEN_BRACKET CLOSE_BRACKET)*
	;

baseType
	: primitiveType
	| classType  // represents types: enum, class, delegate, typeParameter
	| functionType
	;

primitiveType 
	: NUMBER
	| BOOL
	| STRING
	;


/** moduleOrTypeName, OBJECT, STRING */
classType 
	: moduleOrTypeName typeArgumentList?
	;

typeArgumentList 
	: '<' typeList ( ',' typeList)* '>'
	;

functionType
	: OPEN_PARENS formalParameterList? CLOSE_PARENS rightArrow returnTypeList
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
	| conditionalOrExpression
	;

assignment
	: unaryExpression assignmentOperator expression
	;

assignmentOperator
	: '=' | '+=' | '-=' | '*=' | '/=' | '%=' //| '&=' | '|=' | '^=' | '<<=' | rightShiftAssignment
	;

conditionalOrExpression
	: conditionalAndExpression (OP_OR conditionalAndExpression)*
	;

conditionalAndExpression
	: equalityExpression (OP_AND equalityExpression)*
	;

// inclusiveOrExpression
// 	: exclusiveOrExpression ('|' exclusiveOrExpression)*
// 	;

// exclusiveOrExpression
// 	: andExpression ('^' andExpression)*
// 	;

// andExpression
// 	: equalityExpression ('&' equalityExpression)*
// 	;

equalityExpression
	: castExpression ((OP_EQ | OP_NE)  castExpression)*
	;

castExpression
	: relationalExpression (AS type)?
	;

relationalExpression
	: additiveExpression (('<' | '>' | '<=' | '>=') additiveExpression)*
	;

// shiftExpression
// 	: additiveExpression (('<<' | rightShift)  additiveExpression)*
// 	;

additiveExpression
	: multiplicativeExpression (('+' | '-')  multiplicativeExpression)*
	;

multiplicativeExpression
	: unaryExpression (('*' | '/' | '%')  unaryExpression)*
	;

unaryExpression
	: primaryExpression
	| '+' unaryExpression
	| '-' unaryExpression
	| BANG unaryExpression
	;

primaryExpression 
	: pe=primaryExpressionStart bracketExpression*
	  ((memberAccess | methodInvocation | '++' | '--') bracketExpression*)*
	;

nativeMethodInvocationStatement 
	: pe=identifier memberAccess methodInvocation ';'
	;

primaryExpressionStart
	: literal                                   #literalExpression
	| identifier typeArgumentList?            #simpleNameExpression
	| OPEN_PARENS expression CLOSE_PARENS       #parenthesisExpressions
	| THIS                                      #thisReferenceExpression
	| NEW type objectCreationExpression                       #objectCreation
	| '[' expressionList? ']' #arrayCreationExpression
	;

expressionList
	: expression ( ',' expression)*
	;

memberAccess
	: '.' identifier typeArgumentList?
	;

bracketExpression
	: '[' expression ']'
	;

lambdaExpression
	: anonymousFunctionSignature rightArrow anonymousFunctionBody
	;

anonymousFunctionSignature
	: OPEN_PARENS CLOSE_PARENS
	| OPEN_PARENS explicitAnonymousFunctionParameterList CLOSE_PARENS
	//| OPEN_PARENS implicitAnonymousFunctionParameterList CLOSE_PARENS
	//| identifier
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
	: variableDeclaration ';'  #declarationStatement
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
	| IF OPEN_PARENS expression CLOSE_PARENS embeddedStatement (ELSE embeddedStatement)?               #ifStatement
    | SWITCH OPEN_PARENS expression CLOSE_PARENS OPEN_BRACE switchSection* CLOSE_BRACE           #switchStatement

    // iteration statements
	| WHILE OPEN_PARENS expression CLOSE_PARENS embeddedStatement                                        #whileStatement
	| FOR OPEN_PARENS forInitializer? ';' expression? ';' forIterator? CLOSE_PARENS embeddedStatement  #forStatement
	| FOR OPEN_PARENS variableType identifier OF expression CLOSE_PARENS embeddedStatement    #foreachStatement

    // jump statements
	| BREAK ';'                                                   #breakStatement
	| CONTINUE ';'                                                #continueStatement
	| RETURN expression? ';'                                      #returnStatement
	;

block
	: OPEN_BRACE statementList? CLOSE_BRACE
	;

variableDeclaration
	: variableType variableDeclarator ( ','  variableDeclarator)*
	;

variableType 
	: VAR | CONST | LET ;

variableDeclarator
	: identifier (':' type)? ('=' expression)?
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
	: variableDeclaration
	| expression (','  expression)*
	;

forIterator
	: expression (','  expression)*
	;

//B.2.6 modules;
moduleDeclaration
	: EXPORT? MODULE identifier moduleBody ';'?
	;

moduleBody
	: OPEN_BRACE moduleMemberDeclarations? CLOSE_BRACE
	;

moduleMemberDeclarations
	: moduleMemberDeclaration+
	;

moduleMemberDeclaration
	: moduleDeclaration
	| typeDeclaration
	| variableDeclaration ';'
	| nativeMethodInvocationStatement
	| functionDeclaration
	;

functionDeclaration
	: EXPORT? FUNCTION methodDeclaration 
	;

typeDeclaration
	: allMemberModifiers? (classDefinition | enumDefinition)
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
//	| FUNCTION methodMemberName typeParameterList? OPEN_PARENS formalParameterList? CLOSE_PARENS (':' returnTypeList)? methodBody #classFunctionDeclaration
	;

allMemberModifiers
	: allMemberModifier+
	;

allMemberModifier
	: PUBLIC
	//| PROTECTED
	| PRIVATE
	| READONLY
	//| ABSTRACT
	| STATIC
	| EXPORT
	;

// represents the intersection of structMemberDeclaration and classMemberDeclaration
commonMemberDeclaration
	: typedMemberDeclaration
	| constructorDeclaration
	;

typedMemberDeclaration
	: 
	  ( methodDeclaration
	  | getterDeclaration
	  | setterDeclaration
	  | classField ';'
	  )
	;

classField
	: variableDeclarator ( ','  variableDeclarator)*
	;

returnTypeList
	: returnType ('|' returnType)*
	;

returnType
	: type
	| VOID
	;

methodBody
	: block
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
	| NULL
	;

booleanLiteral
	: TRUE
	| FALSE
	;

stringLiteral
	: REGULAR_STRING
	| SINGLE_QUOTE_STRING_LITERAL
	;

// -------------------- extra rules for modularization --------------------------------

classDefinition
	: CLASS identifier typeParameterList? (EXTENDS type)?
	    classBody ';'?
	;

enumDefinition
	: ENUM identifier enumBody ';'?
	;

constructorDeclaration
	: CONSTRUCTOR OPEN_PARENS formalParameterList? CLOSE_PARENS body
	;

methodDeclaration
	: identifier typeParameterList? OPEN_PARENS formalParameterList? CLOSE_PARENS (':' returnTypeList) methodBody
	;

getterDeclaration
	: GET identifier OPEN_PARENS CLOSE_PARENS (':' returnTypeList)? methodBody
	;

setterDeclaration
	: SET identifier OPEN_PARENS formalParameterList CLOSE_PARENS (':' returnTypeList)? methodBody
	;

argDeclaration
	: identifier ':' typeList ('=' expression)?
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