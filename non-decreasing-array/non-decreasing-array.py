class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        
        used = False
        
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                if used:
                    return False
                used = True
                
                if (i > 0 and nums[i - 1] <= nums[i + 1]) or (i == 0):
                    nums[i] = nums[i - 1]
                else:
                    nums[i + 1] = nums[i]
                
        
        return True