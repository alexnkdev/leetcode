class Solution {

  Map<Integer, Integer> freq = new HashMap<>();

  public int mostFrequentSubtreeSum(TreeNode root) {
    rec(root);
    Integer maxSum = null;
    for (Integer sum : freq.keySet()) {
      int f = freq.get(sum);
      if (maxSum == null || freq.get(maxSum) < f) {
        maxSum = sum;
      }
    }
    return maxSum;
  }

  int rec(TreeNode root) {
    int sum = 0;
    if (root.left == null && root.right == null) {
      sum = root.val;

    } else {
      sum = root.val;
      if (root.left != null) {
        sum += rec(root.left);
      }
      if (root.right != null) {
        sum += rec(root.right);
      }
    }
    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
  }

}
