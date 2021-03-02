class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        
        int amount = 0;
        for (int i = 0; i < gas.length; i++) {
            amount += gas[i] - cost[i];
            
            if (amount < min) {
                minIdx = i;
                min = amount;
            }
        }
        
        return amount >= 0 ? (minIdx + 1) % gas.length : -1;
    }
}