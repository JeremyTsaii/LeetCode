class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long count = 0l, mod = (long)1e9 + 7;
        Map<Integer,Long> dp = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1l);
            for (int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i]/arr[j], 0l)) % mod);
                }
            }
            count = (count + dp.get(arr[i])) % mod;
        }
        
        return (int) count;
    }
}