class Solution:
    def jump(self, nums: List[int]) -> int:
        count, end, farthest = 0, 0, 0
        
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            
            if i == end:
                count += 1
                end = farthest
        
        return count