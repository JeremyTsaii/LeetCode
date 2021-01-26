class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (a != b) {
                String s1 = s.substring(i);
                String s2 = s.substring(i+1);
                String t1 = t.substring(i);
                String t2 = t.substring(i+1);
                return s1.equals(t2) || t1.equals(s2) || s2.equals(t2);
            }
        }
        
        return !(s.length() == t.length());
    }
}
