class Solution {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else {
                int last = stack.pop();
                int keep = stack.pop();
                stack.push(keep + Math.max(2 * last, 1));
            }
            
        }
        
        return stack.pop();
    }
}