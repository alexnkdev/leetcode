package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SplitArrayIntoFibonacciSequence {

	public List<Integer> splitIntoFibonacci(String s) {
		for (int i = 1; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String first = s.substring(0, i);
				String second = s.substring(i, j);
				String last = s.substring(j);
				if (first.length() > 0 && second.length() > 0 && last.length() > 0
						&& first.length() <= 10 && second.length() <= 10
						) {
					if (isValidNumber(first) && isValidNumber(second)) {
						Long firstValue = Long.parseLong(first);
						Long secondValue = Long.parseLong(second);
						if (firstValue > Integer.MAX_VALUE || secondValue > Integer.MAX_VALUE) {
							continue;
						}
						List<Long> ret = new ArrayList<Long>();
						ret.add(firstValue);
						ret.add(secondValue);
						int currentPos = j;
						while (currentPos < s.length()) {
							Long next = firstValue + secondValue;
							if (next > Integer.MAX_VALUE) {
								break;
							}
							if (!s.startsWith(next.toString(), currentPos)) {
								break;
							}
							ret.add(next);
							currentPos += next.toString().length();
							firstValue = secondValue;
							secondValue = next;
						}
						if (currentPos == s.length()) {
							return ret.stream().map(b -> b.intValue()).collect(Collectors.toList());
						}
					}
				}
			}
		}
		return new ArrayList<Integer>();
	}

	private boolean isValidNumber(String first) {
		if (first.startsWith("0") && first.length() > 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new SplitArrayIntoFibonacciSequence().splitIntoFibonacci("100100200300"));
	}
}
