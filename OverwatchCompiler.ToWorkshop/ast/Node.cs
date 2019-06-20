using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast
{
    public interface INode
    {
        INode Parent { get; set; }
        IEnumerable<INode> Children { get; }
        IParseTree Context { get; }
        NodePosition Position { get; }
    }

    public class NodePosition : IComparable<NodePosition>
    {
        public readonly int Line;
        public readonly int Column;

        public NodePosition(int line, int column)
        {
            Line = line;
            Column = column;
        }

        public int CompareTo(NodePosition other)
        {
            var cmp = Line.CompareTo(other.Line);
            if (cmp != 0)
                return cmp;
            return Column.CompareTo(other.Column);
        }
    }

    public static class NodeExtensions
    {

        public static T NearestAncestorOfType<T>(this INode node) where T : class, INode
        {
            if (node == null)
                return null;
            if (node is T variable)
                return variable;
            return node.Parent.NearestAncestorOfType<T>();
        }

        public static IEnumerable<T> AllAncestorOfType<T>(this INode node) where T : class, INode
        {
            for (var n = node.NearestAncestorOfType<T>(); n != null; n = n.Parent.NearestAncestorOfType<T>())
            {
                yield return n;
                var sourceFile = n as SourceFile;
                if (sourceFile != null)
                {
                    foreach (var importedFile in sourceFile.ImportedSourceFiles)
                    {
                        yield return (T)(INode)importedFile;
                    }
                }
            }
        }

        public static INode NearestAncestorOfAnyType(this INode node, params Type[] types)
        {
            if (node == null)
                return null;
            if (types.Contains(node.GetType()))
                return node;
            return node.Parent.NearestAncestorOfAnyType(types);
        }

        public static IEnumerable<INode> OfAnyType(this IEnumerable<INode> nodes, params Type[] types)
        {
            return nodes.Where(x => types.Any(y => y.IsInstanceOfType(x)));
        }



        public static IEnumerable<INode> AllVisibleNodes(this INode node, params Type[] types)
        {

            var ancestors = node.AllAncestorsAndSelf().ToList();
            var sourceFile = (SourceFile)ancestors.Last();
            foreach (var ancestor in ancestors)
            {
                yield return ancestor;
            }

            foreach (var importedFile in sourceFile.ImportedSourceFiles)
            {
                yield return importedFile;
            }

        }


        public static IEnumerable<INode> AllAncestorsAndSelf(this INode node)
        {
            if (node == null)
                yield break;
            yield return node;
            foreach (var ancestor in node.Parent.AllAncestorsAndSelf())
            {
                yield return ancestor;
            }
        }


        public static IEnumerable<INode> AllDescendantsAndSelf(this INode node)
        {
            if (node == null)
                yield break;
            yield return node;
            foreach (var child in node.Children)
            {
                foreach (var descendant in child.AllDescendantsAndSelf())
                {
                    yield return descendant;
                }
            }
        }

        public static Dictionary<K, List<T>> GetDuplicatesBy<T, K>(this IEnumerable<T> nodes, Func<T, K> selector)
        {
            return nodes.GroupBy(selector)
                .ToDictionary(x => x.Key, x => x.ToList())
                .Where(x => x.Value.Count > 1)
                .ToDictionary(x => x.Key, x => x.Value);
        }
    }

    //Todo: Move all items to a single child collection
    public abstract class Node : INode
    {
        public INode Parent { get; set; }
        public IParseTree Context { get; set; }
        public NodePosition Position { get; set; }

        public IEnumerable<INode> Children =>
            //Todo: Preload reflection for better performance
            GetType()
                .GetProperties()
                .SelectMany(GetChildrenFromProperty)
                .Concat(GetType().GetFields().SelectMany(GetChildrenFromField))
                .OrderBy(x => x.Position);


        protected Node(IParseTree context)
        {
            Context = context;
            var nearestToken = context.GetNearestToken();
            if (nearestToken != null)
                Position = new NodePosition(nearestToken.Line, nearestToken.Column);
        }

        private IEnumerable<INode> GetChildrenFromProperty(PropertyInfo property)
        {
            if (!property.PropertyType.IsGenericType)
                return Enumerable.Empty<INode>();
            if (property.PropertyType.GetGenericTypeDefinition() == typeof(ChildList<>))
                return ((IEnumerable)property.GetValue(this)).OfType<INode>();
            if (property.PropertyType.GetGenericTypeDefinition() == typeof(ChildProperty<>))
            {
                var childProperty = property.GetValue(this);
                var value = (INode)childProperty.GetType().GetProperty("Value").GetValue(childProperty);
                if (value != null)
                    return Enumerable.Repeat(value, 1);
            }

            return Enumerable.Empty<INode>();
        }

        private IEnumerable<INode> GetChildrenFromField(FieldInfo field)
        {
            if (!field.FieldType.IsGenericType)
                return Enumerable.Empty<INode>();
            if (field.FieldType.GetGenericTypeDefinition() == typeof(ChildList<>))
                return ((IEnumerable)field.GetValue(this)).OfType<INode>();
            if (field.FieldType.GetGenericTypeDefinition() == typeof(ChildProperty<>))
            {
                var childProperty = field.GetValue(this);
                var value = (INode)childProperty.GetType().GetProperty("Value").GetValue(childProperty);
                if (value != null)
                    return Enumerable.Repeat(value, 1);
            }

            return Enumerable.Empty<INode>();
        }

        //Todo: Reduce code duplication
        public void ReplaceWith(INode replacement)
        {
            var fieldsAndProperties = Parent.GetType().GetFields().Concat<object>(Parent.GetType().GetProperties());
            foreach (var fieldOrProperty in fieldsAndProperties)
            {
                var fieldInfo = fieldOrProperty as FieldInfo;
                var propertyInfo = fieldOrProperty as PropertyInfo;
                var type = fieldInfo?.FieldType ?? propertyInfo.PropertyType;
                if (!type.IsGenericType)
                    continue;
                if (type.GetGenericTypeDefinition() == typeof(ChildList<>))
                {
                    var list = fieldInfo?.GetValue(Parent) ?? propertyInfo.GetValue(Parent);
                    if (!list.GetType().GenericTypeArguments[0].IsInstanceOfType(this))
                        continue;
                    var hasChild = (bool) list.GetType().GetMethod("Contains").Invoke(list, new object[] { this });
                    if (hasChild)
                    {
                        list.GetType().GetMethod("Replace").Invoke(list, new object[] {this, replacement});
                        return;
                    }
                }
                else if (type.GetGenericTypeDefinition() == typeof(ChildProperty<>))
                {
                    var property = fieldInfo?.GetValue(Parent) ?? propertyInfo.GetValue(Parent);
                    if (!property.GetType().GenericTypeArguments[0].IsInstanceOfType(this))
                        continue;
                    var currentValue = (INode)property.GetType().GetProperty("Value").GetValue(property);
                    if (currentValue == this)
                    {
                        property.GetType().GetProperty("Value").SetValue(property, replacement);
                        return;
                    }
                }
            }
        }

        public void Remove()
        {
            var fieldsAndProperties = Parent.GetType().GetFields().Concat<object>(Parent.GetType().GetProperties());
            foreach (var fieldOrProperty in fieldsAndProperties)
            {
                var fieldInfo = fieldOrProperty as FieldInfo;
                var propertyInfo = fieldOrProperty as PropertyInfo;
                var type = fieldInfo?.FieldType ?? propertyInfo.PropertyType;
                if (!type.IsGenericType)
                    continue;
                if (type.GetGenericTypeDefinition() == typeof(ChildList<>))
                {
                    var list = fieldInfo?.GetValue(Parent) ?? propertyInfo.GetValue(Parent);
                    if (!list.GetType().GenericTypeArguments[0].IsInstanceOfType(this))
                        continue;
                    var hasChild = (bool) list.GetType().GetMethod("Contains").Invoke(list, new object[] { this });
                    if (hasChild)
                    {
                        list.GetType().GetMethod("Remove").Invoke(list, new object[] {this});
                        return;
                    }
                }
                else if (type.GetGenericTypeDefinition() == typeof(ChildProperty<>))
                {
                    var property = fieldInfo?.GetValue(Parent) ?? propertyInfo.GetValue(Parent);
                    if (!property.GetType().GenericTypeArguments[0].IsInstanceOfType(this))
                        continue;
                    var currentValue = (INode)property.GetType().GetProperty("Value").GetValue(property);
                    if (currentValue == this)
                    {
                        property.GetType().GetProperty("Value").SetValue(property, null);
                        return;
                    }
                }
            }
        }

        public override string ToString()
        {
            var sourceFile = this.NearestAncestorOfType<SourceFile>();
            return $"{GetType().Name} [{sourceFile?.FileName}: {Position?.Line}, {Position?.Column}]";
        }
    }
}