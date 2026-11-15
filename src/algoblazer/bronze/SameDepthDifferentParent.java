class Solution {
  public boolean sameDepthDifferentParent(TreeNode root, int x, int y) {
    int xDepth = findDepth(root, 0, x);
    int yDepth = findDepth(root, 0, y);
    if (xDepth == yDepth) {
      TreeNode xParent = findParent(root, null, x);
      TreeNode yParent = findParent(root, null, y);
      if (xParent != yParent) {
        return true;
      }
    }
    return false;
  }

  TreeNode findParent(TreeNode root, TreeNode parent, int x) {
    if (root == null) {
      return null;
    }
    if (root.val == x) {
      return parent;
    }
    TreeNode p = findParent(root.left, root, x);
    if (p == null) {
      p = findParent(root.right, root, x);
    }
    return p;
  }

  Integer findDepth(TreeNode root, int currentDepth, int target) {
    if (root == null) {
      return null;
    }
    if (root.val == target) {
      return currentDepth;
    }
    Integer ret = null;
    ret = findDepth(root.left, currentDepth + 1, target);
    if (ret == null) {
      ret = findDepth(root.right, currentDepth + 1, target);
    }
    return ret;
  }
}
