class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        
        for (int[] point : points) {
            xMin = Math.min(xMin, point[0]);
            xMax = Math.max(xMax, point[0]);
            String s = point[0] + "," + point[1];
            set.add(s);
        }
        
        int sum = xMin + xMax;
        
        for (int[] point : points) {
            String key = (sum - point[0]) + "," + point[1];
            if (!set.contains(key)) {
                return false;
            }
        }
        
        return true;
    }
}