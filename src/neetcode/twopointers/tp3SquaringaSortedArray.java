package patterns.TwoPointers;

import java.util.Arrays;

/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]*/
public class tp3SquaringaSortedArray {

  public static void main(String args[]) {
    int arr[] = {-7,-3,2,3,11};
    square(arr);
  }

  public static void square(int arr[]) {
    int left = 0;
    int right = arr.length - 1;
    int sol[] = new int[arr.length];
    int i = arr.length - 1;
    while (left <= right) {
      int rightSq = arr[right] * arr[right];
      int leftSq = arr[left] * arr[left];
      if (leftSq > rightSq) {
        left++;
        sol[i] = leftSq;
      } else {
        right--;
        sol[i] = rightSq;
      }
      i--;
    }
    Arrays.stream(sol).forEach(x -> System.out.println(x));
  }

}
