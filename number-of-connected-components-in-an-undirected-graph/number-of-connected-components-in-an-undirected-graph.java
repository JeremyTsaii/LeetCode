class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        boolean[] seen = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                count++;
                
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                seen[i] = true;
                
                while(!q.isEmpty()) {
                    int node = q.poll();
                    
                    for (int neighbor : adj[node]) {
                        if (!seen[neighbor]) {
                            seen[neighbor] = true;
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
        
        return count;
    }
}