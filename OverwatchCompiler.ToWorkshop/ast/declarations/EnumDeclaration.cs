using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class EnumDeclaration : Node, INamedDeclaration
    {
        public string Name { get; set; }
        public IEnumerable<EnumValue> Values => Children.Cast<EnumValue>();

        public EnumDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }

    public class EnumValue : Node, INamedDeclaration
    {
        public string Name { get; set; }
        public StringLiteral Value => (StringLiteral)Children.SingleOrDefault();

        public EnumValue(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}