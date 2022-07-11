package adtiya.verma.dp.knapsackpatterns;

public class Knapsack {

  static Integer dp[][] = new Integer[100][100];

  public static void main(String ar[]) {
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        dp[i][j] = -1;
      }
    }

    int value[] = {20, 5, 10, 40, 15, 25};
    int weight[] = {1, 2, 3, 8, 7, 4};
    int W = 10;
    int n = value.length;
    System.out.println(knapsackRec(value, weight, W, n));
    System.out.println(knapsackMemo(value, weight, W, n));
    System.out.println(knapsackDp(value, weight, W, n));
  }

  public static int knapsackDp(int value[], int weight[], int w, int n) {
    int dp[][] = new int[n + 1][w + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= w; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (weight[i - 1] <= j) {
          dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n][w];

  }

  public static int knapsackRec(int value[], int weight[], int W, int n) {
    if (n == 0 || W == 0) {
      return 0;
    }
    int sum = 0;
    if (weight[n - 1] <= W) {
      sum = value[n - 1] + knapsackRec(value, weight, W - weight[n - 1], n - 1);
    }
    return Math.max(knapsackRec(value, weight, W, n - 1), sum);
  }


  public static int knapsackMemo(int value[], int weight[], int w, int n) {
    if (n == 0 || w == 0) {
      return 0;
    }
    if (dp[n][w] != -1) {
      return dp[n][w];
    }
    int sum = 0;
    if (weight[n - 1] <= w) {
      sum = value[n - 1] + knapsackMemo(value, weight, w - weight[n - 1], n - 1);
    }
    return dp[n][w] = Math.max(sum, knapsackMemo(value, weight, w, n - 1));
  }

}
