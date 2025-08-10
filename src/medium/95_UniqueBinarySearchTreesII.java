class Solution {
  public List<TreeNode> generateTrees(int n) {
    return generateTrees((1 << n) - 1, n);
  }

  public List<TreeNode> generateTrees(int mask, int n) {
    if (mask == 0) {
      List<TreeNode> ret = new ArrayList<>();
      ret.add(null);
      return ret;
    }
    List<TreeNode> ret = new ArrayList<>();
    for (int root = 0; root < n; root++) {
      if ((mask & (1 << root)) > 0) {

        int leftMask = mask;
        int rightMask = mask;
        for (int i = 0; i < n; i++) {
          if (i >= root) {
            leftMask = leftMask & ~(1 << i);
          }
          if (i <= root) {
            rightMask = rightMask & ~(1 << i);
          }
        }

        List<TreeNode> leftTrees = generateTrees(leftMask, n);
        List<TreeNode> rightTrees = generateTrees(rightMask, n);

        for (TreeNode left : leftTrees) {
          for (TreeNode right : rightTrees) {
            TreeNode tree = new TreeNode();
            tree.val = root + 1;
            tree.left = left;
            tree.right = right;
            ret.add(tree);
          }
        }

      }
    }
    return ret;
  }
}
