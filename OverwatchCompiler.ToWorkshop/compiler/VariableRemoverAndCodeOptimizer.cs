using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
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

            SimplifyRuleTriggers(root);
            SimplifyRuleCondition(root);
            MoveStateVariablesToInitializationRules(root);

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
        
        private Dictionary<IStatement, List<IStatement>> BuildSuccessorGraph(Root root)
        {
            var successors = new Dictionary<IStatement, List<IStatement>>();
            var statements = root.AllDescendantsAndSelf().OfType<IStatement>().ToList();

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


        private void ValidateVariableReadsWritesGrapha(INode node)
        {
            var (reads, writes) = BuildVariableReadsWritesGraph2(node);
            foreach (var read in reads)
            {
                if (variableReads[read.Key].Count != read.Value.Count
                    || !variableReads[read.Key].SequenceEqual(read.Value))
                    throw new Exception();
            }
            foreach (var write in writes)
            {
                if (variableWrites[write.Key].Count != write.Value.Count
                    || !variableWrites[write.Key].SequenceEqual(write.Value))
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
            var hasRemovedStatement = false;
            foreach (var predecessor in predecessors.ToList())
            {
                var statement = predecessor.Key;
                if (predecessor.Value.Any() || statement.Parent is LambdaExpression)
                    continue;

                RemoveStatement(statement);

                hasRemovedStatement = true;
            }

            return hasRemovedStatement;
        }

        private bool RemoveRedundantGotos()
        {
            var root = successors.First().Key.NearestAncestorOfType<Root>();
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
                            var parent = (BlockStatement)gotoStatement.Parent;
                            var gotoStatementIndex = parent.Statements.IndexOf(gotoStatement);
                            if (successorPair.Value.All(successor =>
                            {
                                var successorParent = successor.Parent as BlockStatement;
                                return successorParent == parent && parent.Statements.IndexOf(successor) == gotoStatementIndex + 1;
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
            var assignments = root.AllDescendantsAndSelf().OfType<AssignmentExpression>().ToList();
            foreach (var assignment in assignments)
            {
                //Assignments to global or player variables should not be moved
                var variableDeclaration = GetAssignmentTarget(assignment);
                if (!(variableDeclaration.Parent is VariableDeclarationStatement))
                    continue;
                
                var readsAndPredecessors = FindReadsAndStatementsTowardsRead(variableDeclaration, assignment);
                if (readsAndPredecessors.Count == 0)
                {
                    RemoveStatement((ExpressionStatement)assignment.Parent);
                    madeChanges = true;
                    continue;
                }

                var assignmentRight = assignment.Right;
                if (readsAndPredecessors.Count == 1 || IsConstant(assignmentRight))
                {//Only used once, as the very next thing
                    if (readsAndPredecessors.All(x => IsSafeToMoveExpressionAlongPath(assignmentRight, x.Item2, x.Item1)))
                    {
                        assignmentRight.Remove();
                        foreach (var (read, _) in readsAndPredecessors)
                        {
                            variableReads[variableDeclaration].Remove(read);
                            read.ReplaceWith(AstCloner.Clone(assignmentRight));
                        }
                        RemoveStatement((ExpressionStatement)assignment.Parent);
                        madeChanges = true;
                        continue;
                    }
                }

                //Todo: Move if right side can safely be moved across all statements in-between.

            }

            return madeChanges;
        }

        private List<(IExpression, HashSet<IStatement>)> FindReadsAndStatementsTowardsRead(VariableDeclaration variableDeclaration, AssignmentExpression assignment)
        {
            var readsForStatement = new Dictionary<IStatement, List<(IExpression, HashSet<IStatement>)>>();
            var queue = new Queue<(IStatement, HashSet<IStatement>)>();
            foreach (var successor in successors[(IStatement) assignment.Parent])
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
            foreach (var decendant in statement.AllDescendantsAndSelf())
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
                    return !nativeMethod.ChangesState && !nativeMethod.ReadsState && !nativeMethod.ModifiesControlFlow && nativeMethod.Arguments.All(IsConstant);
                case SimpleNameExpression simpleNameExpression:
                    return simpleNameExpression.Declaration is EnumValue;
                case MemberExpression memberExpression:
                    return memberExpression.Declaration is EnumValue;
                case NativeTrigger _:
                case ILiteral _:
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
            var globalVarsForLocalVars = new List<VariableDeclaration>();
            var globalPlayerVarsForLocalVars = new List<VariableDeclaration>();
            foreach (var rule in GetRules(root))
            {
                var assignmentsToLocals = rule.Action.Block
                    .AllDescendantsAndSelf()
                    .OfType<AssignmentExpression>()
                    .Where(x => GetAssignmentTarget(x).Parent is VariableDeclarationStatement)
                    .ToList();
                var usedVariablesWithoutWait = new List<(VariableDeclaration, HashSet<INode>)>();
                var usedVariablesWithWaits = new List<(VariableDeclaration, HashSet<INode>)>();

                //Todo: could maybe be optimized to reduce number of variables.
                foreach (var assignment in assignmentsToLocals)
                {
                    var sourceFile = assignment.NearestAncestorOfType<SourceFile>();
                    var localVar = GetAssignmentTarget(assignment);
                    var readsAndPredecessors = FindReadsAndStatementsTowardsRead(localVar, assignment);
                    var reads = readsAndPredecessors.Select(x => x.Item1).ToList();
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
                        var (globalVariableDeclaration, list) = usedVariablesWithWaits.FirstOrDefault(x =>
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
                            newDeclaration = new VariableDeclaration(assignment.Context, localVar.Name, new INode[0]);
                            if (IsPlayerRule(rule))
                                root.AddChild(newDeclaration);
                            else
                                sourceFile.AddChild(newDeclaration);
                            variableReads.Add(newDeclaration, new List<IExpression>());
                            variableWrites.Add(newDeclaration, new List<IExpression>());
                            usedVariablesWithWaits.Add((newDeclaration, nodesBetweenAssignmentAndAllReads));
                        }
                    }
                    else
                    {
                        var (globalVariableDeclaration, list) = usedVariablesWithoutWait.FirstOrDefault(x =>
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
                            if (IsPlayerRule(rule))
                                newDeclaration = globalPlayerVarsForLocalVars.FirstOrDefault(x => !usedVariablesWithoutWait.Exists(y => x == y.Item1));
                            else
                                newDeclaration = globalVarsForLocalVars.FirstOrDefault(x => !usedVariablesWithoutWait.Exists(y => x == y.Item1));
                            if (newDeclaration == null)
                            {
                                newDeclaration = new VariableDeclaration(assignment.Context, localVar.Name, new INode[0]);
                                if (IsPlayerRule(rule))
                                    root.AddChild(newDeclaration);
                                else
                                    sourceFile.AddChild(newDeclaration);
                                variableReads.Add(newDeclaration, new List<IExpression>());
                                variableWrites.Add(newDeclaration, new List<IExpression>());
                                usedVariablesWithoutWait.Add((newDeclaration, nodesBetweenAssignmentAndAllReads));
                            }
                        }
                    }

                    ((SimpleNameExpression)assignment.Left).Declaration = newDeclaration;
                    variableWrites[newDeclaration].Add((SimpleNameExpression)assignment.Left);
                    foreach (SimpleNameExpression read in reads)
                    {
                        read.Declaration = newDeclaration;
                        variableReads[newDeclaration].Add(read);
                    }
                }
                if (IsPlayerRule(rule))
                    globalPlayerVarsForLocalVars.AddRange(usedVariablesWithoutWait.Select(x => x.Item1));
                else
                    globalVarsForLocalVars.AddRange(usedVariablesWithoutWait.Select(x => x.Item1));

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

        private bool DoesUsagePathsOverlap(List<INode> usagePath1, List<INode> usagePath2)
        {
            return usagePath1.Any(usagePath2.Contains);
        }

        private bool IsPlayerRule(RuleDeclaration rule)
        {
            return ((NativeTrigger)rule.Trigger).Name != "Ongoing - Global";
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


        //private void ValidateSuccessorsAndPredecessors(Root root)
        //{
        //    var currentSuccessors = BuildSuccessorGraph(root);
        //    var currentPredecessors = BuildPredecessorGraph(successors);

        //    foreach (var pair in currentSuccessors)
        //    {
        //        if (!successors.TryGetValue(pair.Key, out var existingList))
        //            throw new Exception();
        //        if (!pair.Value.All(existingList.Contains))
        //            throw new Exception();
        //    }
        //    foreach (var pair in currentPredecessors)
        //    {
        //        if (!predecessors.TryGetValue(pair.Key, out var existingList))
        //            throw new Exception();
        //        if (!pair.Value.All(existingList.Contains))
        //            throw new Exception();
        //    }
        //    foreach (var pair in successors)
        //    {
        //        if (!currentSuccessors.TryGetValue(pair.Key, out var existingList))
        //            throw new Exception();
        //        if (!pair.Value.All(existingList.Contains))
        //            throw new Exception();
        //    }
        //    foreach (var pair in predecessors)
        //    {
        //        if (!currentPredecessors.TryGetValue(pair.Key, out var existingList))
        //            throw new Exception();
        //        if (!pair.Value.All(existingList.Contains))
        //            throw new Exception();
        //    }
        //}
    }
}