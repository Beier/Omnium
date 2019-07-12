using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions
{
    public class PlayerVarsExpression : Expression
    {
        public IExpression Player => Children.OfType<IExpression>().Single();
        public ITypeNode ReturnType => Children.OfType<ITypeNode>().Single();

        public PlayerVarsExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }

    public class PlayerVarsPlayerExpression : Expression
    {
        public IExpression thisExpression => Children.OfType<IExpression>().Single();

        public PlayerVarsPlayerExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}