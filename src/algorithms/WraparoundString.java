package algorithms;

import java.util.HashSet;
import java.util.Set;

public class WraparoundString {

	public int findSubstringInWraproundString(String p) {
		String wrap = "";
		for (char c = 'a'; c <= 'z'; c++) {
			wrap = wrap + c;
		}
		wrap = wrap + wrap + wrap;
		Set<String> ret = new HashSet<>();
		for (int i = 0; i < wrap.length(); i++) {
			for (int j = i + 1; j < wrap.length(); j++) {
				String sub = wrap.substring(i, j);
				if (p.contains(sub)) {
					ret.add(sub);
				}
			}
		}
		return ret.size();
	}

	public static void main(String[] args) {
		System.out.println(new WraparoundString().findSubstringInWraproundString("zab"));
	}
}
