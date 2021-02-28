# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        
        cur = root
        stack = []
        lastVal = float('-inf')
        
        while(cur or stack):
            while(cur):
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            if cur.val <= lastVal:
                return False
            lastVal = cur.val
            cur = cur.right
        
        return True