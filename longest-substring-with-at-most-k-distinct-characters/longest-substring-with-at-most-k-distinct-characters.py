class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if not k:
            return 0
        
        dic = {s[0]: 1}
        maxLen = 1
        
        i, j = 0, 1
        
        while j < len(s):
            if s[j] in dic:
                dic[s[j]] += 1
            else:
                dic[s[j]] = 1
                while len(dic) > k:
                    dic[s[i]] -= 1
                    if not dic[s[i]]:
                        del dic[s[i]]
                    i += 1

            maxLen = max(maxLen, j - i + 1)
            j += 1
            
        return maxLen