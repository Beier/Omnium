﻿using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class RuleDeclaration : Node, INamedDeclaration
    {
        public string Name { get; }
        public IExpression Trigger => Children.OfType<IExpression>().First();
        public IExpression Condition => Children.OfType<IExpression>().Skip(1).First();
        public LambdaExpression Action =>(LambdaExpression)Children.OfType<IExpression>().Last();
        public VariableDeclaration StateVariable => Children.OfType<VariableDeclaration>().SingleOrDefault();
        public int NumberOfStates { get; set; }

        public RuleDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}