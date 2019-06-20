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
		TEXT=120;
	public static final int
		RULE_sourceFiles = 0, RULE_sourceFile = 1, RULE_importDeclaration = 2, 
		RULE_moduleOrTypeName = 3, RULE_typeList = 4, RULE_type = 5, RULE_baseType = 6, 
		RULE_primitiveType = 7, RULE_classType = 8, RULE_typeArgumentList = 9, 
		RULE_functionType = 10, RULE_argumentList = 11, RULE_argument = 12, RULE_expression = 13, 
		RULE_nonAssignmentExpression = 14, RULE_assignment = 15, RULE_assignmentOperator = 16, 
		RULE_conditionalOrExpression = 17, RULE_conditionalAndExpression = 18, 
		RULE_inclusiveOrExpression = 19, RULE_exclusiveOrExpression = 20, RULE_andExpression = 21, 
		RULE_equalityExpression = 22, RULE_castExpression = 23, RULE_relationalExpression = 24, 
		RULE_shiftExpression = 25, RULE_additiveExpression = 26, RULE_multiplicativeExpression = 27, 
		RULE_unaryExpression = 28, RULE_primaryExpression = 29, RULE_nativeMethodInvocationStatement = 30, 
		RULE_primaryExpressionStart = 31, RULE_expressionList = 32, RULE_memberAccess = 33, 
		RULE_bracketExpression = 34, RULE_lambdaExpression = 35, RULE_anonymousFunctionSignature = 36, 
		RULE_explicitAnonymousFunctionParameterList = 37, RULE_explicitAnonymousFunctionParameter = 38, 
		RULE_implicitAnonymousFunctionParameterList = 39, RULE_anonymousFunctionBody = 40, 
		RULE_statement = 41, RULE_embeddedStatement = 42, RULE_simpleEmbeddedStatement = 43, 
		RULE_block = 44, RULE_variableDeclaration = 45, RULE_variableType = 46, 
		RULE_variableDeclarator = 47, RULE_switchSection = 48, RULE_switchLabel = 49, 
		RULE_statementList = 50, RULE_forInitializer = 51, RULE_forIterator = 52, 
		RULE_moduleDeclaration = 53, RULE_moduleBody = 54, RULE_moduleMemberDeclarations = 55, 
		RULE_moduleMemberDeclaration = 56, RULE_functionDeclaration = 57, RULE_typeDeclaration = 58, 
		RULE_typeParameterList = 59, RULE_typeParameter = 60, RULE_classBody = 61, 
		RULE_classMemberDeclarations = 62, RULE_classMemberDeclaration = 63, RULE_allMemberModifiers = 64, 
		RULE_allMemberModifier = 65, RULE_commonMemberDeclaration = 66, RULE_typedMemberDeclaration = 67, 
		RULE_classField = 68, RULE_returnTypeList = 69, RULE_returnType = 70, 
		RULE_methodBody = 71, RULE_formalParameterList = 72, RULE_fixedParameters = 73, 
		RULE_fixedParameter = 74, RULE_constructorInitializer = 75, RULE_body = 76, 
		RULE_variantTypeParameterList = 77, RULE_variantTypeParameter = 78, RULE_enumBody = 79, 
		RULE_enumMemberDeclaration = 80, RULE_rightArrow = 81, RULE_rightShift = 82, 
		RULE_rightShiftAssignment = 83, RULE_literal = 84, RULE_booleanLiteral = 85, 
		RULE_stringLiteral = 86, RULE_classDefinition = 87, RULE_enumDefinition = 88, 
		RULE_constructorDeclaration = 89, RULE_methodDeclaration = 90, RULE_getterDeclaration = 91, 
		RULE_setterDeclaration = 92, RULE_argDeclaration = 93, RULE_methodInvocation = 94, 
		RULE_objectCreationExpression = 95, RULE_identifier = 96;
	public static final String[] ruleNames = {
		"sourceFiles", "sourceFile", "importDeclaration", "moduleOrTypeName", 
		"typeList", "type", "baseType", "primitiveType", "classType", "typeArgumentList", 
		"functionType", "argumentList", "argument", "expression", "nonAssignmentExpression", 
		"assignment", "assignmentOperator", "conditionalOrExpression", "conditionalAndExpression", 
		"inclusiveOrExpression", "exclusiveOrExpression", "andExpression", "equalityExpression", 
		"castExpression", "relationalExpression", "shiftExpression", "additiveExpression", 
		"multiplicativeExpression", "unaryExpression", "primaryExpression", "nativeMethodInvocationStatement", 
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
		"TEXT"
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
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(194);
					sourceFile();
					}
					} 
				}
				setState(199);
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
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BYTE_ORDER_MARK) {
				{
				setState(200);
				match(BYTE_ORDER_MARK);
				}
			}

			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(203);
				importDeclaration();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(209);
				moduleMemberDeclarations();
				}
			}

			setState(212);
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
			setState(214);
			match(IMPORT);
			setState(215);
			stringLiteral();
			setState(216);
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
			setState(218);
			identifier();
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(219);
				match(DOT);
				setState(220);
				identifier();
				}
				}
				setState(225);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
			setState(226);
			type();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_OR) {
				{
				{
				setState(227);
				match(BITWISE_OR);
				setState(228);
				type();
				}
				}
				setState(233);
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
		enterRule(_localctx, 10, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			baseType();
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					match(OPEN_BRACKET);
					setState(236);
					match(CLOSE_BRACKET);
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		enterRule(_localctx, 12, RULE_baseType);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				classType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
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
		enterRule(_localctx, 14, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			moduleOrTypeName();
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
		enterRule(_localctx, 18, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(LT);
			setState(252);
			typeList();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(253);
				match(COMMA);
				setState(254);
				typeList();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
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
		enterRule(_localctx, 20, RULE_functionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(OPEN_PARENS);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(263);
				formalParameterList();
				}
			}

			setState(266);
			match(CLOSE_PARENS);
			setState(267);
			rightArrow();
			setState(268);
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
		enterRule(_localctx, 22, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			argument();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(271);
				match(COMMA);
				setState(272);
				argument();
				}
				}
				setState(277);
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
		enterRule(_localctx, 24, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(278);
				identifier();
				setState(279);
				match(COLON);
				}
				break;
			}
			setState(283);
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
		enterRule(_localctx, 26, RULE_expression);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
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
		enterRule(_localctx, 28, RULE_nonAssignmentExpression);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
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
		enterRule(_localctx, 30, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			unaryExpression();
			setState(294);
			assignmentOperator();
			setState(295);
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
		public RightShiftAssignmentContext rightShiftAssignment() {
			return getRuleContext(RightShiftAssignmentContext.class,0);
		}
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignmentOperator);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGNMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				match(ASSIGNMENT);
				}
				break;
			case OP_ADD_ASSIGNMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(OP_ADD_ASSIGNMENT);
				}
				break;
			case OP_SUB_ASSIGNMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				match(OP_SUB_ASSIGNMENT);
				}
				break;
			case OP_MULT_ASSIGNMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				match(OP_MULT_ASSIGNMENT);
				}
				break;
			case OP_DIV_ASSIGNMENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				match(OP_DIV_ASSIGNMENT);
				}
				break;
			case OP_MOD_ASSIGNMENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				match(OP_MOD_ASSIGNMENT);
				}
				break;
			case OP_AND_ASSIGNMENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(303);
				match(OP_AND_ASSIGNMENT);
				}
				break;
			case OP_OR_ASSIGNMENT:
				enterOuterAlt(_localctx, 8);
				{
				setState(304);
				match(OP_OR_ASSIGNMENT);
				}
				break;
			case OP_XOR_ASSIGNMENT:
				enterOuterAlt(_localctx, 9);
				{
				setState(305);
				match(OP_XOR_ASSIGNMENT);
				}
				break;
			case OP_LEFT_SHIFT_ASSIGNMENT:
				enterOuterAlt(_localctx, 10);
				{
				setState(306);
				match(OP_LEFT_SHIFT_ASSIGNMENT);
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 11);
				{
				setState(307);
				rightShiftAssignment();
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
		enterRule(_localctx, 34, RULE_conditionalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			conditionalAndExpression();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_OR) {
				{
				{
				setState(311);
				match(OP_OR);
				setState(312);
				conditionalAndExpression();
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

	public static class ConditionalAndExpressionContext extends ParserRuleContext {
		public List<InclusiveOrExpressionContext> inclusiveOrExpression() {
			return getRuleContexts(InclusiveOrExpressionContext.class);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression(int i) {
			return getRuleContext(InclusiveOrExpressionContext.class,i);
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
		enterRule(_localctx, 36, RULE_conditionalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			inclusiveOrExpression();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_AND) {
				{
				{
				setState(319);
				match(OP_AND);
				setState(320);
				inclusiveOrExpression();
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

	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public List<ExclusiveOrExpressionContext> exclusiveOrExpression() {
			return getRuleContexts(ExclusiveOrExpressionContext.class);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression(int i) {
			return getRuleContext(ExclusiveOrExpressionContext.class,i);
		}
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_inclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			exclusiveOrExpression();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_OR) {
				{
				{
				setState(327);
				match(BITWISE_OR);
				setState(328);
				exclusiveOrExpression();
				}
				}
				setState(333);
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

	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			andExpression();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CARET) {
				{
				{
				setState(335);
				match(CARET);
				setState(336);
				andExpression();
				}
				}
				setState(341);
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

	public static class AndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			equalityExpression();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMP) {
				{
				{
				setState(343);
				match(AMP);
				setState(344);
				equalityExpression();
				}
				}
				setState(349);
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
		enterRule(_localctx, 44, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			castExpression();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_EQ || _la==OP_NE) {
				{
				{
				setState(351);
				_la = _input.LA(1);
				if ( !(_la==OP_EQ || _la==OP_NE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(352);
				castExpression();
				}
				}
				setState(357);
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
		enterRule(_localctx, 46, RULE_castExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			relationalExpression();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(359);
				match(AS);
				setState(360);
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
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			shiftExpression();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) {
				{
				{
				setState(364);
				_la = _input.LA(1);
				if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(365);
				shiftExpression();
				}
				}
				setState(370);
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

	public static class ShiftExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<RightShiftContext> rightShift() {
			return getRuleContexts(RightShiftContext.class);
		}
		public RightShiftContext rightShift(int i) {
			return getRuleContext(RightShiftContext.class,i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_shiftExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			additiveExpression();
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(374);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OP_LEFT_SHIFT:
						{
						setState(372);
						match(OP_LEFT_SHIFT);
						}
						break;
					case GT:
						{
						setState(373);
						rightShift();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(376);
					additiveExpression();
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 52, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			multiplicativeExpression();
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(383);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(384);
				multiplicativeExpression();
				}
				}
				setState(389);
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
		enterRule(_localctx, 54, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			unaryExpression();
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) {
				{
				{
				setState(391);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(392);
				unaryExpression();
				}
				}
				setState(397);
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
		enterRule(_localctx, 56, RULE_unaryExpression);
		try {
			setState(411);
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
				setState(398);
				primaryExpression();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				match(PLUS);
				setState(400);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(401);
				match(MINUS);
				setState(402);
				unaryExpression();
				}
				break;
			case BANG:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				match(BANG);
				setState(404);
				unaryExpression();
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 5);
				{
				setState(405);
				match(TILDE);
				setState(406);
				unaryExpression();
				}
				break;
			case OP_INC:
				enterOuterAlt(_localctx, 6);
				{
				setState(407);
				match(OP_INC);
				setState(408);
				unaryExpression();
				}
				break;
			case OP_DEC:
				enterOuterAlt(_localctx, 7);
				{
				setState(409);
				match(OP_DEC);
				setState(410);
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
		enterRule(_localctx, 58, RULE_primaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			((PrimaryExpressionContext)_localctx).pe = primaryExpressionStart();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACKET) {
				{
				{
				setState(414);
				bracketExpression();
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (DOT - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				{
				setState(424);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(420);
					memberAccess();
					}
					break;
				case OPEN_PARENS:
					{
					setState(421);
					methodInvocation();
					}
					break;
				case OP_INC:
					{
					setState(422);
					match(OP_INC);
					}
					break;
				case OP_DEC:
					{
					setState(423);
					match(OP_DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPEN_BRACKET) {
					{
					{
					setState(426);
					bracketExpression();
					}
					}
					setState(431);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(436);
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
		enterRule(_localctx, 60, RULE_nativeMethodInvocationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			((NativeMethodInvocationStatementContext)_localctx).pe = identifier();
			setState(438);
			memberAccess();
			setState(439);
			methodInvocation();
			setState(440);
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
		enterRule(_localctx, 62, RULE_primaryExpressionStart);
		int _la;
		try {
			setState(461);
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
				setState(442);
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
				setState(443);
				identifier();
				setState(445);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(444);
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
				setState(447);
				match(OPEN_PARENS);
				setState(448);
				expression();
				setState(449);
				match(CLOSE_PARENS);
				}
				break;
			case THIS:
				_localctx = new ThisReferenceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				match(THIS);
				}
				break;
			case NEW:
				_localctx = new ObjectCreationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				match(NEW);
				setState(453);
				type();
				setState(454);
				objectCreationExpression();
				}
				break;
			case OPEN_BRACKET:
				_localctx = new ArrayCreationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(456);
				match(OPEN_BRACKET);
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
					{
					setState(457);
					expressionList();
					}
				}

				setState(460);
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
		enterRule(_localctx, 64, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			expression();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(464);
				match(COMMA);
				setState(465);
				expression();
				}
				}
				setState(470);
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
		enterRule(_localctx, 66, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(DOT);
			setState(472);
			identifier();
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(473);
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
		enterRule(_localctx, 68, RULE_bracketExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(OPEN_BRACKET);
			setState(477);
			expression();
			setState(478);
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
		enterRule(_localctx, 70, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			anonymousFunctionSignature();
			setState(481);
			rightArrow();
			setState(482);
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
		enterRule(_localctx, 72, RULE_anonymousFunctionSignature);
		try {
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				match(OPEN_PARENS);
				setState(485);
				match(CLOSE_PARENS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				match(OPEN_PARENS);
				setState(487);
				explicitAnonymousFunctionParameterList();
				setState(488);
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
		enterRule(_localctx, 74, RULE_explicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			explicitAnonymousFunctionParameter();
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(493);
				match(COMMA);
				setState(494);
				explicitAnonymousFunctionParameter();
				}
				}
				setState(499);
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
		enterRule(_localctx, 76, RULE_explicitAnonymousFunctionParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			identifier();
			setState(501);
			match(COLON);
			setState(502);
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
		enterRule(_localctx, 78, RULE_implicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			identifier();
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(505);
				match(COMMA);
				setState(506);
				identifier();
				}
				}
				setState(511);
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
		enterRule(_localctx, 80, RULE_anonymousFunctionBody);
		try {
			setState(514);
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
			case TILDE:
			case OP_INC:
			case OP_DEC:
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				expression();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(513);
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
		enterRule(_localctx, 82, RULE_statement);
		try {
			setState(520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new DeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				variableDeclaration();
				setState(517);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new EmbeddedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
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
		enterRule(_localctx, 84, RULE_embeddedStatement);
		try {
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				block();
				}
				break;
			case BREAK:
			case CONTINUE:
			case FALSE:
			case FOR:
			case FOREACH:
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
			case TILDE:
			case OP_INC:
			case OP_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
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
		public TerminalNode FOREACH() { return getToken(TypescriptParser.FOREACH, 0); }
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
		enterRule(_localctx, 86, RULE_simpleEmbeddedStatement);
		int _la;
		try {
			setState(591);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(526);
				match(SEMICOLON);
				}
				break;
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
			case TILDE:
			case OP_INC:
			case OP_DEC:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(527);
				expression();
				setState(528);
				match(SEMICOLON);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(530);
				match(IF);
				setState(531);
				match(OPEN_PARENS);
				setState(532);
				expression();
				setState(533);
				match(CLOSE_PARENS);
				setState(534);
				embeddedStatement();
				setState(537);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(535);
					match(ELSE);
					setState(536);
					embeddedStatement();
					}
					break;
				}
				}
				break;
			case SWITCH:
				_localctx = new SwitchStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(539);
				match(SWITCH);
				setState(540);
				match(OPEN_PARENS);
				setState(541);
				expression();
				setState(542);
				match(CLOSE_PARENS);
				setState(543);
				match(OPEN_BRACE);
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(544);
					switchSection();
					}
					}
					setState(549);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(550);
				match(CLOSE_BRACE);
				}
				break;
			case WHILE:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(552);
				match(WHILE);
				setState(553);
				match(OPEN_PARENS);
				setState(554);
				expression();
				setState(555);
				match(CLOSE_PARENS);
				setState(556);
				embeddedStatement();
				}
				break;
			case FOR:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(558);
				match(FOR);
				setState(559);
				match(OPEN_PARENS);
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
					{
					setState(560);
					forInitializer();
					}
				}

				setState(563);
				match(SEMICOLON);
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
					{
					setState(564);
					expression();
					}
				}

				setState(567);
				match(SEMICOLON);
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
					{
					setState(568);
					forIterator();
					}
				}

				setState(571);
				match(CLOSE_PARENS);
				setState(572);
				embeddedStatement();
				}
				break;
			case FOREACH:
				_localctx = new ForeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(573);
				match(FOREACH);
				setState(574);
				match(OPEN_PARENS);
				setState(575);
				variableType();
				setState(576);
				identifier();
				setState(577);
				match(OF);
				setState(578);
				expression();
				setState(579);
				match(CLOSE_PARENS);
				setState(580);
				embeddedStatement();
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(582);
				match(BREAK);
				setState(583);
				match(SEMICOLON);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(584);
				match(CONTINUE);
				setState(585);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(586);
				match(RETURN);
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
					{
					setState(587);
					expression();
					}
				}

				setState(590);
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
		enterRule(_localctx, 88, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(OPEN_BRACE);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << FOREACH) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				setState(594);
				statementList();
				}
			}

			setState(597);
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
		enterRule(_localctx, 90, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			variableType();
			setState(600);
			variableDeclarator();
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(601);
				match(COMMA);
				setState(602);
				variableDeclarator();
				}
				}
				setState(607);
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
		enterRule(_localctx, 92, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
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
		enterRule(_localctx, 94, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			identifier();
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(611);
				match(COLON);
				setState(612);
				type();
				}
			}

			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(615);
				match(ASSIGNMENT);
				setState(616);
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
		enterRule(_localctx, 96, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(619);
				switchLabel();
				}
				}
				setState(622); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(624);
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
		enterRule(_localctx, 98, RULE_switchLabel);
		try {
			setState(632);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(626);
				match(CASE);
				setState(627);
				expression();
				setState(628);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(630);
				match(DEFAULT);
				setState(631);
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
		enterRule(_localctx, 100, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(634);
				statement();
				}
				}
				setState(637); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << FOREACH) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0) );
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
		enterRule(_localctx, 102, RULE_forInitializer);
		int _la;
		try {
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(639);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(640);
				expression();
				setState(645);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(641);
					match(COMMA);
					setState(642);
					expression();
					}
					}
					setState(647);
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
		enterRule(_localctx, 104, RULE_forIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			expression();
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(651);
				match(COMMA);
				setState(652);
				expression();
				}
				}
				setState(657);
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
		public ModuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDeclaration; }
	}

	public final ModuleDeclarationContext moduleDeclaration() throws RecognitionException {
		ModuleDeclarationContext _localctx = new ModuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			match(MODULE);
			setState(659);
			identifier();
			setState(660);
			moduleBody();
			setState(662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(661);
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
		enterRule(_localctx, 108, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			match(OPEN_BRACE);
			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(665);
				moduleMemberDeclarations();
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
		enterRule(_localctx, 110, RULE_moduleMemberDeclarations);
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
				moduleMemberDeclaration();
				}
				}
				setState(673); 
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
		enterRule(_localctx, 112, RULE_moduleMemberDeclaration);
		try {
			setState(682);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				moduleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				typeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(677);
				variableDeclaration();
				setState(678);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(680);
				nativeMethodInvocationStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(681);
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
		enterRule(_localctx, 114, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(684);
				match(EXPORT);
				}
			}

			setState(687);
			match(FUNCTION);
			setState(688);
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
		enterRule(_localctx, 116, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(690);
				allMemberModifiers();
				}
			}

			setState(695);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(693);
				classDefinition();
				}
				break;
			case ENUM:
				{
				setState(694);
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
		enterRule(_localctx, 118, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(LT);
			setState(698);
			typeParameter();
			setState(703);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(699);
				match(COMMA);
				setState(700);
				typeParameter();
				}
				}
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(706);
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
		enterRule(_localctx, 120, RULE_typeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
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
		enterRule(_localctx, 122, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(OPEN_BRACE);
			setState(712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << CONSTRUCTOR) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(711);
				classMemberDeclarations();
				}
			}

			setState(714);
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
		enterRule(_localctx, 124, RULE_classMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(716);
				classMemberDeclaration();
				}
				}
				setState(719); 
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
		enterRule(_localctx, 126, RULE_classMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(721);
				allMemberModifiers();
				}
			}

			setState(724);
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
		enterRule(_localctx, 128, RULE_allMemberModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(726);
				allMemberModifier();
				}
				}
				setState(729); 
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
		enterRule(_localctx, 130, RULE_allMemberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
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
		enterRule(_localctx, 132, RULE_commonMemberDeclaration);
		try {
			setState(735);
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
				setState(733);
				typedMemberDeclaration();
				}
				break;
			case CONSTRUCTOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
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
		enterRule(_localctx, 134, RULE_typedMemberDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(737);
				methodDeclaration();
				}
				break;
			case 2:
				{
				setState(738);
				getterDeclaration();
				}
				break;
			case 3:
				{
				setState(739);
				setterDeclaration();
				}
				break;
			case 4:
				{
				setState(740);
				classField();
				setState(741);
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
		enterRule(_localctx, 136, RULE_classField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			variableDeclarator();
			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(746);
				match(COMMA);
				setState(747);
				variableDeclarator();
				}
				}
				setState(752);
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
		enterRule(_localctx, 138, RULE_returnTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			returnType();
			setState(758);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(754);
					match(BITWISE_OR);
					setState(755);
					returnType();
					}
					} 
				}
				setState(760);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
		enterRule(_localctx, 140, RULE_returnType);
		try {
			setState(763);
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
				setState(761);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
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
		enterRule(_localctx, 142, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
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
		enterRule(_localctx, 144, RULE_formalParameterList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
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
		enterRule(_localctx, 146, RULE_fixedParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			fixedParameter();
			setState(774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(770);
				match(COMMA);
				setState(771);
				fixedParameter();
				}
				}
				setState(776);
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
		enterRule(_localctx, 148, RULE_fixedParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
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
		enterRule(_localctx, 150, RULE_constructorInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			match(COLON);
			setState(780);
			match(SUPER);
			setState(781);
			match(OPEN_PARENS);
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				setState(782);
				argumentList();
				}
			}

			setState(785);
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
		enterRule(_localctx, 152, RULE_body);
		try {
			setState(789);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(787);
				block();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(788);
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
		enterRule(_localctx, 154, RULE_variantTypeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(LT);
			setState(792);
			variantTypeParameter();
			setState(797);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(793);
				match(COMMA);
				setState(794);
				variantTypeParameter();
				}
				}
				setState(799);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(800);
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
		enterRule(_localctx, 156, RULE_variantTypeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
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
		enterRule(_localctx, 158, RULE_enumBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			match(OPEN_BRACE);
			setState(816);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(805);
				enumMemberDeclaration();
				setState(810);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(806);
						match(COMMA);
						setState(807);
						enumMemberDeclaration();
						}
						} 
					}
					setState(812);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				}
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(813);
					match(COMMA);
					}
				}

				}
			}

			setState(818);
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
		enterRule(_localctx, 160, RULE_enumMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			identifier();
			setState(823);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(821);
				match(ASSIGNMENT);
				setState(822);
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
		enterRule(_localctx, 162, RULE_rightArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			((RightArrowContext)_localctx).first = match(ASSIGNMENT);
			setState(826);
			((RightArrowContext)_localctx).second = match(GT);
			setState(827);
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
		enterRule(_localctx, 164, RULE_rightShift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			((RightShiftContext)_localctx).first = match(GT);
			setState(830);
			((RightShiftContext)_localctx).second = match(GT);
			setState(831);
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
		enterRule(_localctx, 166, RULE_rightShiftAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			((RightShiftAssignmentContext)_localctx).first = match(GT);
			setState(834);
			((RightShiftAssignmentContext)_localctx).second = match(OP_GE);
			setState(835);
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
		enterRule(_localctx, 168, RULE_literal);
		try {
			setState(843);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(837);
				booleanLiteral();
				}
				break;
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(838);
				stringLiteral();
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(839);
				match(INTEGER_LITERAL);
				}
				break;
			case HEX_INTEGER_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(840);
				match(HEX_INTEGER_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(841);
				match(REAL_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(842);
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
		enterRule(_localctx, 170, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
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
		enterRule(_localctx, 172, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
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
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(CLASS);
			setState(850);
			identifier();
			setState(852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(851);
				typeParameterList();
				}
			}

			setState(854);
			classBody();
			setState(856);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(855);
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
		enterRule(_localctx, 176, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			match(ENUM);
			setState(859);
			identifier();
			setState(860);
			enumBody();
			setState(862);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(861);
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
		enterRule(_localctx, 178, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			match(CONSTRUCTOR);
			setState(865);
			match(OPEN_PARENS);
			setState(867);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(866);
				formalParameterList();
				}
			}

			setState(869);
			match(CLOSE_PARENS);
			setState(870);
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
		enterRule(_localctx, 180, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			identifier();
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(873);
				typeParameterList();
				}
			}

			setState(876);
			match(OPEN_PARENS);
			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(877);
				formalParameterList();
				}
			}

			setState(880);
			match(CLOSE_PARENS);
			{
			setState(881);
			match(COLON);
			setState(882);
			returnTypeList();
			}
			setState(884);
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
		enterRule(_localctx, 182, RULE_getterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			match(GET);
			setState(887);
			identifier();
			setState(888);
			match(OPEN_PARENS);
			setState(889);
			match(CLOSE_PARENS);
			setState(892);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(890);
				match(COLON);
				setState(891);
				returnTypeList();
				}
			}

			setState(894);
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
		enterRule(_localctx, 184, RULE_setterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			match(SET);
			setState(897);
			identifier();
			setState(898);
			match(OPEN_PARENS);
			setState(899);
			formalParameterList();
			setState(900);
			match(CLOSE_PARENS);
			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(901);
				match(COLON);
				setState(902);
				returnTypeList();
				}
			}

			setState(905);
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
		enterRule(_localctx, 186, RULE_argDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			identifier();
			setState(908);
			match(COLON);
			setState(909);
			typeList();
			setState(912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(910);
				match(ASSIGNMENT);
				setState(911);
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
		enterRule(_localctx, 188, RULE_methodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			match(OPEN_PARENS);
			setState(916);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				setState(915);
				argumentList();
				}
			}

			setState(918);
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
		enterRule(_localctx, 190, RULE_objectCreationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			match(OPEN_PARENS);
			setState(922);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				setState(921);
				argumentList();
				}
			}

			setState(924);
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
		enterRule(_localctx, 192, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
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
		case 81:
			return rightArrow_sempred((RightArrowContext)_localctx, predIndex);
		case 82:
			return rightShift_sempred((RightShiftContext)_localctx, predIndex);
		case 83:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3z\u03a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\3\2\7\2\u00c6\n\2\f\2\16\2\u00c9\13\2\3\3\5\3\u00cc\n"+
		"\3\3\3\7\3\u00cf\n\3\f\3\16\3\u00d2\13\3\3\3\5\3\u00d5\n\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\7\5\u00e0\n\5\f\5\16\5\u00e3\13\5\3\6\3\6\3\6"+
		"\7\6\u00e8\n\6\f\6\16\6\u00eb\13\6\3\7\3\7\3\7\7\7\u00f0\n\7\f\7\16\7"+
		"\u00f3\13\7\3\b\3\b\3\b\5\b\u00f8\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\7\13\u0102\n\13\f\13\16\13\u0105\13\13\3\13\3\13\3\f\3\f\5\f\u010b"+
		"\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u0114\n\r\f\r\16\r\u0117\13\r\3\16"+
		"\3\16\3\16\5\16\u011c\n\16\3\16\3\16\3\17\3\17\5\17\u0122\n\17\3\20\3"+
		"\20\5\20\u0126\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0137\n\22\3\23\3\23\3\23\7\23\u013c\n"+
		"\23\f\23\16\23\u013f\13\23\3\24\3\24\3\24\7\24\u0144\n\24\f\24\16\24\u0147"+
		"\13\24\3\25\3\25\3\25\7\25\u014c\n\25\f\25\16\25\u014f\13\25\3\26\3\26"+
		"\3\26\7\26\u0154\n\26\f\26\16\26\u0157\13\26\3\27\3\27\3\27\7\27\u015c"+
		"\n\27\f\27\16\27\u015f\13\27\3\30\3\30\3\30\7\30\u0164\n\30\f\30\16\30"+
		"\u0167\13\30\3\31\3\31\3\31\5\31\u016c\n\31\3\32\3\32\3\32\7\32\u0171"+
		"\n\32\f\32\16\32\u0174\13\32\3\33\3\33\3\33\5\33\u0179\n\33\3\33\7\33"+
		"\u017c\n\33\f\33\16\33\u017f\13\33\3\34\3\34\3\34\7\34\u0184\n\34\f\34"+
		"\16\34\u0187\13\34\3\35\3\35\3\35\7\35\u018c\n\35\f\35\16\35\u018f\13"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5"+
		"\36\u019e\n\36\3\37\3\37\7\37\u01a2\n\37\f\37\16\37\u01a5\13\37\3\37\3"+
		"\37\3\37\3\37\5\37\u01ab\n\37\3\37\7\37\u01ae\n\37\f\37\16\37\u01b1\13"+
		"\37\7\37\u01b3\n\37\f\37\16\37\u01b6\13\37\3 \3 \3 \3 \3 \3!\3!\3!\5!"+
		"\u01c0\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01cd\n!\3!\5!\u01d0\n!"+
		"\3\"\3\"\3\"\7\"\u01d5\n\"\f\"\16\"\u01d8\13\"\3#\3#\3#\5#\u01dd\n#\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\5&\u01ed\n&\3\'\3\'\3\'\7\'\u01f2"+
		"\n\'\f\'\16\'\u01f5\13\'\3(\3(\3(\3(\3)\3)\3)\7)\u01fe\n)\f)\16)\u0201"+
		"\13)\3*\3*\5*\u0205\n*\3+\3+\3+\3+\5+\u020b\n+\3,\3,\5,\u020f\n,\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u021c\n-\3-\3-\3-\3-\3-\3-\7-\u0224\n"+
		"-\f-\16-\u0227\13-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0234\n-\3-\3-"+
		"\5-\u0238\n-\3-\3-\5-\u023c\n-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3-\3-\5-\u024f\n-\3-\5-\u0252\n-\3.\3.\5.\u0256\n.\3.\3.\3/\3/"+
		"\3/\3/\7/\u025e\n/\f/\16/\u0261\13/\3\60\3\60\3\61\3\61\3\61\5\61\u0268"+
		"\n\61\3\61\3\61\5\61\u026c\n\61\3\62\6\62\u026f\n\62\r\62\16\62\u0270"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u027b\n\63\3\64\6\64\u027e"+
		"\n\64\r\64\16\64\u027f\3\65\3\65\3\65\3\65\7\65\u0286\n\65\f\65\16\65"+
		"\u0289\13\65\5\65\u028b\n\65\3\66\3\66\3\66\7\66\u0290\n\66\f\66\16\66"+
		"\u0293\13\66\3\67\3\67\3\67\3\67\5\67\u0299\n\67\38\38\58\u029d\n8\38"+
		"\38\39\69\u02a2\n9\r9\169\u02a3\3:\3:\3:\3:\3:\3:\3:\5:\u02ad\n:\3;\5"+
		";\u02b0\n;\3;\3;\3;\3<\5<\u02b6\n<\3<\3<\5<\u02ba\n<\3=\3=\3=\3=\7=\u02c0"+
		"\n=\f=\16=\u02c3\13=\3=\3=\3>\3>\3?\3?\5?\u02cb\n?\3?\3?\3@\6@\u02d0\n"+
		"@\r@\16@\u02d1\3A\5A\u02d5\nA\3A\3A\3B\6B\u02da\nB\rB\16B\u02db\3C\3C"+
		"\3D\3D\5D\u02e2\nD\3E\3E\3E\3E\3E\3E\5E\u02ea\nE\3F\3F\3F\7F\u02ef\nF"+
		"\fF\16F\u02f2\13F\3G\3G\3G\7G\u02f7\nG\fG\16G\u02fa\13G\3H\3H\5H\u02fe"+
		"\nH\3I\3I\3J\3J\3K\3K\3K\7K\u0307\nK\fK\16K\u030a\13K\3L\3L\3M\3M\3M\3"+
		"M\5M\u0312\nM\3M\3M\3N\3N\5N\u0318\nN\3O\3O\3O\3O\7O\u031e\nO\fO\16O\u0321"+
		"\13O\3O\3O\3P\3P\3Q\3Q\3Q\3Q\7Q\u032b\nQ\fQ\16Q\u032e\13Q\3Q\5Q\u0331"+
		"\nQ\5Q\u0333\nQ\3Q\3Q\3R\3R\3R\5R\u033a\nR\3S\3S\3S\3S\3T\3T\3T\3T\3U"+
		"\3U\3U\3U\3V\3V\3V\3V\3V\3V\5V\u034e\nV\3W\3W\3X\3X\3Y\3Y\3Y\5Y\u0357"+
		"\nY\3Y\3Y\5Y\u035b\nY\3Z\3Z\3Z\3Z\5Z\u0361\nZ\3[\3[\3[\5[\u0366\n[\3["+
		"\3[\3[\3\\\3\\\5\\\u036d\n\\\3\\\3\\\5\\\u0371\n\\\3\\\3\\\3\\\3\\\3\\"+
		"\3\\\3]\3]\3]\3]\3]\3]\5]\u037f\n]\3]\3]\3^\3^\3^\3^\3^\3^\3^\5^\u038a"+
		"\n^\3^\3^\3_\3_\3_\3_\3_\5_\u0393\n_\3`\3`\5`\u0397\n`\3`\3`\3a\3a\5a"+
		"\u039d\na\3a\3a\3b\3b\3b\2\2c\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\2\f\5\2\b\b%%..\3\2]"+
		"^\4\2ST_`\3\2HI\3\2JL\5\2\r\r\31\31++\6\2\36\36 !$$\65\65\4\2\23\23))"+
		"\3\2<=\b\2\27\27\31\31##++..\67\67\2\u03c8\2\u00c7\3\2\2\2\4\u00cb\3\2"+
		"\2\2\6\u00d8\3\2\2\2\b\u00dc\3\2\2\2\n\u00e4\3\2\2\2\f\u00ec\3\2\2\2\16"+
		"\u00f7\3\2\2\2\20\u00f9\3\2\2\2\22\u00fb\3\2\2\2\24\u00fd\3\2\2\2\26\u0108"+
		"\3\2\2\2\30\u0110\3\2\2\2\32\u011b\3\2\2\2\34\u0121\3\2\2\2\36\u0125\3"+
		"\2\2\2 \u0127\3\2\2\2\"\u0136\3\2\2\2$\u0138\3\2\2\2&\u0140\3\2\2\2(\u0148"+
		"\3\2\2\2*\u0150\3\2\2\2,\u0158\3\2\2\2.\u0160\3\2\2\2\60\u0168\3\2\2\2"+
		"\62\u016d\3\2\2\2\64\u0175\3\2\2\2\66\u0180\3\2\2\28\u0188\3\2\2\2:\u019d"+
		"\3\2\2\2<\u019f\3\2\2\2>\u01b7\3\2\2\2@\u01cf\3\2\2\2B\u01d1\3\2\2\2D"+
		"\u01d9\3\2\2\2F\u01de\3\2\2\2H\u01e2\3\2\2\2J\u01ec\3\2\2\2L\u01ee\3\2"+
		"\2\2N\u01f6\3\2\2\2P\u01fa\3\2\2\2R\u0204\3\2\2\2T\u020a\3\2\2\2V\u020e"+
		"\3\2\2\2X\u0251\3\2\2\2Z\u0253\3\2\2\2\\\u0259\3\2\2\2^\u0262\3\2\2\2"+
		"`\u0264\3\2\2\2b\u026e\3\2\2\2d\u027a\3\2\2\2f\u027d\3\2\2\2h\u028a\3"+
		"\2\2\2j\u028c\3\2\2\2l\u0294\3\2\2\2n\u029a\3\2\2\2p\u02a1\3\2\2\2r\u02ac"+
		"\3\2\2\2t\u02af\3\2\2\2v\u02b5\3\2\2\2x\u02bb\3\2\2\2z\u02c6\3\2\2\2|"+
		"\u02c8\3\2\2\2~\u02cf\3\2\2\2\u0080\u02d4\3\2\2\2\u0082\u02d9\3\2\2\2"+
		"\u0084\u02dd\3\2\2\2\u0086\u02e1\3\2\2\2\u0088\u02e9\3\2\2\2\u008a\u02eb"+
		"\3\2\2\2\u008c\u02f3\3\2\2\2\u008e\u02fd\3\2\2\2\u0090\u02ff\3\2\2\2\u0092"+
		"\u0301\3\2\2\2\u0094\u0303\3\2\2\2\u0096\u030b\3\2\2\2\u0098\u030d\3\2"+
		"\2\2\u009a\u0317\3\2\2\2\u009c\u0319\3\2\2\2\u009e\u0324\3\2\2\2\u00a0"+
		"\u0326\3\2\2\2\u00a2\u0336\3\2\2\2\u00a4\u033b\3\2\2\2\u00a6\u033f\3\2"+
		"\2\2\u00a8\u0343\3\2\2\2\u00aa\u034d\3\2\2\2\u00ac\u034f\3\2\2\2\u00ae"+
		"\u0351\3\2\2\2\u00b0\u0353\3\2\2\2\u00b2\u035c\3\2\2\2\u00b4\u0362\3\2"+
		"\2\2\u00b6\u036a\3\2\2\2\u00b8\u0378\3\2\2\2\u00ba\u0382\3\2\2\2\u00bc"+
		"\u038d\3\2\2\2\u00be\u0394\3\2\2\2\u00c0\u039a\3\2\2\2\u00c2\u03a0\3\2"+
		"\2\2\u00c4\u00c6\5\4\3\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\3\3\2\2\2\u00c9\u00c7\3\2\2\2"+
		"\u00ca\u00cc\7\3\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d0"+
		"\3\2\2\2\u00cd\u00cf\5\6\4\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d3\u00d5\5p9\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d7\7\2\2\3\u00d7\5\3\2\2\2\u00d8\u00d9\7\62\2\2\u00d9"+
		"\u00da\5\u00aeX\2\u00da\u00db\7G\2\2\u00db\7\3\2\2\2\u00dc\u00e1\5\u00c2"+
		"b\2\u00dd\u00de\7D\2\2\u00de\u00e0\5\u00c2b\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\t\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e4\u00e9\5\f\7\2\u00e5\u00e6\7N\2\2\u00e6\u00e8"+
		"\5\f\7\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\13\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f1\5\16\b"+
		"\2\u00ed\u00ee\7@\2\2\u00ee\u00f0\7A\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\r\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f8\5\20\t\2\u00f5\u00f8\5\22\n\2\u00f6\u00f8\5"+
		"\26\f\2\u00f7\u00f4\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"\17\3\2\2\2\u00f9\u00fa\t\2\2\2\u00fa\21\3\2\2\2\u00fb\u00fc\5\b\5\2\u00fc"+
		"\23\3\2\2\2\u00fd\u00fe\7S\2\2\u00fe\u0103\5\n\6\2\u00ff\u0100\7E\2\2"+
		"\u0100\u0102\5\n\6\2\u0101\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u0107\7T\2\2\u0107\25\3\2\2\2\u0108\u010a\7B\2\2\u0109\u010b\5\u0092"+
		"J\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\7C\2\2\u010d\u010e\5\u00a4S\2\u010e\u010f\5\u008cG\2\u010f\27\3"+
		"\2\2\2\u0110\u0115\5\32\16\2\u0111\u0112\7E\2\2\u0112\u0114\5\32\16\2"+
		"\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\31\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\5\u00c2b\2\u0119"+
		"\u011a\7F\2\2\u011a\u011c\3\2\2\2\u011b\u0118\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\5\34\17\2\u011e\33\3\2\2\2\u011f"+
		"\u0122\5 \21\2\u0120\u0122\5\36\20\2\u0121\u011f\3\2\2\2\u0121\u0120\3"+
		"\2\2\2\u0122\35\3\2\2\2\u0123\u0126\5H%\2\u0124\u0126\5$\23\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0124\3\2\2\2\u0126\37\3\2\2\2\u0127\u0128\5:\36\2\u0128"+
		"\u0129\5\"\22\2\u0129\u012a\5\34\17\2\u012a!\3\2\2\2\u012b\u0137\7R\2"+
		"\2\u012c\u0137\7a\2\2\u012d\u0137\7b\2\2\u012e\u0137\7c\2\2\u012f\u0137"+
		"\7d\2\2\u0130\u0137\7e\2\2\u0131\u0137\7f\2\2\u0132\u0137\7g\2\2\u0133"+
		"\u0137\7h\2\2\u0134\u0137\7j\2\2\u0135\u0137\5\u00a8U\2\u0136\u012b\3"+
		"\2\2\2\u0136\u012c\3\2\2\2\u0136\u012d\3\2\2\2\u0136\u012e\3\2\2\2\u0136"+
		"\u012f\3\2\2\2\u0136\u0130\3\2\2\2\u0136\u0131\3\2\2\2\u0136\u0132\3\2"+
		"\2\2\u0136\u0133\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137"+
		"#\3\2\2\2\u0138\u013d\5&\24\2\u0139\u013a\7[\2\2\u013a\u013c\5&\24\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013e%\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0145\5(\25\2\u0141\u0142"+
		"\7Z\2\2\u0142\u0144\5(\25\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\'\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0148\u014d\5*\26\2\u0149\u014a\7N\2\2\u014a\u014c\5*\26\2\u014b\u0149"+
		"\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		")\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0155\5,\27\2\u0151\u0152\7O\2\2\u0152"+
		"\u0154\5,\27\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156+\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015d"+
		"\5.\30\2\u0159\u015a\7M\2\2\u015a\u015c\5.\30\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e-\3\2\2\2"+
		"\u015f\u015d\3\2\2\2\u0160\u0165\5\60\31\2\u0161\u0162\t\3\2\2\u0162\u0164"+
		"\5\60\31\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2"+
		"\u0165\u0166\3\2\2\2\u0166/\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u016b\5"+
		"\62\32\2\u0169\u016a\7\66\2\2\u016a\u016c\5\f\7\2\u016b\u0169\3\2\2\2"+
		"\u016b\u016c\3\2\2\2\u016c\61\3\2\2\2\u016d\u0172\5\64\33\2\u016e\u016f"+
		"\t\4\2\2\u016f\u0171\5\64\33\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2"+
		"\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\63\3\2\2\2\u0174\u0172"+
		"\3\2\2\2\u0175\u017d\5\66\34\2\u0176\u0179\7i\2\2\u0177\u0179\5\u00a6"+
		"T\2\u0178\u0176\3\2\2\2\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u017c\5\66\34\2\u017b\u0178\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3"+
		"\2\2\2\u017d\u017e\3\2\2\2\u017e\65\3\2\2\2\u017f\u017d\3\2\2\2\u0180"+
		"\u0185\58\35\2\u0181\u0182\t\5\2\2\u0182\u0184\58\35\2\u0183\u0181\3\2"+
		"\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\67\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018d\5:\36\2\u0189\u018a\t\6\2"+
		"\2\u018a\u018c\5:\36\2\u018b\u0189\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018e9\3\2\2\2\u018f\u018d\3\2\2\2\u0190"+
		"\u019e\5<\37\2\u0191\u0192\7H\2\2\u0192\u019e\5:\36\2\u0193\u0194\7I\2"+
		"\2\u0194\u019e\5:\36\2\u0195\u0196\7P\2\2\u0196\u019e\5:\36\2\u0197\u0198"+
		"\7Q\2\2\u0198\u019e\5:\36\2\u0199\u019a\7X\2\2\u019a\u019e\5:\36\2\u019b"+
		"\u019c\7Y\2\2\u019c\u019e\5:\36\2\u019d\u0190\3\2\2\2\u019d\u0191\3\2"+
		"\2\2\u019d\u0193\3\2\2\2\u019d\u0195\3\2\2\2\u019d\u0197\3\2\2\2\u019d"+
		"\u0199\3\2\2\2\u019d\u019b\3\2\2\2\u019e;\3\2\2\2\u019f\u01a3\5@!\2\u01a0"+
		"\u01a2\5F$\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2"+
		"\2\u01a3\u01a4\3\2\2\2\u01a4\u01b4\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01ab"+
		"\5D#\2\u01a7\u01ab\5\u00be`\2\u01a8\u01ab\7X\2\2\u01a9\u01ab\7Y\2\2\u01aa"+
		"\u01a6\3\2\2\2\u01aa\u01a7\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2"+
		"\2\2\u01ab\u01af\3\2\2\2\u01ac\u01ae\5F$\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1"+
		"\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b2\u01aa\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2"+
		"\2\2\u01b4\u01b5\3\2\2\2\u01b5=\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b8"+
		"\5\u00c2b\2\u01b8\u01b9\5D#\2\u01b9\u01ba\5\u00be`\2\u01ba\u01bb\7G\2"+
		"\2\u01bb?\3\2\2\2\u01bc\u01d0\5\u00aaV\2\u01bd\u01bf\5\u00c2b\2\u01be"+
		"\u01c0\5\24\13\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01d0\3"+
		"\2\2\2\u01c1\u01c2\7B\2\2\u01c2\u01c3\5\34\17\2\u01c3\u01c4\7C\2\2\u01c4"+
		"\u01d0\3\2\2\2\u01c5\u01d0\7\'\2\2\u01c6\u01c7\7\32\2\2\u01c7\u01c8\5"+
		"\f\7\2\u01c8\u01c9\5\u00c0a\2\u01c9\u01d0\3\2\2\2\u01ca\u01cc\7@\2\2\u01cb"+
		"\u01cd\5B\"\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2"+
		"\2\2\u01ce\u01d0\7A\2\2\u01cf\u01bc\3\2\2\2\u01cf\u01bd\3\2\2\2\u01cf"+
		"\u01c1\3\2\2\2\u01cf\u01c5\3\2\2\2\u01cf\u01c6\3\2\2\2\u01cf\u01ca\3\2"+
		"\2\2\u01d0A\3\2\2\2\u01d1\u01d6\5\34\17\2\u01d2\u01d3\7E\2\2\u01d3\u01d5"+
		"\5\34\17\2\u01d4\u01d2\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2"+
		"\u01d6\u01d7\3\2\2\2\u01d7C\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\7"+
		"D\2\2\u01da\u01dc\5\u00c2b\2\u01db\u01dd\5\24\13\2\u01dc\u01db\3\2\2\2"+
		"\u01dc\u01dd\3\2\2\2\u01ddE\3\2\2\2\u01de\u01df\7@\2\2\u01df\u01e0\5\34"+
		"\17\2\u01e0\u01e1\7A\2\2\u01e1G\3\2\2\2\u01e2\u01e3\5J&\2\u01e3\u01e4"+
		"\5\u00a4S\2\u01e4\u01e5\5R*\2\u01e5I\3\2\2\2\u01e6\u01e7\7B\2\2\u01e7"+
		"\u01ed\7C\2\2\u01e8\u01e9\7B\2\2\u01e9\u01ea\5L\'\2\u01ea\u01eb\7C\2\2"+
		"\u01eb\u01ed\3\2\2\2\u01ec\u01e6\3\2\2\2\u01ec\u01e8\3\2\2\2\u01edK\3"+
		"\2\2\2\u01ee\u01f3\5N(\2\u01ef\u01f0\7E\2\2\u01f0\u01f2\5N(\2\u01f1\u01ef"+
		"\3\2\2\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"M\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\5\u00c2b\2\u01f7\u01f8\7F\2"+
		"\2\u01f8\u01f9\5\f\7\2\u01f9O\3\2\2\2\u01fa\u01ff\5\u00c2b\2\u01fb\u01fc"+
		"\7E\2\2\u01fc\u01fe\5\u00c2b\2\u01fd\u01fb\3\2\2\2\u01fe\u0201\3\2\2\2"+
		"\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200Q\3\2\2\2\u0201\u01ff\3"+
		"\2\2\2\u0202\u0205\5\34\17\2\u0203\u0205\5Z.\2\u0204\u0202\3\2\2\2\u0204"+
		"\u0203\3\2\2\2\u0205S\3\2\2\2\u0206\u0207\5\\/\2\u0207\u0208\7G\2\2\u0208"+
		"\u020b\3\2\2\2\u0209\u020b\5V,\2\u020a\u0206\3\2\2\2\u020a\u0209\3\2\2"+
		"\2\u020bU\3\2\2\2\u020c\u020f\5Z.\2\u020d\u020f\5X-\2\u020e\u020c\3\2"+
		"\2\2\u020e\u020d\3\2\2\2\u020fW\3\2\2\2\u0210\u0252\7G\2\2\u0211\u0212"+
		"\5\34\17\2\u0212\u0213\7G\2\2\u0213\u0252\3\2\2\2\u0214\u0215\7\30\2\2"+
		"\u0215\u0216\7B\2\2\u0216\u0217\5\34\17\2\u0217\u0218\7C\2\2\u0218\u021b"+
		"\5V,\2\u0219\u021a\7\21\2\2\u021a\u021c\5V,\2\u021b\u0219\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u0252\3\2\2\2\u021d\u021e\7&\2\2\u021e\u021f\7B\2"+
		"\2\u021f\u0220\5\34\17\2\u0220\u0221\7C\2\2\u0221\u0225\7>\2\2\u0222\u0224"+
		"\5b\62\2\u0223\u0222\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225"+
		"\u0226\3\2\2\2\u0226\u0228\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u0229\7?"+
		"\2\2\u0229\u0252\3\2\2\2\u022a\u022b\7-\2\2\u022b\u022c\7B\2\2\u022c\u022d"+
		"\5\34\17\2\u022d\u022e\7C\2\2\u022e\u022f\5V,\2\u022f\u0252\3\2\2\2\u0230"+
		"\u0231\7\25\2\2\u0231\u0233\7B\2\2\u0232\u0234\5h\65\2\u0233\u0232\3\2"+
		"\2\2\u0233\u0234\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237\7G\2\2\u0236"+
		"\u0238\5\34\17\2\u0237\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\3"+
		"\2\2\2\u0239\u023b\7G\2\2\u023a\u023c\5j\66\2\u023b\u023a\3\2\2\2\u023b"+
		"\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\7C\2\2\u023e\u0252\5V,"+
		"\2\u023f\u0240\7\26\2\2\u0240\u0241\7B\2\2\u0241\u0242\5^\60\2\u0242\u0243"+
		"\5\u00c2b\2\u0243\u0244\7\61\2\2\u0244\u0245\5\34\17\2\u0245\u0246\7C"+
		"\2\2\u0246\u0247\5V,\2\u0247\u0252\3\2\2\2\u0248\u0249\7\t\2\2\u0249\u0252"+
		"\7G\2\2\u024a\u024b\7\16\2\2\u024b\u0252\7G\2\2\u024c\u024e\7\"\2\2\u024d"+
		"\u024f\5\34\17\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250\3"+
		"\2\2\2\u0250\u0252\7G\2\2\u0251\u0210\3\2\2\2\u0251\u0211\3\2\2\2\u0251"+
		"\u0214\3\2\2\2\u0251\u021d\3\2\2\2\u0251\u022a\3\2\2\2\u0251\u0230\3\2"+
		"\2\2\u0251\u023f\3\2\2\2\u0251\u0248\3\2\2\2\u0251\u024a\3\2\2\2\u0251"+
		"\u024c\3\2\2\2\u0252Y\3\2\2\2\u0253\u0255\7>\2\2\u0254\u0256\5f\64\2\u0255"+
		"\u0254\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\7?"+
		"\2\2\u0258[\3\2\2\2\u0259\u025a\5^\60\2\u025a\u025f\5`\61\2\u025b\u025c"+
		"\7E\2\2\u025c\u025e\5`\61\2\u025d\u025b\3\2\2\2\u025e\u0261\3\2\2\2\u025f"+
		"\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260]\3\2\2\2\u0261\u025f\3\2\2\2"+
		"\u0262\u0263\t\7\2\2\u0263_\3\2\2\2\u0264\u0267\5\u00c2b\2\u0265\u0266"+
		"\7F\2\2\u0266\u0268\5\f\7\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268"+
		"\u026b\3\2\2\2\u0269\u026a\7R\2\2\u026a\u026c\5\34\17\2\u026b\u0269\3"+
		"\2\2\2\u026b\u026c\3\2\2\2\u026ca\3\2\2\2\u026d\u026f\5d\63\2\u026e\u026d"+
		"\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271"+
		"\u0272\3\2\2\2\u0272\u0273\5f\64\2\u0273c\3\2\2\2\u0274\u0275\7\n\2\2"+
		"\u0275\u0276\5\34\17\2\u0276\u0277\7F\2\2\u0277\u027b\3\2\2\2\u0278\u0279"+
		"\7\17\2\2\u0279\u027b\7F\2\2\u027a\u0274\3\2\2\2\u027a\u0278\3\2\2\2\u027b"+
		"e\3\2\2\2\u027c\u027e\5T+\2\u027d\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280g\3\2\2\2\u0281\u028b\5\\/\2\u0282"+
		"\u0287\5\34\17\2\u0283\u0284\7E\2\2\u0284\u0286\5\34\17\2\u0285\u0283"+
		"\3\2\2\2\u0286\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288"+
		"\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u028a\u0281\3\2\2\2\u028a\u0282\3\2"+
		"\2\2\u028bi\3\2\2\2\u028c\u0291\5\34\17\2\u028d\u028e\7E\2\2\u028e\u0290"+
		"\5\34\17\2\u028f\u028d\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2\2"+
		"\u0291\u0292\3\2\2\2\u0292k\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u0295\7"+
		"\60\2\2\u0295\u0296\5\u00c2b\2\u0296\u0298\5n8\2\u0297\u0299\7G\2\2\u0298"+
		"\u0297\3\2\2\2\u0298\u0299\3\2\2\2\u0299m\3\2\2\2\u029a\u029c\7>\2\2\u029b"+
		"\u029d\5p9\2\u029c\u029b\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\3\2\2"+
		"\2\u029e\u029f\7?\2\2\u029fo\3\2\2\2\u02a0\u02a2\5r:\2\u02a1\u02a0\3\2"+
		"\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4"+
		"q\3\2\2\2\u02a5\u02ad\5l\67\2\u02a6\u02ad\5v<\2\u02a7\u02a8\5\\/\2\u02a8"+
		"\u02a9\7G\2\2\u02a9\u02ad\3\2\2\2\u02aa\u02ad\5> \2\u02ab\u02ad\5t;\2"+
		"\u02ac\u02a5\3\2\2\2\u02ac\u02a6\3\2\2\2\u02ac\u02a7\3\2\2\2\u02ac\u02aa"+
		"\3\2\2\2\u02ac\u02ab\3\2\2\2\u02ads\3\2\2\2\u02ae\u02b0\7\65\2\2\u02af"+
		"\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b2\7\63"+
		"\2\2\u02b2\u02b3\5\u00b6\\\2\u02b3u\3\2\2\2\u02b4\u02b6\5\u0082B\2\u02b5"+
		"\u02b4\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b9\3\2\2\2\u02b7\u02ba\5\u00b0"+
		"Y\2\u02b8\u02ba\5\u00b2Z\2\u02b9\u02b7\3\2\2\2\u02b9\u02b8\3\2\2\2\u02ba"+
		"w\3\2\2\2\u02bb\u02bc\7S\2\2\u02bc\u02c1\5z>\2\u02bd\u02be\7E\2\2\u02be"+
		"\u02c0\5z>\2\u02bf\u02bd\3\2\2\2\u02c0\u02c3\3\2\2\2\u02c1\u02bf\3\2\2"+
		"\2\u02c1\u02c2\3\2\2\2\u02c2\u02c4\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c4\u02c5"+
		"\7T\2\2\u02c5y\3\2\2\2\u02c6\u02c7\5\u00c2b\2\u02c7{\3\2\2\2\u02c8\u02ca"+
		"\7>\2\2\u02c9\u02cb\5~@\2\u02ca\u02c9\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb"+
		"\u02cc\3\2\2\2\u02cc\u02cd\7?\2\2\u02cd}\3\2\2\2\u02ce\u02d0\5\u0080A"+
		"\2\u02cf\u02ce\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d2"+
		"\3\2\2\2\u02d2\177\3\2\2\2\u02d3\u02d5\5\u0082B\2\u02d4\u02d3\3\2\2\2"+
		"\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\5\u0086D\2\u02d7"+
		"\u0081\3\2\2\2\u02d8\u02da\5\u0084C\2\u02d9\u02d8\3\2\2\2\u02da\u02db"+
		"\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u0083\3\2\2\2\u02dd"+
		"\u02de\t\b\2\2\u02de\u0085\3\2\2\2\u02df\u02e2\5\u0088E\2\u02e0\u02e2"+
		"\5\u00b4[\2\u02e1\u02df\3\2\2\2\u02e1\u02e0\3\2\2\2\u02e2\u0087\3\2\2"+
		"\2\u02e3\u02ea\5\u00b6\\\2\u02e4\u02ea\5\u00b8]\2\u02e5\u02ea\5\u00ba"+
		"^\2\u02e6\u02e7\5\u008aF\2\u02e7\u02e8\7G\2\2\u02e8\u02ea\3\2\2\2\u02e9"+
		"\u02e3\3\2\2\2\u02e9\u02e4\3\2\2\2\u02e9\u02e5\3\2\2\2\u02e9\u02e6\3\2"+
		"\2\2\u02ea\u0089\3\2\2\2\u02eb\u02f0\5`\61\2\u02ec\u02ed\7E\2\2\u02ed"+
		"\u02ef\5`\61\2\u02ee\u02ec\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02ee\3\2"+
		"\2\2\u02f0\u02f1\3\2\2\2\u02f1\u008b\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f3"+
		"\u02f8\5\u008eH\2\u02f4\u02f5\7N\2\2\u02f5\u02f7\5\u008eH\2\u02f6\u02f4"+
		"\3\2\2\2\u02f7\u02fa\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9"+
		"\u008d\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fb\u02fe\5\f\7\2\u02fc\u02fe\7,"+
		"\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fc\3\2\2\2\u02fe\u008f\3\2\2\2\u02ff"+
		"\u0300\5Z.\2\u0300\u0091\3\2\2\2\u0301\u0302\5\u0094K\2\u0302\u0093\3"+
		"\2\2\2\u0303\u0308\5\u0096L\2\u0304\u0305\7E\2\2\u0305\u0307\5\u0096L"+
		"\2\u0306\u0304\3\2\2\2\u0307\u030a\3\2\2\2\u0308\u0306\3\2\2\2\u0308\u0309"+
		"\3\2\2\2\u0309\u0095\3\2\2\2\u030a\u0308\3\2\2\2\u030b\u030c\5\u00bc_"+
		"\2\u030c\u0097\3\2\2\2\u030d\u030e\7F\2\2\u030e\u030f\7/\2\2\u030f\u0311"+
		"\7B\2\2\u0310\u0312\5\30\r\2\u0311\u0310\3\2\2\2\u0311\u0312\3\2\2\2\u0312"+
		"\u0313\3\2\2\2\u0313\u0314\7C\2\2\u0314\u0099\3\2\2\2\u0315\u0318\5Z."+
		"\2\u0316\u0318\7G\2\2\u0317\u0315\3\2\2\2\u0317\u0316\3\2\2\2\u0318\u009b"+
		"\3\2\2\2\u0319\u031a\7S\2\2\u031a\u031f\5\u009eP\2\u031b\u031c\7E\2\2"+
		"\u031c\u031e\5\u009eP\2\u031d\u031b\3\2\2\2\u031e\u0321\3\2\2\2\u031f"+
		"\u031d\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0322\3\2\2\2\u0321\u031f\3\2"+
		"\2\2\u0322\u0323\7T\2\2\u0323\u009d\3\2\2\2\u0324\u0325\5\u00c2b\2\u0325"+
		"\u009f\3\2\2\2\u0326\u0332\7>\2\2\u0327\u032c\5\u00a2R\2\u0328\u0329\7"+
		"E\2\2\u0329\u032b\5\u00a2R\2\u032a\u0328\3\2\2\2\u032b\u032e\3\2\2\2\u032c"+
		"\u032a\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u0330\3\2\2\2\u032e\u032c\3\2"+
		"\2\2\u032f\u0331\7E\2\2\u0330\u032f\3\2\2\2\u0330\u0331\3\2\2\2\u0331"+
		"\u0333\3\2\2\2\u0332\u0327\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0334\3\2"+
		"\2\2\u0334\u0335\7?\2\2\u0335\u00a1\3\2\2\2\u0336\u0339\5\u00c2b\2\u0337"+
		"\u0338\7R\2\2\u0338\u033a\5\34\17\2\u0339\u0337\3\2\2\2\u0339\u033a\3"+
		"\2\2\2\u033a\u00a3\3\2\2\2\u033b\u033c\7R\2\2\u033c\u033d\7T\2\2\u033d"+
		"\u033e\6S\2\3\u033e\u00a5\3\2\2\2\u033f\u0340\7T\2\2\u0340\u0341\7T\2"+
		"\2\u0341\u0342\6T\3\3\u0342\u00a7\3\2\2\2\u0343\u0344\7T\2\2\u0344\u0345"+
		"\7`\2\2\u0345\u0346\6U\4\3\u0346\u00a9\3\2\2\2\u0347\u034e\5\u00acW\2"+
		"\u0348\u034e\5\u00aeX\2\u0349\u034e\79\2\2\u034a\u034e\7:\2\2\u034b\u034e"+
		"\7;\2\2\u034c\u034e\7\33\2\2\u034d\u0347\3\2\2\2\u034d\u0348\3\2\2\2\u034d"+
		"\u0349\3\2\2\2\u034d\u034a\3\2\2\2\u034d\u034b\3\2\2\2\u034d\u034c\3\2"+
		"\2\2\u034e\u00ab\3\2\2\2\u034f\u0350\t\t\2\2\u0350\u00ad\3\2\2\2\u0351"+
		"\u0352\t\n\2\2\u0352\u00af\3\2\2\2\u0353\u0354\7\f\2\2\u0354\u0356\5\u00c2"+
		"b\2\u0355\u0357\5x=\2\u0356\u0355\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0358"+
		"\3\2\2\2\u0358\u035a\5|?\2\u0359\u035b\7G\2\2\u035a\u0359\3\2\2\2\u035a"+
		"\u035b\3\2\2\2\u035b\u00b1\3\2\2\2\u035c\u035d\7\22\2\2\u035d\u035e\5"+
		"\u00c2b\2\u035e\u0360\5\u00a0Q\2\u035f\u0361\7G\2\2\u0360\u035f\3\2\2"+
		"\2\u0360\u0361\3\2\2\2\u0361\u00b3\3\2\2\2\u0362\u0363\7\64\2\2\u0363"+
		"\u0365\7B\2\2\u0364\u0366\5\u0092J\2\u0365\u0364\3\2\2\2\u0365\u0366\3"+
		"\2\2\2\u0366\u0367\3\2\2\2\u0367\u0368\7C\2\2\u0368\u0369\5\u009aN\2\u0369"+
		"\u00b5\3\2\2\2\u036a\u036c\5\u00c2b\2\u036b\u036d\5x=\2\u036c\u036b\3"+
		"\2\2\2\u036c\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u0370\7B\2\2\u036f"+
		"\u0371\5\u0092J\2\u0370\u036f\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0372"+
		"\3\2\2\2\u0372\u0373\7C\2\2\u0373\u0374\7F\2\2\u0374\u0375\5\u008cG\2"+
		"\u0375\u0376\3\2\2\2\u0376\u0377\5\u0090I\2\u0377\u00b7\3\2\2\2\u0378"+
		"\u0379\7\27\2\2\u0379\u037a\5\u00c2b\2\u037a\u037b\7B\2\2\u037b\u037e"+
		"\7C\2\2\u037c\u037d\7F\2\2\u037d\u037f\5\u008cG\2\u037e\u037c\3\2\2\2"+
		"\u037e\u037f\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u0381\5\u0090I\2\u0381"+
		"\u00b9\3\2\2\2\u0382\u0383\7#\2\2\u0383\u0384\5\u00c2b\2\u0384\u0385\7"+
		"B\2\2\u0385\u0386\5\u0092J\2\u0386\u0389\7C\2\2\u0387\u0388\7F\2\2\u0388"+
		"\u038a\5\u008cG\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038b"+
		"\3\2\2\2\u038b\u038c\5\u0090I\2\u038c\u00bb\3\2\2\2\u038d\u038e\5\u00c2"+
		"b\2\u038e\u038f\7F\2\2\u038f\u0392\5\n\6\2\u0390\u0391\7R\2\2\u0391\u0393"+
		"\5\34\17\2\u0392\u0390\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u00bd\3\2\2\2"+
		"\u0394\u0396\7B\2\2\u0395\u0397\5\30\r\2\u0396\u0395\3\2\2\2\u0396\u0397"+
		"\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u0399\7C\2\2\u0399\u00bf\3\2\2\2\u039a"+
		"\u039c\7B\2\2\u039b\u039d\5\30\r\2\u039c\u039b\3\2\2\2\u039c\u039d\3\2"+
		"\2\2\u039d\u039e\3\2\2\2\u039e\u039f\7C\2\2\u039f\u00c1\3\2\2\2\u03a0"+
		"\u03a1\t\13\2\2\u03a1\u00c3\3\2\2\2c\u00c7\u00cb\u00d0\u00d4\u00e1\u00e9"+
		"\u00f1\u00f7\u0103\u010a\u0115\u011b\u0121\u0125\u0136\u013d\u0145\u014d"+
		"\u0155\u015d\u0165\u016b\u0172\u0178\u017d\u0185\u018d\u019d\u01a3\u01aa"+
		"\u01af\u01b4\u01bf\u01cc\u01cf\u01d6\u01dc\u01ec\u01f3\u01ff\u0204\u020a"+
		"\u020e\u021b\u0225\u0233\u0237\u023b\u024e\u0251\u0255\u025f\u0267\u026b"+
		"\u0270\u027a\u027f\u0287\u028a\u0291\u0298\u029c\u02a3\u02ac\u02af\u02b5"+
		"\u02b9\u02c1\u02ca\u02d1\u02d4\u02db\u02e1\u02e9\u02f0\u02f8\u02fd\u0308"+
		"\u0311\u0317\u031f\u032c\u0330\u0332\u0339\u034d\u0356\u035a\u0360\u0365"+
		"\u036c\u0370\u037e\u0389\u0392\u0396\u039c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}