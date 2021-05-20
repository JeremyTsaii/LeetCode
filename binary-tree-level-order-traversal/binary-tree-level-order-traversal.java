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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                
                for (TreeNode child : new TreeNode[]{node.left, node.right}) {
                    if (child != null) {
                        q.offer(child);
                    }
                }
            }
            
            output.add(level);
        }
        
        return output;
    }
}