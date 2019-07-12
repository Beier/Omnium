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
    public class VariableRemoverAndCodeOptimizer : TreeVoidWalker
    {
        //Remove variable assignments read 0 times
        //Remove variable assignments with a constant/pure initialization
        //Remove variable assignments read 1 time, if it does not cross unknown setters
        //Merge variables within rule if possible
        //Assign player/global variables to be 100% safe locals (if the usage span does not cross loop or wait)
        //Variables spanning loop or wait will only be used for that rule
        private Dictionary<IStatement, List<IStatement>> successors = new Dictionary<IStatement, List<IStatement>>();
        private Dictionary<IStatement, List<IStatement>> predecessors = new Dictionary<IStatement, List<IStatement>>();
        private readonly Dictionary<VariableDeclaration, List<IExpression>> variableReads = new Dictionary<VariableDeclaration, List<IExpression>>();
        private readonly Dictionary<VariableDeclaration, List<IExpression>> variableWrites = new Dictionary<VariableDeclaration, List<IExpression>>();


        public override void EnterRoot(Root root)
        {
            successors = BuildSuccessorGraph(root);
            predecessors = BuildPredecessorGraph(successors);
            BuildVariableReadsWritesGraph(root);

            MoveLocalVariableInitializationsToAssignments(root);

            var hadChanges = true;
            while (hadChanges)
            {
                hadChanges = false;
                hadChanges |= RemoveUnreachableCode();
                hadChanges |= RemoveRedundantGotos();
                hadChanges |= ConstantEvaluator.EvaluateConstants(root);
                hadChanges |= MoveLocalAssignments(root);
                hadChanges |= RemoveReadVariables();
            }

            SimplifyLambdaMethods(root);
            SimplifyRuleTriggers(root);
            SimplifyRuleCondition(root);
            MoveStateVariablesToInitializationRules(root);
            RemoveAssertions(root);

            hadChanges = true;
            while (hadChanges)
            {
                hadChanges = false;
                hadChanges |= RemoveUnreachableCode();
                hadChanges |= RemoveRedundantGotos();
                hadChanges |= ConstantEvaluator.EvaluateConstants(root);
                hadChanges |= MoveLocalAssignments(root);
                hadChanges |= RemoveReadVariables();
                hadChanges |= RemoveGlobalConstants(root);
            }
            
            RemoveLocalVariables(root);

            skipChildren = true;
        }

        private Dictionary<IStatement, List<IStatement>> BuildSuccessorGraph(INode node)
        {
            var successors = new Dictionary<IStatement, List<IStatement>>();
            var statements = node.AllDescendantsAndSelf().OfType<IStatement>().ToList();

            foreach (var statement in statements)
            {
                successors.Add(statement, GetSuccessors(statement).ToList());
            }

            return successors;
        }

        private Dictionary<IStatement, List<IStatement>> BuildPredecessorGraph(Dictionary<IStatement, List<IStatement>> successors)
        {
            var predecessors = new Dictionary<IStatement, List<IStatement>>();
            foreach (var statement in successors.Keys)
            {
                predecessors.Add(statement, new List<IStatement>());
            }

            foreach (var successorPair in successors)
            {
                var statement = successorPair.Key;
                foreach (var followingStatement in successorPair.Value)
                {
                    predecessors[followingStatement].Add(statement);
                }
            }

            return predecessors;
        }

        private void BuildVariableReadsWritesGraph(INode node)
        {
            var (reads, writes) = BuildVariableReadsWritesGraph2(node);
            foreach (var read in reads)
            {
                variableReads.Add(read.Key, read.Value);
            }
            foreach (var write in writes)
            {
                variableWrites.Add(write.Key, write.Value);
            }
        }


        private void ValidateVariableReadsWritesGraph(INode node)
        {
            var (reads, writes) = BuildVariableReadsWritesGraph2(node);
            foreach (var read in reads)
            {
                if (variableReads[read.Key].Count != read.Value.Count
                    || !variableReads[read.Key].All(read.Value.Contains)
                    || !read.Value.All(variableReads[read.Key].Contains))
                    throw new Exception();
            }
            foreach (var write in writes)
            {
                if (variableWrites[write.Key].Count != write.Value.Count
                    || !variableWrites[write.Key].All(write.Value.Contains)
                    || !write.Value.All(variableWrites[write.Key].Contains))
                    throw new Exception();
            }
        }

        private (Dictionary<VariableDeclaration, List<IExpression>>, Dictionary<VariableDeclaration, List<IExpression>>)
            BuildVariableReadsWritesGraph2(INode node)
        {
            var reads = new Dictionary<VariableDeclaration, List<IExpression>>();
            var writes = new Dictionary<VariableDeclaration, List<IExpression>>();

            foreach (var variableDeclaration in node.AllDescendantsAndSelf().OfType<VariableDeclaration>())
            {
                reads.Add(variableDeclaration, new List<IExpression>());
                writes.Add(variableDeclaration, new List<IExpression>());
            }

            foreach (var decendant in node.AllDescendantsAndSelf())
            {
                switch (decendant)
                {
                    case SimpleNameExpression simpleNameExpression:
                        {
                            var variableDeclaration = simpleNameExpression.Declaration as VariableDeclaration;
                            if (variableDeclaration == null)
                                break;
                            if (simpleNameExpression.Parent is AssignmentExpression assignment && simpleNameExpression == assignment.Left)
                                writes[variableDeclaration].Add(simpleNameExpression);
                            else
                                reads[variableDeclaration].Add(simpleNameExpression);
                            break;
                        }
                    case MemberExpression memberExpression:
                        {
                            var variableDeclaration = memberExpression.Declaration as VariableDeclaration;
                            if (variableDeclaration == null)
                                break;
                            if (memberExpression.Parent is AssignmentExpression assignment && memberExpression == assignment.Left)
                                writes[variableDeclaration].Add(memberExpression);
                            else
                                reads[variableDeclaration].Add(memberExpression);
                            break;
                        }
                }
            }

            return (reads, writes);
        }

        private IEnumerable<IStatement> GetSuccessors(IStatement statement)
        {
            switch (statement)
            {
                case GotoStatement gotoStatement:
                    yield return gotoStatement.TargetStatement;
                    if (gotoStatement.Condition == null)
                        yield break;
                    break;
                case ExpressionStatement expressionStatement:
                    if (expressionStatement.Expression is NativeMethodInvocationExpression nativeInvocation
                        && nativeInvocation.NativeMethodName == "Loop")
                    {
                        var topBlock = statement.AllAncestorOfType<BlockStatement>().Last();
                        yield return topBlock;
                        yield break;
                    }
                    break;
                case BlockStatement blockStatement:
                    var firstChild = blockStatement.Statements.FirstOrDefault();
                    if (firstChild != null)
                    {
                        yield return firstChild;
                        yield break;
                    }
                    break;
                case ReturnStatement _:
                    yield break;
            }

            var parent = statement.Parent as BlockStatement;
            if (parent == null)
                yield break;
            var index = parent.Statements.IndexOf(statement);
            var next = parent.Statements.Skip(index + 1).FirstOrDefault();
            if (next != null)
                yield return next;
        }

        private bool RemoveUnreachableCode()
        {
            var unreachableStatements = new List<IStatement>();
            unreachableStatements.AddRange(predecessors.Where(x => !x.Value.Any() && !(x.Key.Parent is LambdaExpression)).Select(x => x.Key));

            List<IStatement> unreachableSuccessors;
            do
            {
                var successors = unreachableStatements.SelectMany(x => this.successors[x]).Where(x => !unreachableStatements.Contains(x)).Distinct();
                unreachableSuccessors = successors.Where(x => predecessors[x].All(unreachableStatements.Contains)).ToList();
                unreachableStatements.AddRange(unreachableSuccessors);
            } while (unreachableSuccessors.Count > 0);

            var removeLast = unreachableStatements.Where(x => x is GotoTargetStatement || x is VariableDeclarationStatement).ToList();

            foreach (var statement in unreachableStatements.Except(removeLast))
            {
                RemoveStatement(statement);
            }
            foreach (var statement in removeLast)
            {
                RemoveStatement(statement);
            }

            return unreachableStatements.Any();
        }

        private bool RemoveRedundantGotos()
        {
            var changedSomething = false;
            foreach (var successorPair in successors.ToList())
            {
                var statement = successorPair.Key;

                switch (statement)
                {
                    case GotoTargetStatement gotoTarget:
                        //Remove Two subsequent labels
                        if (successorPair.Value.Count == 1 && successorPair.Value[0] is GotoTargetStatement followingGotoTarget)
                        {
                            foreach (var gotoStatement in predecessors[statement].OfType<GotoStatement>())
                            {
                                if (gotoStatement.TargetStatement == gotoTarget)
                                    gotoStatement.TargetStatement = followingGotoTarget;
                            }
                            RemoveStatement(gotoTarget);
                            changedSomething = true;
                            break;
                        }
                        //Remove label with no goto
                        if (predecessors[gotoTarget].OfType<GotoStatement>().All(x => x.TargetStatement != gotoTarget))
                        {
                            RemoveStatement(gotoTarget);
                            changedSomething = true;
                        }
                        break;
                    case GotoStatement gotoStatement:
                        {
                            //Remove goto: next line
                            var block = (BlockStatement)gotoStatement.Parent;
                            var index = block.Statements.IndexOf(gotoStatement);
                            var statements = block.Statements.Skip(index).Take(3).ToList();
                            if (statements.Count >= 2 && successorPair.Value.All(successor =>
                            {
                                var successorParent = successor.Parent as BlockStatement;
                                return successorParent == block && statements[1] == successor;
                            }))
                            {
                                RemoveStatement(statement);
                                changedSomething = true;
                                break;
                            }

                            //Simplify goto (if true or false) to goto
                            if (gotoStatement.Condition is BooleanLiteral literal)
                            {
                                if (literal.Value)
                                {
                                    gotoStatement.Condition.Remove();
                                    var nextStatement = successors[gotoStatement].Single(x => x != gotoStatement.TargetStatement);
                                    successors[gotoStatement].Remove(nextStatement);
                                    predecessors[nextStatement].Remove(gotoStatement);
                                }
                                else
                                {
                                    var gotoTarget = gotoStatement.TargetStatement;
                                    successors[gotoStatement].Remove(gotoTarget);
                                    predecessors[gotoTarget].Remove(gotoStatement);
                                    RemoveStatement(gotoStatement);
                                }
                                changedSomething = true;
                                break;
                            }
                            //Simplify
                            // +0: goto (condition) target 1
                            // 1: goto 42
                            // +2: target 1
                            //Into
                            // +0: goto (!condition) target 42
                            // +1: target 1
                            if (gotoStatement.Condition != null)
                            {
                                if (statements.Count == 3
                                    && statements[1] is GotoStatement skippedGotoStatement
                                    && skippedGotoStatement.Condition == null
                                    && statements[2] == gotoStatement.TargetStatement)
                                {
                                    successors[skippedGotoStatement].Remove(skippedGotoStatement.TargetStatement);
                                    predecessors[skippedGotoStatement.TargetStatement].Remove(skippedGotoStatement);
                                    successors[gotoStatement].Remove(skippedGotoStatement);
                                    predecessors[skippedGotoStatement].Remove(gotoStatement);
                                    gotoStatement.TargetStatement = skippedGotoStatement.TargetStatement;
                                    successors[gotoStatement].Add(gotoStatement.TargetStatement);
                                    predecessors[gotoStatement.TargetStatement].Add(gotoStatement);

                                    skippedGotoStatement.Remove();
                                    predecessors.Remove(skippedGotoStatement);
                                    successors.Remove(skippedGotoStatement);

                                    var negation = new UnaryExpression(gotoStatement.Context, new[] { new Token(gotoStatement.Context, "!") });
                                    var condition = gotoStatement.Condition;
                                    condition.ReplaceWith(negation);
                                    negation.AddChild(condition);
                                    return true;//We deleted a goto statement other than the one we currently process - we can not continue
                                }
                            }
                        }
                        break;
                }


            }

            if (changedSomething)
                RemoveRedundantGotos();
            return changedSomething;
        }


        public void MoveLocalVariableInitializationsToAssignments(Root root)
        {
            var variableDeclarations = root.AllDescendantsAndSelf().OfType<VariableDeclaration>().ToList();
            foreach (var variableDeclaration in variableDeclarations)
            {
                var initExpression = variableDeclaration.InitExpression;
                if (initExpression == null)
                    continue;
                if (variableDeclaration.Parent is VariableDeclarationStatement declarationStatement)
                {
                    var block = (BlockStatement)declarationStatement.Parent;
                    initExpression.Remove();
                    var variableReference = new SimpleNameExpression(variableDeclaration.Context, variableDeclaration.Name)
                    {
                        Declaration = variableDeclaration
                    };
                    var assignmentStatement = new ExpressionStatement(
                        variableDeclaration.Context,
                        new AssignmentExpression(
                            variableDeclaration.Context,
                            new INode[]
                            {
                                variableReference,
                                new AssignmentOperator(variableDeclaration.Context, "="),
                                initExpression
                            }));
                    block.AddChildAfter(declarationStatement, assignmentStatement);
                    variableWrites[variableDeclaration].Add(variableReference);
                    successors.Add(assignmentStatement, successors[declarationStatement]);
                    successors[declarationStatement] = new List<IStatement> { assignmentStatement };
                    predecessors.Add(assignmentStatement, new List<IStatement> { declarationStatement });
                    foreach (var successor in successors[assignmentStatement])
                    {
                        predecessors[successor].Remove(declarationStatement);
                        predecessors[successor].Add(assignmentStatement);
                    }
                }
            }
        }

        private bool MoveLocalAssignments(Root root)
        {
            bool madeChanges = false;
            var assignments = root.AllDescendantsAndSelf().OfType<AssignmentExpression>();
            var assignmentsToLocalVariables = assignments.Where(x => GetAssignmentTarget(x).Parent is VariableDeclarationStatement);
            var readsAndPredecessorsForAssignments = assignmentsToLocalVariables.Select(assignment =>
            {
                var variableDeclaration = GetAssignmentTarget(assignment);
                var readsAndPredecessors = FindReadsAndStatementsTowardsRead(variableDeclaration, assignment);
                return (assignment, variableDeclaration, readsAndPredecessors);
            }).ToList();
            if (readsAndPredecessorsForAssignments.Any(x => x.Item3.Count != x.Item3.DistinctBy(y => y.Item1).Count()))
                throw new Exception();

            var assignmentsForRead = readsAndPredecessorsForAssignments
                .SelectMany(x =>
                {
                    var (assignment, _, readsAndPredecessors) = x;
                    return readsAndPredecessors.Select(y =>
                    {
                        var (read, _) = y;
                        return (read, assignment);
                    });
                }).GroupBy(x => x.Item1)
                .ToDictionary(x => x.Key, x => x.Select(y => y.Item2).ToList());

            foreach (var (assignment, variableDeclaration, readsAndPredecessors) in readsAndPredecessorsForAssignments)
            {
                if (assignment.NearestAncestorOfType<Root>() == null)
                    continue;

                if (readsAndPredecessors.Count == 0)
                {
                    RemoveStatement((ExpressionStatement)assignment.Parent);
                    madeChanges = true;
                    continue;
                }

                var assignmentRight = assignment.Right;
                if (readsAndPredecessors.Count == 1 || IsConstant(assignmentRight))
                {//Only used once, as the very next thing
                    if (readsAndPredecessors.All(x => assignmentsForRead[x.Item1].Count == 1 && IsSafeToMoveExpressionAlongPath(assignmentRight, x.Item2, x.Item1)))
                    {
                        assignmentRight.Remove();
                        if (readsAndPredecessors.Count == 1)
                        {
                            var read = readsAndPredecessors.Single().Item1;
                            variableReads[variableDeclaration].Remove(read);
                            read.ReplaceWith(assignmentRight);
                        }
                        else
                        {
                            ProcessRemovedLambdaStatements(assignmentRight);
                            foreach (var read in readsAndPredecessors.Select(x => x.Item1).Distinct())
                            {
                                variableReads[variableDeclaration].Remove(read);
                                var clone = AstCloner.Clone(assignmentRight);
                                read.ReplaceWith(clone);
                                ProcessAddedLambdaStatements(clone);
                            }
                        }

                        RemoveStatement((ExpressionStatement)assignment.Parent);
                        madeChanges = true;
                        continue;
                    }
                }

                if (assignmentRight is SimpleNameExpression simpleRightSide 
                    && simpleRightSide.Declaration is VariableDeclaration rightSideVariableDeclaration
                    && rightSideVariableDeclaration.Parent is VariableDeclarationStatement)
                {
                    //In the path that this variable is used, there must be no predecessor assignment to the right side variable that does not go past this assignment.
                    var allFutureReads = readsAndPredecessors.Select(x => x.Item1).ToList();
                    if (!HasPredecessorPathToRightSideVariableAssignment(assignment, rightSideVariableDeclaration, allFutureReads))
                    {
                        foreach (SimpleNameExpression futureRead in allFutureReads)
                        {
                            variableReads[variableDeclaration].Remove(futureRead);
                            futureRead.Name = rightSideVariableDeclaration.Name;
                            futureRead.Declaration = rightSideVariableDeclaration;
                            variableReads[rightSideVariableDeclaration].Add(futureRead);
                        }
                        RemoveStatement((IStatement)assignment.Parent);
                        madeChanges = true;
                        continue;
                    }
                }
            }

            return madeChanges;
        }

        private bool HasPredecessorPathToRightSideVariableAssignment(AssignmentExpression originalAssignment, VariableDeclaration rightSideVariable, IEnumerable<IExpression> reads)
        {
            var originalAssignmentStatement = (ExpressionStatement)originalAssignment.Parent;
            var seenStatements = new HashSet<IStatement>();
            var queue = new Queue<IStatement>();
            foreach (var predecessor in reads.SelectMany(read => predecessors[read.NearestAncestorOfType<IStatement>()]))
            {
                queue.Enqueue(predecessor);
            }

            while (queue.Count > 0)
            {
                var statement = queue.Dequeue();
                if (seenStatements.Contains(statement))
                    continue;
                seenStatements.Add(statement);
                if (statement == originalAssignmentStatement)
                    continue;
                if (statement is ExpressionStatement expressionStatement
                    && expressionStatement.Expression is AssignmentExpression predecessorAssignment
                    && predecessorAssignment.Left is INameExpression predecessorAssignmentTarget
                    && predecessorAssignmentTarget.Declaration == rightSideVariable)
                    return true;
                foreach (var predecessor in predecessors[statement])
                {
                    queue.Enqueue(predecessor);
                }
            }

            return false;
        }

        private void ProcessAddedLambdaStatements(INode node)
        {
            foreach (var lambdaExpression in node.FirstDescendantsOfType<LambdaExpression>())
            {
                var newSuccessors = BuildSuccessorGraph(lambdaExpression);
                var newPredecessors = BuildPredecessorGraph(newSuccessors);
                var (newReads, newWrites) = BuildVariableReadsWritesGraph2(lambdaExpression);

                foreach (var newSuccessor in newSuccessors)
                {
                    successors.Add(newSuccessor.Key, newSuccessor.Value);
                }
                foreach (var newPredecessor in newPredecessors)
                {
                    predecessors.Add(newPredecessor.Key, newPredecessor.Value);
                }

                foreach (var newRead in newReads)
                {
                    variableReads.Add(newRead.Key, newRead.Value);
                }
                foreach (var newWrite in newWrites)
                {
                    variableWrites.Add(newWrite.Key, newWrite.Value);
                }
            }
        }

        private void ProcessRemovedLambdaStatements(INode node)
        {
            foreach (var lambdaExpression in node.FirstDescendantsOfType<LambdaExpression>())
            {
                foreach (var descendant in lambdaExpression.AllDescendantsAndSelf().OfAnyType(typeof(IStatement), typeof(VariableDeclaration)))
                {
                    switch (descendant)
                    {
                        case IStatement statement:
                            predecessors.Remove(statement);
                            successors.Remove(statement);
                            break;
                        case VariableDeclaration variableDeclaration:
                            variableReads.Remove(variableDeclaration);
                            variableWrites.Remove(variableDeclaration);
                            break;
                    }
                }
            }
        }

        private List<(IExpression, HashSet<IStatement>)> FindReadsAndStatementsTowardsRead(VariableDeclaration variableDeclaration, AssignmentExpression assignment)
        {
            var readsForStatement = new Dictionary<IStatement, List<(IExpression, HashSet<IStatement>)>>();
            var queue = new Queue<(IStatement, HashSet<IStatement>)>();
            foreach (var successor in successors[(IStatement)assignment.Parent])
            {
                queue.Enqueue((successor, new HashSet<IStatement>()));
            }

            while (queue.Count > 0)
            {
                var (statement, predecessors) = queue.Dequeue();
                if (readsForStatement.TryGetValue(statement, out var reads))
                {
                    //Add predecessors for this statement
                    foreach (var (_, readPredecessors) in reads)
                    {
                        foreach (var predecessor in predecessors)
                        {
                            readPredecessors.Add(predecessor);
                        }
                    }
                    continue;
                }

                reads = GetReadsOfVariable(statement, variableDeclaration).Select(read => (read, new HashSet<IStatement>(predecessors))).ToList();
                readsForStatement.Add(statement, reads);

                if (HasWritesToVariable(statement, variableDeclaration))
                    continue;

                foreach (var successor in successors[statement])
                {
                    queue.Enqueue((successor, new HashSet<IStatement>(predecessors.Concat(statement))));
                }
            }
            if (readsForStatement.Any(x => readsForStatement.Any(y => x.Key != y.Key && x.Value.Any(z => y.Value.Select(h => h.Item1).Contains(z.Item1)))))
                throw new Exception();
            if (readsForStatement.Any(x => x.Value.Count != x.Value.DistinctBy(y => y.Item1).Count()))
                throw new Exception();

            return readsForStatement.Values.SelectMany(x => x).ToList();
        }

        private IEnumerable<IExpression> GetReadsOfVariable(IStatement statement, VariableDeclaration variableDeclaration)
        {
            return GetUsagesOfVariable(statement, variableDeclaration, false);
        }

        private bool HasWritesToVariable(IStatement statement, VariableDeclaration variableDeclaration)
        {
            return GetWritesToVariable(statement, variableDeclaration).Any();
        }

        private IEnumerable<IExpression> GetWritesToVariable(IStatement statement, VariableDeclaration variableDeclaration)
        {
            return GetUsagesOfVariable(statement, variableDeclaration, true);
        }

        private IEnumerable<IExpression> GetUsagesOfVariable(IStatement statement, VariableDeclaration variableDeclaration, bool usageTypeWrite)
        {
            var expressionChildren = statement.Children.OfType<IExpression>();
            var decendants = expressionChildren.SelectMany(x => x.AllDescendantsAndSelf());
            foreach (var decendant in decendants)
            {
                var isWrite = decendant.Parent is AssignmentExpression assignmentExpression && decendant == assignmentExpression.Left;
                if (isWrite != usageTypeWrite)
                    continue;
                switch (decendant)
                {
                    case SimpleNameExpression simpleNameExpression:
                        if (simpleNameExpression.Declaration == variableDeclaration)
                            yield return simpleNameExpression;
                        break;
                    case MemberExpression memberExpression:
                        if (memberExpression.Declaration == variableDeclaration)
                            yield return memberExpression;
                        break;
                }
            }
        }

        private bool IsSafeToMoveExpressionAlongPath(IExpression expression, HashSet<IStatement> predecessors, IExpression usage)
        {
            //Constant or literally the next expression
            var expressionsBeforeUsage = GetDecendantsInExecutionOrder(usage.NearestAncestorOfType<IStatement>()).TakeWhile(x => x != usage).ToList();
            if (IsConstant(expression) || predecessors.Count == 0 && expressionsBeforeUsage.Count == 0)
                return true;
            GetPossibleExecutionEffects(expression, out var expressionHasReads, out var expressionHasWrites, out var expressionHasSleeps);
            if (expressionHasWrites || expressionHasSleeps)
                return false;
            var variableReads = GetVariableReads(expression).ToList();
            if (!expressionHasReads && variableReads.Count == 0)
                return true;

            foreach (var node in predecessors.Concat<INode>(expressionsBeforeUsage))
            {
                GetPossibleExecutionEffects(node, out _, out var statementHasWrites, out var statementHasSleeps);
                if (statementHasWrites && expressionHasReads || statementHasSleeps)
                    return false;
                if (GetVariableWrites(node).Any(x => variableReads.Contains(x)))
                    return false;
            }
            return true;
        }

        private IEnumerable<IExpression> GetDecendantsInExecutionOrder(INode node)
        {
            if (node == null)
                return Enumerable.Empty<IExpression>();
            switch (node)
            {
                case AssignmentExpression assignmentExpression:
                    return GetDecendantsInExecutionOrder(assignmentExpression.Right)
                        .Concat(assignmentExpression)
                        .Concat(GetDecendantsInExecutionOrder(assignmentExpression.Left));
                case MethodInvocationExpression methodInvocation:
                    return methodInvocation.Arguments.SelectMany(GetDecendantsInExecutionOrder)
                        .Concat(methodInvocation);
                case NativeMethodInvocationExpression methodInvocation:
                    return methodInvocation.Arguments.SelectMany(GetDecendantsInExecutionOrder)
                        .Concat(methodInvocation);
                default:
                    return node.Yield().OfType<IExpression>()
                        .Concat(node.Children.SelectMany(GetDecendantsInExecutionOrder));
            }
        }

        private bool IsConstant(IExpression expression)
        {
            switch (expression)
            {
                case AssignmentExpression _:
                    return false;
                case BinaryExpression binaryExpression:
                    return IsConstant(binaryExpression.Left) && IsConstant(binaryExpression.Right);
                case NativeMethodInvocationExpression nativeMethod:
                    //Todo: Add isConstant to all natives
                    return false;// !nativeMethod.ChangesState && !nativeMethod.ReadsState && !nativeMethod.ModifiesControlFlow && nativeMethod.Arguments.All(IsConstant);
                case SimpleNameExpression simpleNameExpression:
                    return simpleNameExpression.Declaration is EnumValue;
                case MemberExpression memberExpression:
                    return memberExpression.Declaration is EnumValue;
                case NativeTrigger _:
                case ILiteral _:
                case LambdaExpression _:
                    return true;
                default:
                    return false;
            }
        }

        private void GetPossibleExecutionEffects(INode node, out bool hasReads, out bool hasWrites, out bool hasSleeps)
        {
            hasReads = false;
            hasWrites = false;
            hasSleeps = false;
            switch (node)
            {
                case AssignmentExpression assignment:
                    GetPossibleExecutionEffects(assignment.Right, out hasReads, out hasWrites, out hasSleeps);
                    return;
                case NativeMethodInvocationExpression nativeMethodInvocation:
                    hasReads |= nativeMethodInvocation.ReadsState;
                    hasWrites |= nativeMethodInvocation.ChangesState;
                    hasSleeps |= nativeMethodInvocation.NativeMethodName == "Wait";
                    foreach (var argument in nativeMethodInvocation.Arguments)
                    {
                        GetPossibleExecutionEffects(argument, out var argumentHasReads, out var argumentHasWrites, out var argumentHasSleeps);
                        hasReads |= argumentHasReads;
                        hasWrites |= argumentHasWrites;
                        hasSleeps |= argumentHasSleeps;
                    }
                    return;
            }

            foreach (var child in node.Children)
            {
                GetPossibleExecutionEffects(child, out var childHasReads, out var childHasWrites, out var childHasSleeps);
                hasReads |= childHasReads;
                hasWrites |= childHasWrites;
                hasSleeps |= childHasSleeps;
            }
        }

        private IEnumerable<VariableDeclaration> GetVariableReads(INode node)
        {
            return GetVariables(node, true);
        }

        private IEnumerable<VariableDeclaration> GetVariableWrites(INode node)
        {
            return GetVariables(node, false);
        }

        private IEnumerable<VariableDeclaration> GetVariables(INode node, bool reads)
        {
            switch (node)
            {
                case SimpleNameExpression simpleNameExpression:
                    {
                        if (simpleNameExpression.Declaration is VariableDeclaration variableDeclaration)
                        {
                            var isWrite = node.Parent is AssignmentExpression assignment && simpleNameExpression == assignment.Left;
                            if (reads != isWrite)
                                yield return variableDeclaration;
                        }
                        break;
                    }
                case MemberExpression memberExpression:
                    {
                        if (memberExpression.Declaration is VariableDeclaration variableDeclaration)
                        {
                            var isWrite = node.Parent is AssignmentExpression assignment && memberExpression == assignment.Left;
                            if (reads != isWrite)
                                yield return variableDeclaration;
                        }
                        break;
                    }
            }

            foreach (var child in node.Children)
            {
                foreach (var variableDeclaration in GetVariables(child, reads))
                {
                    yield return variableDeclaration;
                }
            }
        }

        private VariableDeclaration GetAssignmentTarget(AssignmentExpression assignmentExpression)
        {
            switch (assignmentExpression.Left)
            {
                case SimpleNameExpression simpleNameExpression:
                    return (VariableDeclaration)simpleNameExpression.Declaration;
                case MemberExpression memberExpression:
                    return (VariableDeclaration)memberExpression.Declaration;
            }
            throw new Exception();
        }

        private bool RemoveReadVariables()
        {
            bool removedVariable = false;
            foreach (var pair in variableReads.ToList())
            {
                if (pair.Value.Count > 0)
                    continue;
                var variable = pair.Key;

                foreach (var expression in variableWrites[variable].ToList())
                {
                    RemoveStatement((ExpressionStatement)expression.Parent.Parent);
                }

                if (variable.Parent is VariableDeclarationStatement statement)
                    RemoveStatement(statement);
                else
                {
                    variable.Remove();
                    RemoveVariablesInRemovedExpression(variable);
                }

                variableReads.Remove(variable);
                variableWrites.Remove(variable);

                removedVariable = true;
            }

            return removedVariable;
        }

        private void SimplifyLambdaMethods(Root root)
        {
            var lambdaExpressions = root.AllDescendantsAndSelf().OfType<LambdaExpression>().Where(x => !(x.Parent is RuleDeclaration)).ToList();
            lambdaExpressions.Reverse();
            foreach (var lambdaExpression in lambdaExpressions)
            {
                var variable = lambdaExpression.Variables.Single();
                if (!(lambdaExpression.Parent is ListLambdaExpression))
                {
                    Errors.Add(new CompilationError(lambdaExpression.Context, "Lambda expressions can only be used in combination with Native.listLambda"));
                }
                if (lambdaExpression.Block.Statements.Count() != 1)
                {
                    Errors.Add(new CompilationError(lambdaExpression.Context, "Unable to simplify lambda expression to a single return statement."));
                    continue;
                }
                if (!(lambdaExpression.Block.Statements.Single() is ReturnStatement returnStatement))
                {
                    Errors.Add(new CompilationError(lambdaExpression.Context, "Missing return statement in lambda function"));
                    continue;
                }

                foreach (var expression in variableWrites[variable])
                {
                    Errors.Add(new CompilationError(expression.Context, "Can not write to the lambda parameter variable"));
                }

                foreach (var variableReference in variableReads[variable].Cast<INameExpression>())
                {
                    if (!variableReference.Declarations.Contains(variable))
                        continue;
                    variableReference.ReplaceWith(NativeMethods.CurrentArrayElement(variableReference.Context));
                }

                RemoveStatement(returnStatement);
                variableReads.Remove(variable);
                variableWrites.Remove(variable);

                switch (lambdaExpression.Parent)
                {
                    case ListLambdaExpression listLambda:
                        listLambda.ReplaceWith(NativeMethods.ListLambda(listLambda.Context, listLambda.Name, listLambda.List, returnStatement.Value));
                        break;
                }
            }
        }

        private void SimplifyRuleTriggers(INode node)
        {
            if (!(node is Root || node is SourceFile || node is ModuleDeclaration || node is RuleDeclaration))
                return;

            if (node is RuleDeclaration ruleDeclaration)
            {
                if (!(ruleDeclaration.Trigger is LambdaExpression lambda)
                    || lambda.Block.Statements.Count() != 1
                    || !(lambda.Block.Statements.Single() is ReturnStatement returnStatement)
                    || !(returnStatement.Value is NativeTrigger trigger))
                    throw new CompilationError(ruleDeclaration.Trigger.Context, "Unable to simplify trigger to a constant expression");
                RemoveStatement(returnStatement);
                RemoveStatement(lambda.Block);
                lambda.ReplaceWith(trigger);
                return;
            }

            foreach (var child in node.Children)
            {
                SimplifyRuleTriggers(child);
            }
        }

        private void SimplifyRuleCondition(Root root)
        {
            foreach (var ruleDeclaration in GetRules(root))
            {
                if (!(ruleDeclaration.Condition is LambdaExpression lambda)
                    || lambda.Block.Statements.Count() != 1
                    || !(lambda.Block.Statements.Single() is ReturnStatement returnStatement))
                    throw new CompilationError(ruleDeclaration.Condition.Context, "Unable to simplify condition to a single expression");
                RemoveStatement(returnStatement);
                RemoveStatement(lambda.Block);
                lambda.ReplaceWith(returnStatement.Value);
            }
        }

        private void MoveStateVariablesToInitializationRules(INode node)
        {
            if (!(node is Root || node is SourceFile || node is ModuleDeclaration || node is RuleDeclaration))
                return;

            if (node is RuleDeclaration ruleDeclaration)
            {
                if (ruleDeclaration.StateVariable != null)
                {
                    var initExpression = ruleDeclaration.StateVariable.InitExpression;
                    initExpression.Remove();
                    var root = node.NearestAncestorOfType<Root>();
                    ExpressionStatement statement;
                    IExpression variableReference;
                    IStatement previousStatement;
                    if (!IsPlayerRule(ruleDeclaration))
                    {
                        variableReference = new SimpleNameExpression(ruleDeclaration.Context, ruleDeclaration.StateVariable.Name)
                        {
                            Declaration = ruleDeclaration.StateVariable
                        };
                        statement = new ExpressionStatement(
                            ruleDeclaration.Context,
                            new AssignmentExpression(ruleDeclaration.Context, new INode[]
                            {
                                variableReference,
                                new AssignmentOperator(ruleDeclaration.Context, "="),
                                initExpression
                            }));
                        previousStatement = root.GlobalVariableInitializer.Action.Block.Statements.LastOrDefault() ?? root.GlobalVariableInitializer.Action.Block;
                        root.GlobalVariableInitializer.Action.Block.AddChild(statement);
                    }
                    else
                    {
                        variableReference = new MemberExpression(ruleDeclaration.Context, ruleDeclaration.StateVariable.Name, new INode[]
                        {
                            NativeMethods.EventPlayer(ruleDeclaration.Context)
                        })
                        {
                            Declaration = ruleDeclaration.StateVariable
                        };
                        statement = new ExpressionStatement(
                            ruleDeclaration.Context,
                            new AssignmentExpression(ruleDeclaration.Context, new INode[]
                            {
                                variableReference,
                                new AssignmentOperator(ruleDeclaration.Context, "="),
                                initExpression
                            }));
                        previousStatement = root.PlayerVariableInitializer.Action.Block.Statements.LastOrDefault() ?? root.PlayerVariableInitializer.Action.Block;
                        root.PlayerVariableInitializer.Action.Block.AddChild(statement);
                    }

                    successors[previousStatement].Add(statement);
                    successors.Add(statement, new List<IStatement>());
                    predecessors.Add(statement, new List<IStatement> { previousStatement });
                    variableWrites[ruleDeclaration.StateVariable].Add(variableReference);
                }

                return;
            }

            foreach (var child in node.Children)
            {
                MoveStateVariablesToInitializationRules(child);
            }
        }

        private bool RemoveGlobalConstants(Root root)
        {
            var hadChanges = false;
            foreach (var variableDeclaration in variableReads.Keys.ToList())
            {
                //Skip local and player variables
                if (variableDeclaration.Parent is VariableDeclarationStatement || variableDeclaration.Parent is ClassDeclaration)
                    continue;
                if (variableWrites[variableDeclaration].Count > 1)
                    continue;
                IStatement initStatement = null;
                IExpression initExpression;
                if (variableWrites[variableDeclaration].Count == 0)
                    initExpression = new NullLiteral(variableDeclaration.Context);
                else if (variableWrites[variableDeclaration][0].IsDescendantOf(root.GlobalVariableInitializer))
                {
                    initExpression = ((AssignmentExpression)variableWrites[variableDeclaration][0].Parent).Right;
                    initStatement = (IStatement)variableWrites[variableDeclaration][0].Parent.Parent;
                }
                else
                    continue;
                if (!IsConstant(initExpression))
                    continue;
                foreach (var read in variableReads[variableDeclaration])
                {
                    read.ReplaceWith(AstCloner.Clone(initExpression));
                }
                if (initStatement != null)
                    RemoveStatement(initStatement);
                variableDeclaration.Remove();
                variableReads.Remove(variableDeclaration);
                variableWrites.Remove(variableDeclaration);
                hadChanges = true;
            }

            return hadChanges;
        }

        private void RemoveLocalVariables(Root root)
        {
            //Is player, is array
            var globalVars = new Dictionary<(bool, bool), List<VariableDeclaration>>();
            globalVars.Add((false, false), new List<VariableDeclaration>());
            globalVars.Add((false, true), new List<VariableDeclaration>());
            globalVars.Add((true, false), new List<VariableDeclaration>());
            globalVars.Add((true, true), new List<VariableDeclaration>());
            foreach (var rule in GetRules(root))
            {
                var assignmentsToLocals = rule.Action.Block
                    .AllDescendantsAndSelf()
                    .OfType<AssignmentExpression>()
                    .Where(x => GetAssignmentTarget(x).Parent is VariableDeclarationStatement)
                    .ToList();
                //Is array, is used across wait
                var locallyUsedVariables = new Dictionary<(bool, bool), List<(VariableDeclaration, HashSet<INode>)>>();
                locallyUsedVariables.Add((false, false), new List<(VariableDeclaration, HashSet<INode>)>());
                locallyUsedVariables.Add((false, true), new List<(VariableDeclaration, HashSet<INode>)>());
                locallyUsedVariables.Add((true, false), new List<(VariableDeclaration, HashSet<INode>)>());
                locallyUsedVariables.Add((true, true), new List<(VariableDeclaration, HashSet<INode>)>());

                var connectedComponents = new List<(List<AssignmentExpression>, List<IExpression>)>();
                foreach (var assignment in assignmentsToLocals)
                {
                    var localVar = GetAssignmentTarget(assignment);
                    var reads = FindReadsAndStatementsTowardsRead(localVar, assignment).Select(x => x.Item1).ToList();
                    var existingComponents = reads.SelectMany(read => connectedComponents.Where(x => x.Item2.Contains(read))).Distinct().ToList();
                    if (existingComponents.Count == 0)
                    {
                        connectedComponents.Add((new List<AssignmentExpression> { assignment }, reads));
                    }
                    else if (existingComponents.Count == 1)
                    {
                        existingComponents[0].Item1.Add(assignment);
                        existingComponents[0].Item2.AddRange(reads.Except(existingComponents[0].Item2));
                    }
                    else
                    {
                        for (int i = 1; i < existingComponents.Count; i++)
                        {
                            existingComponents[0].Item1.AddRange(existingComponents[i].Item1);
                            existingComponents[0].Item2.AddRange(existingComponents[i].Item2.Except(existingComponents[0].Item2));
                            connectedComponents.Remove(existingComponents[i]);
                        }
                        existingComponents[0].Item1.Add(assignment);
                        existingComponents[0].Item2.AddRange(reads.Except(existingComponents[0].Item2));
                    }
                }

                foreach (var connectedComponent in connectedComponents)
                {
                    var (assignments, reads) = connectedComponent;
                    var types = assignments.Select(x => ((VariableDeclaration)((INameExpression)x.Left).Declaration).Type);
                    var isArray = types.Any(x => x.IsList(root));
                    var type = isArray
                        ? types.First(x => x.IsList(root))
                        : types.First();
                    var localVar = GetAssignmentTarget(assignments[0]);
                    var sourceFile = assignments[0].NearestAncestorOfType<SourceFile>();
                    var readsAndPredecessors = assignments.SelectMany(assignment => FindReadsAndStatementsTowardsRead(localVar, assignment))
                        .GroupBy(x => x.Item1)
                        .Select(group =>
                        {
                            var read = group.Key;
                            var usagePaths = new HashSet<IStatement>(group.SelectMany(x => x.Item2));
                            return (read, usagePaths);
                        }).ToList();
                    var nodesBetweenAssignmentAndAllReads = new HashSet<INode>(readsAndPredecessors
                        .SelectMany(x =>
                        {
                            var (read, predecessors) = x;
                            var expressionsBeforeUsage = GetDecendantsInExecutionOrder(read.NearestAncestorOfType<IStatement>()).TakeWhile(y => y != read).ToList();
                            return predecessors
                                .SelectMany(y => y.AllDescendantsAndSelf())
                                .Concat(expressionsBeforeUsage);
                        }));



                    VariableDeclaration newDeclaration;
                    if (nodesBetweenAssignmentAndAllReads.Any(IsWait))
                    {
                        var (globalVariableDeclaration, list) = locallyUsedVariables[(isArray, true)].FirstOrDefault(x =>
                        {
                            var set = new HashSet<INode>(x.Item2);
                            set.IntersectWith(nodesBetweenAssignmentAndAllReads);
                            return set.Count == 0;
                        });
                        if (globalVariableDeclaration != null)
                        {
                            foreach (var nodesBetweenAssignmentAndAllRead in nodesBetweenAssignmentAndAllReads)
                            {
                                list.Add(nodesBetweenAssignmentAndAllRead);
                            }
                            newDeclaration = globalVariableDeclaration;
                        }
                        else
                        {
                            newDeclaration = new VariableDeclaration(localVar.Context, localVar.Name, new INode[] { AstCloner.Clone(type) });
                            if (IsPlayerRule(rule))
                                root.AddChild(newDeclaration);
                            else
                                sourceFile.AddChild(newDeclaration);
                            variableReads.Add(newDeclaration, new List<IExpression>());
                            variableWrites.Add(newDeclaration, new List<IExpression>());
                            locallyUsedVariables[(isArray, true)].Add((newDeclaration, nodesBetweenAssignmentAndAllReads));
                        }
                    }
                    else
                    {
                        var (globalVariableDeclaration, list) = locallyUsedVariables[(isArray, false)].Concat(locallyUsedVariables[(isArray, true)]).FirstOrDefault(x =>
                        {
                            var set = new HashSet<INode>(x.Item2);
                            set.IntersectWith(nodesBetweenAssignmentAndAllReads);
                            return set.Count == 0;
                        });
                        if (globalVariableDeclaration != null)
                        {
                            foreach (var nodesBetweenAssignmentAndAllRead in nodesBetweenAssignmentAndAllReads)
                            {
                                list.Add(nodesBetweenAssignmentAndAllRead);
                            }
                            newDeclaration = globalVariableDeclaration;
                        }
                        else
                        {
                            newDeclaration = globalVars[(isArray, IsPlayerRule(rule))].FirstOrDefault(x => !locallyUsedVariables[(isArray, false)].Exists(y => x == y.Item1));

                            if (newDeclaration == null)
                            {
                                newDeclaration = new VariableDeclaration(localVar.Context, localVar.Name, new INode[] { AstCloner.Clone(type) });
                                if (IsPlayerRule(rule))
                                    root.AddChild(newDeclaration);
                                else
                                    sourceFile.AddChild(newDeclaration);
                                variableReads.Add(newDeclaration, new List<IExpression>());
                                variableWrites.Add(newDeclaration, new List<IExpression>());
                                locallyUsedVariables[(isArray, false)].Add((newDeclaration, nodesBetweenAssignmentAndAllReads));
                            }
                        }
                    }

                    foreach (var assignment in assignments)
                    {
                        ((SimpleNameExpression)assignment.Left).Declaration = newDeclaration;
                        variableWrites[newDeclaration].Add((SimpleNameExpression)assignment.Left);
                    }
                    foreach (SimpleNameExpression read in reads)
                    {
                        read.Declaration = newDeclaration;
                        variableReads[newDeclaration].Add(read);
                    }
                }
                globalVars[(false, IsPlayerRule(rule))].AddRange(locallyUsedVariables[(false, false)].Select(x => x.Item1));
                globalVars[(true, IsPlayerRule(rule))].AddRange(locallyUsedVariables[(true, false)].Select(x => x.Item1));

                foreach (var statement in rule.Action.AllDescendantsAndSelf().OfType<VariableDeclarationStatement>().ToList())
                {
                    RemoveStatement(statement);
                }
            }
        }

        private bool IsWait(INode node)
        {
            return node is NativeMethodInvocationExpression methodInvocation && methodInvocation.NativeMethodName.ToLower() == "wait";
        }

        private bool IsPlayerRule(RuleDeclaration rule)
        {
            return ((NativeTrigger)rule.Trigger).Name != "Ongoing - Global";
        }

        private void RemoveAssertions(Root root)
        {
            foreach (var assertion in root.AllDescendantsAndSelf().OfType<Assertion>().ToList())
            {
                if (assertion.Condition is BooleanLiteral literal && !literal.Value)
                {
                    var message = assertion.Message?.UnquotedText ?? "Assertion failed";
                    Errors.Add(new CompilationError(assertion.Context, message));
                }
                RemoveStatement(assertion);
            }
        }


















        private IEnumerable<RuleDeclaration> GetRules(INode node)
        {
            if (node is RuleDeclaration ruleDeclaration)
            {
                yield return ruleDeclaration;
                yield break;
            }

            foreach (var child in node.Children.ToList())
            {
                foreach (var rule in GetRules(child))
                {
                    yield return rule;
                }
            }
        }
















        private void RemoveStatement(IStatement statement)
        {
            foreach (var predecessor in predecessors[statement])
            {
                successors[predecessor].Remove(statement);
                successors[predecessor].AddRange(successors[statement]);
            }
            foreach (var successor in successors[statement])
            {
                predecessors[successor].Remove(statement);
                predecessors[successor].AddRange(predecessors[statement]);
            }
            successors.Remove(statement);
            predecessors.Remove(statement);
            statement.Remove();

            RemoveVariablesInRemovedExpression(statement);
        }

        private void RemoveVariablesInRemovedExpression(INode node)
        {
            foreach (var decendant in node.AllDescendantsAndSelf())
            {
                switch (decendant)
                {
                    case SimpleNameExpression simpleNameExpression:
                        {
                            if (simpleNameExpression.Declaration is VariableDeclaration variableDeclaration)
                            {
                                variableReads[variableDeclaration].Remove(simpleNameExpression);
                                variableWrites[variableDeclaration].Remove(simpleNameExpression);
                            }

                            break;
                        }
                    case MemberExpression memberExpression:
                        {
                            if (memberExpression.Declaration is VariableDeclaration variableDeclaration)
                            {
                                variableReads[variableDeclaration].Remove(memberExpression);
                                variableWrites[variableDeclaration].Remove(memberExpression);
                            }

                            break;
                        }
                    case VariableDeclaration variableDeclaration:
                        {
                            variableReads.Remove(variableDeclaration);
                            variableWrites.Remove(variableDeclaration);
                            break;
                        }
                }
            }
        }




        private void ValidateSuccessorsAndPredecessorsa(Root root)
        {
            var currentSuccessors = BuildSuccessorGraph(root);
            var currentPredecessors = BuildPredecessorGraph(successors);

            foreach (var pair in currentSuccessors)
            {
                if (!successors.TryGetValue(pair.Key, out var existingList))
                    throw new Exception();
                if (!pair.Value.All(existingList.Contains))
                    throw new Exception();
            }
            foreach (var pair in currentPredecessors)
            {
                if (!predecessors.TryGetValue(pair.Key, out var existingList))
                    throw new Exception();
                if (!pair.Value.All(existingList.Contains))
                    throw new Exception();
            }
            foreach (var pair in successors)
            {
                if (!currentSuccessors.TryGetValue(pair.Key, out var existingList))
                    throw new Exception();
                if (!pair.Value.All(existingList.Contains))
                    throw new Exception();
            }
            foreach (var pair in predecessors)
            {
                if (!currentPredecessors.TryGetValue(pair.Key, out var existingList))
                    throw new Exception();
                if (!pair.Value.All(existingList.Contains))
                    throw new Exception();
            }
        }
    }
}