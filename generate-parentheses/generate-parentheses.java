class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        recurse(output, n, "", 0, 0);
        return output;
    }
    
    public void recurse(List<String> output, int n, String str, int open, int close) {
        if (str.length() == 2 * n) {
            output.add(str);
            return;
        }
        
        if (open < n) {
            recurse(output, n, str + "(", open+1, close);
        }
        
        if (close < open) {
            recurse(output, n, str + ")", open, close+1);
        }
    }
}