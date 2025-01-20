package algorithms;

public class FindTheDifference {

	public char findTheDifference(String s, String t) {
		char[] cnt = new char[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'a']++;
		}
		char[] cnt2 = new char[26];
		for (char c : t.toCharArray()) {
			cnt2[c - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (cnt2[i] > cnt[i]) {
				return (char)('a' + i);
			}
		}
		return 'x';
	}

}
