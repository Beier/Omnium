using System;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class Debug
    {
        public static void CheckForErrorsInParentChildRelationShips(INode node)
        {
            foreach (var child in node.Children)
            {
                if (child.Parent != node)
                    throw new Exception();
                CheckForErrorsInParentChildRelationShips(child);
            }
        }

        public static void CheckChildIsRightType(INode node)
        {

            foreach (var child in node.Children)
            {
                CheckChildIsRightType(child);
            }
        }

        public static void CheckForReferencesToRemovedVariablesa(INode node)
        {
            foreach (var decendant in node.AllDescendantsAndSelf())
            {
                VariableDeclaration variableDeclaration = null;
                switch (decendant)
                {
                    case SimpleNameExpression simpleNameExpression:
                        variableDeclaration = simpleNameExpression.Declaration as VariableDeclaration;
                        break;
                    case MemberExpression simpleNameExpression:
                        variableDeclaration = simpleNameExpression.Declaration as VariableDeclaration;
                        break;
                }
                if (variableDeclaration != null && variableDeclaration.NearestAncestorOfType<Root>() == null)
                    throw new Exception();
            }
        }

        public static void HasConvertStringToBoolean(INode node)
        {
            var root = node.NearestAncestorOfType<Root>();
            foreach (var descendant in root.AllDescendantsAndSelf())
            {
                switch (descendant)
                {
                    case BoolType boolType:
                        if (boolType.Text == "string")
                            throw new Exception();
                        break;
                }
            }
        }
    }
}