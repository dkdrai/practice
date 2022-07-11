package neetcode.slidingwindow;

public class PermutaionInString {

  //567. Permutation in String
  //https://leetcode.com/problems/permutation-in-string/
  public static void main(String arg[]) {
    String s = "abc";
    String s1 = "dbdca";
    System.out.println(checkInclusion1(s, s1));
  }

  public static boolean checkInclusion1(String s1, String s2) {
    int len1 = s1.length(), len2 = s2.length();
    if (len1 > len2) return false;

    int[] count = new int[26];
    for (int i = 0; i < len1; i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }
    if (allZero(count)) return true;

    for (int i = len1; i < len2; i++) {
      count[s2.charAt(i) - 'a']--;
      count[s2.charAt(i - len1) - 'a']++;
      if (allZero(count)) return true;
    }

    return false;
  }

  private   static boolean allZero(int[] count) {
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) return false;
    }
    return true;
  }
}
