class Solution {
    public int missingNumber(int[] arr) {
        int diff = arr[1] - arr[0];
        int diff2 = diff * 2;
        int idx = 0;
        
        for (int i = 1; i < arr.length - 1; i++) {
            int d = arr[i+1] - arr[i];

            if (Math.abs(d) > Math.abs(diff)) {
                diff2 = arr[i+1] - arr[i];
                return arr[i] + diff;
            } else if (Math.abs(d) < Math.abs(diff)) {
                diff2 = diff;
                diff = d;
                return arr[0] + diff;
            }
        }
        
        return arr[0];
    }
}