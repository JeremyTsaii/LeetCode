class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        q = deque([(0,0,0)])
        moves = [[1,2],[2,1],[2,-1],[1,-2],[-1,-2],[-2,-1],[-2,1],[-1,2]]
        visited = set([(0,0)])        
        
        while q:
            xx, yy, count = q.popleft()
            if xx == x and yy == y:
                return count
            
            for dx, dy in moves:
                xxx = xx + dx
                yyy = yy + dy
                if (xxx, yyy) not in visited:
                    q.append((xxx, yyy, count + 1))
                    visited.add((xxx, yyy))

        
            
            