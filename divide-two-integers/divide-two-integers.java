class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int negs = 2;
        if (dividend > 0) {
            negs--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negs--;
            divisor = -divisor;
        }
        
        int ans = 0;
        while (divisor >= dividend) {
            int power = -1;
            int val = divisor;
            
            while (val >= (Integer.MIN_VALUE >> 1) && val + val >= dividend) {
                val += val;
                power += power;
            }
            
            ans += power;
            dividend -= val;
        }
        
        if (negs != 1) {
            ans = -ans;
        }
        
        return ans;
    }
}
