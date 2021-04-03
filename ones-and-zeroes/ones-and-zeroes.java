class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str : strs) {
            Pair<Integer,Integer> counts = count(str);
            int c0 = counts.getKey();
            int c1 = counts.getValue();
            
            for (int i = m; i >= c0; i--) {
                for (int j = n; j >= c1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - c0][j-c1] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    public Pair<Integer,Integer> count(String str) {
        int c0 = 0;
        int c1 = 0;
        
        for (char c : str.toCharArray()) {
            if (c == '1') {
                c1++;
            } else {
                c0++;
            }
        }
        return new Pair<>(c0, c1);
    }
}