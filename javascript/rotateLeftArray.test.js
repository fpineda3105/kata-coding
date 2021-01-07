function rotateLeft(arr, n) {
    return arr.slice(n).concat(arr.slice(0,n))
}


/// -- Tests --- //
test('rotate 4 elements of [1,3,4,5,6,7] should return [5,6,7,1,2,3,4]', () => {
    expect(rotateLeft([1,2,3,4,5,6,7], 4)).toStrictEqual([5,6,7,1,2,3,4])
})