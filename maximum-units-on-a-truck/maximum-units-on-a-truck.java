class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] buckets = new int[1001];
        
        int max = 0;
        for (int[] b : boxTypes) {
            buckets[b[1]] += b[0];
            max = Math.max(max, b[1]);
        }
        
        int sum = 0;
        while(truckSize != 0) {
            while(max >= 0 && buckets[max] == 0) {
                max--;
            }
            
            if (max == -1) {
                return sum;
            }
            
            sum += max;
            buckets[max]--;
            truckSize--;
        }
        
        return sum;
    }
}