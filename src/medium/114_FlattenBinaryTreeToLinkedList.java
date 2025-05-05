
class Solution {
  public void flatten(TreeNode root) {
    preorderTraversal(root);
  }

  TreeNode preorderTraversal(TreeNode root) {
    // returns TreeNode in form of LinkedList

    if (root == null) {
      return null;
    }

    TreeNode leftResult = preorderTraversal(root.left);
    // left is flattened to LinkedList

    TreeNode rightResult = preorderTraversal(root.right);
    // right is flattened to LinkedList

    // combine
    root.left = null;
    root.right = leftResult;

    if (leftResult == null) {
      root.right = rightResult;
      return root;
    }

    TreeNode rightMostFromLeft = leftResult;
    while (rightMostFromLeft.right != null) {
      rightMostFromLeft = rightMostFromLeft.right;
    }

    rightMostFromLeft.right = rightResult;

    return root;
  }
}
