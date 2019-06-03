using System;
using System.IO;
using NUnit.Framework;
using OverwatchCompiler.ToTypescript;
using OverwatchCompiler.ToWorkshop;
using OverwatchCompiler.ToWorkshop.compiler;

namespace OverwatchCompiler.Tests.ToWorkshop
{
    [TestFixture]
    public class TypescriptToOverwatchCompilerTests
    {
        [TestCase("Test1")]
        public void ShouldCompile(string testName)
        {
            var compiler = new TypescriptToOverwatchCompiler(new Parser());

            var exeLocation = AppDomain.CurrentDomain.BaseDirectory;
            var code = compiler.Compile($"{exeLocation}/ToWorkshop/Data/{testName}/Input.ts");
            var expectedOutput = File.ReadAllText($"{exeLocation}/ToWorkshop/Data/{testName}/ExpectedOutput.txt");
            Assert.AreEqual(expectedOutput, code);
        }
    }
}