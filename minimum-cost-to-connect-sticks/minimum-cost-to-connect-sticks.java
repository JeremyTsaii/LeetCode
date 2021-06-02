class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int n : sticks) {
            pq.add(n);
        }
        
        int cost = 0;
        
        while(pq.size() > 1) {
            int cur = pq.poll() + pq.poll();
            cost += cur;
            pq.add(cur);
        }
        
        return cost;
    }
}