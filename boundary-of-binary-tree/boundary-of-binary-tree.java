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
        List<Integer> output = new ArrayList<>();
        
        if (root != null) {
            output.add(root.val);
            traverse(root.left, output, true, false);
            traverse(root.right, output, false, true);
        }
        
        return output;
    }
    
    public void traverse(TreeNode root, List<Integer> arr, boolean left, boolean right) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arr.add(root.val);
            return;
        }
        
        if (left) {
            arr.add(root.val);
        }
        
        traverse(root.left, arr, root.left != null && left, root.right == null && right);
        traverse(root.right, arr, root.left == null && left, root.right != null && right);
        
        if (right) {
            arr.add(root.val);
        }
        
    }
}