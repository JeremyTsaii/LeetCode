class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, 0, 4);
    }
    
    public List<List<Integer>> helper(int[] nums, int target, int start, int k) {
        List<List<Integer>> output = new ArrayList<>();
        
        if (nums.length == 0 || nums[0] * k > target || target > nums[nums.length - 1] * k) {
            return output;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> pos : helper(nums, target - nums[i], i + 1, k - 1)) {
                    output.add(new ArrayList<>(Arrays.asList(nums[i])));
                    output.get(output.size() - 1).addAll(pos);
                }
            }
        }
        
        return output;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> output = new ArrayList<>();
        
        int left = start, right = nums.length - 1;
        
        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target || (left > start && nums[left] == nums[left - 1]))
            left++;
        else if (sum > target || (right < nums.length - 1 && nums[right] == nums[right + 1]))
            right--;
        else
            output.add(Arrays.asList(nums[left++], nums[right--]));
            
        }
        
        return output;
    }
}