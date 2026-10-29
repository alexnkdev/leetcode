class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int cnt = 0;
    int childIdx = 0;
    int cookieIdx = 0;
    while (cookieIdx < s.length && childIdx < g.length) {
      if (s[cookieIdx] >= g[childIdx]) {
        cookieIdx++;
        childIdx++;
        cnt++;
      } else {
        cookieIdx++;
      }
    }
    return cnt;
  }
}
