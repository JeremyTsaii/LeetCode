# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        dic = {}
        self.sum(root, dic)
        return self.recurse(root, None, dic)
    
    def recurse(self, root, parent, dic):
        if not root:
            return None
        
        parentVal = 0
        if parent:
            parentVal = dic[parent.val][1]
            if parent.right == root:
                if dic[parent.val][1] == sum(dic[root.val]) + parent.val:
                    parentVal = 0
                else:
                    parentVal -= (parent.val + sum(dic[root.val]))
                    
        
        dic[root.val][1] += parentVal
        node = TreeNode(dic[root.val][1])
        
        node.right = self.recurse(root.right, root, dic)
        node.left = self.recurse(root.left, root, dic)

        return node
    
    def sum(self, root, dic):
        if not root:
            return 0
        
        
        left = self.sum(root.left, dic)
        right = self.sum(root.right, dic)
        
        dic[root.val] = [left, right + root.val]
        
        return root.val + left + right