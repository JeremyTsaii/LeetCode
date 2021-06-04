class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        dead = set(deadends)
        if "0000" in dead:
            return -1
            
            
        q = deque(["0000"])
        visited = set(["0000"])
        
        count = 0
        
        while q:
            length = len(q)
            
            for _ in range(length):
                comb = q.popleft()

                if comb == target:
                    return count

                for neighbor in self.getNeighbors(comb):
                    if neighbor not in visited and neighbor not in dead:
                        q.append(neighbor)
                        visited.add(neighbor)
            
            count += 1
        
        return -1
    
    def getNeighbors(self, comb):
        neighbors = []
        
        num = [c for c in comb]
        
        for i in range(len(num)):
            copy1 = num[:]
            copy2 = num[:]
            
            copy1[i] = str((int(copy1[i]) + 1) % 10)
            copy2[i] = str((int(copy2[i]) - 1) % 10)
            
            neighbors.append("".join(copy1))
            neighbors.append("".join(copy2))
            
        return neighbors