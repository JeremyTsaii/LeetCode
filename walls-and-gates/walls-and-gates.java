class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] coords = q.poll();
            
            for (int[] d : dirs) {
                int i = d[0] + coords[0];
                int j = d[1] + coords[1];
                
                if (i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length && rooms[i][j] == Integer.MAX_VALUE) {
                    rooms[i][j] = 1 + rooms[coords[0]][coords[1]];
                    q.add(new int[]{i,j});
                }
                
            }
        }
        
        
    }
}