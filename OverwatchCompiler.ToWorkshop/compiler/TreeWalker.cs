using System;
using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public abstract class TreeWalker<T>
    {
        private readonly Dictionary<Type, Func<INode, T>> overwrittenMethods;

        protected TreeWalker()
        {
            overwrittenMethods = GetType()
                .GetMethods()
                .Where(x => x.ReturnType == typeof(T)
                            && x.Name == "Visit"
                            && x.GetParameters().Length == 1
                            && x.GetParameters().Single().ParameterType.IsAssignableFrom(typeof(INode)))
                .ToDictionary(
                    x => x.GetParameters().Single().ParameterType,
                    x => (Func<INode, T>)(n => (T)x.Invoke(this, new object[] { n })));
        }

        public virtual T Visit(INode node)
        {
            if (node == null)
                return GetDefault(node);
            if (overwrittenMethods.TryGetValue(node.GetType(), out var func))
                return func(node);
            var children = node.Children.ToList();
            if (children.Count == 0)
                return GetDefault(node);
            return children.Select(Visit).Aggregate(Combine);
        }

        public abstract T GetDefault(INode node);

        public abstract T Combine(T v1, T v2);
    }
}