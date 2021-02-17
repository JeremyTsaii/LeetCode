from collections import defaultdict
from itertools import combinations

class Solution:
    def mostVisitedPattern(self, username: List[str], timestamp: List[int], website: List[str]) -> List[str]:

        arr = sorted(zip(timestamp, username, website))
        
        dic = defaultdict(list)
        
        for _, user, site in arr:
            dic[user].append(site)
            
        possible = defaultdict(int)
        
        for siteArr in dic.values():
            combs = set(combinations(siteArr, 3))
            for comb in combs:
                possible[comb] += 1
        
        return min(possible, key = lambda x: (-possible[x], x))