from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        if not root:
            return []
        
        q = deque([(root, 0)])
        output = []
        
        sumVal = 0
        numNodes = 0
        
        while q:
            node, level = q.popleft()
            
            if level > len(output):
                output.append(sumVal/numNodes)
                
                sumVal = 0
                numNodes = 0
            
            sumVal += node.val
            numNodes += 1
            
            for child in [node.left, node.right]:
                if child:
                    q.append((child, level+1))
        
        output.append(sumVal/numNodes)
        return output