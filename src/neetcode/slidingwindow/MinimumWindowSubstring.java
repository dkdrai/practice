package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//76. Minimum Window Substring
//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {

  public static void main(String arg[]) {
    System.out.println(minWindow("ab", "A"));
  }

  public static String minWindow(String str, String pat) {
    if (str == null || str.length() == 0 || pat == null || pat.length() == 0 | pat.length() > str.length()) {
      return "";
    }
    if(str.length() == pat.length())
    {if ( str.equals(pat)){
      return str;
    }else{
      return "";
    }}
    Map<Character, Integer> patternMap = new HashMap<>();
    for (int i = 0; i < pat.length(); i++) {
      char c = pat.charAt(i);
      patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
    }
    Map<Character, Integer> strMap = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int minLeft = 0;
    int left = 0;
    for (int right = 0; right < str.length(); right++) {
      char c = str.charAt(right);
      strMap.put(c, strMap.getOrDefault(c, 0) + 1);
      while (isPresent(strMap, patternMap)) {
        if (right - left + 1 < min) {
          min = right - left + 1;
          minLeft = left;
        }
        char leftChar = str.charAt(left);
        strMap.put(leftChar, strMap.getOrDefault(leftChar, 0) - 1);
        if (strMap.get(leftChar) == 0) {
          strMap.remove(leftChar);
        }
        left++;
      }
    }

    if(min!= Integer.MAX_VALUE) {
      return str.substring(minLeft, minLeft + min);
    }else{
      return "";
    }
  }

  public static boolean isPresent(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
    for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
      if (!smap.containsKey(entry.getKey()) && smap.get(entry.getKey()) != entry.getValue()) {
        return false;
      }
    }
    return true;
  }
}
