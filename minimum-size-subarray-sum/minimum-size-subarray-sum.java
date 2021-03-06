class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        boolean found = false;
        
        int left = 0, right = 0;
        int curSum = 0;
        
        while (left < nums.length && right < nums.length) {
            curSum += nums[right];
            if (curSum >= target) {
                found = true;
                minLen = Math.min(minLen, right - left + 1);
                curSum -= nums[left];
                curSum -= nums[right];
                left++;
                
                if (right < left) {
                    right = left;
                }
            } else {
                right++;
            }
        }
        
        if (!found) {
            return 0;
        }
        return minLen;
    }
}