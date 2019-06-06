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
	: (identifier typeArgumentList?) ('.' identifier typeArgumentList?)*
	;

//B.2.2 Types
typeList
	: type ('|' type)*
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
	: moduleOrTypeName
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
	: castExpression ((OP_EQ | OP_NE)  castExpression)*
	;

castExpression
	: relationalExpression (AS type)?
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
	;

primaryExpression  // Null-conditional operators C# 6: https://msdn.microsoft.com/en-us/library/dn986595.aspx
	: pe=primaryExpressionStart bracketExpression*
	  ((memberAccess | methodInvocation | '++' | '--') bracketExpression*)*
	;

nativeMethodInvocationStatement  // Null-conditional operators C# 6: https://msdn.microsoft.com/en-us/library/dn986595.aspx
	: pe=identifier memberAccess methodInvocation ';'
	;

primaryExpressionStart
	: literal                                   #literalExpression
	| identifier typeArgumentList?            #simpleNameExpression
	| OPEN_PARENS expression CLOSE_PARENS       #parenthesisExpressions
	| LITERAL_ACCESS                            #literalAccessExpression
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
	: '[' expressionList ']'
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
	| FOREACH OPEN_PARENS variableType identifier OF expression CLOSE_PARENS embeddedStatement    #foreachStatement

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
	: variableDeclaration
	| expression
	;

//B.2.6 modules;
moduleDeclaration
	: MODULE identifier moduleBody ';'?
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
	| PROTECTED
	| PRIVATE
	| READONLY
	| ABSTRACT
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
	  | getterSetterDeclaration
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

memberName
	: moduleOrTypeName
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

constructorDeclaration
	: CONSTRUCTOR OPEN_PARENS formalParameterList? CLOSE_PARENS body
	;

methodDeclaration // lamdas from C# 6
	: identifier typeParameterList? OPEN_PARENS formalParameterList? CLOSE_PARENS (':' returnTypeList)? methodBody
	;

getterSetterDeclaration // lamdas from C# 6
	: (GET | SET) identifier OPEN_PARENS CLOSE_PARENS (':' returnTypeList)? methodBody
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