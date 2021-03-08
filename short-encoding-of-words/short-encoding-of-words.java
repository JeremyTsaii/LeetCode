class Solution {
    public int minimumLengthEncoding(String[] words) {        
        Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String first = words[i];
                String second = words[j];
                if (first.equals(second.substring(second.length()-first.length()))) {
                    words[i] = "";
                    break;
                }
            }
        }
        
        int len = 0;
        int num = 0;
        for (String s : words) {
            if (!s.isEmpty()) {
                len += s.length();
                num += 1;
            }
        }
        return num + len;
    }
}