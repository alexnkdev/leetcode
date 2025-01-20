package algorithms;

public class AddHex {

	public static void main(String[] args) {
		System.out.println(addHex("2A", "2A"));
	}

	private static String addHex(String first, String second) {
		int k = first.length();
		if (second.length() > k) {
			k = second.length();
		}
		String ret = "";
		int carry = 0;
		for (int i = 0; i < k; i++) {
			char c1 = '0';
			if (i < first.length()) {
				c1 = first.charAt(first.length() - i - 1);
			}
			char c2 = '0';
			if (i < second.length()) {
				c2 = second.charAt(second.length() - i - 1);
			}
			int res = hexToDec(c1) + hexToDec(c2) + carry;
			char ch = decToHex(res % 16);
			ret = ch + ret;
			carry = res / 16;
		}
		if (carry != 0) {
			ret = "1" + ret;
		}
		return ret.toString();
	}

	private static char decToHex(int res) {
		if (res < 10) {
			return (char)('0' + res);
		} else {
			return (char)('A' + (res - 10));
		}
	}

	private static int hexToDec(char c) {
		if (c >= 'A' && c <= 'F') {
			return (int)(c - 'A') + 10;
		}
		return (int)(c - '0');
	}

}
