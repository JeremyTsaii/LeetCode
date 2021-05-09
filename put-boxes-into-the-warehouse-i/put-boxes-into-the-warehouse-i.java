class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int idx = boxes.length - 1;
        int count = 0;
        
        Arrays.sort(boxes);
        
        for (int w : warehouse) {
            while(idx >= 0 && boxes[idx] > w) {
                idx--;
            }
            
            if (idx == -1) {
                return count;
            }
            
            count++;
            idx--;
        }
        
        
        return count;
    }
}