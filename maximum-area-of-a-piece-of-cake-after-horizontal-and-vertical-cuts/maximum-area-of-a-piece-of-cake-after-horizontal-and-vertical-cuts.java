class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[] newH = new int[horizontalCuts.length + 2];
        int[] newV = new int[verticalCuts.length + 2];
        
        newH[1] = h;
        newV[1] = w;
        
        for (int i = 0; i < horizontalCuts.length; i++) {
            newH[i+2] = horizontalCuts[i];
        }
        for (int i = 0; i < verticalCuts.length; i++) {
            newV[i+2] = verticalCuts[i];
        }
        Arrays.sort(newH);
        Arrays.sort(newV);
        
        int largestH = 0;
        int largestW = 0;
        
        for (int i = 0; i < newH.length-1; i++) {
            largestH = Math.max(largestH, newH[i + 1] - newH[i]);
        }
        for (int i = 0; i < newV.length-1; i++) {
            largestW = Math.max(largestW, newV[i + 1] - newV[i]);
        }
        long ans = 1L * largestH * largestW % 1000000007;
        return (int) ans;
    }
}