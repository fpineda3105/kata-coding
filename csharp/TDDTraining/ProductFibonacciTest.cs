using System;
using System.Collections.Generic;
using System.Text;
using Xunit;
/**
 * https://www.codewars.com/kata/5541f58a944b85ce6d00006a/
 * he Fibonacci numbers are the numbers in the following integer sequence (Fn): 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
 * such as
 * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
 * 
 * Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
 * F(n) * F(n+1) = prod.
 * 
 * Your function productFib takes an integer (prod) and returns an array:
 * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
 * 
 * depending on the language if F(n) * F(n+1) = prod.
 * If you don't find two consecutive F(m) verifying F(m) * F(m+1) = prodyou will return
 * 
 * [F(m), F(m+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
 * 
 * F(m) being the smallest one such as F(m) * F(m+1) > prod.
 * 
 */
namespace TrainigTDD
{
    public class ProductFibonacciTest
    {
        [Theory]
        [InlineData(4895, new ulong[] { 55, 89, 1 })]
        [InlineData(714, new ulong[] { 21, 34, 1 })]
        [InlineData(74049690, new ulong[] { 6765, 10946, 1 })]
        [InlineData(2, new ulong[] { 1, 2, 1 })]
        [InlineData(1, new ulong[] { 1, 1, 1 })]
        [InlineData(0, new ulong[] { 0, 1, 1 })]
        public void Should_return_true(ulong n, ulong[] expected) {            
            Assert.Equal(expected, ProductFibonacci.validate(n));
        }

        [Theory]
        [InlineData(84049690, new ulong[] { 10946, 17711, 0 })]
        [InlineData(1, new ulong[] { 1, 1, 1 })]
        public void Should_return_false(ulong n, ulong[] expected)
        {
            Assert.Equal(expected, ProductFibonacci.validate(n));
        }
    }

    internal class ProductFibonacci
    {
        internal static ulong[] validate(ulong n)
        {
            ulong current = 0, next = 1, product= 0, temporal;
            
            for (ulong i = 0; i <= n; i++)
            {
                product = current * next;
                if (product == n) 
                {
                    return new ulong[] { current, next, 1 };
                }
                if (product > n)
                {
                    return new ulong[] { current, next, 0 };
                }
                temporal = next;
                next += current;
                current = temporal;
            }
            return new ulong[] { current, next, 0 };
        }
    }
}
