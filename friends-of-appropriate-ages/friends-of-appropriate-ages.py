class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        
        def test(a, b):
            return (b <= (0.5 * a + 7)) or (b > a) or (b > 100 and a < 100)
            
        counter = 0
        counts = [0] * 121
        
        for age in ages:
            counts[age] += 1
            
        
        for i in range(len(counts)):
            for j in range(len(counts)):
                a = counts[i]
                b = counts[j]
                
                if not test(i, j):
                    counter += a * b
                    
                    if i == j:
                        counter -= a
                    
        
        return counter
    
        