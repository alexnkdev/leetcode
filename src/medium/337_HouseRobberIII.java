class Solution {

  public Map<String, Integer> cache = new HashMap<>();

  public int rob(TreeNode root) {
    return Math.max(go(root, true), go(root, false));
  }

  public int go(TreeNode root, boolean take) {
    if (root == null) {
      return 0;
    }
    if (cache.containsKey(createKey(root, take))) {
      return cache.get(createKey(root, take));
    }
    int ret = 0;
    if (take) {
      ret += root.val;
    }

    int leftNoTake = go(root.left, false);
    int rightNoTake = go(root.right, false);
    
    if (take) {
      int left = leftNoTake;
      int right = rightNoTake;
      ret += left;
      ret += right;
    } else {
      int rightTake = go(root.right, true);
      int leftTake = go(root.left, true);
      int maxLeft = Math.max(leftNoTake, leftTake);
      int maxRight = Math.max(rightNoTake, rightTake);
      ret += maxLeft;
      ret += maxRight;
    }

    cache.put(createKey(root, take), ret);

    return ret;

  }

  public String createKey(TreeNode node, boolean take) {
    return node.hashCode() + "_" + Boolean.toString(take);
  }

}
