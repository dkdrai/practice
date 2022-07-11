package neetcode.greedy;

//53. Maximum Subarray
//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int currentMax = nums[0];
    int maxSofar = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (currentMax < 0) {
        currentMax = nums[i];
      } else {
        currentMax = currentMax + nums[i];

      }
      if (currentMax > maxSofar) {
        maxSofar = currentMax;
      }
    }
    return maxSofar;
  }
}
