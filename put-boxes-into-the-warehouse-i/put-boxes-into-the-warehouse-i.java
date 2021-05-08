class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int[] min = new int[warehouse.length];
        min[0] = warehouse[0];
        
        for (int i = 1; i < warehouse.length; i++) {
            min[i] = Math.min(warehouse[i], min[i-1]);
        }
        
        Arrays.sort(boxes);
        
        int idx = 0;
        int count = 0;
        
        for (int i = min.length - 1; i >= 0; i--) {
            if (idx >= boxes.length) {
                break;
            }
            if (min[i] >= boxes[idx]) {
                count++;
                idx++;
            }
        }
        
        
        return count;
    }
}