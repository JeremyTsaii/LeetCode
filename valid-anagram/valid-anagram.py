class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        map1 = {}
        for c in s:
            map1[c] = map1.get(c, 0) + 1
        
        map2 = {}
        for c in t:
            map2[c] = map2.get(c, 0) + 1
        
        return map1 == map2