class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegrees = new int[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int[] r : relations) {
            indegrees[r[1]]++;
            
            if (graph[r[0]] == null) {
                graph[r[0]] = new ArrayList<>();
            }
            graph[r[0]].add(r[1]);
        }
                
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegrees.length; i++) {
            if (i > 0 && indegrees[i] == 0) {
                q.add(i);
            }
        }
        
        int seen = 0;
        int rounds = 0;
        
        while(!q.isEmpty()) {
            int len = q.size();
            rounds++;
            
            for (int i = 0; i < len; i++) {
                int node = q.poll();
                seen++;
                List<Integer> neighbors = graph[node];
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (--indegrees[neighbor] == 0) {
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
        
        return seen == n ? rounds : -1;
    }
}