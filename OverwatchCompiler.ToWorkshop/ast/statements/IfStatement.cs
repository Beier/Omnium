using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class IfStatement : Node, IStatement
    {
        public IExpression Condition => Children.OfType<IExpression>().SingleOrDefault();
        public IStatement TrueBranch => Children.OfType<IStatement>().First();
        public IStatement FalseBranch => Children.OfType<IStatement>().Skip(1).FirstOrDefault();
        
        public IfStatement(IParseTree context, IEnumerable<INode> children): base(context, children)
        {
        }
    }
}