package neetcode.arrayandhashing;

public class ProductofArrayExceptSelf_238 {

  public static void main(String ar[]) {
    int nums[] = {-1, 1, 0, -3, 3};
    productExceptSelf(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  //238. Product of Array Except Self
  //https://leetcode.com/problems/product-of-array-except-self/
  public static int[] productExceptSelf(int[] nums) {
    int leftArray[] = new int[nums.length];
    int rigghtArray[] = new int[nums.length];
    leftArray[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      leftArray[i] = nums[i - 1] * leftArray[i - 1];
    }

    rigghtArray[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      rigghtArray[i] = nums[i + 1] * rigghtArray[i + 1];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = leftArray[i] * rigghtArray[i];
    }
    return nums;
  }
}

