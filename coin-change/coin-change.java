class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    break;
                }
                
                int cur = 1 + dp[i - coins[j]];
                if (cur == Integer.MIN_VALUE) {
                    cur = Integer.MAX_VALUE;
                }
                dp[i] = Math.min(dp[i], cur);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}