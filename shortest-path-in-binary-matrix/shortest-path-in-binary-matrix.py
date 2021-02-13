from collections import deque
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        
        q = deque([])
        
        if not grid[0][0]:
            q.append((0,0,1))
            grid[0][0] = 1
        else:
            return -1
        
        dirs = [(0,1),(0,-1),(1,0),(1,-1),(-1,0),(1,1),(-1,1),(-1,-1)]
        
        while q:
            i, j, steps = q.popleft()
            
            if i == len(grid) - 1 and j == len(grid[0]) - 1:
                return steps
            
            for di, dj in dirs:
                ii = i + di
                jj = j + dj
                
                if ii >= 0 and ii < len(grid) and jj >= 0 and jj < len(grid[0]) and grid[ii][jj] == 0:
                    q.append((ii,jj,steps+1))
                    grid[ii][jj] = 1
            
            
        return -1