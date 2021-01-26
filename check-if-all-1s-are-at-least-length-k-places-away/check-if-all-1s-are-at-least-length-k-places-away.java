class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int steps = 0;
        boolean found = false;
        
        for (int num : nums) {
            if (num == 1) {
                if (found && steps < k) {
                    return false;
                }
                found = true;
                steps = 0;
            } else {
                if (found) {
                    steps++;
                }
            }
        }
        
        return true;
    }
}
