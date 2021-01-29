class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        
        for(int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    isConnected[i][j] = 0;
                    count++;
                    
                    ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
                    arr.add(j);
                    while (!arr.isEmpty()) {
                        int row = arr.pop();
                        
                        for (int k = 0; k < isConnected[0].length; k++) {
                            if (isConnected[row][k] == 1) {
                                isConnected[row][k] = 0;
                                arr.add(k);
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}