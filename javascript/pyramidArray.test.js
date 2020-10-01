/**
 * Pyramid Array
 * https://www.codewars.com/kata/515f51d438015969f7000013
 * Write a function that when given a number >= 0, returns an Array of ascending length subarrays.
 * 
 * pyramid(0) => [ ]
 * pyramid(1) => [ [1] ]
 * pyramid(2) => [ [1], [1, 1] ]
 * pyramid(3) => [ [1], [1, 1], [1, 1, 1] ]
 * 
 * generate an n positions array
 * iterate each position and create an array of index positions of index number of values, being ecah value 1.
 */

function pyramid(n) {
    return Array(n).fill().map((item, index) => {return Array(index+1).fill(1) });    
}

  //----- Test Cases ---//
test("Pyramid of 3 should return [[1], [1, 1], [1, 1, 1]] ", () => {    
    expect(pyramid(3)).toStrictEqual([[1], [1, 1], [1, 1, 1]]);
});

test("Pyramid of 4 should return [[1], [1, 1], [1, 1, 1], [1, 1, 1, 1] ", () => {    
    expect(pyramid(4)).toStrictEqual([[1], [1, 1], [1, 1, 1], [1, 1, 1, 1]]);
});
