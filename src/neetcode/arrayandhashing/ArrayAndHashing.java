package neetcode.arrayandhashing;

import java.util.HashMap;
import java.util.Map;

public class ArrayAndHashing {

  public static void main(String args[]) {

    System.out.println(isAnagram("anagram", "nagaram"));

    int arr[] = {1, 2, 3, 4, 5};
    System.out.println(containsDuplicate(arr));

    //int arr = {3, 4, 2};
    int sol[] = twoSum(arr, 6);
    System.out.println(sol[0]);
    System.out.println(sol[1]);
  }

  //1. Two Sum
  //https://leetcode.com/problems/two-sum/description/
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int part = target - nums[i];
      if (map.containsKey(part) && map.get(part) != i) {
        int sol[] = new int[2];
        sol[0] = i;
        sol[1] = map.get(part);
        return sol;
      }
    }
    return null;
  }

  //217. Contains Duplicate
  // https://leetcode.com/problems/contains-duplicate/description/
  public static boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer i : nums) {
      if (map.containsKey(i)) {
        return true;
      } else {
        map.put(i, i);
      }
    }
    return false;
  }

  //242. dataid Anagram
  //https://leetcode.com/problems/dataid-anagram/description/
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (map.containsKey(c)) {
        int count = map.get(c);
        if (count == 1) {
          map.remove(c);
        } else {
          map.put(c, map.get(c) - 1);
        }
      } else {
        return false;
      }
    }
    if (map.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
