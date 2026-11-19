class Solution {
  public String markdownToHtml(String[] lines) {
    for (int i = 0; i < lines.length; i++) {
      lines[i] = lines[i].trim();
    }
    StringBuilder ret = new StringBuilder();
    List<String> paragraph = new ArrayList<>();
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].length() == 0) {
        if (paragraph.size() > 0) {
          ret.append("<p>" + String.join(" ", paragraph) + "</p>");
          paragraph = new ArrayList<>();
        }
        continue;
      }
      if (isHeading(lines[i])) {
        if (paragraph.size() > 0) {
          ret.append("<p>" + String.join(" ", paragraph) + "</p>");
          paragraph = new ArrayList<>();
        }
        String headingPart = lines[i].split(" ")[0];
        int headingLevel = headingPart.length();
        String textPart = lines[i].substring(headingLevel + 1).trim();
        ret.append("<h" + headingLevel + ">" + replaceMarkers(textPart) + "</h" + headingLevel + ">");
      } else {
        paragraph.add(replaceMarkers(lines[i]));
      }
    }
    if (paragraph.size() > 0) {
      ret.append("<p>" + String.join(" ", paragraph) + "</p>");
    }
    return ret.toString();
  }
  
  boolean isHeading(String line) {
    return line.startsWith("# ") || line.startsWith("## ")
      || line.startsWith("### ");
  }

  String replaceMarkers(String s) {
    s = replaceBold(s);
    s = replaceItalic(s);
    s = replaceLinks(s);
    return s;
  }

  String replaceBold(String s) {
    int i = 0;
    StringBuilder ret = new StringBuilder();
    boolean in_bold = false;
    String bold_part = "";
    while (i < s.length()) {
      if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '*') {
          i += 2;
          if (in_bold) {
            in_bold = false;
            ret.append("<b>" + bold_part + "</b>");
            bold_part = "";
          } else {
            in_bold = true;
          }
      } else {
        if (in_bold) {
          bold_part += s.charAt(i);
        } else {
          ret.append(s.charAt(i));
        }
        i++;
      }
    }
    return ret.toString();
  }

  String replaceItalic(String s) {
    int i = 0;
    StringBuilder ret = new StringBuilder();
    boolean in_italic = false;
    String italic_part = "";
    while (i < s.length()) {
      if (i < s.length() && s.charAt(i) == '_') {
          i += 1;
          if (in_italic) {
            in_italic = false;
            ret.append("<i>" + italic_part + "</i>");
            italic_part = "";
          } else {
            in_italic = true;
          }
      } else {
        if (in_italic) {
          italic_part += s.charAt(i);
        } else {
          ret.append(s.charAt(i));
        }
        i++;
      }
    }
    return ret.toString();

  }

  String replaceLinks(String s) {
    int i = 0;
    StringBuilder ret = new StringBuilder();
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == '[') {
        int idx_end = s.indexOf(']', i);
        if (idx_end < 0) {
          ret.append(c);
        } else {
          String textPart = s.substring(i + 1, idx_end);
          int linkPartStart = idx_end + 2;
          int linkPartEnd = s.indexOf(')', linkPartStart);
          String linkPart = s.substring(linkPartStart, linkPartEnd);
          ret.append("<a href=\"" + linkPart + "\">" + textPart + "</a>");
          i = linkPartEnd + 1;
        }
      } else {
        ret.append(c);
        i++;
      }
    }
    return ret.toString();
  }

}
