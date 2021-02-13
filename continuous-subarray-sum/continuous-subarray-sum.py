class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        for i in range(len(nums)):
            cur = nums[i]
            for j in range(i+1, len(nums)):
                cur += nums[j]
                
                if cur == k or (k != 0 and cur % k == 0):
                    return True
            
        return False