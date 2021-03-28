class Solution {
    public int minCost(String s, int[] cost) {
        int count = 0;
        int i = 0;
        
        while(i < s.length()) {
            int sum = cost[i];
            int max = cost[i];
            
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                sum += cost[i+1];
                max = Math.max(max, cost[i+1]);
                i++;
            }
            
            count += sum - max;
            i++;
        }
        
        return count;
    }
}