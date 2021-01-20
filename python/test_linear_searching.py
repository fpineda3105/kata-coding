def checkIfExist(arr):        
    cache = {}
    for i,num in enumerate(arr):            
        cache[num] = i
    
    for i,num in enumerate(arr):
        if (num * 2) in cache and cache[num* 2] != i:
            return True
        
    return False

# -------- Tests --------
def test_existence_short_array():
    arr = [7,1,14,11]
    assert checkIfExist(arr)
    

def test_existence_short_tricky_array():
    arr = [-10,12,-20,-8,15]
    assert checkIfExist(arr)
    
def test_existence_another_tricky_array():
    arr = [-2,0,10,-19,4,6,-8]
    assert not checkIfExist(arr)