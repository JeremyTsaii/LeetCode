class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        dic = set()
        neighbors = [(1,0,'a'), (0,1,'b'), (-1,0,'b'), (0,-1,'d')]
        stack = []
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    grid[i][j] = 0
                    stack.append((i,j))
                    uniqStr = ""
                    while stack:
                        x, y = stack.pop()
                        for dx, dy, char in neighbors:
                            xx = x + dx
                            yy = y + dy
                            if xx >= 0 and xx < len(grid) and yy >= 0 and yy < len(grid[0]) and grid[xx][yy] == 1:
                                uniqStr += char + str(len(stack))
                                stack.append((xx,yy))
                                grid[xx][yy] = 0
                    if uniqStr not in dic:
                        dic.add(uniqStr)
        return len(dic)
