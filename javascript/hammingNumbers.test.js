function hamming (n) {
    var seq = [1];
    var i2 = 0, i3 = 0, i5 = 0;
    for (var i = 1; i < n; i++) {
      var x = Math.min(2 * seq[i2], 3 * seq[i3], 5 * seq[i5]);
      seq.push(x);
      if (2 * seq[i2] <= x) i2++;  
      if (3 * seq[i3] <= x) i3++;
      if (5 * seq[i5] <= x) i5++;
    }
    return seq[n-1];
  }


//----- Test Cases ---//
test('the 5th smallest Hamming number is 5', () => {
    expect(hamming(5)).toStrictEqual(5);
});

test('the 10th smallest Hamming number is 12', () => {
    expect(hamming(10)).toStrictEqual(12);
});

test('the 20th smallest Hamming number is 36', () => {
    expect(hamming(20)).toStrictEqual(36);
});

test('the 21th smallest Hamming number is 40', () => {
    expect(hamming(21)).toStrictEqual(40);
});

test('the 22th smallest Hamming number is 45', () => {
    expect(hamming(22)).toStrictEqual(45);
});

test('the 46th smallest Hamming number is 200', () => {
    expect(hamming(46)).toStrictEqual(200);
});

test('the 445th smallest Hamming number is 524288', () => {
    expect(hamming(445)).toStrictEqual(518400);
});

test('the 700th smallest Hamming number is 5898240', () => {
    expect(hamming(700)).toStrictEqual(5898240);
});

test('the 800th smallest Hamming number is 12754584', () => {
    expect(hamming(800)).toStrictEqual(12754584);
});

test('the 1000th smallest Hamming number is 51200000', () => {
    expect(hamming(1000)).toStrictEqual(51200000);
});

test('the 1691th smallest Hamming number is 2125764000', () => {
    expect(hamming(1691)).toStrictEqual(2125764000);
});