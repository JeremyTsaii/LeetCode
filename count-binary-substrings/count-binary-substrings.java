class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            count += expand(s, i, i + 1);
        }
        
        return count;
    }
    
    public int expand(String s, int left, int right) {        
        if (s.charAt(left) == s.charAt(right)) {
            return 0;
        }
        
        int total = 1;
        
        while(left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(left) && s.charAt(right + 1) == s.charAt(right)) {
            left--;
            right++;
            total++;
        }
        
        return total;
    }
}