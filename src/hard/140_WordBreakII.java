class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dictionary = new HashSet<>(wordDict);
    List<Integer>[] prev = new List[s.length() + 1];
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String sub = s.substring(j, i);
        if (dictionary.contains(sub) && dp[j]) {
          dp[i] = true;
          if (prev[i] == null) {
            prev[i] = new ArrayList<>();
          }
          prev[i].add(j);
        }
      }
    }
    if (!dp[s.length()]) {
      return Collections.emptyList();
    }
    List<List<String>> words = reconstruct(s, s.length(), dp, prev);
    Set<String> ret = new HashSet<>();
    for (List<String> w : words) {
      Collections.reverse(w);
      ret.add(String.join(" ", w));
    }
    return new ArrayList<>(ret);
  }

  public List<List<String>> reconstruct(String s, int k, boolean[] dp, List<Integer>[] prev) {
    if (k == 0) {
      List<List<String>> ret = new ArrayList<>();
      List<String> empty = new ArrayList<>();
      ret.add(empty);
      return ret;
    } else {
      List<List<String>> ret = new ArrayList<>();
      for (Integer p : prev[k]) {
        String sub = s.substring(p, k);
        List<List<String>> subSolutions = reconstruct(s, p, dp, prev);
        for (List<String> solution : subSolutions) {
          List<String> full = new ArrayList<>();
          full.add(sub);
          full.addAll(solution);
          ret.add(full);
        }
      }
      return ret;
    }
  }

}
