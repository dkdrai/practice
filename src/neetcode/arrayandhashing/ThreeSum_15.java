package neetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum_15 {

  public static void main(String ar[]) {
    int num[] = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(num));
  }

  // three sum
  //https://leetcode.com/problems/3sum/
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> listList = new ArrayList<>();
    Arrays.sort(nums);
    Set<String> set = new HashSet<>();
    for (int i = 0; i < nums.length-2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0 && !set.contains(nums[i] + "-" + nums[left] + "-" + nums[right])) {
          List<Integer> list = List.of(nums[i], nums[left], nums[right]);
          set.add(nums[i] + "-" + nums[left] + "-" + nums[right]);
          listList.add(list);
          right = right - 1;
          left = left + 1;
        } else if (sum > 0) {
          right = right - 1;
        } else {
          left = left + 1;
        }
      }
    }
    return listList;
  }
}