class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            int sum = sumSquares(n);
            if (sum == 1) {
                break;
            }
            if (seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            n = sum;
        }
        return true;
    }

    int sumSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int r = n % 10;
            n /= 10;
            sum += r * r;
        }
        return sum;
    }
}