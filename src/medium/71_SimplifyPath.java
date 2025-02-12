class Solution {
    public String simplifyPath(String path) {
        List<String> tokens = parse(path);
        tokens = simplify(tokens);
        return format(tokens);
    }

    public List<String> simplify(List<String> tokens) {
        Stack<String> fullDir = new Stack<>();
        for (String token : tokens) {
            if (token.equals("..")) {
                if (!fullDir.isEmpty()) {
                    fullDir.pop();
                }
            } else {
                if (!token.equals(".")) {
                    fullDir.push(token);
                }
            }
        }
        if (fullDir.isEmpty()) {
            fullDir.push("");
        }
        return new ArrayList<>(fullDir);
    }
    public String format(List<String> tokens) {
        String ret = "";
        for (String t : tokens) {
            ret += "/";
            ret += t;
        }
        return ret;
    }

    public List<String> parse(String path) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        String current = "";
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '/') {
                if (current.length() > 0) {
                    tokens.add(current);
                }
                current = "";
            } else {
                current = current + c;
            }
            i++;
        }
        if (current.length() > 0) {
            tokens.add(current);
        }
        return tokens;
    }
}