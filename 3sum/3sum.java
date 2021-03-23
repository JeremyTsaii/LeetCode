class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int val = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == val) {
                    List<Integer> add = new ArrayList<>();
                    add.add(nums[i]);
                    add.add(nums[left]);
                    add.add(nums[right]);
                    output.add(add);
                    
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < val) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return output;
    }
}