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
        public readonly ChildList<Token> Identifiers;
        public INode Declaration { get; set; }

        public ReferenceType(IParseTree context, INode declaration) : base(context)
        {
            Identifiers = new ChildList<Token>(this);
            Declaration = declaration;
        }

        public ReferenceType(IParseTree context, IEnumerable<Token> identifiers) : base(context)
        {
            Identifiers = new ChildList<Token>(this);
            Identifiers.AddRange(identifiers);
        }

        public override string ToString()
        {
            if (Declaration is GenericTypeDeclaration genericTypeDeclaration)
                return genericTypeDeclaration.Name;

            return Declaration.AllAncestorsAndSelf().OfType<INamedDeclaration>().Select(x => x.Name).MkString(".");
        }
    }
}