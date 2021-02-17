class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        def strCompare(s1, s2, dic):
            for i in range(min(len(s1), len(s2))):
                if dic[s1[i]] < dic[s2[i]]:
                    return True
                elif dic[s1[i]] > dic[s2[i]]:
                    return False

            return len(s1) <= len(s2)
        
        dic = {}
        for i in range(len(order)):
            dic[order[i]] = i
    
        for i in range((len(words) - 1)):
            if not strCompare(words[i], words[i+1], dic):
                return False
        
        return True
        
