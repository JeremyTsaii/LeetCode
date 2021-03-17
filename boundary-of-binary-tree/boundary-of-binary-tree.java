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
    List<Integer> output = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return output;
        }
        
        output.add(root.val);
        
        leftBound(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBound(root.right);
        
        return output;
    }
    
    public void leftBound(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        output.add(root.val);
        if (root.left == null) {
            leftBound(root.right);
        } else {
            leftBound(root.left);
        }
    }
    
    public void rightBound(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            rightBound(root.left);
        } else {
            rightBound(root.right);
        }
        output.add(root.val);
    }
    
    public void leaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            output.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}