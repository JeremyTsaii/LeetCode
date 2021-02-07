class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        output = [0 for i in range(len(s))]
        
        indices = [i for i in range(len(s)) if s[i] == c]
        
        
        for i in range(len(s)):
            if s[i] == c:
                continue
            
            minimum = float('inf')
            for pos in indices:
                minimum = min(minimum, abs(pos-i))
            output[i] = minimum
        
        return output
            
            