/**
 * https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/
 * You have an array of numbers.
 * Your task is to sort ascending odd numbers but even numbers must be on their places.
 * 
 * Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.
 * 
 * Example
 * 
 * sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
 * 
 * Take an array of numbers
 * filters the odd numbers 
 * sort the odd numbers 
 * replace the odd with the ordered array
 */
const isOdd = (number) => number % 2 !== 0;

function sortOddsNumbersFrom(array) {
    let oddSortedNumbers = array.filter(number => isOdd(number)).sort( (a, b) => b - a);
    return array.map(number => isOdd(number) ? oddSortedNumbers.pop() : number );
}


 //----- Test Cases ---//
test("SortingOdds of [5, 3, 2, 8, 1, 4] should return [1, 3, 2, 8, 5, 4] ", () => {    
    expect(sortOddsNumbersFrom([5, 3, 2, 8, 1, 4])).toStrictEqual([1, 3, 2, 8, 5, 4]);
});
