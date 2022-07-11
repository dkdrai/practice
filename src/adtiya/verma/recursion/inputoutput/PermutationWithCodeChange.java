package adtiya.verma.recursion.inputoutput;

import java.util.Locale;

public class PermutationWithCodeChange {

  public static void main(String ar[]) {
    permutations("", "abc");
  }

  private static void permutations(String outPut, String input) {
    if (input.length() == 0) {
      System.out.println(outPut);
      return;
    }
    permutations(outPut.concat(String.valueOf(input.charAt(0)).toUpperCase(Locale.ROOT)), input.substring(1));
    permutations(outPut.concat(String.valueOf(input.charAt(0))), input.substring(1));

  }

}
