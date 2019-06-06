using System.Collections;
using System.Collections.Generic;

namespace OverwatchCompiler.ToWorkshop.ast2
{
    public class ChildList<T> : IEnumerable<T> where T : INode
    {
        private readonly INode owner;
        private readonly List<T> list = new List<T>();

        public ChildList(INode owner)
        {
            this.owner = owner;
        }

        public void Add(T item)
        {
            item.Parent = owner;
            list.Add(item);
        }

        public void AddRange(IEnumerable<T> items)
        {
            foreach (var item in items)
            {
                Add(item);
            }
        }

        public void Remove(T item)
        {
            item.Parent = null;
            list.Remove(item);
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