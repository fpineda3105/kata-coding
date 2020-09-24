/*

https://www.codewars.com/kata/5287e858c6b5a9678200083c
A Narcissistic Number is a positive number which is the sum of its own digits, each raised to the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).

For example, take 153 (3 digits):
    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

and 1634 (4 digits):
    1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1634
*/
function narcissistic(number) {
    let digits = number.toString().split('');    
    let sumDigits = digits.map( number => Math.pow(parseInt(number), digits.length) ).reduce( (acum, digit) => acum + digit, 0);    
    return sumDigits === number;
}

//----- Test Cases ---//
test('narcissistic of 25 equal false', () => {
    expect(narcissistic(25)).toBe(false);
});

test('narcissistic of 7 equal true', () => {
    expect(narcissistic(7)).toBe(true);
});

test('narcissistic of 153 equal true', () => {
    expect(narcissistic(153)).toBe(true);
});

test('narcissistic of 1634 equal true', () => {     
    expect(narcissistic(1634)).toBe(true);
});

let bigguns = [8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051];
let tests = Math.floor( Math.random() * 10 ) + 15;
for( let i = 0; i <= tests; ++i ) {
    let is = Math.random() > 0.5;
    let value = is ? bigguns[Math.floor( Math.random() * (bigguns.length-1))] : Math.floor( Math.random() * 1400000 ) + 9926316;  
        test(`narcissistic of ${value} equal ${is}`, () => {                            
            expect(narcissistic(value)).toBe(is);                          
        });        
}
 