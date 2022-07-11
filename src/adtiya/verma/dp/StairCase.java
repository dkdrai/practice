package adtiya.verma.dp;

public class StairCase {

  public static void main(String args[]) {
    System.out.println(stairs(4));
    System.out.println(stairsMemo(4, new int[5]));
  }

  public static int stairs(int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    return stairs(n - 1) + stairs(n - 2);
  }

  public static int stairsMemo(int n, int memo[]) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (memo[n] == 0) {
      memo[n] = stairsMemo(n - 1, memo) + stairsMemo(n - 2, memo);
    }
    return memo[n];
  }
}
