using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class GotoStatement : Node, IStatement
    {
        public IExpression Condition => Children.OfType<IExpression>().SingleOrDefault();
        public GotoTargetStatement TargetStatement { get; set; }

        public GotoStatement(IParseTree context, GotoTargetStatement targetStatement) : base(context)
        {
            TargetStatement = targetStatement;
        }

        public GotoStatement(IParseTree context, IExpression condition, GotoTargetStatement targetStatement) : base(context, condition.Yield())
        {
            TargetStatement = targetStatement;
        }

        public override string ToString()
        {
            var conditionString = Condition == null ? null : " (if " + Condition + ")";
            return "goto " + TargetStatement + conditionString;
        }
    }
}