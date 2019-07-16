using System;
using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step1Parsing.astSimplifier
{
    public partial class AstSimplifier
    {

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
            yield return new VariableDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
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
            yield return new VariableDeclaration(
                context,
                context.identifier().GetText(),
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitTypeParameter(TypescriptParser.TypeParameterContext context)
        {
            yield return new GenericTypeDeclaration(context, context.identifier().GetText(), Visit(context.type()));
        }
    }
}