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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
        } else {
            if (root.left != null) {
                List<String> subPaths = binaryTreePaths(root.left);
                for (String path : subPaths) {
                    paths.add(root.val + "->" + path);
                }
            }
            if (root.right != null) {
                List<String> subPaths = binaryTreePaths(root.right);
                for (String path : subPaths) {
                    paths.add(root.val + "->" + path);
                }
            }
        }
        return paths;
    }
}