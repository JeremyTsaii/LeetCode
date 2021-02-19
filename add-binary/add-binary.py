from collections import deque
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        arr1 = list(a)
        arr2 = list(b)
        output = deque([])
        
        carry = 0
        while arr1 or arr2:
            val1 = int(arr1.pop()) if arr1 else 0
            val2 = int(arr2.pop()) if arr2 else 0
            val = val1 + val2 + carry
            carry = val // 2
            val %= 2
            
            output.appendleft(str(val))
        
        if carry:
            output.appendleft("1")
        
        return "".join(output)
            