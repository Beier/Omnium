using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public abstract class AbstractTopLevelNode : Node, IHasVariables
    {
        public readonly ChildList<ModuleDeclaration> ModuleDeclarations;
        public readonly ChildList<ClassDeclaration> ClassDeclarations;
        public readonly ChildList<MethodDeclaration> MethodDeclarations;
        public readonly ChildList<EnumDeclaration> EnumDeclarations;
        public readonly ChildList<VariableDeclaration> VariableDeclarations;
        public readonly ChildList<MethodInvocationExpression> MethodInvocations;
        public readonly ChildList<RuleDeclaration> RuleDeclarations;
        
        protected AbstractTopLevelNode(IParseTree context) : base(context)
        {
            ModuleDeclarations = new ChildList<ModuleDeclaration>(this);
            ClassDeclarations = new ChildList<ClassDeclaration>(this);
            MethodDeclarations = new ChildList<MethodDeclaration>(this);
            EnumDeclarations = new ChildList<EnumDeclaration>(this);
            VariableDeclarations = new ChildList<VariableDeclaration>(this);
            MethodInvocations = new ChildList<MethodInvocationExpression>(this);
            RuleDeclarations = new ChildList<RuleDeclaration>(this);
        }

        public IEnumerable<VariableDeclaration> Variables => VariableDeclarations;
    }
}