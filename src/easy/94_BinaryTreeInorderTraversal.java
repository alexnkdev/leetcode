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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        ret.addAll(left);
        ret.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        ret.addAll(right);
        return ret;
    }
}