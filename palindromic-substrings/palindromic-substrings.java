class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += expand(i, i, s);
            count += expand(i, i+1, s);
        }
        
        return count;
    }
    
    public int expand(int start, int end, String s) {
        int count = 0;
        
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        
        return count;
    }
}