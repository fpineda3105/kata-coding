from collections import Counter

def production_days(machines, goal):

    machine_quantity = Counter(machines)
    fastest_machine = min(machines)
    max_days = goal * fastest_machine // machine_quantity[fastest_machine]
     
    def calculate_production(day):
        return sum((day//prod) * quantity for prod, quantity in machine_quantity.items())

    def binary_search(min_day, max_day):        
        while max_day - min_day > 1:
            pivot_day = (min_day + max_day) // 2           
            production = calculate_production(pivot_day)
            if (production < goal):
                min_day = pivot_day
            else:
                max_day = pivot_day
        else:
            return max_day
      
    return binary_search(fastest_machine, max_days)


# -------- Tests --------
def test_short_machines_short_goal():
    machines = [2, 3, 2]
    goal = 10
    assert production_days(machines, goal) == 8

def test_short_machines_short_goal2():
    machines = [4, 5, 6]
    goal = 12
    assert production_days(machines, goal) == 20
