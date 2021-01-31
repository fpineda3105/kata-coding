"""
Greedy algorithm from HackerRank
https://www.hackerrank.com/challenges/luck-balance/
"""


def get_maximun_luck(k: int, contests: list) -> int:
    """
    Inputs: 
        k        - the number of important contest that Lena can loose
        contests - the list of contests (each contest is a list of 2 values) 
        representing the Lucky and the importance of the contest.
        = 0 -> No important contest
        >=1 -> Important contest        
    Output: 
        The maximun luck that Lena can accumulate losing k important contests
    """
    contests.sort(key=lambda contest: contest[0], reverse=True)

    accum_luck = 0
    for contest in contests:
        if (contest[1] == 0):
            accum_luck += contest[0]
            continue

        if (k > 0):
            k -= 1
            accum_luck += contest[0]
        else:
            accum_luck -= contest[0]

    return accum_luck


# -------- Tests --------
def test_simple_luck():

    contests = [[5, 1], [1, 2], [4, 0]]
    k = 2

    assert get_maximun_luck(k, contests) == 10


def test_simple_luck_2():

    contests = [[5, 1], [4, 0], [6, 1], [2, 1], [8, 0]]
    k = 2

    assert get_maximun_luck(k, contests) == 21
