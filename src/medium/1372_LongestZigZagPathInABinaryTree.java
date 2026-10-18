class Solution {

  private Map<TreeNode, Integer> lcache = new HashMap<>();
  private Map<TreeNode, Integer> rcache = new HashMap<>();
  
  public int longestZigZag(TreeNode root) {
    int ret = Math.max(go(root, true), go(root, false));
    if (root.left != null) {
      ret = Math.max(ret, longestZigZag(root.left) + 1);
    }
    if (root.right != null) {
      ret = Math.max(ret, longestZigZag(root.right) + 1);
    }
    return ret - 1;
  }

  public int go(TreeNode current, boolean nextLeft) {
    if (current == null) {
      return 0;
    }
    if (nextLeft && lcache.get(current) != null) {
      return lcache.get(current);
    }
    if (!nextLeft && rcache.get(current) != null) {
      return rcache.get(current);
    }
    int ret = 1;
    if (nextLeft) {
      if (current.left != null) {
        ret += go(current.left, false);
      }
    } else {
      if (current.right != null) {
        ret += go(current.right, true);
      }
    }
    if (nextLeft) {
      lcache.put(current, ret);
    }
    if (!nextLeft) {
      rcache.put(current, ret);
    }
    return ret;
  }

}
