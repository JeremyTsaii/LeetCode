class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (int[] a, int[] b) -> {
            int first = a[0] - b[0];
            if (first != 0) {
                return first;
            } else {
                return a[1] - b[1]; 
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        int i = 0;
        
        for (int day = 1; day <= 100000; day++) {
            while(i < events.length && events[i][0] == day) {
                pq.add(events[i++][1]);
            }
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                count++;
                pq.poll();
            }
        }
        
        return count;
    }
}