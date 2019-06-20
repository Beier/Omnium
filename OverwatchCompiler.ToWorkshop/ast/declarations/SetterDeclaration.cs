using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class SetterDeclaration : Node, IHasVariables, INamedDeclaration
    {
        public string Name { get; set; }
        public readonly List<MemberModifier> Modifiers = new List<MemberModifier>();
        public readonly ChildProperty<VariableDeclaration> Parameter;
        public readonly ChildProperty<BlockStatement> Body;

        public SetterDeclaration(IParseTree context, string name, VariableDeclaration parameter, BlockStatement body) : base(context)
        {
            Name = name;
            Parameter = new ChildProperty<VariableDeclaration>(this, parameter);
            Body = new ChildProperty<BlockStatement>(this, body);
        }

        public IEnumerable<VariableDeclaration> Variables
        {
            get
            {
                yield return Parameter.Value;
            }
        }
    }
}