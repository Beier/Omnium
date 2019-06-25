using System.Linq;
using System.Runtime.Remoting.Messaging;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class GlobalVariableInitializer : TreeVoidWalker
    {
        public override void EnterRoot(Root root)
        {
            var eventModules = root.SourceFiles
                .SelectMany(x => x.ModuleDeclarations)
                .Where(x => x.Name == "Events")
                .ToList();
            var teamEnum = eventModules
                .SelectMany(x => x.EnumDeclarations)
                .Single(x => x.Name == "Team");
            var playerEnum = eventModules
                .SelectMany(x => x.EnumDeclarations)
                .Single(x => x.Name == "Player");
            root.AddChildFirst(
                new RuleDeclaration(root.Context,
                    "Initialize player variables",
                    new INode[]
                    {
                        new NativeTrigger(root.Context, "Ongoing - All", new INode[]
                        {
                            new SimpleNameExpression(root.Context, "All")
                            {
                                Declaration = teamEnum.Values.Single(x => ((StringLiteral)x.Value).UnquotedText == "All")
                            },
                            new SimpleNameExpression(root.Context, "All")
                            {
                                Declaration = playerEnum.Values.Single(x => ((StringLiteral)x.Value).UnquotedText == "All")
                            },
                        }),
                        new BooleanLiteral(root.Context, true),
                        new LambdaExpression(root.Context, new INode[]
                        {
                            new BlockStatement(root.Context, new IStatement[0])
                        })
                    }));
            root.AddChildFirst(
                new RuleDeclaration(root.Context,
                    "Initialize global variables",
                    new INode[]
                    {
                        new NativeTrigger(root.Context, "Ongoing - Global", new INode[0]),
                        new BooleanLiteral(root.Context, true),
                        new LambdaExpression(root.Context, new INode[]
                        {
                            new BlockStatement(root.Context, new IStatement[0])
                        })
                    }));
        }

        public override void ExitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            if (variableDeclaration.Parent is VariableDeclarationStatement
                || variableDeclaration.Parent is MethodDeclaration
                || variableDeclaration.Parent is ForStatement
                || variableDeclaration.Parent is ForeachStatement
                || variableDeclaration.Parent is LambdaExpression)
                return;
            if (variableDeclaration.InitExpression == null)
                return;
            var initExpression = variableDeclaration.InitExpression;
            initExpression.Remove();
            var root = variableDeclaration.NearestAncestorOfType<Root>();
            if (variableDeclaration.Parent is ClassDeclaration)
            {
                root.GlobalVariableInitializer.Action.Block.AddChild(new ExpressionStatement(
                    variableDeclaration.Context,
                    new AssignmentExpression(variableDeclaration.Context, new INode[]
                    {
                        new MemberExpression(variableDeclaration.Context, variableDeclaration.Name, new INode[]
                        {
                            NativeMethods.EventPlayer(variableDeclaration.Context)
                        })
                        {
                            Declaration = variableDeclaration
                        },
                        new AssignmentOperator(variableDeclaration.Context, "="),
                        initExpression
                    })));
            }
            else
            {
                root.GlobalVariableInitializer.Action.Block.AddChild(new ExpressionStatement(
                    variableDeclaration.Context,
                    new AssignmentExpression(variableDeclaration.Context, new INode[]
                    {
                        new SimpleNameExpression(variableDeclaration.Context, variableDeclaration.Name)
                        {
                            Declaration = variableDeclaration
                        },
                        new AssignmentOperator(variableDeclaration.Context, "="),
                        initExpression
                    })));
            }
        }
    }
}