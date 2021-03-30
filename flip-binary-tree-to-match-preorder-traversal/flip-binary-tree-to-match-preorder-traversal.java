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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 0;
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            if (node.val != voyage[i++]) {
                return Arrays.asList(-1);
            }
            
            if (node.left != null && node.left.val != voyage[i]) {
                output.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            } else {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        
        
        return output;
    }
}