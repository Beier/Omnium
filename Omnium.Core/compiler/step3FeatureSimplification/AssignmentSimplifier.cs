using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.compiler.utilities;

namespace Omnium.Core.compiler.step3FeatureSimplification
{
    public class AssignmentSimplifier : TreeVoidWalker
    {

        public override void EnterIfStatement(IfStatement ifStatement)
        {
            WrapInBlock(ifStatement.TrueBranch);
            WrapInBlock(ifStatement.FalseBranch);
        }

        public override void EnterForStatement(ForStatement forStatement)
        {
            WrapInBlock(forStatement.Body);
        }

        public override void EnterForeachStatement(ForeachStatement foreachStatement)
        {
            WrapInBlock(foreachStatement.Body);
        }

        public override void EnterWhileStatement(WhileStatement whileStatement)
        {
            WrapInBlock(whileStatement.Body);

        }

        public override void EnterSwitchGroup(SwitchGroup switchGroup)
        {
            var statements = switchGroup.Statements.ToList();
            if (statements.Count == 1 && statements[0] is BlockStatement)
                return;
            foreach (var statement in statements)
            {
                statement.Remove();
            }
            switchGroup.AddChild(new BlockStatement(switchGroup.Context, statements));
        }

        private void WrapInBlock(IStatement statement)
        {
            if (statement == null || statement is BlockStatement)
                return;
            var block = new BlockStatement(statement.Context, new List<IStatement>());
            statement.Parent.ReplaceChild(statement, block);
            block.AddChild(statement);
        }

        public override void ExitPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression)
        {
            if (!(posfixOperationExpression.Parent is ExpressionStatement || posfixOperationExpression.Parent is ForStatement forStatement && forStatement.NextExpressions.Contains(posfixOperationExpression)))
                Errors.Add(new CompilationError(posfixOperationExpression.Context, "The postfix operator can only be used directly in a statement"));
            var assignmentExpression = new AssignmentExpression(
                posfixOperationExpression.Context,
                new INode[]
                {
                    AstCloner.Clone(posfixOperationExpression.Base),
                    new AssignmentOperator(posfixOperationExpression.Context, "="),
                    new BinaryExpression(
                        posfixOperationExpression.Context,
                        new INode[]
                        {
                            AstCloner.Clone(posfixOperationExpression.Base),
                            new Token(posfixOperationExpression.Operation.Context, posfixOperationExpression.Operation.Text.Substring(0, 1)),
                            new NumberLiteral(posfixOperationExpression.Context, "1")
                        }),
                });
            posfixOperationExpression.ReplaceWith(assignmentExpression);
            Visit(assignmentExpression);
        }

        public override void ExitUnaryExpression(UnaryExpression unaryExpression)
        {
            switch (unaryExpression.Operator.Text)
            {
                case "+":
                    unaryExpression.ReplaceWith(unaryExpression.Base);
                    break;
                case "-":
                    unaryExpression.ReplaceWith(new BinaryExpression(
                        unaryExpression.Context,
                        new INode[]
                        {
                            new NumberLiteral(unaryExpression.Context, 0), 
                            unaryExpression.Operator,
                            unaryExpression.Base
                        }));
                    break;
            }
        }

        public override void ExitCastExpression(CastExpression castExpression)
        {
            castExpression.ReplaceWith(castExpression.Base);
        }

        public override void ExitAssignmentExpression(AssignmentExpression assignmentExpression)
        {
            if (assignmentExpression.Operator.Value != "=")
            {
                var rightSide = assignmentExpression.Right;
                rightSide.Remove();
                var leftClone = AstCloner.Clone(assignmentExpression.Left);
                switch (leftClone)
                {
                    case SimpleNameExpression simpleNameExpression:
                        if (simpleNameExpression.Declaration is SetterDeclaration)
                        {
                            var classDeclaration = (ClassDeclaration) simpleNameExpression.Declaration.Parent;
                            var getterSetter = classDeclaration.GettersAndSetters.Single(x => x.Setter == simpleNameExpression.Declaration);
                            simpleNameExpression.Declaration = getterSetter.Getter;
                        }
                        break;
                    case MemberExpression memberExpression:
                        if (memberExpression.Declaration is SetterDeclaration)
                        {
                            var classDeclaration = (ClassDeclaration)memberExpression.Declaration.Parent;
                            var getterSetter = classDeclaration.GettersAndSetters.Single(x => x.Setter == memberExpression.Declaration);
                            memberExpression.Declaration = getterSetter.Getter;
                        }
                        break;
                }
                assignmentExpression.AddChild(
                    new BinaryExpression(assignmentExpression.Context,
                        new INode[]
                        {
                            leftClone,
                            new Token(assignmentExpression.Context, assignmentExpression.Operator.Value.Substring(0, assignmentExpression.Operator.Value.Length - 1)), 
                            rightSide
                        }));
                assignmentExpression.Operator.Value = "=";
            }

            if (!(assignmentExpression.Parent is ExpressionStatement || assignmentExpression.Parent is ForStatement || assignmentExpression.Parent is ForeachStatement))
            {
                var statement = assignmentExpression.NearestAncestorOfType<IStatement>();
                var block = (BlockStatement)statement.Parent;
                var variable = new VariableDeclaration(assignmentExpression.Context,
                    "var" + NumberWheel.Next(),
                    new INode[]
                    {
                        assignmentExpression.Type.Wrap(assignmentExpression.Context),
                        assignmentExpression.Right
                    })
                {
                    VariableType = VariableType.Const
                };
                block.VariableDeclarations.Add(variable);
                block.AddChildBefore(statement, new VariableDeclarationStatement(assignmentExpression.Context, variable));
                block.AddChildBefore(statement, new ExpressionStatement(assignmentExpression.Context, 
                    new AssignmentExpression(
                        assignmentExpression.Context,
                        new INode[]
                        {
                            assignmentExpression.Left,
                            assignmentExpression.Operator,
                            new SimpleNameExpression(assignmentExpression.Context, variable.Name)
                            {
                                Declaration = variable,
                                Type = variable.Type
                            },
                        })
                    {
                        Type = assignmentExpression.Type
                    })
                );
                assignmentExpression.ReplaceWith(
                    new SimpleNameExpression(assignmentExpression.Context, variable.Name)
                    {
                        Declaration = variable,
                        Type = variable.Type
                    });
            }
        }
    }
}