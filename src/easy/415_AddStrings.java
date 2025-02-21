class Solution {
    public String addStrings(String num1, String num2) {
        int k = num1.length();
        k = Math.max(k, num2.length());
        int carry = 0;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char c1 = num1.length() - i - 1 >= 0 ? num1.charAt(num1.length() - i - 1) : '0';
            char c2 = num2.length() - i - 1 >= 0 ? num2.charAt(num2.length() - i - 1) : '0';
            int d1 = (int)(c1 - '0');
            int d2 = (int)(c2 - '0');
            int d = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            ret.append((char)(d + '0'));
        }
        if (carry != 0) {
            ret.append((char)(carry + '0'));
        }
        return ret.reverse().toString();
    }
}