class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int doubled = -1;
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) == 2) {
                doubled = n;
            }
            sum += n;
        }
        
        int[] output = new int[2];
        output[0] = doubled;
        output[1] = (nums.length * (nums.length+1)/2) - (sum - doubled);
        return output;
    }
}