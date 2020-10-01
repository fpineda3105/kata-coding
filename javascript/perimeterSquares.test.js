/**
 * https://www.codewars.com/kata/559a28007caad2ac4e000083/
 * Perimeter of squares in a rectangle
 * The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8. It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80
 * 
 * Could you give the sum of the perimeters of all the squares in a rectangle when there are n + 1 squares disposed in the same manner as in the drawing:
 * 
 * alternative text
 * 
 * #Hint: See Fibonacci sequence #Ref: http://oeis.org/A000045
 * 
 * The function perimeter has for parameter n where n + 1 is the number of squares (they are numbered from 0 to n) and returns the total perimeter of all the squares.
 * 
 * perimeter(5)  should return 80
 * perimeter(7)  should return 216
 */
function fib(n) {
    let [current, next, sum] = [0, 1, 0];
    for (let index = 0; index <= n; index++) {
        [current, next, sum] = [next, next + current, sum + current];        
    }
    return sum;
}

function perimeterOf(n) {
    return fib(n+1) * 4;
}

  //----- Test Cases ---//
test("perimeter of 5 should return 80 ", () => {    
    expect(perimeterOf(5)).toStrictEqual(80);
});

test("perimeter of 7 should return 216 ", () => {    
    expect(perimeterOf(7)).toStrictEqual(216);
});
