class Solution {
  public List<Integer> diffWaysToCompute(String expression) {
    List<String> tokens = parse(expression);
    List<Integer> ret = calc(0, tokens.size(), tokens);
    return ret;
  }

  public List<Integer> calc(int from, int to, List<String> tokens) {
    if (from + 1 == to) {
      Integer val = Integer.parseInt(tokens.get(from));
      List<Integer> ret = new ArrayList<>();
      ret.add(val);
      return ret;
    }
    List<Integer> ret = new ArrayList<>();
    for (int k = from; k < to; k++) {
      String token = tokens.get(k);
      if (isOperator(token)) {
        List<Integer> left = calc(from, k, tokens);
        List<Integer> right = calc(k + 1, to, tokens);
        for (Integer l : left) {
          for (Integer r : right) {
            ret.add(apply(l, r, token));
          }
        }
      }
    }
    return ret;
  }

  Integer apply(Integer l, Integer r, String operator) {
    if (operator.equals("+")) {
      return l + r;
    } else if (operator.equals("-")) {
      return l - r;
    }
    return l * r;
  }

  boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*");
  }


  public List<String> parse(String expression) {
    String currentToken = "";
    List<String> ret = new ArrayList<>();
    for (char c : expression.toCharArray()) {
      if (c == '+' || c == '-' || c == '*') {
        if (!currentToken.isEmpty()) {
          ret.add(currentToken);
          currentToken = "";
        }
        ret.add("" + c);
      } else {
        currentToken += c;
      }
    }
    if (!currentToken.isEmpty()) {
      ret.add(currentToken);
    }
    return ret;
  }

}
