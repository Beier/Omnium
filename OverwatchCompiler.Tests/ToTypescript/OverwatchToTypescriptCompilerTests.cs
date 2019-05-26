using System;
using System.IO;
using NUnit.Framework;
using OverwatchCompiler.ToTypescript;

namespace OverwatchCompiler.Tests.ToTypescript
{
    [TestFixture]
    public class OverwatchToTypescriptCompilerTests
    {

        [TestCase("BasicRule")]
        [TestCase("EventTypes")]
        [TestCase("Expressions")]
        [TestCase("StatusEffects")]
        [TestCase("ButtonTypes")]
        [TestCase("CommunicationTypes")]
        [TestCase("BarrierBlockTypes")]
        [TestCase("VectorTransformationTypes")]
        [TestCase("LineOfSightCheckTypes")]
        [TestCase("RoundingDirection")]
        public void ShouldCompileTest(string testName)
        {
            var exeLocation = AppDomain.CurrentDomain.BaseDirectory;
            var code = OverwatchToTypescriptCompiler.Compile($"{exeLocation}/ToTypescript/Data/{testName}/Input.txt");
            var expectedOutput = File.ReadAllText($"{exeLocation}/ToTypescript/Data/{testName}/ExpectedOutput.txt");
            Assert.AreEqual(expectedOutput, code);
        }
    }
}