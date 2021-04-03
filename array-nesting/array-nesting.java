class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int max = 0;
        
        for (int i : nums) {
            if (!seen[i]) {
                int count = 0;
                int start = nums[i];
                boolean started = false;
                while(start != nums[i] || !started) {
                    started = true;
                    start = nums[start];
                    count++;
                    seen[start] = true;
                }
                max = Math.max(count, max);
            }
        }
        
        return max;
    }
}