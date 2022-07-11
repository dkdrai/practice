package neetcode.twopointers;

public class TrappingRainWater {

  //42. Trapping Rain Water
  //https://leetcode.com/problems/trapping-rain-water/description/
  // Need to create 2 utils array 1- containing all the elements greater from left to right and another containing all the elements greater
  //from right to left against each element

  public static void main(String arg[]) {
    int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(height));
  }

  public static int trap(int[] height) {
    int n = height.length;
    int leftarr[] = new int[n];
    leftarr[0] = height[0];
    int rightarr[] = new int[n];
    rightarr[n - 1] = height[n - 1];
    for (int i = 1; i < n; i++) {
      if (height[i] > leftarr[i - 1]) {
        leftarr[i] = height[i];
      } else {
        leftarr[i] = leftarr[i - 1];
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      if (height[i] > rightarr[i + 1]) {
        rightarr[i] = height[i];
      } else {
        rightarr[i] = rightarr[i + 1];
      }
    }
    int max = 0;
    for (int i = 1; i < n - 1; i++) {
      int min = Math.min(leftarr[i], rightarr[i]);
      max += min - height[i];
    }
    return max;
  }
}
