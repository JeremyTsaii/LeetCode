# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
​
class Solution(object):
    def getTargetCopy(self, original, cloned, target):
        """
        :type original: TreeNode
        :type cloned: TreeNode
        :type target: TreeNode
        :rtype: TreeNode
        """
        
        s1 = [original]
        s2 = [cloned]
        
        while original != target:
            original = s1.pop()
            cloned = s2.pop()
            
            if original.left:
                s1.append(original.left)
                s2.append(cloned.left)
            if original.right:
                s1.append(original.right)
                s2.append(cloned.right)
        
        return cloned
