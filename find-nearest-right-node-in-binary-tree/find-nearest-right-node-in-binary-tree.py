from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findNearestRightNode(self, root: TreeNode, u: TreeNode) -> TreeNode:
        
        q = deque([[root, 0]])
        levels = []
        
        while(q):
            node, level = q.popleft()
            if level >= len(levels):
                levels.append([])
            levels[level].append(node)
            for x in [node.left, node.right]:
                if x:
                    q.append([x, level+1])
​
        for level in levels:
            for i in range(len(level)):
                if level[i] == u:
                    if i < len(level)-1:
                        return level[i+1]
                    else:
                        return None
        
        
        
