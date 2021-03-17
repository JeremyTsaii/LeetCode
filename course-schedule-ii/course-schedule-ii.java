class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> bfs = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                bfs.add(i);
            }
        }
        
        for(int i = 0; i < bfs.size(); i++) {
            for (int neighbor : graph[bfs.get(i)]) {
                if (--indegree[neighbor] == 0) {
                    bfs.add(neighbor);
                }
            }
        }
        if (bfs.size() == numCourses) {
            int[] output = new int[bfs.size()];
            for (int i = 0; i < bfs.size(); i++) {
                output[i] = bfs.get(i);
            }
            return output;
        }
        return new int[0];
    }
}