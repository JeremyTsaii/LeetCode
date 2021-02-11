# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        return self.recurse(root, root.val, root.val)
    
    def recurse(self, root, mini, maxi):
        if not root:
            return maxi - mini
        
        newMin = min(mini, root.val)
        newMax = max(maxi, root.val)
        
        left = self.recurse(root.left, newMin, newMax)
        right = self.recurse(root.right, newMin, newMax)
        return max(left, right)