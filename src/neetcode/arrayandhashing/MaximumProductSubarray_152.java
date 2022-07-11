package neetcode.arrayandhashing;

public class MaximumProductSubarray_152 {

  public static void main(String ar[]) {
    int nums[] = {-2, -40, 0, -2, -3};
    System.out.println(maxProduct(nums));
  }
//152. Maximum Product Subarray
  //https://leetcode.com/problems/maximum-product-subarray/
  public static int maxProduct(int[] nums) {
    int res = nums[0];
    int minprod = nums[0];
    int maxprod = nums[0];
    int choice1, choice2;
    for (int i = 1; i < nums.length; i++) {
      choice1 = minprod * nums[i];
      choice2 = maxprod * nums[i];
      minprod = Math.min(nums[i], Math.min(choice1, choice2));
      maxprod = Math.max(nums[i], Math.max(choice1, choice2));
      res = Math.max(maxprod, res);
    }
    return res;
  }
}
