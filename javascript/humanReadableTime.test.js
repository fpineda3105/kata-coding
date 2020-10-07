/**
 * https://www.codewars.com/kata/52685f7382004e774f0001f7/
 * Human Readable Time
 * 
 * Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)
 * 
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * 
 * The maximum time never exceeds 359999 (99:59:59)
 * 
 */

function howManyOf(seconds, divider) {
    let result = Math.floor(seconds / divider);
    return [
        result >= 10 ? result : '0' + result,
        seconds % divider
    ]        
}

function humanReadable(seconds) {
    let [hh, mm, ss] = ['00', '00', '00'];
    [hh, seconds] = howManyOf(seconds, 3600);
    [mm, seconds] = howManyOf(seconds,60);
    [ss] = howManyOf(seconds,1);    
    return [hh, mm, ss].join(":");
}

// Test cases
test('the humanReadable of 86399 is  "23:59:59" ', () => {
    expect(humanReadable(86399)).toStrictEqual("23:59:59");
})

test('the humanReadable of 0 is  "00:00:00" ', () => {
    expect(humanReadable(0)).toStrictEqual("00:00:00");
})

test('the humanReadable of 5 is  "00:00:05" ', () => {
    expect(humanReadable(5)).toStrictEqual("00:00:05");
})

test('the humanReadable of 359999 is  "99:59:59" ', () => {
    expect(humanReadable(359999)).toStrictEqual("99:59:59");
})