class Solution {
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        Map<String, Integer> answers = new HashMap<>();
        
        int max = 1;
        int maxLen = 0;
        for (String word : words) {
            List<String> existing = map.getOrDefault(word.length(), new ArrayList<String>());
            existing.add(word);
            map.put(word.length(), existing);
            maxLen = Math.max(maxLen, word.length());
        }
                
        for (int i = 2; i <= maxLen; i++) {
            List<String> arr1 = map.getOrDefault(i, new ArrayList<String>());
            List<String> arr2 = map.getOrDefault(i-1, new ArrayList<String>());

            for (String w1 : arr1) {
                for (String w2 : arr2) {
                    if (diffByOne(w1, w2)) {
                        int prevScore = answers.getOrDefault(w2, 1);
                        int score1 = answers.getOrDefault(w1, 1);
                        answers.put(w1, Math.max(score1, prevScore + 1));
                        max = Math.max(max, prevScore + 1);
                    }
                }
            }
        }
        
        return max;
    }
    
    
    public boolean diffByOne(String s1, String s2) {
        int i = 0, j = 0;
        boolean used = false;

        while(i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (used) {
                    return false;
                } else {
                    used = true;
                    i++;
                }
            }
        }
        return true;
    }
}