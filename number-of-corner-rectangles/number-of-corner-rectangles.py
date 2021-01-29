class Solution:
    def countCornerRectangles(self, grid: List[List[int]]) -> int:
        dic = {}
        count = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    for k in range(j+1, len(grid[0])):
                        if grid[i][k] == 1:
                            if (j, k) in dic:
                                dic[(j, k)] += 1
                                count += dic[(j,k)]
                            else:
                                dic[(j, k)] = 0        
        
        return count