class Solution:
    def minMoves(self, nums: List[int]) -> int:
        
        minimum = float('inf')
        total = 0
        
        for x in nums:
            minimum = min(minimum, x)
            total += x
        
        return total - minimum * len(nums)