class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        idx = self.searchInsertPosition(arr, x)
        print(idx)
        i, j = idx, idx
        
        while j - i < k:
            if i == 0:
                return arr[:k]
            if j == len(arr):
                return arr[-k:]
        
            if x - arr[i - 1] <= arr[j] - x:
                i -= 1
            else:
                j += 1
        
        
        return arr[i:j]
    
    def searchInsertPosition(self, nums, target):
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