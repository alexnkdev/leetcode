package algorithms;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root.left != null) {
			ret.addAll(inorderTraversal(root.left));
		}
		ret.add(root.val);
		if (root.right != null) {
			ret.addAll(inorderTraversal(root.right));
		}
		return ret;
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
