using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class ObjectCreationExpression : Expression
    {
        public readonly ChildProperty<ITypeNode> CreatedType;
        public readonly ChildList<IExpression> Arguments;

        public ObjectCreationExpression(IParseTree context, ITypeNode createdType, IEnumerable<IExpression> arguments) : base(context)
        {
            CreatedType = new ChildProperty<ITypeNode>(this, createdType);
            Arguments = new ChildList<IExpression>(this);
            Arguments.AddRange(arguments);
        }
    }
}