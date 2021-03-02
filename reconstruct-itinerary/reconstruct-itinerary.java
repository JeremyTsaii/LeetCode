class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            List<String> locs = graph.getOrDefault(start, new ArrayList<String>());
            locs.add(end);
            graph.put(start, locs);
        }
        
        for (String key : graph.keySet()) {
            List<String> locs = graph.get(key);
            Collections.sort(locs);
        }
        List<String> path = new ArrayList<String>();
        path.add("JFK");
        return dfs(graph, path, tickets.size() + 1);
    }
    
    public List<String> dfs(Map<String,List<String>> graph, List<String> path, int n) {
        if (path.size() == n) {
            return path;
        }
        
        String start = path.get(path.size() - 1);
        List<String> neighbors = graph.getOrDefault(start, new ArrayList<String>());

        for (int i = 0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            if (neighbor != "") {
                neighbors.set(i, "");
                graph.put(start, neighbors);
                path.add(neighbor);
                
                List<String> pos = dfs(graph, path, n);
                if (pos.size() == n) {
                    return pos;
                }
                
                neighbors.set(i, neighbor);
                graph.put(start, neighbors);
                path.remove(path.size() - 1);
            }
        }
        
        return path;
    }
}