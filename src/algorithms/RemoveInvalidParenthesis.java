package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String input) {
        int n = 0;
        
        for (char x : input.toCharArray()) {
            if (x == '(' || x == ')') {
                n++;
            }
        }
        
        int min_removed = n;
        
        Map<Integer, Set<String>> ret = new HashMap<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder full = new StringBuilder();
            int removed = 0;
            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == ')') {
                    if ((mask & (1 << cnt)) > 0) {
                        full.append(c);
                    } else {
                        removed++;
                    }
                    cnt++;
                } else {
                    full.append(c);
                }
            }
            if (isCorrect(full.toString())) {
                if (ret.get(removed) == null) {
                    ret.put(removed, new HashSet<>());
                }
                ret.get(removed).add(full.toString());
                if (removed < min_removed) {
                    min_removed = removed;
                }
            }
        }
        return new ArrayList<>(ret.get(min_removed));
    }
    
    boolean isCorrect(String x) {
        int cnt = 0;
        for (char c : x.toCharArray()) {
            if (c != '(' && c != ')') {
                continue;
            }
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}