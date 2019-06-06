using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2
{
    public interface INode
    {
        INode Parent { get; set; }
        IEnumerable<INode> Children { get; }
        IParseTree Context { get; }
    }

    public abstract class Node : INode
    {
        public INode Parent { get; set; }
        public IParseTree Context { get; set; }

        public IEnumerable<INode> Children =>
            //Todo: Preload reflection for better performance
            GetType()
            .GetProperties()
            .SelectMany(GetChildrenFromProperty);

        protected Node(IParseTree context)
        {
            Context = context;
        }

        private IEnumerable<INode> GetChildrenFromProperty(PropertyInfo property)
        {
            if (property.PropertyType == typeof(ChildList<>))
                return ((IEnumerable)property.GetValue(this)).OfType<INode>();
            if (property.PropertyType == typeof(ChildProperty<>))
            {
                var childProperty = property.GetValue(this);
                var value = (INode)typeof(ChildProperty<>).GetProperty("Value").GetValue(childProperty);
                if (value != null)
                    return Enumerable.Repeat(value, 1);
            }
            return Enumerable.Empty<INode>();
        }
    }
}