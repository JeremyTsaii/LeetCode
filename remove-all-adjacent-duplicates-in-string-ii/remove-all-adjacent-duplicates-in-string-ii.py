class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        
        for c in s:
            if not stack or stack[-1][0] != c:
                stack.append([c,1])
            elif stack[-1][1] == k - 1:
                stack.pop()
            else:
                stack[-1][1] += 1
        
        return "".join([x[0] * x[1] for x in stack])
                