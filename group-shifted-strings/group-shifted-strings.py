class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        dic = {}
        
        for string in strings:
            shifts = tuple(ord(string[i]) - ord(string[i+1]) + 26 if ord(string[i]) - ord(string[i+1]) < 0 else ord(string[i]) - ord(string[i+1]) for i in range(len(string)-1))
            dic[shifts] = dic.get(shifts, []) + [string]
            
        return dic.values()