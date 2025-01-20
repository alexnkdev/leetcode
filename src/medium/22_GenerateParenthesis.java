import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(gen(n * 2));
    }

    public Set<String> gen(int n) {
        Set<String> ret = new HashSet<>();
        if (n % 2 != 0) {
            return new HashSet<>();
        }
        if (n == 0) {
            return new HashSet<>(Arrays.asList(""));
        }
        Set<String> sub = gen(n - 2);
        for (String s : sub) {
            ret.add("(" + s + ")");
        }
        for (int leftLen = 2; leftLen <= n - 2; leftLen += 2) {
            int rightLen = n - leftLen;
            Set<String> left = gen(leftLen);
            Set<String> right = gen(rightLen);
            for (String l : left) {
                for (String r: right) {
                    ret.add(l + r);
                }
            }
        }
        return ret;
    }
}