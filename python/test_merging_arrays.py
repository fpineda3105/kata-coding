def merge(nums1, m, nums2, n):
    """
    Do not return anything, modify nums1 in-place instead.
    """
    i = 0
    j = 0
    while( i < m + j and j < n):
        if (nums2[j] <= nums1[i]):
            nums1.insert(i,nums2[j])
            j += 1            
        i += 1
    nums1[m+j:] = nums2[j:] 


# -------- Tests --------
def test_simple_arrays():
    array1 = [1,2,3,0,0,0]
    array2 = [2,5,6]
    n = 3
    m = 3
    merge(array1, m, array2, n)
    assert array1 == [1,2,2,3,5,6]
    
def test_tricky_array():
    array1 = [2,0]
    array2 = [1]
    n = 1
    m = 1
    merge(array1, m, array2, n)
    assert array1 == [1,2]

def test_second_array_less():
    array1 = [4,5,6,0,0,0]
    array2 = [1,2,3]
    n = 3
    m = 3
    merge(array1, m, array2, n)
    assert array1 == [1,2,3,4,5,6]