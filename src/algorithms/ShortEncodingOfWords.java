package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ShortEncodingOfWords {

	public int minimumLengthEncoding(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -Integer.compare(o1.length(), o2.length());
			}
		});
		boolean[] used = new boolean[words.length];
		int ret = 0;
		for (int i = 0; i < words.length; i++) {
			if (!used[i]) {
				used[i] = true;
				ret += words[i].length() + 1;
				for (int j = i + 1; j < words.length; j++) {
					if (!used[j] && words[i].endsWith(words[j])) {
						used[j] = true;
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(new String[] { "time", "me", "bell"}));
		// ["time", "me", "bell"];
		// time#bell#
	}

}
