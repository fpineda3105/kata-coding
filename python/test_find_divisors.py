from find_divisors import divisors

def test_a_small_number():
    assert divisors(15) == [3,5]

def test_a_medium_number():
    assert divisors(253) == [11,23]

def test_a_prime_number():
    assert divisors(13) == '13 is prime'