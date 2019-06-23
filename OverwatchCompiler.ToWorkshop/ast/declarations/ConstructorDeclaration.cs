using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class ConstructorDeclaration : Node
    {
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public IEnumerable<VariableDeclaration> Parameters => Children.OfType<VariableDeclaration>();
        public BlockStatement Body => Children.OfType<BlockStatement>().Single();
        
        public ConstructorDeclaration(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}