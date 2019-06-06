using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.statements;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class MethodDeclaration : Node
    {
        public string Name { get; set; }
        public readonly ChildList<GenericTypeDeclaration> GenericTypeDeclarations;
        public readonly ChildList<VariableDeclaration> Parameters;
        public readonly ChildProperty<BlockStatement> Body;

        public MethodDeclaration(
            IParseTree context, 
            string name, 
            IEnumerable<GenericTypeDeclaration> genericTypeDeclarations,
            IEnumerable<VariableDeclaration> parameters, 
            BlockStatement body) : base(context)
        {
            Name = name;
            GenericTypeDeclarations = new ChildList<GenericTypeDeclaration>(this);
            GenericTypeDeclarations.AddRange(genericTypeDeclarations);
            Parameters = new ChildList<VariableDeclaration>(this);
            Parameters.AddRange(parameters);
            Body = new ChildProperty<BlockStatement>(this, body);
        }
    }
}