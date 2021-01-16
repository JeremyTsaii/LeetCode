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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return recurse(root, 0, sum, map);
        
    }
    
    public int recurse(TreeNode root, int cur, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        cur += root.val;
        int count = map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        
        count += recurse(root.left, cur, target, map);
        count += recurse(root.right, cur, target, map);
        
        map.put(cur, map.get(cur) - 1);
        return count;
    }
}
