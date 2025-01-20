package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TrieImpl {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("test");
		trie.insert("Blahblah");
		System.out.println(trie.startsWith("testr"));
	}
	
	
	static class Trie {
		
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				TrieNode child = current.children.get(word.charAt(i));
				if (child == null) {
					child = new TrieNode();
					current.children.put(word.charAt(i), child);
				}
				current = child;
			}
			current.isWord = true;
		}
		
		public boolean search(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				if (!current.children.containsKey(word.charAt(i))) {
					return false;
				}
				current = current.children.get(word.charAt(i));
			}
			return current.isWord;
		}
		
		public boolean startsWith(String prefix) {
			TrieNode current = root;
			for (int i = 0; i < prefix.length(); i++) {
				if (!current.children.containsKey(prefix.charAt(i))) {
					return false;
				}
				current = current.children.get(prefix.charAt(i));
			}
			return true;
		}
		
	}
	
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isWord;
	}
}
