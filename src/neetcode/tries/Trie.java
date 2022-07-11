package neetcode.tries;

public class Trie {
	static Trie root;
	boolean isEndOfTheWord = false;
	Trie[] children = new Trie[26];
	public Trie() {
		isEndOfTheWord = false;
		for(int i =0; i<26; i++){
			children[i] = null;
		}
	}

	public void insert(String key) {
		Trie current = root;
		for(int i=0; i<key.length(); i++){
			int index = key.charAt(i)-'a';
			if(current.children[index] == null){
				current.children[index] = new Trie();
			}
			current = current.children[index];
		}
		current.isEndOfTheWord = true;
	}

	public boolean search(String key) {
		Trie current = root;
		for(int i=0; i<key.length(); i++){
			int index = key.charAt(i)-'a';
			if(current.children[index] == null){
				return false;
			}
			current = current.children[index];
		}
		return (current != null && current.isEndOfTheWord);
	}

	public boolean startsWith(String key) {
		Trie current = root;
		for(int i=0; i<key.length(); i++){
			int index = key.charAt(i)-'a';
			if(current.children[index] == null){
				return false;
			}else {
				current = current.children[index];
			}
		}
		return (current != null );
	}
}