/**
 * https://www.codewars.com/kata/54b42f9314d9229fd6000d9c
 * The goal of this exercise is to convert a string to a new string where each character 
 * in the new string is "(" if that character appears only once in the original string, or ")" 
 * if that character appears more than once in the original string. I
 * gnore capitalization when determining if a character is a duplicate.
 * Examples 
 * "din"      =>  "(((" 
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))((" 
 * 
 */

 function duplicateEncoder(word) {
     const ocurrences = new Map();

     for (let letter of word.toLowerCase()) {
        if (ocurrences.get(letter) === undefined) {
            ocurrences.set(letter, 1);            
        }
        else {
            ocurrences.set(letter, ocurrences.get(letter) + 1);
        }
     }
     return word.toLowerCase().split('').map(letter => 
         ocurrences.get(letter) > 1 ? ")" : "("
      ).join('');
 }

 //----- Test Cases ---//
test('duplicateEncoder of "din" should return "(((" ', () => {
    expect(duplicateEncoder("din")).toStrictEqual("(((");
});

test('duplicateEncoder of "recede" should return "()()()" ', () => {
    expect(duplicateEncoder("recede")).toStrictEqual("()()()");
});

test('duplicateEncoder of "(( @" should return "))((" ', () => {
    expect(duplicateEncoder("(( @")).toStrictEqual("))((");
});