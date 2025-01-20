package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class BinaryTreeVerticalOrderTraversal {

	List<Point> points;

	public List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		points = new ArrayList<>();
		rec(root, 0, 0);
		Collections.sort(points, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (p1.x == p2.x) {
					return Integer.compare(p1.y, p2.y);
				}
				return Integer.compare(p1.x, p2.x);
			}
		});

		Map<Integer, List<Point>> grouped = points.stream().collect(Collectors.groupingBy(Point::getX));

		return grouped.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
				.map(e -> e.getValue().stream().map(p -> p.val).collect(Collectors.toList()))
				.collect(Collectors.toList());
	}

	void rec(TreeNode root, int x, int y) {
		points.add(new Point(root.val, x, y));
		if (root.left != null) {
			rec(root.left, x - 1, y + 1);
		}
		if (root.right != null) {
			rec(root.right, x + 1, y + 1);
		}
	}

	class Point {
		int val;
		int x, y;

		public int getX() {
			return x;
		}

		public Point(int val, int x, int y) {
			this.val = val;
			this.x = x;
			this.y = y;
		}
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
}

