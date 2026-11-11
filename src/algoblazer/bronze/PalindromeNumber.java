class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        List<Integer> digits = new ArrayList<>();
        while (x != 0) {
            digits.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < digits.size() / 2; i++) {
            if (digits.get(i) != digits.get(digits.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
