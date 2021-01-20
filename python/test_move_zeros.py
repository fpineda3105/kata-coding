def moveZeroes( nums):
    """
    Do not return anything, modify nums in-place instead.
    """
    i = 0
    j = 1
    while (j < len(nums) and i < len(nums)):
        if (nums[i] == 0):
            if nums[j] != 0:
                nums[i] = nums[j]
                nums[j] = 0        
                i += 1            
            j += 1    
                
        else:
            i += 1
            j += 1        
        
        
# -------- Tests --------
def test_short_array():
    arr = [1,0,1]
    moveZeroes(arr)
    assert arr == [1,1,0]
    
def test_short_array_2():
    arr = [0,1,0,3,12]
    moveZeroes(arr)
    assert arr == [1,3,12,0,0]