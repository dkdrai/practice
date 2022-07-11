package neetcode.backtracking;

public class NQueens {

  static int sol[][] = new int[4][4];

  public static void main(String ar[]) {
    nQueenUtil(sol, 0, 4);
  }

  public static boolean nQueenUtil(int sol[][], int r, int n) {
    if (n == r) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(sol[i][j]);
        }
        System.out.println("");
      }
      return true;
    }
    boolean res = false;
    for (int i = 0; i < n; i++) {
      if (isSafe(sol, r, i, n)) {
        sol[r][i] = 1;
        res = nQueenUtil(sol, r + 1, n);
        sol[r][i] = 0;
      }
    }
    return res;
  }

  static boolean isSafe(int sol[][], int r, int c, int n) {
    for (int i = 0; i < n; i++) {
      if (sol[i][c] == 1) {
        return false;
      }
      if (sol[r][i] == 1) {
        return false;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i + j == r + c && sol[i][j] == 1) {
          return false;
        }
        if (i - j == r - c && sol[i][j] == 1) {
          return false;
        }
      }
    }
    return true;
  }
/*00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33 */
}
