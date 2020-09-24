/*
https://www.codewars.com/kata/523a86aa4230ebb5420001e1/
# What is an anagram? Well, two words are anagrams of each other if they both contain the same letters. For example

'abba' & 'baab' == true
'abba' & 'bbaa' == true
'abba' & 'abbba' == false
'abba' & 'abca' == false

# Write a function that will find all the anagrams of a word from a list. You will be given two inputs a word and an array with words. You should return an array of all the anagrams or an empty array if there are none. For example:

anagrams('abba', ['aabb', 'abcd', 'bbaa', 'dada']) => ['aabb', 'bbaa']
anagrams('racer', ['crazer', 'carer', 'racar', 'caers', 'racer']) => ['carer', 'racer']
anagrams('laser', ['lazing', 'lazy',  'lacer']) => []
*/
function sortWord(word) {
    return word.split('').sort().join('');
}

function anagrams(word, words) {
    let sortedWord = sortWord(word);
    return words.filter( wordToCompare => 
        sortedWord === sortWord(wordToCompare)
    );   
}    

//----- Test Cases ---//
test("anagrams of abba in ['aabb', 'abcd', 'bbaa', 'dada'] should return ['aabb', 'bbaa'] ", () => {
    const word = 'abba';
    const wordList = ['aabb', 'abcd', 'bbaa', 'dada'];
    expect(anagrams(word, wordList)).toStrictEqual(['aabb', 'bbaa']);
});

test("anagrams of racer in ['crazer', 'carer', 'racar', 'caers', 'racer'] should return ['carer', 'racer'] ", () => {
    const word = 'racer';
    const wordList = ['crazer', 'carer', 'racar', 'caers', 'racer'];
    expect(anagrams(word, wordList)).toStrictEqual(['carer', 'racer']);
});


 