class Solution {
  public boolean isAnagram(String s, String t) {
    int[] freq_s = makeFreq(s);
    int[] freq_t = makeFreq(t);
    for (int i = 0; i < 26; i++) {
      if (freq_s[i] != freq_t[i]) {
        return false;
      }
    }
    return true;
  }

  public int[] makeFreq(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
      freq[(int)(c - 'a')]++;
    }
    return freq;
  }
}
