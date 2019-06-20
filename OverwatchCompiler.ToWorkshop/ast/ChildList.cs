using System;
using System.Collections;
using System.Collections.Generic;

namespace OverwatchCompiler.ToWorkshop.ast
{
    public class ChildList<T> : IEnumerable<T> where T : INode
    {
        private readonly INode owner;
        private readonly List<T> list = new List<T>();
        public int Count => list.Count;

        public T this[int index] => list[index];

        public ChildList(INode owner)
        {
            this.owner = owner;
        }

        public void Add(T item)
        {
            item.Parent = owner;
            list.Add(item);
            OnItemAdded(item);
        }

        public void AddRange(IEnumerable<T> items)
        {
            foreach (var item in items)
            {
                Add(item);
            }
        }

        public bool Contains(T item)
        {
            return list.Contains(item);
        }

        public void Replace(T oldItem, T newItem)
        {
            var index = list.IndexOf(oldItem);
            list[index] = newItem;
            oldItem.Parent = null;
            newItem.Parent = owner;
            OnItemRemoved(oldItem);
            OnItemAdded(newItem);
        }

        public int IndexOf(T item)
        {
            return list.IndexOf(item);
        }

        public void Remove(T item)
        {
            item.Parent = null;
            list.Remove(item);
            OnItemRemoved(item);
        }

        public delegate void ItemChanged(T item);

        public event ItemChanged ItemAdded;
        public event ItemChanged ItemRemoved;

        private void OnItemAdded(T item)
        {
            ItemAdded?.Invoke(item);
        }

        private void OnItemRemoved(T item)
        {
            ItemRemoved?.Invoke(item);
        }


        public IEnumerator<T> GetEnumerator()
        {
            return list.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}