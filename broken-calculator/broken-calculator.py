class Solution:
    def brokenCalc(self, X: int, Y: int) -> int:
        
        total = 0
        
        while X != Y:
            if X > Y:
                return total + X - Y
            elif Y % 2 == 0 and X < Y:
                Y //= 2
            else:
                Y += 1
            total += 1
        return total