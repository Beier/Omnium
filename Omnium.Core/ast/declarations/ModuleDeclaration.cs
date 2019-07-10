using System.Collections.Generic;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.declarations
{
    public class ModuleDeclaration : AbstractTopLevelNode, INamedDeclaration, ITypeDeclaration
    {
        public string Name { get; set; }
        public List<MemberModifier> Modifiers = new List<MemberModifier>();

        public ModuleDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}