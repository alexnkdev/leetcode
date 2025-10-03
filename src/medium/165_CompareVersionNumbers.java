class Solution {
    public int compareVersion(String version1, String version2) {
        Revision revision1 = Revision.parse(version1);
        Revision revision2 = Revision.parse(version2);
        int k = Math.max(revision1.values.length, revision2.values.length);
        for (int i = 0; i < k; i++) {
            int val1 = i < revision1.values.length ? revision1.values[i] : 0;
            int val2 = i < revision2.values.length ? revision2.values[i] : 0;
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }
        }
        return 0;
    }



static class Revision {

    public int[] values;

    public Revision(int[] values) {
        this.values = values;
    }

    public static Revision parse(String str) {
        String[] tokens = str.split("\\.");
        int[] values = new int[tokens.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(tokens[i]);
        }
        return new Revision(values);
    }
}


}
