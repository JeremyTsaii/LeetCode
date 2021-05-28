class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int left = 0, right = 1;
        int max = nums[left], cur = nums[left];

        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[left], left);
        
        while(left < nums.length && right < nums.length) {
            if (map.containsKey(nums[right])) {
                int idx = map.get(nums[right]);
                while (left <= idx) {
                    map.remove(nums[left]);
                    cur -= nums[left];
                    left++;
                }
            }
            
            map.put(nums[right], right);
            cur += nums[right];
            max = Math.max(max, cur);
            right++;
        }
        
        return max;
    }
}