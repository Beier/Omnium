using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class ClassDeclaration : Node
    {
        public string Name { get; set; }
        public ChildList<ConstructorDeclaration> Constructors;
        //public ChildList<MethodDeclarationContext> Getters;
        //public ChildList<MethodDeclarationContext> Setters;
        public ChildList<MethodDeclaration> MethodDeclaration;
        public ChildList<VariableDeclaration> VariableDeclarations;

        public ClassDeclaration(IParseTree context, string name) : base(context)
        {
            Name = name;
            Constructors = new ChildList<ConstructorDeclaration>(this);
            MethodDeclaration = new ChildList<MethodDeclaration>(this);
            VariableDeclarations = new ChildList<VariableDeclaration>(this);
        }
    }
}