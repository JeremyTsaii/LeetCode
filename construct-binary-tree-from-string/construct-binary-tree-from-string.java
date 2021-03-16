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
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }
        
        int i = 0;
        while(i < s.length() && s.charAt(i) != '(') {
            i++;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, i)));
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        Set<TreeNode> hasLeft = new HashSet<>();
        
        while (i < s.length()) {
            char c = s.charAt(i);
            TreeNode node = stack.peekLast();
            
            if (c == ')') {
                stack.pollLast();
                i++;
            } else if (c == '(') {
                if (s.charAt(i+1) == ')') {
                    hasLeft.add(node);
                    i += 2;
                } else {
                    i++;
                }
                continue;
            } else {
                int j = i + 1;
                while(s.charAt(j) != '(' && s.charAt(j) != ')') {
                    j++;
                }
                TreeNode newNode = new TreeNode(Integer.parseInt(s.substring(i, j)));
                
                i = j;
                stack.addLast(newNode);
                if (hasLeft.contains(node)) {
                    node.right = newNode;
                } else {
                    node.left = newNode;
                    hasLeft.add(node);
                }
            }
            
        }
        
        return root;
    }
}