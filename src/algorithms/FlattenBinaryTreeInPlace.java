package algorithms;

public class FlattenBinaryTreeInPlace {

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.left);
		flatten(root.right);
		if (root.left == null) {

		} else if (root.right == null) {
			root.right = root.left;
			root.left = null;
		} else {
			TreeNode tmpRight = root.right;
			root.right = root.left;
			root.left = null;
			TreeNode lastRight = root;
			while (lastRight.right != null) {
				lastRight = lastRight.right;
			}
			lastRight.right = tmpRight;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		public String toString() {
			return "[" + val + "]";
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		new FlattenBinaryTreeInPlace().flatten(root);
	}

}
