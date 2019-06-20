using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class ConstructorDeclaration : Node
    {
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public readonly ChildList<VariableDeclaration> Parameters;
        public readonly ChildProperty<BlockStatement> Body;
        
        public ConstructorDeclaration(IParseTree context, IEnumerable<VariableDeclaration> parameters, BlockStatement body) : base(context)
        {
            Parameters = new ChildList<VariableDeclaration>(this);
            Parameters.AddRange(parameters);
            Body = new ChildProperty<BlockStatement>(this, body);
        }
    }
}