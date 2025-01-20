package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<>();
		for (int i = 1; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				for (int k = j + 1; k < s.length(); k++) {
					int firstLength = i;
					int secondLength = j - i;
					int thirdLength = k - j;
					int fourthLength = s.length() - k;
					if (firstLength >= 1 && firstLength <= 3
						&& secondLength >= 1 && secondLength <= 3
						&& thirdLength >= 1 && thirdLength <= 3
						&& fourthLength >= 1 && fourthLength <= 3) {
						Integer first = Integer.parseInt(s.substring(0, i));
						Integer second = Integer.parseInt(s.substring(i, j));
						Integer third = Integer.parseInt(s.substring(j, k));
						Integer fourth = Integer.parseInt(s.substring(k));
						if (first >= 0 && first <= 255 
								&& second >= 0 && second <= 255
								&& third >= 0 && third <= 255
								&& fourth >= 0 && fourth <=255) {
							ret.add(first + "." + second + "." + third + "." + fourth);
						}
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new RestoreIPAddresses().restoreIpAddresses("0000"));
	}

}
