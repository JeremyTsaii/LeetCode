class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        
        int max = 0;
        
        for (List<Integer> row : wall) {
            int sum = 0;
            
            for (int j = 0; j < row.size() - 1; j++) {
                sum += row.get(j);
                int num = map.getOrDefault(sum, 0) + 1;
                map.put(sum, num);
                max = Math.max(max, num);
            }
        }

        return wall.size() - max;
    }
}