class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> count = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.getLast()) {
                count.addLast(count.pollLast() + 1);
                
                
                if (count.peekLast() == k) {
                    count.pollLast();
                    stack.pollLast();
                }
            } else {
                stack.addLast(c);
                count.addLast(1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            char c = stack.pollFirst();
            int num = count.pollFirst();
            for (int i = 0; i < num; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}