// Total: 5, 25, 125, 625, 3125, 15625 
// Valid: 5, 15, 35, 70, 126, 210
class Solution {
    public int countVowelStrings(int n) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] vowels = {"a", "e", "i", "o", "u"};
        for (String str : vowels) {
            map.put(str, 1);
        }
        
        for (int j = 1; j < n; j++) {
            int a = map.get("a");
            int e = map.get("e");
            int i = map.get("i");
            int o = map.get("o");
            int u = map.get("u");
            
            map.put("e", a + e);
            map.put("i", a + e + i);
            map.put("o", a + e + i + o);
            map.put("u", a + e + i + o + u);
        }
        
        int count = 0;
        for (String str : vowels) {
            count += map.get(str);
        }
        
        return count;
    }
}
