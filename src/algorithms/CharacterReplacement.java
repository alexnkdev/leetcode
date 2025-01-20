package algorithms;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
    	char[] cnt = new char[26];
    	for (int i = 0; i < s.length(); i++) {
    		cnt[s.charAt(i) - 'A']++;
    	}
    	for (char c = 'A'; c <= 'Z'; c++) {
	    	for (int i = 0; i < s.length(); i++) {
	    		
	    	}
    	}
        return -1;
    }
    
    public static void main(String[] args) {
    	System.out.println(new CharacterReplacement().characterReplacement("AABABBA", 1));
    }
    
}
