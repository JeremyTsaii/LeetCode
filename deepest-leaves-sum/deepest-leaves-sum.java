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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int len = q.size();
            sum = 0;            
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    sum += node.val;
                }
                
                for (TreeNode neighbor : new TreeNode[]{node.left, node.right}) {
                    if (neighbor != null) {
                        q.add(neighbor);
                    }
                }
            }
            
        }
        
        return sum;
    }
}