package algorithms;

public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int ret = 0;
		for (char c = 'A'; c <= 'Z'; c++) {
			int cnt = 0;
			int left = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != c) {
					cnt++;
				}
				if (cnt > k) {
					while (left <= i && cnt > k) {
						if (s.charAt(left) != c) {
							cnt--;
						}
						left++;
					}
				}
				int len = i - left + 1;
				ret = Math.max(ret, len);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABBZZAZZZAZZZX", 4));
	}

}
