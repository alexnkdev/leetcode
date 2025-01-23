import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<StringPair> sorted = new ArrayList<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String(chars);
            StringPair pair = new StringPair(sortedS, s);
            sorted.add(pair);
        }
        Collections.sort(sorted, (s1, s2) -> {
            return s1.sorted.compareTo(s2.sorted);
        });
        List<List<String>> ret = new ArrayList<>();
        int i = 0;
        while (i < sorted.size()) {
            StringPair current = sorted.get(i);
            List<String> group = new ArrayList<>();
            while (i < sorted.size() && current.sorted.equals(sorted.get(i).sorted)){ 
                group.add(sorted.get(i).original);
                i++;
            }
            ret.add(group);
        }
        return ret;
    }

    static class StringPair {
        String sorted;
        String original;
        public StringPair(String sorted, String original) {
            this.sorted = sorted;
            this.original = original;
        }
    }
}