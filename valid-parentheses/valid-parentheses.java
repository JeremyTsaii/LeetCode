class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        
        Set<Character> opening = new HashSet<Character>();
        opening.add('(');
        opening.add('{');
        opening.add('[');
        
        Map<Character, Character> brackMap = new HashMap<Character, Character>();
        brackMap.put('(', ')');
        brackMap.put('[', ']');
        brackMap.put('{', '}');
        brackMap.put(')', '(');
        brackMap.put(']', '[');
        brackMap.put('}', '{');
​
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (opening.contains(cur)) {
                if (stack.size() != 0 && !opening.contains(stack.peekLast())) {
                    char end = stack.pop();
                    if (cur != brackMap.get(end)) {
                        return false;
                    }
                } else {
                    stack.add(cur);
                }
            } else {
                if (stack.size() == 0 || stack.pollLast() != brackMap.get(cur)) {
                    return false;
                }
            }
​
        }
        
        return stack.size() == 0;
    }
}
