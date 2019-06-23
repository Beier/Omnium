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
        IEnumerable<IEnumerable<INode>> ChildGroups { get; }
        IParseTree Context { get; }
        NodePosition Position { get; }
        void AddChild(INode item);
        void AddChildFirst(INode item);
        void AddChildBefore(INode existingItem, INode newItem);
        void AddChildAfter(INode existingItem, INode newItem);
        void AddChildren(IEnumerable<INode> items);
        void ReplaceChild(INode oldItem, INode newItem);
        void ReplaceWith(INode replacement);
        void RemoveChild(INode item);
        void Remove();
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

        public static bool IsDescendantOf(this INode child, INode parent)
        {
            if (child == null)
                return false;
            if (child == parent)
                return true;
            return child.Parent.IsDescendantOf(parent);
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

        public static bool IsVisibleFrom(this INode target, INode source)
        {
            //Todo: Also account for public/private
            var targetFile = target.NearestAncestorOfType<SourceFile>();
            var sourceFile = source.NearestAncestorOfType<SourceFile>();
            return sourceFile == targetFile || sourceFile.ImportedSourceFiles.Contains(targetFile);
        }
    }

    //Todo: Move all items to a single child collection
    public delegate void ItemAddedOrRemoved(INode item);
    public abstract class Node : INode
    {
        public INode Parent { get; set; }
        public IParseTree Context { get; set; }
        public NodePosition Position { get; set; }
        private readonly List<List<INode>> children = new List<List<INode>>();
        public IEnumerable<INode> Children => children.SelectMany(x => x);
        public IEnumerable<IEnumerable<INode>> ChildGroups => children.Select(x => x.AsReadOnly());

        public event ItemAddedOrRemoved ItemAdded;
        public event ItemAddedOrRemoved ItemRemoved;

        protected Node(IParseTree context)
        {
            Context = context;
            var nearestToken = context.GetNearestToken();
            if (nearestToken != null)
                Position = new NodePosition(nearestToken.Line, nearestToken.Column);
        }

        protected Node(IParseTree context, IEnumerable<INode> children) : this(context)
        {
            AddChildren(children);
        }

        protected Node(IParseTree context, IEnumerable<IEnumerable<INode>> childGroups) : this(context)
        {
            foreach (var childGroup in childGroups)
            {
                children.Add(childGroup.ToList());
            }

            foreach (var child in Children)
            {
                child.Parent = this;
                ItemAdded?.Invoke(child);
            }
        }

        public void AddChild(INode item)
        {
            item.Parent = this;
            if (children.Count == 0)
                children.Add(new List<INode>());
            children.Last().Add(item);
            ItemAdded?.Invoke(item);
        }

        public void AddChildFirst(INode item)
        {
            item.Parent = this;
            if (children.Count == 0)
                children.Add(new List<INode>());
            children.First().Insert(0, item);
            ItemAdded?.Invoke(item);
        }

        public void AddChildBefore(INode existingItem, INode newItem)
        {
            foreach (var childGroup in children)
            {
                var index = childGroup.IndexOf(existingItem);
                if (index == -1)
                    continue;
                childGroup.Insert(index, newItem);
                newItem.Parent = this;
                ItemAdded?.Invoke(newItem);
                return;
            }
        }

        public void AddChildAfter(INode existingItem, INode newItem)
        {
            foreach (var childGroup in children)
            {
                var index = childGroup.IndexOf(existingItem);
                if (index == -1)
                    continue;
                childGroup.Insert(index + 1, newItem);
                newItem.Parent = this;
                ItemAdded?.Invoke(newItem);
                return;
            }
        }

        public void AddChildren(IEnumerable<INode> items)
        {
            foreach (var item in items)
            {
                AddChild(item);
            }
        }


        public void ReplaceChild(INode oldItem, INode newItem)
        {
            if (oldItem == newItem)
                return;
            foreach (var childGroup in children)
            {
                var index = childGroup.IndexOf(oldItem);
                if (index == -1)
                    continue;
                childGroup[index] = newItem;
                oldItem.Parent = null;
                newItem.Parent = this;
                ItemRemoved?.Invoke(oldItem);
                ItemAdded?.Invoke(newItem);
                return;
            }
        }

        public void ReplaceWith(INode replacement)
        {
            Parent.ReplaceChild(this, replacement);
        }

        public void RemoveChild(INode child)
        {
            foreach (var childGroup in children)
            {
                if (childGroup.Remove(child))
                    break;
            }
            child.Parent = null;
            ItemRemoved?.Invoke(child);
        }

        public void Remove()
        {
            Parent.RemoveChild(this);
        }

        public override string ToString()
        {
            var sourceFile = this.NearestAncestorOfType<SourceFile>();
            return $"{GetType().Name} [{sourceFile?.FileName}: {Position?.Line}, {Position?.Column}]";
        }
    }
}