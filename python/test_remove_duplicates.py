def removeElement(nums, val):
    i = 0
    j = 0
    
    while j < len(nums):
        if (nums[j] != val):                        
            nums[i] = nums[j]            
            i += 1
        j += 1               
    
    del nums[i:]
    return i


# -------- Tests --------
def test_short_array():
    arr = [1,2,3,4,6,7,8,9,3]
    result = removeElement(arr, 3)
    assert result == 7 and arr == [1,2,4,6,7,8,9]
    
def test_short_array2():
    arr = [3,2,2,3]
    result = removeElement(arr, 3)
    assert result == 2 and arr == [2,2]