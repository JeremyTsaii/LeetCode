class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int start = 0, end = -1;
        
        while (right >= 0) {
            if (nums[left] >= max) {
                max = nums[left];
            } else {
                end = left;
            }
            
            if (nums[right] <= min) {
                min = nums[right];
            } else {
                start = right;
            }
            
            left++;
            right--;
        }
        
        return end - start + 1;
    }
}