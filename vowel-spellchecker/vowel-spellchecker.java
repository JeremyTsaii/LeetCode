class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] output = new String[queries.length];
        Set<String> words = new HashSet<>();
        Map<String,String> lowerWords = new HashMap<>();
        Map<String,String> noVowWords = new HashMap<>();
        
        for (String word : wordlist) {
            words.add(word);
            
            StringBuilder lower = new StringBuilder();
            StringBuilder noVow = new StringBuilder();
            char a = '1';
            
            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                lower.append(c);
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    noVow.append(c);
                } else {
                    noVow.append("#");
                }
            }
            
            String str1 = lower.toString();
            String str2 = noVow.toString();
            
            if (!lowerWords.containsKey(str1)) {
                lowerWords.put(str1, word);
            }
            if (!noVowWords.containsKey(str2)) {
                noVowWords.put(str2, word);
            }
            
        }
        
        for (int i = 0; i < queries.length; i++) {
            StringBuilder lower = new StringBuilder();
            StringBuilder noVow = new StringBuilder();
            
            for (int j = 0; j < queries[i].length(); j++) {
                char c = Character.toLowerCase(queries[i].charAt(j));
                lower.append(c);
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    noVow.append(c);
                } else {
                    noVow.append("#");
                }
            }
            
            String str1 = lower.toString();
            String str2 = noVow.toString();
            
            if (words.contains(queries[i])) {
                output[i] = queries[i];
            } else if (lowerWords.containsKey(str1.toString())) {
                output[i] = lowerWords.get(str1.toString());
            } else if (noVowWords.containsKey(str2.toString())) {
                output[i] = noVowWords.get(str2.toString());
            } else {
                output[i] = "";
            }
        }
        
        return output;
    }
}