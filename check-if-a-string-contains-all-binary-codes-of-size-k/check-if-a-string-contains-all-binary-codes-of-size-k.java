class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < s.length() - k + 1; i++) {
            set.add(s.substring(i, i + k));
        }
        
        List<String> perms = permutations(k);
        
        for (String p : perms) {
            if (!set.contains(p)) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> permutations(int k) {
        List<String> output = new ArrayList<>();

        if (k == 1) {
            output.add("1");
            output.add("0");
            return output;
        }
        
        List<String> next = permutations(k - 1);
        
        for (String str : next) {
            output.add(str + "1");
            output.add(str + "0");
        }
        
        return output;
    }
}