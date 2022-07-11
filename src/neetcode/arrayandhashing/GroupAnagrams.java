package neetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String args[]) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
    System.out.println("second");
    System.out.println(groupAnagramsNoSort(strs));
  }
  //49. Group Anagrams
  //https://leetcode.com/problems/group-anagrams/
  // check for the edge cases first like if the input is not null && input lengh is not 0 else return empty
  // use hashmap of string and list<string>
  // loop through the elements and sort the string and check if already present in map and add to the exisiting list

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> listOflist = new ArrayList<>();
    if (strs == null || strs.length == 0) {
      return listOflist;
    }
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(s);
    }

    return new ArrayList<>(map.values());
  }

  public static List<List<String>> groupAnagramsNoSort(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] ca = new char[26];
      for (char c : s.toCharArray()) {
        ca[c - 'a']++;
      }
      String keyStr = String.valueOf(ca);
      if (!map.containsKey(keyStr)) {
        map.put(keyStr, new ArrayList<>());
      }
      map.get(keyStr).add(s);
    }
    return new ArrayList<>(map.values());
  }
}
