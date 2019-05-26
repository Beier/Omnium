using Antlr4.Runtime;

namespace OverwatchCompiler.ToTypescript.antlr
{
    public class ErrorHandler : BailErrorStrategy
    {
        public override void Reset(Parser recognizer)
        {
            base.Reset(recognizer);
        }

        public override IToken RecoverInline(Parser recognizer)
        {
            return base.RecoverInline(recognizer);
        }

        public override void Recover(Parser recognizer, RecognitionException e)
        {
            base.Recover(recognizer, e);
        }

        public override void Sync(Parser recognizer)
        {
            base.Sync(recognizer);
        }

        public override bool InErrorRecoveryMode(Parser recognizer)
        {
            return base.InErrorRecoveryMode(recognizer);
        }

        public override void ReportMatch(Parser recognizer)
        {
            base.ReportMatch(recognizer);
        }

        public override void ReportError(Parser recognizer, RecognitionException e)
        {
            base.ReportError(recognizer, e);
        }
    }
}