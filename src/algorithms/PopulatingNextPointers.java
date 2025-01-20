package algorithms;

import java.util.ArrayList;
import java.util.List;

class Node {
	
	public int val;
	
	public Node left;
	
	public Node right;
	
	public Node next;

	public Node() {
		
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
	
	public String toString() {
		return val + "";
	}
};

public class PopulatingNextPointers {

	public Node connect(Node root) {
		System.out.println("Connect: " + root);
		if (root == null) {
			return null;
		}
		List<Node> rightSide = collectRightSide(root.right);
		connectLeft(root.left, rightSide);
		connect(root.right);
		return root;
	}

	private void connectLeft(Node root, List<Node> rightSide) {
		if (root == null) {
			return;
		}
		root.next = rightSide.isEmpty() ? null : rightSide.get(0);
		List<Node> rightSideNew = collectRightSide(root.right);
		if (!rightSide.isEmpty()) {
			rightSide.remove(0);
		}
		for (int i = rightSideNew.size(); i < rightSide.size(); i++) {
			rightSideNew.add(rightSide.get(i));
		}
		connectLeft(root.left, rightSideNew);
		connect(root.right);
	}

	private List<Node> collectRightSide(Node root) {
		Node current = root;
		List<Node> ret = new ArrayList<>();
		while (current != null) {
			ret.add(current);
			if (current.left != null) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Node root = new Node();
		root.val = 1;
		root.left = new Node();
		root.left.val = 2;
		root.left.left = new Node();
		root.left.left.val = 4;
		root.left.right = new Node();
		root.left.right.val = 5;
		root.right = new Node();
		root.right.val = 3;
		root.right.right = new Node();
		root.right.right.val = 7;
		root.right.left = new Node();
		root.right.left.val = 6;
		new PopulatingNextPointers().connect(root);
		System.out.println(root.left.right.next);
	}

}
