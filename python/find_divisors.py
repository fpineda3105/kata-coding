# Codewar Kata
# https://www.codewars.com/kata/544aed4c4a30184e960010f4
def divisors(integer):
    result = [i for i in range(2,integer//2 + 1) if (integer % i == 0)]
    if (len(result) > 0):
            return result
    else:
        return '{} is prime'.format(integer)