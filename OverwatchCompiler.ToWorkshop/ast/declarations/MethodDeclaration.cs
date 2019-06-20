using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class MethodDeclaration : Node, IHasVariables, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public readonly ChildProperty<ITypeNode> ReturnType;
        public readonly ChildList<GenericTypeDeclaration> GenericTypeDeclarations;
        public readonly ChildList<VariableDeclaration> Parameters;
        public readonly ChildProperty<BlockStatement> Body;

        public MethodDeclaration(
            IParseTree context, 
            string name, 
            ITypeNode returnType,
            IEnumerable<GenericTypeDeclaration> genericTypeDeclarations,
            IEnumerable<VariableDeclaration> parameters, 
            BlockStatement body) : base(context)
        {
            Name = name;
            ReturnType = new ChildProperty<ITypeNode>(this, returnType);
            GenericTypeDeclarations = new ChildList<GenericTypeDeclaration>(this);
            GenericTypeDeclarations.AddRange(genericTypeDeclarations);
            Parameters = new ChildList<VariableDeclaration>(this);
            Parameters.AddRange(parameters);
            Body = new ChildProperty<BlockStatement>(this, body);
        }

        public IEnumerable<VariableDeclaration> Variables => Parameters;
    }
}