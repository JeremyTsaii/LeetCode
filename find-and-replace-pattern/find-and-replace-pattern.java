class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> output = new ArrayList<>();
        
        String pat = findPattern(pattern);

        for (String s : words) {
            if (isSame(s, pat)) {
                output.add(s);
            }
        }
        
        return output;
    }
    
    public boolean isSame(String s, String pat) {
        if (s.length() != pat.length()) {
            return false;
        }
        
        Map<Character,Character> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, (char) i);
            }
            if (map.get(c) != (pat.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public String findPattern(String s) {
        Map<Character,Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, (char) i);
            }
            sb.append(map.get(c));
        }
        
        return sb.toString();
    }
}