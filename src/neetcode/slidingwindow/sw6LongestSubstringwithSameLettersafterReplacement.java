package neetcode.slidingwindow;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;

/*
* You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.*/
public class sw6LongestSubstringwithSameLettersafterReplacement {

  public static void main(String args[]) {
    System.out.println(bruteForce("AABABBA", 1));
    System.out.println(slide("AABABBA", 1));
  }

  public static int slide(String s, int k) {
    int max = 0;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);
      int maxCharCount = getMaxFromMap(map);
      while ((right - left + 1) - maxCharCount > k) {
        char leftChar = s.charAt(left);
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(s.charAt(left)) == 0) {
          map.remove(s.charAt(left));
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

  public static int getMaxFromMap(Map<Character, Integer> map) {
    int maxCount = 0;
    for (int count : map.values()) {
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }

  public static int bruteForce(String s, int k) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        int count = getMax(s, i, j);
        if ((j - i + 1) - count <= k) {
          max = Math.max(max, (j - i) + 1);
        }
      }
    }
    return max;
  }

  public static int getMax(String s, int left, int right) {
    int count = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (left <= right) {
      char c = s.charAt(left);
      map.put(c, map.getOrDefault(c, 0) + 1);
      count = Math.max(count, map.get(c));
      left++;
    }
    return count;
  }
}
