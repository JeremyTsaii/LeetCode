class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<>();
        
        backtrack(output, s, new StringBuilder(), 0, 0, 0);
        return output;
    }
    
    public void backtrack(List<String> output, String s, StringBuilder sb, int i, int curVal, int numDots) {
        if (numDots > 3 || curVal > 255) {
            return;
        } else if (sb.length() == s.length() + 3) {
            output.add(sb.toString());
            return;
        } else if (i >= s.length()) {
            return;
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '.') {
            sb.append('.');
            backtrack(output, s, sb, i, 0, numDots + 1);
            sb.setLength(sb.length() - 1);
        }

        if (!((sb.length() == 1 && sb.charAt(sb.length() - 1) == '0') || (sb.length() > 2 && sb.charAt(sb.length() - 1) == '0' && sb.charAt(sb.length() - 2) == '.'))) {
            sb.append(s.charAt(i));
            backtrack(output, s, sb, i + 1, curVal * 10 + s.charAt(i) - '0', numDots);
            sb.setLength(sb.length() - 1);
        }
    }
}