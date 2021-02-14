"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        if not root:
            return None

        first = None
        last = None
        
        cur = root
        stack = []
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            
            cur = stack.pop()
            if not first:
                first = cur
            
            if last:
                last.right = cur
                cur.left = last
            
            last = cur
            cur = cur.right
        
        first.left = last
        last.right = first
        
        return first