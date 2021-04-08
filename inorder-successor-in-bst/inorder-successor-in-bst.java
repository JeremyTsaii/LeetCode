/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> arr = new ArrayList<>();
        
        TreeNode cur = root;
        boolean found = false;
        
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            
            TreeNode node = stack.pop();
            if (found) {
                return node;
            }
            if (node == p) {
                found = true;
            }

            arr.add(node);
            if (node.right != null) {
                cur = node.right;
            }
        }

        
        
        return null;
    }
}