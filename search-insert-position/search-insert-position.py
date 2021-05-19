class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target > nums[-1]:
            return len(nums)
        if target < nums[0]:
            return 0
        left = 0
        right = len(nums)-1
        possible = 0
        while(left<right):
            mid = (left+right)//2
            if nums[mid] == target:
                return mid
            elif target > nums[mid]:
                left = mid+1
                possible = mid+1
            else:
                right = mid
                possible = mid
        return possible
        