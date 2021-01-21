def valid_braces_balance(str_braces):
    """
    Return a tuple valid or no valid 
    - no valid: (str_braces, False)
    - valid: (str_braces_balanced, True)
    """
    
    valid_braces = {
        '(': ')',
        '{': '}',
        '[': ']'
    }
    
    stack = []
    rest_balanced = []
    for current_brace in str_braces:
        if current_brace in valid_braces:
            stack.append(current_brace)
        else:
            if (len(stack) > 0):
                last_stacked = stack.pop()
                if (valid_braces[last_stacked] != current_brace):
                    return (str_braces, False)
            
    while len(stack) > 0:
        last_stacked = stack.pop()      
        rest_balanced.append(valid_braces[last_stacked])
    
    return (str_braces + "".join(rest_balanced), True)

print(valid_braces_balance("([{}]"))
print(valid_braces_balance("{[([)"))

# -------- Tests --------
def test_short_braces():
    valid_braces = "([{}]" 
    assert valid_braces_balance(valid_braces) == ('([{}])', True)
    
def test_medium_braces():
    valid_braces = "{[([{}]"
    assert valid_braces_balance(valid_braces) == ('{[([{}])]}', True)
        
def test_no_valid_braces():
    valid_braces = "{[([)" 
    assert valid_braces_balance(valid_braces) == ('{[([)', False)
    
