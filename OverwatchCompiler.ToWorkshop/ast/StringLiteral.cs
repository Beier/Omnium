public partial class TypescriptParser
{
    public partial class StringLiteralContext
    {
        public string QuotedValue => REGULAR_STRING().Symbol.Text;
        public string Value => QuotedValue.Substring(1, QuotedValue.Length - 2);



    }
}