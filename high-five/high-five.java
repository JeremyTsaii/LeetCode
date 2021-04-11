class Solution {
    public int[][] highFive(int[][] items) {
        List<Integer>[] scores = new ArrayList[1001];
        
        int count = 0;
        for (int[] item : items) {
            if (scores[item[0]] == null) {
                count++;
                scores[item[0]] = new ArrayList<>();
            }
            scores[item[0]].add(item[1]);
        }
        
        int[][] output = new int[count][2];
        
        int idx = 0;
        for (int i = 0; i < output.length; i++) {
            while(scores[idx] == null) {
                idx++;
            }
            
            Collections.sort(scores[idx]);
            
            int sum = 0;
            int size = scores[idx].size();
            for (int j = 0; j < 5; j++) {
                sum += scores[idx].get(size - 1 - j);
            }
            output[i] = new int[]{idx, sum / 5};
            idx++;
        }
        
        return output;
    }
}