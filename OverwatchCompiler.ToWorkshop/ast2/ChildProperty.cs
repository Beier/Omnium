namespace OverwatchCompiler.ToWorkshop.ast2
{
    public class ChildProperty<T> where T : INode
    {
        private readonly INode owner;
        private T value;

        public T Value
        {
            get => value;
            set
            {
                if (this.value != null)
                    this.value.Parent = null;
                this.value = value;
                if (this.value != null)
                    this.value.Parent = owner;
            }
        }

        public static implicit operator T(ChildProperty<T> prop)
        {
            return prop.Value;
        }

        public ChildProperty(INode owner)
        {
            this.owner = owner;
        }

        public ChildProperty(INode owner, T value)
        {
            this.owner = owner;
            Value = value;
        }
    }
}