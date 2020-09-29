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

 function consecutiveProdFbNumbers(n) {
    let [current, next] = [0, 1]
    let prod;
    for (let index = 0; index <= n; index++) { 
        prod = current * next;       
        if (prod === n) {
            return [current, next, true];
        }
        if (prod > n) {
            return [current, next, false];
        }
        [current, next] = [next, next + current];          
    }          
 }
 
  //----- Test Cases ---//
test('consecutiveProdFbNumbers of 714 should return [21, 34, true] ', () => {
    expect(consecutiveProdFbNumbers(714)).toStrictEqual([21, 34, true]);
});

test('consecutiveProdFbNumbers of 4895 should return [55, 89, true] ', () => {
    expect(consecutiveProdFbNumbers(4895)).toStrictEqual([55, 89, true]);
});

test('consecutiveProdFbNumbers of 4895 should return [55, 89, true] ', () => {
    expect(consecutiveProdFbNumbers(5895)).toStrictEqual([89, 144, false]);
});

test('consecutiveProdFbNumbers of 74049690 should return [6765, 10946, true] ', () => {
    expect(consecutiveProdFbNumbers(74049690)).toStrictEqual([6765, 10946, true]);
});

test('consecutiveProdFbNumbers of 84049690 should return [10946, 17711, false] ', () => {
    expect(consecutiveProdFbNumbers(84049690)).toStrictEqual([10946, 17711, false]);
});