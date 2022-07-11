package neetcode.arrayandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_217 {

  public static void main(String ar[]) {
    int stops[] = {3, 2, 4, 8, 7,2};
    System.out.println(containsDuplicate(stops));
  }

  //217. Contains Duplicate
  //https://leetcode.com/problems/contains-duplicate/
  public static boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return true;
      } else {
        map.put(nums[i], nums[i]);
      }
    }
    return false;
  }

}
