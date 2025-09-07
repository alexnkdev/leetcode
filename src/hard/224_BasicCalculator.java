class Solution {
    public int calculate(String s) {
        return calc(0, s).val;
    }

    Value calc(int from, String s) {
        int i = from;
        int ret = 0;
        char op = '+';
        String currentToken = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                Value subExpressionValue = calc(i + 1, s);
                ret = addOp(ret, op, Integer.toString(subExpressionValue.val));
                currentToken = "";
                i = subExpressionValue.nextPos;
            } else if (c == '+') {
                if (currentToken.length() > 0) {
                    ret = addOp(ret, op, currentToken);
                    currentToken = "";
                }
                op = '+';
                i++;
            } else if (c == '-') {
                if (currentToken.length() > 0) {
                    ret = addOp(ret, op, currentToken);
                    currentToken = "";
                }
                op = '-';
                i++;
            } else if (c == ')') {
                i++;
                break;
            } else if (c != ' ') {
                currentToken += c;
                i++;
            } else {
                i++;
            }
        }
        if (currentToken.length() > 0) {
            ret = addOp(ret, op, currentToken);
            currentToken = "";
        }
        return new Value(ret, i);
    }

    int addOp(int current, char op, String token) {
        if (op == '+') {
            return current + Integer.parseInt(token);
        } else {
            return current - Integer.parseInt(token);
        }
    }

    static class Value {

        public int val;
        public int nextPos;

        public Value(int val, int nextPos) {
            this.val = val;
            this.nextPos = nextPos;
        }
    }

}
