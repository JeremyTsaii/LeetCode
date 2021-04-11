class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,List<Integer>> map = new HashMap<>();
        Map<Character,List<Integer>> map2 = new HashMap<>();

        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> existing = map.getOrDefault(c, new ArrayList<>());
            existing.add(i);
            map.put(c, existing);
            
            char c2 = t.charAt(i);
            List<Integer> existing2 = map2.getOrDefault(c2, new ArrayList<>());
            existing2.add(i);
            map2.put(c2, existing2);
        }
        
        return check(map, t) && check(map2, s);        

    }
    
    public boolean check(Map<Character,List<Integer>> map, String s) {
        for (List<Integer> arr : map.values()) {
            if (arr.size() > 1) {
                char anchor = s.charAt(arr.get(0));
                for (int i = 1; i < arr.size(); i++) {
                    if (s.charAt(arr.get(i)) != anchor) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}