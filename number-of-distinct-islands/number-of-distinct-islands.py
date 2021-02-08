class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        dic = set()
        seen = set()
        dirs = [(0,1,'a'),(1,0,'b'),(-1,0,'c'),(0,-1,'d')]
        stack = []
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    stack.append((i,j))
                    grid[i][j] = 0
                    cur = []
                    while stack:
                        x, y = stack.pop()
                        for dx, dy, char in dirs:
                            xx = x + dx
                            yy = y + dy
                            
                            if xx >= 0 and xx < len(grid) and yy >= 0 and yy < len(grid[0]) and grid[xx][yy] == 1:
                                grid[xx][yy] = 0
                                stack.append((xx,yy))
                                cur.append(char + str(len(stack)))

                    dic.add("".join(cur))
                
        return len(dic)