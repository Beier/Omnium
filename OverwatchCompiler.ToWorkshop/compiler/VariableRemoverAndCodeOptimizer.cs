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
        private readonly Dictionary<IStatement, List<IStatement>> successors = new Dictionary<IStatement, List<IStatement>>();
        private readonly Dictionary<IStatement, List<IStatement>> predecessors = new Dictionary<IStatement, List<IStatement>>();
        private readonly Dictionary<VariableDeclaration, List<IExpression>> variableReads = new Dictionary<VariableDeclaration, List<IExpression>>();
        private readonly Dictionary<VariableDeclaration, List<IExpression>> variableWrites = new Dictionary<VariableDeclaration, List<IExpression>>();


        public override void EnterRoot(Root root)
        {
            BuildSuccessorGraph(root);
            BuildPredecessorGraph();
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

        private void BuildSuccessorGraph(INode node)
        {
            if (!(node is IStatement || node is Root || node is SourceFile || node is ModuleDeclaration || node is RuleDeclaration || node is LambdaExpression))
                return;

            if (node is IStatement statement)
            {
                successors.Add(statement, GetSuccessors(statement).ToList());
            }

            foreach (var child in node.Children)
            {
                BuildSuccessorGraph(child);
            }
        }

        private void BuildPredecessorGraph()
        {
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
                
                var usagePaths = UsagePaths(variableDeclaration, assignment).ToList();
                if (usagePaths.Count == 0)
                {
                    RemoveStatement((ExpressionStatement)assignment.Parent);
                    madeChanges = true;
                    continue;
                }

                var assignmentRight = assignment.Right;
                if (usagePaths.Count == 1 && IsSafeToMoveExpressionAlongPath(assignmentRight, usagePaths[0]))
                {//Only used once, as the very next thing
                    var usage = (IExpression)usagePaths[0].Last();
                    variableReads[variableDeclaration].Remove(usage);
                    assignmentRight.Remove();
                    usage.ReplaceWith(assignmentRight);
                    RemoveStatement((ExpressionStatement)assignment.Parent);
                    madeChanges = true;
                    continue;
                }

                //Todo: Move if right side can safely be moved across all statements in-between.

            }

            return madeChanges;
        }

        private bool IsSafeToMoveExpressionAlongPath(IExpression expression, List<INode> path)
        {
            //Constant or literally the next expression
            if (IsConstant(expression) || path.OfType<IStatement>().Count() == 1 && path.OfType<IExpression>().Count() == 1)
                return true;
            GetPossibleExecutionEffects(expression, out var expressionHasReads, out var expressionHasWrites, out var expressionHasSleeps);
            if (expressionHasWrites || expressionHasSleeps)
                return false;
            var variableReads = GetVariableReads(expression).ToList();
            if (!expressionHasReads && variableReads.Count == 0)
                return true;

            var statements = path.TakeWhile(x => x is IStatement).Cast<IStatement>().ToList();
            var pathToUsage = statements.Last().Yield().Concat(path.SkipWhile(x => x is IStatement)).ToList();
            statements.RemoveAt(statements.Count - 1);
            foreach (var statement in statements)
            {
                GetPossibleExecutionEffects(statement, out _, out var statementHasWrites, out var statementHasSleeps);
                if (statementHasWrites && expressionHasReads || statementHasSleeps)
                    return false;
                if (GetVariableWrites(statement).Any(x => variableReads.Contains(x)))
                    return false;
            }

            for (int i = 0; i < pathToUsage.Count - 1; i++)
            {
                var indexOfNext = pathToUsage[i].Children.IndexOf(pathToUsage[i + 1]);
                foreach (var node in pathToUsage[i].Children.Take(indexOfNext))
                {
                    GetPossibleExecutionEffects(node, out _, out var statementHasWrites, out var statementHasSleeps);
                    if (statementHasWrites && expressionHasReads || statementHasSleeps)
                        return false;
                    if (GetVariableWrites(node).Any(x => variableReads.Contains(x)))
                        return false;
                }
            }

            return true;
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

        private List<List<INode>> UsagePaths(VariableDeclaration variableDeclaration, AssignmentExpression assignment)
        {
            var parent = (ExpressionStatement)assignment.Parent;
            var successorPaths = GetAllSuccessorPaths(parent);
            var usagePaths = new List<List<INode>>();
            foreach (var successorPath in successorPaths)
            {
                //Remove the initial assignment
                successorPath.RemoveAt(0);
                //Remove everything after a subsequent assignment
                for (int i = 0; i < successorPath.Count; i++)
                {
                    if (successorPath[i] is ExpressionStatement es && es.Expression is AssignmentExpression ass)
                    {
                        var assTarget = GetAssignmentTarget(ass);
                        if (assTarget == variableDeclaration)
                        {
                            successorPath.RemoveRange(i + 1, successorPath.Count - i - 1);
                            break;
                        }
                    }
                }

                for (int i = 0; i < successorPath.Count; i++)
                {
                    var decendants = successorPath[i].AllDescendantsAndSelf().ToList();
                    for (int j = 0; j < decendants.Count; j++)
                    {
                        if (IsReadOfVariable(decendants[j], variableDeclaration))
                        {
                            var usagePath = successorPath.Take(i).Concat(decendants.Take(j + 1)).ToList();
                            if (!usagePaths.Exists(x => x.Count == usagePath.Count && x.SequenceEqual(usagePath)))
                                usagePaths.Add(usagePath);
                        }
                    }
                }

            }

            return usagePaths;
        }

        private bool IsReadOfVariable(INode node, VariableDeclaration variableDeclaration)
        {
            if (node.Parent is AssignmentExpression assignment && node == assignment.Left)
                return false;
            switch (node)
            {
                case SimpleNameExpression simpleNameExpression:
                    return simpleNameExpression.Declaration == variableDeclaration;
                case MemberExpression memberExpression:
                    return memberExpression.Declaration == variableDeclaration;
            }

            return false;
        }

        private List<List<IStatement>> GetAllSuccessorPaths(IStatement statement)
        {
            Queue<List<IStatement>> paths = new Queue<List<IStatement>>();
            List<List<IStatement>> finishedPaths = new List<List<IStatement>>();
            paths.Enqueue(new List<IStatement> { statement });
            while (paths.Any())
            {
                var path = paths.Dequeue();
                var lastNode = path.Last();
                var nodeSuccessors = successors[lastNode];
                if (nodeSuccessors.Count == 0)
                    finishedPaths.Add(path);
                else
                {
                    foreach (var successor in nodeSuccessors)
                    {
                        if (path.Contains(successor))
                            finishedPaths.Add(path);
                        else
                            paths.Enqueue(path.Concat(successor.Yield()).ToList());
                    }
                }
            }

            return finishedPaths;
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
                var usedVariablesWithoutWait = new List<(VariableDeclaration, List<List<INode>>)>();
                var usedVariablesWithWaits = new List<(VariableDeclaration, List<List<INode>>)>();

                //Todo: could maybe be optimized to reduce number of variables.
                foreach (var assignment in assignmentsToLocals)
                {
                    var sourceFile = assignment.NearestAncestorOfType<SourceFile>();
                    var localVar = GetAssignmentTarget(assignment);
                    var usagePaths = UsagePaths(localVar, assignment).ToList();
                    VariableDeclaration newDeclaration;
                    if (usagePaths.Any(DoesUsagePathCrossWait))
                    {
                        var (globalVariableDeclaration, list) = usedVariablesWithWaits.FirstOrDefault(x => x.Item2.All(y => usagePaths.All(z => !DoesUsagePathsOverlap(y, z))));
                        if (globalVariableDeclaration != null)
                        {
                            list.AddRange(usagePaths);
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
                            usedVariablesWithWaits.Add((newDeclaration, usagePaths));
                        }
                    }
                    else
                    {
                        var (globalVariableDeclaration, list) = usedVariablesWithoutWait.FirstOrDefault(x => x.Item2.All(y => usagePaths.All(z => !DoesUsagePathsOverlap(y, z))));
                        if (globalVariableDeclaration != null)
                        {
                            list.AddRange(usagePaths);
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
                                usedVariablesWithoutWait.Add((newDeclaration, usagePaths));
                            }
                        }
                    }

                    ((SimpleNameExpression)assignment.Left).Declaration = newDeclaration;
                    variableWrites[newDeclaration].Add((SimpleNameExpression)assignment.Left);
                    foreach (var usagePath in usagePaths)
                    {
                        var target = (SimpleNameExpression)usagePath.Last();
                        target.Declaration = newDeclaration;
                        variableReads[newDeclaration].Add(target);
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

        private bool DoesUsagePathCrossWait(List<INode> usagePath)
        {
            return usagePath
                .OfType<IStatement>()
                .SelectMany(x => x.AllDescendantsAndSelf())
                .OfType<NativeMethodInvocationExpression>()
                .Any(x => x.NativeMethodName == "Wait");
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
    }
}