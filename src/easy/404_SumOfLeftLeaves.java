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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    int sumOfLeftLeaves(TreeNode current, boolean isLeftLeaf) {
        if (current == null) {
            return 0;
        }
        if (current.left == null && current.right == null && isLeftLeaf) {
            return current.val;
        }
        return sumOfLeftLeaves(current.left, true) + sumOfLeftLeaves(current.right, false);
    }
}