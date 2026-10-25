class Solution {

  public int calculate(String s) {
    List<String> terms = parseTerms(s);
    int currentValue = 0;
    // (term)+(term2)-(term3)
    char operator = '+';
    for (int i = 0; i < terms.size(); i++) {
      String term = terms.get(i);
      if (term.equals("+") || term.equals("-")) {
        String prevTerm = terms.get(i - 1);
        int termValue = calcTerm(prevTerm);
        currentValue = apply(currentValue, termValue, operator);
        operator = term.charAt(0);
      }
    }
    String lastTerm = terms.get(terms.size() - 1);
    currentValue = apply(currentValue, calcTerm(lastTerm), operator);
    return currentValue;
  }

  int calcTerm(String term) {
    int val = 1;
    String currentToken = "";
    char operator = '*';
    for (int i = 0; i < term.length(); i++) {
      char c = term.charAt(i);
      if (c == '*' || c == '/') {
        if (!currentToken.isEmpty()) {
          val = apply(val, Integer.parseInt(currentToken), operator);
          currentToken = "";
        }
        operator = c; 
      } else {
        currentToken += c;
      }
    }
    if (!currentToken.isEmpty()) {
      val = apply(val, Integer.parseInt(currentToken), operator);
    }
    return val;
  }

  int apply(int op1, int op2, char operator) {
    if (operator == '*') {
      return op1 * op2;
    } else if (operator == '/') {
      return op1 / op2;
    } else if (operator == '+') {
      return op1 + op2;
    } else if (operator == '-') {
      return op1 - op2;
    }
    throw new IllegalArgumentException();
  }

  List<String> parseTerms(String s) {
    String currentToken = "";
    List<String> tokens = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        continue;
      }
      if (c == '+' || c == '-') {
        if (!currentToken.isEmpty()) {
          tokens.add(currentToken);
          currentToken = "";
        }
        tokens.add("" + c);
      } else {
        currentToken += c;
      }
    }
    if (!currentToken.isEmpty()) {
      tokens.add(currentToken);
    }
    return tokens;
  }

}
