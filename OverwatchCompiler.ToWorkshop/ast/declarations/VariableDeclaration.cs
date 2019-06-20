using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public enum VariableType
    {
        Const,
        Var,
        Let
    }

    public class VariableDeclaration : Node, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public VariableType? VariableType { get; set; }
        public readonly ChildProperty<ITypeNode> Type;
        public readonly ChildProperty<IExpression> InitExpression;

        public VariableDeclaration(IParseTree context, string name, ITypeNode type, IExpression initExpression) : base(context)
        {
            Name = name;
            Type = new ChildProperty<ITypeNode>(this, type);
            InitExpression = new ChildProperty<IExpression>(this, initExpression);
        }
    }
}