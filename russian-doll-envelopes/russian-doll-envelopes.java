class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               if (a[0] == b[0]) {
                   return b[1] - a[1];
               }
               return a[0] - b[0];
           } 
        });
        
        int max = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        
        
        return max;
    }
}