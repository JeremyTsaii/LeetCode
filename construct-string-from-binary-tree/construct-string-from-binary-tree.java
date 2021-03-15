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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        
        return recurse(t).toString();
    }
    
    public StringBuilder recurse(TreeNode t) {
        StringBuilder output = new StringBuilder();
        output.append(t.val);
     
        if (t.left == null && t.right != null) {
            output.append("()");
        }
        
        for (TreeNode child : new TreeNode[]{t.left, t.right}) {
            if (child != null) {
                output.append("(");
                output.append(recurse(child));
                output.append(")");
            } 
        }
        
        return output;
    }
}