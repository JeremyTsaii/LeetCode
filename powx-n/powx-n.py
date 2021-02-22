class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = -n
        
        output = 1
        cur = x
        
        i = n
        while i:
            if i % 2 == 1:
                output *= cur
            cur *= cur
            
            i //= 2
        
        return output