package algorithms;

public class IsPatterned {

	public boolean isPatterned(String s) {
		for (int n = 1; n <= s.length() / 2; n++) {
			if ((s.length() / n) * n == s.length()) {
				String pattern = s.substring(0, n);
				boolean good = true;
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) != pattern.charAt(j % n)) {
						good = false;
					}
				}
				if (good) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new IsPatterned().isPatterned("abaabaabaaba"));
	}
}
