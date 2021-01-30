# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        dic = {}
        self.recurse(root, dic, 0, 0)
        
        arr = []
        for key in dic:
            arr.append(key)
        
        arr.sort(key=lambda x: (x[1], x[0]))

        output = []
        seen = set()
        for key in arr:
            dic[key].sort()

            if key[1] not in seen:
                seen.add(key[1])
                output.append(dic[key])
            else:
                output[-1] += dic[key]
        
        return output
        
    
    def recurse(self, root, dic, r, c):
        if not root:
            return
        if (r,c) in dic:
            dic[(r,c)].append(root.val)
        else:
            dic[(r,c)] = [root.val]
        
        self.recurse(root.left, dic, r+1, c-1)
        self.recurse(root.right, dic, r+1, c+1)