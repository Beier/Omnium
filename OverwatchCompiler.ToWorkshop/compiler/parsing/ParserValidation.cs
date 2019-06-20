using System.Linq;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler.parsing
{
    public class ParserValidation : TypescriptParserBaseListener
    {
        private readonly ErrorListener errorListener;

        public ParserValidation(ErrorListener errorListener)
        {
            this.errorListener = errorListener;
        }

        public override void ExitSetterDeclaration(TypescriptParser.SetterDeclarationContext context)
        {
            if (context.formalParameterList().fixedParameters().fixedParameter().Length != 1)
            {
                errorListener.Errors.Add($"{context.GetPositionString()}: Setters must have exactly one parameter");
            }
        }
    }
}