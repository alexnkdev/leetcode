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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToTree(nums, 0, nums.length);
    }

    public TreeNode convertToTree(int[] nums, int from, int to) {
        if (from >= to) {
            return null;
        }
        int mid = from + (to - from) / 2;
        TreeNode ret = new TreeNode();
        ret.val = nums[mid];
        ret.left = convertToTree(nums, from, mid);
        ret.right = convertToTree(nums, mid + 1, to);
        return ret;
    }

}