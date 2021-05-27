class Solution {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        
        for(int i = 0; i < bits.length; i++) {
            bits[i] = getBits(words[i]);
        }
        
        int max = 0;
        
        for (int i = 0; i < bits.length; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
    
    private int getBits(String word) {
        int output = 0;
        
        for (int i = 0; i < word.length(); i++) {
            output |= 1 << (word.charAt(i) - 'a');
        }
        
        return output;
    }
}