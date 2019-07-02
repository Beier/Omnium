// Generated from c:\Git\overwatch-typescript-compiler\OverwatchCompiler.ToWorkshop\antlr\TypescriptParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TypescriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BYTE_ORDER_MARK=1, SINGLE_LINE_COMMENT=2, DELIMITED_COMMENT=3, WHITESPACES=4, 
		ABSTRACT=5, BOOL=6, BREAK=7, CASE=8, CATCH=9, CLASS=10, CONST=11, CONTINUE=12, 
		DEFAULT=13, DO=14, ELSE=15, ENUM=16, FALSE=17, FINALLY=18, FOR=19, FOREACH=20, 
		GET=21, IF=22, LET=23, NEW=24, NULL=25, OVERRIDE=26, PARAMS=27, PRIVATE=28, 
		PROTECTED=29, PUBLIC=30, READONLY=31, RETURN=32, SET=33, STATIC=34, STRING=35, 
		SWITCH=36, THIS=37, THROW=38, TRUE=39, TRY=40, VAR=41, VOID=42, WHILE=43, 
		NUMBER=44, SUPER=45, MODULE=46, OF=47, IMPORT=48, FUNCTION=49, CONSTRUCTOR=50, 
		EXPORT=51, AS=52, IDENTIFIER=53, LITERAL_ACCESS=54, INTEGER_LITERAL=55, 
		HEX_INTEGER_LITERAL=56, REAL_LITERAL=57, REGULAR_STRING=58, SINGLE_QUOTE_STRING_LITERAL=59, 
		OPEN_BRACE=60, CLOSE_BRACE=61, OPEN_BRACKET=62, CLOSE_BRACKET=63, OPEN_PARENS=64, 
		CLOSE_PARENS=65, DOT=66, COMMA=67, COLON=68, SEMICOLON=69, PLUS=70, MINUS=71, 
		STAR=72, DIV=73, PERCENT=74, AMP=75, BITWISE_OR=76, CARET=77, BANG=78, 
		TILDE=79, ASSIGNMENT=80, LT=81, GT=82, INTERR=83, DOUBLE_COLON=84, OP_COALESCING=85, 
		OP_INC=86, OP_DEC=87, OP_AND=88, OP_OR=89, OP_PTR=90, OP_EQ=91, OP_NE=92, 
		OP_LE=93, OP_GE=94, OP_ADD_ASSIGNMENT=95, OP_SUB_ASSIGNMENT=96, OP_MULT_ASSIGNMENT=97, 
		OP_DIV_ASSIGNMENT=98, OP_MOD_ASSIGNMENT=99, OP_AND_ASSIGNMENT=100, OP_OR_ASSIGNMENT=101, 
		OP_XOR_ASSIGNMENT=102, OP_LEFT_SHIFT=103, OP_LEFT_SHIFT_ASSIGNMENT=104, 
		DIRECTIVE_WHITESPACES=105, DIGITS=106, DEFINE=107, UNDEF=108, ELIF=109, 
		ENDIF=110, LINE=111, ERROR=112, WARNING=113, REGION=114, ENDREGION=115, 
		PRAGMA=116, DIRECTIVE_HIDDEN=117, CONDITIONAL_SYMBOL=118, DIRECTIVE_NEW_LINE=119, 
		TEXT=120, EXTENDS=121;
	public static final int
		RULE_sourceFiles = 0, RULE_sourceFile = 1, RULE_importDeclaration = 2, 
		RULE_moduleOrTypeName = 3, RULE_typeList = 4, RULE_typeInOptionalParenthesis = 5, 
		RULE_type = 6, RULE_baseType = 7, RULE_primitiveType = 8, RULE_classType = 9, 
		RULE_typeArgumentList = 10, RULE_functionType = 11, RULE_argumentList = 12, 
		RULE_argument = 13, RULE_expression = 14, RULE_nonAssignmentExpression = 15, 
		RULE_assignment = 16, RULE_assignmentOperator = 17, RULE_conditionalOrExpression = 18, 
		RULE_conditionalAndExpression = 19, RULE_equalityExpression = 20, RULE_castExpression = 21, 
		RULE_relationalExpression = 22, RULE_additiveExpression = 23, RULE_multiplicativeExpression = 24, 
		RULE_unaryExpression = 25, RULE_primaryExpression = 26, RULE_nativeMethodInvocationStatement = 27, 
		RULE_primaryExpressionStart = 28, RULE_expressionList = 29, RULE_memberAccess = 30, 
		RULE_bracketExpression = 31, RULE_lambdaExpression = 32, RULE_anonymousFunctionSignature = 33, 
		RULE_explicitAnonymousFunctionParameterList = 34, RULE_explicitAnonymousFunctionParameter = 35, 
		RULE_implicitAnonymousFunctionParameterList = 36, RULE_anonymousFunctionBody = 37, 
		RULE_statement = 38, RULE_embeddedStatement = 39, RULE_simpleEmbeddedStatement = 40, 
		RULE_block = 41, RULE_variableDeclaration = 42, RULE_variableType = 43, 
		RULE_variableDeclarator = 44, RULE_switchSection = 45, RULE_switchLabel = 46, 
		RULE_statementList = 47, RULE_forInitializer = 48, RULE_forIterator = 49, 
		RULE_moduleDeclaration = 50, RULE_moduleBody = 51, RULE_moduleMemberDeclarations = 52, 
		RULE_moduleMemberDeclaration = 53, RULE_functionDeclaration = 54, RULE_typeDeclaration = 55, 
		RULE_typeParameterList = 56, RULE_typeParameter = 57, RULE_classBody = 58, 
		RULE_classMemberDeclarations = 59, RULE_classMemberDeclaration = 60, RULE_allMemberModifiers = 61, 
		RULE_allMemberModifier = 62, RULE_commonMemberDeclaration = 63, RULE_typedMemberDeclaration = 64, 
		RULE_classField = 65, RULE_returnTypeList = 66, RULE_returnType = 67, 
		RULE_methodBody = 68, RULE_formalParameterList = 69, RULE_fixedParameters = 70, 
		RULE_fixedParameter = 71, RULE_constructorInitializer = 72, RULE_body = 73, 
		RULE_variantTypeParameterList = 74, RULE_variantTypeParameter = 75, RULE_enumBody = 76, 
		RULE_enumMemberDeclaration = 77, RULE_rightArrow = 78, RULE_rightShift = 79, 
		RULE_rightShiftAssignment = 80, RULE_literal = 81, RULE_booleanLiteral = 82, 
		RULE_stringLiteral = 83, RULE_classDefinition = 84, RULE_enumDefinition = 85, 
		RULE_constructorDeclaration = 86, RULE_methodDeclaration = 87, RULE_getterDeclaration = 88, 
		RULE_setterDeclaration = 89, RULE_argDeclaration = 90, RULE_methodInvocation = 91, 
		RULE_objectCreationExpression = 92, RULE_identifier = 93;
	public static final String[] ruleNames = {
		"sourceFiles", "sourceFile", "importDeclaration", "moduleOrTypeName", 
		"typeList", "typeInOptionalParenthesis", "type", "baseType", "primitiveType", 
		"classType", "typeArgumentList", "functionType", "argumentList", "argument", 
		"expression", "nonAssignmentExpression", "assignment", "assignmentOperator", 
		"conditionalOrExpression", "conditionalAndExpression", "equalityExpression", 
		"castExpression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
		"unaryExpression", "primaryExpression", "nativeMethodInvocationStatement", 
		"primaryExpressionStart", "expressionList", "memberAccess", "bracketExpression", 
		"lambdaExpression", "anonymousFunctionSignature", "explicitAnonymousFunctionParameterList", 
		"explicitAnonymousFunctionParameter", "implicitAnonymousFunctionParameterList", 
		"anonymousFunctionBody", "statement", "embeddedStatement", "simpleEmbeddedStatement", 
		"block", "variableDeclaration", "variableType", "variableDeclarator", 
		"switchSection", "switchLabel", "statementList", "forInitializer", "forIterator", 
		"moduleDeclaration", "moduleBody", "moduleMemberDeclarations", "moduleMemberDeclaration", 
		"functionDeclaration", "typeDeclaration", "typeParameterList", "typeParameter", 
		"classBody", "classMemberDeclarations", "classMemberDeclaration", "allMemberModifiers", 
		"allMemberModifier", "commonMemberDeclaration", "typedMemberDeclaration", 
		"classField", "returnTypeList", "returnType", "methodBody", "formalParameterList", 
		"fixedParameters", "fixedParameter", "constructorInitializer", "body", 
		"variantTypeParameterList", "variantTypeParameter", "enumBody", "enumMemberDeclaration", 
		"rightArrow", "rightShift", "rightShiftAssignment", "literal", "booleanLiteral", 
		"stringLiteral", "classDefinition", "enumDefinition", "constructorDeclaration", 
		"methodDeclaration", "getterDeclaration", "setterDeclaration", "argDeclaration", 
		"methodInvocation", "objectCreationExpression", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\u00EF\u00BB\u00BF'", null, null, null, "'abstract'", "'boolean'", 
		"'break'", "'case'", "'catch'", "'class'", "'const'", "'continue'", "'default'", 
		"'do'", "'else'", "'enum'", "'false'", "'finally'", "'for'", "'foreach'", 
		"'get'", "'if'", "'let'", "'new'", "'null'", "'override'", "'params'", 
		"'private'", "'protected'", "'public'", "'readonly'", "'return'", "'set'", 
		"'static'", "'string'", "'switch'", "'this'", "'throw'", "'true'", "'try'", 
		"'var'", "'void'", "'while'", "'number'", "'super'", "'module'", "'of'", 
		"'import'", "'function'", "'constructor'", "'export'", "'as'", null, null, 
		null, null, null, null, null, "'{'", "'}'", "'['", "']'", "'('", "')'", 
		"'.'", "','", "':'", "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&'", 
		"'|'", "'^'", "'!'", "'~'", "'='", "'<'", "'>'", "'?'", "'::'", "'??'", 
		"'++'", "'--'", "'&&'", "'||'", "'->'", "'=='", "'!='", "'<='", "'>='", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<'", 
		"'<<='", null, null, "'define'", "'undef'", "'elif'", "'endif'", "'line'", 
		null, null, null, null, null, "'hidden'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BYTE_ORDER_MARK", "SINGLE_LINE_COMMENT", "DELIMITED_COMMENT", "WHITESPACES", 
		"ABSTRACT", "BOOL", "BREAK", "CASE", "CATCH", "CLASS", "CONST", "CONTINUE", 
		"DEFAULT", "DO", "ELSE", "ENUM", "FALSE", "FINALLY", "FOR", "FOREACH", 
		"GET", "IF", "LET", "NEW", "NULL", "OVERRIDE", "PARAMS", "PRIVATE", "PROTECTED", 
		"PUBLIC", "READONLY", "RETURN", "SET", "STATIC", "STRING", "SWITCH", "THIS", 
		"THROW", "TRUE", "TRY", "VAR", "VOID", "WHILE", "NUMBER", "SUPER", "MODULE", 
		"OF", "IMPORT", "FUNCTION", "CONSTRUCTOR", "EXPORT", "AS", "IDENTIFIER", 
		"LITERAL_ACCESS", "INTEGER_LITERAL", "HEX_INTEGER_LITERAL", "REAL_LITERAL", 
		"REGULAR_STRING", "SINGLE_QUOTE_STRING_LITERAL", "OPEN_BRACE", "CLOSE_BRACE", 
		"OPEN_BRACKET", "CLOSE_BRACKET", "OPEN_PARENS", "CLOSE_PARENS", "DOT", 
		"COMMA", "COLON", "SEMICOLON", "PLUS", "MINUS", "STAR", "DIV", "PERCENT", 
		"AMP", "BITWISE_OR", "CARET", "BANG", "TILDE", "ASSIGNMENT", "LT", "GT", 
		"INTERR", "DOUBLE_COLON", "OP_COALESCING", "OP_INC", "OP_DEC", "OP_AND", 
		"OP_OR", "OP_PTR", "OP_EQ", "OP_NE", "OP_LE", "OP_GE", "OP_ADD_ASSIGNMENT", 
		"OP_SUB_ASSIGNMENT", "OP_MULT_ASSIGNMENT", "OP_DIV_ASSIGNMENT", "OP_MOD_ASSIGNMENT", 
		"OP_AND_ASSIGNMENT", "OP_OR_ASSIGNMENT", "OP_XOR_ASSIGNMENT", "OP_LEFT_SHIFT", 
		"OP_LEFT_SHIFT_ASSIGNMENT", "DIRECTIVE_WHITESPACES", "DIGITS", "DEFINE", 
		"UNDEF", "ELIF", "ENDIF", "LINE", "ERROR", "WARNING", "REGION", "ENDREGION", 
		"PRAGMA", "DIRECTIVE_HIDDEN", "CONDITIONAL_SYMBOL", "DIRECTIVE_NEW_LINE", 
		"TEXT", "EXTENDS"
	};
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
	public String getGrammarFileName() { return "TypescriptParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TypescriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SourceFilesContext extends ParserRuleContext {
		public List<SourceFileContext> sourceFile() {
			return getRuleContexts(SourceFileContext.class);
		}
		public SourceFileContext sourceFile(int i) {
			return getRuleContext(SourceFileContext.class,i);
		}
		public SourceFilesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceFiles; }
	}

	public final SourceFilesContext sourceFiles() throws RecognitionException {
		SourceFilesContext _localctx = new SourceFilesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceFiles);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(188);
					sourceFile();
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class SourceFileContext extends ParserRuleContext {
		public string FilePath;
		public TerminalNode EOF() { return getToken(TypescriptParser.EOF, 0); }
		public TerminalNode BYTE_ORDER_MARK() { return getToken(TypescriptParser.BYTE_ORDER_MARK, 0); }
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public ModuleMemberDeclarationsContext moduleMemberDeclarations() {
			return getRuleContext(ModuleMemberDeclarationsContext.class,0);
		}
		public SourceFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceFile; }
	}

	public final SourceFileContext sourceFile() throws RecognitionException {
		SourceFileContext _localctx = new SourceFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sourceFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BYTE_ORDER_MARK) {
				{
				setState(194);
				match(BYTE_ORDER_MARK);
				}
			}

			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(197);
				importDeclaration();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(203);
				moduleMemberDeclarations();
				}
			}

			setState(206);
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public SourceFileContext TargetFile { get; set; }
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
				private string ignoreMe;
		public TerminalNode IMPORT() { return getToken(TypescriptParser.IMPORT, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(IMPORT);
			setState(209);
			stringLiteral();
			setState(210);
			match(SEMICOLON);
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

	public static class ModuleOrTypeNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ModuleOrTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleOrTypeName; }
	}

	public final ModuleOrTypeNameContext moduleOrTypeName() throws RecognitionException {
		ModuleOrTypeNameContext _localctx = new ModuleOrTypeNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_moduleOrTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(212);
			identifier();
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(213);
				match(DOT);
				setState(214);
				identifier();
				}
				}
				setState(219);
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

	public static class TypeListContext extends ParserRuleContext {
		public List<TypeInOptionalParenthesisContext> typeInOptionalParenthesis() {
			return getRuleContexts(TypeInOptionalParenthesisContext.class);
		}
		public TypeInOptionalParenthesisContext typeInOptionalParenthesis(int i) {
			return getRuleContext(TypeInOptionalParenthesisContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			typeInOptionalParenthesis();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_OR) {
				{
				{
				setState(221);
				match(BITWISE_OR);
				setState(222);
				typeInOptionalParenthesis();
				}
				}
				setState(227);
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

	public static class TypeInOptionalParenthesisContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeInOptionalParenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeInOptionalParenthesis; }
	}

	public final TypeInOptionalParenthesisContext typeInOptionalParenthesis() throws RecognitionException {
		TypeInOptionalParenthesisContext _localctx = new TypeInOptionalParenthesisContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeInOptionalParenthesis);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(OPEN_PARENS);
				setState(229);
				type();
				setState(230);
				match(CLOSE_PARENS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				type();
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

	public static class TypeContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<TerminalNode> OPEN_BRACKET() { return getTokens(TypescriptParser.OPEN_BRACKET); }
		public TerminalNode OPEN_BRACKET(int i) {
			return getToken(TypescriptParser.OPEN_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_BRACKET() { return getTokens(TypescriptParser.CLOSE_BRACKET); }
		public TerminalNode CLOSE_BRACKET(int i) {
			return getToken(TypescriptParser.CLOSE_BRACKET, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			baseType();
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(236);
					match(OPEN_BRACKET);
					setState(237);
					match(CLOSE_BRACKET);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_baseType);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				classType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				functionType();
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(TypescriptParser.NUMBER, 0); }
		public TerminalNode BOOL() { return getToken(TypescriptParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(TypescriptParser.STRING, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
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

	public static class ClassTypeContext extends ParserRuleContext {
		public ModuleOrTypeNameContext moduleOrTypeName() {
			return getRuleContext(ModuleOrTypeNameContext.class,0);
		}
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			moduleOrTypeName();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(251);
				typeArgumentList();
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

	public static class TypeArgumentListContext extends ParserRuleContext {
		public List<TypeListContext> typeList() {
			return getRuleContexts(TypeListContext.class);
		}
		public TypeListContext typeList(int i) {
			return getRuleContext(TypeListContext.class,i);
		}
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(LT);
			setState(255);
			typeList();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(256);
				match(COMMA);
				setState(257);
				typeList();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
			match(GT);
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

	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public RightArrowContext rightArrow() {
			return getRuleContext(RightArrowContext.class,0);
		}
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(OPEN_PARENS);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(266);
				formalParameterList();
				}
			}

			setState(269);
			match(CLOSE_PARENS);
			setState(270);
			rightArrow();
			setState(271);
			returnTypeList();
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

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			argument();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(274);
				match(COMMA);
				setState(275);
				argument();
				}
				}
				setState(280);
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

	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(281);
				identifier();
				setState(282);
				match(COLON);
				}
				break;
			}
			setState(286);
			expression();
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public NonAssignmentExpressionContext nonAssignmentExpression() {
			return getRuleContext(NonAssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression);
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				nonAssignmentExpression();
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

	public static class NonAssignmentExpressionContext extends ParserRuleContext {
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public NonAssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonAssignmentExpression; }
	}

	public final NonAssignmentExpressionContext nonAssignmentExpression() throws RecognitionException {
		NonAssignmentExpressionContext _localctx = new NonAssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_nonAssignmentExpression);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				conditionalOrExpression();
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

	public static class AssignmentContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			unaryExpression();
			setState(297);
			assignmentOperator();
			setState(298);
			expression();
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (ASSIGNMENT - 80)) | (1L << (OP_ADD_ASSIGNMENT - 80)) | (1L << (OP_SUB_ASSIGNMENT - 80)) | (1L << (OP_MULT_ASSIGNMENT - 80)) | (1L << (OP_DIV_ASSIGNMENT - 80)) | (1L << (OP_MOD_ASSIGNMENT - 80)))) != 0)) ) {
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

	public static class ConditionalOrExpressionContext extends ParserRuleContext {
		public List<ConditionalAndExpressionContext> conditionalAndExpression() {
			return getRuleContexts(ConditionalAndExpressionContext.class);
		}
		public ConditionalAndExpressionContext conditionalAndExpression(int i) {
			return getRuleContext(ConditionalAndExpressionContext.class,i);
		}
		public List<TerminalNode> OP_OR() { return getTokens(TypescriptParser.OP_OR); }
		public TerminalNode OP_OR(int i) {
			return getToken(TypescriptParser.OP_OR, i);
		}
		public ConditionalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalOrExpression; }
	}

	public final ConditionalOrExpressionContext conditionalOrExpression() throws RecognitionException {
		ConditionalOrExpressionContext _localctx = new ConditionalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			conditionalAndExpression();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_OR) {
				{
				{
				setState(303);
				match(OP_OR);
				setState(304);
				conditionalAndExpression();
				}
				}
				setState(309);
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

	public static class ConditionalAndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> OP_AND() { return getTokens(TypescriptParser.OP_AND); }
		public TerminalNode OP_AND(int i) {
			return getToken(TypescriptParser.OP_AND, i);
		}
		public ConditionalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalAndExpression; }
	}

	public final ConditionalAndExpressionContext conditionalAndExpression() throws RecognitionException {
		ConditionalAndExpressionContext _localctx = new ConditionalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditionalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			equalityExpression();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_AND) {
				{
				{
				setState(311);
				match(OP_AND);
				setState(312);
				equalityExpression();
				}
				}
				setState(317);
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<CastExpressionContext> castExpression() {
			return getRuleContexts(CastExpressionContext.class);
		}
		public CastExpressionContext castExpression(int i) {
			return getRuleContext(CastExpressionContext.class,i);
		}
		public List<TerminalNode> OP_EQ() { return getTokens(TypescriptParser.OP_EQ); }
		public TerminalNode OP_EQ(int i) {
			return getToken(TypescriptParser.OP_EQ, i);
		}
		public List<TerminalNode> OP_NE() { return getTokens(TypescriptParser.OP_NE); }
		public TerminalNode OP_NE(int i) {
			return getToken(TypescriptParser.OP_NE, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			castExpression();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_EQ || _la==OP_NE) {
				{
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==OP_EQ || _la==OP_NE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(320);
				castExpression();
				}
				}
				setState(325);
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

	public static class CastExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(TypescriptParser.AS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_castExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			relationalExpression();
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(327);
				match(AS);
				setState(328);
				type();
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

	public static class RelationalExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			additiveExpression();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) {
				{
				{
				setState(332);
				_la = _input.LA(1);
				if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(333);
				additiveExpression();
				}
				}
				setState(338);
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			multiplicativeExpression();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(340);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(341);
				multiplicativeExpression();
				}
				}
				setState(346);
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

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			unaryExpression();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) {
				{
				{
				setState(348);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(349);
				unaryExpression();
				}
				}
				setState(354);
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

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode BANG() { return getToken(TypescriptParser.BANG, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryExpression);
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case GET:
			case LET:
			case NEW:
			case NULL:
			case SET:
			case THIS:
			case TRUE:
			case VAR:
			case NUMBER:
			case IDENTIFIER:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
			case OPEN_BRACKET:
			case OPEN_PARENS:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				primaryExpression();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				match(PLUS);
				setState(357);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(358);
				match(MINUS);
				setState(359);
				unaryExpression();
				}
				break;
			case BANG:
				enterOuterAlt(_localctx, 4);
				{
				setState(360);
				match(BANG);
				setState(361);
				unaryExpression();
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionStartContext pe;
		public PrimaryExpressionStartContext primaryExpressionStart() {
			return getRuleContext(PrimaryExpressionStartContext.class,0);
		}
		public List<BracketExpressionContext> bracketExpression() {
			return getRuleContexts(BracketExpressionContext.class);
		}
		public BracketExpressionContext bracketExpression(int i) {
			return getRuleContext(BracketExpressionContext.class,i);
		}
		public List<MemberAccessContext> memberAccess() {
			return getRuleContexts(MemberAccessContext.class);
		}
		public MemberAccessContext memberAccess(int i) {
			return getRuleContext(MemberAccessContext.class,i);
		}
		public List<MethodInvocationContext> methodInvocation() {
			return getRuleContexts(MethodInvocationContext.class);
		}
		public MethodInvocationContext methodInvocation(int i) {
			return getRuleContext(MethodInvocationContext.class,i);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			((PrimaryExpressionContext)_localctx).pe = primaryExpressionStart();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACKET) {
				{
				{
				setState(365);
				bracketExpression();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (DOT - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				{
				setState(375);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(371);
					memberAccess();
					}
					break;
				case OPEN_PARENS:
					{
					setState(372);
					methodInvocation();
					}
					break;
				case OP_INC:
					{
					setState(373);
					match(OP_INC);
					}
					break;
				case OP_DEC:
					{
					setState(374);
					match(OP_DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPEN_BRACKET) {
					{
					{
					setState(377);
					bracketExpression();
					}
					}
					setState(382);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(387);
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

	public static class NativeMethodInvocationStatementContext extends ParserRuleContext {
		public IdentifierContext pe;
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NativeMethodInvocationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeMethodInvocationStatement; }
	}

	public final NativeMethodInvocationStatementContext nativeMethodInvocationStatement() throws RecognitionException {
		NativeMethodInvocationStatementContext _localctx = new NativeMethodInvocationStatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_nativeMethodInvocationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			((NativeMethodInvocationStatementContext)_localctx).pe = identifier();
			setState(389);
			memberAccess();
			setState(390);
			methodInvocation();
			setState(391);
			match(SEMICOLON);
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

	public static class PrimaryExpressionStartContext extends ParserRuleContext {
		public PrimaryExpressionStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpressionStart; }
	 
		public PrimaryExpressionStartContext() { }
		public void copyFrom(PrimaryExpressionStartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ThisReferenceExpressionContext extends PrimaryExpressionStartContext {
		public TerminalNode THIS() { return getToken(TypescriptParser.THIS, 0); }
		public ThisReferenceExpressionContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
	}
	public static class SimpleNameExpressionContext extends PrimaryExpressionStartContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public SimpleNameExpressionContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayCreationExpressionContext extends PrimaryExpressionStartContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArrayCreationExpressionContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExpressionContext extends PrimaryExpressionStartContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesisExpressionsContext extends PrimaryExpressionStartContext {
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public ParenthesisExpressionsContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
	}
	public static class ObjectCreationContext extends PrimaryExpressionStartContext {
		public TerminalNode NEW() { return getToken(TypescriptParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ObjectCreationExpressionContext objectCreationExpression() {
			return getRuleContext(ObjectCreationExpressionContext.class,0);
		}
		public ObjectCreationContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryExpressionStartContext primaryExpressionStart() throws RecognitionException {
		PrimaryExpressionStartContext _localctx = new PrimaryExpressionStartContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_primaryExpressionStart);
		int _la;
		try {
			setState(412);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case NULL:
			case TRUE:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
				_localctx = new LiteralExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				literal();
				}
				break;
			case GET:
			case LET:
			case SET:
			case VAR:
			case NUMBER:
			case IDENTIFIER:
				_localctx = new SimpleNameExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				identifier();
				setState(396);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(395);
					typeArgumentList();
					}
					break;
				}
				}
				break;
			case OPEN_PARENS:
				_localctx = new ParenthesisExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				match(OPEN_PARENS);
				setState(399);
				expression();
				setState(400);
				match(CLOSE_PARENS);
				}
				break;
			case THIS:
				_localctx = new ThisReferenceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(402);
				match(THIS);
				}
				break;
			case NEW:
				_localctx = new ObjectCreationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(403);
				match(NEW);
				setState(404);
				type();
				setState(405);
				objectCreationExpression();
				}
				break;
			case OPEN_BRACKET:
				_localctx = new ArrayCreationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(407);
				match(OPEN_BRACKET);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(408);
					expressionList();
					}
				}

				setState(411);
				match(CLOSE_BRACKET);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			expression();
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(415);
				match(COMMA);
				setState(416);
				expression();
				}
				}
				setState(421);
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

	public static class MemberAccessContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(DOT);
			setState(423);
			identifier();
			setState(425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(424);
				typeArgumentList();
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

	public static class BracketExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracketExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketExpression; }
	}

	public final BracketExpressionContext bracketExpression() throws RecognitionException {
		BracketExpressionContext _localctx = new BracketExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_bracketExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(OPEN_BRACKET);
			setState(428);
			expression();
			setState(429);
			match(CLOSE_BRACKET);
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

	public static class LambdaExpressionContext extends ParserRuleContext {
		public AnonymousFunctionSignatureContext anonymousFunctionSignature() {
			return getRuleContext(AnonymousFunctionSignatureContext.class,0);
		}
		public RightArrowContext rightArrow() {
			return getRuleContext(RightArrowContext.class,0);
		}
		public AnonymousFunctionBodyContext anonymousFunctionBody() {
			return getRuleContext(AnonymousFunctionBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			anonymousFunctionSignature();
			setState(432);
			rightArrow();
			setState(433);
			anonymousFunctionBody();
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

	public static class AnonymousFunctionSignatureContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public ExplicitAnonymousFunctionParameterListContext explicitAnonymousFunctionParameterList() {
			return getRuleContext(ExplicitAnonymousFunctionParameterListContext.class,0);
		}
		public AnonymousFunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunctionSignature; }
	}

	public final AnonymousFunctionSignatureContext anonymousFunctionSignature() throws RecognitionException {
		AnonymousFunctionSignatureContext _localctx = new AnonymousFunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_anonymousFunctionSignature);
		try {
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				match(OPEN_PARENS);
				setState(436);
				match(CLOSE_PARENS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(OPEN_PARENS);
				setState(438);
				explicitAnonymousFunctionParameterList();
				setState(439);
				match(CLOSE_PARENS);
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

	public static class ExplicitAnonymousFunctionParameterListContext extends ParserRuleContext {
		public List<ExplicitAnonymousFunctionParameterContext> explicitAnonymousFunctionParameter() {
			return getRuleContexts(ExplicitAnonymousFunctionParameterContext.class);
		}
		public ExplicitAnonymousFunctionParameterContext explicitAnonymousFunctionParameter(int i) {
			return getRuleContext(ExplicitAnonymousFunctionParameterContext.class,i);
		}
		public ExplicitAnonymousFunctionParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitAnonymousFunctionParameterList; }
	}

	public final ExplicitAnonymousFunctionParameterListContext explicitAnonymousFunctionParameterList() throws RecognitionException {
		ExplicitAnonymousFunctionParameterListContext _localctx = new ExplicitAnonymousFunctionParameterListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_explicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			explicitAnonymousFunctionParameter();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(444);
				match(COMMA);
				setState(445);
				explicitAnonymousFunctionParameter();
				}
				}
				setState(450);
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

	public static class ExplicitAnonymousFunctionParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExplicitAnonymousFunctionParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitAnonymousFunctionParameter; }
	}

	public final ExplicitAnonymousFunctionParameterContext explicitAnonymousFunctionParameter() throws RecognitionException {
		ExplicitAnonymousFunctionParameterContext _localctx = new ExplicitAnonymousFunctionParameterContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_explicitAnonymousFunctionParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			identifier();
			setState(452);
			match(COLON);
			setState(453);
			type();
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

	public static class ImplicitAnonymousFunctionParameterListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ImplicitAnonymousFunctionParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicitAnonymousFunctionParameterList; }
	}

	public final ImplicitAnonymousFunctionParameterListContext implicitAnonymousFunctionParameterList() throws RecognitionException {
		ImplicitAnonymousFunctionParameterListContext _localctx = new ImplicitAnonymousFunctionParameterListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_implicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			identifier();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(456);
				match(COMMA);
				setState(457);
				identifier();
				}
				}
				setState(462);
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

	public static class AnonymousFunctionBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AnonymousFunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunctionBody; }
	}

	public final AnonymousFunctionBodyContext anonymousFunctionBody() throws RecognitionException {
		AnonymousFunctionBodyContext _localctx = new AnonymousFunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_anonymousFunctionBody);
		try {
			setState(465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case GET:
			case LET:
			case NEW:
			case NULL:
			case SET:
			case THIS:
			case TRUE:
			case VAR:
			case NUMBER:
			case IDENTIFIER:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
			case OPEN_BRACKET:
			case OPEN_PARENS:
			case PLUS:
			case MINUS:
			case BANG:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				expression();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				block();
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
	public static class DeclarationStatementContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public DeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class EmbeddedContext extends StatementContext {
		public EmbeddedStatementContext embeddedStatement() {
			return getRuleContext(EmbeddedStatementContext.class,0);
		}
		public EmbeddedContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_statement);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new DeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				variableDeclaration();
				setState(468);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new EmbeddedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				embeddedStatement();
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

	public static class EmbeddedStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleEmbeddedStatementContext simpleEmbeddedStatement() {
			return getRuleContext(SimpleEmbeddedStatementContext.class,0);
		}
		public EmbeddedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_embeddedStatement; }
	}

	public final EmbeddedStatementContext embeddedStatement() throws RecognitionException {
		EmbeddedStatementContext _localctx = new EmbeddedStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_embeddedStatement);
		try {
			setState(475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				block();
				}
				break;
			case BREAK:
			case CONTINUE:
			case FALSE:
			case FOR:
			case GET:
			case IF:
			case LET:
			case NEW:
			case NULL:
			case RETURN:
			case SET:
			case SWITCH:
			case THIS:
			case TRUE:
			case VAR:
			case WHILE:
			case NUMBER:
			case IDENTIFIER:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
			case OPEN_BRACKET:
			case OPEN_PARENS:
			case SEMICOLON:
			case PLUS:
			case MINUS:
			case BANG:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				simpleEmbeddedStatement();
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

	public static class SimpleEmbeddedStatementContext extends ParserRuleContext {
		public SimpleEmbeddedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleEmbeddedStatement; }
	 
		public SimpleEmbeddedStatementContext() { }
		public void copyFrom(SimpleEmbeddedStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode WHILE() { return getToken(TypescriptParser.WHILE, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public EmbeddedStatementContext embeddedStatement() {
			return getRuleContext(EmbeddedStatementContext.class,0);
		}
		public WhileStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class EmptyStatementContext extends SimpleEmbeddedStatementContext {
		public EmptyStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ForeachStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode FOR() { return getToken(TypescriptParser.FOR, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OF() { return getToken(TypescriptParser.OF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public EmbeddedStatementContext embeddedStatement() {
			return getRuleContext(EmbeddedStatementContext.class,0);
		}
		public ForeachStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ForStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode FOR() { return getToken(TypescriptParser.FOR, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public EmbeddedStatementContext embeddedStatement() {
			return getRuleContext(EmbeddedStatementContext.class,0);
		}
		public ForInitializerContext forInitializer() {
			return getRuleContext(ForInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForIteratorContext forIterator() {
			return getRuleContext(ForIteratorContext.class,0);
		}
		public ForStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode BREAK() { return getToken(TypescriptParser.BREAK, 0); }
		public BreakStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ExpressionStatementContext extends SimpleEmbeddedStatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ContinueStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode CONTINUE() { return getToken(TypescriptParser.CONTINUE, 0); }
		public ContinueStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class IfStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode IF() { return getToken(TypescriptParser.IF, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public List<EmbeddedStatementContext> embeddedStatement() {
			return getRuleContexts(EmbeddedStatementContext.class);
		}
		public EmbeddedStatementContext embeddedStatement(int i) {
			return getRuleContext(EmbeddedStatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(TypescriptParser.ELSE, 0); }
		public IfStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode RETURN() { return getToken(TypescriptParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}
	public static class SwitchStatementContext extends SimpleEmbeddedStatementContext {
		public TerminalNode SWITCH() { return getToken(TypescriptParser.SWITCH, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(TypescriptParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(TypescriptParser.CLOSE_BRACE, 0); }
		public List<SwitchSectionContext> switchSection() {
			return getRuleContexts(SwitchSectionContext.class);
		}
		public SwitchSectionContext switchSection(int i) {
			return getRuleContext(SwitchSectionContext.class,i);
		}
		public SwitchStatementContext(SimpleEmbeddedStatementContext ctx) { copyFrom(ctx); }
	}

	public final SimpleEmbeddedStatementContext simpleEmbeddedStatement() throws RecognitionException {
		SimpleEmbeddedStatementContext _localctx = new SimpleEmbeddedStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_simpleEmbeddedStatement);
		int _la;
		try {
			setState(542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(477);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				expression();
				setState(479);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(481);
				match(IF);
				setState(482);
				match(OPEN_PARENS);
				setState(483);
				expression();
				setState(484);
				match(CLOSE_PARENS);
				setState(485);
				embeddedStatement();
				setState(488);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(486);
					match(ELSE);
					setState(487);
					embeddedStatement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new SwitchStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(490);
				match(SWITCH);
				setState(491);
				match(OPEN_PARENS);
				setState(492);
				expression();
				setState(493);
				match(CLOSE_PARENS);
				setState(494);
				match(OPEN_BRACE);
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(495);
					switchSection();
					}
					}
					setState(500);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(501);
				match(CLOSE_BRACE);
				}
				break;
			case 5:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(503);
				match(WHILE);
				setState(504);
				match(OPEN_PARENS);
				setState(505);
				expression();
				setState(506);
				match(CLOSE_PARENS);
				setState(507);
				embeddedStatement();
				}
				break;
			case 6:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(509);
				match(FOR);
				setState(510);
				match(OPEN_PARENS);
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)))) != 0)) {
					{
					setState(511);
					forInitializer();
					}
				}

				setState(514);
				match(SEMICOLON);
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(515);
					expression();
					}
				}

				setState(518);
				match(SEMICOLON);
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(519);
					forIterator();
					}
				}

				setState(522);
				match(CLOSE_PARENS);
				setState(523);
				embeddedStatement();
				}
				break;
			case 7:
				_localctx = new ForeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(524);
				match(FOR);
				setState(525);
				match(OPEN_PARENS);
				setState(526);
				variableType();
				setState(527);
				identifier();
				setState(528);
				match(OF);
				setState(529);
				expression();
				setState(530);
				match(CLOSE_PARENS);
				setState(531);
				embeddedStatement();
				}
				break;
			case 8:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(533);
				match(BREAK);
				setState(534);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(535);
				match(CONTINUE);
				setState(536);
				match(SEMICOLON);
				}
				break;
			case 10:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(537);
				match(RETURN);
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(538);
					expression();
					}
				}

				setState(541);
				match(SEMICOLON);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(TypescriptParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(TypescriptParser.CLOSE_BRACE, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(OPEN_BRACE);
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)))) != 0)) {
				{
				setState(545);
				statementList();
				}
			}

			setState(548);
			match(CLOSE_BRACE);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			variableType();
			setState(551);
			variableDeclarator();
			setState(556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(552);
				match(COMMA);
				setState(553);
				variableDeclarator();
				}
				}
				setState(558);
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

	public static class VariableTypeContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(TypescriptParser.VAR, 0); }
		public TerminalNode CONST() { return getToken(TypescriptParser.CONST, 0); }
		public TerminalNode LET() { return getToken(TypescriptParser.LET, 0); }
		public VariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableType; }
	}

	public final VariableTypeContext variableType() throws RecognitionException {
		VariableTypeContext _localctx = new VariableTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << LET) | (1L << VAR))) != 0)) ) {
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

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			identifier();
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(562);
				match(COLON);
				setState(563);
				type();
				}
			}

			setState(568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(566);
				match(ASSIGNMENT);
				setState(567);
				expression();
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

	public static class SwitchSectionContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchSection; }
	}

	public final SwitchSectionContext switchSection() throws RecognitionException {
		SwitchSectionContext _localctx = new SwitchSectionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(570);
				switchLabel();
				}
				}
				setState(573); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(575);
			statementList();
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

	public static class SwitchLabelContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(TypescriptParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(TypescriptParser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_switchLabel);
		try {
			setState(583);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(577);
				match(CASE);
				setState(578);
				expression();
				setState(579);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(581);
				match(DEFAULT);
				setState(582);
				match(COLON);
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

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(585);
				statement();
				}
				}
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)))) != 0) );
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

	public static class ForInitializerContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitializer; }
	}

	public final ForInitializerContext forInitializer() throws RecognitionException {
		ForInitializerContext _localctx = new ForInitializerContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_forInitializer);
		int _la;
		try {
			setState(599);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(591);
				expression();
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(592);
					match(COMMA);
					setState(593);
					expression();
					}
					}
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class ForIteratorContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForIteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forIterator; }
	}

	public final ForIteratorContext forIterator() throws RecognitionException {
		ForIteratorContext _localctx = new ForIteratorContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_forIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			expression();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(602);
				match(COMMA);
				setState(603);
				expression();
				}
				}
				setState(608);
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

	public static class ModuleDeclarationContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(TypescriptParser.MODULE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ModuleBodyContext moduleBody() {
			return getRuleContext(ModuleBodyContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(TypescriptParser.EXPORT, 0); }
		public ModuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDeclaration; }
	}

	public final ModuleDeclarationContext moduleDeclaration() throws RecognitionException {
		ModuleDeclarationContext _localctx = new ModuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(609);
				match(EXPORT);
				}
			}

			setState(612);
			match(MODULE);
			setState(613);
			identifier();
			setState(614);
			moduleBody();
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(615);
				match(SEMICOLON);
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

	public static class ModuleBodyContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(TypescriptParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(TypescriptParser.CLOSE_BRACE, 0); }
		public ModuleMemberDeclarationsContext moduleMemberDeclarations() {
			return getRuleContext(ModuleMemberDeclarationsContext.class,0);
		}
		public ModuleBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleBody; }
	}

	public final ModuleBodyContext moduleBody() throws RecognitionException {
		ModuleBodyContext _localctx = new ModuleBodyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			match(OPEN_BRACE);
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(619);
				moduleMemberDeclarations();
				}
			}

			setState(622);
			match(CLOSE_BRACE);
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

	public static class ModuleMemberDeclarationsContext extends ParserRuleContext {
		public List<ModuleMemberDeclarationContext> moduleMemberDeclaration() {
			return getRuleContexts(ModuleMemberDeclarationContext.class);
		}
		public ModuleMemberDeclarationContext moduleMemberDeclaration(int i) {
			return getRuleContext(ModuleMemberDeclarationContext.class,i);
		}
		public ModuleMemberDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleMemberDeclarations; }
	}

	public final ModuleMemberDeclarationsContext moduleMemberDeclarations() throws RecognitionException {
		ModuleMemberDeclarationsContext _localctx = new ModuleMemberDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_moduleMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(624);
				moduleMemberDeclaration();
				}
				}
				setState(627); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0) );
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

	public static class ModuleMemberDeclarationContext extends ParserRuleContext {
		public ModuleDeclarationContext moduleDeclaration() {
			return getRuleContext(ModuleDeclarationContext.class,0);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public NativeMethodInvocationStatementContext nativeMethodInvocationStatement() {
			return getRuleContext(NativeMethodInvocationStatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ModuleMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleMemberDeclaration; }
	}

	public final ModuleMemberDeclarationContext moduleMemberDeclaration() throws RecognitionException {
		ModuleMemberDeclarationContext _localctx = new ModuleMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_moduleMemberDeclaration);
		try {
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(629);
				moduleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(630);
				typeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(631);
				variableDeclaration();
				setState(632);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(634);
				nativeMethodInvocationStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(635);
				functionDeclaration();
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(TypescriptParser.FUNCTION, 0); }
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(TypescriptParser.EXPORT, 0); }
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(638);
				match(EXPORT);
				}
			}

			setState(641);
			match(FUNCTION);
			setState(642);
			methodDeclaration();
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDefinitionContext classDefinition() {
			return getRuleContext(ClassDefinitionContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public AllMemberModifiersContext allMemberModifiers() {
			return getRuleContext(AllMemberModifiersContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(644);
				allMemberModifiers();
				}
			}

			setState(649);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(647);
				classDefinition();
				}
				break;
			case ENUM:
				{
				setState(648);
				enumDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			match(LT);
			setState(652);
			typeParameter();
			setState(657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(653);
				match(COMMA);
				setState(654);
				typeParameter();
				}
				}
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(660);
			match(GT);
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

	public static class TypeParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_typeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			identifier();
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

	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(TypescriptParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(TypescriptParser.CLOSE_BRACE, 0); }
		public ClassMemberDeclarationsContext classMemberDeclarations() {
			return getRuleContext(ClassMemberDeclarationsContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			match(OPEN_BRACE);
			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << CONSTRUCTOR) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(665);
				classMemberDeclarations();
				}
			}

			setState(668);
			match(CLOSE_BRACE);
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

	public static class ClassMemberDeclarationsContext extends ParserRuleContext {
		public List<ClassMemberDeclarationContext> classMemberDeclaration() {
			return getRuleContexts(ClassMemberDeclarationContext.class);
		}
		public ClassMemberDeclarationContext classMemberDeclaration(int i) {
			return getRuleContext(ClassMemberDeclarationContext.class,i);
		}
		public ClassMemberDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberDeclarations; }
	}

	public final ClassMemberDeclarationsContext classMemberDeclarations() throws RecognitionException {
		ClassMemberDeclarationsContext _localctx = new ClassMemberDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_classMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(670);
				classMemberDeclaration();
				}
				}
				setState(673); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << CONSTRUCTOR) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0) );
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

	public static class ClassMemberDeclarationContext extends ParserRuleContext {
		public CommonMemberDeclarationContext commonMemberDeclaration() {
			return getRuleContext(CommonMemberDeclarationContext.class,0);
		}
		public AllMemberModifiersContext allMemberModifiers() {
			return getRuleContext(AllMemberModifiersContext.class,0);
		}
		public ClassMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberDeclaration; }
	}

	public final ClassMemberDeclarationContext classMemberDeclaration() throws RecognitionException {
		ClassMemberDeclarationContext _localctx = new ClassMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_classMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(675);
				allMemberModifiers();
				}
			}

			setState(678);
			commonMemberDeclaration();
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

	public static class AllMemberModifiersContext extends ParserRuleContext {
		public List<AllMemberModifierContext> allMemberModifier() {
			return getRuleContexts(AllMemberModifierContext.class);
		}
		public AllMemberModifierContext allMemberModifier(int i) {
			return getRuleContext(AllMemberModifierContext.class,i);
		}
		public AllMemberModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allMemberModifiers; }
	}

	public final AllMemberModifiersContext allMemberModifiers() throws RecognitionException {
		AllMemberModifiersContext _localctx = new AllMemberModifiersContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_allMemberModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(680);
				allMemberModifier();
				}
				}
				setState(683); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0) );
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

	public static class AllMemberModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(TypescriptParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(TypescriptParser.PRIVATE, 0); }
		public TerminalNode READONLY() { return getToken(TypescriptParser.READONLY, 0); }
		public TerminalNode STATIC() { return getToken(TypescriptParser.STATIC, 0); }
		public TerminalNode EXPORT() { return getToken(TypescriptParser.EXPORT, 0); }
		public AllMemberModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allMemberModifier; }
	}

	public final AllMemberModifierContext allMemberModifier() throws RecognitionException {
		AllMemberModifierContext _localctx = new AllMemberModifierContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_allMemberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) ) {
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

	public static class CommonMemberDeclarationContext extends ParserRuleContext {
		public TypedMemberDeclarationContext typedMemberDeclaration() {
			return getRuleContext(TypedMemberDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public CommonMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonMemberDeclaration; }
	}

	public final CommonMemberDeclarationContext commonMemberDeclaration() throws RecognitionException {
		CommonMemberDeclarationContext _localctx = new CommonMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_commonMemberDeclaration);
		try {
			setState(689);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GET:
			case LET:
			case SET:
			case VAR:
			case NUMBER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				typedMemberDeclaration();
				}
				break;
			case CONSTRUCTOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(688);
				constructorDeclaration();
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

	public static class TypedMemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GetterDeclarationContext getterDeclaration() {
			return getRuleContext(GetterDeclarationContext.class,0);
		}
		public SetterDeclarationContext setterDeclaration() {
			return getRuleContext(SetterDeclarationContext.class,0);
		}
		public ClassFieldContext classField() {
			return getRuleContext(ClassFieldContext.class,0);
		}
		public TypedMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedMemberDeclaration; }
	}

	public final TypedMemberDeclarationContext typedMemberDeclaration() throws RecognitionException {
		TypedMemberDeclarationContext _localctx = new TypedMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_typedMemberDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(691);
				methodDeclaration();
				}
				break;
			case 2:
				{
				setState(692);
				getterDeclaration();
				}
				break;
			case 3:
				{
				setState(693);
				setterDeclaration();
				}
				break;
			case 4:
				{
				setState(694);
				classField();
				setState(695);
				match(SEMICOLON);
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

	public static class ClassFieldContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public ClassFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classField; }
	}

	public final ClassFieldContext classField() throws RecognitionException {
		ClassFieldContext _localctx = new ClassFieldContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_classField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			variableDeclarator();
			setState(704);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(700);
				match(COMMA);
				setState(701);
				variableDeclarator();
				}
				}
				setState(706);
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

	public static class ReturnTypeListContext extends ParserRuleContext {
		public List<ReturnTypeContext> returnType() {
			return getRuleContexts(ReturnTypeContext.class);
		}
		public ReturnTypeContext returnType(int i) {
			return getRuleContext(ReturnTypeContext.class,i);
		}
		public ReturnTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnTypeList; }
	}

	public final ReturnTypeListContext returnTypeList() throws RecognitionException {
		ReturnTypeListContext _localctx = new ReturnTypeListContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_returnTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			returnType();
			setState(712);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(708);
					match(BITWISE_OR);
					setState(709);
					returnType();
					}
					} 
				}
				setState(714);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(TypescriptParser.VOID, 0); }
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_returnType);
		try {
			setState(717);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case GET:
			case LET:
			case SET:
			case STRING:
			case VAR:
			case NUMBER:
			case IDENTIFIER:
			case OPEN_PARENS:
				enterOuterAlt(_localctx, 1);
				{
				setState(715);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(716);
				match(VOID);
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public FixedParametersContext fixedParameters() {
			return getRuleContext(FixedParametersContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_formalParameterList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			fixedParameters();
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

	public static class FixedParametersContext extends ParserRuleContext {
		public List<FixedParameterContext> fixedParameter() {
			return getRuleContexts(FixedParameterContext.class);
		}
		public FixedParameterContext fixedParameter(int i) {
			return getRuleContext(FixedParameterContext.class,i);
		}
		public FixedParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixedParameters; }
	}

	public final FixedParametersContext fixedParameters() throws RecognitionException {
		FixedParametersContext _localctx = new FixedParametersContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_fixedParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			fixedParameter();
			setState(728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(724);
				match(COMMA);
				setState(725);
				fixedParameter();
				}
				}
				setState(730);
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

	public static class FixedParameterContext extends ParserRuleContext {
		public ArgDeclarationContext argDeclaration() {
			return getRuleContext(ArgDeclarationContext.class,0);
		}
		public FixedParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixedParameter; }
	}

	public final FixedParameterContext fixedParameter() throws RecognitionException {
		FixedParameterContext _localctx = new FixedParameterContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_fixedParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			argDeclaration();
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

	public static class ConstructorInitializerContext extends ParserRuleContext {
		public TerminalNode SUPER() { return getToken(TypescriptParser.SUPER, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ConstructorInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorInitializer; }
	}

	public final ConstructorInitializerContext constructorInitializer() throws RecognitionException {
		ConstructorInitializerContext _localctx = new ConstructorInitializerContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_constructorInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			match(COLON);
			setState(734);
			match(SUPER);
			setState(735);
			match(OPEN_PARENS);
			setState(737);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
				{
				setState(736);
				argumentList();
				}
			}

			setState(739);
			match(CLOSE_PARENS);
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

	public static class BodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_body);
		try {
			setState(743);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(741);
				block();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(742);
				match(SEMICOLON);
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

	public static class VariantTypeParameterListContext extends ParserRuleContext {
		public List<VariantTypeParameterContext> variantTypeParameter() {
			return getRuleContexts(VariantTypeParameterContext.class);
		}
		public VariantTypeParameterContext variantTypeParameter(int i) {
			return getRuleContext(VariantTypeParameterContext.class,i);
		}
		public VariantTypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variantTypeParameterList; }
	}

	public final VariantTypeParameterListContext variantTypeParameterList() throws RecognitionException {
		VariantTypeParameterListContext _localctx = new VariantTypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_variantTypeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(LT);
			setState(746);
			variantTypeParameter();
			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(747);
				match(COMMA);
				setState(748);
				variantTypeParameter();
				}
				}
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(754);
			match(GT);
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

	public static class VariantTypeParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VariantTypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variantTypeParameter; }
	}

	public final VariantTypeParameterContext variantTypeParameter() throws RecognitionException {
		VariantTypeParameterContext _localctx = new VariantTypeParameterContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_variantTypeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(756);
			identifier();
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

	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(TypescriptParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(TypescriptParser.CLOSE_BRACE, 0); }
		public List<EnumMemberDeclarationContext> enumMemberDeclaration() {
			return getRuleContexts(EnumMemberDeclarationContext.class);
		}
		public EnumMemberDeclarationContext enumMemberDeclaration(int i) {
			return getRuleContext(EnumMemberDeclarationContext.class,i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_enumBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			match(OPEN_BRACE);
			setState(770);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(759);
				enumMemberDeclaration();
				setState(764);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(760);
						match(COMMA);
						setState(761);
						enumMemberDeclaration();
						}
						} 
					}
					setState(766);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(767);
					match(COMMA);
					}
				}

				}
			}

			setState(772);
			match(CLOSE_BRACE);
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

	public static class EnumMemberDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnumMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumMemberDeclaration; }
	}

	public final EnumMemberDeclarationContext enumMemberDeclaration() throws RecognitionException {
		EnumMemberDeclarationContext _localctx = new EnumMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_enumMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			identifier();
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(775);
				match(ASSIGNMENT);
				setState(776);
				expression();
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

	public static class RightArrowContext extends ParserRuleContext {
		public Token first;
		public Token second;
		public RightArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightArrow; }
	}

	public final RightArrowContext rightArrow() throws RecognitionException {
		RightArrowContext _localctx = new RightArrowContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_rightArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			((RightArrowContext)_localctx).first = match(ASSIGNMENT);
			setState(780);
			((RightArrowContext)_localctx).second = match(GT);
			setState(781);
			if (!((((RightArrowContext)_localctx).first!=null?((RightArrowContext)_localctx).first.getTokenIndex():0) + 1 == (((RightArrowContext)_localctx).second!=null?((RightArrowContext)_localctx).second.getTokenIndex():0))) throw new FailedPredicateException(this, "$first.index + 1 == $second.index");
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

	public static class RightShiftContext extends ParserRuleContext {
		public Token first;
		public Token second;
		public RightShiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightShift; }
	}

	public final RightShiftContext rightShift() throws RecognitionException {
		RightShiftContext _localctx = new RightShiftContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_rightShift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			((RightShiftContext)_localctx).first = match(GT);
			setState(784);
			((RightShiftContext)_localctx).second = match(GT);
			setState(785);
			if (!((((RightShiftContext)_localctx).first!=null?((RightShiftContext)_localctx).first.getTokenIndex():0) + 1 == (((RightShiftContext)_localctx).second!=null?((RightShiftContext)_localctx).second.getTokenIndex():0))) throw new FailedPredicateException(this, "$first.index + 1 == $second.index");
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

	public static class RightShiftAssignmentContext extends ParserRuleContext {
		public Token first;
		public Token second;
		public RightShiftAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightShiftAssignment; }
	}

	public final RightShiftAssignmentContext rightShiftAssignment() throws RecognitionException {
		RightShiftAssignmentContext _localctx = new RightShiftAssignmentContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_rightShiftAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			((RightShiftAssignmentContext)_localctx).first = match(GT);
			setState(788);
			((RightShiftAssignmentContext)_localctx).second = match(OP_GE);
			setState(789);
			if (!((((RightShiftAssignmentContext)_localctx).first!=null?((RightShiftAssignmentContext)_localctx).first.getTokenIndex():0) + 1 == (((RightShiftAssignmentContext)_localctx).second!=null?((RightShiftAssignmentContext)_localctx).second.getTokenIndex():0))) throw new FailedPredicateException(this, "$first.index + 1 == $second.index");
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
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode INTEGER_LITERAL() { return getToken(TypescriptParser.INTEGER_LITERAL, 0); }
		public TerminalNode HEX_INTEGER_LITERAL() { return getToken(TypescriptParser.HEX_INTEGER_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(TypescriptParser.REAL_LITERAL, 0); }
		public TerminalNode NULL() { return getToken(TypescriptParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_literal);
		try {
			setState(797);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(791);
				booleanLiteral();
				}
				break;
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(792);
				stringLiteral();
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(793);
				match(INTEGER_LITERAL);
				}
				break;
			case HEX_INTEGER_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(794);
				match(HEX_INTEGER_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(795);
				match(REAL_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(796);
				match(NULL);
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(TypescriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TypescriptParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
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

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode REGULAR_STRING() { return getToken(TypescriptParser.REGULAR_STRING, 0); }
		public TerminalNode SINGLE_QUOTE_STRING_LITERAL() { return getToken(TypescriptParser.SINGLE_QUOTE_STRING_LITERAL, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			_la = _input.LA(1);
			if ( !(_la==REGULAR_STRING || _la==SINGLE_QUOTE_STRING_LITERAL) ) {
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

	public static class ClassDefinitionContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(TypescriptParser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(TypescriptParser.EXTENDS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			match(CLASS);
			setState(804);
			identifier();
			setState(806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(805);
				typeParameterList();
				}
			}

			setState(810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(808);
				match(EXTENDS);
				setState(809);
				type();
				}
			}

			setState(812);
			classBody();
			setState(814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(813);
				match(SEMICOLON);
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

	public static class EnumDefinitionContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(TypescriptParser.ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			match(ENUM);
			setState(817);
			identifier();
			setState(818);
			enumBody();
			setState(820);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(819);
				match(SEMICOLON);
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

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public TerminalNode CONSTRUCTOR() { return getToken(TypescriptParser.CONSTRUCTOR, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(CONSTRUCTOR);
			setState(823);
			match(OPEN_PARENS);
			setState(825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(824);
				formalParameterList();
				}
			}

			setState(827);
			match(CLOSE_PARENS);
			setState(828);
			body();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
			identifier();
			setState(832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(831);
				typeParameterList();
				}
			}

			setState(834);
			match(OPEN_PARENS);
			setState(836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(835);
				formalParameterList();
				}
			}

			setState(838);
			match(CLOSE_PARENS);
			{
			setState(839);
			match(COLON);
			setState(840);
			returnTypeList();
			}
			setState(842);
			methodBody();
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

	public static class GetterDeclarationContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(TypescriptParser.GET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public GetterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getterDeclaration; }
	}

	public final GetterDeclarationContext getterDeclaration() throws RecognitionException {
		GetterDeclarationContext _localctx = new GetterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_getterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			match(GET);
			setState(845);
			identifier();
			setState(846);
			match(OPEN_PARENS);
			setState(847);
			match(CLOSE_PARENS);
			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(848);
				match(COLON);
				setState(849);
				returnTypeList();
				}
			}

			setState(852);
			methodBody();
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

	public static class SetterDeclarationContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(TypescriptParser.SET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public SetterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setterDeclaration; }
	}

	public final SetterDeclarationContext setterDeclaration() throws RecognitionException {
		SetterDeclarationContext _localctx = new SetterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_setterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			match(SET);
			setState(855);
			identifier();
			setState(856);
			match(OPEN_PARENS);
			setState(857);
			formalParameterList();
			setState(858);
			match(CLOSE_PARENS);
			setState(861);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(859);
				match(COLON);
				setState(860);
				returnTypeList();
				}
			}

			setState(863);
			methodBody();
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

	public static class ArgDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDeclaration; }
	}

	public final ArgDeclarationContext argDeclaration() throws RecognitionException {
		ArgDeclarationContext _localctx = new ArgDeclarationContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_argDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(865);
			identifier();
			setState(866);
			match(COLON);
			setState(867);
			typeList();
			setState(870);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(868);
				match(ASSIGNMENT);
				setState(869);
				expression();
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

	public static class MethodInvocationContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_methodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			match(OPEN_PARENS);
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
				{
				setState(873);
				argumentList();
				}
			}

			setState(876);
			match(CLOSE_PARENS);
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

	public static class ObjectCreationExpressionContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ObjectCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectCreationExpression; }
	}

	public final ObjectCreationExpressionContext objectCreationExpression() throws RecognitionException {
		ObjectCreationExpressionContext _localctx = new ObjectCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_objectCreationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(878);
			match(OPEN_PARENS);
			setState(880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
				{
				setState(879);
				argumentList();
				}
			}

			setState(882);
			match(CLOSE_PARENS);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TypescriptParser.IDENTIFIER, 0); }
		public TerminalNode GET() { return getToken(TypescriptParser.GET, 0); }
		public TerminalNode LET() { return getToken(TypescriptParser.LET, 0); }
		public TerminalNode SET() { return getToken(TypescriptParser.SET, 0); }
		public TerminalNode VAR() { return getToken(TypescriptParser.VAR, 0); }
		public TerminalNode NUMBER() { return getToken(TypescriptParser.NUMBER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) ) {
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
		case 78:
			return rightArrow_sempred((RightArrowContext)_localctx, predIndex);
		case 79:
			return rightShift_sempred((RightShiftContext)_localctx, predIndex);
		case 80:
			return rightShiftAssignment_sempred((RightShiftAssignmentContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rightArrow_sempred(RightArrowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return (((RightArrowContext)_localctx).first!=null?((RightArrowContext)_localctx).first.getTokenIndex():0) + 1 == (((RightArrowContext)_localctx).second!=null?((RightArrowContext)_localctx).second.getTokenIndex():0);
		}
		return true;
	}
	private boolean rightShift_sempred(RightShiftContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return (((RightShiftContext)_localctx).first!=null?((RightShiftContext)_localctx).first.getTokenIndex():0) + 1 == (((RightShiftContext)_localctx).second!=null?((RightShiftContext)_localctx).second.getTokenIndex():0);
		}
		return true;
	}
	private boolean rightShiftAssignment_sempred(RightShiftAssignmentContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return (((RightShiftAssignmentContext)_localctx).first!=null?((RightShiftAssignmentContext)_localctx).first.getTokenIndex():0) + 1 == (((RightShiftAssignmentContext)_localctx).second!=null?((RightShiftAssignmentContext)_localctx).second.getTokenIndex():0);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3{\u0379\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\3"+
		"\2\7\2\u00c0\n\2\f\2\16\2\u00c3\13\2\3\3\5\3\u00c6\n\3\3\3\7\3\u00c9\n"+
		"\3\f\3\16\3\u00cc\13\3\3\3\5\3\u00cf\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\7\5\u00da\n\5\f\5\16\5\u00dd\13\5\3\6\3\6\3\6\7\6\u00e2\n\6\f\6"+
		"\16\6\u00e5\13\6\3\7\3\7\3\7\3\7\3\7\5\7\u00ec\n\7\3\b\3\b\3\b\7\b\u00f1"+
		"\n\b\f\b\16\b\u00f4\13\b\3\t\3\t\3\t\5\t\u00f9\n\t\3\n\3\n\3\13\3\13\5"+
		"\13\u00ff\n\13\3\f\3\f\3\f\3\f\7\f\u0105\n\f\f\f\16\f\u0108\13\f\3\f\3"+
		"\f\3\r\3\r\5\r\u010e\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u0117\n\16"+
		"\f\16\16\16\u011a\13\16\3\17\3\17\3\17\5\17\u011f\n\17\3\17\3\17\3\20"+
		"\3\20\5\20\u0125\n\20\3\21\3\21\5\21\u0129\n\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\7\24\u0134\n\24\f\24\16\24\u0137\13\24\3\25\3"+
		"\25\3\25\7\25\u013c\n\25\f\25\16\25\u013f\13\25\3\26\3\26\3\26\7\26\u0144"+
		"\n\26\f\26\16\26\u0147\13\26\3\27\3\27\3\27\5\27\u014c\n\27\3\30\3\30"+
		"\3\30\7\30\u0151\n\30\f\30\16\30\u0154\13\30\3\31\3\31\3\31\7\31\u0159"+
		"\n\31\f\31\16\31\u015c\13\31\3\32\3\32\3\32\7\32\u0161\n\32\f\32\16\32"+
		"\u0164\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u016d\n\33\3\34\3"+
		"\34\7\34\u0171\n\34\f\34\16\34\u0174\13\34\3\34\3\34\3\34\3\34\5\34\u017a"+
		"\n\34\3\34\7\34\u017d\n\34\f\34\16\34\u0180\13\34\7\34\u0182\n\34\f\34"+
		"\16\34\u0185\13\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\5\36\u018f"+
		"\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u019c"+
		"\n\36\3\36\5\36\u019f\n\36\3\37\3\37\3\37\7\37\u01a4\n\37\f\37\16\37\u01a7"+
		"\13\37\3 \3 \3 \5 \u01ac\n \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\5#\u01bc\n#\3$\3$\3$\7$\u01c1\n$\f$\16$\u01c4\13$\3%\3%\3%\3%\3&"+
		"\3&\3&\7&\u01cd\n&\f&\16&\u01d0\13&\3\'\3\'\5\'\u01d4\n\'\3(\3(\3(\3("+
		"\5(\u01da\n(\3)\3)\5)\u01de\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01eb"+
		"\n*\3*\3*\3*\3*\3*\3*\7*\u01f3\n*\f*\16*\u01f6\13*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\5*\u0203\n*\3*\3*\5*\u0207\n*\3*\3*\5*\u020b\n*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u021e\n*\3*\5*\u0221\n"+
		"*\3+\3+\5+\u0225\n+\3+\3+\3,\3,\3,\3,\7,\u022d\n,\f,\16,\u0230\13,\3-"+
		"\3-\3.\3.\3.\5.\u0237\n.\3.\3.\5.\u023b\n.\3/\6/\u023e\n/\r/\16/\u023f"+
		"\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u024a\n\60\3\61\6\61\u024d\n"+
		"\61\r\61\16\61\u024e\3\62\3\62\3\62\3\62\7\62\u0255\n\62\f\62\16\62\u0258"+
		"\13\62\5\62\u025a\n\62\3\63\3\63\3\63\7\63\u025f\n\63\f\63\16\63\u0262"+
		"\13\63\3\64\5\64\u0265\n\64\3\64\3\64\3\64\3\64\5\64\u026b\n\64\3\65\3"+
		"\65\5\65\u026f\n\65\3\65\3\65\3\66\6\66\u0274\n\66\r\66\16\66\u0275\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u027f\n\67\38\58\u0282\n8\38\3"+
		"8\38\39\59\u0288\n9\39\39\59\u028c\n9\3:\3:\3:\3:\7:\u0292\n:\f:\16:\u0295"+
		"\13:\3:\3:\3;\3;\3<\3<\5<\u029d\n<\3<\3<\3=\6=\u02a2\n=\r=\16=\u02a3\3"+
		">\5>\u02a7\n>\3>\3>\3?\6?\u02ac\n?\r?\16?\u02ad\3@\3@\3A\3A\5A\u02b4\n"+
		"A\3B\3B\3B\3B\3B\3B\5B\u02bc\nB\3C\3C\3C\7C\u02c1\nC\fC\16C\u02c4\13C"+
		"\3D\3D\3D\7D\u02c9\nD\fD\16D\u02cc\13D\3E\3E\5E\u02d0\nE\3F\3F\3G\3G\3"+
		"H\3H\3H\7H\u02d9\nH\fH\16H\u02dc\13H\3I\3I\3J\3J\3J\3J\5J\u02e4\nJ\3J"+
		"\3J\3K\3K\5K\u02ea\nK\3L\3L\3L\3L\7L\u02f0\nL\fL\16L\u02f3\13L\3L\3L\3"+
		"M\3M\3N\3N\3N\3N\7N\u02fd\nN\fN\16N\u0300\13N\3N\5N\u0303\nN\5N\u0305"+
		"\nN\3N\3N\3O\3O\3O\5O\u030c\nO\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3S"+
		"\3S\3S\3S\3S\3S\5S\u0320\nS\3T\3T\3U\3U\3V\3V\3V\5V\u0329\nV\3V\3V\5V"+
		"\u032d\nV\3V\3V\5V\u0331\nV\3W\3W\3W\3W\5W\u0337\nW\3X\3X\3X\5X\u033c"+
		"\nX\3X\3X\3X\3Y\3Y\5Y\u0343\nY\3Y\3Y\5Y\u0347\nY\3Y\3Y\3Y\3Y\3Y\3Y\3Z"+
		"\3Z\3Z\3Z\3Z\3Z\5Z\u0355\nZ\3Z\3Z\3[\3[\3[\3[\3[\3[\3[\5[\u0360\n[\3["+
		"\3[\3\\\3\\\3\\\3\\\3\\\5\\\u0369\n\\\3]\3]\5]\u036d\n]\3]\3]\3^\3^\5"+
		"^\u0373\n^\3^\3^\3_\3_\3_\2\2`\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\2\r\5\2\b\b%%..\4\2RRae\3\2]^\4\2ST_`\3"+
		"\2HI\3\2JL\5\2\r\r\31\31++\6\2\36\36 !$$\65\65\4\2\23\23))\3\2<=\b\2\27"+
		"\27\31\31##++..\67\67\2\u0393\2\u00c1\3\2\2\2\4\u00c5\3\2\2\2\6\u00d2"+
		"\3\2\2\2\b\u00d6\3\2\2\2\n\u00de\3\2\2\2\f\u00eb\3\2\2\2\16\u00ed\3\2"+
		"\2\2\20\u00f8\3\2\2\2\22\u00fa\3\2\2\2\24\u00fc\3\2\2\2\26\u0100\3\2\2"+
		"\2\30\u010b\3\2\2\2\32\u0113\3\2\2\2\34\u011e\3\2\2\2\36\u0124\3\2\2\2"+
		" \u0128\3\2\2\2\"\u012a\3\2\2\2$\u012e\3\2\2\2&\u0130\3\2\2\2(\u0138\3"+
		"\2\2\2*\u0140\3\2\2\2,\u0148\3\2\2\2.\u014d\3\2\2\2\60\u0155\3\2\2\2\62"+
		"\u015d\3\2\2\2\64\u016c\3\2\2\2\66\u016e\3\2\2\28\u0186\3\2\2\2:\u019e"+
		"\3\2\2\2<\u01a0\3\2\2\2>\u01a8\3\2\2\2@\u01ad\3\2\2\2B\u01b1\3\2\2\2D"+
		"\u01bb\3\2\2\2F\u01bd\3\2\2\2H\u01c5\3\2\2\2J\u01c9\3\2\2\2L\u01d3\3\2"+
		"\2\2N\u01d9\3\2\2\2P\u01dd\3\2\2\2R\u0220\3\2\2\2T\u0222\3\2\2\2V\u0228"+
		"\3\2\2\2X\u0231\3\2\2\2Z\u0233\3\2\2\2\\\u023d\3\2\2\2^\u0249\3\2\2\2"+
		"`\u024c\3\2\2\2b\u0259\3\2\2\2d\u025b\3\2\2\2f\u0264\3\2\2\2h\u026c\3"+
		"\2\2\2j\u0273\3\2\2\2l\u027e\3\2\2\2n\u0281\3\2\2\2p\u0287\3\2\2\2r\u028d"+
		"\3\2\2\2t\u0298\3\2\2\2v\u029a\3\2\2\2x\u02a1\3\2\2\2z\u02a6\3\2\2\2|"+
		"\u02ab\3\2\2\2~\u02af\3\2\2\2\u0080\u02b3\3\2\2\2\u0082\u02bb\3\2\2\2"+
		"\u0084\u02bd\3\2\2\2\u0086\u02c5\3\2\2\2\u0088\u02cf\3\2\2\2\u008a\u02d1"+
		"\3\2\2\2\u008c\u02d3\3\2\2\2\u008e\u02d5\3\2\2\2\u0090\u02dd\3\2\2\2\u0092"+
		"\u02df\3\2\2\2\u0094\u02e9\3\2\2\2\u0096\u02eb\3\2\2\2\u0098\u02f6\3\2"+
		"\2\2\u009a\u02f8\3\2\2\2\u009c\u0308\3\2\2\2\u009e\u030d\3\2\2\2\u00a0"+
		"\u0311\3\2\2\2\u00a2\u0315\3\2\2\2\u00a4\u031f\3\2\2\2\u00a6\u0321\3\2"+
		"\2\2\u00a8\u0323\3\2\2\2\u00aa\u0325\3\2\2\2\u00ac\u0332\3\2\2\2\u00ae"+
		"\u0338\3\2\2\2\u00b0\u0340\3\2\2\2\u00b2\u034e\3\2\2\2\u00b4\u0358\3\2"+
		"\2\2\u00b6\u0363\3\2\2\2\u00b8\u036a\3\2\2\2\u00ba\u0370\3\2\2\2\u00bc"+
		"\u0376\3\2\2\2\u00be\u00c0\5\4\3\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\3\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c6\7\3\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00ca\3\2\2\2\u00c7\u00c9\5\6\4\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00cf\5j\66\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\2\2\3\u00d1\5\3\2\2\2\u00d2\u00d3"+
		"\7\62\2\2\u00d3\u00d4\5\u00a8U\2\u00d4\u00d5\7G\2\2\u00d5\7\3\2\2\2\u00d6"+
		"\u00db\5\u00bc_\2\u00d7\u00d8\7D\2\2\u00d8\u00da\5\u00bc_\2\u00d9\u00d7"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\t\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e3\5\f\7\2\u00df\u00e0\7N\2\2"+
		"\u00e0\u00e2\5\f\7\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\13\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e7\7B\2\2\u00e7\u00e8\5\16\b\2\u00e8\u00e9\7C\2\2\u00e9\u00ec\3\2"+
		"\2\2\u00ea\u00ec\5\16\b\2\u00eb\u00e6\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec"+
		"\r\3\2\2\2\u00ed\u00f2\5\20\t\2\u00ee\u00ef\7@\2\2\u00ef\u00f1\7A\2\2"+
		"\u00f0\u00ee\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\17\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f9\5\22\n\2\u00f6"+
		"\u00f9\5\24\13\2\u00f7\u00f9\5\30\r\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\21\3\2\2\2\u00fa\u00fb\t\2\2\2\u00fb"+
		"\23\3\2\2\2\u00fc\u00fe\5\b\5\2\u00fd\u00ff\5\26\f\2\u00fe\u00fd\3\2\2"+
		"\2\u00fe\u00ff\3\2\2\2\u00ff\25\3\2\2\2\u0100\u0101\7S\2\2\u0101\u0106"+
		"\5\n\6\2\u0102\u0103\7E\2\2\u0103\u0105\5\n\6\2\u0104\u0102\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2"+
		"\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7T\2\2\u010a\27\3\2\2\2\u010b\u010d"+
		"\7B\2\2\u010c\u010e\5\u008cG\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2"+
		"\u010e\u010f\3\2\2\2\u010f\u0110\7C\2\2\u0110\u0111\5\u009eP\2\u0111\u0112"+
		"\5\u0086D\2\u0112\31\3\2\2\2\u0113\u0118\5\34\17\2\u0114\u0115\7E\2\2"+
		"\u0115\u0117\5\34\17\2\u0116\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119\33\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011c\5\u00bc_\2\u011c\u011d\7F\2\2\u011d\u011f\3\2\2\2\u011e\u011b\3"+
		"\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\5\36\20\2\u0121"+
		"\35\3\2\2\2\u0122\u0125\5\"\22\2\u0123\u0125\5 \21\2\u0124\u0122\3\2\2"+
		"\2\u0124\u0123\3\2\2\2\u0125\37\3\2\2\2\u0126\u0129\5B\"\2\u0127\u0129"+
		"\5&\24\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129!\3\2\2\2\u012a"+
		"\u012b\5\64\33\2\u012b\u012c\5$\23\2\u012c\u012d\5\36\20\2\u012d#\3\2"+
		"\2\2\u012e\u012f\t\3\2\2\u012f%\3\2\2\2\u0130\u0135\5(\25\2\u0131\u0132"+
		"\7[\2\2\u0132\u0134\5(\25\2\u0133\u0131\3\2\2\2\u0134\u0137\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\'\3\2\2\2\u0137\u0135\3\2\2\2"+
		"\u0138\u013d\5*\26\2\u0139\u013a\7Z\2\2\u013a\u013c\5*\26\2\u013b\u0139"+
		"\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		")\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0145\5,\27\2\u0141\u0142\t\4\2\2"+
		"\u0142\u0144\5,\27\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143"+
		"\3\2\2\2\u0145\u0146\3\2\2\2\u0146+\3\2\2\2\u0147\u0145\3\2\2\2\u0148"+
		"\u014b\5.\30\2\u0149\u014a\7\66\2\2\u014a\u014c\5\16\b\2\u014b\u0149\3"+
		"\2\2\2\u014b\u014c\3\2\2\2\u014c-\3\2\2\2\u014d\u0152\5\60\31\2\u014e"+
		"\u014f\t\5\2\2\u014f\u0151\5\60\31\2\u0150\u014e\3\2\2\2\u0151\u0154\3"+
		"\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153/\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0155\u015a\5\62\32\2\u0156\u0157\t\6\2\2\u0157\u0159\5\62\32"+
		"\2\u0158\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\61\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0162\5\64\33\2\u015e"+
		"\u015f\t\7\2\2\u015f\u0161\5\64\33\2\u0160\u015e\3\2\2\2\u0161\u0164\3"+
		"\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\63\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0165\u016d\5\66\34\2\u0166\u0167\7H\2\2\u0167\u016d\5"+
		"\64\33\2\u0168\u0169\7I\2\2\u0169\u016d\5\64\33\2\u016a\u016b\7P\2\2\u016b"+
		"\u016d\5\64\33\2\u016c\u0165\3\2\2\2\u016c\u0166\3\2\2\2\u016c\u0168\3"+
		"\2\2\2\u016c\u016a\3\2\2\2\u016d\65\3\2\2\2\u016e\u0172\5:\36\2\u016f"+
		"\u0171\5@!\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2"+
		"\2\u0172\u0173\3\2\2\2\u0173\u0183\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u017a"+
		"\5> \2\u0176\u017a\5\u00b8]\2\u0177\u017a\7X\2\2\u0178\u017a\7Y\2\2\u0179"+
		"\u0175\3\2\2\2\u0179\u0176\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u0178\3\2"+
		"\2\2\u017a\u017e\3\2\2\2\u017b\u017d\5@!\2\u017c\u017b\3\2\2\2\u017d\u0180"+
		"\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0182\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0181\u0179\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2"+
		"\2\2\u0183\u0184\3\2\2\2\u0184\67\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187"+
		"\5\u00bc_\2\u0187\u0188\5> \2\u0188\u0189\5\u00b8]\2\u0189\u018a\7G\2"+
		"\2\u018a9\3\2\2\2\u018b\u019f\5\u00a4S\2\u018c\u018e\5\u00bc_\2\u018d"+
		"\u018f\5\26\f\2\u018e\u018d\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u019f\3"+
		"\2\2\2\u0190\u0191\7B\2\2\u0191\u0192\5\36\20\2\u0192\u0193\7C\2\2\u0193"+
		"\u019f\3\2\2\2\u0194\u019f\7\'\2\2\u0195\u0196\7\32\2\2\u0196\u0197\5"+
		"\16\b\2\u0197\u0198\5\u00ba^\2\u0198\u019f\3\2\2\2\u0199\u019b\7@\2\2"+
		"\u019a\u019c\5<\37\2\u019b\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d"+
		"\3\2\2\2\u019d\u019f\7A\2\2\u019e\u018b\3\2\2\2\u019e\u018c\3\2\2\2\u019e"+
		"\u0190\3\2\2\2\u019e\u0194\3\2\2\2\u019e\u0195\3\2\2\2\u019e\u0199\3\2"+
		"\2\2\u019f;\3\2\2\2\u01a0\u01a5\5\36\20\2\u01a1\u01a2\7E\2\2\u01a2\u01a4"+
		"\5\36\20\2\u01a3\u01a1\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2"+
		"\u01a5\u01a6\3\2\2\2\u01a6=\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a9\7"+
		"D\2\2\u01a9\u01ab\5\u00bc_\2\u01aa\u01ac\5\26\f\2\u01ab\u01aa\3\2\2\2"+
		"\u01ab\u01ac\3\2\2\2\u01ac?\3\2\2\2\u01ad\u01ae\7@\2\2\u01ae\u01af\5\36"+
		"\20\2\u01af\u01b0\7A\2\2\u01b0A\3\2\2\2\u01b1\u01b2\5D#\2\u01b2\u01b3"+
		"\5\u009eP\2\u01b3\u01b4\5L\'\2\u01b4C\3\2\2\2\u01b5\u01b6\7B\2\2\u01b6"+
		"\u01bc\7C\2\2\u01b7\u01b8\7B\2\2\u01b8\u01b9\5F$\2\u01b9\u01ba\7C\2\2"+
		"\u01ba\u01bc\3\2\2\2\u01bb\u01b5\3\2\2\2\u01bb\u01b7\3\2\2\2\u01bcE\3"+
		"\2\2\2\u01bd\u01c2\5H%\2\u01be\u01bf\7E\2\2\u01bf\u01c1\5H%\2\u01c0\u01be"+
		"\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3"+
		"G\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\5\u00bc_\2\u01c6\u01c7\7F\2"+
		"\2\u01c7\u01c8\5\16\b\2\u01c8I\3\2\2\2\u01c9\u01ce\5\u00bc_\2\u01ca\u01cb"+
		"\7E\2\2\u01cb\u01cd\5\u00bc_\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\3\2\2\2"+
		"\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cfK\3\2\2\2\u01d0\u01ce\3"+
		"\2\2\2\u01d1\u01d4\5\36\20\2\u01d2\u01d4\5T+\2\u01d3\u01d1\3\2\2\2\u01d3"+
		"\u01d2\3\2\2\2\u01d4M\3\2\2\2\u01d5\u01d6\5V,\2\u01d6\u01d7\7G\2\2\u01d7"+
		"\u01da\3\2\2\2\u01d8\u01da\5P)\2\u01d9\u01d5\3\2\2\2\u01d9\u01d8\3\2\2"+
		"\2\u01daO\3\2\2\2\u01db\u01de\5T+\2\u01dc\u01de\5R*\2\u01dd\u01db\3\2"+
		"\2\2\u01dd\u01dc\3\2\2\2\u01deQ\3\2\2\2\u01df\u0221\7G\2\2\u01e0\u01e1"+
		"\5\36\20\2\u01e1\u01e2\7G\2\2\u01e2\u0221\3\2\2\2\u01e3\u01e4\7\30\2\2"+
		"\u01e4\u01e5\7B\2\2\u01e5\u01e6\5\36\20\2\u01e6\u01e7\7C\2\2\u01e7\u01ea"+
		"\5P)\2\u01e8\u01e9\7\21\2\2\u01e9\u01eb\5P)\2\u01ea\u01e8\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u0221\3\2\2\2\u01ec\u01ed\7&\2\2\u01ed\u01ee\7B\2"+
		"\2\u01ee\u01ef\5\36\20\2\u01ef\u01f0\7C\2\2\u01f0\u01f4\7>\2\2\u01f1\u01f3"+
		"\5\\/\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f8\7?"+
		"\2\2\u01f8\u0221\3\2\2\2\u01f9\u01fa\7-\2\2\u01fa\u01fb\7B\2\2\u01fb\u01fc"+
		"\5\36\20\2\u01fc\u01fd\7C\2\2\u01fd\u01fe\5P)\2\u01fe\u0221\3\2\2\2\u01ff"+
		"\u0200\7\25\2\2\u0200\u0202\7B\2\2\u0201\u0203\5b\62\2\u0202\u0201\3\2"+
		"\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206\7G\2\2\u0205"+
		"\u0207\5\36\20\2\u0206\u0205\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3"+
		"\2\2\2\u0208\u020a\7G\2\2\u0209\u020b\5d\63\2\u020a\u0209\3\2\2\2\u020a"+
		"\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d\7C\2\2\u020d\u0221\5P)"+
		"\2\u020e\u020f\7\25\2\2\u020f\u0210\7B\2\2\u0210\u0211\5X-\2\u0211\u0212"+
		"\5\u00bc_\2\u0212\u0213\7\61\2\2\u0213\u0214\5\36\20\2\u0214\u0215\7C"+
		"\2\2\u0215\u0216\5P)\2\u0216\u0221\3\2\2\2\u0217\u0218\7\t\2\2\u0218\u0221"+
		"\7G\2\2\u0219\u021a\7\16\2\2\u021a\u0221\7G\2\2\u021b\u021d\7\"\2\2\u021c"+
		"\u021e\5\36\20\2\u021d\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3"+
		"\2\2\2\u021f\u0221\7G\2\2\u0220\u01df\3\2\2\2\u0220\u01e0\3\2\2\2\u0220"+
		"\u01e3\3\2\2\2\u0220\u01ec\3\2\2\2\u0220\u01f9\3\2\2\2\u0220\u01ff\3\2"+
		"\2\2\u0220\u020e\3\2\2\2\u0220\u0217\3\2\2\2\u0220\u0219\3\2\2\2\u0220"+
		"\u021b\3\2\2\2\u0221S\3\2\2\2\u0222\u0224\7>\2\2\u0223\u0225\5`\61\2\u0224"+
		"\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\7?"+
		"\2\2\u0227U\3\2\2\2\u0228\u0229\5X-\2\u0229\u022e\5Z.\2\u022a\u022b\7"+
		"E\2\2\u022b\u022d\5Z.\2\u022c\u022a\3\2\2\2\u022d\u0230\3\2\2\2\u022e"+
		"\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022fW\3\2\2\2\u0230\u022e\3\2\2\2"+
		"\u0231\u0232\t\b\2\2\u0232Y\3\2\2\2\u0233\u0236\5\u00bc_\2\u0234\u0235"+
		"\7F\2\2\u0235\u0237\5\16\b\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u023a\3\2\2\2\u0238\u0239\7R\2\2\u0239\u023b\5\36\20\2\u023a\u0238\3"+
		"\2\2\2\u023a\u023b\3\2\2\2\u023b[\3\2\2\2\u023c\u023e\5^\60\2\u023d\u023c"+
		"\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0242\5`\61\2\u0242]\3\2\2\2\u0243\u0244\7\n\2\2"+
		"\u0244\u0245\5\36\20\2\u0245\u0246\7F\2\2\u0246\u024a\3\2\2\2\u0247\u0248"+
		"\7\17\2\2\u0248\u024a\7F\2\2\u0249\u0243\3\2\2\2\u0249\u0247\3\2\2\2\u024a"+
		"_\3\2\2\2\u024b\u024d\5N(\2\u024c\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e"+
		"\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024fa\3\2\2\2\u0250\u025a\5V,\2\u0251"+
		"\u0256\5\36\20\2\u0252\u0253\7E\2\2\u0253\u0255\5\36\20\2\u0254\u0252"+
		"\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257"+
		"\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0259\u0250\3\2\2\2\u0259\u0251\3\2"+
		"\2\2\u025ac\3\2\2\2\u025b\u0260\5\36\20\2\u025c\u025d\7E\2\2\u025d\u025f"+
		"\5\36\20\2\u025e\u025c\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2"+
		"\u0260\u0261\3\2\2\2\u0261e\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0265\7"+
		"\65\2\2\u0264\u0263\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0266\3\2\2\2\u0266"+
		"\u0267\7\60\2\2\u0267\u0268\5\u00bc_\2\u0268\u026a\5h\65\2\u0269\u026b"+
		"\7G\2\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026bg\3\2\2\2\u026c\u026e"+
		"\7>\2\2\u026d\u026f\5j\66\2\u026e\u026d\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0270\3\2\2\2\u0270\u0271\7?\2\2\u0271i\3\2\2\2\u0272\u0274\5l\67\2\u0273"+
		"\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2"+
		"\2\2\u0276k\3\2\2\2\u0277\u027f\5f\64\2\u0278\u027f\5p9\2\u0279\u027a"+
		"\5V,\2\u027a\u027b\7G\2\2\u027b\u027f\3\2\2\2\u027c\u027f\58\35\2\u027d"+
		"\u027f\5n8\2\u027e\u0277\3\2\2\2\u027e\u0278\3\2\2\2\u027e\u0279\3\2\2"+
		"\2\u027e\u027c\3\2\2\2\u027e\u027d\3\2\2\2\u027fm\3\2\2\2\u0280\u0282"+
		"\7\65\2\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2\2\2"+
		"\u0283\u0284\7\63\2\2\u0284\u0285\5\u00b0Y\2\u0285o\3\2\2\2\u0286\u0288"+
		"\5|?\2\u0287\u0286\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u028b\3\2\2\2\u0289"+
		"\u028c\5\u00aaV\2\u028a\u028c\5\u00acW\2\u028b\u0289\3\2\2\2\u028b\u028a"+
		"\3\2\2\2\u028cq\3\2\2\2\u028d\u028e\7S\2\2\u028e\u0293\5t;\2\u028f\u0290"+
		"\7E\2\2\u0290\u0292\5t;\2\u0291\u028f\3\2\2\2\u0292\u0295\3\2\2\2\u0293"+
		"\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0296\3\2\2\2\u0295\u0293\3\2"+
		"\2\2\u0296\u0297\7T\2\2\u0297s\3\2\2\2\u0298\u0299\5\u00bc_\2\u0299u\3"+
		"\2\2\2\u029a\u029c\7>\2\2\u029b\u029d\5x=\2\u029c\u029b\3\2\2\2\u029c"+
		"\u029d\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f\7?\2\2\u029fw\3\2\2\2\u02a0"+
		"\u02a2\5z>\2\u02a1\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a1\3\2\2"+
		"\2\u02a3\u02a4\3\2\2\2\u02a4y\3\2\2\2\u02a5\u02a7\5|?\2\u02a6\u02a5\3"+
		"\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\5\u0080A\2"+
		"\u02a9{\3\2\2\2\u02aa\u02ac\5~@\2\u02ab\u02aa\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae}\3\2\2\2\u02af\u02b0"+
		"\t\t\2\2\u02b0\177\3\2\2\2\u02b1\u02b4\5\u0082B\2\u02b2\u02b4\5\u00ae"+
		"X\2\u02b3\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4\u0081\3\2\2\2\u02b5"+
		"\u02bc\5\u00b0Y\2\u02b6\u02bc\5\u00b2Z\2\u02b7\u02bc\5\u00b4[\2\u02b8"+
		"\u02b9\5\u0084C\2\u02b9\u02ba\7G\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02b5\3"+
		"\2\2\2\u02bb\u02b6\3\2\2\2\u02bb\u02b7\3\2\2\2\u02bb\u02b8\3\2\2\2\u02bc"+
		"\u0083\3\2\2\2\u02bd\u02c2\5Z.\2\u02be\u02bf\7E\2\2\u02bf\u02c1\5Z.\2"+
		"\u02c0\u02be\3\2\2\2\u02c1\u02c4\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3"+
		"\3\2\2\2\u02c3\u0085\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c5\u02ca\5\u0088E"+
		"\2\u02c6\u02c7\7N\2\2\u02c7\u02c9\5\u0088E\2\u02c8\u02c6\3\2\2\2\u02c9"+
		"\u02cc\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u0087\3\2"+
		"\2\2\u02cc\u02ca\3\2\2\2\u02cd\u02d0\5\16\b\2\u02ce\u02d0\7,\2\2\u02cf"+
		"\u02cd\3\2\2\2\u02cf\u02ce\3\2\2\2\u02d0\u0089\3\2\2\2\u02d1\u02d2\5T"+
		"+\2\u02d2\u008b\3\2\2\2\u02d3\u02d4\5\u008eH\2\u02d4\u008d\3\2\2\2\u02d5"+
		"\u02da\5\u0090I\2\u02d6\u02d7\7E\2\2\u02d7\u02d9\5\u0090I\2\u02d8\u02d6"+
		"\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db"+
		"\u008f\3\2\2\2\u02dc\u02da\3\2\2\2\u02dd\u02de\5\u00b6\\\2\u02de\u0091"+
		"\3\2\2\2\u02df\u02e0\7F\2\2\u02e0\u02e1\7/\2\2\u02e1\u02e3\7B\2\2\u02e2"+
		"\u02e4\5\32\16\2\u02e3\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\3"+
		"\2\2\2\u02e5\u02e6\7C\2\2\u02e6\u0093\3\2\2\2\u02e7\u02ea\5T+\2\u02e8"+
		"\u02ea\7G\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02e8\3\2\2\2\u02ea\u0095\3\2"+
		"\2\2\u02eb\u02ec\7S\2\2\u02ec\u02f1\5\u0098M\2\u02ed\u02ee\7E\2\2\u02ee"+
		"\u02f0\5\u0098M\2\u02ef\u02ed\3\2\2\2\u02f0\u02f3\3\2\2\2\u02f1\u02ef"+
		"\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f4\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f4"+
		"\u02f5\7T\2\2\u02f5\u0097\3\2\2\2\u02f6\u02f7\5\u00bc_\2\u02f7\u0099\3"+
		"\2\2\2\u02f8\u0304\7>\2\2\u02f9\u02fe\5\u009cO\2\u02fa\u02fb\7E\2\2\u02fb"+
		"\u02fd\5\u009cO\2\u02fc\u02fa\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc"+
		"\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0302\3\2\2\2\u0300\u02fe\3\2\2\2\u0301"+
		"\u0303\7E\2\2\u0302\u0301\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0305\3\2"+
		"\2\2\u0304\u02f9\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0306\3\2\2\2\u0306"+
		"\u0307\7?\2\2\u0307\u009b\3\2\2\2\u0308\u030b\5\u00bc_\2\u0309\u030a\7"+
		"R\2\2\u030a\u030c\5\36\20\2\u030b\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c"+
		"\u009d\3\2\2\2\u030d\u030e\7R\2\2\u030e\u030f\7T\2\2\u030f\u0310\6P\2"+
		"\3\u0310\u009f\3\2\2\2\u0311\u0312\7T\2\2\u0312\u0313\7T\2\2\u0313\u0314"+
		"\6Q\3\3\u0314\u00a1\3\2\2\2\u0315\u0316\7T\2\2\u0316\u0317\7`\2\2\u0317"+
		"\u0318\6R\4\3\u0318\u00a3\3\2\2\2\u0319\u0320\5\u00a6T\2\u031a\u0320\5"+
		"\u00a8U\2\u031b\u0320\79\2\2\u031c\u0320\7:\2\2\u031d\u0320\7;\2\2\u031e"+
		"\u0320\7\33\2\2\u031f\u0319\3\2\2\2\u031f\u031a\3\2\2\2\u031f\u031b\3"+
		"\2\2\2\u031f\u031c\3\2\2\2\u031f\u031d\3\2\2\2\u031f\u031e\3\2\2\2\u0320"+
		"\u00a5\3\2\2\2\u0321\u0322\t\n\2\2\u0322\u00a7\3\2\2\2\u0323\u0324\t\13"+
		"\2\2\u0324\u00a9\3\2\2\2\u0325\u0326\7\f\2\2\u0326\u0328\5\u00bc_\2\u0327"+
		"\u0329\5r:\2\u0328\u0327\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032c\3\2\2"+
		"\2\u032a\u032b\7{\2\2\u032b\u032d\5\16\b\2\u032c\u032a\3\2\2\2\u032c\u032d"+
		"\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0330\5v<\2\u032f\u0331\7G\2\2\u0330"+
		"\u032f\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u00ab\3\2\2\2\u0332\u0333\7\22"+
		"\2\2\u0333\u0334\5\u00bc_\2\u0334\u0336\5\u009aN\2\u0335\u0337\7G\2\2"+
		"\u0336\u0335\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u00ad\3\2\2\2\u0338\u0339"+
		"\7\64\2\2\u0339\u033b\7B\2\2\u033a\u033c\5\u008cG\2\u033b\u033a\3\2\2"+
		"\2\u033b\u033c\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\7C\2\2\u033e\u033f"+
		"\5\u0094K\2\u033f\u00af\3\2\2\2\u0340\u0342\5\u00bc_\2\u0341\u0343\5r"+
		":\2\u0342\u0341\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0344\3\2\2\2\u0344"+
		"\u0346\7B\2\2\u0345\u0347\5\u008cG\2\u0346\u0345\3\2\2\2\u0346\u0347\3"+
		"\2\2\2\u0347\u0348\3\2\2\2\u0348\u0349\7C\2\2\u0349\u034a\7F\2\2\u034a"+
		"\u034b\5\u0086D\2\u034b\u034c\3\2\2\2\u034c\u034d\5\u008aF\2\u034d\u00b1"+
		"\3\2\2\2\u034e\u034f\7\27\2\2\u034f\u0350\5\u00bc_\2\u0350\u0351\7B\2"+
		"\2\u0351\u0354\7C\2\2\u0352\u0353\7F\2\2\u0353\u0355\5\u0086D\2\u0354"+
		"\u0352\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0357\5\u008a"+
		"F\2\u0357\u00b3\3\2\2\2\u0358\u0359\7#\2\2\u0359\u035a\5\u00bc_\2\u035a"+
		"\u035b\7B\2\2\u035b\u035c\5\u008cG\2\u035c\u035f\7C\2\2\u035d\u035e\7"+
		"F\2\2\u035e\u0360\5\u0086D\2\u035f\u035d\3\2\2\2\u035f\u0360\3\2\2\2\u0360"+
		"\u0361\3\2\2\2\u0361\u0362\5\u008aF\2\u0362\u00b5\3\2\2\2\u0363\u0364"+
		"\5\u00bc_\2\u0364\u0365\7F\2\2\u0365\u0368\5\n\6\2\u0366\u0367\7R\2\2"+
		"\u0367\u0369\5\36\20\2\u0368\u0366\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u00b7"+
		"\3\2\2\2\u036a\u036c\7B\2\2\u036b\u036d\5\32\16\2\u036c\u036b\3\2\2\2"+
		"\u036c\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036f\7C\2\2\u036f\u00b9"+
		"\3\2\2\2\u0370\u0372\7B\2\2\u0371\u0373\5\32\16\2\u0372\u0371\3\2\2\2"+
		"\u0372\u0373\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0375\7C\2\2\u0375\u00bb"+
		"\3\2\2\2\u0376\u0377\t\f\2\2\u0377\u00bd\3\2\2\2a\u00c1\u00c5\u00ca\u00ce"+
		"\u00db\u00e3\u00eb\u00f2\u00f8\u00fe\u0106\u010d\u0118\u011e\u0124\u0128"+
		"\u0135\u013d\u0145\u014b\u0152\u015a\u0162\u016c\u0172\u0179\u017e\u0183"+
		"\u018e\u019b\u019e\u01a5\u01ab\u01bb\u01c2\u01ce\u01d3\u01d9\u01dd\u01ea"+
		"\u01f4\u0202\u0206\u020a\u021d\u0220\u0224\u022e\u0236\u023a\u023f\u0249"+
		"\u024e\u0256\u0259\u0260\u0264\u026a\u026e\u0275\u027e\u0281\u0287\u028b"+
		"\u0293\u029c\u02a3\u02a6\u02ad\u02b3\u02bb\u02c2\u02ca\u02cf\u02da\u02e3"+
		"\u02e9\u02f1\u02fe\u0302\u0304\u030b\u031f\u0328\u032c\u0330\u0336\u033b"+
		"\u0342\u0346\u0354\u035f\u0368\u036c\u0372";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}