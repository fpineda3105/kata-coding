from collections import deque

def minimumMoves(grid, startX, startY, goalX, goalY):
    visited_nodes = set()
    q = deque()
    q.appendleft((startX, startY, 0))
    neighboring_nodes = [
        (-1, 0),
        (1, 0),
        (0, -1),
        (0, 1),
    ]
    grid_dimension = len(grid)
    while q:
        (current_x, current_y, dist) = q.pop()
        new_dist = dist + 1
        for neighboring_node_diff in neighboring_nodes:
            x = current_x + neighboring_node_diff[0]
            y = current_y + neighboring_node_diff[1]
            while (0 <= x < grid_dimension) and (0 <= y < grid_dimension) and (grid[x][y] != 'X'):
                if (x, y) == (goalX, goalY):
                    return new_dist
                elif (x, y) not in visited_nodes:
                    q.appendleft((x, y, new_dist))
                    visited_nodes.add((x, y))
                x += neighboring_node_diff[0]
                y += neighboring_node_diff[1]
 

# -------- Tests --------
def test_min_moves_small():
    arr = ['.X.','.X.', '...']
    startX = startY = 0
    assert minimumMoves(arr, startX, startY, 1,2) == 3

def test_min_moves_medium():
    arr = ['.X..XX...X',
           'X.........', 
           '.X.......X',
           '..........',
           '........X.',
           '.X...XXX..',
           '.....X..XX',
           '.....X.X..',
           '..........',
           '.....X..XX']
    startX = 9
    startY = 1
    goalX = 9
    goalY = 6
    assert minimumMoves(arr, startX, startY, goalX, goalY) == 3
