class Solution {
  public String intToRoman(int num) {
    String digits = Integer.toString(num);
    Map<String, Integer> symbols = new HashMap<>();
    symbols.put("I", 1);
    symbols.put("V", 5);
    symbols.put("X", 10);
    symbols.put("L", 50);
    symbols.put("C", 100);
    symbols.put("D", 500);
    symbols.put("M", 1000);
    symbols.put("XL", 40);
    symbols.put("IX", 9);
    symbols.put("IV", 4);
    symbols.put("XC", 90);
    symbols.put("CD", 400);
    symbols.put("CM", 900);
    int currentValue = num;
    String ret = "";
    while (currentValue != 0) {
      String maxSubtract = null;
      for (String symbol : symbols.keySet()) {
        int value = symbols.get(symbol);
        if (currentValue >= value && (maxSubtract == null || symbols.get(maxSubtract) < symbols.get(symbol))) {
          maxSubtract = symbol;
        }
      }
      currentValue -= symbols.get(maxSubtract);
      ret += maxSubtract;
    }
    return ret;
  }
}
