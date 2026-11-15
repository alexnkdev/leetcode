class Solution {
  
  boolean[] used;

  public int[][] allSumCombinations(int[] values, int target) {
    used = new boolean[values.length];
    List<List<Integer>> combs = rec(values, 0, target);

    System.out.println(combs);
    return new int[][] {};
  }

  List<List<Integer>> rec(int[] values, int current, int target) {
    if (current == target) {
      List<List<Integer>> ret = new ArrayList<>();
      ret.add(new ArrayList<>());
      return ret;
    }
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < values.length; i++) {
      if (!used[i] && current + values[i] <= target) {
        List<List<Integer>> sub = rec(values, current + values[i], target);
        for (List<Integer> subSol : sub) {
          List<Integer> nn = new ArrayList<>();
          nn.add(values[i]);
          nn.addAll(subSol);
          ret.add(nn);
        }
      }
    }
    return ret;
  }
}
