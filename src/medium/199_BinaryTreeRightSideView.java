class Solution {

  public Map<Integer, List<Integer>> levelsToNode = new HashMap<>();

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    dfs(root, 0);
    List<Integer> ret = new ArrayList<>();
    int maxLevel = 0;
    for (Integer key : levelsToNode.keySet()) {
      maxLevel = Math.max(key, maxLevel);
    }
    for (int i = 0; i <= maxLevel; i++) {
      ret.add(levelsToNode.get(i).get(levelsToNode.get(i).size() - 1));
    }
    return ret;
  }

  void dfs(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (!levelsToNode.containsKey(level)) {
      levelsToNode.put(level, new ArrayList<>());
    }
    levelsToNode.get(level).add(root.val);
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }
}
