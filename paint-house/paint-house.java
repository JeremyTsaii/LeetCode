class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        
        int minimum = min(costs[costs.length - 1]);
        
        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);

            minimum = Math.min(Math.min(costs[i][0], costs[i][1]), costs[i][2]);
        }
        
        return minimum;
    }
    
    public int min(int[] arr) {
        int output = Integer.MAX_VALUE;
        
        for (int i : arr) {
            output = Math.min(output, i);
        }
        
        return output;
    }
}