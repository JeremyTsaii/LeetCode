class Solution:
    def trap(self, height: List[int]) -> int:
        left = [0] * len(height)
        for i in range(1, len(height)):
            left[i] = max(height[i-1], left[i-1])
        
        right = [0] * len(height)
        for i in range(len(height) - 2, -1, -1):
            right[i] = max(height[i+1], right[i+1])
            
        count = 0
        
        for i in range(len(height)):
            minimum = min(left[i], right[i])
            if height[i] < minimum:
                count += minimum - height[i]
        
        return count