/**
 * First non-repeating character
 * https://www.codewars.com/kata/52bc74d4ac05d0945d00054e
 * Write a function named first_non_repeating_letter that takes a string input, and returns the first character that is not repeated anywhere in the string.
 * 
 * For example, if given the input 'stress', the function should return 't', 
 * since the letter t only occurs once in the string, and occurs first in the string.
 * 
 * As an added challenge, upper- and lowercase letters are considered the same character, 
 * but the function should return the correct case for the initial letter. For example, 
 * the input 'sTreSS' should return 'T'.
 */

function firstNonRepeating(str) {
    const ocurrences = new Map();    
    for (const letter of str) {
        let value = ocurrences.get(letter.toLowerCase());        
        ocurrences.set(letter.toLowerCase(), value === undefined ? 1 : value + 1);        
    }
    return str.split('').find( letter => ocurrences.get(letter.toLowerCase()) === 1) || '';
}

// Test cases
 test('the string "sTreSS" should return "t" ', () => {
     expect(firstNonRepeating('sTreSS')).toStrictEqual('T');
 })

 test('the string "moonmen" should return "e" ', () => {
    expect(firstNonRepeating('moonmen')).toStrictEqual('e');
})

//zero repetitions
test('the string "abba" should return " " ', () => {
    expect(firstNonRepeating('abba')).toStrictEqual('');
})
 