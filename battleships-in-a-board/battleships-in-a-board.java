class Solution {
    public int countBattleships(char[][] board) {
        
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int count = 0;
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'v') {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    
                    Stack<Pair<Integer,Integer>> stack = new Stack<>();
                    stack.push(new Pair<>(i, j));
                    board[i][j] = 'v';
                    count++;
                    
                    while(!stack.isEmpty()) {
                        Pair<Integer,Integer> pair = stack.pop();
                        int ii = pair.getKey();
                        int jj = pair.getValue();
                        
                        for (int[] dir : dirs) {
                            int di = dir[0];
                            int dj = dir[1];

                            int i2 = ii + di;
                            int j2 = jj + dj;

                            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length && board[i2][j2] == 'X') {
                                stack.push(new Pair<>(i2, j2));
                                board[i2][j2] = 'v';
                            }
                        }
                    }

                }
            }
        }
        
        return count;
    }
}