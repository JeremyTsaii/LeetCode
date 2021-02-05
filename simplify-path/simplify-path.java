class Solution {
    public String simplifyPath(String path) {
        String[] subs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String sub : subs) {
            if (!sub.equals("")) {
                if (sub.equals(".")) {
                    continue;
                } else if (sub.equals("..")) {
                    stack.pollLast();
                } else {
                    stack.addLast(sub);
                }
            }
        }
        
        return "/" + String.join("/", stack);
    }
}