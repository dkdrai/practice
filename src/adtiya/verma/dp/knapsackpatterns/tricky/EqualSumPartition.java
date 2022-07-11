package adtiya.verma.dp.knapsackpatterns.tricky;

import java.util.Arrays;

/*
Equal Sum Partition Problem
Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11}
 */
public class EqualSumPartition {

  static boolean dp[][] = new boolean[100][100];

  public static void main(String ar[]) {
    int arr[] = {1, 5, 11, 5};
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        dp[i][j] = false;
      }
    }
    int sum = Arrays.stream(arr).sum();
    if (sum % 2 != 0) {
      System.out.print("false");
      return;
    }
    System.out.println(equalSumPresentRec(arr, sum / 2, arr.length));
    System.out.println(equalSumPresentDp(arr, sum / 2, arr.length));
  }

  private static boolean equalSumPresentRec(int[] arr, int sum, int length) {
    if (sum == 0) {
      return true;
    }
    if (length == 0) {
      return false;
    }
    if (arr[length - 1] <= sum) {
      return equalSumPresentRec(arr, sum - arr[length - 1], length - 1) || equalSumPresentRec(arr, sum, length - 1);
    } else {
      return equalSumPresentRec(arr, sum, length - 1);
    }
  }

  private static boolean equalSumPresentDp(int[] arr, int sum, int length) {
    boolean dp[][] = new boolean[length + 1][sum + 1];
    for (int i = 0; i <= length; i++) {
      for (int j = 0; j <= sum; j++) {
        if (i == 0) {
          dp[i][j] = false;
        }
        if (j == 0) {
          dp[i][j] = true;
        }
      }
    }
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[length][sum];
  }

}
