class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    if (root.left == null || root.right == null) {
      return false;
    }

    Stack<Input> stack = new Stack<>();
    stack.push(new Input(root.left, root.right));
    while (!stack.isEmpty()) {
      Input top = stack.pop();
      if (top.tree1 == null && top.tree2 == null) {
        continue;
      }
      if (top.tree1 == null || top.tree2 == null) {
        return false;
      }
      if (top.tree1.val != top.tree2.val) {
        return false;
      }
      stack.push(new Input(top.tree1.left, top.tree2.right));
      stack.push(new Input(top.tree1.right, top.tree2.left));
    }

    return true;
  }

  boolean isSymmetrical(TreeNode tree1, TreeNode tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }
    if (tree1.val != tree2.val) {
      return false;
    }

    return isSymmetrical(tree1.left, tree2.right)
      && isSymmetrical(tree1.right, tree2.left);
  }

  class Input {
    TreeNode tree1;
    TreeNode tree2;
    public Input(TreeNode tree1, TreeNode tree2) {
      this.tree1 = tree1;
      this.tree2 = tree2;
    }
  }

}
