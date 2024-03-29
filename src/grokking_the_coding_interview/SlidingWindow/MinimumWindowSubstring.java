package grokking_the_coding_interview.SlidingWindow;

import java.util.*;

/*
Smallest Window containing Substring (hard)#
Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.

Example 1:

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"
Example 2:

Input: String="aabdec", Pattern="abac"
Output: "aabdec"
Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
Example 3:

Input: String="abdbca", Pattern="abc"
Output: "bca"
Explanation: The smallest substring having all characters of the pattern is "bca".
Example 4:

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
 */
class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charFrequencyMap.containsKey(rightChar)) {
        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
        if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
          matched++;
      }

      // shrink the window if we can, finish as soon as we remove a matched character
      while (matched == pattern.length()) {
        if (minLength > windowEnd - windowStart + 1) {
          minLength = windowEnd - windowStart + 1;
          subStrStart = windowStart;
        }

        char leftChar = str.charAt(windowStart++);
        if (charFrequencyMap.containsKey(leftChar)) {
          // note that we could have redundant matching characters, therefore we'll decrement the
          // matched count only when a useful occurrence of a matched character is going out of the window
          if (charFrequencyMap.get(leftChar) == 0)
            matched--;
          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
        }
      }
    }

    return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
  }

  public static void main(String[] args) {
    System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
    System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abac"));
    System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
    System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
  }
}