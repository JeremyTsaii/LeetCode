class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int i = 0, j = 0;
        
        while (i < pushed.length && j < popped.length) {

            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                System.out.println(popped[j]);
                stack.pollLast();
                j++;
            } else {
                stack.addLast(pushed[i]);
                i++;
            }
        }

        while(!stack.isEmpty()) {
            if (stack.pollLast() == popped[j]) {
                j++;
            } else {
                return false;
            }
        }
        
        return true;
    }
}