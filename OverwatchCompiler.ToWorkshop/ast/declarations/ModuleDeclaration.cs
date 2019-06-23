using System.Collections.Generic;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class ModuleDeclaration : AbstractTopLevelNode, INamedDeclaration
    {
        public string Name { get; set; }

        public ModuleDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}