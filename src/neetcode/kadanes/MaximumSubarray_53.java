package neetcode.kadanes;

public class MaximumSubarray_53 {

  public static void main(String ar[]) {
    //int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int nums[] =  {5,4,-1,7,8};
    System.out.println(maxSubArray(nums));
  }

  //53. Maximum Subarray
  //https://leetcode.com/problems/maximum-subarray/
  public static int maxSubArray(int[] nums) {
    int max = 0;
    int sofar = 0;
    for (int i = 0; i < nums.length; i++) {
      max = max + nums[i];
      if (max > sofar) {
        sofar = max;
      }
      if (max < 0) {
        max = 0;
      }
    }
    return sofar;
  }
}
