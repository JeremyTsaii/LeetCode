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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val, root, null);
            return newRoot;
        }
        
        List<TreeNode> nodes = getDepthNodes(root, depth-1);
        
        for (TreeNode n : nodes) {
            TreeNode oldLeft = n.left;
            TreeNode oldRight = n.right;
            TreeNode newLeft = new TreeNode(val, oldLeft, null);
            TreeNode newRight = new TreeNode(val, null, oldRight);
            n.left = newLeft;
            n.right = newRight;
        }
        
        return root;
    }
    
    private List<TreeNode> getDepthNodes(TreeNode root, int depth) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        List<TreeNode> output = new ArrayList<>();
        int d = 1;
        while(d <= depth) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();

                if (d == depth) {
                    output.add(node);
                }

                for (TreeNode child : new TreeNode[]{node.left, node.right}) {
                    if (child != null) {
                        q.addLast(child);
                    }
                }
            }
            d++;
        }
        
        return output;
    }
}