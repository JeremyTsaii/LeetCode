class FreqStack {
    Map <Integer, Integer> freq;
    Map <Integer, Stack<Integer>> group;
    int maxFreq;
    
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxFreq) {
            maxFreq = f;
        }
        group.computeIfAbsent(f, z -> new Stack()).push(x);
    }
    
    public int pop() {
        int ret = group.get(maxFreq).pop();
        freq.put(ret, freq.get(ret) - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */