class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();
                stack.push(apply(op1, op2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*")
        || token.equals("/");
    }

    int apply(int op1, int op2, String operator) {
        if (operator.equals("+")) {
            return op1 + op2;
        }
        if (operator.equals("-")) {
            return op1 - op2;
        }
        if (operator.equals("*")) {
            return op1 * op2;
        }
        if (operator.equals("/")) {
            return op1 / op2;
        }
        throw new RuntimeException();
    }

}
