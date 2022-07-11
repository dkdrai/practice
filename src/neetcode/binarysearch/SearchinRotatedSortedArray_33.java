package neetcode.binarysearch;

public class SearchinRotatedSortedArray_33 {

  public static void main(String ar[]) {
    int nums[] = {1, 2, 3, 4, 5, 6, 7, 0};
    System.out.println(searchKey(nums, 0));
  }

  //33. Search in Rotated Sorted Array
  //https://leetcode.com/problems/search-in-rotated-sorted-array/

  private static int searchKey(int[] nums, int targe) {
    if (nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == targe) {
        return mid;
      }
      if (nums[left] <= nums[mid]) {
        if (targe >= nums[left] && targe < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (targe > nums[mid] && targe <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  // int nums[] = {1, 2, 3, 4, 5, 6, 7, 0};
  public static int search(int[] nums, int target) {
    int mid;
    int size = nums.length;
    int left = 0;
    int right = size - 1;
    while (left < right) {
      mid = left + right / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[left] < nums[mid]) {
        if (nums[left] <= target && nums[mid] >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[left] <= target && nums[mid] >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
        right = mid;
      }
    }
    return -1;
  }

}
