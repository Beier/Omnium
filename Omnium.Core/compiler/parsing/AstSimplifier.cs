using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.parsing
{
    public class AstSimplifier : TypescriptParserBaseVisitor<IEnumerable<INode>>
    {
        protected override IEnumerable<INode> DefaultResult => Enumerable.Empty<INode>();

        protected override IEnumerable<INode> AggregateResult(IEnumerable<INode> first, IEnumerable<INode> second)
        {
            return first.Concat(second);
        }

        public override IEnumerable<INode> Visit(IParseTree tree)
        {
            try
            {
                if (tree == null)
                    return Enumerable.Empty<INode>();
                return base.Visit(tree).ToList();
            }
            catch (CompilationError)
            {
                throw;
            }
            catch (Exception e)
            {
                throw new CompilationError(tree, "An internal error occured trying to simplify the AST", e);
            }
        }

        public override IEnumerable<INode> VisitSourceFiles(TypescriptParser.SourceFilesContext context)
        {
            var root = new Root(base.VisitSourceFiles(context));
            var sourceFilesByPath = root.SourceFiles.ToDictionary(x => x.Path);

            foreach (var rawSourceFile in context.sourceFile())
            {
                var sourceFile = sourceFilesByPath[rawSourceFile.FilePath];
                foreach (var importDeclaration in sourceFile.ImportedSourceFiles)
                {
                    var importContext = (TypescriptParser.ImportDeclarationContext)importDeclaration.Context;
                    var targetPath = importContext.TargetPath.ToLower();
                    if (!targetPath.EndsWith(".ts"))
                        targetPath += ".ts";
                    importDeclaration.TargetSourceFile = sourceFilesByPath[targetPath];
                }
            }
            yield return root;
        }

        public override IEnumerable<INode> VisitImportDeclaration(TypescriptParser.ImportDeclarationContext context)
        {
            yield return new ImportDeclaration(context, context.identifier().Select(x => new Token(x)));
        }

        public override IEnumerable<INode> VisitSourceFile(TypescriptParser.SourceFileContext context)
        {
            yield return new SourceFile(context, context.FilePath, base.VisitSourceFile(context));
        }

        public override IEnumerable<INode> VisitModuleDeclaration(TypescriptParser.ModuleDeclarationContext context)
        {
            var moduleDeclaration = new ModuleDeclaration(context, context.identifier().GetText(), base.VisitModuleDeclaration(context));
            if (context.EXPORT() != null)
                moduleDeclaration.Modifiers.Add(MemberModifier.Export);
            yield return moduleDeclaration;
        }

        public override IEnumerable<INode> VisitFunctionDeclaration(TypescriptParser.FunctionDeclarationContext context)
        {
            var methodDeclaration = (MethodDeclaration)Visit(context.methodDeclaration()).Single();
            methodDeclaration.Modifiers.Add(MemberModifier.Static);
            if (context.EXPORT() != null)
                methodDeclaration.Modifiers.Add(MemberModifier.Export);
            yield return methodDeclaration;
        }

        public override IEnumerable<INode> VisitEnumDefinition(TypescriptParser.EnumDefinitionContext context)
        {
            yield return new EnumDeclaration(
                context,
                context.identifier().GetText(),
                context.children.SelectMany(Visit).Cast<EnumValue>());
        }

        public override IEnumerable<INode> VisitEnumMemberDeclaration(TypescriptParser.EnumMemberDeclarationContext context)
        {
            yield return new EnumValue(
                context,
                context.identifier().GetText(),
                Visit(context.expression()));
        }

        public override IEnumerable<INode> VisitVariableDeclaration(TypescriptParser.VariableDeclarationContext context)
        {
            var variableDeclarations = context
                .variableDeclarator()
                .SelectMany(Visit)
                .Cast<VariableDeclaration>()
                .ToList();
            var variableType = GetVariableType(context.variableType());

            foreach (var variableDeclaration in variableDeclarations)
            {
                variableDeclaration.VariableType = variableType;
            }

            return variableDeclarations;
        }

        private VariableType? GetVariableType(TypescriptParser.VariableTypeContext context)
        {
            if (context.VAR() != null)
                return VariableType.Var;
            if (context.LET() != null)
                return VariableType.Let;
            if (context.CONST() != null)
                return VariableType.Const;
            return null;
        }

        public override IEnumerable<INode> VisitVariableDeclarator(TypescriptParser.VariableDeclaratorContext context)
        {
            if (context.identifier().GetText() == "header")
                Console.WriteLine();
            yield return new VariableDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitNativeMethodInvocationStatement(TypescriptParser.NativeMethodInvocationStatementContext context)
        {
            yield return new MethodInvocationExpression(
                context,
                new MemberExpression(
                    context.memberAccess(),
                    context.memberAccess().identifier().GetText(),
                    new SimpleNameExpression(context, context.identifier().GetText()).Yield()
                ).Yield()
                    .Concat<INode>(Visit(context.memberAccess().typeArgumentList()).Cast<ITypeNode>())
                    .Concat(Visit(context.methodInvocation()).Cast<IExpression>())
            );
        }

        public override IEnumerable<INode> VisitClassDefinition(TypescriptParser.ClassDefinitionContext context)
        {
            yield return new ClassDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitClassMemberDeclaration(TypescriptParser.ClassMemberDeclarationContext context)
        {
            var declaration = Visit(context.commonMemberDeclaration()).SingleOrDefault();
            var modifiers = ParseModifiers(context.allMemberModifiers()).ToList();
            switch (declaration)
            {
                case ConstructorDeclaration constructorDeclaration:
                    constructorDeclaration.Modifiers.AddRange(modifiers);
                    break;
                case GetterDeclaration getterDeclaration:
                    getterDeclaration.Modifiers.AddRange(modifiers);
                    break;
                case SetterDeclaration setterDeclaration:
                    setterDeclaration.Modifiers.AddRange(modifiers);
                    break;
                case MethodDeclaration methodDeclaration:
                    methodDeclaration.Modifiers.AddRange(modifiers);
                    break;
                case VariableDeclaration variableDeclaration:
                    variableDeclaration.Modifiers.AddRange(modifiers);
                    break;
            }

            yield return declaration;
        }

        public override IEnumerable<INode> VisitTypeDeclaration(TypescriptParser.TypeDeclarationContext context)
        {
            var modifiers = ParseModifiers(context.allMemberModifiers());
            if (context.classDefinition() != null)
            {
                var classDeclaration = (ClassDeclaration) Visit(context.classDefinition()).Single();
                classDeclaration.Modifiers.AddRange(modifiers);
                yield return classDeclaration;
            }
            else if (context.enumDefinition() != null)
            {
                var enumDeclaration = (EnumDeclaration) Visit(context.enumDefinition()).Single();
                enumDeclaration.Modifiers.AddRange(modifiers);
                yield return enumDeclaration;
            }
        }

        private IEnumerable<MemberModifier> ParseModifiers(TypescriptParser.AllMemberModifiersContext context)
        {
            return context?.allMemberModifier().Select(modifier =>
            {
                switch (modifier.GetText())
                {
                    case "public":
                        return MemberModifier.Public;
                    case "private":
                        return MemberModifier.Private;
                    case "static":
                        return MemberModifier.Static;
                    case "readonly":
                        return MemberModifier.Readonly;
                    case "export":
                        return MemberModifier.Export;
                    default:
                        throw new Exception();
                }
            }) ?? Enumerable.Empty<MemberModifier>();
        }

        public override IEnumerable<INode> VisitConstructorDeclaration(TypescriptParser.ConstructorDeclarationContext context)
        {
            yield return new ConstructorDeclaration(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitMethodDeclaration(TypescriptParser.MethodDeclarationContext context)
        {
            if (context.identifier().GetText() == "createHudText")
                Console.WriteLine();
            yield return new MethodDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }


        public override IEnumerable<INode> VisitGetterDeclaration(TypescriptParser.GetterDeclarationContext context)
        {
            yield return new GetterDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSetterDeclaration(TypescriptParser.SetterDeclarationContext context)
        {
            yield return new SetterDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitArgDeclaration(TypescriptParser.ArgDeclarationContext context)
        {
            if (context.identifier().GetText() == "header")
                Console.WriteLine();
            yield return new VariableDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitTypeParameter(TypescriptParser.TypeParameterContext context)
        {
            yield return new GenericTypeDeclaration(context, context.identifier().GetText(), Visit(context.type()));
        }

        public override IEnumerable<INode> VisitBlock(TypescriptParser.BlockContext context)
        {
            yield return new BlockStatement(
                context,
                Visit(context.statementList()).Cast<IStatement>());
        }

        public override IEnumerable<INode> VisitDeclarationStatement(TypescriptParser.DeclarationStatementContext context)
        {
            return Visit(context.variableDeclaration())
                .Cast<VariableDeclaration>()
                .Select(variableDeclaration => new VariableDeclarationStatement(context, variableDeclaration));
        }

        public override IEnumerable<INode> VisitExpressionStatement(TypescriptParser.ExpressionStatementContext context)
        {
            yield return new ExpressionStatement(
                context,
                (IExpression)Visit(context.expression()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitIfStatement(TypescriptParser.IfStatementContext context)
        {
            yield return new IfStatement(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSwitchStatement(TypescriptParser.SwitchStatementContext context)
        {
            yield return new SwitchStatement(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSwitchSection(TypescriptParser.SwitchSectionContext context)
        {
            yield return new SwitchGroup(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSwitchLabel(TypescriptParser.SwitchLabelContext context)
        {
            yield return new SwitchLabel(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitWhileStatement(TypescriptParser.WhileStatementContext context)
        {
            yield return new WhileStatement(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitForStatement(TypescriptParser.ForStatementContext context)
        {
            var inits = Visit(context.forInitializer()).ToList();
            var condition = (IExpression)Visit(context.expression()).SingleOrDefault();
            var nextExpressions = Visit(context.forIterator()).Cast<IExpression>();
            var body = (IStatement)Visit(context.embeddedStatement()).SingleOrDefault();

            yield return new ForStatement(
                context,
                inits.OfType<VariableDeclaration>(),
                inits.OfType<IExpression>(),
                condition,
                nextExpressions,
                body);
        }

        public override IEnumerable<INode> VisitForeachStatement(TypescriptParser.ForeachStatementContext context)
        {
            var variableDeclaration = new VariableDeclaration(context, context.identifier().GetText(), new INode[0])
            {
                VariableType = GetVariableType(context.variableType())
            };
            var arrayExpression = Visit(context.expression()).Single();
            var body = Visit(context.embeddedStatement()).Single();


            yield return new ForeachStatement(context, new []{variableDeclaration, arrayExpression, body});
        }

        public override IEnumerable<INode> VisitBreakStatement(TypescriptParser.BreakStatementContext context)
        {
            yield return new BreakStatement(context);
        }

        public override IEnumerable<INode> VisitContinueStatement(TypescriptParser.ContinueStatementContext context)
        {
            yield return new ContinueStatement(context);
        }

        public override IEnumerable<INode> VisitReturnStatement(TypescriptParser.ReturnStatementContext context)
        {
            yield return new ReturnStatement(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitAssignment(TypescriptParser.AssignmentContext context)
        {
            yield return new AssignmentExpression(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitAssignmentOperator(TypescriptParser.AssignmentOperatorContext context)
        {
            yield return new AssignmentOperator(context, context.GetText());
        }

        public override IEnumerable<INode> VisitConditionalOrExpression(TypescriptParser.ConditionalOrExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.conditionalAndExpression(), context.OP_OR());
        }

        public override IEnumerable<INode> VisitConditionalAndExpression(TypescriptParser.ConditionalAndExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.equalityExpression(), context.OP_AND());
        }

        public override IEnumerable<INode> VisitEqualityExpression(TypescriptParser.EqualityExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.castExpression(), context.OP_EQ().Concat(context.OP_NE()));
        }

        public override IEnumerable<INode> VisitCastExpression(TypescriptParser.CastExpressionContext context)
        {
            if (context.type() == null)
                return VisitChildren(context);
            return new CastExpression(context, VisitChildren(context)).Yield();
        }

        public override IEnumerable<INode> VisitRelationalExpression(TypescriptParser.RelationalExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.additiveExpression(), context.GT().Concat(context.LT()).Concat(context.OP_GE()).Concat(context.OP_LE()));
        }

        public override IEnumerable<INode> VisitAdditiveExpression(TypescriptParser.AdditiveExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.multiplicativeExpression(), context.PLUS().Concat(context.MINUS()));
        }

        public override IEnumerable<INode> VisitMultiplicativeExpression(TypescriptParser.MultiplicativeExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.unaryExpression(), context.DIV().Concat(context.PERCENT()).Concat(context.STAR()));
        }

        public override IEnumerable<INode> VisitUnaryExpression(TypescriptParser.UnaryExpressionContext context)
        {
            if (context.primaryExpression() != null)
                yield return (IExpression)Visit(context.primaryExpression()).SingleOrDefault();
            else
            {
                var token = CreateToken(context.PLUS() ?? context.MINUS() ?? context.BANG());
                var @base = (IExpression)Visit(context.unaryExpression()).SingleOrDefault();
                yield return new UnaryExpression(context, new INode[] { token, @base });
            }
        }

        public override IEnumerable<INode> VisitPrimaryExpression(TypescriptParser.PrimaryExpressionContext context)
        {
            var @base = (IExpression)Visit(context.primaryExpressionStart()).SingleOrDefault();
            var operations = context.bracketExpression()
                .Concat<IParseTree>(context.memberAccess())
                .Concat(context.methodInvocation())
                .Concat(context.OP_INC())
                .Concat(context.OP_DEC())
                .OrderBy(x => x.GetTokens().First().Line)
                .ThenBy(x => x.GetTokens().First().Column);

            foreach (var operation in operations)
            {
                if (operation is TypescriptParser.BracketExpressionContext bracketExpression)
                    @base = new ArrayIndexExpression(bracketExpression, @base.Yield().Concat(Visit(bracketExpression)));
                else if (operation is TypescriptParser.MemberAccessContext memberAccess)
                    @base = new MemberExpression(memberAccess, memberAccess.identifier().GetText(), @base.Yield());
                else if (operation is TypescriptParser.MethodInvocationContext methodInvocation)
                {
                    var genericTypeArguments = Visit((@base.Context as TypescriptParser.MemberAccessContext)?.typeArgumentList()).Cast<ITypeNode>();
                    var arguments = Visit(methodInvocation.argumentList()).Cast<IExpression>();

                    @base = new MethodInvocationExpression(
                        methodInvocation,
                        @base.Yield().Concat<INode>(genericTypeArguments).Concat(arguments));
                }
                else if (operation is ITerminalNode terminalNode)
                {
                    @base = new PosfixOperationExpression(terminalNode, new INode[] { @base, new Token(terminalNode) });
                }
                else
                    throw new Exception("Unexpected operation: " + operation);
            }

            yield return @base;
        }

        public override IEnumerable<INode> VisitLambdaExpression(TypescriptParser.LambdaExpressionContext context)
        {
            var children = VisitChildren(context).ToList();
            var variables = children.OfType<VariableDeclaration>();
            var expressionBody = children.OfType<IExpression>().SingleOrDefault();
            var blockBody = children.OfType<BlockStatement>().SingleOrDefault()
                            ?? new BlockStatement(context, new ReturnStatement(context, expressionBody.Yield()).Yield());
            yield return new LambdaExpression(context, variables.Concat<INode>(blockBody.Yield()));
        }

        public override IEnumerable<INode> VisitAnonymousFunctionSignature(TypescriptParser.AnonymousFunctionSignatureContext context)
        {
            if (context.identifier() != null)
                return new VariableDeclaration(context.identifier(), context.identifier().GetText(), new INode[0]).Yield();
            return base.VisitAnonymousFunctionSignature(context);
        }

        public override IEnumerable<INode> VisitExplicitAnonymousFunctionParameter(TypescriptParser.ExplicitAnonymousFunctionParameterContext context)
        {
            yield return new VariableDeclaration(context, context.identifier().GetText(), Visit(context.type()));
        }

        public override IEnumerable<INode> VisitImplicitAnonymousFunctionParameterList(TypescriptParser.ImplicitAnonymousFunctionParameterListContext context)
        {
            return context.identifier()
                .Select(identifier => new VariableDeclaration(identifier, identifier.GetText(), new INode[0]));
        }

        public override IEnumerable<INode> VisitSimpleNameExpression(TypescriptParser.SimpleNameExpressionContext context)
        {
            yield return new SimpleNameExpression(context, context.identifier().GetText());
        }

        public override IEnumerable<INode> VisitThisReferenceExpression(TypescriptParser.ThisReferenceExpressionContext context)
        {
            yield return new ThisExpression(context);
        }

        public override IEnumerable<INode> VisitObjectCreation(TypescriptParser.ObjectCreationContext context)
        {
            yield return new ObjectCreationExpression(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitArrayCreationExpression(TypescriptParser.ArrayCreationExpressionContext context)
        {
            yield return new ArrayCreationExpression(
                context,
                Visit(context.expressionList()).Cast<IExpression>());
        }

        private IExpression CreateBinaryExpression(IParseTree context, IEnumerable<IParseTree> expressions, IEnumerable<IParseTree> tokens)
        {
            var subExpressions = expressions.SelectMany(Visit).Cast<IExpression>().ToArray();
            var operators = tokens.Select(CreateToken).OrderBy(x => x.Line).ThenBy(x => x.Column).ToArray();

            var previous = subExpressions[0];
            for (int i = 1; i < subExpressions.Length; i++)
            {
                previous = new BinaryExpression(
                    context,
                    new INode[]
                    {
                        previous,
                        operators[i - 1],
                        subExpressions[i]
                    });
            }

            return previous;
        }

        private Token CreateToken(IParseTree node)
        {
            return new Token(node);
        }



        public override IEnumerable<INode> VisitLiteral(TypescriptParser.LiteralContext context)
        {
            if (context.booleanLiteral() != null)
                yield return new BooleanLiteral(context);
            if (context.stringLiteral() != null)
                yield return new StringLiteral(context);
            if (context.INTEGER_LITERAL() != null)
                yield return new NumberLiteral(context);
            if (context.HEX_INTEGER_LITERAL() != null)
            {
                var hex = context.GetText();
                var number = Convert.ToInt32(hex, 16);
                yield return new NumberLiteral(context, number.ToString());
            }
            if (context.REAL_LITERAL() != null)
                yield return new NumberLiteral(context);
            if (context.NULL() != null)
                yield return new NullLiteral(context);
        }


        public override IEnumerable<INode> VisitTypeList(TypescriptParser.TypeListContext context)
        {
            var subTypes = context.typeInOptionalParenthesis().SelectMany(Visit).Cast<ITypeNode>().ToArray();
            if (subTypes.Length == 1)
                yield return subTypes[0];
            else
                yield return new TypeList(context, subTypes);
        }

        public override IEnumerable<INode> VisitReturnTypeList(TypescriptParser.ReturnTypeListContext context)
        {
            var subTypes = context.returnType().SelectMany(Visit).Cast<ITypeNode>().ToArray();
            if (subTypes.Length == 1)
                yield return subTypes[0];
            else
                yield return new TypeList(context, subTypes);
        }

        public override IEnumerable<INode> VisitType(TypescriptParser.TypeContext context)
        {
            var @base = (ITypeNode)Visit(context.baseType()).SingleOrDefault();
            for (int i = 0; i < context.OPEN_BRACKET().Length; i++)
            {
                @base = new ArrayType(context, @base);
            }

            yield return @base;
        }

        public override IEnumerable<INode> VisitPrimitiveType(TypescriptParser.PrimitiveTypeContext context)
        {
            if (context.NUMBER() != null)
                yield return new NumberType(context);
            if (context.BOOL() != null)
                yield return new BoolType(context);
            if (context.STRING() != null)
                yield return new StringType(context);
        }

        public override IEnumerable<INode> VisitClassType(TypescriptParser.ClassTypeContext context)
        {
            var baseType = (ITypeNode)Visit(context.moduleOrTypeName()).Single();
            var genericTypeArguments = Visit(context.typeArgumentList()).Cast<ITypeNode>().ToList();

            if (genericTypeArguments.Any())
                yield return new GenericType(context, baseType.Yield().Concat(genericTypeArguments));
            else
                yield return baseType;
        }

        public override IEnumerable<INode> VisitModuleOrTypeName(TypescriptParser.ModuleOrTypeNameContext context)
        {
            yield return new ReferenceType(
                context,
                context.identifier().Select(CreateToken));
        }

        public override IEnumerable<INode> VisitReturnType(TypescriptParser.ReturnTypeContext context)
        {
            if (context.VOID() != null)
                yield return new VoidType(context);
            else
                yield return Visit(context.type()).SingleOrDefault();
        }

        public override IEnumerable<INode> VisitFunctionType(TypescriptParser.FunctionTypeContext context)
        {
            var children = VisitChildren(context);

            children = children.Select(child =>
            {
                switch (child)
                {
                    case VariableDeclaration variableDeclaration:
                        return new FunctionParameter(variableDeclaration.Context, variableDeclaration.Children);
                    default:
                        return child;
                }
            });

            yield return new FunctionType(context, children);
        }
    }
}