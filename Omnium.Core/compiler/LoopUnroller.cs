using System;
using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
{
    public class LoopUnroller : TreeVoidWalker
    {
        //Foreach: If a single expression, use the native functionality, otherwise convert to for
        //For: Unroll if constant, otherwise convert to while
        //While:
        //If it spans the entire rule, simply replace with a loop statement at the bottom
        //If not, split it into a new rule, use a global/player variable to trigger it

        private Root root;
        public override void EnterRoot(Root root)
        {
            this.root = root;
        }

        public override void EnterMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            BlockFlattener.FlattenAllSubBlocks(methodDeclaration.Body);
        }

        public override void EnterForeachStatement(ForeachStatement foreachStatement)
        {
            var listVariable = new VariableDeclaration(
                foreachStatement.Context,
                "list" + NumberWheel.Next(),
                new INode[]
                {
                    AstCloner.Clone((GenericType)foreachStatement.List.Type),
                    foreachStatement.List
                });
            var indexVariable = new VariableDeclaration(
                foreachStatement.Context,
                "index" + NumberWheel.Next(),
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

        public override void EnterForStatement(ForStatement forStatement)
        {
            var block = (BlockStatement)forStatement.Parent;
            var addedStatements = new List<IStatement>();

            var allowedConditionOperators = new[] {"==", "!=", "<", ">", "<=", ">="};
            var allowedUpdateOperators = new[] {"+", "-", "*", "/", "%"};
            if (forStatement.Variables.Count() == 1
                && forStatement.Variables.Single() is VariableDeclaration singleVariable
                && singleVariable.Type is NumberType
                && singleVariable.InitExpression is NumberLiteral initLiteral
                && !forStatement.InitExpressions.Any()
                && forStatement.Condition is BinaryExpression condition
                && condition.Left is SimpleNameExpression conditionVar
                && conditionVar.Declaration == singleVariable
                && condition.Right is NumberLiteral
                && allowedConditionOperators.Contains(condition.Operator.Text)
                && forStatement.NextExpressions.Count() == 1
                && forStatement.NextExpressions.Single() is AssignmentExpression update
                && update.Left is SimpleNameExpression updateVarWrite
                && updateVarWrite.Declaration == singleVariable
                && update.Right is BinaryExpression updateBinaryExpression
                && allowedUpdateOperators.Contains(updateBinaryExpression.Operator.Text)
                && updateBinaryExpression.Left is SimpleNameExpression updateVarRead
                && updateVarRead.Declaration == singleVariable
                && updateBinaryExpression.Right is NumberLiteral
                && CountIterations(initLiteral, condition, updateBinaryExpression) is List<double> iterations)
            {
                var breakGotoTarget = new GotoTargetStatement(forStatement.Context);
                foreach (var iteration in iterations)
                {
                    var continueGotoTarget = new GotoTargetStatement(forStatement.Context);
                    var clone = AstCloner.Clone(forStatement);
                    ReplaceContinueAndBreakStatements(
                        clone,
                        new GotoStatement(clone.Context, breakGotoTarget), 
                        new GotoStatement(clone.Context, continueGotoTarget));

                    var variable = clone.Variables.Single();
                    variable.InitExpression.ReplaceWith(new NumberLiteral(variable.Context, iteration));
                    var variableDeclarationStatement = new VariableDeclarationStatement(variable.Context, variable);
                    block.AddChildBefore(forStatement, variableDeclarationStatement);
                    block.AddChildBefore(forStatement, clone.Body);
                    block.AddChildBefore(forStatement, continueGotoTarget);


                    addedStatements.Add(variableDeclarationStatement);
                    addedStatements.Add(clone.Body);
                    addedStatements.Add(continueGotoTarget);
                }
                block.AddChildBefore(forStatement, breakGotoTarget);
                addedStatements.Add(breakGotoTarget);

                forStatement.Remove();
            }
            else
            {
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
            }

            foreach (var addedStatement in addedStatements)
            {
                Visit(addedStatement);
            }
            BlockFlattener.FlattenAllSubBlocks(block);
            skipChildren = true;
        }

        private List<double> CountIterations(NumberLiteral initLiteral, BinaryExpression condition, BinaryExpression update)
        {
            var iterations = new List<double>();
            for (double x = initLiteral.Value; EvaluateCondition(x, condition); x = PerformUpdate(x, update))
            {
                iterations.Add(x);
                if (iterations.Count > 20)
                    return null;
            }

            return iterations;
        }

        private bool EvaluateCondition(double x, BinaryExpression condition)
        {
            var rightSide = ((NumberLiteral) condition.Right).Value;
            switch (condition.Operator.Text)
            {
                case "<": return x < rightSide;
                case "<=": return x <= rightSide;
                case ">": return x > rightSide;
                case ">=": return x >= rightSide;
                case "==": return x == rightSide;
                case "!=": return x != rightSide;
            }
            throw new Exception();
        }

        private double PerformUpdate(double x, BinaryExpression update)
        {
            var rightSide = ((NumberLiteral)update.Right).Value;
            switch (update.Operator.Text)
            {
                case "+": return x + rightSide;
                case "-": return x - rightSide;
                case "*": return x * rightSide;
                case "/": return x / rightSide;
                case "%": return x % rightSide;
            }
            throw new Exception();
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
            ReplaceContinueAndBreakStatements(
                whileBody, 
                new GotoStatement(whileStatement.Context, afterWhileGotoTarget),
                NativeMethods.Loop(whileStatement.Context)
                );
            
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
            if (!rule.GlobalVariables.Any(x => x.Name.StartsWith("state")))
            {
                rule.AddChild(
                    new VariableDeclaration(
                        rule.Context, 
                        "state" + NumberWheel.Next(), 
                        new INode[]
                        {
                            new NumberType(rule.Context), new NumberLiteral(rule.Context, "0"),
                        })
                    );
            }
            return rule.GlobalVariables.Single(x => x.Name.StartsWith("state"));

        }
        
        private void ReplaceContinueAndBreakStatements(INode node, IStatement breakReplacement, IStatement continueReplacement)
        {
            if (!(node is IStatement))
                return;
            if (node is BreakStatement breakStatement)
            {
                breakStatement.ReplaceWith(AstCloner.Clone(breakReplacement));
            }
            if (node is ContinueStatement continueStatement)
            {
                continueStatement.ReplaceWith(AstCloner.Clone(continueReplacement));
            }

            foreach (var child in node.Children.ToList())
            {
                ReplaceContinueAndBreakStatements(child, breakReplacement, continueReplacement);
            }
        }
    }
}

