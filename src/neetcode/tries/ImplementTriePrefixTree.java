package neetcode.tries;

//208. Implement Trie (Prefix Tree)
//https://leetcode.com/problems/implement-trie-prefix-tree/
//211. Design Add and Search Words Data Structure
public class ImplementTriePrefixTree {

  static Trie root;

  public static class Trie {

    boolean isEndOfTheWord;
    Trie[] children = new Trie[128];

    public Trie() {
      isEndOfTheWord = false;
      for (int i = 0; i < 128; i++) {
        children[i] = null;
      }
    }
  }

  public void insert(String word) {
    Trie current = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 0;
      if (current.children[index] == null) {
        current.children[index] = new Trie();
      }
      current = current.children[index];
    }
    current.isEndOfTheWord = true;
  }


  public boolean search(String word) {
    Trie current = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 0;
      if (word.charAt(i) == '.') {
        for(int j =0; j<128; j++){
          if(current.children[j] != null){
            current = current.children[j];
          }
        }
      } else {
        if (current.children[index] == null) {
          return false;
        }
        current = current.children[index];
      }
    }
    return (current != null && current.isEndOfTheWord);
  }

  public boolean startsWith(String word) {
    Trie current = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (current.children[index] == null) {
        return false;
      } else {
        current = current.children[index];
      }
    }
    return (current != null);
  }

  public static void main(String arg[]) {
    root = new Trie();
    ImplementTriePrefixTree tree = new ImplementTriePrefixTree();
    String[] list = {"bad", "dad", "mad"};
    for (int i = 0; i < list.length; i++) {
      tree.insert(list[i]);
    }
    System.out.println(tree.search("pad"));
    System.out.println(tree.search("bad"));
    System.out.println(tree.search(".ad"));
    System.out.println(tree.search("b.."));


  }
}
