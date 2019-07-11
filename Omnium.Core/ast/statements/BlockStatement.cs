using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.statements
{
    public class BlockStatement : Node, IStatement, IHasVariables
    {
        public readonly List<VariableDeclaration> VariableDeclarations = new List<VariableDeclaration>();
        public IEnumerable<IStatement> Statements => Children.Cast<IStatement>();

        public BlockStatement(IParseTree context, IEnumerable<IStatement> statements) : base(context, statements)
        {
        }
        
        public IEnumerable<VariableDeclaration> Variables => VariableDeclarations;

        public override string ToString()
        {
            return $"{{{Statements.MkString(" ")}}}";
        }
    }
}