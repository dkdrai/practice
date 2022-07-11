package neetcode.twopointers;

public class ContainerWithMostWater_11 {

  public static void main(String ar[]) {
    int nums[] = {1, 10, 6, 2, 5, 4, 10, 3, 7};

    System.out.println(getMax(nums));
  }

  //11. Container With Most Water
  //https://leetcode.com/problems/container-with-most-water/

  public static int getMax(int num[]) {
    if (num.length == 0) {
      return -1;
    }
    int left = 0;
    int right = num.length - 1;
    int max = Integer.MIN_VALUE;
    while (left < right) {
      int diff = right - left;
      int min = Integer.min(num[left], num[right]);
      max = Integer.max(min * diff, max);
      if (min == num[left]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

}
