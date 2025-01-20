package algorithms;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

	public int rob(TreeNode root) {
		return Math.max(rob(root, false), rob(root, true));
	}
	
	public int rob(TreeNode root, boolean canTakeRoot) {
		if (root == null) {
			return 0;
		}
		int leftFalse = rob(root.left, false);
		int rightFalse = rob(root.right, false);
		int leftTrue = rob(root.left, true);
		int rightTrue = rob(root.right, true);
		if (canTakeRoot) {
			int option1 = root.val + leftFalse + rightFalse;
			int option2 = leftTrue + rightTrue;
			int ans = Math.max(option1, option2);
			return ans;
		} else {
			int ans = leftTrue + rightTrue;
			return ans;
		}
	}


	public class Pair {
		TreeNode node;
		boolean canTakeRoot;
		public Pair(TreeNode node, boolean canTakeRoot) {
			this.node = node;
			this.canTakeRoot = canTakeRoot;
		}
		
		public boolean equals(Pair other) {
			return this.node.equals(other.node) && this.canTakeRoot == other.canTakeRoot;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (canTakeRoot ? 1231 : 1237);
			result = prime * result + ((node == null) ? 0 : node.hashCode());
			return result;
		}

	}
	public static void main(String[] args) {
		HouseRobberIII h = new HouseRobberIII();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(h.rob(root));
	}
	public  static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
