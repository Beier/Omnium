using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.statements;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class ConstructorDeclaration : Node
    {
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