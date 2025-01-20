package easy;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        List<Integer> digits = new ArrayList<>();
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            digits.add(digit);
        }
        for (int i = 0; i < digits.size() / 2; i++) {
            if (digits.get(i) != digits.get(digits.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}