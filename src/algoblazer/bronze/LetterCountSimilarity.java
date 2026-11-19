class Solution {
  public String[] letterCountSimilarity(String[] s, String[] t) {
    String[] ret = new String[s.length];
    for (int i = 0; i < s.length; i++) {
      ret[i] = isSimilar(s[i], t[i]) ? "YES" : "NO";
    }
    return ret;
  }

  boolean isSimilar(String first, String second) {
    int[] freq_a = new int[26];
    int[] freq_b = new int[26];
    for (char c : first.toCharArray()) {
      freq_a[(int)(c - 'a')]++;
    }
    for (char c : second.toCharArray()) {
      freq_b[(int)(c - 'a')]++;
    }
    for (int i = 0; i < 26; i++) {
      int cnt_a = freq_a[i];
      int cnt_b = freq_b[i];
      if (Math.abs(cnt_a - cnt_b) > 3) {
        return false;
      }
    }
    return true;
  }

}
