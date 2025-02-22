class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int k = Math.abs(n);
        while (k != 1 && k % 2 == 0) {
            k /= 2;
        }
        if (k != 1) {
            return false;
        }
        return true;
    }
}