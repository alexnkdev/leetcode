class Solution {
    public String reverseOnlyLetters(String s) {
        String letters = "";
        for (int i = 0; i < s.length(); i++) {
            if (isLetter(s.charAt(i))) {
                letters += s.charAt(i);
            }
        }
        String ret = "";
        int letterCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isLetter(s.charAt(i))) {
                ret += letters.charAt(letters.length() - letterCnt - 1);
                letterCnt++;
            } else {
                ret += s.charAt(i);
            }
        }
        return ret;
    }

    boolean isLetter(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }
}