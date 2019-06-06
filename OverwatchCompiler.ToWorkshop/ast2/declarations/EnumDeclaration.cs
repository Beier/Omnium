using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.expressions;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class EnumDeclaration : Node
    {
        public string Name { get; set; }
        public readonly ChildList<EnumValue> Values;

        public EnumDeclaration(IParseTree context, string name, IEnumerable<EnumValue> values) : base(context)
        {
            Name = name;
            Values = new ChildList<EnumValue>(this);
            Values.AddRange(values);
        }
    }

    public class EnumValue : Node
    {
        public string Name { get; set; }
        public readonly ChildProperty<IExpression> Value;

        public EnumValue(IParseTree context, string name, IExpression value) : base(context)
        {
            Name = name;
            Value = new ChildProperty<IExpression>(this, value);
        }
    }
}