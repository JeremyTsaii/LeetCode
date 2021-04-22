class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()];
        
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            int hourT = s.charAt(0) - '0';
            int hourO = s.charAt(1) - '0';
            int minT = s.charAt(3) - '0';
            int minO = s.charAt(4) - '0';
            
            mins[i] = hourT * 10 * 60 + hourO * 60 + minT * 10 + minO;
        }
        
        Arrays.sort(mins);
        
        int output = Math.min(mins[mins.length - 1] - mins[0], Math.abs(1440 - mins[mins.length - 1] + mins[0]));
        for (int i = 0; i < mins.length - 1; i++) {
            int diff = mins[i+1] - mins[i];
            output = Math.min(output, diff);
        }
        
        return output;
    }
}