class Solution {
    public int shortestBridge(int[][] grid) {
        
        Queue<Pair<Pair<Integer,Integer>,Integer>> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        Pair<Integer,Integer> firstPair = firstCoord(grid);
        int i = firstPair.getKey();
        int j = firstPair.getValue();
        stack.push(new Pair<>(i, j));
        grid[i][j] = 2;
        q.offer(new Pair<>(new Pair<>(i, j), 0));

        while(!stack.isEmpty()) {
            Pair<Integer,Integer> pair = stack.pop();
            int ii = pair.getKey();
            int jj = pair.getValue();

            for (int[] dir : dirs) {
                int di = dir[0];
                int dj = dir[1];

                int i2 = ii + di;
                int j2 = jj + dj;

                if (i2 >= 0 && i2 < grid.length && j2 >= 0 && j2 < grid[0].length && grid[i2][j2] == 1) {
                    stack.push(new Pair<>(i2, j2));
                    grid[i2][j2] = 2;
                    q.offer(new Pair<>(new Pair<>(i2, j2), 0));

                }
            }
        }
        
        
        while(!q.isEmpty()) {
            Pair<Pair<Integer,Integer>,Integer> pair = q.poll();
            Pair<Integer,Integer> pair2 = pair.getKey();
            int steps = pair.getValue();
            int ii = pair2.getKey();
            int jj = pair2.getValue();
            
            
            for (int[] dir : dirs) {
                int di = dir[0];
                int dj = dir[1];
                
                int i2 = di + ii;
                int j2 = dj + jj;
                
                if (i2 >= 0 && i2 < grid.length && j2 >= 0 && j2 < grid[0].length) {
                    if (grid[i2][j2] == 0) {
                        q.offer(new Pair<>(new Pair<>(i2, j2), steps + 1));
                        grid[i2][j2] = 2;
                    } else if (grid[i2][j2] == 1) {
                        return steps;
                    }
                    
                }
            }
        }
        return 0;
    }
    
    public Pair<Integer,Integer> firstCoord(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return new Pair<>(i, j);
                }
            }
        }
        return new Pair<>(0,0);
    }
}