/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> output = new ArrayList<Integer>();
        
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            
            Set<TreeNode> set1 = graph.getOrDefault(node, new HashSet());
            
            if (node.left != null) {
                q.addLast(node.left);
                Set<TreeNode> set2 = graph.getOrDefault(node.left, new HashSet());
                set1.add(node.left);
                set2.add(node);
                graph.put(node.left, set2);
            }

            if (node.right != null) {
                q.addLast(node.right);
                Set<TreeNode> set2 = graph.getOrDefault(node.right, new HashSet());
                set1.add(node.right);
                set2.add(node);
                graph.put(node.right, set2);
            }
            
            graph.put(node, set1);
        }
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        Deque<Integer> distances = new ArrayDeque<>();
        q.addLast(target);
        distances.addLast(K);
        
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            int dist = distances.pollFirst();
            
            if (dist == 0) {
                output.add(node.val);
            }
            
            Set<TreeNode> neighbors = graph.get(node);
            for (TreeNode neighbor : neighbors) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    q.addLast(neighbor);
                    distances.add(dist - 1);
                }
            }
        }
                
        return output;
    }
}