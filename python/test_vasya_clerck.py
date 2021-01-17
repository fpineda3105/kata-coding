def valid_tickets(queue):
    current_bills = {
        25: 0,
        50: 0,
        100: 0
    }    

    def verify_change(devolution):
        if (devolution in current_bills and current_bills[devolution] > 0):
            current_bills[devolution] -= 1
            return True
        elif devolution == 25:
            return False
        else:
            return verify_change(devolution - 25) and verify_change(25)

    for bill in queue:
        current_bills[bill] += 1
        if (bill == 25):
            continue
        else:
            if (not verify_change(bill - 25)):                
                return "NO"

    return 'YES'


def test_short_valid_queue():
    queue = [25, 25, 50, 50]
    assert valid_tickets(queue) == 'YES'


def test_short_valid_queue2():
    queue = [25, 25, 50, 50]
    assert valid_tickets(queue) == 'YES'


def test_short_invalid_queue():
    queue = [25, 100]
    assert valid_tickets(queue) == 'NO'


def test_short_invalid_queue2():
    queue = [25, 25, 50, 100]
    assert valid_tickets(queue) == 'YES'


def test_medium_invalid_queue2():
    queue = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
    assert valid_tickets(queue) == 'NO'


def test_medium_valid_queue2():
    queue = [25, 25, 25, 25, 50, 100, 50]
    assert valid_tickets(queue) == 'YES'


def test_short_invalid_queue3():
    queue = [25, 50, 25, 100]
    assert valid_tickets(queue) == 'YES'
