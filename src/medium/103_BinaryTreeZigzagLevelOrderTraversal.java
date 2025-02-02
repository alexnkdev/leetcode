/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new TreeMap<>();
        traverse(root, levels, 0);
        List<List<Integer>> ret = new ArrayList<>();
        for (Integer level : levels.keySet()) {
            if (level % 2 == 0) {
                ret.add(levels.get(level));
            } else {
                List<Integer> reversed = new ArrayList<>(levels.get(level));
                Collections.reverse(reversed);
                ret.add(reversed);
            }
        }
        return ret;
    }

    void traverse(TreeNode root, Map<Integer, List<Integer>> levels, int currentLevel) {
        if (root == null) {
            return;
        }
        List<Integer> nodes = levels.getOrDefault(currentLevel, new ArrayList<>());
        nodes.add(root.val);
        levels.put(currentLevel, nodes);
        traverse(root.left, levels, currentLevel + 1);
        traverse(root.right, levels, currentLevel + 1);
    }
}