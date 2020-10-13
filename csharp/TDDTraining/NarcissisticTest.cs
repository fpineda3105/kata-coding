using System;
using Xunit;
using System.Linq;

namespace TrainigTDD
{
    /*
     * Kata: https://www.codewars.com/kata/5287e858c6b5a9678200083c/
     * A Narcissistic Number is a positive number which is the sum of its own digits, each raised to the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).
     * For example, take 153 (3 digits):
     * 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
     * and 1634 (4 digits):
     * 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1634
     */
    public class NarcissisticTest
    {
        [Fact]
        public void verify() {            
            Assert.True(Narcissistic.verify(153));
            Assert.True(Narcissistic.verify(1634));
            Assert.False(Narcissistic.verify(25));
        }

        public class Narcissistic
        {
            public static bool verify(int value){                
                var str = value.ToString();
                return str.Sum(c => Math.Pow(char.GetNumericValue(c), str.Length)) == value;               
            }

        }
    }
}
