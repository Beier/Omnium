using System.Collections.Generic;
using System.Linq;

namespace Omnium.Core.ast.declarations
{
    public class Root : Node
    {
        public Root(IEnumerable<INode> children) : base(null, children)
        {
        }

        public IEnumerable<SourceFile> SourceFiles => Children.OfType<SourceFile>();
        public IEnumerable<ModuleDeclaration> NativeModules => Children.OfType<ModuleDeclaration>();
        public IEnumerable<MethodDeclaration> NativeMethods => Children.OfType<MethodDeclaration>();
        public IEnumerable<VariableDeclaration> PlayerVariableDeclarations => Children.OfType<VariableDeclaration>();
        public RuleDeclaration GlobalVariableInitializer => Children.OfType<RuleDeclaration>().FirstOrDefault();
        public RuleDeclaration PlayerVariableInitializer => Children.OfType<RuleDeclaration>().LastOrDefault();
        public ModuleDeclaration NativeModule { get; set; }
        public ClassDeclaration ListDeclaration { get; set; }
        public readonly List<string> NativeStrings = new List<string>();
        public readonly List<ReevaluationRegistration> ReevaluationRegistrations = new List<ReevaluationRegistration>();
    }

    public class ReevaluationRegistration
    {
        public string NativeMethodName { get; }
        public int ReevaluationEnumParameter { get; }
        public EnumValue EnumValue { get; }
        public int ReevaluatedParameter { get; }

        public ReevaluationRegistration(string nativeMethodName, int reevaluationEnumParameter, EnumValue enumValue, int reevaluatedParameter)
        {
            NativeMethodName = nativeMethodName;
            ReevaluationEnumParameter = reevaluationEnumParameter;
            EnumValue = enumValue;
            ReevaluatedParameter = reevaluatedParameter;
        }
    }
}