class Solution {
    public int lengthLongestPath(String input) {
        int max = 0;
        
        String[] dirs = input.split("\n");
        int[] levels = new int[dirs.length];

        for (String s : dirs) {
            int i = 0;
            while (s.charAt(i) == '\t') {
                i++;
            }
            
            int prevScore = i != 0 ? levels[i-1] : 0;
            levels[i] = prevScore + (s.length() - i);
            
            if (s.contains(".")) {
                max = Math.max(max, levels[i]);
            } else {
                levels[i]++;
            }
        }
        
        return max;
    }
}