class Solution {
  
  Map<TreeNode, Boolean> cache = new HashMap<>();

  public TreeNode pruneZeroSubtrees(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (isZero(root)) {
      return null;
    }
    root.left = pruneZeroSubtrees(root.left);
    root.right = pruneZeroSubtrees(root.right);
    return root;
  }

  boolean isZero(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.val != 0) {
      return false;
    }
    if (cache.containsKey(root)) {
      return cache.get(root);
    }
    boolean ret = isZero(root.left) && isZero(root.right);
    cache.put(root, ret);
    return ret;
  }
}
