class Solution {
  public boolean areTreesIdentical(TreeNode root0, TreeNode root1) {
    if (root0 == null && root1 == null) {
      return true;
    }
    if (root0 == null || root1 == null) {
      return false;
    }
    if (root0.val != root1.val) {
      return false;
    }
    return areTreesIdentical(root0.left, root1.left) &&
      areTreesIdentical(root0.right, root1.right);
  }
}
