class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def backtrack(i):
            if i == n:
                output.append(list(board))
            else:
                for j in range(n):
                    if j not in cols and j-i not in diag1 and j+i not in diag2:
                        cols.add(j)
                        diag1.add(j-i)
                        diag2.add(j+i)
                        
                        board.append("." * j + "Q" + "." * (n - j - 1))
                        backtrack(i+1)
                        board.pop()
                        cols.remove(j)
                        diag1.remove(j-i)
                        diag2.remove(j+i)
        
        output = []
        board = []
        cols = set()
        diag1 = set()
        diag2 = set()
        
        backtrack(0)
        return output