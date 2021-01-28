class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = k - (n - i - 1);
            if (val > 26) {
                val = 26;
            }
            k -= val;
            char c = (char) ('a' + (val - 1));
            output.append(c);
        }
        
        return output.reverse().toString();
    }
}