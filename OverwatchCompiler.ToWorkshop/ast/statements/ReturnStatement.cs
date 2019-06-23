﻿using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class ReturnStatement: Node, IStatement
    {
        public IExpression Value => Children.OfType<IExpression>().SingleOrDefault();

        public ReturnStatement(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            var valueString = Value == null ? null : " " + Value;
            return "return" + valueString + ";";
        }
    }
}