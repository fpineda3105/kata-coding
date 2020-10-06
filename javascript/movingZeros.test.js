/**
 * https://www.codewars.com/kata/52597aa56021e91c93000cb0
 * Write an algorithm that takes an array and moves all of the zeros to the end, preserving the order of the other elements.
 * 
 * moveZeros([false,1,0,1,2,0,1,3,"a"]) // returns[false,1,1,2,1,3,"a",0,0]
 */

function moveZeros(array) {
    const arrayWithoutZeros = [];
    const zeros = [];
    for (const element of array) {
        element === 0 ? zeros.push(0) : arrayWithoutZeros.push(element);        
    }
    return [...arrayWithoutZeros, ...zeros]; 
}

  //----- Test Cases ---//
test('moves zeros for [false,1,0,1,2,0,1,3,"a"] should return [false,1,1,2,1,3,"a",0,0] ', () => {
    expect(moveZeros([false,1,0,1,2,0,1,3,"a"])).toStrictEqual([false,1,1,2,1,3,"a",0,0]);
});

test('moves zeros for [9,0.0,0,9,1,2,0,1,0,1,0.0,3,0,1,9,0,0,0,0,9] should return [9,9,1,2,1,1,3,1,9,9,0,0,0,0,0,0,0,0,0,0] ', () => {
    expect(moveZeros([9,0.0,0,9,1,2,0,1,0,1,0.0,3,0,1,9,0,0,0,0,9])).toStrictEqual([9,9,1,2,1,1,3,1,9,9,0,0,0,0,0,0,0,0,0,0]);
});