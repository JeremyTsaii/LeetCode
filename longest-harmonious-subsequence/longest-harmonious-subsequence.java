class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int max = 0;
        for (int num : nums) {
            int above = map.getOrDefault(num + 1, 0);
            int below = map.getOrDefault(num - 1, 0);
            int freq = map.get(num);
            
            max = Math.max(max, Math.max(above == 0 ? 0 : above + freq, below == 0 ? 0 : below + freq));
        }
        
        return max;
    }
}