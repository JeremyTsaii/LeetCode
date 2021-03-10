class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        
        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            boolean sn = (l == '6' && r == '9') || (l == '9' && r == '6');
            boolean o = l == '1' && r == '1';
            boolean e = l == '8' && r == '8';
            boolean z = l == '0' && r == '0';
            
            if (!sn && !o && !e && !z) {
                return false;
            }
                
            left++;
            right--;
        }
        
        return true;
    }
}