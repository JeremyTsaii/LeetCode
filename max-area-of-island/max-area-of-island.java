class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                
                Queue<Pair<Integer,Integer>> q = new LinkedList<>();
                q.offer(new Pair<>(i, j));
                grid[i][j] = 0;
                int area = 1;
                
                while(!q.isEmpty()) {
                    Pair<Integer,Integer> cur = q.poll();
                    
                    for (int[] dir : directions) {
                        int ii = cur.getKey() + dir[0];
                        int jj = cur.getValue() + dir[1];

                        if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 1) {
                            area++;
                            grid[ii][jj] = 0;
                            q.offer(new Pair<>(ii, jj));
                        }
                    }
                }
                
                max = Math.max(max, area);
            }
        }
        
        
        return max;
    }
}