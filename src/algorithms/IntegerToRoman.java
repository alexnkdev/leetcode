package algorithms;

public class IntegerToRoman {
	
	int num;
	
	public String intToRoman(int num) {
		String ret = "";
		this.num = num;
		ret = ret + map("M", 1000);
		ret = ret + map("CM", 900);
		ret = ret + map("D", 500);
		ret = ret + map("CD", 400);
		ret = ret + map("C", 100);
		ret = ret + map("XC", 90);
		ret = ret + map("L", 50);
		ret = ret + map("XL", 40);
		ret = ret + map("X", 10);
		ret = ret + map("IX", 9);
		ret = ret + map("V", 5);
		ret = ret + map("IV", 4);
		ret = ret + map("I", 1);
		return ret;
	}

	private String map(String rep, int val) {
		int count = num / val;
		String ret = "";
		for (int i = 0; i < count; i++) {
			ret = ret + rep;
		}
		num = num - count * val;
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(4));
	}

}
