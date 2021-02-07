from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        
        levels = []
        q = deque([(root, 1)])
        
        while q:
            node, level = q.popleft()
            
            if len(levels) < level:
                levels.append([])
            
            levels[level-1].append(node.val)
            
            for x in [node.left, node.right]:
                if x:
                    q.append((x, level+1))
            
        return [x[-1] for x in levels]
        
        
        