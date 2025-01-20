package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeRightSideView {

	Map<Integer, TreeNode> rightmost = new TreeMap<>();
	
	public List<Integer> rightSideView(TreeNode root) {
		go(root, 0);
		List<Integer> ret = new ArrayList<>();
		for (Integer key : rightmost.keySet()) {
			ret.add(rightmost.get(key).val);
		}
		return ret;
	}
	
	public void go(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (!rightmost.containsKey(level)) {
			rightmost.put(level, root);
		}
		go(root.right, level + 1);
		go(root.left, level + 1);
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
