package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String arg[]) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  //3. Longest Substring Without Repeating Characters
  //https://leetcode.com/problems/longest-substring-without-repeating-characters/

  public static int lengthOfLongestSubstring(String s) {
    int max = 0;
    Set<Character> map = new HashSet<>();
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      if (map.contains(s.charAt(right))) {
        map.remove(s.charAt(left));
        left++;
      } else {
        map.add(s.charAt(right));
        right++;
        max = Math.max(max, map.size());
      }
    }
    return max;
  }
}
