class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        q = deque([(1, 0)])
        seen = set([1])
        
        dst = len(board) * len(board[0])
        while q:
            num, steps = q.popleft()
            i, j = self.numToCoord(num, len(board), len(board[0]))

            if board[i][j] != -1:
                num = board[i][j]
            if num == dst:
                return steps

            for roll in range(1, 7):
                nex = num + roll
                if nex <= dst and nex not in seen:
                    q.append((nex, steps + 1))
                    seen.add(nex)
                            
        
        return -1
    
    def numToCoord(self, num, rows, cols):
        row = rows - 1 - ((num - 1) // cols)
        col = (num - 1) % cols if (rows - 1 - row) % 2 == 0 else cols - 1 - ((num - 1) % cols)
        return (row, col)