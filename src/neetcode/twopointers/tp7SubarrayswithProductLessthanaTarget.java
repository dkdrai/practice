package patterns.TwoPointers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.IconUIResource;

/*Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0* /

 */
public class tp7SubarrayswithProductLessthanaTarget {

  public static void main(String args[]) {
    int arr[] = {10, 5, 2, 6};
    System.out.println(bruteForce(arr, 100));
    System.out.println(solution(arr, 100));
  }


  public static int solution(int arr[], int target) {
    int left = 0;
    int right = 0;
    int prod = 1;
    int result = 0;
    while (right < arr.length) {
      prod *= arr[right];
      while (prod >= target) {
        prod /= arr[left];
        left++;
      }
      result += right - left + 1;
      right++;
    }
    return result;
  }

  public static int bruteForce(int arr[], int target) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 1;

      for (int j = i; j < arr.length; j++) {
        sum *= arr[j];
        if (sum < target) {
          count++;
        }
      }
    }
    return count;
  }

}
