/***
 * https://www.codewars.com/kata/51ba717bb08c1cd60f00002f
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 * individual integers
 * or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. 
 * The range includes all integers in the interval including both endpoints. 
 * It is not considered a range unless it spans at least 3 numbers. 
 * 
 * For example "12,13,15-17"
 * 
 * Complete the solution so that it takes a list of integers in increasing order and returns a correctly 
 * formatted string in the range format.
 * 
 * Example:
 * solution([-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20]);
 * 
 * returns "-6,-3-1,3-5,7-11,14-15,17-20"
 * 
 */


function rangeExtraction(orderedArray) {
    let prev = orderedArray[0];
    let result = prev + "";

    let counter = 0;
    let tempElements = []
    for (let index = 1; index < orderedArray.length; index++) {
        if (prev + 1 === orderedArray[index]) {
            tempElements.push(orderedArray[index]);
            counter++;
        } else {
            result += counter >= 2 ? "-" + prev + "," + orderedArray[index] :
                counter === 0 ? "," + orderedArray[index] : "," + tempElements.join(",") + "," + orderedArray[index];
            counter = 0;
            tempElements = [];
        }
        prev = orderedArray[index];
    }

    result += counter >= 2 ? "-" + prev : counter > 0 ? "," + tempElements.join(",") : "";
    return result;
}


//----- Test Cases ---//
test('range extraction of [-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20] ' +
    'should return returns "-6,-3-1,3-5,7-11,14,15,17-20"', () => {
        expect(rangeExtraction([-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20])).
        toStrictEqual("-6,-3-1,3-5,7-11,14,15,17-20");
    });


test('range extraction of [-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20] ' +
    'should return returns "-90,-88,-87,-84,-82,-79,-78,-75,-73,-70,-69,-66,-64,-62,-60,-58,-55,-53,-50,-47,-45,-43--41,-38,-36,-34,-31,-29,-26,-24"', () => {
        expect(rangeExtraction([-90, -88, -87, -84, -82, -79, -78, -75, -73, -70, -69, -66, -64, -62, -60, -58, -55, -53, -50, -47, -45, -43, -42, -41, -38, -36, -34, -31, -29, -26, -24])).
        toStrictEqual("-90,-88,-87,-84,-82,-79,-78,-75,-73,-70,-69,-66,-64,-62,-60,-58,-55,-53,-50,-47,-45,-43--41,-38,-36,-34,-31,-29,-26,-24");
    });