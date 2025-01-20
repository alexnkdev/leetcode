package algorithms;

public class LongestSubstringWithAtLeastK {

	public int longestSubstring(String s, int k) {
		char[] counts = new char[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counts[c - 'a']++;
		}
		while (true) {
			Character rem = null;
			for (int i = 0; i < 26; i++) {
				if (counts[i] > 0 && counts[i] < k) {
					rem = (char)('a' + i);
					break;
				}
			}
			if (rem == null) {
				break;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithAtLeastK().longestSubstring("aaabb", 3));
	}

}
