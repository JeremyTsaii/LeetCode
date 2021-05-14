/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = new TreeNode();
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            prev.right = node;
            prev.left = null;
            prev = node;
            
            for (TreeNode neighbor : new TreeNode[]{node.right, node.left}) {
                if (neighbor != null) {
                    stack.push(neighbor);
                }
            }
            
            
        }
        
    }
}