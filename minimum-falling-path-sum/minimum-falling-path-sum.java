class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                int left = j - 1 >= 0 ? matrix[i+1][j-1] : Integer.MAX_VALUE;
                int bot = matrix[i+1][j];
                int right = j + 1 < matrix[i].length ? matrix[i+1][j+1] : Integer.MAX_VALUE;
                
                matrix[i][j] += Math.min(left, Math.min(bot, right));
            }
        }
        
        int min = matrix[0][0];
        for (int n : matrix[0]) {
            min = Math.min(n, min);
        }
        return min;
    }
}