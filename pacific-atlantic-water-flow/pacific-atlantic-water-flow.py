from collections import deque
class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return []
        
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        good = set()
        good.add((len(matrix) - 1, 0))
        good.add((0, len(matrix[0]) - 1))
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if (i,j) in good:
                    continue
                
                seen = set()
                seen.add((i,j))
                atlantic = False
                pacific = False
                q = deque([(i,j)])
                
                while q:
                    x,y = q.popleft()
                    
                    if x == 0 or y == 0:
                        pacific = True
                    if x == len(matrix) - 1 or y == len(matrix[0]) - 1:
                        atlantic = True
                    
                    for dx, dy in dirs:
                        xx = x + dx
                        yy = y + dy
                        if (xx >= 0 and xx < len(matrix) and yy >= 0 and yy < len(matrix[0]) and (xx,yy) not in seen and matrix[xx][yy] <= matrix[x][y]):
                            seen.add((xx,yy))
                            if (xx,yy) in good:
                                good.add((i,j))
                                q.clear()
                                break
                            else:
                                q.append((xx,yy))
                
                if atlantic and pacific:
                    good.add((i,j))

                    
        return [[x,y] for x,y in good]