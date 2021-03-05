class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean changed = true;

        while(changed) {
            changed = crush(board);
            gravity(board);
        }
        
        return board;
    }
    
    public void gravity(int[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            // Top points to first element needing relocation
            // Bot points to first open space
            int top = board.length - 1, bot = board.length - 1;
            while(top >= 0 && bot >= 0) {
                while(bot >= 0 && board[bot][col] != 0) {
                    bot--;
                }
                if (top >= bot) {
                    top = bot - 1;
                }
                while(top >= 0 && board[top][col] == 0) {
                    top--;
                }
                if (top >= 0 && bot >= 0) {
                    board[bot][col] = board[top][col];
                    board[top][col] = 0;
                    bot--;
                    top--;
                }
            }
        }
    }
    
    public boolean crush(int[][] board) {
        boolean changed = false;
        for (int i = 0; i < board.length; i++) {
            int j = 0;
            while (j < board[0].length - 2) {
                if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i][j+1]) && Math.abs(board[i][j]) == Math.abs(board[i][j+2])) {
                    changed = true;
                    board[i][j] = -Math.abs(board[i][j]);
                    board[i][j+1] = -Math.abs(board[i][j+1]);
                    board[i][j+2] = -Math.abs(board[i][j+2]);
                }
                j++;
            }
        }
        
        for (int j = 0; j < board[0].length; j++) {
            int i = 0;
            while (i < board.length - 2) {
                if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i+1][j]) && Math.abs(board[i][j]) == Math.abs(board[i+2][j])) {
                    changed = true;
                    board[i][j] = -Math.abs(board[i][j]);
                    board[i+1][j] = -Math.abs(board[i+1][j]);
                    board[i+2][j] = -Math.abs(board[i+2][j]);
                }
                i++;
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
        
        return changed;
    }
}