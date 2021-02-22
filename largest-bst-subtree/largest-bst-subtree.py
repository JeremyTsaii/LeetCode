# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestBSTSubtree(self, root: TreeNode) -> int:
        
        def recurse(node):
            if not node:
                return (True, 0, float('inf'), float('-inf'))
            
            leftTrue, leftCount, leftMin, leftMax = recurse(node.left)
            rightTrue, rightCount, rightMin, rightMax = recurse(node.right)
            
            if leftTrue and rightTrue and leftMax < node.val < rightMin:
                self.maximum = max(self.maximum, leftCount + rightCount + 1)
                return (True, leftCount + rightCount + 1, min(leftMin, node.val), max(rightMax, node.val))
            
            return (False, 0, 0, 0)

            
        self.maximum = 0
        recurse(root)
        return self.maximum