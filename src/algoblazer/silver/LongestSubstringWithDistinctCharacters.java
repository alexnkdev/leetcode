class Solution {
  public int longestDistinctSubstring(String s) {
    int n = s.length();
    int i = 0;
    int j = 0;
    Set<Character> window = new HashSet<>();
    int max = 0;
    while (i <= j && j < s.length()) {
      char next = s.charAt(j);
      if (window.contains(next)) {
        window.remove(s.charAt(i));
        i++;
      } else {
        window.add(s.charAt(j));
        j++;
        max = Math.max(max, j - i);
      }
    }
    return max;
  }
}
