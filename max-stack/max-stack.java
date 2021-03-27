class MaxStack {
    PriorityQueue<Integer> pq;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        pq = new PriorityQueue<>((a, b) -> (b - a));
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }
    
    public int pop() {
        int num = stack.pop();
        pq.remove(num);
        return num;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
        int num = pq.poll();
        Stack<Integer> temp = new Stack<>();
        while(stack.peek() != num) {
            temp.push(stack.pop());
        }
        stack.pop();
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        
        return num;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */