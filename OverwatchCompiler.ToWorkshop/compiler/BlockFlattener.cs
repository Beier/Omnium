﻿using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.compiler
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