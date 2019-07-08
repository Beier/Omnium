using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.extensions
{
    public static class RuleContextExtensions
    {
        public static T GetNearestAncestorOfType<T>(this IParseTree context) where T : class
        {
            if (context == null)
                return null;
            if (context is T variable)
                return variable;
            return context.Parent.GetNearestAncestorOfType<T>();
        }

        public static IParseTree GetNearestAncestorOfTypes(this IParseTree context, params Type[] types)
        {
            if (context == null)
                return null;
            if (types.Contains(context.GetType()))
                return context;
            return context.Parent.GetNearestAncestorOfTypes(types);
        }

        public static string GetPositionString(this IParseTree context)
        {
            var sourceFile = context.GetNearestAncestorOfType<TypescriptParser.SourceFileContext>();
            var token = context.GetTokens().First();
            return $"{sourceFile.FilePath} ({token.Line}, {token.Column})";
        }



        public static IEnumerable<IToken> GetTokens(this IParseTree context)
        {
            return context.DecendantsOfType<ITerminalNode>().Select(x => x.Symbol);
        }

        public static IEnumerable<T> DecendantsOfType<T>(this IParseTree context)
        {
            if (context == null)
                yield break;
            if (context is T matchingDecendant)
                yield return matchingDecendant;
            for (int i = 0; i < context.ChildCount; i++)
            {
                var child = context.GetChild(i);
                foreach (var childResult in child.DecendantsOfType<T>())
                {
                    yield return childResult;
                }
            }
        }

        public static IEnumerable<T> DecendantsOfTypeReversed<T>(this IParseTree context)
        {
            if (context == null)
                yield break;
            if (context is T matchingDecendant)
                yield return matchingDecendant;
            for (int i = context.ChildCount - 1; i >= 0; i--)
            {
                var child = context.GetChild(i);
                foreach (var childResult in child.DecendantsOfTypeReversed<T>())
                {
                    yield return childResult;
                }
            }
        }

        public static IToken GetNearestToken(this IParseTree context)
        {
            return context.NearestOfType<ITerminalNode>().Select(x => x.Symbol).FirstOrDefault();
        }

        public static IEnumerable<T> NearestOfType<T>(this IParseTree context)
        {
            if (context == null)
                yield break;

            foreach (var result in context.DecendantsOfType<T>())
            {
                yield return result;
            }

            var node = context;
            var parent = context.Parent;
            while (parent != null)
            {
                var childIndex = parent.IndexOfChild(node);

                for (int i = 1; i < parent.ChildCount; i++)
                {
                    var previousIndex = childIndex - i;
                    var nextIndex = childIndex + i;

                    if (previousIndex >= 0)
                    {
                        foreach (var result in parent.GetChild(previousIndex).DecendantsOfTypeReversed<T>())
                        {
                            yield return result;
                        }
                    }
                    if (nextIndex < parent.ChildCount)
                    {
                        foreach (var result in parent.GetChild(nextIndex).DecendantsOfType<T>())
                        {
                            yield return result;
                        }
                    }
                }


                node = parent;
                parent = node.Parent;
            }

        }

        public static int IndexOfChild(this IParseTree parent, IParseTree child)
        {
            for (int i = 0; i < parent.ChildCount; i++)
            {
                if (parent.GetChild(i) == child)
                    return i;
            }

            return -1;
        }

        public static IEnumerable<T> PreviousOfType<T>(this IParseTree context)
        {
            if (context is T matchingDecendant)
                yield return matchingDecendant;
            var parent = context.Parent;
            if (parent == null)
                yield break;
            var childIndex = -1;
            for (int i = parent.ChildCount - 1; i >= 0; i--)
            {
                var child = parent.GetChild(i);
                if (child == context)
                    childIndex = i;
                else if (childIndex != -1)
                {
                    foreach (var childResult in child.DecendantsOfTypeReversed<T>())
                    {
                        yield return childResult;
                    }
                }
            }

            foreach (var parentResult in parent.PreviousOfType<T>())
            {
                yield return parentResult;
            }
        }

        public static string MkString(this IEnumerable<object> objects, string seperator = "")
        {
            return string.Join(seperator, objects);
        }
    }
}