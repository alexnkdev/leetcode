package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> allWords = new HashSet<>(wordDict);
		int n = s.length();
		boolean[][] good = new boolean[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				String sub = s.substring(i, j);
				good[i][j] = allWords.contains(sub);
			}
		}
		boolean[] ok = new boolean[s.length() + 1];
		ok[0] = true;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (good[j][i]) {
					ok[i] |= ok[j];
				}
			}
		}
		return ok[s.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(new WordBreak().wordBreak("leetcodecode", Arrays.asList("leet", "code")));
	}

}
