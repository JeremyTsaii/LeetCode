class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int max = 0;
        
        for (int i : nums) {
            if (!seen[i]) {
                int count = 1;
                int next = nums[i];
                seen[i] = true;
                
                while(next != i) {
                    seen[next] = true;
                    count++;
                    next = nums[next];
                }
                max = Math.max(count, max);
            }
        }
        
        return max;
    }
}