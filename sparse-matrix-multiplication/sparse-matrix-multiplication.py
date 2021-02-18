from collections import defaultdict
class Solution:
    def multiply(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        
        output = [[0 for j in range(len(B[0]))] for i in range(len(A))]
        
        rows = defaultdict(list)
        cols = defaultdict(list)
        
        for i in range(len(A)):
            for j in range(len(A[0])):
                if A[i][j]:
                    rows[i].append((A[i][j], j))
        
        for i in range(len(B)):
            for j in range(len(B[0])):
                if B[i][j]:
                    cols[j].append((B[i][j], i))

        for i in rows:
                for j in cols:
                    rowVals = rows[i]
                    colVals = cols[j]

                    total = 0
                    p1, p2 = 0, 0
                    while p1 < len(rowVals) and p2 < len(colVals):
                        if rowVals[p1][1] == colVals[p2][1]:
                            total += rowVals[p1][0] * colVals[p2][0]
                            p1 += 1
                            p2 += 1
                        elif rowVals[p1][1] < colVals[p2][1]:
                            p1 += 1
                        else:
                            p2 += 1
                    output[i][j] = total
        
                    
        return output
        
        

                
        