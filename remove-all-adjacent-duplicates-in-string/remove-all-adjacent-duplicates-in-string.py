class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = []
        
        for c in S:
            if not stack or stack[-1] != c:
                stack.append(c)
            else:
                stack.pop()
        
        return "".join(stack)
        