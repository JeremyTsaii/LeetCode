import random
class Solution:

    def __init__(self, w: List[int]):
        self.buckets = [0] * len(w)
        
        total = 0
        for i in range(len(w)):
            total += w[i]
            self.buckets[i] = total

    def pickIndex(self) -> int:
        left, right = 0, len(self.buckets) - 1
        r = random.randint(1, self.buckets[-1])
        
        while left < right:
            mid = (left + right) // 2
            
            if r == self.buckets[mid]:
                return mid
            elif r > self.buckets[mid]:
                left = mid + 1
            else:
                right = mid
        
        return left


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()