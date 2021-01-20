def replaceElements(arr):
    if len(arr) == 1:
        arr[0] = -1
        return arr
    
    right_max = -1
    for i in range(len(arr)-1, -1, -1):
        temp_val = arr[i]
        arr[i] = right_max
        right_max = max(right_max, temp_val)
    
    return(arr)

# -------- Tests --------
def test_short_array():
    arr = [17,18,5,4,6,1]
    assert replaceElements(arr) == [18,6,6,6,1,-1]
    