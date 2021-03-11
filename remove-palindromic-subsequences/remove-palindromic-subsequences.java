class Solution {
    public int removePalindromeSub(String s) {

        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            
            if (l != r) {
                return 2;
            }
            
            left++;
            right--;
        }
        
        return 1;
    }
}