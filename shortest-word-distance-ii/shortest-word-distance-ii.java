class WordDistance {
    Map<String,List<Integer>> map;
    
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> arr = map.getOrDefault(wordsDict[i], new ArrayList<>());
            arr.add(i);
            map.put(wordsDict[i], arr);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        
        List<Integer> arr1 = map.get(word1);
        List<Integer> arr2 = map.get(word2);
        
        for (int i : arr1) {
            for (int j : arr2) {
                min = Math.min(min, Math.abs(i - j));
                if (min == 1) {
                    return 1;
                }
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */