class Solution {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int dir = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1] && dir != -1) {
                dir = -1;
                count++;
            } else if (nums[i] > nums[i-1] && dir != 1) {
                dir = 1;
                count++;
            }
        }
        
        return count;
    }
}