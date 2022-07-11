package neetcode.dptwodim;

public class LongestCommonSubsequence {

  static int count = 0;
  static int dp[][];

  public static void main(String ar[]) {

    String x = "abcdf";
    String y = "abcdhgr";
    dp = new int[x.length() + 1][y.length() + 1];
    for (int i = 0; i <= x.length(); i++) {
      for (int j = 0; j <= y.length(); j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }

    }
    System.out.println(subsequenceRec(x, y, x.length(), y.length()));
    System.out.println(count);
    count = 0;
    System.out.println(subsequenceRecTopdown(x, y, x.length(), y.length()));
    System.out.println(count);
  }

  public static int subsequenceRecMemo(String x, String y, int n, int m) {
    count++;
    if (n == 0 || m == 0) {
      return 0;
    }
    if (dp[n][m] != -1) {
      return dp[n][m];
    }
    if (x.charAt(n - 1) == y.charAt(m - 1)) {
      return dp[n][m] = 1 + subsequenceRecMemo(x, y, n - 1, m - 1);
    } else {
      return dp[n][m] = Math.max(subsequenceRecMemo(x, y, n - 1, m), subsequenceRecMemo(x, y, n, m - 1));
    }
  }

  public static int subsequenceRecTopdown(String x, String y, int n, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        count++;
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
           dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
           dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m];
  }

  public static int subsequenceRec(String x, String y, int n, int m) {
    count++;
    if (n == 0 || m == 0) {
      return 0;
    }
    if (x.charAt(n - 1) == y.charAt(m - 1)) {
      return 1 + subsequenceRec(x, y, n - 1, m - 1);
    } else {
      return Math.max(subsequenceRec(x, y, n - 1, m), subsequenceRec(x, y, n, m - 1));
    }
  }
}
