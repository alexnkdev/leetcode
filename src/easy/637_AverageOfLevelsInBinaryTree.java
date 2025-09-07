/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

  Map<Integer, List<TreeNode>> nodesAtLevel;
  int maxLevel = 0;

  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    nodesAtLevel = new HashMap<>();
    traverse(root, 0);
    List<Double> ret = new ArrayList<>();
    for (int i = 0; i <= maxLevel; i++) {
      List<TreeNode> nodes = nodesAtLevel.get(i);
      double sum = 0;
      for (TreeNode node : nodes) {
        sum += node.val;
      }
      ret.add(sum / nodes.size());
    }
    return ret;
  }

  void traverse(TreeNode root, int currentLevel) {
    if (root == null) {
      return;
    }
    maxLevel = Math.max(maxLevel, currentLevel);
    if (nodesAtLevel.get(currentLevel) == null) {
      nodesAtLevel.put(currentLevel, new ArrayList<>());
    }
    nodesAtLevel.get(currentLevel).add(root);
    traverse(root.left, currentLevel + 1);
    traverse(root.right, currentLevel + 1);
  }

}
