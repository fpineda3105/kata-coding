/* 
Min Window Substring
Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr, 
which will contain only two strings, the first parameter being the string N and 
the second parameter being a string K of some characters, and your goal is to determine 
the smallest substring of N that contains all the characters in K. 

For example: if strArr is ["aaabaaddae", "aed"] then 
the smallest substring of N that contains the characters a, e, and d is "dae" 
located at the end of the string. So for this example your program should return the string dae.

Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N 
that contains all of the characters in K is "aabd" which is located at the beginning of the string. 
Both parameters will be strings ranging in length from 1 to 50 characters 
and all of K's characters will exist somewhere in the string N. 
Both strings will only contains lowercase alphabetic characters.

Examples
Input: ["ahffaksfajeeubsne", "jefaa"]
Output: aksfaje
Input: ["aaffhkksemckelloe", "fhea"]
Output: affhkkse
*/

function MinWindowSubstring(array) {
    let expectedMap = new Map();
    const [N, K] = array;
    const minLength = K.length;
    let lastIndex = N.length;
    let result = [];
    
    for (const letter of K) {
        let value = expectedMap.get(letter);
        expectedMap.set(letter, value === undefined ? 1 : value + 1);
    }

    for (let index = N.length-1; index >= 0; index--) {
        let lastLetter = N[index];
        if (expectedMap.get(lastLetter) !== undefined) {
            lastIndex = index;
            break;
        }       
    }
    for (let index = 0; index < lastIndex; index++) {
        let checkingMap = new Map();
        let firstLetterFound = false;
        let str = '';
        for (let index2 = index; index2 < lastIndex && minLength <= lastIndex - index2; index2++) {
            let letter = N[index2];
            let expectedValue = expectedMap.get(letter);
            if (expectedValue !== undefined) {
                let checkingValue = checkingMap.get(letter);
                checkingMap.set(letter,checkingValue === undefined ? 1 : checkingValue + 1);
                str = str + letter;
                firstLetterFound = true;            
                if (isCompleted(checkingMap, expectedMap)) {
                    result.push(str);
                    break;
                }   
            }
            else if (firstLetterFound) {
                let checkingValue = checkingMap.get(letter);
                checkingMap.set(letter,checkingValue === undefined ? 1 : checkingValue + 1);
                str = str + letter;
            }
                     
        }                
    }

    return result.sort( (a, b) => a.length - b.length )[0];
    
}

function isCompleted(checkingMap, expectedMap) {
    if (checkingMap.size < expectedMap.size) {
        return false;
    }
    for (const [key,val] of expectedMap) {
        let checkingValue = checkingMap.get(key);
        if (checkingValue === undefined || checkingValue < val) {
            return false;
        }
    }
    return true;
    
}

  //----- Test Cases ---//
test('min windows of ["ahffaksfajeeubsne", "jefaa"] should return "aksfaje" ', () => {
    expect(MinWindowSubstring(["ahffaksfajeeubsne", "jefaa"])).toStrictEqual("aksfaje");
});