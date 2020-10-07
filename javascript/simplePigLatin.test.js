/**
 * https://www.codewars.com/kata/520b9d2ad5c005041100000f/
 * Simple Pig Latin
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
 * 
 * Examples
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !');     // elloHay orldway !\\
 * 
 * - take each word of a string
 * - for each word, verify that the first character is a letter or not.
 * - if it is a letter then append to the final word plus 'ay'
 */

const isALetter = (charCode) => charCode >= 65 && charCode <= 90 || charCode >= 97 && charCode <= 122;

function pigIt(str) {
    return str.split(' ').map(word =>
        isALetter(word.charCodeAt(0)) ? word.slice(1) + word.charAt(0) + 'ay' : word).join(' ');
}

// Test cases
test('the Pig Latin of "Pig latin is cool" is  "igPay atinlay siay oolcay" ', () => {
    expect(pigIt("Pig latin is cool")).toStrictEqual("igPay atinlay siay oolcay");
})

test('the Pig Latin of "Hello world !" is  "elloHay orldway !" ', () => {
    expect(pigIt("Hello world !")).toStrictEqual("elloHay orldway !");
})