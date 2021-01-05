const validBrackets = new Map([
    ['()', true],
    ['[]', true],
    ['{}', true]
])

function isBalanced(s) {
    const stack = []
    
    for (const bracket of s) {
        switch (bracket) {
            case '(':
            case '[':
            case '{':
                stack.push(bracket)
                break
            case ']':
            case '}':
            case ')':
                if (stack.length === 0) {
                    return "NO"
                }
                let possiblePair = stack.pop() + bracket
                if (!validBrackets.has(possiblePair)) {
                    return "NO"
                }
                break
            default:
                return "NO"
        }
    }

    return "YES"
}


//----- Test Cases ---//
test('Basic Valid braces [{()}]', () => {    
    expect(isBalanced('()(){{}}[()()]{}{}')).toStrictEqual('YES')
});

test('NON Valid braces [{())}]', () => {    
    expect(isBalanced('[{())}]')).toStrictEqual('NO')
});

test('medium Valid braces [{()}]', () => {    
    expect(isBalanced('[][(())[({{{()[]}}{[[][[][[[]{{{[()]{{{{}{[]}[][]}}}}}}]]]]}})]]')).toStrictEqual('YES')
});

test('medium NON-Valid braces [{())}]', () => {    
    expect(isBalanced('({(}{})))}(}[)[}{)}}[)[{][{(}{{}]({}{[(})[{[({{[}{(]]})}')).toStrictEqual('NO')
});