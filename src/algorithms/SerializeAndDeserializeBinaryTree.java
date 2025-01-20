package algorithms;

public class SerializeAndDeserializeBinaryTree {

	private int current_pos;

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		return "[" + root.val + "][" + serialize(root.left) + "][" + serialize(root.right) + "]";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.isEmpty()) {
			return null;
		}
		current_pos = 0;
		return doDeserialize(data);
	}

	public TreeNode doDeserialize(String data) {
		if (data.charAt(current_pos) == ']') {
			current_pos += 1;
			return null;
		}
		// should start at [
		current_pos++;
		StringBuilder val = new StringBuilder();
		while (data.charAt(current_pos) != ']') {
			val.append(data.charAt(current_pos));
			current_pos++;
		}

		// now we are at ']'
		// skip ']'
		current_pos++;

		// now left subtree starts, we are at [
		current_pos++;
		TreeNode left = doDeserialize(data);
		// left subtree ends, we are at [
		current_pos++;

		TreeNode right = doDeserialize(data);

		// now we are at ']'
		current_pos++;
		TreeNode ret = new TreeNode();
		ret.left = left;
		ret.right = right;
		ret.val = Integer.parseInt(val.toString());
		return ret;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}

