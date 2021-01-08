class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        dic = {}
        maxLen = 0
        
        for i in range(len(s)):
            # String contains letter
            if s[i] in dic and dic[s[i]] >= start:
                start = dic[s[i]] + 1
            else:
                maxLen = max(maxLen, i - start + 1)
            dic[s[i]] = i
​
        return maxLen
