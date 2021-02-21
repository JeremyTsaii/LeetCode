class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        
        words = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[-1] = True
        
        for i in range(len(s))[::-1]:
            for j in range(i, len(s)):
                if dp[i]:
                    continue
                segment = s[i:j+1]
                
                if segment in words and dp[j + 1]:
                    dp[i] = True
                
        return dp[0]