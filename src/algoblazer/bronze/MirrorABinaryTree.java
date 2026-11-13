class Solution {
  public TreeNode mirrorTree(TreeNode root) {

    return mirror(root);
  }

  public TreeNode mirror(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode newLeft = mirror(root.right);
    TreeNode newRight = mirror(root.left);
    root.left = newLeft;
    root.right = newRight;
    return root;
  }
}
