class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bMax = new int[26];
        for (String b : B) {
            int[] bFreqs = count(b);
            for (int i = 0; i < 26; i++) {
                bMax[i] = Math.max(bMax[i], bFreqs[i]);
            }
        }
        
        List<String> output = new ArrayList<>();
        
        for (String a : A) {
            int[] aFreqs = count(a);

            if (valid(aFreqs, bMax)) {
                output.add(a);
            }
        }
        
        return output;
    }
    
    public int[] count(String s) {
        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqs[c - 'a']++;
        }
        return freqs;
    }
    
    
    public boolean valid(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}