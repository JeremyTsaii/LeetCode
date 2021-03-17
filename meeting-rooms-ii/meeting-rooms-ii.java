class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((int[] a, int[]b) -> a[1] - b[1]);
        
        Arrays.sort(intervals, (int[] a, int[]b) -> a[0] - b[0]);
        
        int rooms = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (!q.isEmpty() && q.peek()[1] <= intervals[i][0]) {
                q.poll();
            } else {
                rooms += 1;
            }
            q.add(intervals[i]);
        }
        
        return rooms;
    }
}