class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int c1 = 0;
        int c2 = 0;
        
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                c1++;
            }
            if (isVowel(s.charAt(n - 1 - i))) {
                c2++;
            }
        }
        
        return c1 == c2;
    }
    
    public boolean isVowel(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' || s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U';
    }
}