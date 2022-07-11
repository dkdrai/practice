package neetcode.slidingwindow;
import java.util.HashMap;
import java.util.Map;

/* 3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class sw5longestsubstringwithdistinctcharacters {

  public static void main(String args[]) {
    System.out.println(bruteForce("findlongestsubstring"));
    System.out.println(slide("findlongestsubstring"));
  }

  //pawwkeabw
  public static int slide(String s) {
    int max = 0;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      while (map.containsKey(c)) {
        map.remove(s.charAt(left));
        left++;
      }
      map.put(s.charAt(right), 1);
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

  public static int bruteForce(String s) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (uniqCount(s, i, j)) {
          max = Math.max(max, j - i + 1);
        }
      }
    }
    return max;
  }

  public static boolean uniqCount(String s, int left, int right) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = left; i <= right; i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        return false;
      } else {
        map.put(s.charAt(i), i);
      }
    }
    return true;
  }
}
