/**
 * https://www.codewars.com/kata/550554fd08b86f84fe000a58
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
 * #Example 1: 
 *  a1 = ["arp", "live", "strong"]
 *  a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *  returns ["arp", "live", "strong"]
 * 
 * #Example 2: 
 *  a1 = ["tarp", "mice", "bull"]
 *  a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *  returns []
 */

function whichElementsAreIn(array1, array2) {
    const arr2Str = array2.join(',');
    return array1.filter( element => arr2Str.includes(element));
}


  //----- Test Cases ---//
test('whichElementsAreIn of ["arp", "live", "strong"] are in ["lively", "alive", "harp", "sharp", "armstrong"] should return ["arp", "live", "strong"] ', () => {
    expect(whichElementsAreIn(["arp", "live", "strong"],["lively", "alive", "harp", "sharp", "armstrong"])).toStrictEqual(["arp", "live", "strong"]);
});

test('whichElementsAreIn of ["xyz", "live", "strong"] are in ["lively", "alive", "harp", "sharp", "armstrong"] should return ["arp", "live", "strong"] ', () => {
    expect(whichElementsAreIn(["xyz", "live", "strong"],["lively", "alive", "harp", "sharp", "armstrong"])).toStrictEqual(["live", "strong"]);
});


test('whichElementsAreIn of ["tarp", "mice", "bull"] are in ["lively", "alive", "harp", "sharp", "armstrong"] should return ["arp", "live", "strong"] ', () => {
    expect(whichElementsAreIn(["tarp", "mice", "bull"],["lively", "alive", "harp", "sharp", "armstrong"])).toStrictEqual([]);
});