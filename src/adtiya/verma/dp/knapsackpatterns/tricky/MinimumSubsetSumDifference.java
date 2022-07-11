package adtiya.verma.dp.knapsackpatterns.tricky;

import java.util.Arrays;

/*
Sum of subset differences
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:
Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSubsetSumDifference {

  public static void main(String ar[]) {
    int arr[] = {2, 5, 6, 13};
    System.out.print(sumPresentDp(arr));
  }

  public static int sumPresentDp(int arr[]) {
    int n = arr.length;
    int sum = Arrays.stream(arr).sum();
    int mid = sum / 2;
    boolean t[][] = new boolean[n + 1][mid + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < mid + 1; j++) {
        if (i == 0) {
          t[i][j] = false;
        }
        if (j == 0) {
          t[i][j] = true;
        }
      }
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < mid + 1; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] | t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    int min = 0;
    for (int i = mid; i > 0; i--) {
      if (t[n][i]) {
        min = Math.abs(sum - i) - i;
        break;
      }
    }
    return min;
  }
}
