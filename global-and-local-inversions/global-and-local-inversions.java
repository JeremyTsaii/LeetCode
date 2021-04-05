class Solution {
    public boolean isIdealPermutation(int[] A) {
        int min = A.length;
        
        for (int i = A.length - 1; i > 1; i--) {
            min = Math.min(min, A[i]);
            if (A[i - 2] > min) {
                return false;
            }
        }
        
        return true;
    }
}