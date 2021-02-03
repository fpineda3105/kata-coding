# Returns a
def consecutive_counters(letters: str)-> list:
    """Returns a list of counters of consecutive letters

    Args:
        letters (str): a consecutive letters like aaaabbbcca

    Returns:
        list: list of tuple of a letter and counter of consecutive
    """
    if (len(letters) == 0):
        return []        
    
    prev = letters[0]
    counter = 1
    result = []
    
    for i in range(1, len(letters)):
        if letters[i] == prev:
            counter += 1
        else: 
            elem = (prev, counter)
            result.append(elem)
            counter = 1
            prev = letters[i]
    
    elem = (prev, counter)
    result.append(elem)
    
    return result            

# -------- Tests --------
def test_short_string():    
    assert consecutive_counters('') == []
    assert consecutive_counters('a') == [('a', 1)]
    assert consecutive_counters('aaaabbbcca') == [('a', 4), ('b', 3), ('c', 2), ('a', 1)]
    
    