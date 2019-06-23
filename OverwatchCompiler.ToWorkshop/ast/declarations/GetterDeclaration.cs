using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class GetterDeclaration : Node, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public ITypeNode ReturnType => Children.OfType<ITypeNode>().SingleOrDefault();
        public BlockStatement Body => Children.OfType<BlockStatement>().Single();

        public GetterDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}