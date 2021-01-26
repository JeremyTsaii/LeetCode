class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> freq1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> freq2 = new HashMap<Character, Integer>();
​
        for (int i = 0; i < word1.length(); i++) {
            freq1.put(word1.charAt(i), freq1.getOrDefault(word1.charAt(i), 0) + 1);
            freq2.put(word2.charAt(i), freq2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        
        Set<Character> key1 = freq1.keySet();
        Set<Character> key2 = freq2.keySet();
        if (key1.size() != key2.size()) {
            return false;
        }
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int freq : freq1.values()) {
            set1.add(freq);
        }
        for (int freq : freq2.values()) {
            set2.add(freq);
        }
​
​
        return key1.equals(key2) && set1.equals(set2);
    }
}
