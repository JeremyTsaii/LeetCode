class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(map, words[i], words[i+1])) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isSorted(Map<Character,Integer> map, String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            int c1 = map.get(str1.charAt(i));
            int c2 = map.get(str2.charAt(i));
            
            if (c1 < c2) {
                return true;
            } else if (c1 == c2) {
                continue;
            } else {
                return false;
            }
        }
        
        return str1.length() <= str2.length();
    }
}