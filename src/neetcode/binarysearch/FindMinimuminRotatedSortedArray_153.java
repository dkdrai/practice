package neetcode.binarysearch;

public class FindMinimuminRotatedSortedArray_153 {

  public static void main(String ar[]) {
    int nums[] = {4, 5, 6, 7, 0, 1, 1, 2, 3};
    System.out.println(getMint(nums));
    getMint(nums);
  }
//153. Find Minimum in Rotated Sorted Array
  //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

  public static int getMint(int arr[]) {
    if (arr.length == 0) {
      return -1000;
    }
    if (arr.length == 1) {
      return arr[0];
    }
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= arr[right]) {
        right = mid;
      } else if (arr[mid] >= arr[right]) {
        left = mid + 1;
      }
    }
    return arr[left];
  }


}
