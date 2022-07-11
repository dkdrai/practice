package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

  public static void main(String ars[]) {
    System.out.println(characterReplacement("ABABAC", 3));
  }

  //424. Longest Repeating Character Replacement
  //https://leetcode.com/problems/longest-repeating-character-replacement/
  public static int characterReplacement(String s, int k) {
    int max = 0;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      Character c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);
      int maxCharCount = getMapMax(map);
      while ((right - left + 1) - maxCharCount > k) {
        Character leftChar = s.charAt(left);
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

  public static int getMapMax(Map<Character, Integer> map) {
    int max = 0;
    for (Integer key : map.values()) {
      if (key > max) {
        max = key;
      }
    }
    return max;
  }

}
