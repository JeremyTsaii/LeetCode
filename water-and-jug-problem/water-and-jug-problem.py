from collections import deque
class Solution:
    def canMeasureWater(self, jug1Capacity: int, jug2Capacity: int, targetCapacity: int) -> bool:
        q = deque()
        q.append((0, 0))
        seen = set()
        seen.add((0,0))
        
        while q:
            jug1, jug2 = q.popleft()
            
            if jug1 == targetCapacity or jug2 == targetCapacity or jug1 + jug2 == targetCapacity:
                return True
            
            pos = [ (jug1, jug2Capacity), (jug1Capacity, jug2),
                    (jug1, 0), (0, jug2),
                    (max(jug1 - (jug2Capacity - jug2), 0), min(jug2 + jug1, jug2Capacity)),
                    (min(jug1 + jug2, jug1Capacity), max(jug2 - (jug1Capacity - jug1), 0))
                  ]
            
            for p in pos:
                if p not in seen:
                    seen.add(p)
                    q.append(p)
        
        
        
        return False