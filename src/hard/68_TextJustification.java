class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    StringBuilder currentLine = new StringBuilder();
    List<String> ret = new ArrayList<>();
    for (String word : words) {

      int extra = 0;
      if (currentLine.length() > 0) {
        extra = 1;
      }

      if (currentLine.length() + word.length() + extra <= maxWidth) {
        if (currentLine.length() != 0) {
          currentLine.append(" ");
        }
        currentLine.append(word);
      } else {
        if (currentLine.length() > 0) {
          ret.add(justifyLine(currentLine.toString(), maxWidth));
          currentLine = new StringBuilder();
          currentLine.append(word);
        }
      }

    }
    if (currentLine.length() > 0) {
      ret.add(justifyLastLine(currentLine.toString(), maxWidth));
    }
    return ret;
  }

  String justifyLastLine(String line, int maxWidth) {
    StringBuilder ret = new StringBuilder();
    ret.append(line);
    while (ret.length() < maxWidth) {
      ret.append(" ");
    }
    return ret.toString();
  }

  String justifyLine(String line, int maxWidth) {
    String[] words = line.split(" ");
    int spaces = words.length - 1;
    int extra = maxWidth - line.length(); // 2 extra 5 spaces

    int extraForEach = spaces == 0 ? 0 : extra / spaces;
    int rem = spaces == 0 ? 0 : extra % spaces;

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      result.append(words[i]);
      if (i < words.length - 1) {
        int numSpaces = 1 + extraForEach;
        if (i + 1 <= rem) {
          numSpaces++;
        }
        for (int k = 0; k < numSpaces; k++) {
          result.append(" ");
        }
      }
    }
    while (result.length() < maxWidth) {
      result.append(" ");
    }
    return result.toString();
  }
}
