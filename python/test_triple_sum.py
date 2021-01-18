def triplets(newA,newB,newC):
    newA = list(sorted(set(newA)))
    newB = list(sorted(set(newB)))
    newC = list(sorted(set(newC)))
    
    ai = 0
    bi = 0
    ci = 0
    
    result = 0
    
    while bi < len(newB):
        while ai < len(newA) and newA[ai] <= newB[bi]:
            ai += 1
        
        while ci < len(newC) and newC[ci] <= newB[bi]:
            ci += 1
        
        result += ai * ci
        bi += 1
    
    return result

# -----------Tests ---------------
def test_triplets_1():
    assert triplets([1,4,5],[2,3,3], [1,2,3]) == 5
    


