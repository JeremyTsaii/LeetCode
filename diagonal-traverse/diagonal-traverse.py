class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        
        cols = [[] for _ in range(len(mat) + len(mat[0]) - 1)]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                cols[i + j].append(mat[i][j])
                
        output = []
        
        for i in range(len(cols)):
            if i % 2 == 0:
                [output.append(x) for x in cols[i][::-1]]
            else:
                [output.append(x) for x in cols[i]]
        
        return output