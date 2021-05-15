class Solution:
    def isNumber(self, s: str) -> bool:
        
        for i in range(len(s)):
            if s[i] in ["e", "E"]:
                left = s[:i]
                right = s[i+1:]
                
                if not (left and right):
                    return False
                return (self.isDecimal(left) or self.isInteger(left)) and self.isInteger(right)
        
        return self.isDecimal(s) or self.isInteger(s)
    
    def isInteger(self, s):
        if not (self.isDigit(s[0]) or self.isSign(s[0])):
            return False
        if len(s) == 1 and self.isSign(s[0]):
            return False
        
        return self.allDigits(s[1:])
    
    def isDecimal(self, s):
        
        for i in range(len(s)):
            if s[i] == ".":
                left = s[:i]
                right = s[i+1:]
                
                if left and self.isSign(left[0]):
                    left = left[1:]
                if not (left or right):
                    return False
                
                leftValid = self.allDigits(left) if left else True
                rightValid = self.allDigits(right) if right else True
                
                return leftValid and rightValid
                
    
    def allDigits(self, s):
        for c in s:
            if not self.isDigit(c):
                return False
            
        return True
    
    def isDigit(self, c):
        return c in ['0','1','2','3','4','5','6','7','8','9']
    
    def isSign(self, c):
        return c in ['+','-']
    
    
    