class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:
        
        output = set()
        
        posX = set([1])
        posY = set([1])
        
        curX = 1
        curY = 1
        
        while x != 1 and curX < bound:
            posX.add(curX)
            curX *= x
            
        while y != 1 and curY < bound:
            posY.add(curY)
            curY *= y
        
        
        
        for num in range(2, bound + 1):
            for x in posX:
                if num - x in posY:
                    output.add(num)
        
        
        return list(output)