package adtiya.verma.dp.knapsackpatterns;

/*
Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}

 */
public class CountOfSubsetWithGivenSum {

  static int dp[][] = new int[100][100];

  public static void main(String ar[]) {
    int arr[] = {3, 4, 5, 6, 7, 8, 2};
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(subsetSumCountRec(arr, 9, arr.length));
    System.out.println(subsetSumCountMemo(arr, 9, arr.length));
    System.out.println(subsetSumCountTopDown(arr, 9, arr.length));
  }

  private static int subsetSumCountRec(int[] arr, int sum, int n) {
    if (sum == 0) {
      return 1;
    }
    if (n == 0) {
      return 0;
    }
    if (arr[n - 1] <= sum) {
      return subsetSumCountRec(arr, sum - arr[n - 1], n - 1) + subsetSumCountRec(arr, sum, n - 1);
    } else {
      return subsetSumCountRec(arr, sum, n - 1);
    }
  }

  private static int subsetSumCountMemo(int[] arr, int sum, int n) {
    if (sum == 0) {
      return 1;
    }
    if (n == 0) {
      return 0;
    }
    if (dp[n][sum] != -1) {
      return dp[n][sum];
    }
    if (arr[n - 1] <= sum) {
      return dp[n][sum] = subsetSumCountMemo(arr, sum - arr[n - 1], n - 1) + subsetSumCountMemo(arr, sum, n - 1);
    } else {
      return dp[n][sum] = subsetSumCountMemo(arr, sum, n - 1);
    }
  }

  private static int subsetSumCountTopDown(int[] arr, int sum, int n) {
    int t[][] = new int[n + 1][sum + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if (j == 0) {
          t[i][j] = 1;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];

  }
}
