class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<int[]> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length * 2; i++) {
            int idx = i % nums.length;
            while(!stack.isEmpty() && nums[idx] > stack.peek()[0]) {
                map.put(stack.pop()[1], nums[idx]);
            }
            stack.push(new int[]{nums[idx], idx});
        }
        
        int[] output = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            output[i] = map.getOrDefault(i, -1);
        }
        
        return output;
    }
}