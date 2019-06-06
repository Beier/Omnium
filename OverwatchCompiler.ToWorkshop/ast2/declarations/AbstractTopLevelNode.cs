using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.expressions;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public abstract class AbstractTopLevelNode : Node
    {
        public readonly ChildList<ModuleDeclaration> ModuleDeclarations;
        public readonly ChildList<ClassDeclaration> ClassDeclarations;
        public readonly ChildList<EnumDeclaration> EnumDeclarations;
        public readonly ChildList<VariableDeclaration> VariableDeclarations;
        public readonly ChildList<MethodInvocationExpression> MethodInvocations;
        
        protected AbstractTopLevelNode(IParseTree context) : base(context)
        {
            ModuleDeclarations = new ChildList<ModuleDeclaration>(this);
            ClassDeclarations = new ChildList<ClassDeclaration>(this);
            EnumDeclarations = new ChildList<EnumDeclaration>(this);
            VariableDeclarations = new ChildList<VariableDeclaration>(this);
            MethodInvocations = new ChildList<MethodInvocationExpression>(this);
        }
    }
}