using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.statements;

namespace Omnium.Core.compiler.step3FeatureSimplification
{
    public class BlockFlattener
    {
        public static void FlattenAllSubBlocks(INode statement)
        {
            if (!(statement is IStatement))
                return;
            if (statement is BlockStatement)
            {
                var childBlockStatements = statement.Children.OfType<BlockStatement>().ToList();
                foreach (var childBlockStatement in childBlockStatements)
                {
                    foreach (var subStatement in childBlockStatement.Statements.ToList())
                    {
                        subStatement.Remove();
                        statement.AddChildBefore(childBlockStatement, subStatement);
                    }
                    childBlockStatement.Remove();
                }
            }

            foreach (var child in statement.Children)
            {
                FlattenAllSubBlocks(child);
            }
        }
    }
}