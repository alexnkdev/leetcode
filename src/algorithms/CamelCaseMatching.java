package algorithms;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<String> patternCamels = findCamels(pattern);
		List<Boolean> ret = new ArrayList<>();
		for (String query : queries) {
			List<String> camels = findCamels(query);
			if (camels.size() == patternCamels.size() + 1) {
				if (Character.isUpperCase(camels.get(0).charAt(0))) {
					ret.add(Boolean.FALSE);
					continue;
				}else {
					camels = camels.subList(1, camels.size());
				}
			} else {
				System.out.println(camels);
				if (camels.size() != patternCamels.size()) {
					ret.add(Boolean.FALSE);
					continue;
				}
			}
			boolean ok = true;
			for (int i = 0; i < camels.size(); i++) {
				String queryCamel = camels.get(i);
				String patternCamel = patternCamels.get(i);
				if (!match(queryCamel, patternCamel)) {
					ok = false;
					break;
				}
			}
			ret.add(ok);
		}
		return ret;
	}
	
	private boolean match(String queryCamel, String patternCamel) {
		if (Character.isUpperCase(queryCamel.charAt(0)) && queryCamel.charAt(0) != patternCamel.charAt(0)) {
			return false;
		}
		if (Character.isUpperCase(queryCamel.charAt(0))) {
		queryCamel = queryCamel.substring(1);
		patternCamel = patternCamel.substring(1);
		}
		int pi = 0;
		int pj = 0;
		while (pi < patternCamel.length()) {
			while (pj < queryCamel.length() && queryCamel.charAt(pj) != patternCamel.charAt(pi)) {
				pj++;
			}
			if (pj == queryCamel.length()) {
				//System.out.println("SAD");
				return false;
			}
			pi++;
			pj++;
		}
		return pi == patternCamel.length();
	}

	private List<String> findCamels(String query) {
		List<String> ret = new ArrayList<>();
		String current = "";
		for (int i = 0; i <= query.length(); i++) {
			if (i == query.length() || Character.isUpperCase(query.charAt(i))) {
				if (current.length() > 0) {
					ret.add(current);
				}
				if (i < query.length()) {
					current = "" + query.charAt(i);
				}
			} else {
				current = current + query.charAt(i);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new CamelCaseMatching().camelMatch(new String[] { "uAxaqlzahfialcezsLfj" } , "AqlzahalcezsLfj"));
	}
	
}
