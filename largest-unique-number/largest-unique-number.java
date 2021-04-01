class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] buckets = new int[1001];
        int max = -1;
        int min = 1001;
        int zeros = 0;
        for (int n : A) {
            if (n == 0) {
                zeros += 1;
            }
            buckets[n] += n;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        for (int i = max; i >= min; i--) {
            if (buckets[i] == i) {
                if (i == 0) {
                    return zeros == 1 ? 0 : -1;
                } 
                return i;
            }
        }
        
        return -1;
    }
}