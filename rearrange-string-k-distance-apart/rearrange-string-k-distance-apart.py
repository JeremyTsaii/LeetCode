from heapq import heapify, heappop, heappush
class Solution:
    def rearrangeString(self, s: str, k: int) -> str:
        if k <= 1 or len(s) <= 1:
            return s
        
        dic = Counter(s)
        heap = [(-dic[x], x) for x in dic]
        heapify(heap)
        
        chars = []
        
        while heap:
            wait = k
            temp = []
            
            while wait > 0 and heap:
                count, char = heappop(heap)
                chars.append(char)
                wait -= 1
                temp.append((count + 1, char))
            
            for c, ch in temp:
                if c < 0:
                    heappush(heap, (c, ch))
        
            if wait and heap:
                return ""
        
        return "".join(chars)