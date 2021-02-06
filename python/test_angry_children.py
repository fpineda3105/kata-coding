# HackerRank Greedy algorithm
# https://www.hackerrank.com/challenges/angry-children/problem
import sys

def maxMin(k: int, arr: list) -> int:
    arr.sort()    
    min_diff = sys.maxsize    
    for i in range(len(arr) - k + 1):
        min_diff = min(min_diff, arr[i+k -1] - arr[i])
        
    return min_diff

# -------- Tests --------

def test_short_array():
    arr = [1, 2, 1, 2, 1]
    k = 2
    assert maxMin(k, arr) == 0


def test_short_array_2():
    arr = [1, 2, 3, 4, 10, 20, 30, 40, 100, 200]
    k = 4
    assert maxMin(k, arr) == 3


def test_short_array_3():
    arr = [10, 100, 300, 200, 1000, 20, 30]
    k = 3
    assert maxMin(k, arr) == 20