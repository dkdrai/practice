package neetcode.backtracking;

//79. Word Search
//https://leetcode.com/problems/word-search/
public class WordSearch {

  public static void main(String arg[]) {

  }

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0) &&
            dfs(board, word, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(char[][] board, String word, int r, int c, int index) {
    if (index == word.length()) {
      return true;
    }
    if (r >= board.length || r < 0 ||
        c >= board[0].length || c < 0
        || board[r][c] != word.charAt(index)) {
      return false;
    }
    char temp = board[r][c];
    board[r][c] = ' ';
    boolean res = dfs(board, word, r + 1, c, index + 1)
        || dfs(board, word, r - 1, c, index + 1)
        || dfs(board, word, r, c + 1, index + 1)
        || dfs(board, word, r, c - 1, index + 1);
    board[r][c] = temp;
    return res;
  }
}
