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
    int count;
    
    public int minCameraCover(TreeNode root) {
        count = 0;
        
        if (dfs(root) == 0) {
            count++;
        }
        
        return count;
    }
    
    public int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        

        if (left == 0 || right == 0) {
            count++;
            return 2;
        }
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }
}