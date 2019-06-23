using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class ReferenceType : Node, ITypeNode
    {
        public IEnumerable<Token> Identifiers => Children.OfType<Token>();
        public INode Declaration { get; set; }

        public ReferenceType(IParseTree context, INode declaration) : base(context)
        {
            Declaration = declaration;
        }

        public ReferenceType(IParseTree context, IEnumerable<Token> identifiers) : base(context, identifiers)
        {
        }

        public override string ToString()
        {
            if (Declaration is GenericTypeDeclaration genericTypeDeclaration)
                return genericTypeDeclaration.Name;

            return Declaration.AllAncestorsAndSelf().OfType<INamedDeclaration>().Select(x => x.Name).MkString(".");
        }
    }
}