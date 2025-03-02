class Solution {
    public boolean hasMatch(String s, String p) {
        for (int start = 0; start < s.length(); start++) {
            for (int starReplacement = 0; starReplacement < s.length(); starReplacement++) {
                if (isMatch(s, p, start, starReplacement)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isMatch(String s, String pattern, int from, int starCharCnt) {
        int patternLength = pattern.length() - 1 + starCharCnt;
        String actualPattern = new String(pattern);
        String replacement = String.valueOf("*").repeat(starCharCnt);
        actualPattern = actualPattern.replace("*", replacement);
        if (from + patternLength <= s.length()) {
            for (int i = 0; i < patternLength; i++) {
                char patternChar = actualPattern.charAt(i);
                char sChar = s.charAt(from + i);
                if (sChar != patternChar && patternChar != '*') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}