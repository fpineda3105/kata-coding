function checkComments(input, markers) {
    const sentences = input.split('\n')
    const regexp = new RegExp(markers.reduce((acc, next) => acc + `${next}`, '[') + ']')
    const result = sentences.map(s => {
        let index = s.search(regexp)
        if (index !== -1) {
            return s.substring(0, index - 1)
        }
        return s
    }).join('\n')
    return result
}


//----- Test Cases ---//
test(' "with markers ["%", "!"] should return "apples, plums\npears\noranges"', () => {
    expect(checkComments("apples, plums % and bananas\npears\noranges !applesauce", ["%", "!"]))
        .toStrictEqual("apples, plums\npears\noranges");
});

test(' "Q @b\nu\ne -e f g" with markers ["@", "-"] should return "Q\nu\ne"', () => {
    expect(checkComments("Q @b\nu\ne -e f g", ["@", "-"]))
        .toStrictEqual("Q\nu\ne");
});