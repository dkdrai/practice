package adtiya.verma.dp.unboundedknapsack;

public class Knapsack {

  static Integer dp[][] = new Integer[100][100];

  public static void main(String ar[]) {
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        dp[i][j] = -1;
      }
    }

    int value[] = {10, 40, 50, 70};
    int weight[] = {1, 3, 4, 5};
    int W = 8;
    int n = value.length;
    System.out.println(knapsackRec(value, weight, W, n));
    System.out.println(knapsackMemo(value, weight, W, n));
    System.out.println(knapsackDp(value, weight, W, n));
  }

  private static int knapsackRec(int[] value, int[] weight, int w, int n) {
    if (n == 0 || w == 0) {
      return 0;
    }
    if (weight[n - 1] <= w) {
      return Math.max(value[n - 1] + knapsackRec(value, weight, w - weight[n - 1], n),
          knapsackRec(value, weight, w, n - 1));
    } else {
      return knapsackRec(value, weight, w, n - 1);
    }
  }

  private static int knapsackMemo(int[] value, int[] weight, int w, int n) {
    if (w == 0 || n == 0) {
      return 0;
    }
    if (dp[n][w] != -1) {
      return dp[n][w];
    }
    if (weight[n - 1] <= w) {
      return dp[n][w] = Math.max(value[n - 1] + knapsackMemo(value, weight, w - weight[n - 1], n),
          knapsackMemo(value, weight, w, n - 1));
    } else {
      return dp[n][w] = knapsackMemo(value, weight, w, n - 1);
    }
  }

  private static int knapsackDp(int[] value, int[] weight, int w, int n) {
    int sol[][] = new int[n + 1][w + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= w; j++) {
        if (i == 0 || j == 0) {
          sol[i][j] = 0;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (weight[i - 1] <= j) {
          sol[i][j] = Math.max(value[i - 1] + sol[i - 1][j - weight[i - 1]], sol[i - 1][j]);
        } else {
          sol[i][j] = sol[i - 1][j];
        }
      }
    }
    return sol[n][w];
  }

}