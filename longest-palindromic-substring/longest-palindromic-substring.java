class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String pos1 = check(s, i, i);
            String pos2 = check(s, i, i+1);
​
            if (pos1.length() > res.length()) {
                res = pos1;
            }
            if (pos2.length() > res.length()) {
                res = pos2;
            }
        }
        return res;
    }
    
    public String check(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        return s.substring(start+1, end);
    }
}
