package algorithms;

public class ValidateIPAddress {

	public static void main(String[] args) {
		String ret = new ValidateIPAddress().validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:733a");
		System.out.println(ret);
	}
	public String validIPAddress(String IP) {
		if (isValidIP4(IP)) {
			return "IPv4";
		} else if (isValidIPV6(IP)) {
			return "IPv6";
		} else {
			return "Neither";
		}
	}

	private boolean isValidIPV6(String ip) {
		String[] tokens = ip.split(":");
		if (ip.endsWith(":")) {
			return false;
		}
		if (tokens.length != 8) {
			return false;
		}
		for (String token : tokens) {
			if (token.length() < 1 || token.length() > 4) {
				return false;
			}
			if (token.startsWith("00") && !token.equals("0000") && !token.equals("000") && !token.equals("00")) {
				return false;
			}
			for (char c : token.toCharArray()) {
				if (!isValidCharacter(c)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidCharacter(char c) {
		c = Character.toLowerCase(c);
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f');
	}

	private boolean isValidIP4(String ip) {
		String[] tokens = ip.split("\\.");
		if (ip.endsWith(".")) {
			return false;
		}
		if (tokens.length != 4) {
			return false;
		}
		for (String token : tokens) {
			for (char c : token.toCharArray()) {
				if (!Character.isDigit(c)) {
					return false;
				}
			}
			if (token.length() < 1 || token.length() > 3) {
				return false;
			}
			if (token.startsWith("0") && token.length() > 1) {
				return false;
			}
			Integer val = Integer.parseInt(token);
			if (val > 255) {
				return false;
			}
		}
		return true;
	}
	
}
