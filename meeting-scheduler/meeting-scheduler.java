class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
        
        List<Integer> output = new ArrayList<>();
        
        int i1 = 0, i2 = 0;
        
        while(i1 < slots1.length && i2 < slots2.length) {
            int[] s1 = slots1[i1];
            int[] s2 = slots2[i2];
            
            int start = Math.max(s1[0], s2[0]);
            int end = Math.min(s1[1], s2[1]);
            int overlap = end - start;
            
            if (overlap >= duration) {
                output.add(start);
                output.add(start + duration);
                return output;
            } else if (s1[1] > s2[1]) {
                i2++;
            } else {
                i1++;
            }
        }
        
        return output;
    }
}