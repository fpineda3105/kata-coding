from simple_permut_list import valid_permutations

def test_simple():
    x = y = z = 1
    n = 2
    assert len(valid_permutations(x, y, z, n)) == 5
