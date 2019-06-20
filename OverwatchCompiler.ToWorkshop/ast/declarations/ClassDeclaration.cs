using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.compiler;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class ClassDeclaration : Node, IHasVariables, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly ChildList<ConstructorDeclaration> Constructors;
        public readonly ChildList<GetterDeclaration> Getters;
        public readonly ChildList<SetterDeclaration> Setters;
        public readonly List<GetterSetterDeclaration> GettersAndSetters = new List<GetterSetterDeclaration>();
        public readonly ChildList<MethodDeclaration> MethodDeclarations;
        public readonly ChildList<VariableDeclaration> VariableDeclarations;

        public ClassDeclaration(
            IParseTree context, 
            string name, 
            IEnumerable<ConstructorDeclaration> constructors, 
            IEnumerable<GetterDeclaration> getters,
            IEnumerable<SetterDeclaration> setters,
            IEnumerable<MethodDeclaration> methodDeclarations,
            IEnumerable<VariableDeclaration> variableDeclarations) : base(context)
        {
            Name = name;
            Constructors = new ChildList<ConstructorDeclaration>(this);
            Getters = new ChildList<GetterDeclaration>(this);
            Setters = new ChildList<SetterDeclaration>(this);
            MethodDeclarations = new ChildList<MethodDeclaration>(this);
            VariableDeclarations = new ChildList<VariableDeclaration>(this);

            Getters.ItemAdded += getter =>
            {
                var matchingGetterSetter = GettersAndSetters.SingleOrDefault(x => x.Name == getter.Name);
                if (matchingGetterSetter != null)
                {
                    if (matchingGetterSetter.Getter != null)
                        throw new CompilationError(context, "Multiple getters defined with name: " + getter.Name);
                    matchingGetterSetter.Getter = getter;
                }
                else
                {
                    GettersAndSetters.Add(new GetterSetterDeclaration {Getter = getter});
                }
            };
            Getters.ItemRemoved += getter =>
            {
                var matchingGetterSetter = GettersAndSetters.Single(x => x.Name == getter.Name);
                matchingGetterSetter.Getter = null;
                if (matchingGetterSetter.Setter == null)
                    GettersAndSetters.Remove(matchingGetterSetter);
            };
            Setters.ItemAdded += setter =>
            {
                var matchingGetterSetter = GettersAndSetters.SingleOrDefault(x => x.Name == setter.Name);
                if (matchingGetterSetter != null)
                {
                    if (matchingGetterSetter.Setter != null)
                        throw new CompilationError(context, "Multiple setters defined with name: " + setter.Name);
                    matchingGetterSetter.Setter = setter;
                }
                else
                {
                    GettersAndSetters.Add(new GetterSetterDeclaration {Setter = setter});
                }
            };
            Setters.ItemRemoved += setter =>
            {
                var matchingGetterSetter = GettersAndSetters.Single(x => x.Name == setter.Name);
                matchingGetterSetter.Setter = null;
                if (matchingGetterSetter.Getter == null)
                    GettersAndSetters.Remove(matchingGetterSetter);
            };


            Constructors.AddRange(constructors);
            Getters.AddRange(getters);
            Setters.AddRange(setters);
            MethodDeclarations.AddRange(methodDeclarations);
            VariableDeclarations.AddRange(variableDeclarations);
        }

        public IEnumerable<VariableDeclaration> Variables => VariableDeclarations;
    }
}