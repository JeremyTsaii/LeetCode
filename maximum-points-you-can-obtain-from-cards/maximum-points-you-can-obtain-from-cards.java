class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        
        int max = sum;
        
        for (int i = 0; i < k; i++) {
            sum += cardPoints[cardPoints.length - 1 - i] - cardPoints[k - 1 - i];
            max = Math.max(sum, max);
        }
        
        return max;
    }
}