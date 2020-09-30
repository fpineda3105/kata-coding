/**
 * Find the odd int
 * Given an array of integers, find the one that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */

function findOddAppearancesIn(arr) {
    const ocurrences = new Map();    
    for (const number of arr) {
        let value = ocurrences.get(number);        
        ocurrences.set(number, value === undefined ? 1 : value + 1);        
    }
    return arr.find( number => ocurrences.get(number) % 2 !== 0);
}

// Test cases
 test('findOddAppearancesIn in [1, 3, 4, 5, 6, 3] should return 3 ', () => {
     expect(findOddAppearancesIn([1, 3, 4, 5, 6, 6, 1, 4, 5])).toStrictEqual(3);
 })

 // Test cases
 test('findOddAppearancesIn in [20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5] should return 5 ', () => {
    expect(findOddAppearancesIn([20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5])).toStrictEqual(5);
})