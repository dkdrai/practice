package neetcode.slidingwindow;
/*
 Problem Statement#
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
or [1, 1, 6].*/
public class sw2SmallestSubarraywithaGreaterSum {

  public static void main(String args[]) {
    int arr1[] = {2, 1, 5, 2, 3, 2};
    System.out.println(getSmallestSubarraywithaGreaterSumBrute(arr1, 8));
    System.out.println(getSlide(arr1, 7));
  }

  public static int getSmallestSubarraywithaGreaterSumBrute(int arr[], int k) {
    if (k <= 0) {
      return 0;
    }
    int count = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum >= k) {
          count = Math.min(count, j - i + 1);
        }
      }
    }
    return count;
  }

  public static int getSlide(int arr[], int k) {
    if (k <= 0) {
      return 0;
    }
    int count = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum >= k) {
        count = Math.min(count, i - left + 1);
        sum -= arr[left];
        left++;
      }
    }
    return count;
  }

}
