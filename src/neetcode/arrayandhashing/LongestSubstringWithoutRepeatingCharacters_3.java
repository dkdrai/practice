package neetcode.arrayandhashing;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {

  public static void main(String ar[]) {
    String s = "abcbacde";
    System.out.println(getLength(s));
  }

  public static int getLength(String s) {
    int left = 0;
    int right = 0;
    int max = 0;
    HashSet<String> set = new HashSet<>();
    while (right < s.length()) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right) + "");
        max = Math.max(set.size(), max);
        right++;
      } else {
        set.remove(s.charAt(left) + "");
        left++;
      }
    }
    return max;
  }

}

