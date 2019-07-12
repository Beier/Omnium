using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;

namespace Omnium.Core.compiler
{
    public class CodeGenerator : TreeValueWalker<StringBuilder>
    {
        public Dictionary<VariableDeclaration, (string, int?)> variableAssignments = new Dictionary<VariableDeclaration, (string, int?)>();

        public override StringBuilder VisitRoot(Root root)
        {
            var letters = Enumerable.Range('A', 'Z' - 'A' + 1).Select(x => ((char)x).ToString()).ToList();
            var playerVariables = root.PlayerVariableDeclarations.ToList();
            var globalVariables = root.SourceFiles.SelectMany(x => x.AllDescendantsAndSelf()).OfType<VariableDeclaration>().ToList();
            if (playerVariables.Count(x => x.Type.IsList(root)) + playerVariables.Count(x => !x.Type.IsList(root))/1000 > letters.Count)
                throw new CompilationError(null, "Number of player variables exceeds supported number.");
            if (globalVariables.Count(x => x.Type.IsList(root)) + globalVariables.Count(x => !x.Type.IsList(root)) / 1000 > letters.Count)
                throw new CompilationError(null, "Number of global variables exceeds supported number.");
            int usedVariables = 1;
            int variableUsedForSingleValues = 0;
            int numberOfVariablesInArray = 0;
            foreach (var playerVariable in playerVariables)
            {
                if (playerVariable.Type.IsList(root))
                {
                    variableAssignments.Add(playerVariable, (letters[usedVariables], null));
                    usedVariables++;
                }
                else
                {
                    variableAssignments.Add(playerVariable, (letters[variableUsedForSingleValues], numberOfVariablesInArray));
                    numberOfVariablesInArray++;
                    if (numberOfVariablesInArray >= 1000)
                    {
                        variableUsedForSingleValues = usedVariables;
                        numberOfVariablesInArray = 0;
                        usedVariables++;
                    }
                }
            }
            usedVariables = 1;
            variableUsedForSingleValues = 0;
            numberOfVariablesInArray = 0;
            foreach (var globalVariable in globalVariables)
            {
                if (globalVariable.Type.IsList(root))
                {
                    variableAssignments.Add(globalVariable, (letters[usedVariables], null));
                    usedVariables++;
                }
                else
                {
                    variableAssignments.Add(globalVariable, (letters[variableUsedForSingleValues], numberOfVariablesInArray));
                    numberOfVariablesInArray++;
                    if (numberOfVariablesInArray >= 1000)
                    {
                        variableUsedForSingleValues = usedVariables;
                        numberOfVariablesInArray = 0;
                        usedVariables++;
                    }
                }
            }

            return base.VisitRoot(root);
        }

        public override StringBuilder VisitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            var builder = new StringBuilder();
            if (!ruleDeclaration.Action.Block.Statements.Any())
                return builder;
            AppendLine(builder, $"rule(\"{ruleDeclaration.Name}\")");
            AppendLine(builder, "{");
            indents++;
            AppendLine(builder, "event");
            AppendLine(builder, "{");
            indents++;
            builder.Append(Visit(ruleDeclaration.Trigger));
            indents--;
            AppendLine(builder, "}");
            AppendLine(builder);
            if (!(ruleDeclaration.Condition is BooleanLiteral booleanLiteral && booleanLiteral.Value))
            {
                AppendLine(builder, "conditions");
                AppendLine(builder, "{");
                indents++;
                foreach (var expression in SplitAndExpressions(ruleDeclaration.Condition).ToList())
                {
                    var comparison = EnsureIsComparison(expression);
                    var line = ProcessComparison(comparison, isRuleCondition: true);
                    AppendLine(builder, line.Append(";"));
                }
                indents--;
                AppendLine(builder, "}");
                AppendLine(builder);
            }
            AppendLine(builder, "actions");
            AppendLine(builder, "{");
            indents++;
            builder.Append(Visit(ruleDeclaration.Action.Block));
            indents--;
            AppendLine(builder, "}");
            indents--;
            AppendLine(builder, "}");
            AppendLine(builder);
            return builder;
        }

