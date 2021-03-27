class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nums.length * 2; i++) {
            int idx = i % nums.length;
            while(!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                output[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }
        
        
        
        return output;
    }
}