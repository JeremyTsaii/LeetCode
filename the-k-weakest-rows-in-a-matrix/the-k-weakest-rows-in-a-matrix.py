class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        buckets = [[] for i in range(len(mat[0]) + 1)]
        
        for i in range(len(mat)):
            numSoldiers = sum(mat[i])
            buckets[numSoldiers].append(i)
        
        output = []
        curRow = 0
        curCol = 0
        while len(output) < k:
            if curCol >= len(buckets[curRow]):
                curRow += 1
                curCol = 0
                continue
                
            output.append(buckets[curRow][curCol])
            curCol += 1
        
        return output