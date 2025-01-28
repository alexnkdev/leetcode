class Solution {
    public String addBinary(String a, String b) {
        int l = Math.max(a.length(), b.length());
        String ret = "";
        int carry = 0;
        for (int k = 0; k < l; k++) {
            char c1 = k < a.length() ? a.charAt(a.length() - k - 1) : '0';
            char c2 = k < b.length() ? b.charAt(b.length() - k - 1) : '0';
            int v1 = c1 - '0';
            int v2 = c2 - '0';
            int sum = v1 + v2 + carry;
            carry = sum / 2;
            int digit = sum % 2;
            ret += (char) (digit + '0');
        }
        if (carry > 0) {
            ret += (char) ('1');
        }
        return new StringBuilder(ret).reverse().toString();
    }
}