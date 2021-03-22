class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
                if (map.get(mat[i][j]) == mat.length) {
                    min = Math.min(min, mat[i][j]);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}