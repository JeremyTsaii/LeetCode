class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        int numDigits = 0;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                numDigits++;
            }
            
            result = ((result << numDigits) + i) % MOD;
        }
        
        return (int) result;
    }
}