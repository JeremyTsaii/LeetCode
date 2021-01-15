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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
​
        if (root == null) {
            return output;
        }
        
​
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            output.add(path);
            return output;
        }
        
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        for (int i = 0; i < left.size(); i++) {
            left.get(i).add(0, root.val);
            output.add(left.get(i));
        }
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for (int i = 0; i < right.size(); i++) {
            right.get(i).add(0, root.val);
            output.add(right.get(i));
        }
        
        return output;
    }
}
