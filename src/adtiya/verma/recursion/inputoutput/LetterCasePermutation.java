package adtiya.verma.recursion.inputoutput;

import java.util.Locale;

public class LetterCasePermutation {

  public static void main(String ar[]) {
    permutations("", "a1B2");
  }

  private static void permutations(String outPut, String input) {
    if (input.length() == 0) {
      System.out.println(outPut);
      return;
    }
    if (Character.isDigit(input.charAt(0))) {
      permutations(outPut.concat(String.valueOf(input.charAt(0))), input.substring(1));
    } else {
      permutations(outPut.concat(String.valueOf(input.charAt(0)).toLowerCase(Locale.ROOT)), input.substring(1));
      permutations(outPut.concat(String.valueOf(input.charAt(0)).toUpperCase(Locale.ROOT)), input.substring(1));
    }
  }

}
