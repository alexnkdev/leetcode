class Solution {
  public int sumNumbers(TreeNode root) {
    int ret = 0;
    if (root == null) {
      return 0;
    }
    ret += sumNumbers(root.val, root);
    return ret;
  }

  int sumNumbers(int current, TreeNode root) {
    if (root.left == null && root.right == null) {
      return current;
    }
    int ret = 0;
    if (root.left != null) {
      ret += sumNumbers(current * 10 + root.left.val, root.left);
    }
    if (root.right != null) {
      ret += sumNumbers(current * 10 + root.right.val, root.right);
    }
    return ret;
  }
}
