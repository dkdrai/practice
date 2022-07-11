package neetcode.twopointers;

public class TwoPointers {

  public static void main(String args[]) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
  }

  //125. dataid Palindrome
  //https://leetcode.com/problems/dataid-palindrome/description/
  public static boolean isPalindrome(String s) {
    s = s.toLowerCase();
    s = s.replaceAll("[^A-Za-z0-9]", "");
    s = s.replaceAll(" ", "");
    if(s.length() == 0){
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
