using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step1Parsing.astSimplifier
{
    public partial class AstSimplifier
    {
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