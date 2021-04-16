class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int n : data) {
            if (n == 1) {
                ones++;
            }
        }
        int min = data.length;
        int[] counts = new int[2];
        int right = 0;
        
        while(right < ones) {
            counts[data[right++]]++;
        }
        for (int left = 0; left < data.length - ones + 1; left++) {

            if (ones - counts[1] == counts[0]) {
                min = Math.min(min, counts[0]);
            }
            
            if (right < data.length) {
                counts[data[right++]]++;
                counts[data[left]]--; 
            }

        }
        
        
        return min;
    }
}