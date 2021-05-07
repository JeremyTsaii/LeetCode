class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        longest = self.lcs(word1, word2)
        return len(word1) + len(word2) - longest * 2
    
    def lcs(self, s1, s2):
        
        dp = [[0 for j in range(len(s2) + 1)] for i in range(len(s1) + 1)]
        
        for i in range(1, len(s1) + 1):
            for j in range(1, len(s2) + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        
        return dp[-1][-1]