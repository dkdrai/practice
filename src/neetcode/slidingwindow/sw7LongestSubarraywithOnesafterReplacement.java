package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class sw7LongestSubarraywithOnesafterReplacement {

  public static void main(String args[]) {
    int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    System.out.println(slide(arr, 3));
  }

  public static int slide(int arr[], int k) {
    int max = 0;
    int left = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int right = 0; right < arr.length; right++) {
      int c = arr[right];
      map.put(c, map.getOrDefault(c, 0) + 1);
      int maxCharCount = getMaxFromMap(map);
      while ((right - left + 1) - maxCharCount > k) {
        int leftChar = arr[left];
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(arr[left]) == 0) {
          map.remove(arr[left]);
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

  public static int getMaxFromMap(Map<Integer, Integer> map) {
    int maxCount = 0;
    for (int count : map.values()) {
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }
}
