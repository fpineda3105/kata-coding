function candies(array) {
    const recordCandies = Array(array.length).fill(1)    

    for (let i = 1; i < array.length;i++) {
        if (array[i] > array[i-1]) {
            recordCandies[i] = recordCandies[i-1] + 1
        }
    }

    for (let j = array.length - 2; j >= 0; j--) {
        if (array[j] > array[j+1]) {
            if (recordCandies[j] <= recordCandies[j+1]) {
                recordCandies[j] = Math.max(recordCandies[j+1],recordCandies[j]) + 1
            }            
        }
    }
    
    return recordCandies.reduce((acc, current) => acc + current, 0)
}

// ---- Test cases ----//
test('the students with ratings [2,4,2,6,1,7,8,9,2,1] should return 19 candies', () => {
    let ratings = [2,4,2,6,1,7,8,9,2,1]
    expect(candies(ratings)).toStrictEqual(19)
})

test('the students with ratings [1,8,4,3,2,6,5,2,1] should return 21 candies', () => {
    let ratings = [1,8,4,3,2,6,5,2,1]
    expect(candies(ratings)).toStrictEqual(21)
})

test('the students with ratings [2,4,3,5,2,6,4,5] should return 12 candies', () => {
    let ratings = [2,4,3,5,2,6,4,5]
    expect(candies(ratings)).toStrictEqual(12)
})

test('the students with ratings [1,2,2] should return 4 candies', () => {
    let ratings = [1,2,2]
    expect(candies(ratings)).toStrictEqual(4)
})