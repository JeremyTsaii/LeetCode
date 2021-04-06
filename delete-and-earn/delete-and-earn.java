class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        
        for (int n : nums) {
            buckets[n] += n;
        }
        
        int skip = 0, take = 0;
        
        for (int i = 0; i < buckets.length; i++) {
            int take2 = buckets[i] + skip;
            int skip2 = Math.max(skip, take);
            
            take = take2;
            skip = skip2;
        }
        
        return Math.max(skip, take);
    }
}