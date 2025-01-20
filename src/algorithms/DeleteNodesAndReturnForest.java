package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toList());
		List<TreeNode> ret = deleteNodes(root, null, false, toDelete);
		if (!toDelete.contains(root.val)) {
			ret.add(root);
		}
		return ret;
	}

	private List<TreeNode> deleteNodes(TreeNode root, TreeNode prev, boolean isLeft, List<Integer> toDelete) {
		if (root == null) {
			return new ArrayList<TreeNode>();
		}
		if (toDelete.contains(root.val)) {
			if (prev != null) {
				if (isLeft) {
					prev.left = null;
				} else {
					prev.right = null;
				}
			}
			List<TreeNode> ret = new ArrayList<>();
			if (root.left != null && !toDelete.contains(root.left.val)) {
				ret.add(root.left);
			}
			if (root.right != null && !toDelete.contains(root.right.val)) {
				ret.add(root.right);
			}
			ret.addAll(deleteNodes(root.left, root, true, toDelete));
			ret.addAll(deleteNodes(root.left, root, true, toDelete));
			return ret;
		} else {
			List<TreeNode> ret = new ArrayList<>();
			ret.addAll(deleteNodes(root.left, root, true, toDelete));
			ret.addAll(deleteNodes(root.right, root, false, toDelete));
			return ret;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
