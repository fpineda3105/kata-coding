/**
 * https://www.codewars.com/kata/5842df8ccbd22792a4000245
 * Write Number in Expanded Form 
 * You will be given a number and you will need to return it as a string in Expanded Form. For example:
 * 
 * expandedForm(12); // Should return '10 + 2'
 * expandedForm(42); // Should return '40 + 2'
 * expandedForm(70304); // Should return '70000 + 300 + 4
 *  
 */

function expandedForm(number) {
    let strNumber = number + '';
    let result = [];
    while (strNumber.length > 1) {
        let expand = strNumber.charAt(0) + '0'.repeat(strNumber.length - 1);
        result.push(expand);
        strNumber =  parseInt(strNumber) - parseInt(expand) + '';       
    }
    if (strNumber !== '0') {
        result.push(strNumber);        
    }    
    return result.join(' + ');
}

  //----- Test Cases ---//
test('expanded form of 70304 should return "70000 + 300 + 4" ', () => {
    expect(expandedForm(70304)).toStrictEqual('70000 + 300 + 4');
});

test('expanded form of 4982342 should return "4000000 + 900000 + 80000 + 2000 + 300 + 40 + 2" ', () => {
    expect(expandedForm(4982342)).toStrictEqual('4000000 + 900000 + 80000 + 2000 + 300 + 40 + 2');
});

test('expanded form of 420370022 should return "400000000 + 20000000 + 300000 + 70000 + 20 + 2" ', () => {
    expect(expandedForm(420370022)).toStrictEqual('400000000 + 20000000 + 300000 + 70000 + 20 + 2');
});

//Big number
test('expanded form of 92093403034573 should return "90000000000000 + 2000000000000 + 90000000000 + 3000000000 + 400000000 + 3000000 + 30000 + 4000 + 500 + 70 + 3" ', () => {
    expect(expandedForm(92093403034573)).toStrictEqual('90000000000000 + 2000000000000 + 90000000000 + 3000000000 + 400000000 + 3000000 + 30000 + 4000 + 500 + 70 + 3');
});