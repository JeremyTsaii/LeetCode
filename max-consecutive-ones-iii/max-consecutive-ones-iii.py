class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        start, end = 0, 0
        maxLen = 0
        used = 0
        
        while start < len(A) and end < len(A):
            if A[end] == 0:
                used += 1
            
            while used > K and start < len(A):
                if A[start] == 0:
                    used -= 1
                start += 1
            
            maxLen = max(maxLen, end - start + 1)
            end += 1
            
        return maxLen
                
        