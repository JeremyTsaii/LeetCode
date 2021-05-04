class Solution:
    def numTeams(self, rating: List[int]) -> int:
        count = 0
        
        for j in range(1, len(rating) - 1):
            
            ascLeft = 0
            ascRight = 0
            
            descLeft = 0
            descRight = 0
            
            for left in range(j):
                if rating[left] > rating[j]:
                    descLeft += 1
                else:
                    ascLeft += 1
            
            for right in range(j + 1, len(rating)):
                if rating[right] > rating[j]:
                    ascRight += 1
                else:
                    descRight += 1
            
            
            count += ascLeft * ascRight + descLeft * descRight
            
        
        return count