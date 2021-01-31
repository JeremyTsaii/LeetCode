class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        boolean found = false;
        
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                idx = i-1;
                found = true;
                break;
            }
        }
        
        if (found) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[idx]) {
                    System.out.println(nums[i]);
                    System.out.println(nums[idx]);

                    replace(nums, i, idx);
                    break;
                }
            }
        }

        
        reverse(nums, idx+1, nums.length - 1);
    }
    
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            replace(nums, left, right);
            left++;
            right--;
        }
    }
    
    public void replace(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}