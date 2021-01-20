# Find the elements dissappears from 1-n in an array of n elements.
# for example in the array [1,3,4,2,1,3] the dissapears elements are: [5,6]

def findDisappearedNumbers(nums):
        if (len(nums) < 1):
            return []
        
        size = len(nums)
        result = []
        
        nums = set(nums)
        
        for i in range(1,size + 1):
            if i not in nums:
                result.append(i)
        
        return result

# -------- Tests --------
def test_short_array():
    arr = [4,3,2,7,8,2,3,1]
    assert findDisappearedNumbers(arr) == [5,6]