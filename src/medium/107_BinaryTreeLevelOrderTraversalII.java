class Solution {

  Map<Integer, List<Integer>> levelToNodes = new HashMap<>();

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    go(root, 0);
    int maxLevel = 0;
    for (int key : levelToNodes.keySet()) {
      maxLevel = Math.max(maxLevel, key);
    }
    List<List<Integer>> levels = new ArrayList<>();
    for (int i = maxLevel; i >= 0; i--) {
      List<Integer> level = levelToNodes.get(i);
      levels.add(level);
    }
    return levels;
  }

  void go(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (!levelToNodes.containsKey(level)) {
      levelToNodes.put(level, new ArrayList<>());
    }
    levelToNodes.get(level).add(root.val);
    go(root.left, level + 1);
    go(root.right, level + 1);
  }
}
