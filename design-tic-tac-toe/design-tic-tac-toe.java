class TicTacToe {
    int dim;
    int[][] rows;
    int[][] cols;
    int[][] diags;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        dim = n;
        rows = new int[2][n];
        cols = new int[2][n];
        diags = new int[2][2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int p = player - 1;
        // Insert into player's rows arr
        this.rows[p][row] += 1;
        
        // Insert into player's cols arr
        this.cols[p][col] += 1;
        
        // Insert into player's diag arr
        if (row == col) {
            this.diags[p][0] += 1;
        }
        if (row + col == this.dim - 1) {
            this.diags[p][1] += 1;
        }
            
        // Check for wins
        for (int count : this.rows[p]) {
            if (count == this.dim) {
                return player;
            }
        }
        for (int count : this.cols[p]) {
            if (count == this.dim) {
                return player;
            }
        }
        for (int count : this.diags[p]) {
            if (count == this.dim) {
                return player;
            }
        }
        
        return 0;
    }
}
​
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
