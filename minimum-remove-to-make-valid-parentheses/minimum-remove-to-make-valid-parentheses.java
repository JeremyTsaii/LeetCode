class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = new char[s.length()];

        int len = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (count > 0) {
                    count--;
                    arr[len] = c;
                    len++;
                }
            } else {
                if (c == '(') {
                    count++;
                }
                arr[len] = c;
                len++;
            }
        }
                
        count = 0;
        int len2 = len - 1;
        char[] arr2 = new char[len];
        for (int i = len2; i >= 0; i--) {
            char c = arr[i];
            if (c == '(') {
                if (count > 0) {
                    count--;
                    arr2[len2] = c;
                    len2--;
                }
            } else {
                if (c == ')') {
                    count++;
                }
                arr2[len2] = c;
                len2--;
            }
        }
        
        return new String(Arrays.copyOfRange(arr2, len2 + 1, len));
    }
}