# Hacker Rank - Special-palindrome
def substrCount(n, s):
    tot = 0
    count_seq = 0
    prev = ''
    for index,current in enumerate(s):
        count_seq += 1
        if index and (prev != current):            
            j = 1
            while ((index-j) >= 0) and ((index+j) < len(s)) and j <= count_seq:                
                left = s[index-j]
                right = s[index+j]
                if left == prev == right:                    
                    tot += 1
                    j += 1
                else:                    
                    break
                            
            count_seq = 1  
        tot += count_seq            
        prev = current
    return tot


# -------- Tests --------

def test_easy_string():
    string = 'aaaa'
    assert substrCount(4,string) == 10

def test_simple_string():
    string = 'abcbaba'
    assert substrCount(7,string) == 10