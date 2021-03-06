﻿using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.statements;

namespace Omnium.Core.ast.declarations
{
    public class SetterDeclaration : Node, IHasVariables, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public VariableDeclaration Parameter => Variables.SingleOrDefault();
        public BlockStatement Body => Children.OfType<BlockStatement>().SingleOrDefault();

        public SetterDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
    }
}