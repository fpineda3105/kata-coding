let cache = new Map();

function pathWeight(pyramid, floor, position) {
    let currentNode = pyramid[floor][position];
    let key = floor + "," + position;
    if (cache.get(key) === undefined) {
        cache.set(key, 1);            
    }
    else {
        cache.set(key, cache.get(key) + 1);
    }    
    if (floor === pyramid.length - 1){
        return currentNode;
    }

    let leftPath = currentNode + pathWeight(pyramid, floor + 1, position);
    let rightPath = currentNode + pathWeight(pyramid, floor + 1, position + 1);
    return Math.max(leftPath, rightPath);
}

function longestPath(pyramid) {
    
    return pathWeight(pyramid, 0, 0);
    
}

//----- Test Cases ---//
test('longest path of small test case', () => {
    let pyramid = 
    [
    [5],
    [4, 3],
    [7, 9, 7],
    [9, 7, 6, 5],
    [8, 2, 4, 8, 6]];
    expect(longestPath(pyramid)).toStrictEqual(33);
});

test('longest path of under medium test case', () => {
    let pyramid = 
    [
    [75],
    [95, 64],
    [17, 47, 82],
    [18, 35, 87, 10],
    [20, 4, 82, 47, 65],
    [19, 1, 23, 75, 3, 34],
    [88, 2, 77, 73, 7, 63, 67],
    [99, 65, 4, 28, 6, 16, 70, 92],
    [41, 41, 26, 56, 83, 40, 80, 70, 33],
    [41, 48, 72, 33, 47, 32, 37, 16, 94, 29],
    [53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14],
    [70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57],
    [91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48],
    [63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31],
    [4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23]];
    expect(longestPath(pyramid)).toStrictEqual(1074);
});

