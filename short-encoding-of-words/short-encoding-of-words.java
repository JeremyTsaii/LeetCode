class TrieNode {
    TrieNode[] children = new TrieNode[26];
    Boolean empty = true;
}

class Solution {
    public int minimumLengthEncoding(String[] words) {        
        TrieNode trie = new TrieNode();
        int count = 1;
        
        for (String word : words) {
            TrieNode cur = trie;
            Boolean newWord = false;
            
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.empty && !newWord) {
                     count -= word.length() - i;
                }
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                    newWord = true;
                    cur.empty = false;
                }
                cur = cur.children[c];
            }
            
            if (newWord) {
                count += word.length() + 1;
            }
        }
        
        return count;
    }
}