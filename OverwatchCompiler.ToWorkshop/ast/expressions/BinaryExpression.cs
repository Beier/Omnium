using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class BinaryExpression: Expression
    {
        public IExpression Left => Children.OfType<IExpression>().First();
        public Token Operator => Children.Skip(1).OfType<Token>().NotOfType(typeof(IExpression)).SingleOrDefault();
        public IExpression Right => Children.OfType<IExpression>().Last();

        public BinaryExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return "(" + Left + " " + Operator + " " + Right + ")";
        }
    }
}