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
    int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        recurse(root);
        return count;
    }
    
    public int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            count += 1;
            return 1;
        }
        
        int left = recurse(root.left);
        int right = recurse(root.right);
        
        boolean leftValid = (root.left != null && root.val == root.left.val && left > 0) || (root.left == null);
        boolean rightValid = (root.right != null && root.val == root.right.val && right > 0) || (root.right == null);
        
        if (leftValid && rightValid) {
            count += 1;
            return 1;
        }
        return 0;
    }
}
