package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {


	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int n = wordList.size();
		boolean a[][] = new boolean[n][n];
		int fi = -1, ei = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && connected(wordList.get(i), wordList.get(j))) {
					a[i][j] = true;
				}
			}
			if (wordList.get(i).equals(beginWord)) {
				fi = i;
			}
			if (wordList.get(i).equals(endWord)) {
				ei = i;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(fi);
		int[] d = new int[n];
		boolean[] visited = new boolean[n];
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			for (int i = 0; i < n; i++) {
				if (a[cur][i] && !visited[i]) {
					d[i] = d[cur] + 1;
					visited[i] = true;
					q.add(i);
				}
			}
		}
        return d[fi];
    }
	
	private boolean connected(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				cnt++;
			}
		}
		return cnt == 1;
	}

	public static void main(String[] args) {
		
	}
	
}
