using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class GetterDeclaration : Node, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public readonly ChildProperty<ITypeNode> ReturnType;
        public readonly ChildProperty<BlockStatement> Body;

        public GetterDeclaration(IParseTree context, string name, ITypeNode returnType, BlockStatement body) : base(context)
        {
            Name = name;
            ReturnType = new ChildProperty<ITypeNode>(this, returnType);
            Body = new ChildProperty<BlockStatement>(this, body);
        }
    }
}