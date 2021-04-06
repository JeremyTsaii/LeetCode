class Solution {
    public int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            output[i] = prev + nums[i];
            prev = output[i];
        }
        
        return output;
    }
}