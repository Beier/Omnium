using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.statements;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.expressions
{
    public class LambdaExpression : Expression, IHasVariables
    {
        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
        public BlockStatement Block => Children.OfType<BlockStatement>().SingleOrDefault();

        public LambdaExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return $"({Variables.MkString(",")}) => {Block}";
        }
    }
}