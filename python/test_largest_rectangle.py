def largestRectangle(buildings):
    max_area = 0
    for i in range(1,len(buildings)):
        counter = 1
        for j in range(i-1,-1,-1):
            if (buildings[j] >= buildings[i]):
                counter += 1
            else: break
        
        for j in range(i+1,len(buildings)):
            if (buildings[j] >= buildings[i]):
                counter += 1
            else: break
        max_area = max(max_area,counter * buildings[i])
    
    return max_area 

#----------- Tests --------    
def test_short_buildings1():
    buildings = [11,11,10,10,10]
    assert largestRectangle(buildings) == 50
    
def test_short_buildings2():
    buildings = [1,3,5,9,11]
    assert largestRectangle(buildings) == 18

def test_short_buildings():
    buildings = [1,2,3,4,5]
    assert largestRectangle(buildings) == 9





        