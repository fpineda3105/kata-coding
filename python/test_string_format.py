from string_format import namelist

def test_one_name():
    one_name = [{'name': 'Bart'}] 
    assert namelist(one_name) == 'Bart'

def test_two_names():
    two_names = [{'name': 'Bart'}, {'name': 'Lisa'}] 
    assert namelist(two_names) == 'Bart & Lisa'

def test_multiple_names():
    multiple_names = [{'name': 'Bart'}, {'name': 'Lisa'}, {'name': 'Fer'}] 
    assert namelist(multiple_names) == 'Bart, Lisa & Fer'
