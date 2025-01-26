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
        List<TreeNode> left = new ArrayList<>();
        left.add(root.left);
        List<TreeNode> right = new ArrayList<>();
        right.add(root.right);
        while (true) {
            List<TreeNode> newLeft = new ArrayList<>();
            List<TreeNode> newRight = new ArrayList<>();
            boolean found = false;
            for (int i = 0; i < left.size(); i++) {
                TreeNode l = left.get(i);
                TreeNode r = right.get(right.size() - i - 1);
                if (l == null && r == null) {
                    continue;
                }
                if (l == null || r == null) {
                    return false;
                }
                if (l.val != r.val) {
                    return false;
                }
            }
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) != null) {
                    found = true;
                    newLeft.add(left.get(i).left);
                    newLeft.add(left.get(i).right);
                }
                if (right.get(i) != null) {
                    found = true;
                    newRight.add(right.get(i).left);
                    newRight.add(right.get(i).right);
                }
            }
            left = newLeft;
            right = newRight;
            if (!found) {
                break;
            }
        }
        return true;
    }
}