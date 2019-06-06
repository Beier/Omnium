using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.declarations;

namespace OverwatchCompiler.ToWorkshop.ast2.statements
{
    public class BlockStatement : Node, IStatement
    {
        public readonly List<VariableDeclaration> VariableDeclarations = new List<VariableDeclaration>();
        public readonly ChildList<IStatement> Statements;

        public BlockStatement(IParseTree context, IEnumerable<IStatement> statements) : base(context)
        {
            Statements = new ChildList<IStatement>(this);
            Statements.AddRange(statements);
        }
    }
}