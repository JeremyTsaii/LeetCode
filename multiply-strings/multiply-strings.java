class Solution {
    public String multiply(String num1, String num2) {
        int[] prod = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                prod[i + j + 1] += d1 * d2;
            }
        }
        
        for (int i = prod.length - 1; i > 0; i--) {
            int carry = prod[i] / 10;
            prod[i] %= 10;
            prod[i-1] += carry;
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < prod.length && prod[idx] == 0) {
            idx++;
        }
        
        for (; idx < prod.length; idx++) {
            sb.append(prod[idx]);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
       
    }
}