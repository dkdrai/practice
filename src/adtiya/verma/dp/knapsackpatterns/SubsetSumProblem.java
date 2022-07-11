package adtiya.verma.dp.knapsackpatterns;
/*
Subset Sum Problem(Dynamic Programming)
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSumProblem {

  static boolean dp[][] = new boolean[100][100];

  public static void main(String ar[]) {
    int arr[] = {2, 3, 7, 8, 10};
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        dp[i][j] = false;
      }
    }
    System.out.println(sumPresentRec(arr, 12, arr.length));

    System.out.println(sumPresentDp(arr, 12, arr.length));
  }

  public static boolean sumPresentRec(int arr[], int sum, int n) {
    if (sum == 0) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    if (arr[n - 1] <= sum) {
      return sumPresentRec(arr, sum - arr[n - 1], n - 1) | sumPresentRec(arr, sum, n - 1);
    } else {
      return sumPresentRec(arr, sum, n - 1);
    }
  }

  public static boolean sumPresentDp(int arr[], int sum, int n) {
    boolean t[][] = new boolean[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = false;
        }
        if (j == 0) {
          t[i][j] = true;
        }
      }
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] | t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }
}
