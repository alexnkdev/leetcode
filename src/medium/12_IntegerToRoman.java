class Solution {
  public String intToRoman(int num) {
    Map<String, Integer> symbols = Map.ofEntries(
        Map.entry("I", 1),
        Map.entry("V", 5),
        Map.entry("X", 10),
        Map.entry("L", 50),
        Map.entry("C", 100),
        Map.entry("D", 500),
        Map.entry("M", 1000),
        Map.entry("XL", 40),
        Map.entry("IX", 9),
        Map.entry("IV", 4),
        Map.entry("XC", 90),
        Map.entry("CD", 400),
        Map.entry("CM", 900));
    int currentValue = num;
    StringBuilder romanNumeral = new StringBuilder();
    while (currentValue != 0) {
      String maxSubtract = null;
      for (String symbol : symbols.keySet()) {
        int value = symbols.get(symbol);
        if (currentValue >= value && (maxSubtract == null || symbols.get(maxSubtract) < symbols.get(symbol))) {
          maxSubtract = symbol;
        }
      }
      currentValue -= symbols.get(maxSubtract);
      romanNumeral.append(maxSubtract);
    }
    return romanNumeral.toString();
  }
}
