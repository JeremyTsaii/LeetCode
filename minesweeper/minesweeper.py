class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        x, y = click
        
        if board[x][y] == 'M':
            board[x][y] = 'X'
        else:
            stack = [(x,y)]
            while stack:
                x2, y2 = stack.pop()
                mines = 0
                count = 0
                for di, dj in [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)]:
                    i = x2 + di
                    j = y2 + dj
                    if i >= 0 and i < len(board) and j >= 0 and j < len(board[0]):
                        if board[i][j] == 'M':
                            mines += 1
                        elif board[i][j] == 'E':
                            count += 1
                            stack.append((i,j))
                    
                if not mines:
                    board[x2][y2] = 'B'

                else:
                    board[x2][y2] = str(mines)
                    while count:
                        count -= 1
                        stack.pop()
        
        
        return board