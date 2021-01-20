def sort_array_by_parity(A):
    i = 0
    j = 0
    for j in range(len(A)):
        if (A[j] % 2 == 0):            
            A[i], A[j] = A[j], A[i] 
            i += 1            
        j += 1

    return A


# -------- Tests --------

def test_short_array():
    arr = [3, 1, 2, 4]
    assert sort_array_by_parity(arr) == [2,4,3,1]