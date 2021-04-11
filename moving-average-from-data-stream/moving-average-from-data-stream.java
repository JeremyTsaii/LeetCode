class MovingAverage {
    
    Queue<Integer> q;
    int s;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        s = size;
        sum = 0;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        if (q.size() == s) {
            sum -= q.poll();
        }
        q.add(val);
        return (double) sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */