using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class LambdaExpression : Expression, IHasVariables
    {
        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
        public BlockStatement Block => Children.OfType<BlockStatement>().SingleOrDefault();

        public LambdaExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}