package educative.solution.grokkingcodinginterviewpatterns.subsets;

import java.util.ArrayList;
import java.util.List;

//17. Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LetterCombinationsofaPhoneNumber {

  public static String[] map = {
      "0",
      "1",
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxyz"
  };

  public static void main(String args[]){
    System.out.println(letterCombinations("23"));
  }

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
      return result;
    }
    utils(digits, "", 0, result);
    return result;
  }

  public static void utils(String digits, String s, int index, List<String> result) {
    if (index == digits.length()) {
      result.add(s);
      return;
    }
    String key = map[digits.charAt(index) - '0'];
    for (int i = 0; i < key.length(); i++) {
      utils(digits, s + key.charAt(i), index + 1, result);
    }
  }
}
