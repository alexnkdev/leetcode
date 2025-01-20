package algorithms;

import java.util.List;

public class PathInZigZagTree {

	public List<Integer> pathInZigZagTree(int label) {
		int nodeCountInLevel = 1;
		int nodeCountTotal = 0;
		int level = 0;
		while (nodeCountTotal < label) {
			nodeCountInLevel = 2 * nodeCountInLevel;
			nodeCountTotal += nodeCountInLevel;
			level++;
		}
		System.out.println(level);
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new PathInZigZagTree().pathInZigZagTree(26));
	}

}
