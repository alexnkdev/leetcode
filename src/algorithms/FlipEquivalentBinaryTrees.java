package algorithms;

public class FlipEquivalentBinaryTrees {

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		return go(root1, root2);
	}
	
	boolean go(TreeNode node1, TreeNode node2) {
		if (node1.val != node2.val) {
			return false;
		}
		if (node1.left != null && node1.right != null) {
			if (node2.left == null || node2.right == null) {
				return false;
			}
			if (node1.left.val == node2.left.val && node1.right.val == node2.right.val) {
				return go(node1.left, node2.left) && go(node1.right, node2.right);
			}
			if (node1.left.val == node2.right.val && node1.right.val == node2.left.val) {
				return go(node1.left, node2.right) && go(node1.right, node2.left);
			}
			return false;
		} else if (node1.left != null) {
			if (node2.left == null && node2.right == null) {
				return false;
			}
			if (node2.left != null && node2.right != null) {
				return false;
			}
			TreeNode otherNode = node2.left != null ? node2.left : node2.right;
			if (node1.left.val == otherNode.val) {
				return go(node1.left, otherNode);
			} else {
				return false;
			}
		} else if (node1.right != null) {
			if (node2.left == null && node2.right == null) {
				return false;
			}
			if (node2.left != null && node2.right != null) {
				return false;
			}
			TreeNode otherNode = node2.left != null ? node2.left : node2.right;
			if (node1.right.val == otherNode.val) {
				return go(node1.right, otherNode);
			} else {
				return false;
			}
		} else {
			return node2.left == null && node2.right == null;
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
