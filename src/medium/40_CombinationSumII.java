
import java.util.ArrayList;

class Solution {

  static Set[][] cache;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    int n = candidates.length;
    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int t = 0; t <= target; t++) {
        dp[i][t] += dp[i - 1][t];
        if (t >= candidates[i - 1]) {
          dp[i][t] += dp[i - 1][t - candidates[i - 1]];
        }
      }
    }
    cache = new Set[n + 1][target + 1];
    Set<List<Integer>> ret = reconstruct(n, target, candidates, dp);
    return new ArrayList<>(ret);
  }

  Set<List<Integer>> reconstruct(int n, int target, int[] candidates, int[][] dp) {
    if (n == 0 && target == 0) {
      Set<List<Integer>> ret = new HashSet<>();
      ret.add(new ArrayList<>());
      return ret;
    }
    if (n == 0) {
      return new HashSet<>();
    }
    if (dp[n][target] == 0) {
      return new HashSet<>();
    }
    if (cache[n][target] != null) {
      return cache[n][target];
    }
    Set<List<Integer>> ret = new HashSet<>();
    ret.addAll(reconstruct(n - 1, target, candidates, dp));
    if (target >= candidates[n - 1]) {
      Set<List<Integer>> sub = reconstruct(n - 1, target - candidates[n - 1], candidates, dp);
      for (List<Integer> s : sub) {
        List<Integer> newList = new ArrayList<>(s);
        newList.add(candidates[n - 1]);
        Collections.sort(newList);
        ret.add(newList);
      }
    }
    cache[n][target] = ret;
    return ret;
  }

}
