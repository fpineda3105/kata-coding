using System;
using Xunit;
using System.Linq;

namespace TDDTraining
{
    
    /**
     * https://www.codewars.com/kata/56541980fa08ab47a0000040
     * In a factory a printer prints labels for boxes. 
     * For one kind of boxes the printer has to use colors which, for the sake of simplicity, 
     * are named with letters from a to m.
     * The colors used by the printer are recorded in a control string. 
     * For example a "good" control string would be aaabbbbhaijjjm meaning that 
     * the printer used three times color a, four times color b, 
     * one time color h then one time color a...
     * Sometimes there are problems: lack of colors, technical malfunction and 
     * a "bad" control string is produced e.g. aaaxbbbbyyhwawiwjjjwwm with letters not from a to m.
     */
    public class PrinterTests
    {

        [Fact]
        public void HowManyErrorsInTest() {            
            string sequence = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
            Assert.Equal("3/56", Printer.HowManyErrorsIn(sequence));
        }

        internal class Printer
        {
            public static String HowManyErrorsIn(String sequence)
            {
                int errors = sequence.ToLower().ToCharArray().Where(c => c > 109).Count();
                return errors + "/" + sequence.Length;
            }
        }

    }
}
