class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Long> map = new HashMap<>();
        map.put(arr[0], 1l);
        
        for (int i = 1; i < arr.length; i++) {
            long cur = 1;
            for (int n : map.keySet()) {
                if(arr[i] % n == 0 && map.containsKey(arr[i] / n)) {
                    cur += map.get(arr[i] / n) * map.get(n);
                }
            }
            map.put(arr[i], cur);
        }
        
        long sum = 0;
        for (long c : map.values()) {
            sum = (sum + c) % 1000000007;
        }
        
        return (int) sum;
    }
}