using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;
using Omnium.Core.compiler;

namespace Omnium.Core.ast.declarations
{
    public class ClassDeclaration : Node, IHasVariables, INamedDeclaration, ITypeDeclaration
    {
        public string Name { get; set; }
        public IEnumerable<ConstructorDeclaration> Constructors => Children.OfType<ConstructorDeclaration>();
        public IEnumerable<GetterDeclaration> Getters => Children.OfType<GetterDeclaration>();
        public IEnumerable<SetterDeclaration> Setters => Children.OfType<SetterDeclaration>();
        public readonly List<GetterSetterDeclaration> GettersAndSetters = new List<GetterSetterDeclaration>();
        public IEnumerable<MethodDeclaration> MethodDeclarations => Children.OfType<MethodDeclaration>();
        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
        public readonly List<ClassDeclaration> EquivalentClassDeclarations = new List<ClassDeclaration>();
        public IEnumerable<GenericTypeDeclaration> GenericTypeDeclarations => Children.OfType<GenericTypeDeclaration>();
        public ITypeNode BaseType => Children.OfType<ITypeNode>().SingleOrDefault();
        public List<MemberModifier> Modifiers = new List<MemberModifier>();

        public ClassDeclaration(
            IParseTree context,
            string name,
            IEnumerable<INode> children) : base(context, children)
        {
            Name = name;

            foreach (var child in Children)
            {
                OnChildAdded(child);
            }
            ItemAdded += OnChildAdded;
            ItemRemoved += OnChildRemoved;
        }

        private void OnChildAdded(INode child)
        {
            var getter = child as GetterDeclaration;
            var setter = child as SetterDeclaration;
            if (getter == null && setter == null)
                return;
            var getterSetterName = getter?.Name ?? setter.Name;

            var matchingGetterSetter = GettersAndSetters.SingleOrDefault(x => x.Name == getterSetterName);
            if (matchingGetterSetter != null)
            {
                if (getter != null)
                {
                    if (matchingGetterSetter.Getter != null)
                        throw new CompilationError(Context, "Multiple getters defined with name: " + getterSetterName);
                    matchingGetterSetter.Getter = getter;
                }
                if (setter != null)
                {
                    if (matchingGetterSetter.Setter != null)
                        throw new CompilationError(Context, "Multiple setters defined with name: " + getterSetterName);
                    matchingGetterSetter.Setter = setter;
                }
            }
            else
            {
                GettersAndSetters.Add(new GetterSetterDeclaration(child.Context) { Getter = getter, Setter = setter });
            }
        }

        private void OnChildRemoved(INode child)
        {
            var getter = child as GetterDeclaration;
            var setter = child as SetterDeclaration;
            if (getter == null && setter == null)
                return;
            var getterSetterName = getter?.Name ?? setter.Name;
            var matchingGetterSetter = GettersAndSetters.Single(x => x.Name == getterSetterName);
            if (getter != null)
                matchingGetterSetter.Getter = null;
            if (setter != null)
                matchingGetterSetter.Setter = null;
            if (matchingGetterSetter.Getter == null && matchingGetterSetter.Setter == null)
                GettersAndSetters.Remove(matchingGetterSetter);
        }
    }
}