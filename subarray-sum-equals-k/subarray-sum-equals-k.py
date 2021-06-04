class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dic = {0: 1}
        
        total = 0
        count = 0
        for n in nums:
            total += n
            if total - k in dic:
                count += dic[total - k]
            dic[total] = dic.get(total, 0) + 1

        return count