class Solution {
    public int myAtoi(String s) {
        String state = "start";
        int i = 0;
        boolean negative = false;
        String digits = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            if (state.equals("start")) {
                if (c != ' ') {
                    state = "sign";
                } else {
                    i++;
                }
            } else if (state.equals("sign")) {
                if (c == '-' || c == '+') {
                    negative = c == '-';
                    i++;
                    state = "leading";
                } else {
                    negative = false;
                    state = "leading";
                }
            } else if (state.equals("leading")) {
                if (c == '0') {
                    i++;
                } else {
                    state = "digits";
                }
            } else if (state.equals("digits")) {
                if (c >= '0' && c <= '9') {
                    digits += c;
                    i++;
                } else {
                    break;
                }
            }
        }
        if (digits.isEmpty()) {
            digits = "0";
        }
        if (negative && !(digits.equals("0"))) {
            digits = "-" + digits;
        }
        if (isGreaterThan(digits, "" + ((1 << 31) - 1))) {
            return (1 << 31) - 1;
        } else if (isLessThanIntMinValue(digits)) {
            return -(1 << 31);
        } else {
            return Integer.parseInt(digits);
        }
    }

    boolean isGreaterThan(String digits, String maxValue) {
        if (digits.charAt(0) == '-') {
            return false;
        }
        if (digits.length() < maxValue.length()) {
            return false;
        }
        if (digits.length() > maxValue.length()) {
            return true;
        }
        for (int i = 0; i < digits.length(); i++) {
            int c1 = (int) (digits.charAt(i) - '0');
            int c2 = (int) (maxValue.charAt(i) - '0');
            if (c1 < c2) {
                return false;
            }
            if (c1 > c2) {
                return true;
            }
        }
        return false;
    }

    boolean isLessThanIntMinValue(String digits) {
        String neg = negate(digits);
        return isGreaterThan(neg, "" + ((1 << 31) - 1));
    }

    String negate(String digits) {
        if (digits.startsWith("-")) {
            return digits.substring(1);
        } else {
            return "-" + digits;
        }
    }
}