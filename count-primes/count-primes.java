class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        boolean[] nums = new boolean[n];
        for (int p = 2; p <= (int) Math.sqrt(n); p++) {
            if (!nums[p]) {
                for (int j = p * p; j < n; j += p) {
                    nums[j] = true;
                }
            }
        }
        
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                count++;
            }
        }
        
        return count;
    }
}