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
		RULE_equalityExpression = 19, RULE_castExpression = 20, RULE_relationalExpression = 21, 
		RULE_additiveExpression = 22, RULE_multiplicativeExpression = 23, RULE_unaryExpression = 24, 
		RULE_primaryExpression = 25, RULE_nativeMethodInvocationStatement = 26, 
		RULE_primaryExpressionStart = 27, RULE_expressionList = 28, RULE_memberAccess = 29, 
		RULE_bracketExpression = 30, RULE_lambdaExpression = 31, RULE_anonymousFunctionSignature = 32, 
		RULE_explicitAnonymousFunctionParameterList = 33, RULE_explicitAnonymousFunctionParameter = 34, 
		RULE_implicitAnonymousFunctionParameterList = 35, RULE_anonymousFunctionBody = 36, 
		RULE_statement = 37, RULE_embeddedStatement = 38, RULE_simpleEmbeddedStatement = 39, 
		RULE_block = 40, RULE_variableDeclaration = 41, RULE_variableType = 42, 
		RULE_variableDeclarator = 43, RULE_switchSection = 44, RULE_switchLabel = 45, 
		RULE_statementList = 46, RULE_forInitializer = 47, RULE_forIterator = 48, 
		RULE_moduleDeclaration = 49, RULE_moduleBody = 50, RULE_moduleMemberDeclarations = 51, 
		RULE_moduleMemberDeclaration = 52, RULE_functionDeclaration = 53, RULE_typeDeclaration = 54, 
		RULE_typeParameterList = 55, RULE_typeParameter = 56, RULE_classBody = 57, 
		RULE_classMemberDeclarations = 58, RULE_classMemberDeclaration = 59, RULE_allMemberModifiers = 60, 
		RULE_allMemberModifier = 61, RULE_commonMemberDeclaration = 62, RULE_typedMemberDeclaration = 63, 
		RULE_classField = 64, RULE_returnTypeList = 65, RULE_returnType = 66, 
		RULE_methodBody = 67, RULE_formalParameterList = 68, RULE_fixedParameters = 69, 
		RULE_fixedParameter = 70, RULE_constructorInitializer = 71, RULE_body = 72, 
		RULE_variantTypeParameterList = 73, RULE_variantTypeParameter = 74, RULE_enumBody = 75, 
		RULE_enumMemberDeclaration = 76, RULE_rightArrow = 77, RULE_rightShift = 78, 
		RULE_rightShiftAssignment = 79, RULE_literal = 80, RULE_booleanLiteral = 81, 
		RULE_stringLiteral = 82, RULE_classDefinition = 83, RULE_enumDefinition = 84, 
		RULE_constructorDeclaration = 85, RULE_methodDeclaration = 86, RULE_getterDeclaration = 87, 
		RULE_setterDeclaration = 88, RULE_argDeclaration = 89, RULE_methodInvocation = 90, 
		RULE_objectCreationExpression = 91, RULE_identifier = 92;
	public static final String[] ruleNames = {
		"sourceFiles", "sourceFile", "importDeclaration", "moduleOrTypeName", 
		"typeList", "type", "baseType", "primitiveType", "classType", "typeArgumentList", 
		"functionType", "argumentList", "argument", "expression", "nonAssignmentExpression", 
		"assignment", "assignmentOperator", "conditionalOrExpression", "conditionalAndExpression", 
		"equalityExpression", "castExpression", "relationalExpression", "additiveExpression", 
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
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					sourceFile();
					}
					} 
				}
				setState(191);
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
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BYTE_ORDER_MARK) {
				{
				setState(192);
				match(BYTE_ORDER_MARK);
				}
			}

			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(195);
				importDeclaration();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(201);
				moduleMemberDeclarations();
				}
			}

			setState(204);
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
			setState(206);
			match(IMPORT);
			setState(207);
			stringLiteral();
			setState(208);
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
			setState(210);
			identifier();
			}
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(211);
				match(DOT);
				setState(212);
				identifier();
				}
				}
				setState(217);
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
			setState(218);
			type();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_OR) {
				{
				{
				setState(219);
				match(BITWISE_OR);
				setState(220);
				type();
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
			setState(226);
			baseType();
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					match(OPEN_BRACKET);
					setState(228);
					match(CLOSE_BRACKET);
					}
					} 
				}
				setState(233);
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
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				classType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
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
			setState(239);
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
			setState(241);
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
			setState(243);
			match(LT);
			setState(244);
			typeList();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(245);
				match(COMMA);
				setState(246);
				typeList();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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
			setState(254);
			match(OPEN_PARENS);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(255);
				formalParameterList();
				}
			}

			setState(258);
			match(CLOSE_PARENS);
			setState(259);
			rightArrow();
			setState(260);
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
			setState(262);
			argument();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(263);
				match(COMMA);
				setState(264);
				argument();
				}
				}
				setState(269);
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
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(270);
				identifier();
				setState(271);
				match(COLON);
				}
				break;
			}
			setState(275);
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
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
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
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
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
			setState(285);
			unaryExpression();
			setState(286);
			assignmentOperator();
			setState(287);
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
		enterRule(_localctx, 32, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
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
		enterRule(_localctx, 34, RULE_conditionalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			conditionalAndExpression();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_OR) {
				{
				{
				setState(292);
				match(OP_OR);
				setState(293);
				conditionalAndExpression();
				}
				}
				setState(298);
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
		enterRule(_localctx, 36, RULE_conditionalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			equalityExpression();
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_AND) {
				{
				{
				setState(300);
				match(OP_AND);
				setState(301);
				equalityExpression();
				}
				}
				setState(306);
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
		enterRule(_localctx, 38, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			castExpression();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_EQ || _la==OP_NE) {
				{
				{
				setState(308);
				_la = _input.LA(1);
				if ( !(_la==OP_EQ || _la==OP_NE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(309);
				castExpression();
				}
				}
				setState(314);
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
		enterRule(_localctx, 40, RULE_castExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			relationalExpression();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(316);
				match(AS);
				setState(317);
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
		enterRule(_localctx, 42, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			additiveExpression();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) {
				{
				{
				setState(321);
				_la = _input.LA(1);
				if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LT - 81)) | (1L << (GT - 81)) | (1L << (OP_LE - 81)) | (1L << (OP_GE - 81)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(322);
				additiveExpression();
				}
				}
				setState(327);
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
		enterRule(_localctx, 44, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			multiplicativeExpression();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(329);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(330);
				multiplicativeExpression();
				}
				}
				setState(335);
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
		enterRule(_localctx, 46, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			unaryExpression();
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) {
				{
				{
				setState(337);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (STAR - 72)) | (1L << (DIV - 72)) | (1L << (PERCENT - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(338);
				unaryExpression();
				}
				}
				setState(343);
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
		enterRule(_localctx, 48, RULE_unaryExpression);
		try {
			setState(351);
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
				setState(344);
				primaryExpression();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				match(PLUS);
				setState(346);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(347);
				match(MINUS);
				setState(348);
				unaryExpression();
				}
				break;
			case BANG:
				enterOuterAlt(_localctx, 4);
				{
				setState(349);
				match(BANG);
				setState(350);
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
		enterRule(_localctx, 50, RULE_primaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			((PrimaryExpressionContext)_localctx).pe = primaryExpressionStart();
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACKET) {
				{
				{
				setState(354);
				bracketExpression();
				}
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (DOT - 64)) | (1L << (OP_INC - 64)) | (1L << (OP_DEC - 64)))) != 0)) {
				{
				{
				setState(364);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(360);
					memberAccess();
					}
					break;
				case OPEN_PARENS:
					{
					setState(361);
					methodInvocation();
					}
					break;
				case OP_INC:
					{
					setState(362);
					match(OP_INC);
					}
					break;
				case OP_DEC:
					{
					setState(363);
					match(OP_DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPEN_BRACKET) {
					{
					{
					setState(366);
					bracketExpression();
					}
					}
					setState(371);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(376);
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
		enterRule(_localctx, 52, RULE_nativeMethodInvocationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			((NativeMethodInvocationStatementContext)_localctx).pe = identifier();
			setState(378);
			memberAccess();
			setState(379);
			methodInvocation();
			setState(380);
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
		enterRule(_localctx, 54, RULE_primaryExpressionStart);
		int _la;
		try {
			setState(401);
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
				setState(382);
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
				setState(383);
				identifier();
				setState(385);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(384);
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
				setState(387);
				match(OPEN_PARENS);
				setState(388);
				expression();
				setState(389);
				match(CLOSE_PARENS);
				}
				break;
			case THIS:
				_localctx = new ThisReferenceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(391);
				match(THIS);
				}
				break;
			case NEW:
				_localctx = new ObjectCreationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(392);
				match(NEW);
				setState(393);
				type();
				setState(394);
				objectCreationExpression();
				}
				break;
			case OPEN_BRACKET:
				_localctx = new ArrayCreationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(396);
				match(OPEN_BRACKET);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(397);
					expressionList();
					}
				}

				setState(400);
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
		enterRule(_localctx, 56, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			expression();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(404);
				match(COMMA);
				setState(405);
				expression();
				}
				}
				setState(410);
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
		enterRule(_localctx, 58, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(DOT);
			setState(412);
			identifier();
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(413);
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
		enterRule(_localctx, 60, RULE_bracketExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(OPEN_BRACKET);
			setState(417);
			expression();
			setState(418);
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
		enterRule(_localctx, 62, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			anonymousFunctionSignature();
			setState(421);
			rightArrow();
			setState(422);
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
		enterRule(_localctx, 64, RULE_anonymousFunctionSignature);
		try {
			setState(430);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(OPEN_PARENS);
				setState(425);
				match(CLOSE_PARENS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				match(OPEN_PARENS);
				setState(427);
				explicitAnonymousFunctionParameterList();
				setState(428);
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
		enterRule(_localctx, 66, RULE_explicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			explicitAnonymousFunctionParameter();
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(433);
				match(COMMA);
				setState(434);
				explicitAnonymousFunctionParameter();
				}
				}
				setState(439);
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
		enterRule(_localctx, 68, RULE_explicitAnonymousFunctionParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			identifier();
			setState(441);
			match(COLON);
			setState(442);
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
		enterRule(_localctx, 70, RULE_implicitAnonymousFunctionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			identifier();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(445);
				match(COMMA);
				setState(446);
				identifier();
				}
				}
				setState(451);
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
		enterRule(_localctx, 72, RULE_anonymousFunctionBody);
		try {
			setState(454);
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
				setState(452);
				expression();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
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
		enterRule(_localctx, 74, RULE_statement);
		try {
			setState(460);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new DeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				variableDeclaration();
				setState(457);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new EmbeddedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(459);
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
		enterRule(_localctx, 76, RULE_embeddedStatement);
		try {
			setState(464);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
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
		enterRule(_localctx, 78, RULE_simpleEmbeddedStatement);
		int _la;
		try {
			setState(531);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
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
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				expression();
				setState(468);
				match(SEMICOLON);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(470);
				match(IF);
				setState(471);
				match(OPEN_PARENS);
				setState(472);
				expression();
				setState(473);
				match(CLOSE_PARENS);
				setState(474);
				embeddedStatement();
				setState(477);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(475);
					match(ELSE);
					setState(476);
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
				setState(479);
				match(SWITCH);
				setState(480);
				match(OPEN_PARENS);
				setState(481);
				expression();
				setState(482);
				match(CLOSE_PARENS);
				setState(483);
				match(OPEN_BRACE);
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(484);
					switchSection();
					}
					}
					setState(489);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(490);
				match(CLOSE_BRACE);
				}
				break;
			case WHILE:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(492);
				match(WHILE);
				setState(493);
				match(OPEN_PARENS);
				setState(494);
				expression();
				setState(495);
				match(CLOSE_PARENS);
				setState(496);
				embeddedStatement();
				}
				break;
			case FOR:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(498);
				match(FOR);
				setState(499);
				match(OPEN_PARENS);
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << FALSE) | (1L << GET) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << SET) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)))) != 0)) {
					{
					setState(500);
					forInitializer();
					}
				}

				setState(503);
				match(SEMICOLON);
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(504);
					expression();
					}
				}

				setState(507);
				match(SEMICOLON);
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(508);
					forIterator();
					}
				}

				setState(511);
				match(CLOSE_PARENS);
				setState(512);
				embeddedStatement();
				}
				break;
			case FOREACH:
				_localctx = new ForeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(513);
				match(FOREACH);
				setState(514);
				match(OPEN_PARENS);
				setState(515);
				variableType();
				setState(516);
				identifier();
				setState(517);
				match(OF);
				setState(518);
				expression();
				setState(519);
				match(CLOSE_PARENS);
				setState(520);
				embeddedStatement();
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(522);
				match(BREAK);
				setState(523);
				match(SEMICOLON);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(524);
				match(CONTINUE);
				setState(525);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(526);
				match(RETURN);
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
					{
					setState(527);
					expression();
					}
				}

				setState(530);
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
		enterRule(_localctx, 80, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			match(OPEN_BRACE);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << FOREACH) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)))) != 0)) {
				{
				setState(534);
				statementList();
				}
			}

			setState(537);
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
		enterRule(_localctx, 82, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			variableType();
			setState(540);
			variableDeclarator();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(541);
				match(COMMA);
				setState(542);
				variableDeclarator();
				}
				}
				setState(547);
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
		enterRule(_localctx, 84, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
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
		enterRule(_localctx, 86, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			identifier();
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(551);
				match(COLON);
				setState(552);
				type();
				}
			}

			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(555);
				match(ASSIGNMENT);
				setState(556);
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
		enterRule(_localctx, 88, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(559);
				switchLabel();
				}
				}
				setState(562); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(564);
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
		enterRule(_localctx, 90, RULE_switchLabel);
		try {
			setState(572);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				match(CASE);
				setState(567);
				expression();
				setState(568);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				match(DEFAULT);
				setState(571);
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
		enterRule(_localctx, 92, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(574);
				statement();
				}
				}
				setState(577); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONST) | (1L << CONTINUE) | (1L << FALSE) | (1L << FOR) | (1L << FOREACH) | (1L << GET) | (1L << IF) | (1L << LET) | (1L << NEW) | (1L << NULL) | (1L << RETURN) | (1L << SET) | (1L << SWITCH) | (1L << THIS) | (1L << TRUE) | (1L << VAR) | (1L << WHILE) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL) | (1L << HEX_INTEGER_LITERAL) | (1L << REAL_LITERAL) | (1L << REGULAR_STRING) | (1L << SINGLE_QUOTE_STRING_LITERAL) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OPEN_PARENS - 64)) | (1L << (SEMICOLON - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)) | (1L << (BANG - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_forInitializer);
		int _la;
		try {
			setState(588);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(579);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(580);
				expression();
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(581);
					match(COMMA);
					setState(582);
					expression();
					}
					}
					setState(587);
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
		enterRule(_localctx, 96, RULE_forIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			expression();
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(591);
				match(COMMA);
				setState(592);
				expression();
				}
				}
				setState(597);
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
		enterRule(_localctx, 98, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(598);
				match(EXPORT);
				}
			}

			setState(601);
			match(MODULE);
			setState(602);
			identifier();
			setState(603);
			moduleBody();
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(604);
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
		enterRule(_localctx, 100, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(OPEN_BRACE);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << CONST) | (1L << ENUM) | (1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << MODULE) | (1L << FUNCTION) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(608);
				moduleMemberDeclarations();
				}
			}

			setState(611);
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
		enterRule(_localctx, 102, RULE_moduleMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(613);
				moduleMemberDeclaration();
				}
				}
				setState(616); 
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
		enterRule(_localctx, 104, RULE_moduleMemberDeclaration);
		try {
			setState(625);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(618);
				moduleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(619);
				typeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(620);
				variableDeclaration();
				setState(621);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(623);
				nativeMethodInvocationStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(624);
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
		enterRule(_localctx, 106, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(627);
				match(EXPORT);
				}
			}

			setState(630);
			match(FUNCTION);
			setState(631);
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
		enterRule(_localctx, 108, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(633);
				allMemberModifiers();
				}
			}

			setState(638);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(636);
				classDefinition();
				}
				break;
			case ENUM:
				{
				setState(637);
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
		enterRule(_localctx, 110, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(LT);
			setState(641);
			typeParameter();
			setState(646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(642);
				match(COMMA);
				setState(643);
				typeParameter();
				}
				}
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(649);
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
		enterRule(_localctx, 112, RULE_typeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
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
		enterRule(_localctx, 114, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(OPEN_BRACE);
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << SET) | (1L << STATIC) | (1L << VAR) | (1L << NUMBER) | (1L << CONSTRUCTOR) | (1L << EXPORT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(654);
				classMemberDeclarations();
				}
			}

			setState(657);
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
		enterRule(_localctx, 116, RULE_classMemberDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(659);
				classMemberDeclaration();
				}
				}
				setState(662); 
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
		enterRule(_localctx, 118, RULE_classMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PUBLIC) | (1L << READONLY) | (1L << STATIC) | (1L << EXPORT))) != 0)) {
				{
				setState(664);
				allMemberModifiers();
				}
			}

			setState(667);
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
		enterRule(_localctx, 120, RULE_allMemberModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(669);
				allMemberModifier();
				}
				}
				setState(672); 
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
		enterRule(_localctx, 122, RULE_allMemberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
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
		enterRule(_localctx, 124, RULE_commonMemberDeclaration);
		try {
			setState(678);
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
				setState(676);
				typedMemberDeclaration();
				}
				break;
			case CONSTRUCTOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(677);
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
		enterRule(_localctx, 126, RULE_typedMemberDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(680);
				methodDeclaration();
				}
				break;
			case 2:
				{
				setState(681);
				getterDeclaration();
				}
				break;
			case 3:
				{
				setState(682);
				setterDeclaration();
				}
				break;
			case 4:
				{
				setState(683);
				classField();
				setState(684);
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
		enterRule(_localctx, 128, RULE_classField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			variableDeclarator();
			setState(693);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(689);
				match(COMMA);
				setState(690);
				variableDeclarator();
				}
				}
				setState(695);
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
		enterRule(_localctx, 130, RULE_returnTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			returnType();
			setState(701);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(697);
					match(BITWISE_OR);
					setState(698);
					returnType();
					}
					} 
				}
				setState(703);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
		enterRule(_localctx, 132, RULE_returnType);
		try {
			setState(706);
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
				setState(704);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(705);
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
		enterRule(_localctx, 134, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
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
		enterRule(_localctx, 136, RULE_formalParameterList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
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
		enterRule(_localctx, 138, RULE_fixedParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			fixedParameter();
			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(713);
				match(COMMA);
				setState(714);
				fixedParameter();
				}
				}
				setState(719);
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
		enterRule(_localctx, 140, RULE_fixedParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
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
		enterRule(_localctx, 142, RULE_constructorInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			match(COLON);
			setState(723);
			match(SUPER);
			setState(724);
			match(OPEN_PARENS);
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
				{
				setState(725);
				argumentList();
				}
			}

			setState(728);
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
		enterRule(_localctx, 144, RULE_body);
		try {
			setState(732);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(730);
				block();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(731);
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
		enterRule(_localctx, 146, RULE_variantTypeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
			match(LT);
			setState(735);
			variantTypeParameter();
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(736);
				match(COMMA);
				setState(737);
				variantTypeParameter();
				}
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(743);
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
		enterRule(_localctx, 148, RULE_variantTypeParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
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
		enterRule(_localctx, 150, RULE_enumBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			match(OPEN_BRACE);
			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(748);
				enumMemberDeclaration();
				setState(753);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(749);
						match(COMMA);
						setState(750);
						enumMemberDeclaration();
						}
						} 
					}
					setState(755);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				}
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(756);
					match(COMMA);
					}
				}

				}
			}

			setState(761);
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
		enterRule(_localctx, 152, RULE_enumMemberDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			identifier();
			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(764);
				match(ASSIGNMENT);
				setState(765);
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
		enterRule(_localctx, 154, RULE_rightArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			((RightArrowContext)_localctx).first = match(ASSIGNMENT);
			setState(769);
			((RightArrowContext)_localctx).second = match(GT);
			setState(770);
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
		enterRule(_localctx, 156, RULE_rightShift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			((RightShiftContext)_localctx).first = match(GT);
			setState(773);
			((RightShiftContext)_localctx).second = match(GT);
			setState(774);
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
		enterRule(_localctx, 158, RULE_rightShiftAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			((RightShiftAssignmentContext)_localctx).first = match(GT);
			setState(777);
			((RightShiftAssignmentContext)_localctx).second = match(OP_GE);
			setState(778);
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
		enterRule(_localctx, 160, RULE_literal);
		try {
			setState(786);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(780);
				booleanLiteral();
				}
				break;
			case REGULAR_STRING:
			case SINGLE_QUOTE_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(781);
				stringLiteral();
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(782);
				match(INTEGER_LITERAL);
				}
				break;
			case HEX_INTEGER_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(783);
				match(HEX_INTEGER_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(784);
				match(REAL_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(785);
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
		enterRule(_localctx, 162, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
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
		enterRule(_localctx, 164, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
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
		enterRule(_localctx, 166, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			match(CLASS);
			setState(793);
			identifier();
			setState(795);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(794);
				typeParameterList();
				}
			}

			setState(797);
			classBody();
			setState(799);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(798);
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
		enterRule(_localctx, 168, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			match(ENUM);
			setState(802);
			identifier();
			setState(803);
			enumBody();
			setState(805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(804);
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
		enterRule(_localctx, 170, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			match(CONSTRUCTOR);
			setState(808);
			match(OPEN_PARENS);
			setState(810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(809);
				formalParameterList();
				}
			}

			setState(812);
			match(CLOSE_PARENS);
			setState(813);
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
		enterRule(_localctx, 172, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			identifier();
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(816);
				typeParameterList();
				}
			}

			setState(819);
			match(OPEN_PARENS);
			setState(821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GET) | (1L << LET) | (1L << SET) | (1L << VAR) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(820);
				formalParameterList();
				}
			}

			setState(823);
			match(CLOSE_PARENS);
			{
			setState(824);
			match(COLON);
			setState(825);
			returnTypeList();
			}
			setState(827);
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
		enterRule(_localctx, 174, RULE_getterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			match(GET);
			setState(830);
			identifier();
			setState(831);
			match(OPEN_PARENS);
			setState(832);
			match(CLOSE_PARENS);
			setState(835);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(833);
				match(COLON);
				setState(834);
				returnTypeList();
				}
			}

			setState(837);
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
		enterRule(_localctx, 176, RULE_setterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			match(SET);
			setState(840);
			identifier();
			setState(841);
			match(OPEN_PARENS);
			setState(842);
			formalParameterList();
			setState(843);
			match(CLOSE_PARENS);
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(844);
				match(COLON);
				setState(845);
				returnTypeList();
				}
			}

			setState(848);
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
		enterRule(_localctx, 178, RULE_argDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850);
			identifier();
			setState(851);
			match(COLON);
			setState(852);
			typeList();
			setState(855);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(853);
				match(ASSIGNMENT);
				setState(854);
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
		enterRule(_localctx, 180, RULE_methodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857);
			match(OPEN_PARENS);
			setState(859);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
				{
				setState(858);
				argumentList();
				}
			}

			setState(861);
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
		enterRule(_localctx, 182, RULE_objectCreationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			match(OPEN_PARENS);
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (FALSE - 17)) | (1L << (GET - 17)) | (1L << (LET - 17)) | (1L << (NEW - 17)) | (1L << (NULL - 17)) | (1L << (SET - 17)) | (1L << (THIS - 17)) | (1L << (TRUE - 17)) | (1L << (VAR - 17)) | (1L << (NUMBER - 17)) | (1L << (IDENTIFIER - 17)) | (1L << (INTEGER_LITERAL - 17)) | (1L << (HEX_INTEGER_LITERAL - 17)) | (1L << (REAL_LITERAL - 17)) | (1L << (REGULAR_STRING - 17)) | (1L << (SINGLE_QUOTE_STRING_LITERAL - 17)) | (1L << (OPEN_BRACKET - 17)) | (1L << (OPEN_PARENS - 17)) | (1L << (PLUS - 17)) | (1L << (MINUS - 17)) | (1L << (BANG - 17)))) != 0)) {
				{
				setState(864);
				argumentList();
				}
			}

			setState(867);
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
		enterRule(_localctx, 184, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
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
		case 77:
			return rightArrow_sempred((RightArrowContext)_localctx, predIndex);
		case 78:
			return rightShift_sempred((RightShiftContext)_localctx, predIndex);
		case 79:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3z\u036a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\3\2\7\2"+
		"\u00be\n\2\f\2\16\2\u00c1\13\2\3\3\5\3\u00c4\n\3\3\3\7\3\u00c7\n\3\f\3"+
		"\16\3\u00ca\13\3\3\3\5\3\u00cd\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\7\5\u00d8\n\5\f\5\16\5\u00db\13\5\3\6\3\6\3\6\7\6\u00e0\n\6\f\6\16\6"+
		"\u00e3\13\6\3\7\3\7\3\7\7\7\u00e8\n\7\f\7\16\7\u00eb\13\7\3\b\3\b\3\b"+
		"\5\b\u00f0\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00fa\n\13\f\13"+
		"\16\13\u00fd\13\13\3\13\3\13\3\f\3\f\5\f\u0103\n\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\7\r\u010c\n\r\f\r\16\r\u010f\13\r\3\16\3\16\3\16\5\16\u0114\n"+
		"\16\3\16\3\16\3\17\3\17\5\17\u011a\n\17\3\20\3\20\5\20\u011e\n\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\7\23\u0129\n\23\f\23\16\23\u012c"+
		"\13\23\3\24\3\24\3\24\7\24\u0131\n\24\f\24\16\24\u0134\13\24\3\25\3\25"+
		"\3\25\7\25\u0139\n\25\f\25\16\25\u013c\13\25\3\26\3\26\3\26\5\26\u0141"+
		"\n\26\3\27\3\27\3\27\7\27\u0146\n\27\f\27\16\27\u0149\13\27\3\30\3\30"+
		"\3\30\7\30\u014e\n\30\f\30\16\30\u0151\13\30\3\31\3\31\3\31\7\31\u0156"+
		"\n\31\f\31\16\31\u0159\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0162"+
		"\n\32\3\33\3\33\7\33\u0166\n\33\f\33\16\33\u0169\13\33\3\33\3\33\3\33"+
		"\3\33\5\33\u016f\n\33\3\33\7\33\u0172\n\33\f\33\16\33\u0175\13\33\7\33"+
		"\u0177\n\33\f\33\16\33\u017a\13\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\5\35\u0184\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u0191\n\35\3\35\5\35\u0194\n\35\3\36\3\36\3\36\7\36\u0199\n"+
		"\36\f\36\16\36\u019c\13\36\3\37\3\37\3\37\5\37\u01a1\n\37\3 \3 \3 \3 "+
		"\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01b1\n\"\3#\3#\3#\7#\u01b6\n"+
		"#\f#\16#\u01b9\13#\3$\3$\3$\3$\3%\3%\3%\7%\u01c2\n%\f%\16%\u01c5\13%\3"+
		"&\3&\5&\u01c9\n&\3\'\3\'\3\'\3\'\5\'\u01cf\n\'\3(\3(\5(\u01d3\n(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01e0\n)\3)\3)\3)\3)\3)\3)\7)\u01e8\n"+
		")\f)\16)\u01eb\13)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01f8\n)\3)\3)"+
		"\5)\u01fc\n)\3)\3)\5)\u0200\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\5)\u0213\n)\3)\5)\u0216\n)\3*\3*\5*\u021a\n*\3*\3*\3+\3+"+
		"\3+\3+\7+\u0222\n+\f+\16+\u0225\13+\3,\3,\3-\3-\3-\5-\u022c\n-\3-\3-\5"+
		"-\u0230\n-\3.\6.\u0233\n.\r.\16.\u0234\3.\3.\3/\3/\3/\3/\3/\3/\5/\u023f"+
		"\n/\3\60\6\60\u0242\n\60\r\60\16\60\u0243\3\61\3\61\3\61\3\61\7\61\u024a"+
		"\n\61\f\61\16\61\u024d\13\61\5\61\u024f\n\61\3\62\3\62\3\62\7\62\u0254"+
		"\n\62\f\62\16\62\u0257\13\62\3\63\5\63\u025a\n\63\3\63\3\63\3\63\3\63"+
		"\5\63\u0260\n\63\3\64\3\64\5\64\u0264\n\64\3\64\3\64\3\65\6\65\u0269\n"+
		"\65\r\65\16\65\u026a\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0274\n\66"+
		"\3\67\5\67\u0277\n\67\3\67\3\67\3\67\38\58\u027d\n8\38\38\58\u0281\n8"+
		"\39\39\39\39\79\u0287\n9\f9\169\u028a\139\39\39\3:\3:\3;\3;\5;\u0292\n"+
		";\3;\3;\3<\6<\u0297\n<\r<\16<\u0298\3=\5=\u029c\n=\3=\3=\3>\6>\u02a1\n"+
		">\r>\16>\u02a2\3?\3?\3@\3@\5@\u02a9\n@\3A\3A\3A\3A\3A\3A\5A\u02b1\nA\3"+
		"B\3B\3B\7B\u02b6\nB\fB\16B\u02b9\13B\3C\3C\3C\7C\u02be\nC\fC\16C\u02c1"+
		"\13C\3D\3D\5D\u02c5\nD\3E\3E\3F\3F\3G\3G\3G\7G\u02ce\nG\fG\16G\u02d1\13"+
		"G\3H\3H\3I\3I\3I\3I\5I\u02d9\nI\3I\3I\3J\3J\5J\u02df\nJ\3K\3K\3K\3K\7"+
		"K\u02e5\nK\fK\16K\u02e8\13K\3K\3K\3L\3L\3M\3M\3M\3M\7M\u02f2\nM\fM\16"+
		"M\u02f5\13M\3M\5M\u02f8\nM\5M\u02fa\nM\3M\3M\3N\3N\3N\5N\u0301\nN\3O\3"+
		"O\3O\3O\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\5R\u0315\nR\3S\3S\3"+
		"T\3T\3U\3U\3U\5U\u031e\nU\3U\3U\5U\u0322\nU\3V\3V\3V\3V\5V\u0328\nV\3"+
		"W\3W\3W\5W\u032d\nW\3W\3W\3W\3X\3X\5X\u0334\nX\3X\3X\5X\u0338\nX\3X\3"+
		"X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u0346\nY\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3"+
		"Z\5Z\u0351\nZ\3Z\3Z\3[\3[\3[\3[\3[\5[\u035a\n[\3\\\3\\\5\\\u035e\n\\\3"+
		"\\\3\\\3]\3]\5]\u0364\n]\3]\3]\3^\3^\3^\2\2_\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|"+
		"~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096"+
		"\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae"+
		"\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\2\r\5\2\b\b%%..\4\2RRae\3\2]^\4\2"+
		"ST_`\3\2HI\3\2JL\5\2\r\r\31\31++\6\2\36\36 !$$\65\65\4\2\23\23))\3\2<"+
		"=\b\2\27\27\31\31##++..\67\67\2\u0382\2\u00bf\3\2\2\2\4\u00c3\3\2\2\2"+
		"\6\u00d0\3\2\2\2\b\u00d4\3\2\2\2\n\u00dc\3\2\2\2\f\u00e4\3\2\2\2\16\u00ef"+
		"\3\2\2\2\20\u00f1\3\2\2\2\22\u00f3\3\2\2\2\24\u00f5\3\2\2\2\26\u0100\3"+
		"\2\2\2\30\u0108\3\2\2\2\32\u0113\3\2\2\2\34\u0119\3\2\2\2\36\u011d\3\2"+
		"\2\2 \u011f\3\2\2\2\"\u0123\3\2\2\2$\u0125\3\2\2\2&\u012d\3\2\2\2(\u0135"+
		"\3\2\2\2*\u013d\3\2\2\2,\u0142\3\2\2\2.\u014a\3\2\2\2\60\u0152\3\2\2\2"+
		"\62\u0161\3\2\2\2\64\u0163\3\2\2\2\66\u017b\3\2\2\28\u0193\3\2\2\2:\u0195"+
		"\3\2\2\2<\u019d\3\2\2\2>\u01a2\3\2\2\2@\u01a6\3\2\2\2B\u01b0\3\2\2\2D"+
		"\u01b2\3\2\2\2F\u01ba\3\2\2\2H\u01be\3\2\2\2J\u01c8\3\2\2\2L\u01ce\3\2"+
		"\2\2N\u01d2\3\2\2\2P\u0215\3\2\2\2R\u0217\3\2\2\2T\u021d\3\2\2\2V\u0226"+
		"\3\2\2\2X\u0228\3\2\2\2Z\u0232\3\2\2\2\\\u023e\3\2\2\2^\u0241\3\2\2\2"+
		"`\u024e\3\2\2\2b\u0250\3\2\2\2d\u0259\3\2\2\2f\u0261\3\2\2\2h\u0268\3"+
		"\2\2\2j\u0273\3\2\2\2l\u0276\3\2\2\2n\u027c\3\2\2\2p\u0282\3\2\2\2r\u028d"+
		"\3\2\2\2t\u028f\3\2\2\2v\u0296\3\2\2\2x\u029b\3\2\2\2z\u02a0\3\2\2\2|"+
		"\u02a4\3\2\2\2~\u02a8\3\2\2\2\u0080\u02b0\3\2\2\2\u0082\u02b2\3\2\2\2"+
		"\u0084\u02ba\3\2\2\2\u0086\u02c4\3\2\2\2\u0088\u02c6\3\2\2\2\u008a\u02c8"+
		"\3\2\2\2\u008c\u02ca\3\2\2\2\u008e\u02d2\3\2\2\2\u0090\u02d4\3\2\2\2\u0092"+
		"\u02de\3\2\2\2\u0094\u02e0\3\2\2\2\u0096\u02eb\3\2\2\2\u0098\u02ed\3\2"+
		"\2\2\u009a\u02fd\3\2\2\2\u009c\u0302\3\2\2\2\u009e\u0306\3\2\2\2\u00a0"+
		"\u030a\3\2\2\2\u00a2\u0314\3\2\2\2\u00a4\u0316\3\2\2\2\u00a6\u0318\3\2"+
		"\2\2\u00a8\u031a\3\2\2\2\u00aa\u0323\3\2\2\2\u00ac\u0329\3\2\2\2\u00ae"+
		"\u0331\3\2\2\2\u00b0\u033f\3\2\2\2\u00b2\u0349\3\2\2\2\u00b4\u0354\3\2"+
		"\2\2\u00b6\u035b\3\2\2\2\u00b8\u0361\3\2\2\2\u00ba\u0367\3\2\2\2\u00bc"+
		"\u00be\5\4\3\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4"+
		"\7\3\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c8\3\2\2\2\u00c5"+
		"\u00c7\5\6\4\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00cd\5h\65\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\7\2\2\3\u00cf\5\3\2\2\2\u00d0\u00d1\7\62\2\2\u00d1\u00d2"+
		"\5\u00a6T\2\u00d2\u00d3\7G\2\2\u00d3\7\3\2\2\2\u00d4\u00d9\5\u00ba^\2"+
		"\u00d5\u00d6\7D\2\2\u00d6\u00d8\5\u00ba^\2\u00d7\u00d5\3\2\2\2\u00d8\u00db"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\t\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00e1\5\f\7\2\u00dd\u00de\7N\2\2\u00de\u00e0\5\f"+
		"\7\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\13\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e9\5\16\b"+
		"\2\u00e5\u00e6\7@\2\2\u00e6\u00e8\7A\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\r\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00f0\5\20\t\2\u00ed\u00f0\5\22\n\2\u00ee\u00f0\5"+
		"\26\f\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\17\3\2\2\2\u00f1\u00f2\t\2\2\2\u00f2\21\3\2\2\2\u00f3\u00f4\5\b\5\2\u00f4"+
		"\23\3\2\2\2\u00f5\u00f6\7S\2\2\u00f6\u00fb\5\n\6\2\u00f7\u00f8\7E\2\2"+
		"\u00f8\u00fa\5\n\6\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u00ff\7T\2\2\u00ff\25\3\2\2\2\u0100\u0102\7B\2\2\u0101\u0103\5\u008a"+
		"F\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\7C\2\2\u0105\u0106\5\u009cO\2\u0106\u0107\5\u0084C\2\u0107\27\3"+
		"\2\2\2\u0108\u010d\5\32\16\2\u0109\u010a\7E\2\2\u010a\u010c\5\32\16\2"+
		"\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\31\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\5\u00ba^\2\u0111"+
		"\u0112\7F\2\2\u0112\u0114\3\2\2\2\u0113\u0110\3\2\2\2\u0113\u0114\3\2"+
		"\2\2\u0114\u0115\3\2\2\2\u0115\u0116\5\34\17\2\u0116\33\3\2\2\2\u0117"+
		"\u011a\5 \21\2\u0118\u011a\5\36\20\2\u0119\u0117\3\2\2\2\u0119\u0118\3"+
		"\2\2\2\u011a\35\3\2\2\2\u011b\u011e\5@!\2\u011c\u011e\5$\23\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011c\3\2\2\2\u011e\37\3\2\2\2\u011f\u0120\5\62\32\2\u0120"+
		"\u0121\5\"\22\2\u0121\u0122\5\34\17\2\u0122!\3\2\2\2\u0123\u0124\t\3\2"+
		"\2\u0124#\3\2\2\2\u0125\u012a\5&\24\2\u0126\u0127\7[\2\2\u0127\u0129\5"+
		"&\24\2\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b%\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0132\5(\25\2"+
		"\u012e\u012f\7Z\2\2\u012f\u0131\5(\25\2\u0130\u012e\3\2\2\2\u0131\u0134"+
		"\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\'\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0135\u013a\5*\26\2\u0136\u0137\t\4\2\2\u0137\u0139\5*"+
		"\26\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b)\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u0140\5,\27\2"+
		"\u013e\u013f\7\66\2\2\u013f\u0141\5\f\7\2\u0140\u013e\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141+\3\2\2\2\u0142\u0147\5.\30\2\u0143\u0144\t\5\2\2\u0144"+
		"\u0146\5.\30\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148-\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014f"+
		"\5\60\31\2\u014b\u014c\t\6\2\2\u014c\u014e\5\60\31\2\u014d\u014b\3\2\2"+
		"\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150/"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0157\5\62\32\2\u0153\u0154\t\7\2\2"+
		"\u0154\u0156\5\62\32\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0158\61\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u0162\5\64\33\2\u015b\u015c\7H\2\2\u015c\u0162\5\62\32\2\u015d\u015e"+
		"\7I\2\2\u015e\u0162\5\62\32\2\u015f\u0160\7P\2\2\u0160\u0162\5\62\32\2"+
		"\u0161\u015a\3\2\2\2\u0161\u015b\3\2\2\2\u0161\u015d\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0162\63\3\2\2\2\u0163\u0167\58\35\2\u0164\u0166\5> \2\u0165"+
		"\u0164\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u0178\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016f\5<\37\2\u016b"+
		"\u016f\5\u00b6\\\2\u016c\u016f\7X\2\2\u016d\u016f\7Y\2\2\u016e\u016a\3"+
		"\2\2\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f"+
		"\u0173\3\2\2\2\u0170\u0172\5> \2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2"+
		"\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173"+
		"\3\2\2\2\u0176\u016e\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\65\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c\5\u00ba"+
		"^\2\u017c\u017d\5<\37\2\u017d\u017e\5\u00b6\\\2\u017e\u017f\7G\2\2\u017f"+
		"\67\3\2\2\2\u0180\u0194\5\u00a2R\2\u0181\u0183\5\u00ba^\2\u0182\u0184"+
		"\5\24\13\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0194\3\2\2\2"+
		"\u0185\u0186\7B\2\2\u0186\u0187\5\34\17\2\u0187\u0188\7C\2\2\u0188\u0194"+
		"\3\2\2\2\u0189\u0194\7\'\2\2\u018a\u018b\7\32\2\2\u018b\u018c\5\f\7\2"+
		"\u018c\u018d\5\u00b8]\2\u018d\u0194\3\2\2\2\u018e\u0190\7@\2\2\u018f\u0191"+
		"\5:\36\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0194\7A\2\2\u0193\u0180\3\2\2\2\u0193\u0181\3\2\2\2\u0193\u0185\3\2"+
		"\2\2\u0193\u0189\3\2\2\2\u0193\u018a\3\2\2\2\u0193\u018e\3\2\2\2\u0194"+
		"9\3\2\2\2\u0195\u019a\5\34\17\2\u0196\u0197\7E\2\2\u0197\u0199\5\34\17"+
		"\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b"+
		"\3\2\2\2\u019b;\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\7D\2\2\u019e\u01a0"+
		"\5\u00ba^\2\u019f\u01a1\5\24\13\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1=\3\2\2\2\u01a2\u01a3\7@\2\2\u01a3\u01a4\5\34\17\2\u01a4\u01a5"+
		"\7A\2\2\u01a5?\3\2\2\2\u01a6\u01a7\5B\"\2\u01a7\u01a8\5\u009cO\2\u01a8"+
		"\u01a9\5J&\2\u01a9A\3\2\2\2\u01aa\u01ab\7B\2\2\u01ab\u01b1\7C\2\2\u01ac"+
		"\u01ad\7B\2\2\u01ad\u01ae\5D#\2\u01ae\u01af\7C\2\2\u01af\u01b1\3\2\2\2"+
		"\u01b0\u01aa\3\2\2\2\u01b0\u01ac\3\2\2\2\u01b1C\3\2\2\2\u01b2\u01b7\5"+
		"F$\2\u01b3\u01b4\7E\2\2\u01b4\u01b6\5F$\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9"+
		"\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8E\3\2\2\2\u01b9"+
		"\u01b7\3\2\2\2\u01ba\u01bb\5\u00ba^\2\u01bb\u01bc\7F\2\2\u01bc\u01bd\5"+
		"\f\7\2\u01bdG\3\2\2\2\u01be\u01c3\5\u00ba^\2\u01bf\u01c0\7E\2\2\u01c0"+
		"\u01c2\5\u00ba^\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4I\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6"+
		"\u01c9\5\34\17\2\u01c7\u01c9\5R*\2\u01c8\u01c6\3\2\2\2\u01c8\u01c7\3\2"+
		"\2\2\u01c9K\3\2\2\2\u01ca\u01cb\5T+\2\u01cb\u01cc\7G\2\2\u01cc\u01cf\3"+
		"\2\2\2\u01cd\u01cf\5N(\2\u01ce\u01ca\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cf"+
		"M\3\2\2\2\u01d0\u01d3\5R*\2\u01d1\u01d3\5P)\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d1\3\2\2\2\u01d3O\3\2\2\2\u01d4\u0216\7G\2\2\u01d5\u01d6\5\34\17\2"+
		"\u01d6\u01d7\7G\2\2\u01d7\u0216\3\2\2\2\u01d8\u01d9\7\30\2\2\u01d9\u01da"+
		"\7B\2\2\u01da\u01db\5\34\17\2\u01db\u01dc\7C\2\2\u01dc\u01df\5N(\2\u01dd"+
		"\u01de\7\21\2\2\u01de\u01e0\5N(\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2"+
		"\2\2\u01e0\u0216\3\2\2\2\u01e1\u01e2\7&\2\2\u01e2\u01e3\7B\2\2\u01e3\u01e4"+
		"\5\34\17\2\u01e4\u01e5\7C\2\2\u01e5\u01e9\7>\2\2\u01e6\u01e8\5Z.\2\u01e7"+
		"\u01e6\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2"+
		"\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ed\7?\2\2\u01ed"+
		"\u0216\3\2\2\2\u01ee\u01ef\7-\2\2\u01ef\u01f0\7B\2\2\u01f0\u01f1\5\34"+
		"\17\2\u01f1\u01f2\7C\2\2\u01f2\u01f3\5N(\2\u01f3\u0216\3\2\2\2\u01f4\u01f5"+
		"\7\25\2\2\u01f5\u01f7\7B\2\2\u01f6\u01f8\5`\61\2\u01f7\u01f6\3\2\2\2\u01f7"+
		"\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\7G\2\2\u01fa\u01fc\5\34"+
		"\17\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01ff\7G\2\2\u01fe\u0200\5b\62\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\u0201\3\2\2\2\u0201\u0202\7C\2\2\u0202\u0216\5N(\2\u0203\u0204"+
		"\7\26\2\2\u0204\u0205\7B\2\2\u0205\u0206\5V,\2\u0206\u0207\5\u00ba^\2"+
		"\u0207\u0208\7\61\2\2\u0208\u0209\5\34\17\2\u0209\u020a\7C\2\2\u020a\u020b"+
		"\5N(\2\u020b\u0216\3\2\2\2\u020c\u020d\7\t\2\2\u020d\u0216\7G\2\2\u020e"+
		"\u020f\7\16\2\2\u020f\u0216\7G\2\2\u0210\u0212\7\"\2\2\u0211\u0213\5\34"+
		"\17\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0216\7G\2\2\u0215\u01d4\3\2\2\2\u0215\u01d5\3\2\2\2\u0215\u01d8\3\2"+
		"\2\2\u0215\u01e1\3\2\2\2\u0215\u01ee\3\2\2\2\u0215\u01f4\3\2\2\2\u0215"+
		"\u0203\3\2\2\2\u0215\u020c\3\2\2\2\u0215\u020e\3\2\2\2\u0215\u0210\3\2"+
		"\2\2\u0216Q\3\2\2\2\u0217\u0219\7>\2\2\u0218\u021a\5^\60\2\u0219\u0218"+
		"\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c\7?\2\2\u021c"+
		"S\3\2\2\2\u021d\u021e\5V,\2\u021e\u0223\5X-\2\u021f\u0220\7E\2\2\u0220"+
		"\u0222\5X-\2\u0221\u021f\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2"+
		"\2\u0223\u0224\3\2\2\2\u0224U\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0227"+
		"\t\b\2\2\u0227W\3\2\2\2\u0228\u022b\5\u00ba^\2\u0229\u022a\7F\2\2\u022a"+
		"\u022c\5\f\7\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022f\3\2"+
		"\2\2\u022d\u022e\7R\2\2\u022e\u0230\5\34\17\2\u022f\u022d\3\2\2\2\u022f"+
		"\u0230\3\2\2\2\u0230Y\3\2\2\2\u0231\u0233\5\\/\2\u0232\u0231\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2"+
		"\2\2\u0236\u0237\5^\60\2\u0237[\3\2\2\2\u0238\u0239\7\n\2\2\u0239\u023a"+
		"\5\34\17\2\u023a\u023b\7F\2\2\u023b\u023f\3\2\2\2\u023c\u023d\7\17\2\2"+
		"\u023d\u023f\7F\2\2\u023e\u0238\3\2\2\2\u023e\u023c\3\2\2\2\u023f]\3\2"+
		"\2\2\u0240\u0242\5L\'\2\u0241\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243"+
		"\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244_\3\2\2\2\u0245\u024f\5T+\2\u0246"+
		"\u024b\5\34\17\2\u0247\u0248\7E\2\2\u0248\u024a\5\34\17\2\u0249\u0247"+
		"\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0245\3\2\2\2\u024e\u0246\3\2"+
		"\2\2\u024fa\3\2\2\2\u0250\u0255\5\34\17\2\u0251\u0252\7E\2\2\u0252\u0254"+
		"\5\34\17\2\u0253\u0251\3\2\2\2\u0254\u0257\3\2\2\2\u0255\u0253\3\2\2\2"+
		"\u0255\u0256\3\2\2\2\u0256c\3\2\2\2\u0257\u0255\3\2\2\2\u0258\u025a\7"+
		"\65\2\2\u0259\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025b\3\2\2\2\u025b"+
		"\u025c\7\60\2\2\u025c\u025d\5\u00ba^\2\u025d\u025f\5f\64\2\u025e\u0260"+
		"\7G\2\2\u025f\u025e\3\2\2\2\u025f\u0260\3\2\2\2\u0260e\3\2\2\2\u0261\u0263"+
		"\7>\2\2\u0262\u0264\5h\65\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264"+
		"\u0265\3\2\2\2\u0265\u0266\7?\2\2\u0266g\3\2\2\2\u0267\u0269\5j\66\2\u0268"+
		"\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2"+
		"\2\2\u026bi\3\2\2\2\u026c\u0274\5d\63\2\u026d\u0274\5n8\2\u026e\u026f"+
		"\5T+\2\u026f\u0270\7G\2\2\u0270\u0274\3\2\2\2\u0271\u0274\5\66\34\2\u0272"+
		"\u0274\5l\67\2\u0273\u026c\3\2\2\2\u0273\u026d\3\2\2\2\u0273\u026e\3\2"+
		"\2\2\u0273\u0271\3\2\2\2\u0273\u0272\3\2\2\2\u0274k\3\2\2\2\u0275\u0277"+
		"\7\65\2\2\u0276\u0275\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278\3\2\2\2"+
		"\u0278\u0279\7\63\2\2\u0279\u027a\5\u00aeX\2\u027am\3\2\2\2\u027b\u027d"+
		"\5z>\2\u027c\u027b\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u0280\3\2\2\2\u027e"+
		"\u0281\5\u00a8U\2\u027f\u0281\5\u00aaV\2\u0280\u027e\3\2\2\2\u0280\u027f"+
		"\3\2\2\2\u0281o\3\2\2\2\u0282\u0283\7S\2\2\u0283\u0288\5r:\2\u0284\u0285"+
		"\7E\2\2\u0285\u0287\5r:\2\u0286\u0284\3\2\2\2\u0287\u028a\3\2\2\2\u0288"+
		"\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028b\3\2\2\2\u028a\u0288\3\2"+
		"\2\2\u028b\u028c\7T\2\2\u028cq\3\2\2\2\u028d\u028e\5\u00ba^\2\u028es\3"+
		"\2\2\2\u028f\u0291\7>\2\2\u0290\u0292\5v<\2\u0291\u0290\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\7?\2\2\u0294u\3\2\2\2\u0295"+
		"\u0297\5x=\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0296\3\2\2"+
		"\2\u0298\u0299\3\2\2\2\u0299w\3\2\2\2\u029a\u029c\5z>\2\u029b\u029a\3"+
		"\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\5~@\2\u029e"+
		"y\3\2\2\2\u029f\u02a1\5|?\2\u02a0\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2"+
		"\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3{\3\2\2\2\u02a4\u02a5\t\t\2\2"+
		"\u02a5}\3\2\2\2\u02a6\u02a9\5\u0080A\2\u02a7\u02a9\5\u00acW\2\u02a8\u02a6"+
		"\3\2\2\2\u02a8\u02a7\3\2\2\2\u02a9\177\3\2\2\2\u02aa\u02b1\5\u00aeX\2"+
		"\u02ab\u02b1\5\u00b0Y\2\u02ac\u02b1\5\u00b2Z\2\u02ad\u02ae\5\u0082B\2"+
		"\u02ae\u02af\7G\2\2\u02af\u02b1\3\2\2\2\u02b0\u02aa\3\2\2\2\u02b0\u02ab"+
		"\3\2\2\2\u02b0\u02ac\3\2\2\2\u02b0\u02ad\3\2\2\2\u02b1\u0081\3\2\2\2\u02b2"+
		"\u02b7\5X-\2\u02b3\u02b4\7E\2\2\u02b4\u02b6\5X-\2\u02b5\u02b3\3\2\2\2"+
		"\u02b6\u02b9\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u0083"+
		"\3\2\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02bf\5\u0086D\2\u02bb\u02bc\7N\2\2"+
		"\u02bc\u02be\5\u0086D\2\u02bd\u02bb\3\2\2\2\u02be\u02c1\3\2\2\2\u02bf"+
		"\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u0085\3\2\2\2\u02c1\u02bf\3\2"+
		"\2\2\u02c2\u02c5\5\f\7\2\u02c3\u02c5\7,\2\2\u02c4\u02c2\3\2\2\2\u02c4"+
		"\u02c3\3\2\2\2\u02c5\u0087\3\2\2\2\u02c6\u02c7\5R*\2\u02c7\u0089\3\2\2"+
		"\2\u02c8\u02c9\5\u008cG\2\u02c9\u008b\3\2\2\2\u02ca\u02cf\5\u008eH\2\u02cb"+
		"\u02cc\7E\2\2\u02cc\u02ce\5\u008eH\2\u02cd\u02cb\3\2\2\2\u02ce\u02d1\3"+
		"\2\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u008d\3\2\2\2\u02d1"+
		"\u02cf\3\2\2\2\u02d2\u02d3\5\u00b4[\2\u02d3\u008f\3\2\2\2\u02d4\u02d5"+
		"\7F\2\2\u02d5\u02d6\7/\2\2\u02d6\u02d8\7B\2\2\u02d7\u02d9\5\30\r\2\u02d8"+
		"\u02d7\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02db\7C"+
		"\2\2\u02db\u0091\3\2\2\2\u02dc\u02df\5R*\2\u02dd\u02df\7G\2\2\u02de\u02dc"+
		"\3\2\2\2\u02de\u02dd\3\2\2\2\u02df\u0093\3\2\2\2\u02e0\u02e1\7S\2\2\u02e1"+
		"\u02e6\5\u0096L\2\u02e2\u02e3\7E\2\2\u02e3\u02e5\5\u0096L\2\u02e4\u02e2"+
		"\3\2\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7"+
		"\u02e9\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e9\u02ea\7T\2\2\u02ea\u0095\3\2"+
		"\2\2\u02eb\u02ec\5\u00ba^\2\u02ec\u0097\3\2\2\2\u02ed\u02f9\7>\2\2\u02ee"+
		"\u02f3\5\u009aN\2\u02ef\u02f0\7E\2\2\u02f0\u02f2\5\u009aN\2\u02f1\u02ef"+
		"\3\2\2\2\u02f2\u02f5\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4"+
		"\u02f7\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f6\u02f8\7E\2\2\u02f7\u02f6\3\2"+
		"\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02ee\3\2\2\2\u02f9"+
		"\u02fa\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fc\7?\2\2\u02fc\u0099\3\2"+
		"\2\2\u02fd\u0300\5\u00ba^\2\u02fe\u02ff\7R\2\2\u02ff\u0301\5\34\17\2\u0300"+
		"\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u009b\3\2\2\2\u0302\u0303\7R"+
		"\2\2\u0303\u0304\7T\2\2\u0304\u0305\6O\2\3\u0305\u009d\3\2\2\2\u0306\u0307"+
		"\7T\2\2\u0307\u0308\7T\2\2\u0308\u0309\6P\3\3\u0309\u009f\3\2\2\2\u030a"+
		"\u030b\7T\2\2\u030b\u030c\7`\2\2\u030c\u030d\6Q\4\3\u030d\u00a1\3\2\2"+
		"\2\u030e\u0315\5\u00a4S\2\u030f\u0315\5\u00a6T\2\u0310\u0315\79\2\2\u0311"+
		"\u0315\7:\2\2\u0312\u0315\7;\2\2\u0313\u0315\7\33\2\2\u0314\u030e\3\2"+
		"\2\2\u0314\u030f\3\2\2\2\u0314\u0310\3\2\2\2\u0314\u0311\3\2\2\2\u0314"+
		"\u0312\3\2\2\2\u0314\u0313\3\2\2\2\u0315\u00a3\3\2\2\2\u0316\u0317\t\n"+
		"\2\2\u0317\u00a5\3\2\2\2\u0318\u0319\t\13\2\2\u0319\u00a7\3\2\2\2\u031a"+
		"\u031b\7\f\2\2\u031b\u031d\5\u00ba^\2\u031c\u031e\5p9\2\u031d\u031c\3"+
		"\2\2\2\u031d\u031e\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0321\5t;\2\u0320"+
		"\u0322\7G\2\2\u0321\u0320\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u00a9\3\2"+
		"\2\2\u0323\u0324\7\22\2\2\u0324\u0325\5\u00ba^\2\u0325\u0327\5\u0098M"+
		"\2\u0326\u0328\7G\2\2\u0327\u0326\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u00ab"+
		"\3\2\2\2\u0329\u032a\7\64\2\2\u032a\u032c\7B\2\2\u032b\u032d\5\u008aF"+
		"\2\u032c\u032b\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u032f"+
		"\7C\2\2\u032f\u0330\5\u0092J\2\u0330\u00ad\3\2\2\2\u0331\u0333\5\u00ba"+
		"^\2\u0332\u0334\5p9\2\u0333\u0332\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0335"+
		"\3\2\2\2\u0335\u0337\7B\2\2\u0336\u0338\5\u008aF\2\u0337\u0336\3\2\2\2"+
		"\u0337\u0338\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033a\7C\2\2\u033a\u033b"+
		"\7F\2\2\u033b\u033c\5\u0084C\2\u033c\u033d\3\2\2\2\u033d\u033e\5\u0088"+
		"E\2\u033e\u00af\3\2\2\2\u033f\u0340\7\27\2\2\u0340\u0341\5\u00ba^\2\u0341"+
		"\u0342\7B\2\2\u0342\u0345\7C\2\2\u0343\u0344\7F\2\2\u0344\u0346\5\u0084"+
		"C\2\u0345\u0343\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0347\3\2\2\2\u0347"+
		"\u0348\5\u0088E\2\u0348\u00b1\3\2\2\2\u0349\u034a\7#\2\2\u034a\u034b\5"+
		"\u00ba^\2\u034b\u034c\7B\2\2\u034c\u034d\5\u008aF\2\u034d\u0350\7C\2\2"+
		"\u034e\u034f\7F\2\2\u034f\u0351\5\u0084C\2\u0350\u034e\3\2\2\2\u0350\u0351"+
		"\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0353\5\u0088E\2\u0353\u00b3\3\2\2"+
		"\2\u0354\u0355\5\u00ba^\2\u0355\u0356\7F\2\2\u0356\u0359\5\n\6\2\u0357"+
		"\u0358\7R\2\2\u0358\u035a\5\34\17\2\u0359\u0357\3\2\2\2\u0359\u035a\3"+
		"\2\2\2\u035a\u00b5\3\2\2\2\u035b\u035d\7B\2\2\u035c\u035e\5\30\r\2\u035d"+
		"\u035c\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0360\7C"+
		"\2\2\u0360\u00b7\3\2\2\2\u0361\u0363\7B\2\2\u0362\u0364\5\30\r\2\u0363"+
		"\u0362\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0366\7C"+
		"\2\2\u0366\u00b9\3\2\2\2\u0367\u0368\t\f\2\2\u0368\u00bb\3\2\2\2^\u00bf"+
		"\u00c3\u00c8\u00cc\u00d9\u00e1\u00e9\u00ef\u00fb\u0102\u010d\u0113\u0119"+
		"\u011d\u012a\u0132\u013a\u0140\u0147\u014f\u0157\u0161\u0167\u016e\u0173"+
		"\u0178\u0183\u0190\u0193\u019a\u01a0\u01b0\u01b7\u01c3\u01c8\u01ce\u01d2"+
		"\u01df\u01e9\u01f7\u01fb\u01ff\u0212\u0215\u0219\u0223\u022b\u022f\u0234"+
		"\u023e\u0243\u024b\u024e\u0255\u0259\u025f\u0263\u026a\u0273\u0276\u027c"+
		"\u0280\u0288\u0291\u0298\u029b\u02a2\u02a8\u02b0\u02b7\u02bf\u02c4\u02cf"+
		"\u02d8\u02de\u02e6\u02f3\u02f7\u02f9\u0300\u0314\u031d\u0321\u0327\u032c"+
		"\u0333\u0337\u0345\u0350\u0359\u035d\u0363";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}