class Solution {
    public boolean doesAliceWin(String s) {
      int cnt = 0;
      for (int i = 0; i < s.length(); i++) {
        if (isVowel(s.charAt(i))) {
            cnt++;
        }
      }  
      if (cnt == 0) {
        return false;
      }
      return true;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
