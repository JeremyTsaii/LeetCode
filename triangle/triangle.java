class Solution {
    Map<String,Integer> memo;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new HashMap<>();
        int maxRow = triangle.size() - 1;
        int maxCol = triangle.get(maxRow).size() - 1;
        return recurse(triangle, 0, 0, maxRow, maxCol);
    }
    
    public int recurse(List<List<Integer>> triangle, int row, int col, int maxRow, int maxCol) {
        if (row > maxRow || col > maxCol) {
            return 0;
        }
        String key = row + ":" + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int val = triangle.get(row).get(col) + Math.min(recurse(triangle, row + 1, col, maxRow, maxCol), recurse(triangle, row + 1, col + 1, maxRow, maxCol));
        memo.put(key, val);
        return val;
    }
}