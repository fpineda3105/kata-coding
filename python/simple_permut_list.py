'''
HackerRank simple Kata
https://www.hackerrank.com/challenges/list-comprehensions/problem
'''
def valid_permutations(x,y,z,n):
    permutations = [[a,b,c] for a in range(x+1) for b in range(y+1) for c in range(z+1)]
    return [valid for valid in permutations if sum(valid) != n]