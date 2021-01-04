function makeAnagram(strA, strB) {    
    let arrayStrA = strA.split('')
    let arrayStrB = strB.split('')
    while(arrayStrA.length > 0) {
        let letter = arrayStrA.pop()
        let index = arrayStrB.findIndex(elem => elem === letter)
        if (index > -1) {            
            arrayStrB[index] = ''
        }
    }
    let anagram = arrayStrB.filter(letter => letter === '').length
    return strA.length - anagram + strB.length - anagram
           
    
}


test(' makeAnagram for ("abcd", "fgdbca") should be 2 ', () => {
    expect(makeAnagram("abcd", "fgdbca"))
        .toStrictEqual(2);
});

test(' makeAnagram for ("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke") should be 30 ', () => {
    expect(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"))
        .toStrictEqual(30);
});