using System;
using System.IO;
using System.Text.RegularExpressions;
using NUnit.Framework;
using OverwatchCompiler.ToTypescript;
using OverwatchCompiler.ToWorkshop;
using OverwatchCompiler.ToWorkshop.compiler;
using OverwatchCompiler.ToWorkshop.compiler.parsing;

namespace OverwatchCompiler.Tests.ToWorkshop
{
    [TestFixture]
    public class TypescriptToOverwatchCompilerTests
    {
        [TestCase("HelloWorld")]
        [TestCase("CountShots")]
        [TestCase("LoopUnrolling")]
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