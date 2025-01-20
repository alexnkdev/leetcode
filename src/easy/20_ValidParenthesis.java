package easy;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpening(c)) {
                stack.add(c);
            } else {
                char reversed = reverse(c);
                if (stack.isEmpty() || !(stack.peek() == reversed)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    char reverse(char c) {
        if (c == ')') {
            return '(';
        }
        if (c == ']') {
            return '[';
        }
        if (c == '}') {
            return '{';
        }
        throw new RuntimeException();
    }

}