        public override StringBuilder VisitSourceFile(SourceFile sourceFile)
        {
            var builder = new StringBuilder();
            foreach (var child in sourceFile.Children)
            {
                builder.Append(Visit(child));
            }

            return builder;
        }

        public override StringBuilder VisitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            var builder = new StringBuilder();
            foreach (var child in moduleDeclaration.Children)
            {
                builder.Append(Visit(child));
            }

            return builder;
        }

        public override StringBuilder VisitEnumDeclaration(EnumDeclaration enumDeclaration)
        {
            return new StringBuilder();
        }

        private IEnumerable<IExpression> SplitAndExpressions(IExpression expression)
        {
            if (expression is BinaryExpression binaryExpression && binaryExpression.Operator.Text == "&&")
            {
                foreach (var subExpression in SplitAndExpressions(binaryExpression.Left))
                {
                    yield return subExpression;
                }
                foreach (var subExpression in SplitAndExpressions(binaryExpression.Right))
                {
                    yield return subExpression;
                }
            }
            else
            {
                yield return expression;
            }
        }

        private BinaryExpression EnsureIsComparison(IExpression expression)
        {
            var comparisonOperators = new[] {"==", "!=", "<", "<=", ">", ">="};
            if (expression is BinaryExpression binaryExpression
                && comparisonOperators.Contains(binaryExpression.Operator.Text))
                return binaryExpression;
            
            binaryExpression = new BinaryExpression(expression.Context, new INode[0]);
            expression.ReplaceWith(binaryExpression);
            binaryExpression.AddChild(expression);
            binaryExpression.AddChild(new Token(expression.Context, "=="));
            binaryExpression.AddChild(new BooleanLiteral(expression.Context, "true"));
            return binaryExpression;
        }

        public override StringBuilder VisitNativeTrigger(NativeTrigger nativeTrigger)
        {
            var builder = new StringBuilder();
            AppendLine(builder, new StringBuilder(nativeTrigger.Name).Append(";"));
            foreach (var argument in nativeTrigger.Arguments)
            {
                AppendLine(builder, Visit(argument).Append(";"));
            }

            return builder;
        }

        public override StringBuilder VisitBlockStatement(BlockStatement blockStatement)
        {
            var builder = new StringBuilder();
            foreach (var statement in blockStatement.Statements)
            {
                var line = Visit(statement);
                if (line.Length > 0)
                    AppendLine(builder, line);
            }
            return builder;
        }

        public override StringBuilder VisitExpressionStatement(ExpressionStatement expressionStatement)
        {
            return Visit(expressionStatement.Expression).Append(";");
        }

        public override StringBuilder VisitGotoStatement(GotoStatement gotoStatement)
        {
            var target = gotoStatement.TargetStatement;
            var block = (BlockStatement)gotoStatement.Parent;

            var hasFoundStart = false;
            int count = 0;
            foreach (var statement in block.Statements)
            {
                if (hasFoundStart)
                {
                    if (statement == target)
                        break;
                    if (!(statement is GotoTargetStatement))
                        count++;
                }
                else if (statement == gotoStatement)
                    hasFoundStart = true;
            }

            if (gotoStatement.Condition != null)
                return new StringBuilder("Skip If(")
                    .Append(Visit(gotoStatement.Condition))
                    .Append(", ")
                    .Append(count)
                    .Append(");");
            return new StringBuilder("Skip(")
                .Append(count)
                .Append(");");
        }

        public override StringBuilder VisitGotoTargetStatement(GotoTargetStatement gotoTargetStatement)
        {
            return new StringBuilder();
        }

        public override StringBuilder VisitReturnStatement(ReturnStatement returnStatement)
        {
            return new StringBuilder("Abort;");
        }

        public override StringBuilder VisitSimpleNameExpression(SimpleNameExpression simpleNameExpression)
        {
            switch (simpleNameExpression.Declaration)
            {
                case EnumValue enumValue:
                    return new StringBuilder(enumValue.Value.UnquotedText);
                case VariableDeclaration variableDeclaration:
                    {
                        var builder = new StringBuilder();
                        var (letter, index) = variableAssignments[variableDeclaration];
                        if (index != null)
                            builder.Append("Value in Array(");

                        if (IsPlayerVariable(variableDeclaration))
                            builder.Append("Player Variable(Event Player, ");
                        else
                            builder.Append("Global Variable(");
                        builder.Append(letter);
                        builder.Append(")");
                        if (index != null)
                        {
                            builder.Append(", ");
                            builder.Append(index.Value);
                            builder.Append(")");
                        }
                        return builder;
                    }
                default:
                    throw new Exception();
            }
        }

        public override StringBuilder VisitMemberExpression(MemberExpression memberExpression)
        {
            switch (memberExpression.Declaration)
            {
                case EnumValue enumValue:
                    return new StringBuilder(enumValue.Value.UnquotedText);
                case VariableDeclaration variableDeclaration:
                {
                    var builder = new StringBuilder();
                    if (IsPlayerVariable(variableDeclaration))
                    {
                        builder.Append("Player Variable(");
                        builder.Append(Visit(memberExpression.Base));
                        builder.Append(", ");
                    }
                    else
                        builder.Append("Global Variable(");
                    builder.Append(variableAssignments[variableDeclaration]);
                    builder.Append(")");
                    return builder;
                }
                default:
                    throw new Exception();
            }
        }

        private bool IsPlayerVariable(VariableDeclaration variableDeclaration)
        {
            return variableDeclaration.Parent is Root;
        }

        public override StringBuilder VisitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            return new StringBuilder();
        }

        public override StringBuilder VisitBooleanLiteral(BooleanLiteral booleanLiteral)
        {
            return new StringBuilder(booleanLiteral.Text);
        }

        public override StringBuilder VisitNullLiteral(NullLiteral nullLiteral)
        {
            return new StringBuilder("Null");
        }

        public override StringBuilder VisitNumberLiteral(NumberLiteral numberLiteral)
        {
            return new StringBuilder(numberLiteral.Text);
        }

        public override StringBuilder VisitStringLiteral(StringLiteral stringLiteral)
        {
            return new StringBuilder(stringLiteral.Text);
        }

        public override StringBuilder VisitAssignmentExpression(AssignmentExpression assignmentExpression)
        {
            VariableDeclaration target;
            IExpression @base = null;
            IExpression index = null;
            switch (assignmentExpression.Left)
            {
                case SimpleNameExpression simpleNameExpression:
                    target = (VariableDeclaration)simpleNameExpression.Declaration;
                    break;
                case MemberExpression memberExpression:
                    target = (VariableDeclaration)memberExpression.Declaration;
                    @base = memberExpression.Base;
                    break;
                case ArrayIndexExpression arrayIndexExpression:
                    switch (arrayIndexExpression.Array)
                    {
                        case SimpleNameExpression simpleNameExpression:
                            target = (VariableDeclaration)simpleNameExpression.Declaration;
                            break;
                        case MemberExpression memberExpression:
                            target = (VariableDeclaration)memberExpression.Declaration;
                            @base = memberExpression.Base;
                            break;
                        default:
                            throw new Exception();
                    }

                    index = arrayIndexExpression.Index;
                    break;
                default:
                    throw new Exception();
            }

            var builder = new StringBuilder();
            List<StringBuilder> arguments = new List<StringBuilder>();
            if (IsPlayerVariable(target))
            {
                if (@base == null)
                    @base = NativeMethods.EventPlayer(assignmentExpression.Context);
                arguments.Add(Visit(@base));
                builder.Append("Set Player Variable");
            }
            else
            {
                builder.Append("Set Global Variable");
            }

            var (letter, variableIndex) = variableAssignments[target];
            if (variableIndex != null)
            {
                if (index != null)
                    throw new Exception("Array variable should not be stored in an array.");
                index = new NumberLiteral(assignmentExpression.Context, variableIndex.Value);
            }

            arguments.Add(new StringBuilder(letter));

            if (index != null)
            {
                builder.Append(" At Index");
                arguments.Add(Visit(index));
            }

            arguments.Add(Visit(assignmentExpression.Right));

            builder.Append("(");
            for (int i = 0; i < arguments.Count; i++)
            {
                if (i != 0)
                    builder.Append(", ");
                builder.Append(arguments[i]);
            }

            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitBinaryExpression(BinaryExpression binaryExpression)
        {
            string methodName;
            switch (binaryExpression.Operator.Text)
            {
                case "==":
                case "!=":
                case "<":
                case "<=":
                case ">":
                case ">=":
                    return ProcessComparison(binaryExpression);
                case "||":
                    methodName = "Or";
                    break;
                case "&&":
                    methodName = "And";
                    break;
                case "+":
                    methodName = "Add";
                    break;
                case "-":
                    methodName = "Subtract";
                    break;
                case "*":
                    methodName = "Multiply";
                    break;
                case "/":
                    methodName = "Divide";
                    break;
                case "%":
                    methodName = "Modulo";
                    break;
                default:
                    throw new Exception();
            }

            return new StringBuilder(methodName)
                .Append("(")
                .Append(Visit(binaryExpression.Left))
                .Append(", ")
                .Append(Visit(binaryExpression.Right))
                .Append(")");
        }

        private StringBuilder ProcessComparison(BinaryExpression binaryExpression, bool isRuleCondition = false)
        {
            var builder = new StringBuilder();
            if (!isRuleCondition)
                builder.Append("Compare(");
            builder.Append(Visit(binaryExpression.Left));
            if (isRuleCondition)
                builder.Append(" ");
            else
                builder.Append(", ");
            builder.Append(binaryExpression.Operator.Text);
            if (isRuleCondition)
                builder.Append(" ");
            else
                builder.Append(", ");
            builder.Append(Visit(binaryExpression.Right));
            if (!isRuleCondition)
                builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitUnaryExpression(UnaryExpression unaryExpression)
        {
            switch (unaryExpression.Operator.Text)
            {
                case "!":
                    return new StringBuilder("Not")
                        .Append("(")
                        .Append(Visit(unaryExpression.Base))
                        .Append(")");
                default:
                    throw new Exception();
            }
        }

        public override StringBuilder VisitNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression)
        {
            var builder = new StringBuilder();
            builder.Append(nativeMethodInvocationExpression.NativeMethodName);
            var arguments = nativeMethodInvocationExpression.Arguments.ToList();
            if (arguments.Any())
            {
                builder.Append("(");
                for (int i = 0; i < arguments.Count; i++)
                {
                    if (i != 0)
                        builder.Append(", ");
                    builder.Append(Visit(arguments[i]));
                }
                builder.Append(")");
            }

            return builder;
        }

        public override StringBuilder VisitImportDeclaration(ImportDeclaration importDeclaration)
        {
            return new StringBuilder();
        }


        private int indents = 0;

        private void AppendLine(StringBuilder builder, string line = "")
        {
            AppendLine(builder, new StringBuilder(line));
        }

        private void AppendLine(StringBuilder builder, StringBuilder line)
        {
            for (int i = 0; i < indents; i++)
            {
                line.Insert(0, '\t');
            }

            builder.Append(line);
            builder.AppendLine();
        }

        public override StringBuilder GetDefault(INode node)
        {
            throw new Exception();
        }

        public override StringBuilder Combine(StringBuilder v1, StringBuilder v2)
        {
            v1.Append(v2);
            return v1;
        }
    }
}