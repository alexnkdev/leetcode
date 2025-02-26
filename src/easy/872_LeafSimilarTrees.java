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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = collectLeaves(root1);
        List<Integer> leaves2 = collectLeaves(root2);
        return leaves1.equals(leaves2);
    }

    public List<Integer> collectLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return List.of(root.val);
        }
        List<Integer> left = collectLeaves(root.left);
        List<Integer> right = collectLeaves(root.right);
        List<Integer> ret = new ArrayList<>();
        ret.addAll(left);
        ret.addAll(right);
        return ret;
    }
}