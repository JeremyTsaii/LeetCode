class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        return sum(abs(nums[len(nums) // 2] - x) for x in nums)