class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int left = 0, right = warehouse.length - 1;
        int count = 0; 
        Arrays.sort(boxes);
        
        for (int i = boxes.length - 1; i >= 0 && left <= right; i--) {
            if (boxes[i] <= warehouse[left]) {
                count++;
                left++;
            } else if (boxes[i] <= warehouse[right]) {
                count++;
                right--;
            }
        }
        
        return count;
    }
}