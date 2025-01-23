class Solution {
    public int lengthOfLastWord(String s) {
        int i = 0;
        s = s.trim();
        String lastWord = "";
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            String word = "";
            while (i < s.length() && s.charAt(i) != ' ') {
                word += s.charAt(i);
                i++;
            }
            lastWord = word;
        }
        return lastWord.length();
    }
}