class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return generate(digits, 0);
    }

    public List<String> generate(String digits, int pos) {
        if (pos == digits.length()) {
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }
        char digit = digits.charAt(pos);
        char[][] options = new char[10][];
        options[2] = new char[] { 'a', 'b', 'c' };
        options[3] = new char[] { 'd', 'e', 'f' };
        options[4] = new char[] { 'g', 'h', 'i' };
        options[5] = new char[] { 'j', 'k', 'l' };
        options[6] = new char[] { 'm', 'n', 'o' };
        options[7] = new char[] { 'p', 'q', 'r', 's' };
        options[8] = new char[] { 't', 'u', 'v' };
        options[9] = new char[] { 'w', 'x', 'y', 'z' };
        List<String> sub = generate(digits, pos + 1);
        List<String> ret = new ArrayList<>();
        for (String other : sub) {
            for (char option : options[digit - '0']) {
                ret.add(option + other);
            }
        }
        return ret;
    }

}