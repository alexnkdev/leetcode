package algorithms;

public class PermutationInString {

	public boolean checkInclusion(String small, String large) {
		int[] window = new int[26];
		int[] perm = new int[26];
		for (int i = 0; i < small.length(); i++) {
			perm[small.charAt(i) - 'a']++;
		}
		int left = 0;
		int cntMatch = 0;
		for (int i = 0; i < large.length(); i++) {
			char c = large.charAt(i);
			window[c - 'a']++;
			cntMatch++;
			if (window[c - 'a'] > perm[c - 'a']) {
				while (left <= i) {
					window[large.charAt(left) - 'a']--;
					cntMatch--;
					left++;
					if (isGood(window, perm)) {
						break;
					}
				}
			} else {
				if (cntMatch == small.length()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isGood(int[] window, int[] perm) {
		for (int i = 0; i < 26; i++) {
			if (window[i] > perm[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
	}

}
