using System;
using System.IO;
using NUnit.Framework;
using Omnium.Core.compiler;
using Omnium.Core.compiler.parsing;

namespace Omnium.Tests.ToWorkshop
{
    [TestFixture]
    public class TypescriptToOverwatchCompilerTests
    {
        [TestCase("HelloWorld")]
        [TestCase("CountShots")]
        [TestCase("ConstantLoopUnrolling")]
        [TestCase("NonConstantLoopUnrolling")]
        [TestCase("TestArraySize")]
        [TestCase("ModuleAndClassOfSameName")]
        public void RunTest(string testName)
        {
            var compiler = new TypescriptToOverwatchCompiler(new Parser());

            var exeLocation = AppDomain.CurrentDomain.BaseDirectory;
            var code = compiler.Compile($"{exeLocation}/ToWorkshop/Data/{testName}/Input.ts");
            var expectedOutput = File.ReadAllText($"{exeLocation}/ToWorkshop/Data/{testName}/ExpectedOutput.txt");

            code = code.Replace("\r", "");
            expectedOutput = expectedOutput.Replace("\r", "");

            Assert.AreEqual(expectedOutput, code);
        }
    }
}