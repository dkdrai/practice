package grokking_the_coding_interview.SlidingWindow;

import java.util.*;

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
class LongestSubstringKDistinct {
    //findLength(araaci, 2)
    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char startChar = str.charAt(start);
                if (map.containsKey(startChar) && map.get(startChar) > 1) {
                    map.put(startChar, map.get(startChar) - 1);
                } else {
                    map.remove(startChar);
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println(LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println(LongestSubstringKDistinct.findLength("cbbebi", 3));
        System.out.println(LongestSubstringKDistinct.findLength("cbbebi", 10));
    }
}