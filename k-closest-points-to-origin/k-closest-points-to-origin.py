class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        output = []
        
        for x, y in points:
            dist = (x*x + y*y)**.5
            
            output.append((dist, x, y))
        
        output.sort()
        
        return [[output[i][1], output[i][2]] for i in range(K)]
        
        