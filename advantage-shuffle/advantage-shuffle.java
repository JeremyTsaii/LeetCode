class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] output = new int[A.length];
        
        Arrays.sort(A);
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < B.length; i++) {
            maxHeap.offer(new int[]{i, B[i]});
        }
        
        int left = 0, right = A.length - 1;
        while (!maxHeap.isEmpty()) {
            int[] b = maxHeap.poll();
            output[b[0]] = b[1] >= A[right] ? A[left++] : A[right--];
        }
        
        return output;
    }
}