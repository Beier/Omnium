using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2;
using OverwatchCompiler.ToWorkshop.ast2.declarations;
using OverwatchCompiler.ToWorkshop.ast2.expressions;
using OverwatchCompiler.ToWorkshop.ast2.statements;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class AstSimplifier : TypescriptParserBaseVisitor<IEnumerable<INode>>
    {
        protected override IEnumerable<INode> DefaultResult => Enumerable.Empty<INode>();

        protected override IEnumerable<INode> AggregateResult(IEnumerable<INode> first, IEnumerable<INode> second)
        {
            return first.Concat(second);
        }

        public override IEnumerable<INode> VisitSourceFiles(TypescriptParser.SourceFilesContext context)
        {
            var root = new Root();
            var sourceFilesByPath = context.sourceFile().ToDictionary(x => x.FilePath, x => (SourceFile)Visit(x));

            root.SourceFiles.AddRange(sourceFilesByPath.Values);
            foreach (var rawSourceFile in context.sourceFile())
            {
                var sourceFile = sourceFilesByPath[rawSourceFile.FilePath];
                sourceFile.ImportedSourceFiles.AddRange(rawSourceFile.importDeclaration().Select(x => sourceFilesByPath[x.TargetPath]));
            }
            yield return root;
        }

        public override IEnumerable<INode> VisitSourceFile(TypescriptParser.SourceFileContext context)
        {
            var sourceFile = new SourceFile(context, context.FilePath);

            foreach (var childNode in context.children.SelectMany(Visit))
            {
                if (childNode is ClassDeclaration classDeclaration)
                    sourceFile.ClassDeclarations.Add(classDeclaration);
                else if (childNode is VariableDeclaration variableDeclaration)
                    sourceFile.VariableDeclarations.Add(variableDeclaration);
                else if (childNode is ModuleDeclaration moduleDeclaration)
                    sourceFile.ModuleDeclarations.Add(moduleDeclaration);
                else if (childNode is MethodInvocationExpression methodInvocation)
                    sourceFile.MethodInvocations.Add(methodInvocation);
                else if (childNode is EnumDeclaration enumDeclaration)
                    sourceFile.EnumDeclarations.Add(enumDeclaration);
                else
                    throw new CompilationError(childNode.Context, "Unknown source file member: " + childNode.GetType().Name);
            }

            yield return sourceFile;
        }

        public override IEnumerable<INode> VisitModuleDeclaration(TypescriptParser.ModuleDeclarationContext context)
        {
            var module = new ModuleDeclaration(context, context.identifier().GetText());

            foreach (var childNode in context.children.SelectMany(Visit))
            {
                if (childNode is ClassDeclaration classDeclaration)
                    module.ClassDeclarations.Add(classDeclaration);
                else if (childNode is VariableDeclaration variableDeclaration)
                    module.VariableDeclarations.Add(variableDeclaration);
                else if (childNode is ModuleDeclaration moduleDeclaration)
                    module.ModuleDeclarations.Add(moduleDeclaration);
                else if (childNode is MethodInvocationExpression methodInvocation)
                    module.MethodInvocations.Add(methodInvocation);
                else if (childNode is EnumDeclaration enumDeclaration)
                    module.EnumDeclarations.Add(enumDeclaration);
                else
                    throw new CompilationError(childNode.Context, "Unknown module member:" + childNode.GetType().Name);
            }

            yield return module;
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
                (IExpression)Visit(context.expression()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitVariableDeclaration(TypescriptParser.VariableDeclarationContext context)
        {
            var variableDeclarations = context
                .variableDeclarator()
                .SelectMany(Visit)
                .Cast<VariableDeclaration>()
                .ToList();
            VariableType? variableType = null;
            if (context.variableType().VAR() != null)
                variableType = VariableType.Var;
            if (context.variableType().LET() != null)
                variableType = VariableType.Let;
            if (context.variableType().CONST() != null)
                variableType = VariableType.Const;

            foreach (var variableDeclaration in variableDeclarations)
            {
                variableDeclaration.VariableType = variableType;
            }

            return variableDeclarations;
        }

        public override IEnumerable<INode> VisitVariableDeclarator(TypescriptParser.VariableDeclaratorContext context)
        {
            yield return new VariableDeclaration(
                context,
                context.identifier().GetText(),
                (ast2.types.IType)Visit(context.type()).SingleOrDefault(),
                (IExpression)Visit(context.expression()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitNativeMethodInvocationStatement(TypescriptParser.NativeMethodInvocationStatementContext context)
        {
            yield return new MethodInvocationExpression(
                context,
                new MemberExpression(
                    context.memberAccess(),
                    new SimpleNameExpression(context, context.identifier().GetText()), 
                    context.memberAccess().identifier().GetText()
                    ), 
                    Visit(context.methodInvocation()).Cast<IExpression>()
                );
        }

        public override IEnumerable<INode> VisitClassDefinition(TypescriptParser.ClassDefinitionContext context)
        {
            var classDeclaration = new ClassDeclaration(context, context.identifier().GetText());

            foreach (var childNode in context.children.SelectMany(Visit))
            {
                if (childNode is VariableDeclaration variableDeclaration)
                    classDeclaration.VariableDeclarations.Add(variableDeclaration);
                else if (childNode is MethodDeclaration methodDeclaration)
                    classDeclaration.MethodDeclaration.Add(methodDeclaration);
                else if (childNode is ConstructorDeclaration constructorDeclaration)
                    classDeclaration.Constructors.Add(constructorDeclaration);
                else
                    throw new CompilationError(childNode.Context, "Unknown class member: " + childNode.GetType().Name);
            }

            yield return classDeclaration;
        }

        public override IEnumerable<INode> VisitConstructorDeclaration(TypescriptParser.ConstructorDeclarationContext context)
        {
            yield return new ConstructorDeclaration(
                context,
                Visit(context.formalParameterList()).Cast<VariableDeclaration>(),
                (BlockStatement) Visit(context.body()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitMethodDeclaration(TypescriptParser.MethodDeclarationContext context)
        {
            yield return new MethodDeclaration(
                context,
                context.identifier().GetText(),
                Visit(context.typeParameterList()).Cast<GenericTypeDeclaration>(),
                Visit(context.formalParameterList()).Cast<VariableDeclaration>(),
                (BlockStatement)Visit(context.methodBody()).SingleOrDefault()
                );
        }

        public override IEnumerable<INode> VisitTypeParameter(TypescriptParser.TypeParameterContext context)
        {
            yield return new GenericTypeDeclaration(context, context.identifier().GetText());
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
            var condition = (IExpression)Visit(context.expression()).SingleOrDefault();
            var branches = context.embeddedStatement().SelectMany(Visit).Cast<IStatement>().ToList();
            yield return new IfStatement(
                context,
                condition,
                branches.First(),
                branches.Skip(1).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitSwitchStatement(TypescriptParser.SwitchStatementContext context)
        {
            yield return new SwitchStatement(
                context,
                (IExpression)Visit(context.expression()).SingleOrDefault(),
                context.switchSection().SelectMany(Visit).Cast<SwitchGroup>());
        }

        public override IEnumerable<INode> VisitSwitchSection(TypescriptParser.SwitchSectionContext context)
        {
            yield return new SwitchGroup(
                context, 
                context.switchLabel().SelectMany(Visit).Cast<SwitchLabel>(),
                Visit(context.statementList()).Cast<IStatement>());
        }

        public override IEnumerable<INode> VisitSwitchLabel(TypescriptParser.SwitchLabelContext context)
        {
            yield return new SwitchLabel(context, (IExpression)Visit(context.expression()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitWhileStatement(TypescriptParser.WhileStatementContext context)
        {
            yield return new WhileStatement(
                context,
                (IExpression)Visit(context.expression()).SingleOrDefault(),
                (IStatement)Visit(context.embeddedStatement()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitForStatement(TypescriptParser.ForStatementContext context)
        {
            var inits = Visit(context.forInitializer()).ToList();
            var condition = (IExpression) Visit(context.expression()).SingleOrDefault();
            var nextExpressions = Visit(context.forIterator()).Cast<IExpression>();
            var body = (IStatement) Visit(context.embeddedStatement()).SingleOrDefault();

            yield return new ForStatement(
                context,
                inits.OfType<VariableDeclaration>(),
                inits.OfType<IExpression>(),
                condition,
                nextExpressions,
                body);
        }
    }
}