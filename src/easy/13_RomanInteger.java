package easy;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> patterns = new HashMap<>();
        patterns.put("IV", 4);
        patterns.put("IX", 9);
        patterns.put("XL", 40);
        patterns.put("XC", 90);
        patterns.put("CD", 400);
        patterns.put("CM", 900);

        patterns.put("I", 1);
        patterns.put("V", 5);
        patterns.put("X", 10);
        patterns.put("L", 50);
        patterns.put("C", 100);
        patterns.put("D", 500);
        patterns.put("M", 1000);

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String twoStr = "" + s.charAt(i) + s.charAt(i + 1);
                if (patterns.containsKey(twoStr)) {
                    result += patterns.get(twoStr);
                    i += 2;
                    continue;
                }
            }
            if (patterns.containsKey("" + s.charAt(i))) {
                result += patterns.get("" + s.charAt(i));
                i++;
            }
        }
        return result;
    }
}