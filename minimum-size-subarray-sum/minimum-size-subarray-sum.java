class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        
        int left = 0;
        int curSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while(curSum >= target) {
                minLen = Math.min(minLen, i - left + 1);
                curSum -= nums[left++];
            }
        }
        
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}