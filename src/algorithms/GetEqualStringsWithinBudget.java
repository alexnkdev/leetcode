package algorithms;

public class GetEqualStringsWithinBudget {

	public int equalSubstring(String first, String second, int maxCost) {
		int n = first.length();
		int currentCost = 0;
		int left = 0;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			currentCost += Math.abs(second.charAt(i) - first.charAt(i));
			if (currentCost > maxCost) {
				while (left <= i && currentCost > maxCost) {
					currentCost -= Math.abs(second.charAt(left) - first.charAt(left));
					left++;
				}
			}
			System.out.println(left + " " + i + " " + currentCost);
			ret = Math.max(ret, i - left + 1);
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new GetEqualStringsWithinBudget().equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
	}

}
