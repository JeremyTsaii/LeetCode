class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> map = new HashMap<>();
        int[] chars = new int[26];
        int size = 0;
        int maxCount = 0;
        int start = 0;
        
        // if (minSize > maxLetters) {
        //     return 0;
        // }
        
        for (int i = 0; i < s.length(); i++) {
            if (++chars[s.charAt(i) - 'a'] == 1) {
                size++;
            }
            
            if (i - start + 1 > minSize) {
                if (--chars[s.charAt(start) - 'a'] == 0) {
                    size--;
                }
                start++;
            }
            
            if (i - start + 1 == minSize && size <= maxLetters) {
                String sub = s.substring(start, i + 1);
                int count = map.getOrDefault(sub, 0);
                map.put(sub, count + 1);
                maxCount = Math.max(maxCount, count + 1);
            }
        }
        
        return maxCount;      
    }
}