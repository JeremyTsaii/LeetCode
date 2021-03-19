class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        
        while(!q.isEmpty()) {
            int node = q.pollFirst();
            
            for (int neighbor : rooms.get(node)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    q.addLast(neighbor);
                }
            }
            
        }
        
        
        return seen.size() == rooms.size();
    }
}