class Solution:
    def findLongestWord(self, s: str, d: List[str]) -> str:
        maxStr = ""
        d.sort()
        
        for word in d:
            i, j = 0, 0
            
            while i < len(s) and j < len(word):
                if s[i] == word[j]:
                    j += 1
                i += 1

            if j == len(word) and len(word) > len(maxStr):
                maxStr = word
                    
        
        return maxStr