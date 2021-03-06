﻿using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.statements
{
    public class VariableDeclarationStatement : Node, IStatement
    {
        public VariableDeclaration VariableDeclaration => Children.OfType<VariableDeclaration>().SingleOrDefault();

        public VariableDeclarationStatement(IParseTree context, VariableDeclaration variableDeclaration) : base(context, variableDeclaration.Yield())
        {
        }

        public override string ToString()
        {
            return VariableDeclaration + ";";
        }
    }
}