class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int min = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < nuts.length; i++) {
            int[] nut = nuts[i];
            int dist = calcDist(nut, tree);
            total += dist * 2;
            min = Math.max(min, dist - calcDist(nut, squirrel));
        }
        
        return total - min;
    }
    
    public int calcDist(int[] nut, int[] squirrel) {
        return Math.abs(nut[0]-squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
    }
}