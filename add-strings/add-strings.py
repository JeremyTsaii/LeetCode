from collections import deque
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        chars = deque([])
        
        carry = 0
        
        for i in range(1, max(len(num1), len(num2)) + 1):
            val1 = ord(num1[-i]) - ord('0') if i <= len(num1) else 0
            val2 = ord(num2[-i]) - ord('0') if i <= len(num2) else 0
            total = val1 + val2 + carry
            carry = total // 10
            total %= 10
            chars.appendleft(chr(ord('0') + total))
        
        if carry:
            chars.appendleft("1")
        
        return "".join(chars)