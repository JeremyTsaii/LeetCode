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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        
        int total = 0;
        long sum = 0;
        
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        Deque<Integer> levels = new ArrayDeque<>();
        q.addLast(root);
        levels.addLast(0);
          
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            int level = levels.pollFirst();

            
            if (level > output.size()) {
                output.add(1.0 * sum / total);
                total = 0;
                sum = 0;
            }
            
            sum += node.val;
            total++;
            
            for (TreeNode child : new TreeNode[]{node.left, node.right}) {
                if (child != null) {
                    q.addLast(child);
                    levels.addLast(level + 1);
                }
            }
            
        }
        output.add(1.0 * sum / total);
            
        return output;
    }
}