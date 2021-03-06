﻿using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.declarations
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
        public ITypeNode Type => Children.OfType<ITypeNode>().SingleOrDefault();
        public bool IsChased = false;

        public IExpression InitExpression => Children.OfType<IExpression>().SingleOrDefault();


        public VariableDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public override string ToString()
        {
            var varTypeString = VariableType?.ToString() ?? "var";
            var typeString = Type == null ? null : ": " + Type;
            var initializerString = InitExpression == null ? null : " = " + InitExpression;
            return varTypeString + " " + Name + typeString + initializerString;
        }
    }
}