package grokking_the_coding_interview.SlidingWindow;

import java.util.*;

/*
String Anagrams (hard)#
Given a string and a pattern, find all anagrams of the pattern in the given string.

Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N!
N!
 permutations (or anagrams) of a string having N
N
 characters. For example, here are the six anagrams of the string “abc”:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
Example 2:

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
class StringAnagrams {

  public static void main(String ar[]){
    System.out.println(findStringAnagrams("abbcabc","abc"));
  }
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    int left = 0, match = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : pattern.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < str.length(); i++) {
      char endChar = str.charAt(i);
      if (map.containsKey(endChar)) {
        map.put(endChar, map.get(endChar) - 1);
        if (map.get(endChar) == 0)
          match++;
      }
      if (match == map.size())
        resultIndices.add(left);
      if (i >= pattern.length() - 1) {
        char startChar = str.charAt(left);
        left++;
        if (map.containsKey(startChar)) {
          if (map.get(startChar) == 0)
            match--;
          map.put(startChar, map.getOrDefault(startChar, 0) + 1);
        }
      }
    }
    return resultIndices;
  }
}