class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int k = digits.length - 1; k >= 0; k--) {
           int sum = digits[k] + carry;
           if (k == digits.length - 1) {
            sum += 1;
           }
           digits[k] = sum % 10;
           carry = sum / 10;
        }
        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                newDigits[i] = digits[i];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}