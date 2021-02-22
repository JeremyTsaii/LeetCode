# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: TreeNode, target: float) -> int:
        
        closest = root.val
        
        while root:
            minDiff = abs(closest - target)
            curDiff = abs(root.val - target)
            
            if curDiff < minDiff:
                closest = root.val
            
            if target < root.val:
                root = root.left
            else:
                root = root.right
        
        return closest
            