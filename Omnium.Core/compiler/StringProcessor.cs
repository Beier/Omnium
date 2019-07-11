using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
{
    public class StringProcessor : TreeVoidWalker
    {
        public override void ExitStringLiteral(StringLiteral stringLiteral)
        {
            if (stringLiteral.Parent is NativeMethodInvocationExpression nativeMethodInvocation
                && nativeMethodInvocation.NativeMethodName == "String"
                && stringLiteral == nativeMethodInvocation.Arguments.First()
                || stringLiteral.Parent is EnumValue)
                return;
            var root = stringLiteral.NearestAncestorOfType<Root>();
            var parts = new List<IExpression>{stringLiteral};
            var (constructed, matchesCase) = Construct(root, stringLiteral.Context, parts);
            if (constructed == null)
            {
                Errors.Add(new CompilationError(stringLiteral.Context, "String can not be constructed from predefined strings in Overwatch"));
            }
            else
            {
                if (!matchesCase)
                    Warnings.Add(new CompilationError(stringLiteral.Context, "String case might not match the predefined strings in Overwatch"));
                stringLiteral.ReplaceWith(constructed);
                Visit(constructed);
            }
        }

        public override void EnterBinaryExpression(BinaryExpression binaryExpression)
        {
            if (!(binaryExpression.Type is StringType))
                return;
            var root = binaryExpression.NearestAncestorOfType<Root>();
            var parts = GetStringConcatenationParts(binaryExpression).ToList();
            var (constructed, matchesCase) = Construct(root, binaryExpression.Context, parts);
            if (constructed == null)
            {
                Errors.Add(new CompilationError(binaryExpression.Operator.Context, "String can not be constructed from predefined strings in overwatch"));
            }
            else
            {
                if (!matchesCase)
                    Warnings.Add(new CompilationError(binaryExpression.Context, "String case might not match the predefined strings in Overwatch"));
                binaryExpression.ReplaceWith(constructed);
                Visit(constructed);
            }
            skipChildren = true;
        }

        private IEnumerable<IExpression> GetStringConcatenationParts(BinaryExpression binaryExpression)
        {
            if (binaryExpression.Left is BinaryExpression left && left.Type is StringType)
            {
                foreach (var part in GetStringConcatenationParts(left))
                {
                    yield return part;
                }
            }
            else
            {
                yield return binaryExpression.Left;
            }
            if (binaryExpression.Right is BinaryExpression right && right.Type is StringType)
            {
                foreach (var part in GetStringConcatenationParts(right))
                {
                    yield return part;
                }
            }
            else
            {
                yield return binaryExpression.Right;
            }
        }

        private (IExpression, bool) Construct(Root root, IParseTree context, List<IExpression> parts)
        {
            if (parts.Count == 0)
                return (null, true);
            if (parts.Count == 1)
            {
                if (!(parts[0] is StringLiteral literal))
                    return (parts[0], true);
                if (root.NativeStrings.Contains(literal.UnquotedText))
                    return (NativeMethods.String(context, AstCloner.Clone(literal)), true);
                if (root.NativeStrings.Select(x => x.ToLower()).Contains(literal.UnquotedText.ToLower()))
                    return (NativeMethods.String(context, AstCloner.Clone(literal)), false);

                //Check if string can be split up
                var wildcardStrings = root.NativeStrings.Where(x => x.Contains("{0}")).OrderBy(x => -x.Length);
                foreach (var wildcardString in wildcardStrings)
                {
                    var escaped = Regex.Escape(wildcardString)
                        .Replace("\\{0}", "(.*)")
                        .Replace("\\{1}", "(.*)")
                        .Replace("\\{2}", "(.*)");
                    var regex = new Regex($"^{escaped}$");
                    bool matchesCase = true;
                    var matchResult = regex.Match(literal.UnquotedText);
                    if (!matchResult.Success)
                    {
                        matchesCase = false;
                        regex = new Regex($"^{escaped}$", RegexOptions.IgnoreCase);
                        matchResult = regex.Match(literal.UnquotedText);
                        if (!matchResult.Success)
                            continue;
                    }
                    var subParts = 
                        matchResult
                        .Groups.OfType<Group>().Skip(1)
                        .Select(x => Construct(root, context, new List<IExpression> {new StringLiteral(context, "\"" + x.Value + "\"") }))
                        .ToList();
                    if (subParts.Any(x => x.Item1 == null))
                        continue;
                    var newLiteral = new StringLiteral(context, "\"" + wildcardString + "\"");
                    var arg1 = subParts[0].Item1;
                    var arg2 = subParts.Count >= 2 ? subParts[1].Item1 : null;
                    var arg3 = subParts.Count >= 3 ? subParts[2].Item1 : null;
                    return (NativeMethods.String(context, newLiteral, arg1, arg2, arg3), matchesCase && subParts.All(x => x.Item2));
                }
            }
            else
            {
                var wildcardStrings = root.NativeStrings.Where(x => x.Contains("{0}")).Reverse();
                foreach (var wildcardString in wildcardStrings)
                {
                    bool matchesCase = true;
                    var prefix = GetPrefix(wildcardString);
                    var postfix = GetPostfix(wildcardString);
                    var trimmedParts = TrimPrefix(prefix, parts, ref matchesCase);
                    if (trimmedParts == null)
                        continue;
                    trimmedParts = TrimPostfix(postfix, trimmedParts, ref matchesCase);
                    if (trimmedParts == null)
                        continue;

                    if (!wildcardString.Contains("{1}"))
                    {
                        if (prefix == "" && postfix == "")
                            continue;
                        var subExpression = Construct(root, context, trimmedParts);
                        if (subExpression.Item1 == null)
                            continue;
                        return (NativeMethods.String(context, new StringLiteral(context, "\"" + wildcardString + "\""), subExpression.Item1), matchesCase && subExpression.Item2);
                    }

                    var middlePartsCaptureRegex = new Regex("^[^\\{]*\\{0}([^\\{]*)(?:\\{1}([^\\{]*))?\\{\\d}[^}]*$");
                    var middleParts = middlePartsCaptureRegex.Match(wildcardString).Groups.OfType<Group>().Skip(1).Select(x => x.Value).Where(x => x != "").ToList();

                    var possibleSplits = new List<List<(int, int, bool)>>();
                    possibleSplits.Add(new List<(int, int, bool)>{(-1, 0, true)});
                    foreach (var middlePart in middleParts)
                    {
                        var newSplits = new List<List<(int, int, bool)>>();
                        foreach (var possibleSplit in possibleSplits)
                        {
                            var (previousPart, previousIndex, previousMatchCase) = possibleSplit.Last();
                            var splits = GetIndexesForMiddlePartAfter(previousPart, previousIndex, middlePart, parts).ToList();
                            foreach (var split in splits)
                            {
                                newSplits.Add(possibleSplit.Concat(split.Yield()).ToList());
                            }
                        }

                        possibleSplits = newSplits;
                    }
                    if (!possibleSplits.Any())
                        continue;

                    for (int i = 0; i < possibleSplits.Count; i++)
                    {
                        possibleSplits[i].RemoveAt(0);
                        var possibleSplitMatchesCase = matchesCase;
                        var splitParts = new List<List<IExpression>>{parts};
                        for (int j = possibleSplits[i].Count - 1; j >= 0; j--)
                        {
                            var (partIndex, stringIndex, splitMatchCase) = possibleSplits[i][j];
                            possibleSplitMatchesCase &= splitMatchCase;
                            var prefixParts = splitParts.First();
                            splitParts.RemoveAt(0);
                            var (left, right) = Split(partIndex, stringIndex, middleParts[j].Length, prefixParts);
                            splitParts.Insert(0, right);
                            splitParts.Insert(0, left);
                        }

                        var replacementParts = splitParts.Select(x => Construct(root, context, x)).ToList();
                        if (replacementParts.Any(x => x.Item1 == null))
                            continue;
                        var newLiteral = new StringLiteral(context, "\"" + wildcardString + "\"");
                        var arg1 = replacementParts[0].Item1;
                        var arg2 = replacementParts.Count >= 2 ? replacementParts[1].Item1 : null;
                        var arg3 = replacementParts.Count >= 3 ? replacementParts[2].Item1 : null;
                        return (NativeMethods.String(context, newLiteral, arg1, arg2, arg3), possibleSplitMatchesCase);

                    }
                }
            }

            return (null, true);
        }

        private IEnumerable<(int, int, bool)> GetIndexesForMiddlePartAfter(int startPart, int startIndex, string middlePart, List<IExpression> parts)
        {
            for (int i = startPart; i < parts.Count; i++)
            {
                if (i < 0)
                    continue;
                if (!(parts[i] is StringLiteral literal))
                    continue;
                var j = i == startPart ? startIndex + 1: 0;
                while (true)
                {
                    var index = literal.UnquotedText.Substring(j).IndexOf(middlePart);
                    var matchesCase = true;
                    if (index == -1)
                    {
                        matchesCase = false;
                        index = literal.UnquotedText.Substring(j).IndexOf(middlePart, StringComparison.CurrentCultureIgnoreCase);
                        if (index == -1)
                            break;
                    }
                    index += j;
                    j = index + 1;
                    yield return (i, index, matchesCase);
                }
            }
        }

        private (List<IExpression>, List<IExpression>) Split(int partIndex, int stringIndex, int removeLength, List<IExpression> parts)
        {
            var left = new List<IExpression>();
            var right = new List<IExpression>();

            left.AddRange(parts.Take(partIndex));

            var partToSplit = (StringLiteral) parts[partIndex];
            if (stringIndex == 0 && removeLength == partToSplit.UnquotedText.Length)
            {
                //Do nothing
            }
            else if (stringIndex == 0)
                right.Add(new StringLiteral(partToSplit.Context, "\"" + partToSplit.UnquotedText.Substring(removeLength) + "\""));
            else if (stringIndex + removeLength == partToSplit.UnquotedText.Length)
                left.Add(new StringLiteral(partToSplit.Context, "\"" + partToSplit.UnquotedText.Substring(0, stringIndex) + "\""));
            else
            {
                left.Add(new StringLiteral(partToSplit.Context, "\"" + partToSplit.UnquotedText.Substring(0, stringIndex) + "\""));
                right.Add(new StringLiteral(partToSplit.Context, "\"" + partToSplit.UnquotedText.Substring(stringIndex + removeLength) + "\""));
            }
            right.AddRange(parts.Skip(partIndex + 1));

            return (left, right);
        }

        private static string GetPrefix(string wildcardString)
        {
            var captureRegex = new Regex("^([^\\{]*)\\{.*$");
            var match = captureRegex.Match(wildcardString);
            var prefix = match.Groups[1].Value;
            return prefix;
        }

        private static string GetPostfix(string wildcardString)
        {
            var captureRegex = new Regex("^.*}([^}]*)$");
            var match = captureRegex.Match(wildcardString);
            var postfix = match.Groups[1].Value;
            return postfix;
        }

        private List<IExpression> TrimPrefix(string prefix, List<IExpression> parts, ref bool matchesCase)
        {
            if (prefix == "")
                return parts;
            if (parts.Count == 0 
                || !(parts[0] is StringLiteral literal) 
                || literal.UnquotedText.Length < prefix.Length 
                || !literal.UnquotedText.StartsWith(prefix, StringComparison.CurrentCultureIgnoreCase))
                return null;

            if (!literal.UnquotedText.StartsWith(prefix))
                matchesCase = false;

            if (literal.UnquotedText.Length == prefix.Length)
                return parts.Skip(1).ToList();
            return new StringLiteral(parts[0].Context, "\"" + literal.UnquotedText.Substring(prefix.Length) + "\"").Yield().Concat(parts.Skip(1)).ToList();
        }

        private List<IExpression> TrimPostfix(string postfix, List<IExpression> parts, ref bool matchesCase)
        {
            if (postfix == "")
                return parts;
            if (parts.Count == 0 
                || !(parts.Last() is StringLiteral literal) 
                || literal.UnquotedText.Length < postfix.Length 
                || !literal.UnquotedText.EndsWith(postfix, StringComparison.CurrentCultureIgnoreCase))
                return null;

            if (!literal.UnquotedText.EndsWith(postfix))
                matchesCase = false;

            if (literal.UnquotedText.Length == postfix.Length)
                return parts.Take(parts.Count - 1).ToList();
            return parts.Take(parts.Count - 1)
                .Concat(new StringLiteral(parts[0].Context, "\"" + literal.UnquotedText.Substring(0, literal.UnquotedText.Length - postfix.Length) + "\"").Yield())
                .ToList();
        }
    }
}/*
actions
{
	Small Message(All Players(All Teams), String("{0}!", String("{0} {1}", String("Hello", String("", Null, Null, Null), Null, Null),
		Event Player, Null), Null, Null));
}

*/
