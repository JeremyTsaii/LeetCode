class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
            
        Deque<int[]> pq = new ArrayDeque<>();
        Deque<int[]> aq = new ArrayDeque<>();
        
        for (int i = 0; i < matrix.length; i++) {
            pq.addLast(new int[]{i, 0});
            aq.addLast(new int[]{i, matrix[0].length-1});
        }
        for (int j = 0; j < matrix[0].length; j++) {
            pq.addLast(new int[]{0, j});
            aq.addLast(new int[]{matrix.length-1, j});
        }
        
        boolean[][] pr = bfs(matrix, pq);
        boolean[][] ar = bfs(matrix, aq);
        
        List<List<Integer>> output = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pr[i][j] && ar[i][j]) {
                    output.add(Arrays.asList(i, j));
                }
            }
        }
        
        return output;
    }

    public boolean[][] bfs(int[][] matrix, Deque<int[]> q) {
        boolean[][] reachable = new boolean[matrix.length][matrix[0].length];
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()) {
            int[] node = q.pollFirst();
            reachable[node[0]][node[1]] = true;
            
            for (int[] arr : dirs) {
                int xx = node[0] + arr[0];
                int yy = node[1] + arr[1];
                
                if (xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length && !reachable[xx][yy] && matrix[xx][yy] >= matrix[node[0]][node[1]]) {
                    q.addLast(new int[]{xx,yy});
                }
            }
        }
        
        return reachable;
    }
}