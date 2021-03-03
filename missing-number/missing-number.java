class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}