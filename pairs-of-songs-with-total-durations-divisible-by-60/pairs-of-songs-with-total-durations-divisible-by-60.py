class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        newTime = [x % 60 for x in time]
        dic = {}
        count = 0
        
        for x in newTime:
            count += dic.get(60 - x if x != 0 else 0, 0)
            dic[x] = dic.get(x, 0) + 1
        
        
        return count