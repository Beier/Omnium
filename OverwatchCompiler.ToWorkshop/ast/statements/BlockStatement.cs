using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class BlockStatement : Node, IStatement, IHasVariables
    {
        public readonly List<VariableDeclaration> VariableDeclarations = new List<VariableDeclaration>();
        public readonly ChildList<IStatement> Statements;

        public BlockStatement(IParseTree context, IEnumerable<IStatement> statements) : base(context)
        {
            Statements = new ChildList<IStatement>(this);
            Statements.AddRange(statements);
        }
        
        public IEnumerable<VariableDeclaration> Variables => VariableDeclarations;
    }
}