class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        
        count = 0
        d = [0] * k
        d[0] = 1
        
        total = 0
        for n in nums:
            total = (total + n) % k
            count += d[total]
            d[total] += 1  
        
        return count
            