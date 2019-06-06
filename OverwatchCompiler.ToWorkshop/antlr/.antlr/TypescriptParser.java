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
		HEX_INTEGER_LITERAL=56, REAL_LITERAL=57, CHARACTER_LITERAL=58, REGULAR_STRING=59, 
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
		RULE_conditionalExpression = 17, RULE_conditionalOrExpression = 18, RULE_conditionalAndExpression = 19, 
		RULE_inclusiveOrExpression = 20, RULE_exclusiveOrExpression = 21, RULE_andExpression = 22, 
		RULE_equalityExpression = 23, RULE_castExpression = 24, RULE_relationalExpression = 25, 
		RULE_shiftExpression = 26, RULE_additiveExpression = 27, RULE_multiplicativeExpression = 28, 
		RULE_unaryExpression = 29, RULE_primaryExpression = 30, RULE_nativeMethodInvocationStatement = 31, 
		RULE_primaryExpressionStart = 32, RULE_expressionList = 33, RULE_memberAccess = 34, 
		RULE_bracketExpression = 35, RULE_lambdaExpression = 36, RULE_anonymousFunctionSignature = 37, 
		RULE_explicitAnonymousFunctionParameterList = 38, RULE_explicitAnonymousFunctionParameter = 39, 
		RULE_implicitAnonymousFunctionParameterList = 40, RULE_anonymousFunctionBody = 41, 
		RULE_statement = 42, RULE_embeddedStatement = 43, RULE_simpleEmbeddedStatement = 44, 
		RULE_block = 45, RULE_variableDeclaration = 46, RULE_variableType = 47, 
		RULE_variableDeclarator = 48, RULE_switchSection = 49, RULE_switchLabel = 50, 
		RULE_statementList = 51, RULE_forInitializer = 52, RULE_forIterator = 53, 
		RULE_catchClauses = 54, RULE_specificCatchClause = 55, RULE_generalCatchClause = 56, 
		RULE_finallyClause = 57, RULE_resourceAcquisition = 58, RULE_moduleDeclaration = 59, 
		RULE_moduleBody = 60, RULE_moduleMemberDeclarations = 61, RULE_moduleMemberDeclaration = 62, 
		RULE_typeDeclaration = 63, RULE_typeParameterList = 64, RULE_typeParameter = 65, 
		RULE_classBody = 66, RULE_classMemberDeclarations = 67, RULE_classMemberDeclaration = 68, 
		RULE_allMemberModifiers = 69, RULE_allMemberModifier = 70, RULE_commonMemberDeclaration = 71, 
		RULE_typedMemberDeclaration = 72, RULE_classField = 73, RULE_returnTypeList = 74, 
		RULE_returnType = 75, RULE_memberName = 76, RULE_methodBody = 77, RULE_formalParameterList = 78, 
		RULE_fixedParameters = 79, RULE_fixedParameter = 80, RULE_constructorInitializer = 81, 
		RULE_body = 82, RULE_variantTypeParameterList = 83, RULE_variantTypeParameter = 84, 
		RULE_enumBody = 85, RULE_enumMemberDeclaration = 86, RULE_rightArrow = 87, 
		RULE_rightShift = 88, RULE_rightShiftAssignment = 89, RULE_literal = 90, 
		RULE_booleanLiteral = 91, RULE_stringLiteral = 92, RULE_classDefinition = 93, 
		RULE_enumDefinition = 94, RULE_constructorDeclaration = 95, RULE_methodDeclaration = 96, 
		RULE_getterSetterDeclaration = 97, RULE_argDeclaration = 98, RULE_methodInvocation = 99, 
		RULE_objectCreationExpression = 100, RULE_identifier = 101;
	public static final String[] ruleNames = {
		"sourceFiles", "sourceFile", "importDeclaration", "moduleOrTypeName", 
		"typeList", "type", "baseType", "primitiveType", "classType", "typeArgumentList", 
		"functionType", "argumentList", "argument", "expression", "nonAssignmentExpression", 
		"assignment", "assignmentOperator", "conditionalExpression", "conditionalOrExpression", 
		"conditionalAndExpression", "inclusiveOrExpression", "exclusiveOrExpression", 
		"andExpression", "equalityExpression", "castExpression", "relationalExpression", 
		"shiftExpression", "additiveExpression", "multiplicativeExpression", "unaryExpression", 
		"primaryExpression", "nativeMethodInvocationStatement", "primaryExpressionStart", 
		"expressionList", "memberAccess", "bracketExpression", "lambdaExpression", 
		"anonymousFunctionSignature", "explicitAnonymousFunctionParameterList", 
		"explicitAnonymousFunctionParameter", "implicitAnonymousFunctionParameterList", 
		"anonymousFunctionBody", "statement", "embeddedStatement", "simpleEmbeddedStatement", 
		"block", "variableDeclaration", "variableType", "variableDeclarator", 
		"switchSection", "switchLabel", "statementList", "forInitializer", "forIterator", 
		"catchClauses", "specificCatchClause", "generalCatchClause", "finallyClause", 
		"resourceAcquisition", "moduleDeclaration", "moduleBody", "moduleMemberDeclarations", 
		"moduleMemberDeclaration", "typeDeclaration", "typeParameterList", "typeParameter", 
		"classBody", "classMemberDeclarations", "classMemberDeclaration", "allMemberModifiers", 
		"allMemberModifier", "commonMemberDeclaration", "typedMemberDeclaration", 
		"classField", "returnTypeList", "returnType", "memberName", "methodBody", 
		"formalParameterList", "fixedParameters", "fixedParameter", "constructorInitializer", 
		"body", "variantTypeParameterList", "variantTypeParameter", "enumBody", 
		"enumMemberDeclaration", "rightArrow", "rightShift", "rightShiftAssignment", 
		"literal", "booleanLiteral", "stringLiteral", "classDefinition", "enumDefinition", 
		"constructorDeclaration", "methodDeclaration", "getterSetterDeclaration", 
		"argDeclaration", "methodInvocation", "objectCreationExpression", "identifier"
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
		"CHARACTER_LITERAL", "REGULAR_STRING", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", 
		"CLOSE_BRACKET", "OPEN_PARENS", "CLOSE_PARENS", "DOT", "COMMA", "COLON", 
		"SEMICOLON", "PLUS", "MINUS", "STAR", "DIV", "PERCENT", "AMP", "BITWISE_OR", 
		"CARET", "BANG", "TILDE", "ASSIGNMENT", "LT", "GT", "INTERR", "DOUBLE_COLON", 
		"OP_COALESCING", "OP_INC", "OP_DEC", "OP_AND", "OP_OR", "OP_PTR", "OP_EQ", 
		"OP_NE", "OP_LE", "OP_GE", "OP_ADD_ASSIGNMENT", "OP_SUB_ASSIGNMENT", "OP_MULT_ASSIGNMENT", 
		"OP_DIV_ASSIGNMENT", "OP_MOD_ASSIGNMENT", "OP_AND_ASSIGNMENT", "OP_OR_ASSIGNMENT", 
		"OP_XOR_ASSIGNMENT", "OP_LEFT_SHIFT", "OP_LEFT_SHIFT_ASSIGNMENT", "DIRECTIVE_WHITESPACES", 
		"DIGITS", "DEFINE", "UNDEF", "ELIF", "ENDIF", "LINE", "ERROR", "WARNING", 
		"REGION", "ENDREGION", "PRAGMA", "DIRECTIVE_HIDDEN", "CONDITIONAL_SYMBOL", 
		"DIRECTIVE_NEW_LINE", "TEXT"
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
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					sourceFile();
					}
					} 
				}
				setState(209);
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
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BYTE_ORDER_MARK) {
				{
				setState(210);
				match(BYTE_ORDER_MARK);
				}
			}

			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(213);
				importDeclaration();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(219);
				moduleMemberDeclarations();
				}
			}

			setState(222);
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
			setState(224);
			match(IMPORT);
			setState(225);
			stringLiteral();
			setState(226);
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
		public List<TypeArgumentListContext> typeArgumentList() {
			return getRuleContexts(TypeArgumentListContext.class);
		}
		public TypeArgumentListContext typeArgumentList(int i) {
			return getRuleContext(TypeArgumentListContext.class,i);
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
			setState(228);
			identifier();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(229);
				typeArgumentList();
				}
			}

			}
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(232);
				match(DOT);
				setState(233);
				identifier();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(234);
					typeArgumentList();
					}
				}

				}
				}
				setState(241);
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
			setState(242);
			type();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_OR) {
				{
				{
				setState(243);
				match(BITWISE_OR);
				setState(244);
				type();
				}
				}
				setState(249);
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
			setState(250);
			baseType();
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					match(OPEN_BRACKET);
					setState(252);
					match(CLOSE_BRACKET);
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				classType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
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
			setState(263);
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
			setState(265);
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
			setState(267);
			match(LT);
			setState(268);
			typeList();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(269);
				match(COMMA);
				setState(270);
				typeList();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
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
			setState(278);
			match(OPEN_PARENS);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(279);
				formalParameterList();
				}
			}

			setState(282);
			match(CLOSE_PARENS);
			setState(283);
			rightArrow();
			setState(284);
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
			setState(286);
			argument();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(287);
				match(COMMA);
				setState(288);
				argument();
				}
				}
				setState(293);
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
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(294);
				identifier();
				setState(295);
				match(COLON);
				}
				break;
			}
			setState(299);
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
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
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
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
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
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				conditionalExpression();
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
			setState(309);
			unaryExpression();
			setState(310);
			assignmentOperator();
			setState(311);
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
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGNMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(ASSIGNMENT);
				}
				break;
			case OP_ADD_ASSIGNMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(OP_ADD_ASSIGNMENT);
				}
				break;
			case OP_SUB_ASSIGNMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				match(OP_SUB_ASSIGNMENT);
				}
				break;
			case OP_MULT_ASSIGNMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
				match(OP_MULT_ASSIGNMENT);
				}
				break;
			case OP_DIV_ASSIGNMENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				match(OP_DIV_ASSIGNMENT);
				}
				break;
			case OP_MOD_ASSIGNMENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(318);
				match(OP_MOD_ASSIGNMENT);
				}
				break;
			case OP_AND_ASSIGNMENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(319);
				match(OP_AND_ASSIGNMENT);
				}
				break;
			case OP_OR_ASSIGNMENT:
				enterOuterAlt(_localctx, 8);
				{
				setState(320);
				match(OP_OR_ASSIGNMENT);
				}
				break;
			case OP_XOR_ASSIGNMENT:
				enterOuterAlt(_localctx, 9);
				{
				setState(321);
				match(OP_XOR_ASSIGNMENT);
				}
				break;
			case OP_LEFT_SHIFT_ASSIGNMENT:
				enterOuterAlt(_localctx, 10);
				{
				setState(322);
				match(OP_LEFT_SHIFT_ASSIGNMENT);
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 11);
				{
				setState(323);
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

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conditionalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			conditionalOrExpression();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTERR) {
				{
				setState(327);
				match(INTERR);
				setState(328);
				expression();
				setState(329);
				match(COLON);
				setState(330);
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
			setState(334);
			conditionalAndExpression();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_OR) {
				{
				{
				setState(335);
				match(OP_OR);
				setState(336);
				conditionalAndExpression();
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
		enterRule(_localctx, 38, RULE_conditionalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			inclusiveOrExpression();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_AND) {
				{
				{
				setState(343);
				match(OP_AND);
				setState(344);
				inclusiveOrExpression();
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
		enterRule(_localctx, 40, RULE_inclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			exclusiveOrExpression();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_OR) {
				{
				{
				setState(351);
				match(BITWISE_OR);
				setState(352);
				exclusiveOrExpression();
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
		enterRule(_localctx, 42, RULE_exclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			andExpression();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CARET) {
				{
				{
				setState(359);
				match(CARET);
				setState(360);
				andExpression();
				}
				}
				setState(365);
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
		enterRule(_localctx, 44, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			equalityExpression();
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMP) {
				{
				{
				setState(367);
				match(AMP);
				setState(368);
				equalityExpression();
				}
				}
				setState(373);
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
		enterRule(_localctx, 46, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			castExpression();
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_EQ || _la==OP_NE) {
				{
				{
				setState(375);
				_la = _input.LA(1);
				if ( !(_la==OP_EQ || _la==OP_NE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(376);
				castExpression();
				}
				}
				setState(381);
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
		enterRule(_localctx, 48, RULE_castExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			relationalExpression();
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(383);
				match(AS);
				setState(384);
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
		enterRule(_localctx, 50, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			shiftExpression();
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) {
				{
				{
				setState(388);
				_la = _input.LA(1);
				if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(389);
				shiftExpression();
				}
				}
				setState(394);
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
		enterRule(_localctx, 52, RULE_shiftExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			additiveExpression();
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(398);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OP_LEFT_SHIFT:
						{
						setState(396);
						match(OP_LEFT_SHIFT);
						}
						break;
					case GT:
						{
						setState(397);
						rightShift();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(400);
					additiveExpression();
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		enterRule(_localctx, 54, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			multiplicativeExpression();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(407);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(408);
				multiplicativeExpression();
				}
				}
				setState(413);
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
		enterRule(_localctx, 56, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			unaryExpression();
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) {
				{
				{
				setState(415);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(416);
				unaryExpression();
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
		enterRule(_localctx, 58, RULE_unaryExpression);
		try {
			setState(431);
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
			case LITERAL_ACCESS:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case CHARACTER_LITERAL:
			case REGULAR_STRING:
			case OPEN_BRACKET:
			case OPEN_PARENS:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				primaryExpression();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(PLUS);
				setState(424);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				match(MINUS);
				setState(426);
				unaryExpression();
				}
				break;
			case BANG:
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				match(BANG);
				setState(428);
				unaryExpression();
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 5);
				{
				setState(429);
				match(TILDE);
				setState(430);
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
		enterRule(_localctx, 60, RULE_primaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			((PrimaryExpressionContext)_localctx).pe = primaryExpressionStart();
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACKET) {
				{
				{
				setState(434);
				bracketExpression();
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (DOT - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				{
				setState(444);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(440);
					memberAccess();
					}
					break;
				case OPEN_PARENS:
					{
					setState(441);
					methodInvocation();
					}
					break;
				case OP_INC:
					{
					setState(442);
					match(OP_INC);
					}
					break;
				case OP_DEC:
					{
					setState(443);
					match(OP_DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPEN_BRACKET) {
					{
					{
					setState(446);
					bracketExpression();
					}
					}
					setState(451);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(456);
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
		enterRule(_localctx, 62, RULE_nativeMethodInvocationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			((NativeMethodInvocationStatementContext)_localctx).pe = identifier();
			setState(458);
			memberAccess();
			setState(459);
			methodInvocation();
			setState(460);
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
	public static class LiteralAccessExpressionContext extends PrimaryExpressionStartContext {
		public TerminalNode LITERAL_ACCESS() { return getToken(TypescriptParser.LITERAL_ACCESS, 0); }
		public LiteralAccessExpressionContext(PrimaryExpressionStartContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 64, RULE_primaryExpressionStart);
		int _la;
		try {
			setState(482);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case NULL:
			case TRUE:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case CHARACTER_LITERAL:
			case REGULAR_STRING:
				_localctx = new LiteralExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
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
				setState(463);
				identifier();
				setState(465);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(464);
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
				setState(467);
				match(OPEN_PARENS);
				setState(468);
				expression();
				setState(469);
				match(CLOSE_PARENS);
				}
				break;
			case LITERAL_ACCESS:
				_localctx = new LiteralAccessExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(471);
				match(LITERAL_ACCESS);
				}
				break;
			case THIS:
				_localctx = new ThisReferenceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(472);
				match(THIS);
				}
				break;
			case NEW:
				_localctx = new ObjectCreationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(473);
				match(NEW);
				setState(474);
				type();
				setState(475);
				objectCreationExpression();
				}
				break;
			case OPEN_BRACKET:
				_localctx = new ArrayCreationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(477);
				match(OPEN_BRACKET);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
					{
					setState(478);
					expressionList();
					}
				}

				setState(481);
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
		enterRule(_localctx, 66, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			expression();
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(485);
				match(COMMA);
				setState(486);
				expression();
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
		enterRule(_localctx, 68, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			match(DOT);
			setState(493);
			identifier();
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(494);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public BracketExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketExpression; }
	}

	public final BracketExpressionContext bracketExpression() throws RecognitionException {
		BracketExpressionContext _localctx = new BracketExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_bracketExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(OPEN_BRACKET);
			setState(498);
			expressionList();
			setState(499);
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
		enterRule(_localctx, 72, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			anonymousFunctionSignature();
			setState(502);
			rightArrow();
			setState(503);
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
		public ImplicitAnonymousFunctionParameterListContext implicitAnonymousFunctionParameterList() {
			return getRuleContext(ImplicitAnonymousFunctionParameterListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AnonymousFunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunctionSignature; }
	}

	public final AnonymousFunctionSignatureContext anonymousFunctionSignature() throws RecognitionException {
		AnonymousFunctionSignatureContext _localctx = new AnonymousFunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_anonymousFunctionSignature);
		try {
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(505);
				match(OPEN_PARENS);
				setState(506);
				match(CLOSE_PARENS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				match(OPEN_PARENS);
				setState(508);
				explicitAnonymousFunctionParameterList();
				setState(509);
				match(CLOSE_PARENS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(511);
				match(OPEN_PARENS);
				setState(512);
				implicitAnonymousFunctionParameterList();
				setState(513);
				match(CLOSE_PARENS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(515);
				identifier();
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
		enterRule(_localctx, 76, RULE_explicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			explicitAnonymousFunctionParameter();
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(519);
				match(COMMA);
				setState(520);
				explicitAnonymousFunctionParameter();
				}
				}
				setState(525);
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
		enterRule(_localctx, 78, RULE_explicitAnonymousFunctionParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			identifier();
			setState(527);
			match(COLON);
			setState(528);
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
		enterRule(_localctx, 80, RULE_implicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			identifier();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(531);
				match(COMMA);
				setState(532);
				identifier();
				}
				}
				setState(537);
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
		enterRule(_localctx, 82, RULE_anonymousFunctionBody);
		try {
			setState(540);
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
			case LITERAL_ACCESS:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case CHARACTER_LITERAL:
			case REGULAR_STRING:
			case OPEN_BRACKET:
			case OPEN_PARENS:
			case PLUS:
			case MINUS:
			case BANG:
			case TILDE:
				enterOuterAlt(_localctx, 1);
				{
				setState(538);
				expression();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
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
		enterRule(_localctx, 84, RULE_statement);
		try {
			setState(546);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new DeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(542);
				variableDeclaration();
				setState(543);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new EmbeddedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
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
		enterRule(_localctx, 86, RULE_embeddedStatement);
		try {
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
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
			case LITERAL_ACCESS:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case CHARACTER_LITERAL:
			case REGULAR_STRING:
			case OPEN_BRACKET:
			case OPEN_PARENS:
			case SEMICOLON:
			case PLUS:
			case MINUS:
			case BANG:
			case TILDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
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
		enterRule(_localctx, 88, RULE_simpleEmbeddedStatement);
		int _la;
		try {
			setState(617);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
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
			case LITERAL_ACCESS:
			case INTEGER_LITERAL:
			case HEX_INTEGER_LITERAL:
			case REAL_LITERAL:
			case CHARACTER_LITERAL:
			case REGULAR_STRING:
			case OPEN_BRACKET:
			case OPEN_PARENS:
			case PLUS:
			case MINUS:
			case BANG:
			case TILDE:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				expression();
				setState(554);
				match(SEMICOLON);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(556);
				match(IF);
				setState(557);
				match(OPEN_PARENS);
				setState(558);
				expression();
				setState(559);
				match(CLOSE_PARENS);
				setState(560);
				embeddedStatement();
				setState(563);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(561);
					match(ELSE);
					setState(562);
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
				setState(565);
				match(SWITCH);
				setState(566);
				match(OPEN_PARENS);
				setState(567);
				expression();
				setState(568);
				match(CLOSE_PARENS);
				setState(569);
				match(OPEN_BRACE);
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(570);
					switchSection();
					}
					}
					setState(575);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(576);
				match(CLOSE_BRACE);
				}
				break;
			case WHILE:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(578);
				match(WHILE);
				setState(579);
				match(OPEN_PARENS);
				setState(580);
				expression();
				setState(581);
				match(CLOSE_PARENS);
				setState(582);
				embeddedStatement();
				}
				break;
			case FOR:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(584);
				match(FOR);
				setState(585);
				match(OPEN_PARENS);
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << LITERAL_ACCESS) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << CHARACTER_LITERAL) | (1L << REGULAR_STRING) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)))) != 0)) {
					{
					setState(586);
					forInitializer();
					}
				}

				setState(589);
				match(SEMICOLON);
				setState(591);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
					{
					setState(590);
					expression();
					}
				}

				setState(593);
				match(SEMICOLON);
				setState(595);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
					{
					setState(594);
					forIterator();
					}
				}

				setState(597);
				match(CLOSE_PARENS);
				setState(598);
				embeddedStatement();
				}
				break;
			case FOREACH:
				_localctx = new ForeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(599);
				match(FOREACH);
				setState(600);
				match(OPEN_PARENS);
				setState(601);
				variableType();
				setState(602);
				identifier();
				setState(603);
				match(OF);
				setState(604);
				expression();
				setState(605);
				match(CLOSE_PARENS);
				setState(606);
				embeddedStatement();
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(608);
				match(BREAK);
				setState(609);
				match(SEMICOLON);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(610);
				match(CONTINUE);
				setState(611);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(612);
				match(RETURN);
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
					{
					setState(613);
					expression();
					}
				}

				setState(616);
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
		enterRule(_localctx, 90, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(OPEN_BRACE);
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << FOREACH) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << LITERAL_ACCESS) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << CHARACTER_LITERAL) | (1L << REGULAR_STRING) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)))) != 0)) {
				{
				setState(620);
				statementList();
				}
			}

			setState(623);
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
		enterRule(_localctx, 92, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			variableType();
			setState(626);
			variableDeclarator();
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(627);
				match(COMMA);
				setState(628);
				variableDeclarator();
				}
				}
				setState(633);
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
		enterRule(_localctx, 94, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
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
		enterRule(_localctx, 96, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			identifier();
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(637);
				match(COLON);
				setState(638);
				type();
				}
			}

			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(641);
				match(ASSIGNMENT);
				setState(642);
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
		enterRule(_localctx, 98, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(645);
				switchLabel();
				}
				}
				setState(648); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(650);
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
		enterRule(_localctx, 100, RULE_switchLabel);
		try {
			setState(658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(652);
				match(CASE);
				setState(653);
				expression();
				setState(654);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				match(DEFAULT);
				setState(657);
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
		enterRule(_localctx, 102, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(660);
				statement();
				}
				}
				setState(663); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << FOREACH) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << LITERAL_ACCESS) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << CHARACTER_LITERAL) | (1L << REGULAR_STRING) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)))) != 0) );
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
		enterRule(_localctx, 104, RULE_forInitializer);
		int _la;
		try {
			setState(674);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(665);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(666);
				expression();
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(667);
					match(COMMA);
					setState(668);
					expression();
					}
					}
					setState(673);
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
		enterRule(_localctx, 106, RULE_forIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			expression();
			setState(681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(677);
				match(COMMA);
				setState(678);
				expression();
				}
				}
				setState(683);
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

	public static class CatchClausesContext extends ParserRuleContext {
		public List<SpecificCatchClauseContext> specificCatchClause() {
			return getRuleContexts(SpecificCatchClauseContext.class);
		}
		public SpecificCatchClauseContext specificCatchClause(int i) {
			return getRuleContext(SpecificCatchClauseContext.class,i);
		}
		public GeneralCatchClauseContext generalCatchClause() {
			return getRuleContext(GeneralCatchClauseContext.class,0);
		}
		public CatchClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClauses; }
	}

	public final CatchClausesContext catchClauses() throws RecognitionException {
		CatchClausesContext _localctx = new CatchClausesContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_catchClauses);
		int _la;
		try {
			int _alt;
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(684);
				specificCatchClause();
				setState(688);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(685);
						specificCatchClause();
						}
						} 
					}
					setState(690);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				}
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(691);
					generalCatchClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				generalCatchClause();
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

	public static class SpecificCatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(TypescriptParser.CATCH, 0); }
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SpecificCatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificCatchClause; }
	}

	public final SpecificCatchClauseContext specificCatchClause() throws RecognitionException {
		SpecificCatchClauseContext _localctx = new SpecificCatchClauseContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_specificCatchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(CATCH);
			setState(698);
			match(OPEN_PARENS);
			setState(699);
			classType();
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(700);
				identifier();
				}
			}

			setState(703);
			match(CLOSE_PARENS);
			setState(704);
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

	public static class GeneralCatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(TypescriptParser.CATCH, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public GeneralCatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalCatchClause; }
	}

	public final GeneralCatchClauseContext generalCatchClause() throws RecognitionException {
		GeneralCatchClauseContext _localctx = new GeneralCatchClauseContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_generalCatchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(CATCH);
			setState(707);
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

	public static class FinallyClauseContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(TypescriptParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyClause; }
	}

	public final FinallyClauseContext finallyClause() throws RecognitionException {
		FinallyClauseContext _localctx = new FinallyClauseContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_finallyClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			match(FINALLY);
			setState(710);
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

	public static class ResourceAcquisitionContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ResourceAcquisitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceAcquisition; }
	}

	public final ResourceAcquisitionContext resourceAcquisition() throws RecognitionException {
		ResourceAcquisitionContext _localctx = new ResourceAcquisitionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_resourceAcquisition);
		try {
			setState(714);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(712);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(713);
				expression();
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
		enterRule(_localctx, 118, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
			match(MODULE);
			setState(717);
			identifier();
			setState(718);
			moduleBody();
			setState(720);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(719);
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
		enterRule(_localctx, 120, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			match(OPEN_BRACE);
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(723);
				moduleMemberDeclarations();
				}
			}

			setState(726);
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
		enterRule(_localctx, 122, RULE_moduleMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(728);
				moduleMemberDeclaration();
				}
				}
				setState(731); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0) );
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
		public ModuleMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleMemberDeclaration; }
	}

	public final ModuleMemberDeclarationContext moduleMemberDeclaration() throws RecognitionException {
		ModuleMemberDeclarationContext _localctx = new ModuleMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_moduleMemberDeclaration);
		try {
			setState(739);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				moduleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
				typeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(735);
				variableDeclaration();
				setState(736);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(738);
				nativeMethodInvocationStatement();
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
		enterRule(_localctx, 126, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(741);
				allMemberModifiers();
				}
			}

			setState(746);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(744);
				classDefinition();
				}
				break;
			case ENUM:
				{
				setState(745);
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
		enterRule(_localctx, 128, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			match(LT);
			setState(749);
			typeParameter();
			setState(754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(750);
				match(COMMA);
				setState(751);
				typeParameter();
				}
				}
				setState(756);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(757);
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
		enterRule(_localctx, 130, RULE_typeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
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
		enterRule(_localctx, 132, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			match(OPEN_BRACE);
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << CONSTRUCTOR) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(762);
				classMemberDeclarations();
				}
			}

			setState(765);
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
		enterRule(_localctx, 134, RULE_classMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(767);
				classMemberDeclaration();
				}
				}
				setState(770); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << CONSTRUCTOR) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0) );
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
		enterRule(_localctx, 136, RULE_classMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(772);
				allMemberModifiers();
				}
			}

			setState(775);
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
		enterRule(_localctx, 138, RULE_allMemberModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(777);
				allMemberModifier();
				}
				}
				setState(780); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0) );
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
		public TerminalNode PROTECTED() { return getToken(TypescriptParser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(TypescriptParser.PRIVATE, 0); }
		public TerminalNode READONLY() { return getToken(TypescriptParser.READONLY, 0); }
		public TerminalNode ABSTRACT() { return getToken(TypescriptParser.ABSTRACT, 0); }
		public TerminalNode STATIC() { return getToken(TypescriptParser.STATIC, 0); }
		public TerminalNode EXPORT() { return getToken(TypescriptParser.EXPORT, 0); }
		public AllMemberModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allMemberModifier; }
	}

	public final AllMemberModifierContext allMemberModifier() throws RecognitionException {
		AllMemberModifierContext _localctx = new AllMemberModifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_allMemberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) ) {
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
		enterRule(_localctx, 142, RULE_commonMemberDeclaration);
		try {
			setState(786);
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
				setState(784);
				typedMemberDeclaration();
				}
				break;
			case CONSTRUCTOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(785);
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
		public GetterSetterDeclarationContext getterSetterDeclaration() {
			return getRuleContext(GetterSetterDeclarationContext.class,0);
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
		enterRule(_localctx, 144, RULE_typedMemberDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(788);
				methodDeclaration();
				}
				break;
			case 2:
				{
				setState(789);
				getterSetterDeclaration();
				}
				break;
			case 3:
				{
				setState(790);
				classField();
				setState(791);
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
		enterRule(_localctx, 146, RULE_classField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			variableDeclarator();
			setState(800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(796);
				match(COMMA);
				setState(797);
				variableDeclarator();
				}
				}
				setState(802);
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
		enterRule(_localctx, 148, RULE_returnTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			returnType();
			setState(808);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(804);
					match(BITWISE_OR);
					setState(805);
					returnType();
					}
					} 
				}
				setState(810);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
		enterRule(_localctx, 150, RULE_returnType);
		try {
			setState(813);
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
				setState(811);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(812);
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

	public static class MemberNameContext extends ParserRuleContext {
		public ModuleOrTypeNameContext moduleOrTypeName() {
			return getRuleContext(ModuleOrTypeNameContext.class,0);
		}
		public MemberNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberName; }
	}

	public final MemberNameContext memberName() throws RecognitionException {
		MemberNameContext _localctx = new MemberNameContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_memberName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
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
		enterRule(_localctx, 154, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
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
		enterRule(_localctx, 156, RULE_formalParameterList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
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
		enterRule(_localctx, 158, RULE_fixedParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			fixedParameter();
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(822);
				match(COMMA);
				setState(823);
				fixedParameter();
				}
				}
				setState(828);
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
		enterRule(_localctx, 160, RULE_fixedParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
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
		enterRule(_localctx, 162, RULE_constructorInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			match(COLON);
			setState(832);
			match(SUPER);
			setState(833);
			match(OPEN_PARENS);
			setState(835);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
				{
				setState(834);
				argumentList();
				}
			}

			setState(837);
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
		enterRule(_localctx, 164, RULE_body);
		try {
			setState(841);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(839);
				block();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(840);
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
		enterRule(_localctx, 166, RULE_variantTypeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			match(LT);
			setState(844);
			variantTypeParameter();
			setState(849);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(845);
				match(COMMA);
				setState(846);
				variantTypeParameter();
				}
				}
				setState(851);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(852);
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
		enterRule(_localctx, 168, RULE_variantTypeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
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
		enterRule(_localctx, 170, RULE_enumBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			match(OPEN_BRACE);
			setState(868);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(857);
				enumMemberDeclaration();
				setState(862);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(858);
						match(COMMA);
						setState(859);
						enumMemberDeclaration();
						}
						} 
					}
					setState(864);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
				}
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(865);
					match(COMMA);
					}
				}

				}
			}

			setState(870);
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
		enterRule(_localctx, 172, RULE_enumMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			identifier();
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(873);
				match(ASSIGNMENT);
				setState(874);
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
		enterRule(_localctx, 174, RULE_rightArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			((RightArrowContext)_localctx).first = match(ASSIGNMENT);
			setState(878);
			((RightArrowContext)_localctx).second = match(GT);
			setState(879);
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
		enterRule(_localctx, 176, RULE_rightShift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			((RightShiftContext)_localctx).first = match(GT);
			setState(882);
			((RightShiftContext)_localctx).second = match(GT);
			setState(883);
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
		enterRule(_localctx, 178, RULE_rightShiftAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			((RightShiftAssignmentContext)_localctx).first = match(GT);
			setState(886);
			((RightShiftAssignmentContext)_localctx).second = match(OP_GE);
			setState(887);
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
		public TerminalNode CHARACTER_LITERAL() { return getToken(TypescriptParser.CHARACTER_LITERAL, 0); }
		public TerminalNode NULL() { return getToken(TypescriptParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_literal);
		try {
			setState(896);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				booleanLiteral();
				}
				break;
			case REGULAR_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				stringLiteral();
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(891);
				match(INTEGER_LITERAL);
				}
				break;
			case HEX_INTEGER_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(892);
				match(HEX_INTEGER_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(893);
				match(REAL_LITERAL);
				}
				break;
			case CHARACTER_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(894);
				match(CHARACTER_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(895);
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
		enterRule(_localctx, 182, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
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
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			match(REGULAR_STRING);
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
		enterRule(_localctx, 186, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
			match(CLASS);
			setState(903);
			identifier();
			setState(905);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(904);
				typeParameterList();
				}
			}

			setState(907);
			classBody();
			setState(909);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(908);
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
		enterRule(_localctx, 188, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			match(ENUM);
			setState(912);
			identifier();
			setState(913);
			enumBody();
			setState(915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(914);
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
		enterRule(_localctx, 190, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			match(CONSTRUCTOR);
			setState(918);
			match(OPEN_PARENS);
			setState(920);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(919);
				formalParameterList();
				}
			}

			setState(922);
			match(CLOSE_PARENS);
			setState(923);
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
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			identifier();
			setState(927);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(926);
				typeParameterList();
				}
			}

			setState(929);
			match(OPEN_PARENS);
			setState(931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(930);
				formalParameterList();
				}
			}

			setState(933);
			match(CLOSE_PARENS);
			setState(936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(934);
				match(COLON);
				setState(935);
				returnTypeList();
				}
			}

			setState(938);
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

	public static class GetterSetterDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OPEN_PARENS() { return getToken(TypescriptParser.OPEN_PARENS, 0); }
		public TerminalNode CLOSE_PARENS() { return getToken(TypescriptParser.CLOSE_PARENS, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode GET() { return getToken(TypescriptParser.GET, 0); }
		public TerminalNode SET() { return getToken(TypescriptParser.SET, 0); }
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public GetterSetterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getterSetterDeclaration; }
	}

	public final GetterSetterDeclarationContext getterSetterDeclaration() throws RecognitionException {
		GetterSetterDeclarationContext _localctx = new GetterSetterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_getterSetterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(940);
			_la = _input.LA(1);
			if ( !(_la==GET || _la==SET) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(941);
			identifier();
			setState(942);
			match(OPEN_PARENS);
			setState(943);
			match(CLOSE_PARENS);
			setState(946);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(944);
				match(COLON);
				setState(945);
				returnTypeList();
				}
			}

			setState(948);
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
		enterRule(_localctx, 196, RULE_argDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(950);
			identifier();
			setState(951);
			match(COLON);
			setState(952);
			typeList();
			setState(955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(953);
				match(ASSIGNMENT);
				setState(954);
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
		enterRule(_localctx, 198, RULE_methodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			match(OPEN_PARENS);
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
				{
				setState(958);
				argumentList();
				}
			}

			setState(961);
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
		enterRule(_localctx, 200, RULE_objectCreationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(963);
			match(OPEN_PARENS);
			setState(965);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (LITERAL_ACCESS - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (CHARACTER_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)) | (1L << (TILDE - 17)))) != 0)) {
				{
				setState(964);
				argumentList();
				}
			}

			setState(967);
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
		enterRule(_localctx, 202, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
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
		case 87:
			return rightArrow_sempred((RightArrowContext)_localctx, predIndex);
		case 88:
			return rightShift_sempred((RightShiftContext)_localctx, predIndex);
		case 89:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3z\u03ce\4\2\t\2\4"+
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
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\3\2\7\2\u00d0\n\2\f\2\16"+
		"\2\u00d3\13\2\3\3\5\3\u00d6\n\3\3\3\7\3\u00d9\n\3\f\3\16\3\u00dc\13\3"+
		"\3\3\5\3\u00df\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\5\5\u00e9\n\5\3\5\3"+
		"\5\3\5\5\5\u00ee\n\5\7\5\u00f0\n\5\f\5\16\5\u00f3\13\5\3\6\3\6\3\6\7\6"+
		"\u00f8\n\6\f\6\16\6\u00fb\13\6\3\7\3\7\3\7\7\7\u0100\n\7\f\7\16\7\u0103"+
		"\13\7\3\b\3\b\3\b\5\b\u0108\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\7"+
		"\13\u0112\n\13\f\13\16\13\u0115\13\13\3\13\3\13\3\f\3\f\5\f\u011b\n\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u0124\n\r\f\r\16\r\u0127\13\r\3\16\3"+
		"\16\3\16\5\16\u012c\n\16\3\16\3\16\3\17\3\17\5\17\u0132\n\17\3\20\3\20"+
		"\5\20\u0136\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0147\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u014f\n\23\3\24\3\24\3\24\7\24\u0154\n\24\f\24\16\24\u0157\13\24\3\25"+
		"\3\25\3\25\7\25\u015c\n\25\f\25\16\25\u015f\13\25\3\26\3\26\3\26\7\26"+
		"\u0164\n\26\f\26\16\26\u0167\13\26\3\27\3\27\3\27\7\27\u016c\n\27\f\27"+
		"\16\27\u016f\13\27\3\30\3\30\3\30\7\30\u0174\n\30\f\30\16\30\u0177\13"+
		"\30\3\31\3\31\3\31\7\31\u017c\n\31\f\31\16\31\u017f\13\31\3\32\3\32\3"+
		"\32\5\32\u0184\n\32\3\33\3\33\3\33\7\33\u0189\n\33\f\33\16\33\u018c\13"+
		"\33\3\34\3\34\3\34\5\34\u0191\n\34\3\34\7\34\u0194\n\34\f\34\16\34\u0197"+
		"\13\34\3\35\3\35\3\35\7\35\u019c\n\35\f\35\16\35\u019f\13\35\3\36\3\36"+
		"\3\36\7\36\u01a4\n\36\f\36\16\36\u01a7\13\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\5\37\u01b2\n\37\3 \3 \7 \u01b6\n \f \16 \u01b9\13"+
		" \3 \3 \3 \3 \5 \u01bf\n \3 \7 \u01c2\n \f \16 \u01c5\13 \7 \u01c7\n "+
		"\f \16 \u01ca\13 \3!\3!\3!\3!\3!\3\"\3\"\3\"\5\"\u01d4\n\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01e2\n\"\3\"\5\"\u01e5\n\"\3"+
		"#\3#\3#\7#\u01ea\n#\f#\16#\u01ed\13#\3$\3$\3$\5$\u01f2\n$\3%\3%\3%\3%"+
		"\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0207\n\'"+
		"\3(\3(\3(\7(\u020c\n(\f(\16(\u020f\13(\3)\3)\3)\3)\3*\3*\3*\7*\u0218\n"+
		"*\f*\16*\u021b\13*\3+\3+\5+\u021f\n+\3,\3,\3,\3,\5,\u0225\n,\3-\3-\5-"+
		"\u0229\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0236\n.\3.\3.\3.\3.\3."+
		"\3.\7.\u023e\n.\f.\16.\u0241\13.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u024e"+
		"\n.\3.\3.\5.\u0252\n.\3.\3.\5.\u0256\n.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\5.\u0269\n.\3.\5.\u026c\n.\3/\3/\5/\u0270\n/\3/"+
		"\3/\3\60\3\60\3\60\3\60\7\60\u0278\n\60\f\60\16\60\u027b\13\60\3\61\3"+
		"\61\3\62\3\62\3\62\5\62\u0282\n\62\3\62\3\62\5\62\u0286\n\62\3\63\6\63"+
		"\u0289\n\63\r\63\16\63\u028a\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\5"+
		"\64\u0295\n\64\3\65\6\65\u0298\n\65\r\65\16\65\u0299\3\66\3\66\3\66\3"+
		"\66\7\66\u02a0\n\66\f\66\16\66\u02a3\13\66\5\66\u02a5\n\66\3\67\3\67\3"+
		"\67\7\67\u02aa\n\67\f\67\16\67\u02ad\13\67\38\38\78\u02b1\n8\f8\168\u02b4"+
		"\138\38\58\u02b7\n8\38\58\u02ba\n8\39\39\39\39\59\u02c0\n9\39\39\39\3"+
		":\3:\3:\3;\3;\3;\3<\3<\5<\u02cd\n<\3=\3=\3=\3=\5=\u02d3\n=\3>\3>\5>\u02d7"+
		"\n>\3>\3>\3?\6?\u02dc\n?\r?\16?\u02dd\3@\3@\3@\3@\3@\3@\5@\u02e6\n@\3"+
		"A\5A\u02e9\nA\3A\3A\5A\u02ed\nA\3B\3B\3B\3B\7B\u02f3\nB\fB\16B\u02f6\13"+
		"B\3B\3B\3C\3C\3D\3D\5D\u02fe\nD\3D\3D\3E\6E\u0303\nE\rE\16E\u0304\3F\5"+
		"F\u0308\nF\3F\3F\3G\6G\u030d\nG\rG\16G\u030e\3H\3H\3I\3I\5I\u0315\nI\3"+
		"J\3J\3J\3J\3J\5J\u031c\nJ\3K\3K\3K\7K\u0321\nK\fK\16K\u0324\13K\3L\3L"+
		"\3L\7L\u0329\nL\fL\16L\u032c\13L\3M\3M\5M\u0330\nM\3N\3N\3O\3O\3P\3P\3"+
		"Q\3Q\3Q\7Q\u033b\nQ\fQ\16Q\u033e\13Q\3R\3R\3S\3S\3S\3S\5S\u0346\nS\3S"+
		"\3S\3T\3T\5T\u034c\nT\3U\3U\3U\3U\7U\u0352\nU\fU\16U\u0355\13U\3U\3U\3"+
		"V\3V\3W\3W\3W\3W\7W\u035f\nW\fW\16W\u0362\13W\3W\5W\u0365\nW\5W\u0367"+
		"\nW\3W\3W\3X\3X\3X\5X\u036e\nX\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\"+
		"\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u0383\n\\\3]\3]\3^\3^\3_\3_\3_\5_\u038c\n"+
		"_\3_\3_\5_\u0390\n_\3`\3`\3`\3`\5`\u0396\n`\3a\3a\3a\5a\u039b\na\3a\3"+
		"a\3a\3b\3b\5b\u03a2\nb\3b\3b\5b\u03a6\nb\3b\3b\3b\5b\u03ab\nb\3b\3b\3"+
		"c\3c\3c\3c\3c\3c\5c\u03b5\nc\3c\3c\3d\3d\3d\3d\3d\5d\u03be\nd\3e\3e\5"+
		"e\u03c2\ne\3e\3e\3f\3f\5f\u03c8\nf\3f\3f\3g\3g\3g\2\2h\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\2\f\5\2\b\b%%..\3\2]^\4\2ST_`\3\2HI\3\2"+
		"JL\5\2\r\r\31\31++\6\2\7\7\36!$$\65\65\4\2\23\23))\4\2\27\27##\b\2\27"+
		"\27\31\31##++..\67\67\2\u03f5\2\u00d1\3\2\2\2\4\u00d5\3\2\2\2\6\u00e2"+
		"\3\2\2\2\b\u00e6\3\2\2\2\n\u00f4\3\2\2\2\f\u00fc\3\2\2\2\16\u0107\3\2"+
		"\2\2\20\u0109\3\2\2\2\22\u010b\3\2\2\2\24\u010d\3\2\2\2\26\u0118\3\2\2"+
		"\2\30\u0120\3\2\2\2\32\u012b\3\2\2\2\34\u0131\3\2\2\2\36\u0135\3\2\2\2"+
		" \u0137\3\2\2\2\"\u0146\3\2\2\2$\u0148\3\2\2\2&\u0150\3\2\2\2(\u0158\3"+
		"\2\2\2*\u0160\3\2\2\2,\u0168\3\2\2\2.\u0170\3\2\2\2\60\u0178\3\2\2\2\62"+
		"\u0180\3\2\2\2\64\u0185\3\2\2\2\66\u018d\3\2\2\28\u0198\3\2\2\2:\u01a0"+
		"\3\2\2\2<\u01b1\3\2\2\2>\u01b3\3\2\2\2@\u01cb\3\2\2\2B\u01e4\3\2\2\2D"+
		"\u01e6\3\2\2\2F\u01ee\3\2\2\2H\u01f3\3\2\2\2J\u01f7\3\2\2\2L\u0206\3\2"+
		"\2\2N\u0208\3\2\2\2P\u0210\3\2\2\2R\u0214\3\2\2\2T\u021e\3\2\2\2V\u0224"+
		"\3\2\2\2X\u0228\3\2\2\2Z\u026b\3\2\2\2\\\u026d\3\2\2\2^\u0273\3\2\2\2"+
		"`\u027c\3\2\2\2b\u027e\3\2\2\2d\u0288\3\2\2\2f\u0294\3\2\2\2h\u0297\3"+
		"\2\2\2j\u02a4\3\2\2\2l\u02a6\3\2\2\2n\u02b9\3\2\2\2p\u02bb\3\2\2\2r\u02c4"+
		"\3\2\2\2t\u02c7\3\2\2\2v\u02cc\3\2\2\2x\u02ce\3\2\2\2z\u02d4\3\2\2\2|"+
		"\u02db\3\2\2\2~\u02e5\3\2\2\2\u0080\u02e8\3\2\2\2\u0082\u02ee\3\2\2\2"+
		"\u0084\u02f9\3\2\2\2\u0086\u02fb\3\2\2\2\u0088\u0302\3\2\2\2\u008a\u0307"+
		"\3\2\2\2\u008c\u030c\3\2\2\2\u008e\u0310\3\2\2\2\u0090\u0314\3\2\2\2\u0092"+
		"\u031b\3\2\2\2\u0094\u031d\3\2\2\2\u0096\u0325\3\2\2\2\u0098\u032f\3\2"+
		"\2\2\u009a\u0331\3\2\2\2\u009c\u0333\3\2\2\2\u009e\u0335\3\2\2\2\u00a0"+
		"\u0337\3\2\2\2\u00a2\u033f\3\2\2\2\u00a4\u0341\3\2\2\2\u00a6\u034b\3\2"+
		"\2\2\u00a8\u034d\3\2\2\2\u00aa\u0358\3\2\2\2\u00ac\u035a\3\2\2\2\u00ae"+
		"\u036a\3\2\2\2\u00b0\u036f\3\2\2\2\u00b2\u0373\3\2\2\2\u00b4\u0377\3\2"+
		"\2\2\u00b6\u0382\3\2\2\2\u00b8\u0384\3\2\2\2\u00ba\u0386\3\2\2\2\u00bc"+
		"\u0388\3\2\2\2\u00be\u0391\3\2\2\2\u00c0\u0397\3\2\2\2\u00c2\u039f\3\2"+
		"\2\2\u00c4\u03ae\3\2\2\2\u00c6\u03b8\3\2\2\2\u00c8\u03bf\3\2\2\2\u00ca"+
		"\u03c5\3\2\2\2\u00cc\u03cb\3\2\2\2\u00ce\u00d0\5\4\3\2\u00cf\u00ce\3\2"+
		"\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\7\3\2\2\u00d5\u00d4\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d9\5\6\4\2\u00d8\u00d7"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\5|?\2\u00de\u00dd\3\2\2"+
		"\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\2\2\3\u00e1\5"+
		"\3\2\2\2\u00e2\u00e3\7\62\2\2\u00e3\u00e4\5\u00ba^\2\u00e4\u00e5\7G\2"+
		"\2\u00e5\7\3\2\2\2\u00e6\u00e8\5\u00ccg\2\u00e7\u00e9\5\24\13\2\u00e8"+
		"\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f1\3\2\2\2\u00ea\u00eb\7D"+
		"\2\2\u00eb\u00ed\5\u00ccg\2\u00ec\u00ee\5\24\13\2\u00ed\u00ec\3\2\2\2"+
		"\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0\u00f3"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\t\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f9\5\f\7\2\u00f5\u00f6\7N\2\2\u00f6\u00f8\5\f"+
		"\7\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\13\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u0101\5\16\b"+
		"\2\u00fd\u00fe\7@\2\2\u00fe\u0100\7A\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103"+
		"\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\r\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0104\u0108\5\20\t\2\u0105\u0108\5\22\n\2\u0106\u0108\5"+
		"\26\f\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108"+
		"\17\3\2\2\2\u0109\u010a\t\2\2\2\u010a\21\3\2\2\2\u010b\u010c\5\b\5\2\u010c"+
		"\23\3\2\2\2\u010d\u010e\7S\2\2\u010e\u0113\5\n\6\2\u010f\u0110\7E\2\2"+
		"\u0110\u0112\5\n\6\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116"+
		"\u0117\7T\2\2\u0117\25\3\2\2\2\u0118\u011a\7B\2\2\u0119\u011b\5\u009e"+
		"P\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011d\7C\2\2\u011d\u011e\5\u00b0Y\2\u011e\u011f\5\u0096L\2\u011f\27\3"+
		"\2\2\2\u0120\u0125\5\32\16\2\u0121\u0122\7E\2\2\u0122\u0124\5\32\16\2"+
		"\u0123\u0121\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\31\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\5\u00ccg\2\u0129"+
		"\u012a\7F\2\2\u012a\u012c\3\2\2\2\u012b\u0128\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012e\5\34\17\2\u012e\33\3\2\2\2\u012f"+
		"\u0132\5 \21\2\u0130\u0132\5\36\20\2\u0131\u012f\3\2\2\2\u0131\u0130\3"+
		"\2\2\2\u0132\35\3\2\2\2\u0133\u0136\5J&\2\u0134\u0136\5$\23\2\u0135\u0133"+
		"\3\2\2\2\u0135\u0134\3\2\2\2\u0136\37\3\2\2\2\u0137\u0138\5<\37\2\u0138"+
		"\u0139\5\"\22\2\u0139\u013a\5\34\17\2\u013a!\3\2\2\2\u013b\u0147\7R\2"+
		"\2\u013c\u0147\7a\2\2\u013d\u0147\7b\2\2\u013e\u0147\7c\2\2\u013f\u0147"+
		"\7d\2\2\u0140\u0147\7e\2\2\u0141\u0147\7f\2\2\u0142\u0147\7g\2\2\u0143"+
		"\u0147\7h\2\2\u0144\u0147\7j\2\2\u0145\u0147\5\u00b4[\2\u0146\u013b\3"+
		"\2\2\2\u0146\u013c\3\2\2\2\u0146\u013d\3\2\2\2\u0146\u013e\3\2\2\2\u0146"+
		"\u013f\3\2\2\2\u0146\u0140\3\2\2\2\u0146\u0141\3\2\2\2\u0146\u0142\3\2"+
		"\2\2\u0146\u0143\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2\u0147"+
		"#\3\2\2\2\u0148\u014e\5&\24\2\u0149\u014a\7U\2\2\u014a\u014b\5\34\17\2"+
		"\u014b\u014c\7F\2\2\u014c\u014d\5\34\17\2\u014d\u014f\3\2\2\2\u014e\u0149"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f%\3\2\2\2\u0150\u0155\5(\25\2\u0151"+
		"\u0152\7[\2\2\u0152\u0154\5(\25\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2"+
		"\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\'\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0158\u015d\5*\26\2\u0159\u015a\7Z\2\2\u015a\u015c\5*\26\2\u015b"+
		"\u0159\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e)\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0165\5,\27\2\u0161\u0162"+
		"\7N\2\2\u0162\u0164\5,\27\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166+\3\2\2\2\u0167\u0165\3\2\2\2"+
		"\u0168\u016d\5.\30\2\u0169\u016a\7O\2\2\u016a\u016c\5.\30\2\u016b\u0169"+
		"\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"-\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0175\5\60\31\2\u0171\u0172\7M\2\2"+
		"\u0172\u0174\5\60\31\2\u0173\u0171\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176/\3\2\2\2\u0177\u0175\3\2\2\2\u0178"+
		"\u017d\5\62\32\2\u0179\u017a\t\3\2\2\u017a\u017c\5\62\32\2\u017b\u0179"+
		"\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\61\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0183\5\64\33\2\u0181\u0182\7\66"+
		"\2\2\u0182\u0184\5\f\7\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\63\3\2\2\2\u0185\u018a\5\66\34\2\u0186\u0187\t\4\2\2\u0187\u0189\5\66"+
		"\34\2\u0188\u0186\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\65\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u0195\58\35"+
		"\2\u018e\u0191\7i\2\2\u018f\u0191\5\u00b2Z\2\u0190\u018e\3\2\2\2\u0190"+
		"\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0194\58\35\2\u0193\u0190\3\2"+
		"\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"\67\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u019d\5:\36\2\u0199\u019a\t\5\2"+
		"\2\u019a\u019c\5:\36\2\u019b\u0199\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b"+
		"\3\2\2\2\u019d\u019e\3\2\2\2\u019e9\3\2\2\2\u019f\u019d\3\2\2\2\u01a0"+
		"\u01a5\5<\37\2\u01a1\u01a2\t\6\2\2\u01a2\u01a4\5<\37\2\u01a3\u01a1\3\2"+
		"\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		";\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01b2\5> \2\u01a9\u01aa\7H\2\2\u01aa"+
		"\u01b2\5<\37\2\u01ab\u01ac\7I\2\2\u01ac\u01b2\5<\37\2\u01ad\u01ae\7P\2"+
		"\2\u01ae\u01b2\5<\37\2\u01af\u01b0\7Q\2\2\u01b0\u01b2\5<\37\2\u01b1\u01a8"+
		"\3\2\2\2\u01b1\u01a9\3\2\2\2\u01b1\u01ab\3\2\2\2\u01b1\u01ad\3\2\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b2=\3\2\2\2\u01b3\u01b7\5B\"\2\u01b4\u01b6\5H%\2\u01b5"+
		"\u01b4\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2"+
		"\2\2\u01b8\u01c8\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bf\5F$\2\u01bb\u01bf"+
		"\5\u00c8e\2\u01bc\u01bf\7X\2\2\u01bd\u01bf\7Y\2\2\u01be\u01ba\3\2\2\2"+
		"\u01be\u01bb\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c3"+
		"\3\2\2\2\u01c0\u01c2\5H%\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c6\u01be\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9?\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\5\u00cc"+
		"g\2\u01cc\u01cd\5F$\2\u01cd\u01ce\5\u00c8e\2\u01ce\u01cf\7G\2\2\u01cf"+
		"A\3\2\2\2\u01d0\u01e5\5\u00b6\\\2\u01d1\u01d3\5\u00ccg\2\u01d2\u01d4\5"+
		"\24\13\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01e5\3\2\2\2\u01d5"+
		"\u01d6\7B\2\2\u01d6\u01d7\5\34\17\2\u01d7\u01d8\7C\2\2\u01d8\u01e5\3\2"+
		"\2\2\u01d9\u01e5\78\2\2\u01da\u01e5\7\'\2\2\u01db\u01dc\7\32\2\2\u01dc"+
		"\u01dd\5\f\7\2\u01dd\u01de\5\u00caf\2\u01de\u01e5\3\2\2\2\u01df\u01e1"+
		"\7@\2\2\u01e0\u01e2\5D#\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e5\7A\2\2\u01e4\u01d0\3\2\2\2\u01e4\u01d1\3\2"+
		"\2\2\u01e4\u01d5\3\2\2\2\u01e4\u01d9\3\2\2\2\u01e4\u01da\3\2\2\2\u01e4"+
		"\u01db\3\2\2\2\u01e4\u01df\3\2\2\2\u01e5C\3\2\2\2\u01e6\u01eb\5\34\17"+
		"\2\u01e7\u01e8\7E\2\2\u01e8\u01ea\5\34\17\2\u01e9\u01e7\3\2\2\2\u01ea"+
		"\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ecE\3\2\2\2"+
		"\u01ed\u01eb\3\2\2\2\u01ee\u01ef\7D\2\2\u01ef\u01f1\5\u00ccg\2\u01f0\u01f2"+
		"\5\24\13\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2G\3\2\2\2\u01f3"+
		"\u01f4\7@\2\2\u01f4\u01f5\5D#\2\u01f5\u01f6\7A\2\2\u01f6I\3\2\2\2\u01f7"+
		"\u01f8\5L\'\2\u01f8\u01f9\5\u00b0Y\2\u01f9\u01fa\5T+\2\u01faK\3\2\2\2"+
		"\u01fb\u01fc\7B\2\2\u01fc\u0207\7C\2\2\u01fd\u01fe\7B\2\2\u01fe\u01ff"+
		"\5N(\2\u01ff\u0200\7C\2\2\u0200\u0207\3\2\2\2\u0201\u0202\7B\2\2\u0202"+
		"\u0203\5R*\2\u0203\u0204\7C\2\2\u0204\u0207\3\2\2\2\u0205\u0207\5\u00cc"+
		"g\2\u0206\u01fb\3\2\2\2\u0206\u01fd\3\2\2\2\u0206\u0201\3\2\2\2\u0206"+
		"\u0205\3\2\2\2\u0207M\3\2\2\2\u0208\u020d\5P)\2\u0209\u020a\7E\2\2\u020a"+
		"\u020c\5P)\2\u020b\u0209\3\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2"+
		"\2\u020d\u020e\3\2\2\2\u020eO\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0211"+
		"\5\u00ccg\2\u0211\u0212\7F\2\2\u0212\u0213\5\f\7\2\u0213Q\3\2\2\2\u0214"+
		"\u0219\5\u00ccg\2\u0215\u0216\7E\2\2\u0216\u0218\5\u00ccg\2\u0217\u0215"+
		"\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"S\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u021f\5\34\17\2\u021d\u021f\5\\/\2"+
		"\u021e\u021c\3\2\2\2\u021e\u021d\3\2\2\2\u021fU\3\2\2\2\u0220\u0221\5"+
		"^\60\2\u0221\u0222\7G\2\2\u0222\u0225\3\2\2\2\u0223\u0225\5X-\2\u0224"+
		"\u0220\3\2\2\2\u0224\u0223\3\2\2\2\u0225W\3\2\2\2\u0226\u0229\5\\/\2\u0227"+
		"\u0229\5Z.\2\u0228\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229Y\3\2\2\2\u022a"+
		"\u026c\7G\2\2\u022b\u022c\5\34\17\2\u022c\u022d\7G\2\2\u022d\u026c\3\2"+
		"\2\2\u022e\u022f\7\30\2\2\u022f\u0230\7B\2\2\u0230\u0231\5\34\17\2\u0231"+
		"\u0232\7C\2\2\u0232\u0235\5X-\2\u0233\u0234\7\21\2\2\u0234\u0236\5X-\2"+
		"\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u026c\3\2\2\2\u0237\u0238"+
		"\7&\2\2\u0238\u0239\7B\2\2\u0239\u023a\5\34\17\2\u023a\u023b\7C\2\2\u023b"+
		"\u023f\7>\2\2\u023c\u023e\5d\63\2\u023d\u023c\3\2\2\2\u023e\u0241\3\2"+
		"\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242\3\2\2\2\u0241"+
		"\u023f\3\2\2\2\u0242\u0243\7?\2\2\u0243\u026c\3\2\2\2\u0244\u0245\7-\2"+
		"\2\u0245\u0246\7B\2\2\u0246\u0247\5\34\17\2\u0247\u0248\7C\2\2\u0248\u0249"+
		"\5X-\2\u0249\u026c\3\2\2\2\u024a\u024b\7\25\2\2\u024b\u024d\7B\2\2\u024c"+
		"\u024e\5j\66\2\u024d\u024c\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\3\2"+
		"\2\2\u024f\u0251\7G\2\2\u0250\u0252\5\34\17\2\u0251\u0250\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\7G\2\2\u0254\u0256\5l\67"+
		"\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258"+
		"\7C\2\2\u0258\u026c\5X-\2\u0259\u025a\7\26\2\2\u025a\u025b\7B\2\2\u025b"+
		"\u025c\5`\61\2\u025c\u025d\5\u00ccg\2\u025d\u025e\7\61\2\2\u025e\u025f"+
		"\5\34\17\2\u025f\u0260\7C\2\2\u0260\u0261\5X-\2\u0261\u026c\3\2\2\2\u0262"+
		"\u0263\7\t\2\2\u0263\u026c\7G\2\2\u0264\u0265\7\16\2\2\u0265\u026c\7G"+
		"\2\2\u0266\u0268\7\"\2\2\u0267\u0269\5\34\17\2\u0268\u0267\3\2\2\2\u0268"+
		"\u0269\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\7G\2\2\u026b\u022a\3\2"+
		"\2\2\u026b\u022b\3\2\2\2\u026b\u022e\3\2\2\2\u026b\u0237\3\2\2\2\u026b"+
		"\u0244\3\2\2\2\u026b\u024a\3\2\2\2\u026b\u0259\3\2\2\2\u026b\u0262\3\2"+
		"\2\2\u026b\u0264\3\2\2\2\u026b\u0266\3\2\2\2\u026c[\3\2\2\2\u026d\u026f"+
		"\7>\2\2\u026e\u0270\5h\65\2\u026f\u026e\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u0271\3\2\2\2\u0271\u0272\7?\2\2\u0272]\3\2\2\2\u0273\u0274\5`\61\2\u0274"+
		"\u0279\5b\62\2\u0275\u0276\7E\2\2\u0276\u0278\5b\62\2\u0277\u0275\3\2"+
		"\2\2\u0278\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a"+
		"_\3\2\2\2\u027b\u0279\3\2\2\2\u027c\u027d\t\7\2\2\u027da\3\2\2\2\u027e"+
		"\u0281\5\u00ccg\2\u027f\u0280\7F\2\2\u0280\u0282\5\f\7\2\u0281\u027f\3"+
		"\2\2\2\u0281\u0282\3\2\2\2\u0282\u0285\3\2\2\2\u0283\u0284\7R\2\2\u0284"+
		"\u0286\5\34\17\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286c\3\2\2"+
		"\2\u0287\u0289\5f\64\2\u0288\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u0288"+
		"\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028d\5h\65\2\u028d"+
		"e\3\2\2\2\u028e\u028f\7\n\2\2\u028f\u0290\5\34\17\2\u0290\u0291\7F\2\2"+
		"\u0291\u0295\3\2\2\2\u0292\u0293\7\17\2\2\u0293\u0295\7F\2\2\u0294\u028e"+
		"\3\2\2\2\u0294\u0292\3\2\2\2\u0295g\3\2\2\2\u0296\u0298\5V,\2\u0297\u0296"+
		"\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a"+
		"i\3\2\2\2\u029b\u02a5\5^\60\2\u029c\u02a1\5\34\17\2\u029d\u029e\7E\2\2"+
		"\u029e\u02a0\5\34\17\2\u029f\u029d\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f"+
		"\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4"+
		"\u029b\3\2\2\2\u02a4\u029c\3\2\2\2\u02a5k\3\2\2\2\u02a6\u02ab\5\34\17"+
		"\2\u02a7\u02a8\7E\2\2\u02a8\u02aa\5\34\17\2\u02a9\u02a7\3\2\2\2\u02aa"+
		"\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2\2\2\u02acm\3\2\2\2"+
		"\u02ad\u02ab\3\2\2\2\u02ae\u02b2\5p9\2\u02af\u02b1\5p9\2\u02b0\u02af\3"+
		"\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3"+
		"\u02b6\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02b7\5r:\2\u02b6\u02b5\3\2\2"+
		"\2\u02b6\u02b7\3\2\2\2\u02b7\u02ba\3\2\2\2\u02b8\u02ba\5r:\2\u02b9\u02ae"+
		"\3\2\2\2\u02b9\u02b8\3\2\2\2\u02bao\3\2\2\2\u02bb\u02bc\7\13\2\2\u02bc"+
		"\u02bd\7B\2\2\u02bd\u02bf\5\22\n\2\u02be\u02c0\5\u00ccg\2\u02bf\u02be"+
		"\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\7C\2\2\u02c2"+
		"\u02c3\5\\/\2\u02c3q\3\2\2\2\u02c4\u02c5\7\13\2\2\u02c5\u02c6\5\\/\2\u02c6"+
		"s\3\2\2\2\u02c7\u02c8\7\24\2\2\u02c8\u02c9\5\\/\2\u02c9u\3\2\2\2\u02ca"+
		"\u02cd\5^\60\2\u02cb\u02cd\5\34\17\2\u02cc\u02ca\3\2\2\2\u02cc\u02cb\3"+
		"\2\2\2\u02cdw\3\2\2\2\u02ce\u02cf\7\60\2\2\u02cf\u02d0\5\u00ccg\2\u02d0"+
		"\u02d2\5z>\2\u02d1\u02d3\7G\2\2\u02d2\u02d1\3\2\2\2\u02d2\u02d3\3\2\2"+
		"\2\u02d3y\3\2\2\2\u02d4\u02d6\7>\2\2\u02d5\u02d7\5|?\2\u02d6\u02d5\3\2"+
		"\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\7?\2\2\u02d9"+
		"{\3\2\2\2\u02da\u02dc\5~@\2\u02db\u02da\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd"+
		"\u02db\3\2\2\2\u02dd\u02de\3\2\2\2\u02de}\3\2\2\2\u02df\u02e6\5x=\2\u02e0"+
		"\u02e6\5\u0080A\2\u02e1\u02e2\5^\60\2\u02e2\u02e3\7G\2\2\u02e3\u02e6\3"+
		"\2\2\2\u02e4\u02e6\5@!\2\u02e5\u02df\3\2\2\2\u02e5\u02e0\3\2\2\2\u02e5"+
		"\u02e1\3\2\2\2\u02e5\u02e4\3\2\2\2\u02e6\177\3\2\2\2\u02e7\u02e9\5\u008c"+
		"G\2\u02e8\u02e7\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ec\3\2\2\2\u02ea"+
		"\u02ed\5\u00bc_\2\u02eb\u02ed\5\u00be`\2\u02ec\u02ea\3\2\2\2\u02ec\u02eb"+
		"\3\2\2\2\u02ed\u0081\3\2\2\2\u02ee\u02ef\7S\2\2\u02ef\u02f4\5\u0084C\2"+
		"\u02f0\u02f1\7E\2\2\u02f1\u02f3\5\u0084C\2\u02f2\u02f0\3\2\2\2\u02f3\u02f6"+
		"\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f7\3\2\2\2\u02f6"+
		"\u02f4\3\2\2\2\u02f7\u02f8\7T\2\2\u02f8\u0083\3\2\2\2\u02f9\u02fa\5\u00cc"+
		"g\2\u02fa\u0085\3\2\2\2\u02fb\u02fd\7>\2\2\u02fc\u02fe\5\u0088E\2\u02fd"+
		"\u02fc\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\7?"+
		"\2\2\u0300\u0087\3\2\2\2\u0301\u0303\5\u008aF\2\u0302\u0301\3\2\2\2\u0303"+
		"\u0304\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0089\3\2"+
		"\2\2\u0306\u0308\5\u008cG\2\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308"+
		"\u0309\3\2\2\2\u0309\u030a\5\u0090I\2\u030a\u008b\3\2\2\2\u030b\u030d"+
		"\5\u008eH\2\u030c\u030b\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030c\3\2\2"+
		"\2\u030e\u030f\3\2\2\2\u030f\u008d\3\2\2\2\u0310\u0311\t\b\2\2\u0311\u008f"+
		"\3\2\2\2\u0312\u0315\5\u0092J\2\u0313\u0315\5\u00c0a\2\u0314\u0312\3\2"+
		"\2\2\u0314\u0313\3\2\2\2\u0315\u0091\3\2\2\2\u0316\u031c\5\u00c2b\2\u0317"+
		"\u031c\5\u00c4c\2\u0318\u0319\5\u0094K\2\u0319\u031a\7G\2\2\u031a\u031c"+
		"\3\2\2\2\u031b\u0316\3\2\2\2\u031b\u0317\3\2\2\2\u031b\u0318\3\2\2\2\u031c"+
		"\u0093\3\2\2\2\u031d\u0322\5b\62\2\u031e\u031f\7E\2\2\u031f\u0321\5b\62"+
		"\2\u0320\u031e\3\2\2\2\u0321\u0324\3\2\2\2\u0322\u0320\3\2\2\2\u0322\u0323"+
		"\3\2\2\2\u0323\u0095\3\2\2\2\u0324\u0322\3\2\2\2\u0325\u032a\5\u0098M"+
		"\2\u0326\u0327\7N\2\2\u0327\u0329\5\u0098M\2\u0328\u0326\3\2\2\2\u0329"+
		"\u032c\3\2\2\2\u032a\u0328\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u0097\3\2"+
		"\2\2\u032c\u032a\3\2\2\2\u032d\u0330\5\f\7\2\u032e\u0330\7,\2\2\u032f"+
		"\u032d\3\2\2\2\u032f\u032e\3\2\2\2\u0330\u0099\3\2\2\2\u0331\u0332\5\b"+
		"\5\2\u0332\u009b\3\2\2\2\u0333\u0334\5\\/\2\u0334\u009d\3\2\2\2\u0335"+
		"\u0336\5\u00a0Q\2\u0336\u009f\3\2\2\2\u0337\u033c\5\u00a2R\2\u0338\u0339"+
		"\7E\2\2\u0339\u033b\5\u00a2R\2\u033a\u0338\3\2\2\2\u033b\u033e\3\2\2\2"+
		"\u033c\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u00a1\3\2\2\2\u033e\u033c"+
		"\3\2\2\2\u033f\u0340\5\u00c6d\2\u0340\u00a3\3\2\2\2\u0341\u0342\7F\2\2"+
		"\u0342\u0343\7/\2\2\u0343\u0345\7B\2\2\u0344\u0346\5\30\r\2\u0345\u0344"+
		"\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0348\7C\2\2\u0348"+
		"\u00a5\3\2\2\2\u0349\u034c\5\\/\2\u034a\u034c\7G\2\2\u034b\u0349\3\2\2"+
		"\2\u034b\u034a\3\2\2\2\u034c\u00a7\3\2\2\2\u034d\u034e\7S\2\2\u034e\u0353"+
		"\5\u00aaV\2\u034f\u0350\7E\2\2\u0350\u0352\5\u00aaV\2\u0351\u034f\3\2"+
		"\2\2\u0352\u0355\3\2\2\2\u0353\u0351\3\2\2\2\u0353\u0354\3\2\2\2\u0354"+
		"\u0356\3\2\2\2\u0355\u0353\3\2\2\2\u0356\u0357\7T\2\2\u0357\u00a9\3\2"+
		"\2\2\u0358\u0359\5\u00ccg\2\u0359\u00ab\3\2\2\2\u035a\u0366\7>\2\2\u035b"+
		"\u0360\5\u00aeX\2\u035c\u035d\7E\2\2\u035d\u035f\5\u00aeX\2\u035e\u035c"+
		"\3\2\2\2\u035f\u0362\3\2\2\2\u0360\u035e\3\2\2\2\u0360\u0361\3\2\2\2\u0361"+
		"\u0364\3\2\2\2\u0362\u0360\3\2\2\2\u0363\u0365\7E\2\2\u0364\u0363\3\2"+
		"\2\2\u0364\u0365\3\2\2\2\u0365\u0367\3\2\2\2\u0366\u035b\3\2\2\2\u0366"+
		"\u0367\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u0369\7?\2\2\u0369\u00ad\3\2"+
		"\2\2\u036a\u036d\5\u00ccg\2\u036b\u036c\7R\2\2\u036c\u036e\5\34\17\2\u036d"+
		"\u036b\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u00af\3\2\2\2\u036f\u0370\7R"+
		"\2\2\u0370\u0371\7T\2\2\u0371\u0372\6Y\2\3\u0372\u00b1\3\2\2\2\u0373\u0374"+
		"\7T\2\2\u0374\u0375\7T\2\2\u0375\u0376\6Z\3\3\u0376\u00b3\3\2\2\2\u0377"+
		"\u0378\7T\2\2\u0378\u0379\7`\2\2\u0379\u037a\6[\4\3\u037a\u00b5\3\2\2"+
		"\2\u037b\u0383\5\u00b8]\2\u037c\u0383\5\u00ba^\2\u037d\u0383\79\2\2\u037e"+
		"\u0383\7:\2\2\u037f\u0383\7;\2\2\u0380\u0383\7<\2\2\u0381\u0383\7\33\2"+
		"\2\u0382\u037b\3\2\2\2\u0382\u037c\3\2\2\2\u0382\u037d\3\2\2\2\u0382\u037e"+
		"\3\2\2\2\u0382\u037f\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0381\3\2\2\2\u0383"+
		"\u00b7\3\2\2\2\u0384\u0385\t\t\2\2\u0385\u00b9\3\2\2\2\u0386\u0387\7="+
		"\2\2\u0387\u00bb\3\2\2\2\u0388\u0389\7\f\2\2\u0389\u038b\5\u00ccg\2\u038a"+
		"\u038c\5\u0082B\2\u038b\u038a\3\2\2\2\u038b\u038c\3\2\2\2\u038c\u038d"+
		"\3\2\2\2\u038d\u038f\5\u0086D\2\u038e\u0390\7G\2\2\u038f\u038e\3\2\2\2"+
		"\u038f\u0390\3\2\2\2\u0390\u00bd\3\2\2\2\u0391\u0392\7\22\2\2\u0392\u0393"+
		"\5\u00ccg\2\u0393\u0395\5\u00acW\2\u0394\u0396\7G\2\2\u0395\u0394\3\2"+
		"\2\2\u0395\u0396\3\2\2\2\u0396\u00bf\3\2\2\2\u0397\u0398\7\64\2\2\u0398"+
		"\u039a\7B\2\2\u0399\u039b\5\u009eP\2\u039a\u0399\3\2\2\2\u039a\u039b\3"+
		"\2\2\2\u039b\u039c\3\2\2\2\u039c\u039d\7C\2\2\u039d\u039e\5\u00a6T\2\u039e"+
		"\u00c1\3\2\2\2\u039f\u03a1\5\u00ccg\2\u03a0\u03a2\5\u0082B\2\u03a1\u03a0"+
		"\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\7B\2\2\u03a4"+
		"\u03a6\5\u009eP\2\u03a5\u03a4\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a7"+
		"\3\2\2\2\u03a7\u03aa\7C\2\2\u03a8\u03a9\7F\2\2\u03a9\u03ab\5\u0096L\2"+
		"\u03aa\u03a8\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03ad"+
		"\5\u009cO\2\u03ad\u00c3\3\2\2\2\u03ae\u03af\t\n\2\2\u03af\u03b0\5\u00cc"+
		"g\2\u03b0\u03b1\7B\2\2\u03b1\u03b4\7C\2\2\u03b2\u03b3\7F\2\2\u03b3\u03b5"+
		"\5\u0096L\2\u03b4\u03b2\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03b6\3\2\2"+
		"\2\u03b6\u03b7\5\u009cO\2\u03b7\u00c5\3\2\2\2\u03b8\u03b9\5\u00ccg\2\u03b9"+
		"\u03ba\7F\2\2\u03ba\u03bd\5\n\6\2\u03bb\u03bc\7R\2\2\u03bc\u03be\5\34"+
		"\17\2\u03bd\u03bb\3\2\2\2\u03bd\u03be\3\2\2\2\u03be\u00c7\3\2\2\2\u03bf"+
		"\u03c1\7B\2\2\u03c0\u03c2\5\30\r\2\u03c1\u03c0\3\2\2\2\u03c1\u03c2\3\2"+
		"\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c4\7C\2\2\u03c4\u00c9\3\2\2\2\u03c5"+
		"\u03c7\7B\2\2\u03c6\u03c8\5\30\r\2\u03c7\u03c6\3\2\2\2\u03c7\u03c8\3\2"+
		"\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03ca\7C\2\2\u03ca\u00cb\3\2\2\2\u03cb"+
		"\u03cc\t\13\2\2\u03cc\u00cd\3\2\2\2j\u00d1\u00d5\u00da\u00de\u00e8\u00ed"+
		"\u00f1\u00f9\u0101\u0107\u0113\u011a\u0125\u012b\u0131\u0135\u0146\u014e"+
		"\u0155\u015d\u0165\u016d\u0175\u017d\u0183\u018a\u0190\u0195\u019d\u01a5"+
		"\u01b1\u01b7\u01be\u01c3\u01c8\u01d3\u01e1\u01e4\u01eb\u01f1\u0206\u020d"+
		"\u0219\u021e\u0224\u0228\u0235\u023f\u024d\u0251\u0255\u0268\u026b\u026f"+
		"\u0279\u0281\u0285\u028a\u0294\u0299\u02a1\u02a4\u02ab\u02b2\u02b6\u02b9"+
		"\u02bf\u02cc\u02d2\u02d6\u02dd\u02e5\u02e8\u02ec\u02f4\u02fd\u0304\u0307"+
		"\u030e\u0314\u031b\u0322\u032a\u032f\u033c\u0345\u034b\u0353\u0360\u0364"+
		"\u0366\u036d\u0382\u038b\u038f\u0395\u039a\u03a1\u03a5\u03aa\u03b4\u03bd"+
		"\u03c1\u03c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}