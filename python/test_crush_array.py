# https://www.hackerrank.com/challenges/crush/problem
# Given a serie of queries, find the max element in an array
# after applying  all those queries.

def max_value(n, queries):    
    arr = [0 for i in range(n+1)] 
    for query in queries:
        a, b, k = query[0], query[1], query[2]
        arr[a - 1] += k
        arr[b] -= k
    
    max_sum = 0
    current_sum = 0
    for i in range(n + 1):
        current_sum += arr[i]
        max_sum = max(max_sum, current_sum)
    
    return max_sum                


# -------- Tests --------

def test_short_array_3_queries():
    n = 10
    queries = [[1, 5, 3], [4, 8, 7], [6, 9, 1]]
    assert max_value(n, queries) == 10
    
def test_short_array_3_queries_2():
    n = 5
    queries = [[1, 2, 100], [2, 5, 100], [3, 4, 100]]
    assert max_value(n, queries) == 200

def test_short_array_4_queries():
    n = 10
    queries = [[2, 6, 8], [3, 5, 7], [1, 8, 1], [5, 9, 15]]
    assert max_value(n, queries) == 31