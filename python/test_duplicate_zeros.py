def duplicateZeros(arr) :
        """
        Do not return anything, modify arr in-place instead.
        """
        original_size = len(arr)
        i = original_size - 2       
        while i >= 0:
            if arr[i] == 0:
                arr.insert(i,0)                                
            i -= 1
        del arr[original_size:]

# -------- Tests --------
def test_short_array():
    arr = [1,0,2,3,0,4,5,0]
    duplicateZeros(arr)
    assert arr == [1,0,0,2,3,0,0,4]
    
def test_short_array2():
    arr = [0,4,1,0,0,8,0,0,3]
    duplicateZeros(arr)
    assert arr == [0,0,4,1,0,0,0,0,8]