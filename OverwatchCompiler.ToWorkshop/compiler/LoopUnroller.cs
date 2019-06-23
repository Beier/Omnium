using System;
using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class LoopUnroller : TreeVoidWalker
    {
        //Foreach: If a single expression, use the native functionality, otherwise convert to for
        //For: Unroll if constant, otherwise convert to while
        //While:
        //If it spans the entire rule, simply replace with a loop statement at the bottom
        //If not, split it into a new rule, use a global/player variable to trigger it

        public override void EnterMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            BlockFlattener.FlattenAllSubBlocks(methodDeclaration.Body);
        }

        public override void EnterForeachStatement(ForeachStatement foreachStatement)
        {
            var listVariable = new VariableDeclaration(
                foreachStatement.Context,
                "var" + new Random().Next(),
                new INode[]
                {
                    (ArrayType)foreachStatement.List.Type,
                    foreachStatement.List
                });
            var indexVariable = new VariableDeclaration(
                foreachStatement.Context,
                "var" + new Random().Next(),
                new INode[]
                {
                    new NumberType(foreachStatement.Context),
                    new NumberLiteral(foreachStatement.Context, "0")
                });

            var condition = new BinaryExpression(
                foreachStatement.Context,
                new INode[]
                {
                    new SimpleNameExpression(foreachStatement.Context, indexVariable.Name)
                    {
                        Declaration = indexVariable,
                        Type = indexVariable.Type
                    },
                    new Token(foreachStatement.Context, "<"),
                    NativeMethods.ArrayCount(
                        foreachStatement.Context, 
                        new SimpleNameExpression(foreachStatement.Context, listVariable.Name)
                        {
                            Declaration = listVariable,
                            Type = listVariable.Type
                        })
                });
            var update = new AssignmentExpression(
                foreachStatement.Context,
                new INode[]
                {
                    new SimpleNameExpression(foreachStatement.Context, indexVariable.Name)
                    {
                        Declaration = indexVariable,
                        Type = indexVariable.Type
                    },
                    new AssignmentOperator(foreachStatement.Context, "="),
                    new BinaryExpression(
                        foreachStatement.Context,
                        new INode[]
                        {
                            new SimpleNameExpression(foreachStatement.Context, indexVariable.Name)
                            {
                                Declaration = indexVariable,
                                Type = indexVariable.Type
                            },
                            new Token(foreachStatement.Context, "+"),
                            new NumberLiteral(foreachStatement.Context, "1")
                        }),
                });
            var forStatement = new ForStatement(
                foreachStatement.Context,
                new[]
                {
                    listVariable,
                    indexVariable
                },
                new IExpression[0],
                condition,
                update.Yield(),
                foreachStatement.Body);
            var elmVariable = foreachStatement.Variable;
            elmVariable.AddChild(
                NativeMethods.ArrayIndex(
                    foreachStatement.Context,
                    new SimpleNameExpression(foreachStatement.Context, listVariable.Name)
                    {
                        Declaration = listVariable,
                        Type = listVariable.Type
                    },
                    new SimpleNameExpression(foreachStatement.Context, indexVariable.Name)
                    {
                        Declaration = indexVariable,
                        Type = indexVariable.Type
                    })
                );
            forStatement.Body.AddChildFirst(new VariableDeclarationStatement(foreachStatement.Context, elmVariable));
            foreachStatement.ReplaceWith(forStatement);
            Visit(forStatement);
            skipChildren = true;
        }

        //Todo: unroll if constant
        public override void EnterForStatement(ForStatement forStatement)
        {
            var block = (BlockStatement)forStatement.Parent;
            var addedStatements = new List<IStatement>();
            foreach (var variable in forStatement.Variables.Reverse().ToList())
            {
                var variableDeclarationStatement = new VariableDeclarationStatement(forStatement.Context, variable);
                block.AddChildBefore(forStatement, variableDeclarationStatement);
                addedStatements.Add(variableDeclarationStatement);
            }
            foreach (var initExpression in forStatement.InitExpressions.Reverse().ToList())
            {
                var expressionStatement = new ExpressionStatement(forStatement.Context, initExpression);
                block.AddChildBefore(forStatement, expressionStatement);
                addedStatements.Add(expressionStatement);
            }

            var body = (BlockStatement)forStatement.Body;
            foreach (var nextExpression in forStatement.NextExpressions)
            {
                body.AddChild(
                    new ExpressionStatement(
                        forStatement.Context,
                        AstCloner.Clone(nextExpression)
                        )
                    );
            }

            AddUpdateBeforeContinueStatements(body, forStatement.NextExpressions);

            var whileStatement = new WhileStatement(
                forStatement.Context,
                new INode[]
                {
                    forStatement.Condition ?? new BooleanLiteral(forStatement.Context, "true"),
                    body
                });
            forStatement.ReplaceWith(whileStatement);
            addedStatements.Add(whileStatement);
            foreach (var addedStatement in addedStatements)
            {
                Visit(addedStatement);
            }
            skipChildren = true;
        }

        private void AddUpdateBeforeContinueStatements(INode statement, IEnumerable<IExpression> updateExpressions)
        {
            if (!(statement is IStatement))
                return;
            if (statement is ContinueStatement)
            {
                var parentBlock = (BlockStatement)statement.Parent;
                foreach (var nextExpression in updateExpressions)
                {
                    parentBlock.AddChildBefore(
                        statement,
                        new ExpressionStatement(
                            statement.Context,
                            AstCloner.Clone(nextExpression)
                        )
                    );
                }
            }

            foreach (var child in statement.Children.ToList())
            {
                AddUpdateBeforeContinueStatements(child, updateExpressions);
            }
        }

        public override void ExitWhileStatement(WhileStatement whileStatement)
        {
            var rule = whileStatement.NearestAncestorOfType<RuleDeclaration>();
            var stateVariable = GetOrCreateStateVariable(rule);
            var stateIndex = ++rule.NumberOfStates;
            var block = (BlockStatement)whileStatement.Parent;
            block.AddChildBefore(whileStatement,
                new ExpressionStatement(
                    whileStatement.Context,
                    new AssignmentExpression(
                        whileStatement.Context,
                        new INode[]
                        {
                            new SimpleNameExpression(whileStatement.Context, stateVariable.Name)
                            {
                                Declaration = stateVariable,
                                Type = stateVariable.Type
                            },
                            new AssignmentOperator(whileStatement.Context, "="), 
                            new NumberLiteral(whileStatement.Context, stateIndex.ToString())
                        })
                    )
                );

            var followingStateAssignment = new ExpressionStatement(
                whileStatement.Context,
                new AssignmentExpression(
                    whileStatement.Context,
                    new INode[]
                    {
                        new SimpleNameExpression(whileStatement.Context, stateVariable.Name)
                        {
                            Declaration = stateVariable,
                            Type = stateVariable.Type
                        },
                        new AssignmentOperator(whileStatement.Context, "="),
                        new NumberLiteral(whileStatement.Context, "0")
                    })
            );
            block.AddChildAfter(whileStatement, followingStateAssignment);

            var beforeWhileGotoTarget = new GotoTargetStatement(whileStatement.Context);
            block.AddChildBefore(whileStatement, beforeWhileGotoTarget);
            var afterWhileGotoTarget = new GotoTargetStatement(whileStatement.Context);
            block.AddChildAfter(whileStatement, afterWhileGotoTarget);

            var whileBody = (BlockStatement) whileStatement.Body;
            if (!(whileBody.Statements.LastOrDefault() is ContinueStatement))
                whileBody.AddChild(new ContinueStatement(whileStatement.Context));
            ReplaceContinueAndBreakStatements(whileBody, afterWhileGotoTarget);
            
            var ifStatement = new IfStatement(
                whileStatement.Context,
                new INode[]
                {
                    whileStatement.Condition,
                    whileStatement.Body
                });
            whileStatement.ReplaceWith(ifStatement);


            rule.Action.Block.AddChildFirst(
                new IfStatement(
                    whileStatement.Context,
                    new INode[]
                    {
                        new BinaryExpression(
                            whileStatement.Context,
                            new INode[]
                            {
                                new SimpleNameExpression(whileStatement.Context, stateVariable.Name)
                                {
                                    Declaration = stateVariable,
                                    Type = stateVariable.Type
                                },
                                new Token(whileStatement.Context, "=="),
                                new NumberLiteral(whileStatement.Context, stateIndex.ToString())
                            }),
                        new GotoStatement(whileStatement.Context, beforeWhileGotoTarget)
                    }));

            skipChildren = true;
        }

        private VariableDeclaration GetOrCreateStateVariable(RuleDeclaration rule)
        {
            if (rule.StateVariable == null)
            {
                rule.AddChild(
                    new VariableDeclaration(
                        rule.Context, 
                        "var" + new Random().Next(), 
                        new INode[]
                        {
                            new NumberType(rule.Context), new NumberLiteral(rule.Context, "0"),
                        })
                    );
            }
            return rule.StateVariable;

        }

        private void ReplaceContinueAndBreakStatements(INode node, GotoTargetStatement followingStatement)
        {
            if (!(node is IStatement))
                return;
            if (node is BreakStatement breakStatement)
            {
                breakStatement.ReplaceWith(new GotoStatement(breakStatement.Context, followingStatement));
            }
            if (node is ContinueStatement continueStatement)
            {
                continueStatement.ReplaceWith(NativeMethods.Loop(continueStatement.Context));
            }

            foreach (var child in node.Children)
            {
                ReplaceContinueAndBreakStatements(child, followingStatement);
            }
        }
    }
}

