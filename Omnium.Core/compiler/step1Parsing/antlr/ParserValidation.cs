using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step1Parsing.antlr
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