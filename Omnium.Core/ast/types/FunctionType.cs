﻿using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class FunctionType : Node, ITypeNode
    {
        public IEnumerable<FunctionParameter> Parameters => Children.OfType<FunctionParameter>();
        public ITypeNode ReturnType => Children.OfType<ITypeNode>().SingleOrDefault();

        public FunctionType(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return "(" + Parameters.Select(x => x.Type).MkString(", ") + ") => " + ReturnType;
        }
    }

    public class FunctionParameter : Node
    {
        public string Name { get; set; }
        public ITypeNode Type => Children.OfType<ITypeNode>().SingleOrDefault();

        public FunctionParameter(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}