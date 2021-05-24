class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        int pow = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            num += (columnTitle.charAt(i) - 'A' + 1) * pow;
            pow *= 26;
        }
        
        return num;
    }
}