class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        
        for (int num : nums) {
            if (map.containsKey(k - num)) {
                count++;
                int cur = map.get(k - num);
                if (cur == 1) {
                    map.remove(k - num);
                } else {
                    map.put(k - num, cur - 1);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        return count;
    }
}
