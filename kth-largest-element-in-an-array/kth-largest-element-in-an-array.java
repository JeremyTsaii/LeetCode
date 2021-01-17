class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        
        int val = 0;
        for (int i = 0; i < k; i++) {
            val = maxHeap.remove();
        }
        
        return val;
    }
}
