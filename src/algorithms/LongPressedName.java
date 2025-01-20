package algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongPressedName {

	public boolean isLongPressedName(String name, String typed) {
		List<Count> countsName = calc(name);
		List<Count> countsTyped = calc(typed);
		if (countsName.size() != countsTyped.size()) {
			return false;
		}
		for (int i = 0; i < countsName.size(); i++) {
			Count countName = countsName.get(i);
			Count countTyped = countsTyped.get(i);
			if (countTyped.c != countName.c) {
				return false;
			}
			if (countName.cnt > countTyped.cnt) {
				return false;
			}
		}
		return true;
	}
	
	private List<Count> calc(String name) {
		List<Count> ret = new ArrayList<>();
		int i = 0;
		while (i < name.length()) {
			char c = name.charAt(i);
			int j = i + 1;
			while (j < name.length() && name.charAt(j) == c) {
				j++;
			}
			Count cnt = new Count();
			cnt.c = c;
			cnt.cnt = j - i;
			ret.add(cnt);
			i = j;
		}
		return ret;
	}

	static class Count {
		char c;
		int cnt;
	}
	
}
