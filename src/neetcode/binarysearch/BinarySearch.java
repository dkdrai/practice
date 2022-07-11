package neetcode.binarysearch;

public class BinarySearch {

  public static void main(String ar[]) {
    int nums[] = {-1, 0, 3, 5, 9, 12};
    System.out.println(search(nums, 9));
    System.out.println(searchRec(nums, 9, 0, nums.length - 1));
    System.out.println(search(nums, 2));
    System.out.println(searchRec(nums, 2, 0, nums.length - 1));
  }

  //704. Binary Search
  //https://leetcode.com/problems/binary-search/description/
  public static int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static int searchRec(int[] nums, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    int mid = left + (right - left) / 2;
    if (target == nums[mid]) {
      return mid;
    }

    if (target == nums[mid]) {
      return mid;
    } else if (target < nums[mid]) {
      return searchRec(nums, target, left, mid - 1);
    } else {
      left = mid + 1;
      return searchRec(nums, target, mid + 1, right);
    }
  }
}


