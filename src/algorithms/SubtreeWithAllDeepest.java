package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SubtreeWithAllDeepest {

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		int maxDepth = findMaxDepth(root);
		List<TreeNode> nodesWithMaxDepth = findNodesWithMaxDepth(root, maxDepth, 0);
		TreeNode ret = findDeepest(root, nodesWithMaxDepth);
		return null;
	}

	private TreeNode findDeepest(TreeNode root, List<TreeNode> nodesWithMaxDepth) {
		return null;
	}

	private List<TreeNode> findNodesWithMaxDepth(TreeNode root, int reqDepth, int depth) {
		if (root == null) {
			return new ArrayList<>();
		}
		if (depth == reqDepth) {
			List<TreeNode> ret = new ArrayList<>();
			ret.add(root);
			return ret;
		}
		List<TreeNode> ret = new ArrayList<>();
		ret.addAll(findNodesWithMaxDepth(root.left, reqDepth, depth + 1));
		ret.addAll(findNodesWithMaxDepth(root.right, reqDepth, depth + 1));
		return null;
	}

	private int findMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(findMaxDepth(root.left), findMaxDepth(root.right)) + 1;
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
