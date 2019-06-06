using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.expressions;
using OverwatchCompiler.ToWorkshop.ast2.types;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public enum VariableType
    {
        Const,
        Var,
        Let
    }

    public class VariableDeclaration : Node
    {
        public string Name { get; set; }
        public VariableType? VariableType { get; set; }
        public IType Type { get; set; }
        public readonly ChildProperty<IExpression> InitExpression;

        public VariableDeclaration(IParseTree context, string name, IType type, IExpression initExpression) : base(context)
        {
            Name = name;
            Type = type;
            InitExpression = new ChildProperty<IExpression>(this, initExpression);
        }
    }
}