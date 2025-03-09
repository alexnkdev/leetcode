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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return List.of(List.of(root.val));
            } else {
                return new ArrayList<>();
            }
        }

        List<List<Integer>> ret = new ArrayList<>();

        if (root.left != null) {
            List<List<Integer>> subPaths = pathSum(root.left, targetSum - root.val);
            for (List<Integer> subPath : subPaths) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                path.addAll(subPath);
                ret.add(path);
            }
        }

        if (root.right != null) {
            List<List<Integer>> subPaths = pathSum(root.right, targetSum - root.val);
            for (List<Integer> subPath : subPaths) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                path.addAll(subPath);
                ret.add(path);
            }
        }

        return ret;

    }
}