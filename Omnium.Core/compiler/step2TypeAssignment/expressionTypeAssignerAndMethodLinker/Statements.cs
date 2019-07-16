using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.compiler.utilities;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step2TypeAssignment.expressionTypeAssignerAndMethodLinker
{
    public partial class ExpressionTypeAssignerAndMethodLinker : TreeVoidWalker
    {
        public override void EnterForeachStatement(ForeachStatement foreachStatement)
        {
            Visit(foreachStatement.List);
            if (!foreachStatement.List.Type.IsList(foreachStatement.NearestAncestorOfType<Root>()))
            {
                Errors.Add(new CompilationError(foreachStatement.Context, $"Can not iterate over {foreachStatement.List.Type}."));
                skipChildren = true;
                return;
            }

            var genericType = (GenericType)foreachStatement.List.Type;

            foreachStatement.Variable.AddChild(AstCloner.Clone(genericType.GenericTypes.Single()));
            Visit(foreachStatement.Body);
            skipChildren = true;
        }

        public override void ExitForeachStatement(ForeachStatement foreachStatement)
        {
            if (!foreachStatement.List.Type.IsList(foreachStatement.NearestAncestorOfType<Root>()))
                Errors.Add(new CompilationError(foreachStatement.Context, $"Can not iterate over {foreachStatement.List.Type}."));
        }

        public override void ExitForStatement(ForStatement forStatement)
        {
            if (forStatement.Condition != null && !(forStatement.Condition.Type is BoolType))
                Errors.Add(new CompilationError(forStatement.Context, $"The condition must be a boolean, found {forStatement.Condition.Type}."));
        }

        public override void ExitIfStatement(IfStatement ifStatement)
        {
            if (!(ifStatement.Condition.Type is BoolType))
                Errors.Add(new CompilationError(ifStatement.Context, $"The condition must be a boolean, found {ifStatement.Condition.Type}."));
        }
    }
}