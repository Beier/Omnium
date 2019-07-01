using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class Assertion : Node, IStatement
    {
        public IExpression Condition => Children.OfType<IExpression>().First();
        public StringLiteral Message => (StringLiteral)Children.OfType<IExpression>().Skip(1).FirstOrDefault();
        public Assertion(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}