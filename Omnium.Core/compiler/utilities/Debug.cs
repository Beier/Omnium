using System;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;

namespace Omnium.Core.compiler.utilities
{
    public class Debug
    {
        public static void CheckForInvalidExpressionParentsa(INode node)
        {
            foreach (var child in node.Children)
            {
                if (child is Expression && !(child.Parent is ExpressionStatement || child.Parent is ReturnStatement || child.Parent is SourceFile
                                             || child.Parent is IExpression || child.Parent is VariableDeclaration || child.Parent is IfStatement || child.Parent is RuleDeclaration)
                    )
                    throw new Exception(child.Parent.GetType().ToString());
                CheckForInvalidExpressionParentsa(child);
            }
        }

        public static void CheckForTypeWrappersInAsta(INode node)
        {
            foreach (var child in node.Children)
            {
                if (child is TypeNodeWrapper)
                    throw new Exception(child.Parent.GetType().ToString());
                CheckForTypeWrappersInAsta(child);
            }
        }

        public static void CheckForVariablesWithoutTypesa(INode node)
        {
            foreach (var child in node.Children)
            {
                if (child is VariableDeclaration vd && vd.Type == null && !(child.Parent is ForeachStatement))
                    throw new Exception();
                CheckForVariablesWithoutTypesa(child);
            }
        }

        public static void CheckForReferencesToLocalVariablesInOtherFunctionsa(INode node)
        {
            foreach (var nameExpression in node.AllDescendantsAndSelf().OfType<INameExpression>())
            {
                if (nameExpression.Declarations.Count != 1)
                    continue;
                var variableDeclaration = nameExpression.Declaration as VariableDeclaration;
                if (variableDeclaration == null)
                    continue;
                var nameExpressionParent = nameExpression.NearestAncestorOfAnyType(typeof(MethodDeclaration), typeof(LambdaExpression));
                if (nameExpression == null)
                    continue;
                var variableDeclarationParent = variableDeclaration.NearestAncestorOfAnyType(typeof(MethodDeclaration), typeof(LambdaExpression));
                if (variableDeclarationParent == null)
                    continue;
                if (nameExpressionParent != variableDeclarationParent)
                    throw new Exception();
            }
        }

        public static void CheckForErrorsInParentChildRelationShipsa(INode node)
        {
            foreach (var child in node.Children)
            {
                if (child.Parent != node)
                    throw new Exception();
                CheckForErrorsInParentChildRelationShipsa(child);
            }
        }

        public static void CheckChildIsRightTypea(INode node)
        {

            foreach (var child in node.Children)
            {
                CheckChildIsRightTypea(child);
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