class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        
        char[] chars = palindrome.toCharArray();
        boolean evenLen = palindrome.length() % 2 == 0;
        int mid = palindrome.length() / 2;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'a' && (i != mid || evenLen)) {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        
        chars[chars.length - 1] = 'b';
        
        return new String(chars);
    }
}