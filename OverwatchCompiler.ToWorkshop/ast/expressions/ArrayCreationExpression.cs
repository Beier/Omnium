using System.Collections.Generic;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class ArrayCreationExpression : Expression
    {
        public readonly ChildList<IExpression> InitialItems;

        public ArrayCreationExpression(IParseTree context, IEnumerable<IExpression> initialItems) : base(context)
        {
            InitialItems = new ChildList<IExpression>(this);
            InitialItems.AddRange(initialItems);
        }
    }
}