class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        left, right = 0, len(height) - 1
        
        while (left < right):
            height2 = min(height[left], height[right])
            width = right - left
            maxArea = max(maxArea, height2 * width)
            
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1
        
        return maxArea