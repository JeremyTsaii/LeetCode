class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[] indegrees = new int[matrix.length * matrix[0].length];
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        List<Integer>[] adj = new ArrayList[matrix.length * matrix[0].length];
        
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int idx1 = i * matrix[0].length + j;
                for (int[] d : dirs) {
                    int i2 = d[0] + i;
                    int j2 = d[1] + j;
                    int idx2 = i2 * matrix[0].length + j2;
                    
                    if (i2 >= 0 && i2 < matrix.length && j2 >= 0 && j2 < matrix[0].length && matrix[i2][j2] > matrix[i][j]) {
                        indegrees[idx2]++;
                        adj[idx1].add(idx2);
                    }
                }
            }
        }
        
        
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                leaves.add(i);
            }
        }
        
        int count = 0;

        while(!leaves.isEmpty()) {
            count++;
            int len = leaves.size();
            
            for (int i = 0; i < len; i++) {
                int node = leaves.poll();
                for (int neighbor : adj[node]) {
                    if (--indegrees[neighbor] == 0) {
                        leaves.add(neighbor);
                    }
                }
            }
        }
        
        return count;
    }
}