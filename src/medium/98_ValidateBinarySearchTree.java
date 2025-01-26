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
    public boolean isValidBST(TreeNode root) {
        return isValidTree(root, null, null);
    }

    boolean isValidTree(TreeNode node, Integer minAllowedValue, Integer maxAllowedValue) {
        if (node == null) {
            return true;
        }
        if (minAllowedValue != null && node.val <= minAllowedValue) {
            return false;
        }
        if (maxAllowedValue != null && node.val >= maxAllowedValue) {
            return false;
        }
        return isValidTree(node.left, minAllowedValue, node.val)
            && isValidTree(node.right, node.val, maxAllowedValue);
    }
}