def validMountainArray(arr):
    if len(arr) < 3:
        return False
    
    prev = arr[0]
    i = 1    
    while i < len(arr):
        if (arr[i] > prev):
            prev = arr[i]
            i += 1    
        else:                        
            break
    
    if (i == 1 or i >=  len(arr) ):
        return False

    while i < len(arr):
        if (arr[i] < prev):
            prev = arr[i]
            i += 1    
        else:
            return False                    
    
    return True

# -------- Test --------
def test_valid_mountain():
    mountain = [0,3,2,1]
    assert validMountainArray(mountain)
    
def test_short_valid_mountain():
    mountain = [1,3,2]
    assert validMountainArray(mountain)    
    
def test_not_valid_mountain():
    mountain = [9,8,7,6,5,4,3,2,1,0]
    assert not validMountainArray(mountain)