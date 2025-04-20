import java.util.ArrayList;

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int n = candidates.length;
    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int t = 0; t <= target; t++) {
        dp[i][t] += dp[i - 1][t];
        if (t >= candidates[i - 1]) {
          dp[i][t] += dp[i][t - candidates[i - 1]];
        }
      }
    }
    List<List<Integer>> ret = reconstruct(n, target, candidates, dp);
    return ret;
  }

  List<List<Integer>> reconstruct(int n, int target, int[] candidates, int[][] dp) {
    if (n == 0 && target == 0) {
      List<List<Integer>> ret = new ArrayList<>();
      ret.add(new ArrayList<>());
      return ret;
    }
    if (n == 0) {
      return new ArrayList<>();
    }
    if (dp[n][target] == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> ret = new ArrayList<>();
    ret.addAll(reconstruct(n - 1, target, candidates, dp));
    if (target >= candidates[n - 1]) {
      List<List<Integer>> sub = reconstruct(n, target - candidates[n - 1], candidates, dp);
      for (List<Integer> s : sub) {
        s.add(candidates[n - 1]);
      }
      ret.addAll(sub);
    }
    return ret;
  }

}
