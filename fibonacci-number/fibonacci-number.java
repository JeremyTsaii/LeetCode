class Solution {
    public int fib(int n) {
        int prev = 0, cur = 1;
        
        if (n == 0) {
            return 0;
        }
        
        while(n > 1) {
            int temp = prev + cur;
            prev = cur;
            cur = temp;
            n--;
        }
        
        return cur;
    }
}