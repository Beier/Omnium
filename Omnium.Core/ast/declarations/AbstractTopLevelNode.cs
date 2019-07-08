using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;

namespace Omnium.Core.ast.declarations
{
    public abstract class AbstractTopLevelNode : Node, IHasVariables
    {
        public IEnumerable<ModuleDeclaration> ModuleDeclarations => Children.OfType<ModuleDeclaration>();
        public IEnumerable<ClassDeclaration> ClassDeclarations => Children.OfType<ClassDeclaration>();
        public IEnumerable<MethodDeclaration> MethodDeclarations => Children.OfType<MethodDeclaration>();
        public IEnumerable<EnumDeclaration> EnumDeclarations => Children.OfType<EnumDeclaration>();
        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
        public IEnumerable<MethodInvocationExpression> MethodInvocations => Children.OfType<MethodInvocationExpression>();
        public IEnumerable<RuleDeclaration> RuleDeclarations => Children.OfType<RuleDeclaration>();

        protected AbstractTopLevelNode(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}