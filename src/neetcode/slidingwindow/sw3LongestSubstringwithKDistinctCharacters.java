package neetcode.slidingwindow;
import java.util.HashMap;
import java.util.Map;

/*
Problem Statement#
Given a string, find the length of the longest substring in it with no more than K distinct characters.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
Example 4:

Input: String="cbbebi", K=10
Output: 6
Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
*/
public class sw3LongestSubstringwithKDistinctCharacters {

  public static void main(String args[]) {
    System.out.println(bruteForce("aabacbebebe", 15));
    System.out.println(slide("aabacbebebe", 15));

  }

  public static int slide(String s, int k) {
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);
      while (map.size() > k) {
        char leftChar = s.charAt(left);
        map.put(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);

        }
        left++;
      }
      if (map.size() <= k) {
        max = Math.max(max, right - left + 1);
      }
    }
    return max;
  }

  public static int bruteForce(String s, int k) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        int count = uniqCount(s, i, j);
        if (count <= k) {
          max = Math.max(max, j - i + 1);
        }
      }
    }
    return max;
  }

  public static int uniqCount(String s, int left, int right) {
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = left; i <= right; i++) {
      if (!map.containsKey(s.charAt(i) + "")) {
        count++;
      }
      map.put(s.charAt(i) + "", i);
    }
    return count;
  }

}
