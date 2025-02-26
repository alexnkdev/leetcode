class Solution {
    public String findValidPair(String s) {
       int[] freq = new int[10];
       for (int i = 0; i < s.length(); i++) {
          freq[s.charAt(i) - '0']++;
       }
       for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if (first != second && freq[first - '0']
            == (int) (first - '0') && freq[second - '0'] == (int)(second - '0')) {
                return "" + first + second;
            }
       }
        return "";
    }
}