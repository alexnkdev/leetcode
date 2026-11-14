class Solution {
  public String finalString(String[] c) {
    List<Character> current = new ArrayList<>();
    Stack<Character> undones = new Stack<>();
    for (int i = 0; i < c.length; i++) {
      String command = c[i];
      if (command.startsWith("type ")) {
        String letter = command.split(" ")[1];
        current.add(letter.charAt(0));
        undones.clear();
      } else if (command.equals("undo")) {
        if (current.size() > 0) {
          Character undone = current.get(current.size() - 1);
          undones.push(undone);
          current.remove(current.size() - 1);
        }
      } else if (command.equals("redo")) {
        if (undones.size() > 0) {
          current.add(undones.pop());
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Character cc : current) {
      sb.append(cc);
    }
    return sb.toString();
  }
}
