class Solution:
    def reorganizeString(self, S: str) -> str:
        counter = Counter(S)
        heap = [(-counter[x], x) for x in counter]
        heapq.heapify(heap)
        
        prevChar = ""
        prevCount = 0
        chars = []
        while heap:
            count, char = heapq.heappop(heap)
            chars.append(char)
            
            if prevCount < 0:
                heapq.heappush(heap, (prevCount, prevChar))
            
            prevChar = char
            prevCount = count + 1
            
        
        
        return "" if len(chars) != len(S) else "".join(chars)
        
        
        