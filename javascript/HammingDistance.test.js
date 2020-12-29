function hamming(strA, strB) {
    if (strA === strB) return 0;
    return [...Array(strA.length).keys()].filter(index => strA.codePointAt(index) !== strB.codePointAt(index)).length
}


// Test cases
test('should returns 3', () => {
    expect(hamming('sTreSS', 'sTradd')).toStrictEqual(3);
})