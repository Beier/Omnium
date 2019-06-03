using System.Linq;
using System.Text;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration
    {


        private StringBuilder BasicMethodOrProperty(string name)
        {
            return BasicMethodOrProperty(name, new StringBuilder[0]);
        }

        private StringBuilder BasicMethodOrProperty(string name, params OverwatchCodeParser.ExpressionContext[] subExpressions)
        {
            var arguments = subExpressions.Select(VisitExpression).ToArray();
            return BasicMethodOrProperty(name, arguments);
        }

        private StringBuilder BasicMethodOrProperty(string name, params StringBuilder[] arguments)
        {
            var builder = new StringBuilder();
            builder.Append(name);
            if (arguments.Length == 0)
                return builder;
            builder.Append("(");
            for (int i = 0; i < arguments.Length; i++)
            {
                if (i != 0)
                    builder.Append(", ");
                builder.Append(arguments[i]);
            }
            builder.Append(")");
            return builder;
        }

        private StringBuilder MemberMethodOrProperty(string name, params OverwatchCodeParser.ExpressionContext[] subExpressions)
        {
            var arguments = subExpressions.Select(VisitExpression).ToArray();
            return MemberMethodOrProperty(name, arguments);
        }

        private StringBuilder MemberMethodOrProperty(string name, params StringBuilder[] arguments)
        {
            var builder = new StringBuilder();
            builder.Append(arguments[0]);
            builder.Append(".");
            builder.Append(name);
            if (arguments.Length == 1)
                return builder;
            builder.Append("(");
            for (int i = 1; i < arguments.Length; i++)
            {
                if (i != 1)
                    builder.Append(", ");
                builder.Append(arguments[i]);
            }
            builder.Append(")");
            return builder;
        }
    }
}