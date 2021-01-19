def removeDuplicates(nums):
        i = 1
        j = 1
        prev = nums[0]
        size = len(nums)
        while (j < size):
            if nums[j] != prev:
                nums[i] = nums[j]
                prev = nums[j]
                i +=1
            j+=1
        
        del nums[i:]
        return i

# -------- Tests --------
def test_short_array():
    arr = [1,2,3,3]
    result = removeDuplicates(arr)
    assert result == 3 and arr == [1,2,3]
    