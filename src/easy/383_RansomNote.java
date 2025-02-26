class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqRansom = new int[26];
        int[] freqMagazine = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            freqRansom[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            freqMagazine[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freqRansom[i] > freqMagazine[i]) {
                return false;
            }
        }
        return true;
    }
}