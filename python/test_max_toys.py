# Find the maximun number of toys that a person can buy.
# given the prices of toys
# https://www.hackerrank.com/challenges/mark-and-toys/problem
def maximum_toys(toys, amount):
    toys.sort()
    quantity = 0
    current_spending = 0
    for i in range(len(toys)):
        if (toys[i] + current_spending <= amount):
            current_spending += toys[i]
            quantity += 1
        else:
            break
    
    return quantity


# -------- Tests --------
def test_short_toys():
    toys = [1,12,200,11,5,1000]
    amount = 50
    assert maximum_toys(toys, 50) == 4
    