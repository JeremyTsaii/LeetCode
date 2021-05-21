class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        patDic = {}
        wordsDic = {}
        
        words = s.split()
        
        if len(words) != len(pattern):
            return False
        
        
        for i in range(len(words)):
            if words[i] not in wordsDic:
                wordsDic[words[i]] = i
            if pattern[i] not in patDic:
                patDic[pattern[i]] = i
            
            if wordsDic[words[i]] != patDic[pattern[i]]:
                return False
        
        return True