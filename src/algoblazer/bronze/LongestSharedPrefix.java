class Solution {
  public String longestSharedPrefix(String[] words) {
    int min_length = words[0].length();
    for (int i = 0; i < words.length; i++) {
      min_length = Math.min(min_length, words[i].length());
    }
    for (int k = 1; k <= min_length; k++) {

      boolean good = true;

      for (int i = 0; i < words.length; i++) {
        for (int j = 0; j < k; j++) {
          if (words[i].charAt(j) != words[0].charAt(j)) {
            good = false;
            break;
          }
        }
      }
      if (!good) {
        return words[0].substring(0, k - 1);
      }
    }
    return words[0].substring(0, min_length);
  }
}
