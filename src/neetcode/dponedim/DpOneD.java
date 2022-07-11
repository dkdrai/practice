package neetcode.dponedim;

public class DpOneD {

  public static void main(String arg[]) {
    int a[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(minCostClimbingStairs(a));

  }

  //70. Climbing Stairs
  //https://leetcode.com/problems/climbing-stairs/submissions/
  static int sol[];
  public static int climbStairs(int n) {
    sol = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      sol[i] = -1;
    }
    return climbStairsUt(n);
  }

  public static int climbStairsUt(int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (sol[n] == -1) {
      sol[n] = climbStairsUt(n - 1) + climbStairsUt(n - 2);
    }
    return sol[n];
  }



  public static int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
  }

  public static int minCost(int[] cost, int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0 || n == 1) {
      return cost[n];
    }
    return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
  }

  // Top Down Memoization - O(n) 1ms
  int[] dp;
  public int minCostClimbingStairs1(int[] cost) {
    int n = cost.length;
    dp = new int[n];
    return Math.min(minCost1(cost, n-1), minCost1(cost, n-2));
  }
  private int minCost1(int[] cost, int n) {
    if (n < 0) return 0;
    if (n==0 || n==1) return cost[n];
    if (dp[n] != 0) return dp[n];
    dp[n] = cost[n] + Math.min(minCost1(cost, n-1), minCost1(cost, n-2));
    return dp[n];
  }

  // Bottom up tabulation - O(n) 1ms
  public int minCostClimbingStairs2(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n];
    for (int i=0; i<n; i++) {
      if (i<2) dp[i] = cost[i];
      else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    }
    return Math.min(dp[n-1], dp[n-2]);
  }

  // Bottom up computation - O(n) time, O(1) space
  public int minCostClimbingStairs3(int[] cost) {
    int n = cost.length;
    int first = cost[0];
    int second = cost[1];
    if (n<=2) return Math.min(first, second);
    for (int i=2; i<n; i++) {
      int curr = cost[i] + Math.min(first, second);
      first = second;
      second = curr;
    }
    return Math.min(first, second);
  }
}
