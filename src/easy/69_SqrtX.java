class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long low = 1;
        long high = x;
        while (low <= high) {
            long mid = (low + high) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) (low - 1);
    }
}