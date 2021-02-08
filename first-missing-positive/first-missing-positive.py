class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        filtered = []
        s = set()
        for x in nums:
            if x not in s and x > 0:
                s.add(x)
                filtered.append(x)
                
        heapq.heapify(filtered)

        cur = 1
        for _ in range(len(filtered)):
            if heapq.heappop(filtered) == cur:
                cur += 1
            else:
                return cur
        
        return cur
        