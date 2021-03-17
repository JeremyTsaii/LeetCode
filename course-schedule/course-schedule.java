class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        return bfs.size() == numCourses;
    }
}