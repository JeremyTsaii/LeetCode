class Solution {
    public int[] constructArray(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n - k; i++) {
            arr.add(i);
        }
        
        for (int i = 0; i < k + 1; i++) {
            if (i % 2 == 0) {
                arr.add(n - k + i / 2);
            } else {
                arr.add(n - i / 2);
            }
        }
        
        int[] output = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            output[i] = arr.get(i);
        }
        return output;
    }
}