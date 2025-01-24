import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> ret = new HashSet<>();
        for (int mask = 0; mask < (1 << s.length()); mask++) {
            String ip = "";
            for (int pos = 0; pos < s.length(); pos++) {
                if ((mask & (1 << (pos))) != 0) {
                    ip += ".";
                }
                ip += s.charAt(pos);
            }
            if (isValid(ip)) {
                ret.add(ip);
            }
        }
        return new ArrayList<>(ret);
    }

    boolean isValid(String ip) {
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            if (token.length() == 0) {
                return false;
            }
            if (token.length() > 3) {
                return false;
            }
            Integer val = Integer.parseInt(token);
            if (val < 0 || val > 255) {
                return false;
            }
            if (token.startsWith("0") && !token.equals("0")) {
                return false;
            }
        }
        return true;
    }
}