class Solution {
    
    public int totalNQueens(int n) {
        return backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    
    public int backtrack(int n, int curRow, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (curRow == n) {
            return 1;
        }
        
        int total = 0;
        
        for (int j = 0; j < n; j++) {
            if (!(cols.contains(j)) && !(diag1.contains(curRow + j)) && !(diag2.contains(curRow- j))) {
                cols.add(j);
                diag1.add(curRow + j); 
                diag2.add(curRow - j);
                
                total += backtrack(n, curRow + 1, cols, diag1, diag2);
                
                cols.remove(j);
                diag1.remove(curRow + j);
                diag2.remove(curRow - j);
            }
        }
        
        return total;
    }
}