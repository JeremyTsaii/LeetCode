class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            int idx1 = map.getOrDefault(s.charAt(i), -1);
            int idx2 = map2.getOrDefault(t.charAt(i), -1);
            
            if (idx1 != idx2) {
                return false;
            }
            
            map.put(s.charAt(i), i);
            map2.put(t.charAt(i), i);
        }
        
        return true;
    }
}