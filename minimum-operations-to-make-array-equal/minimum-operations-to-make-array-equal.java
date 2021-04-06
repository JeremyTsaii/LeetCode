class Solution {
    public int minOperations(int n) {
        // Sum is n^2
        // Each element must become n^2 / n = n
        int div = n / 2;

        if (n % 2 == 0) {
            return div * div;
        }
        return div * (div + 1);
    }
}