/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max;
    
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        recurse(root);
        return max;
    }
    
    public int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = recurse(root.left);
        int right = recurse(root.right);
        int leftPath = 0;
        int rightPath = 0;
        
        if (root.left != null && root.left.val == root.val) {
            leftPath += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightPath += right + 1;
        }
        
        max = Math.max(max, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
