#Project Euler 230: Fibonacci Words
# HackerRank
# https://www.hackerrank.com/contests/projecteuler/challenges/euler230/problem
def print_D_A_B(A, B, n):
    lengths = [len(A)]
    if n <= len(A):
        return A[n-1]
    lengths.append(len(B))
    if n <= len(B):
        return B[n-1]

    idx = 1        
    while True:
        idx = idx + 1
        lengths.append(lengths[idx-2] + lengths[idx-1])
        if lengths[idx]  >= n:
            break

    # Going back recursively until we know where exactly to 
    # find digit n. 
    len_diff = n
    while idx > 1:
        if lengths[idx-2] < len_diff:            
            len_diff = len_diff - lengths[idx-2]
            idx = idx - 1
        else:            
            idx = idx - 2

    if idx == 0:
        return A[len_diff-1]
    else:
        return B[len_diff-1]


# -------- Tests --------
def test_short_numbers():
    A = '1415926535'
    B = '8979323846'
    n = 35

    assert print_D_A_B(A, B, n) == '9'

def test_short_numbers_2():
    A = '1415926535'
    B = '8979323846'
    n = 48

    assert print_D_A_B(A, B, n) == '8'

def test_medium_numbers():
    A = '1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679'
    B = '8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196'
    n = 104683731294243150

    assert print_D_A_B(A, B, n) == '8'
