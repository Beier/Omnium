using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class MethodInvocationExpression : Expression
    {
        public readonly ChildProperty<IExpression> Base;
        public readonly ChildList<ITypeNode> GenericTypes;
        public readonly ChildList<IExpression> Arguments;

        public MethodInvocationExpression(IParseTree context, IExpression @base, IEnumerable<ITypeNode> genericTypes, IEnumerable<IExpression> arguments) : base(context)
        {
            Base = new ChildProperty<IExpression>(this, @base);
            GenericTypes = new ChildList<ITypeNode>(this);
            GenericTypes.AddRange(genericTypes);
            Arguments = new ChildList<IExpression>(this);
            Arguments.AddRange(arguments);
        }
    }
}