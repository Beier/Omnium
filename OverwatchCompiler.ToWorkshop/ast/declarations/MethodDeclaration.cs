using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class MethodDeclaration : Node, IHasVariables, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public ITypeNode ReturnType => Children.OfType<ITypeNode>().SingleOrDefault();
        public IEnumerable<GenericTypeDeclaration> GenericTypeDeclarations => Children.OfType<GenericTypeDeclaration>();
        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
        public BlockStatement Body => Children.OfType<BlockStatement>().SingleOrDefault();

        public MethodDeclaration(
            IParseTree context, 
            string name,
            IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public override string ToString()
        {
            var sourceFile = this.NearestAncestorOfType<SourceFile>();
            return $"{Name} [{sourceFile?.FileName}: {Position?.Line}, {Position?.Column}]";
        }
    }
}